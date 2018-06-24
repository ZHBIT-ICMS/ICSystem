package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.News;
import com.zhbit.entity.base.PageBean;
import com.zhbit.service.NewsService;
import com.zhbit.util.PageUtil;
import com.zhbit.util.StringUtil;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wby on 2018/5/29.
 */
public class NewsAction extends ActionSupport implements ServletRequestAware {
    @Resource
    private NewsService newsService;
    private int newsId;
    private News news;//展示时用到对象
    private String page;
    private News s_news;//分页用到对象
    private List<News> newsList;
    private Long total;
    private HttpServletRequest request;
    private String pageCode;

    public List <News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List <News> newsList) {
        this.newsList = newsList;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public News getS_news() {
        return s_news;
    }

    public void setS_news(News s_news) {
        this.s_news = s_news;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    /**
     * 前台页面分页展示
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),8);
        newsList=newsService.showNewsList(s_news,pageBean);
        total= newsService.getNewsCount(s_news);
        StringBuffer param=new StringBuffer();
        pageCode= PageUtil.genPagination(request.getContextPath()+"/news.action", total, Integer.parseInt(page), 8, param.toString());
        return super.execute();
    }
    /**
     * 展示新闻详情
     * @return
     */
    public String showNews(){
        System.out.println("newsId"+newsId);
        news=newsService.getNewsById(newsId);
        return "shownews";
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;

    }
}
