package com.zhbit.action;

import com.zhbit.entity.News;
import com.zhbit.entity.Notice;
import com.zhbit.entity.PageBean;
import com.zhbit.entity.Policy;
import com.zhbit.service.NewsService;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zhbit.service.NoticeService;
import com.zhbit.service.PolicyService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
/*展现主页面内容的信息*/
@Component
public class InitAction implements ServletContextListener,ApplicationContextAware {
    /*
    * 继承 ApplicationContextAware 来获取 spring容器
    * */
    private static ApplicationContext applicationContext;
    /**继承  ServletContextListener 需要重写  contextDestroyed & contextInitialized
     * 初始化
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application=servletContextEvent.getServletContext();
        // 新闻
        NewsService newsService= (NewsService) applicationContext.getBean("newsService");
        List<News>newsList=newsService.showNewsList(null,new PageBean(1,7));
        application.setAttribute("newsList",newsList);
        //公告
        NoticeService noticeService= (NoticeService) applicationContext.getBean("noticeService");
        List<Notice>noticeList=noticeService.showNoticeList(null,new PageBean(1,7));
        application.setAttribute("noticeList",noticeList);
        //政策法规
        PolicyService policyService= (PolicyService) applicationContext.getBean("policyService");
        List<Policy> policyList=policyService.showPolicyList(null,new PageBean(1,7));
        application.setAttribute("policyList",policyList);


    }

    /**继承  ServletContextListener 需要重写  contextDestroyed & contextInitialized
     * 销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;

    }
}
