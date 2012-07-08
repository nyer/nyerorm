package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.util.Constant;
import org.nyer.copyright.guessfb.web.action.BaseAction;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class AdminLogoutAction extends BaseAction{
    public String execute(){
        removeFromSession(Constant.SESSIONADMIN);
        
        return SUCCESS;
    }
}
