package org.nyer.copyright.guessfb.web.action.admin;

import java.util.Date;
import java.util.List;

import org.nyer.copyright.guessfb.model.JoinedLeague;
import org.nyer.copyright.guessfb.model.JoinedRace;
import org.nyer.copyright.guessfb.model.LeagueRankHead;
import org.nyer.copyright.guessfb.model.LeagueRankItem;
import org.nyer.copyright.guessfb.model.Race;
import org.nyer.copyright.guessfb.service.JoinedLeagueService;
import org.nyer.copyright.guessfb.service.JoinedRaceService;
import org.nyer.copyright.guessfb.service.LeagueRankService;
import org.nyer.copyright.guessfb.service.RaceService;
import org.nyer.copyright.guessfb.web.action.BaseAction;

public class ScoreRaceAction extends BaseAction {
	private Race race;
	private Long leagueId;
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}

	private RaceService raceService;
	private JoinedLeagueService joinedLeagueService;
	private JoinedRaceService joinedRaceService;
	private LeagueRankService leagueRankService;
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
	
	public LeagueRankService getLeagueRankService() {
		return leagueRankService;
	}
	public void setLeagueRankService(LeagueRankService leagueRankService) {
		this.leagueRankService = leagueRankService;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public RaceService getRaceService() {
		return raceService;
	}
	public void setRaceService(RaceService raceService) {
		this.raceService = raceService;
	}
	
	public String execute(){
		Race local = this.raceService.get(Race.class, race.getIdRace());
		leagueId = local.getLeague();
		local.setTeam1Score(race.getTeam1Score());
		local.setTeam2Score(race.getTeam2Score());
		this.raceService.update(local);
		
		//竞猜结果
		String guess = "0";//平局
		if(local.getTeam1Score() > local.getTeam2Score()){
			guess = "1";//team1 赢 team2
		}else if(local.getTeam1Score() < local.getTeam2Score()){
			guess = "-1";//team1 输 team2;
		}
		
		Double basePoint = local.getPinpoint();
		if(guess.equals("1")){
			basePoint = local.getWinpoint();
		}else if(guess.equals("-1")){
			basePoint = local.getLostpoint();
		}
		//给各位竞猜者评分
		List<JoinedLeague> joinedLeagues = this.joinedLeagueService.getJoinedLeagueByLeagueId(leagueId);
		for(JoinedLeague joinedLeague:joinedLeagues){
			JoinedRace joinedRace = this.joinedRaceService.getJoinedRaceByRaceIdAndUserId(local.getIdRace(), joinedLeague.getUserId());
			if(joinedRace == null){
				//没有手动竞猜，默认竞猜为平局
				joinedRace = new JoinedRace();
				joinedRace.setAuto(1);
				joinedRace.setTime(new Date());
				joinedRace.setRaceId(race.getIdRace());
				joinedRace.setUserId(joinedLeague.getUserId());
				joinedRace.setPoint(0d);
				joinedRace.setLeagueId(joinedLeague.getLeagueId());
				joinedRace.setGuess(local.getAutoguess().toString());//默认竞猜
				if(joinedRace.getGuess().equals(guess)){//猜中
					joinedRace.setPoint(basePoint * local.getFree());//打折
				}
				this.joinedRaceService.save(joinedRace);
			}else{
				joinedRace.setAuto(0);
				joinedRace.setPoint(0d);//默认没有猜中
				if(guess.equals(joinedRace.getGuess())){//猜中
					joinedRace.setPoint(basePoint );
				}
				this.joinedRaceService.update(joinedRace);
			}
			
		}
		
		//计算联赛总分
		for(JoinedLeague joinedLeague:joinedLeagues){
			List<JoinedRace> joinedRaces = this.joinedRaceService
			.queryJoinedRacesByLeagueIdAndUserId(joinedLeague.getLeagueId(), joinedLeague.getUserId());
			Double leagueTotalScore = 0d;
			for(JoinedRace race:joinedRaces){
				if(race.getPoint() == null)
					continue;//比赛结果还没有出
				leagueTotalScore += race.getPoint();
			}
			joinedLeague.setScore(leagueTotalScore);
			this.joinedLeagueService.update(joinedLeague);
		}
		
		//更新联赛排名
		joinedLeagues = this.joinedLeagueService.getJoinedLeagueByLeagueIdOrderByPointDesc(leagueId);
		LeagueRankHead rankHead = new LeagueRankHead();
		rankHead.setLeagueId(leagueId);
		rankHead.setCreateTime(new Date());
		this.joinedRaceService.save(rankHead);
		for(int i=0,j = joinedLeagues.size();i < j;i ++){
			JoinedLeague joinedLeague = joinedLeagues.get(i);
			int rank = i + 1;
			long userId = joinedLeague.getUserId();
			LeagueRankItem t = new LeagueRankItem();
			t.setUserId(userId);
			t.setJoinedLeagueId(joinedLeague.getIdJoinedLeague());
			t.setLeagueId(leagueId);
			t.setRankHeadId(rankHead.getRankHeadId());
			t.setRank(rank);
			t.setScore(joinedLeague.getScore());
			
			LeagueRankItem item = this.leagueRankService.getLatestLeagueRankItem(userId, leagueId);
			if(item != null){
				if(rank > item.getRank()){
					t.setChange(-1);
				}else if(rank == item.getRank()){
					t.setChange(0);
				}else{
					t.setChange(1);
				}
			}
			this.leagueRankService.save(t);
		}
		
		return SUCCESS;
	}
}
