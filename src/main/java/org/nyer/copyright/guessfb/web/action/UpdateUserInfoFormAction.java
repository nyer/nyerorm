package org.nyer.copyright.guessfb.web.action;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.util.UserSession;

public class UpdateUserInfoFormAction extends BaseAction {

	
	@Override
	public String execute() throws Exception {
		User  user = UserSession.getSessionUser();
		setRequestAttr("user", user);
		return SUCCESS;
	}
}
