package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.util.UserSession;
import org.nyer.copyright.guessfb.web.action.BaseAction;

import com.opensymphony.xwork2.Action;

public class AdminHomePageAction extends BaseAction{
    public LeagueService getLeagueService() {
        return leagueService;
    }
    public void setLeagueService(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
    private LeagueService leagueService;
    
    
    public String execute(){
        User user = UserSession.getSessionAdmin();
        setRequestAttr("user", user);
        return Action.SUCCESS;
    }
}
