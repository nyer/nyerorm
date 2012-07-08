package org.nyer.copyright.guessfb.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.nyer.copyright.guessfb.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected BaseDao dao;

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    public Object save(Object obj) {
        obj = dao.save(obj);
        return obj;
    }

    public <T> T get(Class<T> entityClass, Serializable id) {
        return this.dao.get(entityClass, id);
    }

    public <T> void delete(T obj) {
        this.dao.delete(obj);
    }
    
    public <T> void delete(Class<T> entityClass,Serializable id){
        this.dao.delete(id, entityClass);
    }

    public <T> void update(T obj) {
        this.dao.update(obj);
    }

    public <T> T queryForObject(String sql, Object[] params, Class<T> clazz) {
        return this.dao.queryForObject(sql, params, clazz);
    }

    public <T> List<T> queryForObjectList(String sql, Object[] params, Class<T> clazz) {
        return this.dao.queryForObjectList(sql, params, clazz);
    }
    
    public <T> List<T> queryForObjectList(String sql,Class<T> clazz){
        return this.dao.queryForObjectList(sql, clazz);
    }

    public List<Map<String, Object>> queryForMapList(String sql, Object[] params) {
        return this.dao.queryForMapList(sql, params);
    }

    public Map<String, Object> queryForMap(String sql, Object[] params) {
        return this.dao.queryForMap(sql, params);
    }

    public Map<String, Object> queryForMap(String sql) {
        return this.dao.queryForMap(sql);
    }
    
    public <T> List<T> queryListFromExample(T entity){
        return this.dao.queryFromExample(entity);
    }
    
    public <T> T queryFromExample(T entity){
        List<T> list = queryListFromExampleWithLimit(entity,0,1);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public Double queryForDouble(String sql,Object[] params){
    	return this.dao.queryForDouble(sql, params);
    }
    
    public <T> List<T> queryListFromExampleWithLimit(T entity,int from,int count){
        return this.dao.queryFromExampleWithLimit(entity, from, count);
    }
    
    public void execute(String sql,Object[] params){
    	this.dao.execute(sql, params);
    }
    public void execute(String sql){
    	this.dao.execute(sql);
    }
}
