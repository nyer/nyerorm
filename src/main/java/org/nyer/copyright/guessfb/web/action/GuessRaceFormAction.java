package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.RaceService;

public class GuessRaceFormAction extends BaseAction {
	private RaceService raceService;
	private Long raceId;

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
	
	@Override
	public String execute() throws Exception {
		Race race = this.raceService.get(Race.class, raceId);
		setRequestAttr("race", race);
		return SUCCESS;
	}
}
