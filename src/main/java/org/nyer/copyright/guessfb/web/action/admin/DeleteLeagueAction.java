package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class DeleteLeagueAction extends BaseAction {
	private Long leagueId;
	private LeagueService leagueService;
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	public LeagueService getLeagueService() {
		return leagueService;
	}
	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	@Override
	public String execute() throws Exception {
		this.leagueService.deleteLeague(leagueId);
		return SUCCESS;
	}
}
