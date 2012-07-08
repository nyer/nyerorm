package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedRace;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.JoinedRaceService;

public class RaceRankAction extends BaseAction{
	private Long raceId;
	private JoinedRaceService  joinedRaceService;
	public Long getRaceId() {
		return raceId;
	}
	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}
	public JoinedRaceService getJoinedRaceService() {
		return joinedRaceService;
	}
	public void setJoinedRaceService(JoinedRaceService joinedRaceService) {
		this.joinedRaceService = joinedRaceService;
	}
	
	@Override
	public String execute() throws Exception {
		List<JoinedRace> joinedRaces = this.joinedRaceService.queryJoinedRaceByRaceId(raceId);
		for(JoinedRace race:joinedRaces ){
			User user = this.joinedRaceService.get(User.class, race.getUserId());
			race.setUser(user);
		}
		setRequestAttr("joinedRaces", joinedRaces);
		return SUCCESS;
	}
}
