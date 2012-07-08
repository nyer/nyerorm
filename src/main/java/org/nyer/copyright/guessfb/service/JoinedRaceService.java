package org.nyer.copyright.guessfb.service;

import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedRace;

public class JoinedRaceService extends BaseService{
    public List<JoinedRace> getJoinedRaceListByUserIdWithLimit(Long userId,int from,int count){
        String sql = "select * from joinedrace where userid = ? order by time limit ?,?";
        return this.queryForObjectList(sql, new Object[]{userId,from,count}, JoinedRace.class);
    }
    
    public List<JoinedRace> getJoinedRaceListByRaceIdWithLimit(Long raceId,int from ,int count){
        String sql = "select * from joinedrace where raceid = ? order by time limit ?,?";
        return this.queryForObjectList(sql, new Object[]{raceId,from,count}, JoinedRace.class);
    }
    
    public JoinedRace getJoinedRaceByRaceIdAndUserId(Long raceId,Long userId){
    	String sql = "select * from joinedrace where raceid = ? and userid = ? ";
    	return this.queryForObject(sql, new Object[]{raceId,userId},JoinedRace.class);
    }
    
    public List<JoinedRace> queryJoinedRacesByLeagueIdAndUserId(Long leagueId,Long userId){
    	String sql = "select * from joinedrace where leagueid = ? and userid = ?";
    	return this.queryForObjectList(sql, new Object[]{leagueId,userId}, JoinedRace.class);
    }
    
    public List<JoinedRace> queryJoinedRaceByRaceId(Long raceId){
    	String sql = "select * from joinedrace where raceid = ? order by point desc,userid";
    	return this.queryForObjectList(sql, new Object[]{raceId}, JoinedRace.class);
    }
}
