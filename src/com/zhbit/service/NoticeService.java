package com.zhbit.service;

import com.zhbit.entity.Notice;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoNotice;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 * modified by wenxuan
 */
public interface NoticeService {
    /**
     * 展示所有通知公告，
     */
    public List<Notice> showNoticeList(Notice s_notice, PageBean pageBean);

    /**
     * 根据id 查出通知公告详情
     */
    public Notice getNoticeById(int noticeId);

    /**
     * 计算总记录数
     */
    public Long getNoticeCount(Notice s_notice);


    /**
     * 获得数据表格
     */
    public DataGrid datagrid(VoNotice voNotice);

    /**
     * 删除
     */
    public void delete(String ids);

    /**
     * 添加
     */
    public void add(VoNotice voNotice);

    /**
     * 获得通知公告信息内容
     */
    public String getContentById(int id);

    public void update(VoNotice voNotice);
}
