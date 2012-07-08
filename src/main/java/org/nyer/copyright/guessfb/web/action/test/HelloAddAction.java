package org.nyer.copyright.guessfb.web.action.test;

import java.util.Date;

import org.nyer.copyright.guessfb.model.People;
import org.nyer.copyright.guessfb.service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAddAction extends ActionSupport{
    private BaseService baseService;
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
    
    public String execute(){
        people.setTime(new Date());
        this.baseService.save(people);
        id = people.getId();
        return SUCCESS;
    }
}
