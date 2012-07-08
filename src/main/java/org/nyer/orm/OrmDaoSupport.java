package org.nyer.orm;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class OrmDaoSupport {
    private static  Logger log = Logger.getLogger(OrmDaoSupport.class);
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public <T> T update(T obj){
        ModelDescriber md = OrmContext.queryMDByModel(obj.getClass());
        String sql = md.bornUpdateSQL(obj);
        logSql(sql);
           jdbcTemplate.execute(sql);
        return obj;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T queryForObject(String sql,Object[] params,Class<T> clazz){
    	logSql(sql);
        List<T> objs = this.queryForObjectList(sql, params, clazz);
        if(objs.size() > 0){
        	return objs.get(0);
        }else{
        	return null;
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    public <T> List<T> queryForObjectList(String sql,Object[] params,Class<T> clazz){
    	logSql(sql);
        List<Map<String,Object>> maps = this.jdbcTemplate.queryForList(sql, params);
        ModelDescriber md = getMD(clazz);
        List<Object> list = md.converMapsToObjs(maps);
        return (List<T>)list;
    }
    
    public Double queryForDouble(String sql,Object[] params){
    	logSql(sql);
    	Double result  = null;
    	try{
        	Map<String,Object> map = this.jdbcTemplate.queryForMap(sql, params);
        	if(map.size() > 0){
        		result = (Double) map.values().iterator().next();
        	}
    	}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
    	return result;
    }
    
    
    @SuppressWarnings("unchecked")
    public <T> List<T> queryForObjectList(String sql,Class<T> clazz){
    	logSql(sql);
        List<Map<String,Object>> maps = this.jdbcTemplate.queryForList(sql);
        ModelDescriber md = getMD(clazz);
        List<Object> list = md.converMapsToObjs(maps);
        return (List<T>)list;
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> queryForMapList(String sql,Object[] params){
    	logSql(sql);
        List<Map<String,Object>> maps = this.jdbcTemplate.queryForList(sql, params);
        return maps;
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> queryFromExample(T example){
        ModelDescriber md = getMD(example.getClass());
        String sql = md.bornExampleSQL(example);
        logSql(sql);
        List<Map<String,Object>> maps = this.jdbcTemplate.queryForList(sql);
        List<Object> list = md.converMapsToObjs(maps);
        return (List<T>) list;
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> queryFromExampleWithLimit(T example,int from,int count){
        ModelDescriber md = getMD(example.getClass());
        String sql = md.bornExampleSQLWithLimit(example, from, count);
        logSql(sql);
        List<Map<String,Object>> maps = this.jdbcTemplate.queryForList(sql);
        List<Object> list = md.converMapsToObjs(maps);
        return (List<T>) list;
    }
    
    @SuppressWarnings("unchecked")
    public Map<String,Object> queryForMap(String sql,Object[] params){
    	logSql(sql);
    	Map<String,Object> map = null;
    	try{
    		map = this.jdbcTemplate.queryForMap(sql, params);
    	}catch(EmptyResultDataAccessException e){
    		//keep silent
    	}
        return map;
    }
    
    @SuppressWarnings("unchecked")
    public Map<String,Object> queryForMap(String sql){
    	logSql(sql);
    	Map<String,Object> map = null;
    	try{
    		map = this.jdbcTemplate.queryForMap(sql);
    	}catch(EmptyResultDataAccessException e){
    		//keep silent
    	}
        return map;
    } 
    
    public Object save(Object obj){
        ModelDescriber md = getMD(obj.getClass());
        String sql = md.bornInsertSQL(obj);
        logSql(sql);
        md.setId(obj,execAndGenKey(sql));
        return obj;
    }
    
    public long execAndGenKey(final String sql){
    	KeyHolder key = new GeneratedKeyHolder();
    	jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement state = con.prepareStatement(sql);
				return state;
			}
		}, key);
    	return key.getKey().longValue();
    }
    
    public long execAndGenKey(final String sql,final Object[] params){
    	KeyHolder key = new GeneratedKeyHolder();
    	jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement state = con.prepareStatement(sql);
				ArgPreparedStatementSetter pss = new ArgPreparedStatementSetter(params);
				pss.setValues(state);
				return state;
			}
		}, key);
    	return key.getKey().longValue();
    }
    
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> entityClass,Serializable id){
        ModelDescriber md = getMD(entityClass);
        String sql = md.bornSelectSQLWithId(id);
        logSql(sql);
        Object obj = null;
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map = this.jdbcTemplate.queryForMap(sql);
            obj = md.convertMapToObject(map);
        }catch(EmptyResultDataAccessException e){
    		//keep silent
    	}
        return (T) obj;
    }
    
    public void delete(Serializable id,Class<?> entityClass){
        try {
            Object obj = entityClass.newInstance();
            ModelDescriber md = getMD(entityClass);
            md.setObjectId(obj, id);
            delete(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Object obj){
        ModelDescriber md = getMD(obj.getClass());
        String sql = md.bornDeleteSQL(obj);
        logSql(sql);
            jdbcTemplate.execute(sql);   
        
    }
    
    private ModelDescriber getMD(Class<?> entityClass){
        return OrmContext.queryMDByModel(entityClass);
    }
    
    private void logSql(String sql){
    	 if(log.isInfoEnabled()){
    		 log.info(sql);
    	 }
    }
    
    
    public void execute(String sql,Object[] params){
    	this.jdbcTemplate.update(sql, params);
    }
    
    public void execute(String sql){
    	this.jdbcTemplate.execute(sql);
    }
}
