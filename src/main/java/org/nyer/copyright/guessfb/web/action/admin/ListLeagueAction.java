package org.nyer.copyright.guessfb.web.action.admin;

import java.util.List;

import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class ListLeagueAction extends BaseAction{
    private LeagueService leagueService;

    public LeagueService getLeagueService() {
        return leagueService;
    }

    public void setLeagueService(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
    
    public String execute(){
        List<League> list = this.leagueService.getLeaguesWithLimit(0, 10);
        setRequestAttr("leagues", list);
        return SUCCESS;
    }
}
