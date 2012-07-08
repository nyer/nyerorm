package org.nyer.copyright.guessfb.service;

import java.util.List;

import org.nyer.copyright.guessfb.model.LeagueRankHead;
import org.nyer.copyright.guessfb.model.LeagueRankItem;

public class LeagueRankService extends BaseService {
	public LeagueRankItem getLatestLeagueRankItem(long userId,long leagueId){
		String sql = "select * from leaguerankitem item where item.userid = ? and item.leagueid = ? order by item.rankitemid";
		return this.queryForObject(sql, new Object[]{userId,leagueId}, LeagueRankItem.class);
	}
	
	public List<LeagueRankItem> getLeagueRankItemsByRankHeadId(long rankHeadId){
		String sql = "select * from leaguerankitem item where item.rankheadid = ? order by rank ";
		return this.queryForObjectList(sql, new Object[]{rankHeadId}, LeagueRankItem.class);
	}
	
	public LeagueRankHead getLastedlLeagueRank(long leagueId){
		String sql = "select * from leaguerankhead head where head.leagueid = ? order by createtime desc";
		return  this.queryForObject(sql, new Object[]{leagueId}, LeagueRankHead.class);
	}
	
	public List<LeagueRankItem> getRankItems(long leagueRankId){
		String sql = "select * from leaguerankitem where rankheadid = ?";
		return this.queryForObjectList(sql, new Object[]{leagueRankId}, LeagueRankItem.class);
	}
}
