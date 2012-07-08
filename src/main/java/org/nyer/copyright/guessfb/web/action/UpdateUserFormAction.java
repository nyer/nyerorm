package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.UserService;
import org.nyer.copyright.guessfb.util.UserSession;

@SuppressWarnings("serial")
public class UpdateUserFormAction extends BaseAction{
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public String exeucte(){
        User user = UserSession.getSessionUser();
        getRequest().setAttribute("user", user);
        return "updateUserForm";
    }
}
