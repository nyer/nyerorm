package org.nyer.copyright.guessfb.web.action.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Array;
import org.nyer.copyright.guessfb.model.People;
import org.nyer.copyright.guessfb.service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloListAction extends ActionSupport{
	private BaseService baseService;
	private static  Logger log = Logger.getLogger(HelloListAction.class);

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public String execute(){
	    long start = System.currentTimeMillis();
	    People p = new People();
//	    for(int i=0;i < 10000;i ++){
//	        p.setId(null);
//	        p.setName("test" + i);
//	        p.setTime(new Date());
//	        this.baseService.save(p);
//	    }
//	    System.out.println("-----" + (System.currentTimeMillis() - start));
	    
	    start = System.currentTimeMillis();
	    List<People> list = null;
	    
	   // int time = Integer.parseInt(ServletActionContext.getRequest().getParameter("time"));
	    for(int i=1;i <= 1;i ++){
            list = this.baseService.queryListFromExampleWithLimit(p, 1, 200);
	    }
	    Long cost =  (System.currentTimeMillis() - start);
	    ServletActionContext.getRequest().setAttribute("peoples", list);
	    ServletActionContext.getRequest().setAttribute("queryCost", cost);
		return SUCCESS;
	}
}
	