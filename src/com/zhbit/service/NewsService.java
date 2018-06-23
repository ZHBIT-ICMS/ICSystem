package com.zhbit.service;

import com.zhbit.entity.News;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoNews;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//����
public interface NewsService {
    /**
     * չʾ�������ţ�����չʾ1-8����������
     * @param s_news
     * @param pageBean
     * @return
     */
    public List<News> showNewsList(News s_news, PageBean pageBean);

    /**
     * ����id �����������
     * @param newsId
     * @return
     */
    public News getNewsById(int newsId);

    /**
     * �����ܼ�¼��
     * @param s_news
     * @return
     */
    public Long getNewsCount(News s_news);


//���·������鳤�������
    /**
     * ������ݱ��
     *
     * @param voNews
     * @return
     */
    public DataGrid datagrid(VoNews voNews);

    /**
     * ɾ��
     *
     * @param ids
     */
    public void delete(String ids);

    /**
     * ���
     *
     * @param voNews
     */
    public void add(VoNews voNews);

    /**
     * �����������
     * @param id
     * @return
     */
    public String getContentById(int id);

    public void update(VoNews voNews);
}
