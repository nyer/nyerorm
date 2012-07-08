package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.util.UserSession;


public class ListUnaddedLeagueAction extends BaseAction {
	private LeagueService leagueService;

	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	@Override
	public String execute(){
		User user = UserSession.getSessionUser();
		List<League> leagues = this.leagueService.getCouldAttendLeagueByUserId(user.getId());
		setRequestAttr("leagues", leagues);
		return SUCCESS;
	}
}
