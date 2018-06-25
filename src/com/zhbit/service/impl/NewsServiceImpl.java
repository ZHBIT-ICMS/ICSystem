package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.News;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoNews;
import com.zhbit.service.NewsService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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

    //
    //
    //以下接口方法的实现由组长：张润添加

    /**
     *返回easyUI所需的datagrid
     * @param voNews
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DataGrid datagrid(VoNews voNews) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voNews)));
        j.setTotal(total(voNews));
        return j;
    }

    /**
     *将News转换成VoNews（视图层模型）
     * @param tnews
     * @return
     */
    private List<VoNews> changeModel(List<News> tnews) {
        List<VoNews> voNews = new ArrayList<VoNews>();
        if (tnews != null && tnews.size() > 0) {
            for (News tn : tnews) {
                VoNews vn= new VoNews();
                BeanUtils.copyProperties(tn, vn);
                voNews.add(vn);
            }
        }
        return voNews;
    }

    /**
     *
     * @param voNews
     * @return
     */
    private List<News> find(VoNews voNews) {
        String hql = " from News t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voNews, hql, values);

        if (voNews.getSort() != null && voNews.getOrder() != null) {
            hql += " order by " + voNews.getSort() + " " + voNews.getOrder();
        }
        PageBean pageBean = new PageBean(voNews.getPage(),voNews.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    /**
     *计算新闻总数
     * @param voNews
     * @return
     */
    private Long total(VoNews voNews) {
        String hql = "select count(*) from News t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voNews, hql, values);
        return baseDAO.count(hql, values);
    }

    /**
     * 新闻条件查询
     * @param voNews
     * @param hql
     * @param values
     * @return
     */
    private String addWhere(VoNews voNews, String hql, List<Object> values) {
        String where;
        String title=voNews.getTitle();
        if(title!=null) {
            where = "t.title like '%" + title + "%'";
        }else{
            where=" 1=1";
        }
        hql=hql+where+" ";
        return hql;
    }

    /**
     * 新闻删除
     * @param ids
     */
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                News t = baseDAO.get(News.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除新闻id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }
    }

    /**
     *新闻增加
     * @param voNews
     */
    public void add(VoNews voNews) {
        if (voNews.getCreateTime() == null) {
            voNews.setCreateTime(new Date());
        }
        News t = new News();
        BeanUtils.copyProperties(voNews, t);
        //t.setId(UUID.randomUUID().toString());
        baseDAO.save(t);
    }

    /**
     * 获得新闻内容
     * @param id
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String getContentById(int id) {
        News t = baseDAO.get(News.class, id);
        return t.getContent();
    }

    /**
     * 新闻更新
     * @param voNews
     */
    public void update(VoNews voNews) {
        News t = baseDAO.get(News.class,voNews.getId());
        if (t != null) {
          t.setTitle(voNews.getTitle());
          t.setContent(voNews.getContent());
          t.setCreateTime(new Date());
          t.setPeople(voNews.getPeople());
        }
    }

}
