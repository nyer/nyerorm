package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.MarkNotColumn;
import org.nyer.orm.annotation.Table;

@Table("People")
public class People {
    @Id(value="id",idPolicy = IdPolicy.AUTO)
    private Long id;
    private String name;
    private Date time;
    
    @MarkNotColumn
    private String test;
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
