package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.News;
import com.zhbit.entity.PageBean;
import com.zhbit.service.NewsService;
import com.zhbit.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService{
    @Resource
    private BaseDAO<News>baseDAO;
    /**
     * 展示所有新闻，这里展示1-8条最新新闻
     * @param s_news
     * @param pageBean
     * @return
     */
    @Override
    public List<News> showNewsList(News s_news, PageBean pageBean) {
        List<Object>param =new LinkedList <Object>();
        StringBuffer hql=new StringBuffer("from News ");
        if(s_news!=null){
            if(StringUtil.isNotEmpty(s_news.getTitle())){
                hql.append(" and title like ?");
                param.add("%"+s_news.getTitle()+"%");
            }
        }
       hql.append("order by id desc");
        if(pageBean!=null){
            System.out.println("111111:"+hql.toString().replaceFirst("and","where"));
            return baseDAO.find(hql.toString().replaceFirst("and","where"),param,pageBean);

        }else {
            return null;
        }
    }
    /**
     * 根据id 查出新闻详情
     * @param
     * @return
     */
    @Override
    public News getNewsById(int newsId) {
        return baseDAO.get(News.class,newsId);
    }

    /**
     * 计算新闻总的记录数
     * @param s_news
     * @return
     */
    @Override
    public Long getNewsCount(News s_news) {
        List<Object>param=new LinkedList <>();
        StringBuffer hql=new StringBuffer("select count(*) from News");
        if(s_news!=null){
            if(StringUtil.isNotEmpty(s_news.getTitle())){
                hql.append(" and title like ?");
                param.add("%"+s_news.getTitle()+"%");
            }
        }
        return (Long)baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
    }
}
