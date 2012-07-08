package org.nyer.orm;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.MarkNotColumn;
import org.nyer.orm.annotation.NotUpdate;
import org.nyer.orm.exception.IdIsNull;
import org.nyer.orm.exception.UnknowModelException;

public class ModelDescriber {
    private Class<?> model;
    private String tableName;
    private String idPolicy;
    private List<String> idColumns = new ArrayList<String>();
    private List<String> columns = new ArrayList<String>();
    private List<String> notUpdateColumns = new ArrayList<String>();
    
    private Map<String,Field> columnMapField = new HashMap<String, Field>();//c
    private Map<String,Method> columnMapSetMethod = new HashMap<String, Method>();//column到field转换方法集
    private Map<String,Method> columnMapGetMethod = new HashMap<String, Method>();// 
    
    public String getTableName(){
        return tableName;
    }
    
    public Class<?> getModel(){
        return model;
    }
    
    public ModelDescriber(Class<?> clazz,String tableName){
        this.tableName = tableName;
        this.model = clazz;
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            int modifier = field.getModifiers();
            if(Modifier.isPrivate(modifier) && !Modifier.isStatic(modifier)){
                try {
                    if(field.isAnnotationPresent(MarkNotColumn.class)){//the field has no column to map
                        continue;
                    }
                    String columnName = field.getName();
                    if(field.isAnnotationPresent(Column.class)){
                        Column column = field.getAnnotation(Column.class);
                        columnName = column.column().toLowerCase();
                    }else if(field.isAnnotationPresent(Id.class)){
                        Id id = field.getAnnotation(Id.class);
                        columnName = id.value().toLowerCase();
                        idColumns.add(columnName);
                        
                       idPolicy = id.idPolicy();//主键生成策略
                    }
                    
                    if(field.isAnnotationPresent(NotUpdate.class)){//not update column
                        notUpdateColumns.add(columnName);
                    }
                    
                    columnName = columnName.toLowerCase();
                    
                    columns.add(columnName);
                    columnMapField.put(columnName, field);
                    
                    Method getmethod = clazz.getDeclaredMethod(
                        "get" + StringUtils.capitalize(field.getName()));
                    columnMapGetMethod.put(columnName, getmethod);
                    
                    Method setmethod = clazz.getDeclaredMethod(
                        "set" + StringUtils.capitalize(field.getName()), field.getType());
                    columnMapSetMethod.put(columnName, setmethod);
                    
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 生成sql更新语句
     * @param obj
     * @return
     */
    public String bornUpdateSQL(Object obj){
        checkModel(obj);
        StringBuffer buf = new StringBuffer("UPDATE ");
        this.appendSetAttr(buf, obj);
        
        this.appendWhereAttr(buf, obj);
        
        return buf.toString();
        
    }
    
    /**
     * 生成sql插入语句
     * @param obj
     * @return
     */
    public String bornInsertSQL(Object obj){
        checkModel(obj);
        Map<String,Object> map = new HashMap<String, Object>();
        
        for(String key:columns){
            if(idColumns.contains(key))
                continue;
            Method method = columnMapGetMethod.get(key);
            Object result = invokeGetMethod(method, obj);
            if(result != null){
                map.put(key, result);
            }
        }
        StringBuffer buf = new StringBuffer("INSERT INTO ");
        buf.append(tableName).append("(");
        boolean isFirst = true;
        for(String key:map.keySet()){
            if(isFirst){
                buf.append(key);
                isFirst = false;
            }else{
                buf.append(",").append(key);
            }
        }
        buf.append(") VALUES(");
        isFirst = true;
        for(String key:map.keySet()){
            Object result = map.get(key);
            if(result == null)
                continue;
            if(isFirst){
                buf.append(convertType(result));
                isFirst=false;
            }else{
                buf.append(",").append(convertType(result));
            }
        }
        buf.append(")");
        return buf.toString();
    }
    
    /**
     * 生成删除语句
     * @param obj
     * @return
     */
    public String bornDeleteSQL(Object obj){
        checkModel(obj);
        StringBuffer buf = new StringBuffer("DELETE from ");
        buf.append(tableName);
        appendWhereAttr(buf, obj);
        return buf.toString();
    }
    
    public String bornExampleSQL(Object obj){
        checkModel(obj);
        StringBuffer buf = new StringBuffer("SELECT * FROM ");
        buf.append(this.tableName).append(" WHERE 1=1 ");
        for(String column:columns){
            Method getMethod = columnMapGetMethod.get(column);
            String pair = createAssignPair(getMethod, column, obj);
            if(pair != ""){
                buf.append(" and ").append(pair);
            }
        }
        
        return buf.toString();
    }
    
    public String bornExampleSQLWithLimit(Object obj,int from,int count){
        String sql = this.bornExampleSQL(obj);
        sql += " limit " + from + ", " + count;
        return sql;
    }
    
    public void setObjectId(Object obj,Serializable id){
        checkModel(obj);
        String key = idColumns.get(0);
        Method method = columnMapSetMethod.get(key);
        invokeSetMethod(method, obj, id);
    }
    public Object convertMapToObject(Map<String,Object> map){
        Object obj = null;
        try {
            obj = model.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for(String key:map.keySet()){
            key = key.toLowerCase();
            Method setMethod = columnMapSetMethod.get(key);
            if(setMethod != null){//not everyl column is mapped to a field
                invokeSetMethod(setMethod, obj, map.get(key));
            }
        }
        return obj;
    }
    
    
    public List<Object> converMapsToObjs(List<Map<String,Object>> maps){
        List<Object> objs= new ArrayList<Object>();
        for(Map<String,Object> map:maps){
            objs.add(convertMapToObject(map));
        }
        return objs;
    }
    
    public String bornSelectSQLWithCompositeKey(Object obj){
        StringBuffer buf = new StringBuffer("SELECT * FROM ");
        buf.append(tableName).append(" ");
        appendWhereAttr(buf, obj);
        return buf.toString();
    }
    
    public String bornSelectSQLWithId(Serializable id){
        StringBuffer buf = new StringBuffer("SELECT * FROM ");
        buf.append(tableName).append(" ");
        buf.append(" WHERE ");
        buf.append(idColumns.get(0)).append("=");
        buf.append(id);
        return buf.toString();
    }
    
    private void checkModel(Object obj){
        if(obj.getClass() != this.model){
            throw  new UnknowModelException();
          }
    }
    private void appendSetAttr(StringBuffer buf,Object obj){
        buf.append(tableName).append(" SET ");
        boolean isAppend = false;
        for(String key:columns){
            if(idColumns.contains(key))
                continue;
            
            if(notUpdateColumns.contains(key)){
                continue;
            }
            
            Method getMethod = columnMapGetMethod.get(key);
            String frag = this.createAssignPair(getMethod, key, obj);
            if(frag != ""){
                buf.append(frag);
                buf.append(",");
            }
            isAppend = true;
        }
        
        if(isAppend){
            buf.deleteCharAt(buf.length() -1);
        }
    }
    
    private void appendWhereAttr(StringBuffer buf,Object obj){
        buf.append(" WHERE 1=1 ");
        boolean appended = false;
        for(String id:idColumns){
            Method getMethod = columnMapGetMethod.get(id);
            String pair = this.createAssignPair(getMethod, id, obj);
            if(pair != ""){
                buf.append(" and ");
                buf.append(pair);
                appended = true;
            }
        }
        if(appended == false){
            throw new IdIsNull("object's id fields is null");
        }
    }
    
    private String createAssignPair(Method method,String key,Object obj ){
        StringBuffer buf = new StringBuffer();
        Object result = invokeGetMethod(method,obj);
        if(result == null)
            return "";
        
        buf.append(" ").append(key).append("= ");
        buf.append(convertType(result));
        buf.append(" ");
        return buf.toString();
    }
    
    private Object convertType(Object obj){
        if(obj instanceof Date){
            Date date = (Date)obj;
            String dateStr =  (DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
            return "'" + dateStr + "'";
        }
        if(obj.getClass() == String.class){
            return "'" + obj + "'";
        }
        return obj;
    }
    
    
    public void setId(Object obj,long id){
        if(idPolicy.equals(IdPolicy.AUTO)){
            String idColumn = idColumns.get(0);//自增主键不能为复合主题
            invokeSetMethod( columnMapSetMethod.get(idColumn), obj, id);
        }
    }
    
    private Object invokeGetMethod(Method method,Object obj){
        Object result = null;
        try{
            result = method.invoke(obj);
        }catch (Exception e) {
           e.printStackTrace();
        }
        return result;
    }
    
    private void invokeSetMethod(Method method,Object obj,Object param){
        try{
            method.invoke(obj, param);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
