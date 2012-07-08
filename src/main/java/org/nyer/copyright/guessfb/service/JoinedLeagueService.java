package org.nyer.copyright.guessfb.service;

import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.orm.util.DateUtils;

public class JoinedLeagueService extends BaseService{
    public List<JoinedLeague> getJoiningLeagueByUserIdWithLimit(Long userId,int from,int count){
    	String timenow = DateUtils.getDBCurrentTime();
        String sql = "select * from joinedleague where userId = ?  and exists( select * from league  where joinedleague.leagueid = league.idLeague and league.end >= ?) order by jointime limit ?,?";
        return this.queryForObjectList(sql, new Object[]{userId,timenow,from,count}, JoinedLeague.class);
    }
    
    public List<JoinedLeague> getJoinedLeagueByLeagueIdWithLimit(Long leagueId,int from,int count){
        String sql = "select * from joinedleague where leagueid = ? order by jointime limit ?,?";
        return this.queryForObjectList(sql, new Object[]{leagueId,from,count}, JoinedLeague.class);
    }
    
    public List<JoinedLeague> getAttendingJoinedLeagueByUserId(Long userId){
    	String currentTimeStr =DateUtils.getDBCurrentTime();
    	String sql = "SELECT * FROM joinedleague where end > ? and userId = ?";
    	return this.queryForObjectList(sql, new Object[]{currentTimeStr,userId}, JoinedLeague.class);
    }
    
    public List<JoinedLeague> getHasEndedJoinedLeagueByUserId(Long userId){
    	String currentTime = DateUtils.getDBCurrentTime();
    	String sql = "select * from joinedleague where userId = ? and exists(" +
    			"select  * from league l  where l.idLeague = joinedleague.leagueid and  l.end < ?)";
    	return this.queryForObjectList(sql, new Object[]{userId,currentTime}, JoinedLeague.class);
    }
    
    public List<JoinedLeague> getJoinedLeagueRank(Long leagueId){
    	String sql = "select * from joinedleague where leagueid = ? order by score desc,userid ";
    	return this.queryForObjectList(sql, new Object[]{leagueId}, JoinedLeague.class);
    }
    
    public Double getLowestJoinedLeagueScore(Long leagueId){
    	String sql = "select min(score) from joinedleague where leagueid = ?";
    	Double d = this.dao.queryForDouble(sql, new Object[]{leagueId});
    	if(d == null){
    		d = 0d;
    	}
    	return d;
    }
    
    public List<JoinedLeague> getJoinedLeagueByLeagueId(Long leagueId){
    	String sql = "select * from joinedleague where leagueid = ?";
    	return this.dao.queryForObjectList(sql, new Object[]{leagueId}, JoinedLeague.class);
    }
    
    public List<JoinedLeague> getJoinedLeagueByLeagueIdOrderByPointDesc(Long leagueId){
    	String sql = "select * from joinedleague where leagueid = ? order by score desc";
    	return this.dao.queryForObjectList(sql, new Object[]{leagueId}, JoinedLeague.class);
    }
    
    public JoinedLeague getJoinedLeagueByUserIdAndLeagueId(long userId,long leagueId){
    	String sql = "select * from joinedleague where  userid=? and leagueid = ?";
    	return this.dao.queryForObject(sql, new Object[]{userId,leagueId}, JoinedLeague.class);
    }
}
