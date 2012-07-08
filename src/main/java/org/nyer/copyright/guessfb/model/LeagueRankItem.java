package org.nyer.copyright.guessfb.model;

import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.MarkNotColumn;
import org.nyer.orm.annotation.Table;

import com.sun.istack.internal.NotNull;

@Table("leaguerankitem")
public class LeagueRankItem {
	@Id(value="rankitemid",idPolicy=IdPolicy.AUTO)
	private Long rankItemId;
	@Column(column="rankheadid")
	private Long rankHeadId;
	@Column(column="userid")
	private Long userId;
	@Column(column="rank")
	private Integer rank;
	@Column(column="wave")
	private Integer change;
	@Column(column="joinedleagueid")
	private Long joinedLeagueId;
	@Column(column="leagueId")
	private Long leagueId;
	@Column(column="score")
	private Double score;
	@MarkNotColumn
	private User user;
	
	public Long getRankItemId() {
		return rankItemId;
	}
	public void setRankItemId(Long rankItemId) {
		this.rankItemId = rankItemId;
	}
	public Long getRankHeadId() {
		return rankHeadId;
	}
	public void setRankHeadId(Long rankHeadId) {
		this.rankHeadId = rankHeadId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getChange() {
		return change;
	}
	public void setChange(Integer change) {
		this.change = change;
	}
	
	public Long getJoinedLeagueId() {
		return joinedLeagueId;
	}
	public void setJoinedLeagueId(Long joinedLeagueId) {
		this.joinedLeagueId = joinedLeagueId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	
	
}
