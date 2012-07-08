package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Column;
import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.Table;

@Table("league")
public class League {
    @Id(value="idLeague",idPolicy = IdPolicy.AUTO)
    private Long idLeague;
    private Date start;
    private Date end;
    @Column(column="title")
    private String desc;
    public Long getIdLeague() {
        return idLeague;
    }
    public void setIdLeague(Long idLeague) {
        this.idLeague = idLeague;
    }
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public boolean isAvai(){
        long current = System.currentTimeMillis();
        return (start.getTime() >= current) && ( end.getTime() <= current);
    }
    
    public boolean isStarted(){
    	return start.getTime() < System.currentTimeMillis();
    }
    
    public boolean isEnded(){
    	return end.getTime() <= System.currentTimeMillis();
    }
    
}
