package org.nyer.copyright.guessfb.model;

import java.util.Date;

import org.nyer.orm.annotation.Id;
import org.nyer.orm.annotation.IdPolicy;
import org.nyer.orm.annotation.NotUpdate;
import org.nyer.orm.annotation.Table;

@Table("user")
public class User {
    @Id(value="id",idPolicy = IdPolicy.AUTO)
    private Long id;
    
    @NotUpdate
    private String userName;
    @NotUpdate
    private Date bornTime;
    private String password;
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getBornTime() {
        return bornTime;
    }
    public void setBornTime(Date bornTime) {
        this.bornTime = bornTime;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
