package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Notice;
import com.zhbit.entity.base.PageBean;
import com.zhbit.service.NoticeService;
import com.zhbit.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService  {
    @Resource
    private BaseDAO<Notice> baseDAO;
    /**
     * չʾ���й��棬����չʾ1-8�����¹���
     * @param s_notice
     * @param pageBean
     * @return
     */
    @Override
    public List <Notice> showNoticeList(Notice s_notice, PageBean pageBean) {
        List<Object>param =new LinkedList<Object>();
        StringBuffer hql=new StringBuffer("from Notice ");
        if(s_notice!=null){
            if(StringUtil.isNotEmpty(s_notice.getTitle())){
                hql.append(" and title like ?");
                param.add("%"+s_notice.getTitle()+"%");
            }
        }
        hql.append("order by id desc");
        if(pageBean!=null){
            return baseDAO.find(hql.toString().replaceFirst("and","where"),param,pageBean);

        }else {
            return null;
        }


    }
    /**
     * ����id �����������
     * @param noticeId
     * @return
     */
    @Override
    public Notice getNoticeById(int noticeId) {
        return baseDAO.get(Notice.class,noticeId);
    }
    /**
     * ���㹫���ܵļ�¼��
     * @param s_notice
     * @return
     */
    @Override
    public Long getNoticeCount(Notice s_notice) {
            List<Object>param=new LinkedList <>();
            StringBuffer hql=new StringBuffer("select count(*) from Notice");
            if(s_notice!=null){
                if(StringUtil.isNotEmpty(s_notice.getTitle())){
                    hql.append(" and title like ?");
                    param.add("%"+s_notice.getTitle()+"%");
                }
            }
            return (Long)baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
        }


}
