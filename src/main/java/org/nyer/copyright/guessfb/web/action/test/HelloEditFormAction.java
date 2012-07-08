package org.nyer.copyright.guessfb.web.action.test;

import org.apache.struts2.ServletActionContext;
import org.nyer.copyright.guessfb.model.People;
import org.nyer.copyright.guessfb.service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloEditFormAction extends ActionSupport{
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private BaseService baseService;
    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public String execute(){
        People people = this.baseService.get(People.class, id);
        ServletActionContext.getRequest().setAttribute("people",people);
        return SUCCESS;
    }
    
}
