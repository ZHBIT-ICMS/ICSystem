package com.zhbit.service;

import com.zhbit.entity.News;
import com.zhbit.entity.PageBean;
import com.zhbit.util.StringUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//新闻
public interface NewsService {
    /**
     * 展示所有新闻，这里展示1-8条最新新闻
     * @param s_news
     * @param pageBean
     * @return
     */
    public List<News> showNewsList(News s_news, PageBean pageBean);

    /**
     * 根据id 查出新闻详情
     * @param newsId
     * @return
     */
    public News getNewsById(int newsId);

    /**
     * 计算总记录数
     * @param s_news
     * @return
     */
    public Long getNewsCount(News s_news);


}
