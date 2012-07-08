package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class AddRaceFormAction extends BaseAction{
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
	
	public String execute(){
		League league = this.leagueService.get(League.class, leagueId);
		setRequestAttr("league", league);
		return SUCCESS;
	}
}
