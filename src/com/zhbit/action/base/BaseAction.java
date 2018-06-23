package com.zhbit.action.base;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:23:18
 * 描述：
 */
/*public class BaseAction extends ActionSupport implements ServletContextAware,
        ServletResponseAware, ServletRequestAware, SessionAware {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(BaseAction.class);

    protected ServletContext servletContext;

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession httpSession;

    protected Map<String, Object> session;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static Logger getLogger() {
        return logger;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public void writeJson(Object object){

    }
}*/
