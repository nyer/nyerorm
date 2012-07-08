package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.util.UserSession;

public class ListEndedLeagueAction extends BaseAction {
	private JoinedLeagueService joinedLeagueService;
	
	
	public JoinedLeagueService getJoinedLeagueService() {
		return joinedLeagueService;
	}


	public void setJoinedLeagueService(JoinedLeagueService joinedLeagueService) {
		this.joinedLeagueService = joinedLeagueService;
	}


	@Override
	public String execute() throws Exception {
		User user = UserSession.getSessionUser();
		List<JoinedLeague> joinedLeagues = this.joinedLeagueService.getHasEndedJoinedLeagueByUserId(user.getId());
		for(JoinedLeague joinedLeague:joinedLeagues){
			League league = this.joinedLeagueService.get(League.class, joinedLeague.getLeagueId());
			joinedLeague.setLeague(league);
		}
		setRequestAttr("joinedLeagues", joinedLeagues);
		return SUCCESS;
	}
}
