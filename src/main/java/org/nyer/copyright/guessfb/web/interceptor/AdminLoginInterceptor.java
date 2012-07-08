package org.nyer.copyright.guessfb.web.interceptor;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.util.UserSession;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminLoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		User user = UserSession.getSessionAdmin();
		if(user != null){
			return "adminHomePage";
		}
		return arg0.invoke();
	}

}
