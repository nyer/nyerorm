package org.nyer.copyright.guessfb.service;

import java.util.List;

import org.nyer.copyright.guessfb.model.Race;

public class RaceService extends BaseService{
    public List<Race> getRaceListWithLimit(int from,int count){
        String sql = "select * from race order by start  limit ?,?";
        return this.queryForObjectList(sql, new Object[]{from,count}, Race.class);
    }
    
    public List<Race> getRaceListByLeagueId(Long leagueId){
    	String sql = "select * from race where league = ? order by start ";
    	return this.queryForObjectList(sql, new Object[]{leagueId}, Race.class);
    }
    
    public void deleteRace(Long raceId){
    	String sql = "delete from joinedrace  where raceid = ?";
    	this.dao.execute(sql, new Object[]{raceId});
    	
    	sql = "delete from race where idrace = ?";
    	this.dao.execute(sql, new Object[]{raceId});
    }
}
