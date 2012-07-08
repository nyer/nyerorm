package org.nyer.copyright.guessfb.web.action.admin;

import java.util.List;

import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.RaceService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class ListRaceAction extends BaseAction{
	private Long leagueId;
	private RaceService raceService;
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	public RaceService getRaceService() {
		return raceService;
	}
	public void setRaceService(RaceService raceService) {
		this.raceService = raceService;
	}
	public String execute(){
		League league = this.raceService.get(League.class, leagueId);
		setRequestAttr("league", league);
		
		List<Race> races = this.raceService.getRaceListByLeagueId(leagueId);
		setRequestAttr("races", races);
		return SUCCESS;
	}
}
