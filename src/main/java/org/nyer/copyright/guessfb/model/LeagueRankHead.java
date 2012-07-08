package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.Table;

@Table("leaguerankhead")
public class LeagueRankHead {
	@Id(value="rankheadid",idPolicy=IdPolicy.AUTO)
	private Long rankHeadId;
	@Column(column="leagueid")
	private Long leagueId;
	@Column(column="createtime")
	private Date createTime;
	public Long getRankHeadId() {
		return rankHeadId;
	}
	public void setRankHeadId(Long rankHeadId) {
		this.rankHeadId = rankHeadId;
	}
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
