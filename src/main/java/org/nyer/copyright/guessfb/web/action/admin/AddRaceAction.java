package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.RaceService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class AddRaceAction extends BaseAction {
	private Race race;
	private Long leagueId;
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}

	private RaceService raceService;
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public RaceService getRaceService() {
		return raceService;
	}
	public void setRaceService(RaceService raceService) {
		this.raceService = raceService;
	}
	
	public String execute(){
		race.setIdRace(null);
		this.raceService.save(race);
		leagueId = race.getLeague();
		return SUCCESS;
	}
}
