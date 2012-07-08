package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.UserService;
import org.nyer.copyright.guessfb.util.Constant;

import com.opensymphony.xwork2.Action;

public class LoginAction extends BaseAction{
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
        if(user == null)
            return Action.LOGIN;
        this.addToSessionMap(Constant.SESSIONUSER, user);
        return "homePage";
    }
}
