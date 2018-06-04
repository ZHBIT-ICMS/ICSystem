package com.zhbit.service;

import com.zhbit.entity.News;
import com.zhbit.entity.Notice;
import com.zhbit.entity.PageBean;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//公告
public interface NoticeService {
    /**
     * 展示所有公告，这里展示1-8条最新新闻
     * @param s_notice
     * @param pageBean
     * @return
     */
    public List<Notice> showNoticeList(Notice s_notice, PageBean pageBean);
    /**
     * 根据id 查出公告详情
     * @param noticeId
     * @return
     */
    public Notice getNoticeById(int noticeId);
    /**
     * 计算总记录数
     * @param s_notice
     * @return
     */
    public Long getNoticeCount(Notice s_notice);
}
