package org.nyer.copyright.guessfb.web.action.test;

import org.nyer.copyright.guessfb.model.People;
import org.nyer.copyright.guessfb.service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloDeleteAction extends ActionSupport{
    private BaseService baseService;
    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    private Long id;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String execute(){
        this.baseService.delete(People.class, id);
        return SUCCESS;
    }
}
