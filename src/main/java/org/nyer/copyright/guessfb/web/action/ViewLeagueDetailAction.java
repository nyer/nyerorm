package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.JoinedRace;
import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.service.JoinedRaceService;
import org.nyer.copyright.guessfb.service.RaceService;
import org.nyer.copyright.guessfb.util.UserSession;

public class ViewLeagueDetailAction extends BaseAction {
	private Long joinedLeagueId;

	private RaceService raceService;
	private JoinedRaceService joinedRaceService;
	private JoinedLeagueService joinedLeagueService;
	
	public Long getJoinedLeagueId() {
		return joinedLeagueId;
	}
	public void setJoinedLeagueId(Long joinedLeagueId) {
		this.joinedLeagueId = joinedLeagueId;
	}
	public RaceService getRaceService() {
		return raceService;
	}
	public void setRaceService(RaceService raceService) {
		this.raceService = raceService;
	}
	public JoinedRaceService getJoinedRaceService() {
		return joinedRaceService;
	}
	public void setJoinedRaceService(JoinedRaceService joinedRaceService) {
		this.joinedRaceService = joinedRaceService;
	}
	
	
	public JoinedLeagueService getJoinedLeagueService() {
		return joinedLeagueService;
	}
	public void setJoinedLeagueService(JoinedLeagueService joinedLeagueService) {
		this.joinedLeagueService = joinedLeagueService;
	}
	@Override
	public String execute() throws Exception {
		Long userId = UserSession.getSessionUser().getId();
		JoinedLeague joinedLeague = this.joinedLeagueService.get(JoinedLeague.class, joinedLeagueId);
		if(joinedLeague.getUserId().longValue() != userId.longValue()){
			setRequestAttr("readonly", true);//只读
		}
		List<Race> races = this.raceService.getRaceListByLeagueId(joinedLeague.getLeagueId());
		for(Race race:races){
			JoinedRace joinedRace = this.joinedRaceService
			.getJoinedRaceByRaceIdAndUserId(race.getIdRace(),userId);
			if(joinedRace == null)
				continue;
			race.setGuess(joinedRace.getGuess());
			race.setPoint(joinedRace.getPoint());
			race.setAuto(joinedRace.getAuto());
		}
		setRequestAttr("races", races);
		return SUCCESS;
	}
}
