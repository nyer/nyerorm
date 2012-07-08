package org.nyer.copyright.guessfb.web.action;

import java.util.List;

import org.nyer.copyright.guessfb.model.LeagueRankHead;
import org.nyer.copyright.guessfb.model.LeagueRankItem;
import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.LeagueRankService;

public class ExportLeagueRankToExcel extends BaseAction {
	private long leagueRankId;
	private LeagueRankService leagueRankService;
	public long getLeagueRankId() {
		return leagueRankId;
	}
	public void setLeagueRankId(long leagueRankId) {
		this.leagueRankId = leagueRankId;
	}
	public LeagueRankService getLeagueRankService() {
		return leagueRankService;
	}
	public void setLeagueRankService(LeagueRankService leagueRankService) {
		this.leagueRankService = leagueRankService;
	}
	
	@Override
	public String execute() throws Exception {
		LeagueRankHead head = this.leagueRankService.get(LeagueRankHead.class, leagueRankId);
		List<LeagueRankItem> items = this.leagueRankService.getLeagueRankItemsByRankHeadId(leagueRankId);
		 for(LeagueRankItem item:items){
			 User user = this.leagueRankService.get(User.class,item.getUserId());
			 item.setUser(user);
		 }
		super.setExcelConfig("联赛排名.xls" );
		setRequestAttr("rankItems", items);
		return SUCCESS;
	}
}
