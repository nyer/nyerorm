package org.nyer.copyright.guessfb.web.interceptor;

import org.nyer.copyright.guessfb.model.User;
import org.nyer.copyright.guessfb.util.UserSession;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        User user = UserSession.getSessionAdmin();
        if(user == null){
            return Action.LOGIN;
        }
        return ai.invoke();
    }

}
