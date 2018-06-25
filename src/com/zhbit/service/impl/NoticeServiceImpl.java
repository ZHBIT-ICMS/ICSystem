package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Notice;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoNotice;
import com.zhbit.service.NoticeService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 * modified by wenxuan
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService  {
    @Resource
    private BaseDAO<Notice> baseDAO;

    public BaseDAO<Notice> getBaseDAO() {
        return baseDAO;
    }

    public void setBaseDAO(BaseDAO<Notice> baseDAO) {
        this.baseDAO = baseDAO;
    }

    /**
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
     * @param noticeId
     * @return
     */
    @Override
    public Notice getNoticeById(int noticeId) {
        return baseDAO.get(Notice.class,noticeId);
    }
    /**
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

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DataGrid datagrid(VoNotice voNotice) {
        DataGrid j = new DataGrid();
        String where;
        j.setRows(this.changeModel(this.find(voNotice)));
        j.setTotal(total(voNotice));
        return j;
    }

    /**
     *将Notice转换成VoNotice（视图层模型）
     */
    private List<VoNotice> changeModel(List<Notice> noticeList) {
        List<VoNotice> voNoticeList = new ArrayList<VoNotice>();
        if (noticeList != null && noticeList.size() > 0) {
            for (Notice tn : noticeList) {
                VoNotice vn= new VoNotice();
                BeanUtils.copyProperties(tn, vn);
                voNoticeList.add(vn);
            }
        }
        return voNoticeList;
    }

    private List<Notice> find(VoNotice voNotice) {
        String hql = " from Notice t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voNotice, hql, values);

        if (voNotice.getSort() != null && voNotice.getOrder() != null) {
            hql += " order by " + voNotice.getSort() + " " + voNotice.getOrder();
        }
        PageBean pageBean = new PageBean(voNotice.getPage(),voNotice.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    private String addWhere(VoNotice voNotice, String hql, List<Object> values) {
        String where;
        String title=voNotice.getTitle();
        if(title!=null) {
            where = "t.title like '%" + title + "%'";
        }else{
            where=" 1=1";
        }
        hql=hql+where+" ";
        return hql;
    }

    /**
     *计算通知公告信息总数
     */
    private Long total(VoNotice voNotice) {
        String hql = "select count(*) from Notice t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voNotice, hql, values);
        return baseDAO.count(hql, values);
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                Notice t = baseDAO.get(Notice.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除通知公告信息id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }

    }

    //增加通知公告信息
    @Override
    public void add(VoNotice voNotice) {
        if (voNotice.getCreateTime() == null) {
            voNotice.setCreateTime(new Date());
        }
        Notice t = new Notice();
        BeanUtils.copyProperties(voNotice, t);
        baseDAO.save(t);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String getContentById(int id) {
        Notice t = baseDAO.get(Notice.class, id);
        return t.getContent();
    }

    //修改通知公告信息
    @Override
    public void update(VoNotice voNotice) {
        Notice t = baseDAO.get(Notice.class,voNotice.getId());
        if (t != null) {
            t.setTitle(voNotice.getTitle());
            t.setContent(voNotice.getContent());
            t.setCreateTime(new Date());
            t.setPeople(voNotice.getPeople());
        }
    }


}
