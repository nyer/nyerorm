package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.League;
import org.nyer.copyright.guessfb.service.LeagueService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class EditLeagueAction extends BaseAction{
    private League league;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
    private LeagueService leagueService;

    public LeagueService getLeagueService() {
        return leagueService;
    }

    public void setLeagueService(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
    
    public String execute(){
        this.leagueService.update(league);
        return SUCCESS;
    }
}
