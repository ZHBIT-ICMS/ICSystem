package com.zhbit.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhbit.entity.base.SessionInfo;
import com.zhbit.util.ResourceUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:17:10
 * 描述：
 */
public class SessionInterceptor extends MethodFilterInterceptor {
    /*
    public  String intercept(ActionInvocation ai) throws Exception{
        SessionInfo sessionInfo=(SessionInfo)ai.getInvocationContext().getSession().get(ResourceUtil.getSessionInfoName());
        if (sessionInfo == null){
            ai.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);

        }
    }*/
    private static final long serialVersionUID = 1L;
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
    //SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
        SessionInfo sessionInfo = (SessionInfo) actionInvocation.getInvocationContext().getSession().get(ResourceUtil.getSessionInfoName());
    if(sessionInfo == null){
        ServletActionContext.getRequest().setAttribute("msg","您还没有登录或登录已超时，请重新登录，2秒后将跳转到登录页面！<br><a href='javascript:void(0)' onclick='skip()'>如不能自动跳转请点击此处</a>");
        return "noSession";
    }
    return actionInvocation.invoke();
    }
}
