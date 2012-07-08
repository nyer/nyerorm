package org.nyer.copyright.guessfb.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
    /**
     * 
     */
    private static Logger log = Logger.getLogger(BaseAction.class);
    private static final long serialVersionUID = -2170398906753199772L;
     

    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }
    
    public HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }
    
    public void write(String content){
        PrintWriter out = getOut();
        out.print(content);
        out.flush();
    }
    
    public PrintWriter getOut(){
        try {
            return getResponse().getWriter();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("error on get writer", e);
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public Map<String,Object> getSessionMap(){
        return ActionContext.getContext().getSession();
    }
    
    public void addToSessionMap(String key,Object value){
        getSessionMap().put(key, value);
    }
    
    public void removeFromSession(String key){
        getSessionMap().remove(key);
    }
    
    public HttpSession getSession(){
        return getRequest().getSession();
    }
    
    public void setRequestAttr(String key,Object value){
        getRequest().setAttribute(key, value);
    }
    
    public Object getRequestAttr(String key){
        return getRequest().getAttribute(key);
    }
    
    public void sendRedirect(String url){
    	try {
			getResponse().sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void setExcelConfig(String fileName) throws UnsupportedEncodingException{
		fileName = new String(fileName.getBytes("UTF-8"),"ISO8859_1");
		getResponse().setHeader("Content-Disposition", "attachment;filename=" + fileName);
		getResponse().setDateHeader("Expires", 0);
		getResponse().setHeader("Cache-Control"	, "no-cache");
		getResponse().setHeader("Pragma", "no-cache");
    }
}
