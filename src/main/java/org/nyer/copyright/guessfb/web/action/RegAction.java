package org.nyer.copyright.guessfb.web.action;

import java.util.Date;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.UserService;
import org.nyer.copyright.guessfb.util.Constant;

public class RegAction extends BaseAction{
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public String execute(){
        if(userService.isUserNameExist(user.getUserName())){
            return "regPage";
        }
        user.setBornTime(new Date());
        user = userService.regUser(user);
        addToSessionMap(Constant.SESSIONUSER, user);
        return "homePage";
    }
}
