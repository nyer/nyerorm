package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.util.Constant;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class LogoutAction extends BaseAction{
    public String execute(){
        removeFromSession(Constant.SESSIONUSER);
        
        return Action.LOGIN;
    }
}
