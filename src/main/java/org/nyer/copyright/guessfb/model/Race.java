package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.MarkNotColumn;
import org.nyer.orm.annotation.NotUpdate;
import org.nyer.orm.annotation.Table;

@Table("race")
public class Race {
    @Id(value="idrace",idPolicy = IdPolicy.AUTO)
    private Long idRace;
    private Date start;
    @NotUpdate
    private Long league;
    private String team1;
    private String team2;
    
    @Column(column="team1score")
    private Integer team1Score;
    @Column(column="team2score")
    private Integer team2Score;
    private Double winpoint;
    private Double pinpoint;
    private Double lostpoint;
    private Integer autoguess;
    private Double free;//折扣
    
    public Double getFree() {
		return free;
	}


	public void setFree(Double free) {
		this.free = free;
	}

	

	public Integer getAutoguess() {
		return autoguess;
	}


	public void setAutoguess(Integer autoguess) {
		this.autoguess = autoguess;
	}





	@MarkNotColumn
    private String guess;//1:胜，0：平，-1：负
    @MarkNotColumn
    private Double point;//得分
    @MarkNotColumn
    private Integer auto;//是否默认
    
    
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


	public String getGuess() {
		return guess;
	}


	public void setGuess(String guess) {
		this.guess = guess;
	}


	public Long getIdRace() {
		return idRace;
	}


	public void setIdRace(Long idRace) {
		this.idRace = idRace;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}

	


	public Double getWinpoint() {
		return winpoint;
	}


	public void setWinpoint(Double winpoint) {
		this.winpoint = winpoint;
	}


	public Double getPinpoint() {
		return pinpoint;
	}


	public void setPinpoint(Double pinpoint) {
		this.pinpoint = pinpoint;
	}


	public Double getLostpoint() {
		return lostpoint;
	}


	public void setLostpoint(Double lostpoint) {
		this.lostpoint = lostpoint;
	}


	public Long getLeague() {
		return league;
	}


	public void setLeague(Long league) {
		this.league = league;
	}


	public String getTeam1() {
		return team1;
	}


	public void setTeam1(String team1) {
		this.team1 = team1;
	}


	public String getTeam2() {
		return team2;
	}


	public void setTeam2(String team2) {
		this.team2 = team2;
	}


	public Integer getTeam1Score() {
		return team1Score;
	}


	public void setTeam1Score(Integer team1Score) {
		this.team1Score = team1Score;
	}


	public Integer getTeam2Score() {
		return team2Score;
	}


	public void setTeam2Score(Integer team2Score) {
		this.team2Score = team2Score;
	}



    public boolean isCanGuess(){
    	return (start.getTime() - System.currentTimeMillis()) /(1000 * 60 ) > 30;
    }
}
