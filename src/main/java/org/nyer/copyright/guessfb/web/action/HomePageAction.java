package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.util.Constant;
import org.nyer.copyright.guessfb.util.UserSession;

import com.opensymphony.xwork2.Action;

public class HomePageAction extends BaseAction{
    private JoinedLeagueService joinedLeagueService;
    public JoinedLeagueService getJoinedLeagueService() {
        return joinedLeagueService;
    }
    public void setJoinedLeagueService(JoinedLeagueService joinedLeagueService) {
        this.joinedLeagueService = joinedLeagueService;
    }
    
    public String execute(){
        User user = UserSession.getSessionUser();
        List<JoinedLeague> joinedLeagues = joinedLeagueService.getJoiningLeagueByUserIdWithLimit(user.getId(), 0, Constant.JOINED_LEGUE_SIZE);
        
        for(JoinedLeague jl:joinedLeagues){
        	League league = this.joinedLeagueService.get(League.class, jl.getLeagueId());
        	jl.setLeague(league);
        }
        setRequestAttr("joinedLeagues", joinedLeagues);
        
        return Action.SUCCESS;
    }
}
