package com.zhbit.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:17:24 描述：
 */
public class CharacterEncodingFilter implements Filter {
    protected FilterConfig filterConfig = null;
    protected String encoding = "";
    public void destroy() {
        filterConfig = null;
        encoding = null;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if(encoding != null && !"".equals(encoding))
            servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
    }
}
