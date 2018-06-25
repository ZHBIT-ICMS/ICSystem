package com.zhbit.service;

import com.zhbit.entity.News;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoNews;

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


//以下方法由组长张润添加
    /**
     * 获得数据表格
     *
     * @param voNews
     * @return
     */
    public DataGrid datagrid(VoNews voNews);

    /**
     * 删除
     *
     * @param ids
     */
    public void delete(String ids);

    /**
     * 添加
     *
     * @param voNews
     */
    public void add(VoNews voNews);

    /**
     * 获得新闻内容
     * @param id
     * @return
     */
    public String getContentById(int id);

    public void update(VoNews voNews);
}
