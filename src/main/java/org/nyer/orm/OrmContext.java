package org.nyer.orm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nyer.orm.annotation.Table;

public class OrmContext {
    static List<Class<?>> modelClazzs;
    static  Map<String,ModelDescriber> tableMapModelDescribe = new HashMap<String, ModelDescriber>();
    static  Map<Class<?>,ModelDescriber> modelMapModelDescribe = new HashMap<Class<?>, ModelDescriber>();
    
    private  OrmContext(){
    }
    
    public static void buildOrmContext(List<Class<?>> models){
            modelClazzs = models;
            initOrm();
    }
    
    private static void initOrm(){
        for(Class<?> clazz:modelClazzs){
            String tableName = clazz.getSimpleName();
            if(clazz.isAnnotationPresent(Table.class)){
                Table t = clazz.getAnnotation(Table.class);
                tableName = t.value();
            }
            ModelDescriber md = new ModelDescriber(clazz, tableName);
            tableMapModelDescribe.put(tableName, md);
            modelMapModelDescribe.put(clazz, md);
        }
    }
    
    public static ModelDescriber queryMDByTableName(String tableName){
        return tableMapModelDescribe.get(tableName);
    }
    
    public static ModelDescriber queryMDByModel(Class<?> clazz){
        return modelMapModelDescribe.get(clazz);
    }
}
