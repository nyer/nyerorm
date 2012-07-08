package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.service.RaceService;

public class ViewUnaddedLeagueAction extends BaseAction {
	private long leagueId;
	private RaceService raceService;
	public long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}
	
	
	public RaceService getRaceService() {
		return raceService;
	}
	public void setRaceService(RaceService raceService) {
		this.raceService = raceService;
	}
	public String execute(){
		List<Race> races = this.raceService.getRaceListByLeagueId(leagueId);
		setRequestAttr("races", races);
		return SUCCESS;
	}
}
