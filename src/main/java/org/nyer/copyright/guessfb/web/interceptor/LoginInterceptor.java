package org.nyer.copyright.guessfb.web.interceptor;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.util.UserSession;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		User user = UserSession.getSessionUser();
		if(user != null){
			return "homePage";
		}
		return arg0.invoke();
	}

}
