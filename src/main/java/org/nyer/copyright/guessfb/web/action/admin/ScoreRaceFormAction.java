package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.RaceService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class ScoreRaceFormAction extends BaseAction{
	private Long raceId;
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
		setRequestAttr("race", race);
		return SUCCESS;
	}
}
