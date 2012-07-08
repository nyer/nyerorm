package org.nyer.copyright.guessfb.web.action.admin;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.UserService;
import org.nyer.copyright.guessfb.util.Constant;
import org.nyer.copyright.guessfb.web.action.BaseAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class AdminLoginAction extends BaseAction{
    private User user;
    
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute(){
        if(user.getUserName().trim().length() == 0 || user.getPassword().trim().length() == 0){
            return Action.LOGIN;
        }
        user = userService.login(user);	
        if(user == null || !"admin".equals(user.getUserName()))//默认管理员账号
        	return Action.LOGIN;
        if(user == null)
            return Action.LOGIN;
        this.addToSessionMap(Constant.SESSIONADMIN, user);
        return SUCCESS;
    }
}
