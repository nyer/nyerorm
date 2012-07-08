package org.nyer.copyright.guessfb.web.action.test;

import java.util.Date;

import org.nyer.copyright.guessfb.model.People;
import org.nyer.copyright.guessfb.service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloEditAction extends ActionSupport{
    private People people;
    private BaseService baseService;
    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
    
    public String execute(){
        people.setTime(new Date());
        this.baseService.update(people);
        return SUCCESS;
    }
    
}
