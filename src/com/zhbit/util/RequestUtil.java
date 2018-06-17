package com.zhbit.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:17:24
 * 描述：
 * 获得请求路径工具类
 */
public class RequestUtil {

    public static String getRequestPath(HttpServletRequest request) {
        String requestPath = request.getRequestURI();
        requestPath = requestPath.substring(request.getContextPath().length());// 去掉项目路径
        return requestPath;
    }
}
