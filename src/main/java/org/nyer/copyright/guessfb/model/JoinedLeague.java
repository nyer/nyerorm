package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.MarkNotColumn;
import org.nyer.orm.annotation.Table;

@Table("joinedleague")
public class JoinedLeague {
    @Id(value="idjoinedleague",idPolicy = IdPolicy.AUTO)
    private Long idJoinedLeague;
    private Long userId;
    @Column(column = "jointime")
    private Date joinTime;
    @Column(column="leagueid")
    private Long leagueId;
    private Double score;
    
    @MarkNotColumn
    private League league;
    @MarkNotColumn
    private User user;
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Long getIdJoinedLeague() {
        return idJoinedLeague;
    }
    public void setIdJoinedLeague(Long idJoinedLeague) {
        this.idJoinedLeague = idJoinedLeague;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Date getJoinTime() {
        return joinTime;
    }
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
    public Long getLeagueId() {
        return leagueId;
    }
    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
    
    
}
