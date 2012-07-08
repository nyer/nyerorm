package org.nyer.copyright.guessfb.web.action;

import java.util.Date;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.JoinedRace;
import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.service.JoinedRaceService;
import org.nyer.copyright.guessfb.util.UserSession;

public class GuessRaceAction extends BaseAction {
	private JoinedRaceService joinedRaceService;
	private Long raceId;
	private Long joinedLeagueId;
	private JoinedLeagueService joinedLeagueService;
	
	public Long getJoinedLeagueId() {
		return joinedLeagueId;
	}
	public void setJoinedLeagueId(Long joinedLeagueId) {
		this.joinedLeagueId = joinedLeagueId;
	}
	
	
	public JoinedLeagueService getJoinedLeagueService() {
		return joinedLeagueService;
	}
	public void setJoinedLeagueService(JoinedLeagueService joinedLeagueService) {
		this.joinedLeagueService = joinedLeagueService;
	}


	private String guess;
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public JoinedRaceService getJoinedRaceService() {
		return joinedRaceService;
	}
	public void setJoinedRaceService(JoinedRaceService joinedRaceService) {
		this.joinedRaceService = joinedRaceService;
	}
	
	public Long getRaceId() {
		return raceId;
	}
	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}
	@Override
	public String execute() throws Exception {
		User user = UserSession.getSessionUser();
		Race race = this.joinedRaceService.get(Race.class, raceId);
		League league = this.joinedRaceService.get(League.class, race.getLeague());

		JoinedRace joinedRace = new JoinedRace();
		joinedRace.setAuto(0);//1：自动，0：手动
		joinedRace.setGuess(guess);
		joinedRace.setRaceId(raceId);
		joinedRace.setTime(new Date());
		joinedRace.setUserId(user.getId());
		joinedRace.setLeagueId(league.getIdLeague());
		this.joinedRaceService.save(joinedRace);
		
		JoinedLeague joinedLeague = this.joinedLeagueService.getJoinedLeagueByUserIdAndLeagueId(user.getId(), league.getIdLeague());
		this.setJoinedLeagueId(joinedLeague.getIdJoinedLeague());
		return SUCCESS;
	}
}
