package org.nyer.copyright.guessfb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.League;
import org.nyer.orm.util.DateUtils;

public class LeagueService extends BaseService{
    public List<League> getLeaguesWithLimit(int from,int count){
        String sql = "select * from league order by start  desc limit ?,?";
        return this.queryForObjectList(sql, new Object[]{from,count}, League.class);
    }
    
    public List<League> getCouldAttendLeagueByUserId(Long userId){
    	String currentTimeStr = DateUtils.getDBCurrentTime();
    	String sql = "SELECT * FROM league l where end > ? and not exists(" +
    			"SELECT * FROM joinedleague jl where jl.userId = ? and jl.leagueid = l.idLeague )";
    	return this.queryForObjectList(sql, new Object[]{currentTimeStr,userId}, League.class);
    }
    
    public void deleteLeague(Long leagueId){
    	String sql = "delete from joinedrace  where leagueid = ?";
    	this.dao.execute(sql, new Object[]{leagueId});
    	
    	sql = "delete from race where league = ?";
    	this.dao.execute(sql, new Object[]{leagueId});
    	
    	sql = "delete from joinedleague where leagueid = ?";
    	this.dao.execute(sql, new Object[]{leagueId});
    	
    	this.dao.delete(leagueId, League.class);
    		
    }
    
}
