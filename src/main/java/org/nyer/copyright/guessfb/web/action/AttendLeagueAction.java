package org.nyer.copyright.guessfb.web.action;

import java.util.Date;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.util.UserSession;

public class AttendLeagueAction extends BaseAction {
	private JoinedLeagueService joinedLeagueService;
	private Long leagueId;

	public Long getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}

	public JoinedLeagueService getJoinedLeagueService() {
		return joinedLeagueService;
	}

	public void setJoinedLeagueService(JoinedLeagueService joinedLeagueService) {
		this.joinedLeagueService = joinedLeagueService;
	}
	
	@Override
	public String execute() throws Exception {
		JoinedLeague joinedLeague = new JoinedLeague();
		joinedLeague.setLeagueId(leagueId);
		joinedLeague.setJoinTime(new Date());
		User user = UserSession.getSessionUser();
		joinedLeague.setUserId(user.getId());
		
		Double lowestScore = this.joinedLeagueService.getLowestJoinedLeagueScore(leagueId);
		joinedLeague.setScore(lowestScore);
		
		this.joinedLeagueService.save(joinedLeague);
		return SUCCESS;
	}
}
