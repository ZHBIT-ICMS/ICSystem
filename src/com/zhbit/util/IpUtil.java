package com.zhbit.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:16:09
 * 描述：
 * 获取登录用户IP地址
 */
public class IpUtil {

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf("0:") != -1) {
            ip = "本地";
        }
        return ip;
    }
}
