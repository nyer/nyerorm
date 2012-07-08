package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.MarkNotColumn;
import org.nyer.orm.annotation.Table;

@Table("joinedrace")
public class JoinedRace {
    @Id(value="idjoinedrace",idPolicy = IdPolicy.AUTO)
    private Long idJoinedRace;
    private Date time;
    private Integer auto;//1:自动，0：不自动
    private Double point;
    @Column(column="userid")
    private Long userId;
    @MarkNotColumn
    private User user;
    @Column(column="raceid")
    private Long raceId;
    private String guess;
    @Column(column="leagueid")
    private Long leagueId;
   
	public Long getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}
	public Long getIdJoinedRace() {
		return idJoinedRace;
	}
	public void setIdJoinedRace(Long idJoinedRace) {
		this.idJoinedRace = idJoinedRace;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getAuto() {
		return auto;
	}
	public void setAuto(Integer auto) {
		this.auto = auto;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRaceId() {
		return raceId;
	}
	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
}
