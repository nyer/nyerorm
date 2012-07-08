package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.service.UserService;
import org.nyer.copyright.guessfb.util.UserSession;

/**
 * @author LeiTing
 *
 */
public class UpdateUserInfoAction extends BaseAction {
	private User user;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		User u = UserSession.getSessionUser();
		user.setId(u.getId());
		this.userService.update(user);
		return SUCCESS;
	}
}
