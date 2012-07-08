package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.UserService;
import org.nyer.copyright.guessfb.util.Constant;

public class UpdateUserAction extends BaseAction{
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
    
    public String exeucte(){
        user = userService.updateUser(user);
        addToSessionMap(Constant.SESSIONUSER, user);
        return "homePage";
    }
}
