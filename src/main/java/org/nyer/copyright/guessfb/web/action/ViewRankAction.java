package org.nyer.copyright.guessfb.web.action;

import java.util.ArrayList;
import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.model.LeagueRankHead;
import org.nyer.copyright.guessfb.model.LeagueRankItem;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.service.LeagueRankService;



public class ViewRankAction extends BaseAction {
	private Long leagueId;
	private JoinedLeagueService joinedLeagueService;
	private LeagueRankService leagueRankService;

	public JoinedLeagueService getJoinedLeagueService() {
		return joinedLeagueService;
	}

	public void setJoinedLeagueService(JoinedLeagueService joinedLeagueService) {
		this.joinedLeagueService = joinedLeagueService;
	}
	

	public LeagueRankService getLeagueRankService() {
		return leagueRankService;
	}

	public void setLeagueRankService(LeagueRankService leagueRankService) {
		this.leagueRankService = leagueRankService;
	}

	public Long getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	@Override
	public String execute() throws Exception {
		League league = this.joinedLeagueService.get(League.class, leagueId);
		setRequestAttr("league", league);
		LeagueRankHead head = this.leagueRankService.getLastedlLeagueRank(leagueId);
		List<LeagueRankItem> items;
		if(head != null){
			 items = this.leagueRankService.getRankItems(head.getRankHeadId());
			 for(LeagueRankItem item:items){
				 User user = this.joinedLeagueService.get(User.class,item.getUserId());
				 item.setUser(user);
			 }
			 setRequestAttr("leagueRank", head);
		}else{//first rank,no previous rank data exists now.
			items = new ArrayList<LeagueRankItem>();
			List<JoinedLeague> rankedJoinedLeagues = this.joinedLeagueService.getJoinedLeagueRank(leagueId);
			for(JoinedLeague jl:rankedJoinedLeagues){
				User user = this.joinedLeagueService.get(User.class, jl.getUserId());
				LeagueRankItem item = new LeagueRankItem();
				item.setUser(user);
				item.setScore(0d);
				items.add(item);
			}
		}
		setRequestAttr("leagueRankItems", items);
		return SUCCESS;
	}
}
