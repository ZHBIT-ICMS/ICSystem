package com.zhbit.service;

import com.zhbit.entity.Notice;
import com.zhbit.entity.base.PageBean;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//����
public interface NoticeService {
    /**
     * չʾ���й��棬����չʾ1-8����������
     * @param s_notice
     * @param pageBean
     * @return
     */
    public List<Notice> showNoticeList(Notice s_notice, PageBean pageBean);
    /**
     * ����id �����������
     * @param noticeId
     * @return
     */
    public Notice getNoticeById(int noticeId);
    /**
     * �����ܼ�¼��
     * @param s_notice
     * @return
     */
    public Long getNoticeCount(Notice s_notice);
}
