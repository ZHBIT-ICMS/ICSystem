package com.zhbit.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhbit.entity.base.SessionInfo;
import com.zhbit.util.RequestUtil;
import com.zhbit.util.ResourceUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:17:22
 * 描述：
 * 权限拦截器
 */
public class AuthInterceptor extends MethodFilterInterceptor {
    private static final long serialVersionUID = 1L;
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //ActionContext actionContext = actionInvocation.getInvocationContext();
        SessionInfo sessionInfo = (SessionInfo) actionInvocation.getInvocationContext().getSession().get(ResourceUtil.getSessionInfoName());
        if (sessionInfo.getLoginName().equals("admin")) {// admin用户不需要验证权限
            return actionInvocation.invoke();
        }
       // String requestPath = RequestUtil.getRequestPath(ServletActionContext.getRequest());
        HttpServletRequest request =(HttpServletRequest) actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
        String requestPath = RequestUtil.getRequestPath(request);
        String authUrls = sessionInfo.getAuthUrls();
        boolean b = false;
        for (String url : authUrls.split(",")) {
            if (requestPath.equals(url)) {
                b = true;
                break;
            }
        }
        if (b) {
            return actionInvocation.invoke();
        }
        request.setAttribute("msg", "您没有访问此功能的权限！权限路径为[" + requestPath + "]请联系管理员给你赋予相应权限。");
        return "noAuth";
    }
}
