package com.zhbit.action;

import com.zhbit.entity.News;
import com.zhbit.entity.Notice;
import com.zhbit.entity.base.PageBean;
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
/*չ����ҳ�����ݵ���Ϣ*/
@Component
public class InitAction implements ServletContextListener,ApplicationContextAware {
    /*
    * �̳� ApplicationContextAware ����ȡ spring����
    * */
    private static ApplicationContext applicationContext;
    /**�̳�  ServletContextListener ��Ҫ��д  contextDestroyed & contextInitialized
     * ��ʼ��
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application=servletContextEvent.getServletContext();
        // ����
        NewsService newsService= (NewsService) applicationContext.getBean("newsService");
        List<News>newsList=newsService.showNewsList(null,new PageBean(1,7));
        application.setAttribute("newsList",newsList);
        //����
        NoticeService noticeService= (NoticeService) applicationContext.getBean("noticeService");
        List<Notice>noticeList=noticeService.showNoticeList(null,new PageBean(1,7));
        application.setAttribute("noticeList",noticeList);
        //���߷���
        PolicyService policyService= (PolicyService) applicationContext.getBean("policyService");
        List<Policy> policyList=policyService.showPolicyList(null,new PageBean(1,7));
        application.setAttribute("policyList",policyList);


    }

    /**�̳�  ServletContextListener ��Ҫ��д  contextDestroyed & contextInitialized
     * ����
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
