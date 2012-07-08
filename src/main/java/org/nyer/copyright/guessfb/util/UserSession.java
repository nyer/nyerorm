package org.nyer.copyright.guessfb.util;

import org.nyer.copyright.guessfb.model.User;

import com.opensymphony.xwork2.ActionContext;

public class UserSession {
    public static final User getSessionUser(){
       return  (User) ActionContext.getContext().getSession().get(Constant.SESSIONUSER);
    }
    
    public static final User getSessionAdmin(){
        return (User)ActionContext.getContext().getSession().get(Constant.SESSIONADMIN);
    }
}
