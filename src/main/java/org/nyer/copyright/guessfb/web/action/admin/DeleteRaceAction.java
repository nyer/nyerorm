package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.RaceService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class DeleteRaceAction extends BaseAction {
	private Long raceId;
	private Long leagueId;
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	private RaceService raceService;
	public Long getRaceId() {
		return raceId;
	}
	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}
	public RaceService getRaceService() {
		return raceService;
	}
	public void setRaceService(RaceService raceService) {
		this.raceService = raceService;
	}
	public String execute(){
		Race race = this.raceService.get(Race.class, raceId);
		this.leagueId = race.getLeague();
		this.raceService.deleteRace(raceId);
		return SUCCESS;
	}
}
