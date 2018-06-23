package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Chair;
import com.zhbit.entity.ForeignCollege;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoChair;
import com.zhbit.service.ChairService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:9:26
 * 描述：
 */
@Service("chairService")
public class ChairServiceImpl implements ChairService {

    private BaseDAO<Chair> chairDAO;
    private BaseDAO<ForeignCollege> foreignCollegeDAO;

    public BaseDAO<Chair> getChairDAO() {
        return chairDAO;
    }
   @Autowired
    public void setChairDAO(BaseDAO<Chair> chairDAO) {
        this.chairDAO = chairDAO;
    }

    public BaseDAO<ForeignCollege> getForeignCollegeDAO() {
        return foreignCollegeDAO;
    }
    @Autowired
    public void setForeignCollegeDAO(BaseDAO<ForeignCollege> foreignCollegeDAO) {
        this.foreignCollegeDAO = foreignCollegeDAO;
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                Chair t = chairDAO.get(Chair.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除讲座id为"+id);
                if (t != null) {
                    chairDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void edit(VoChair voChair) {
        Chair chair = chairDAO.get(Chair.class,voChair.getId());
        if(chair!=null){
            if (StringUtil.isNotEmpty(voChair.getTitle())){
                chair.setTitle(voChair.getTitle());
            }
           if(StringUtil.isNotEmpty(voChair.getContent())){
              chair.setContent(voChair.getContent());
            }
            if (voChair.getForeignCollegeId()>0){
                chair.setForeignCollege(foreignCollegeDAO.get(ForeignCollege.class,voChair.getForeignCollegeId()));
            }
            if(voChair.getActivityTime()!=null){
                chair.setActivityTime(voChair.getActivityTime());
            }
            if(voChair.getVisitTime()!=null){
                chair.setVisitTime(voChair.getVisitTime());
            }
       }
    }

    @Override
    public void add(VoChair voChair) {
        Chair chair = new Chair();
        BeanUtils.copyProperties(voChair,chair);
        chair.setForeignCollege(foreignCollegeDAO.get(ForeignCollege.class,voChair.getForeignCollegeId()));
        chairDAO.save(chair);
    }

    @Override
    public DataGrid dataGrid(VoChair voChair) {
       DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voChair)));
        j.setTotal(total(voChair));
        return  j;
    }
    private List<VoChair> changeModel(List<Chair> tchairs) {
        List<VoChair> voChairs = new ArrayList<VoChair>();
        if (tchairs != null && tchairs.size() > 0) {
            for (Chair tc : tchairs) {
                VoChair vc= new VoChair();
                BeanUtils.copyProperties(tc, vc);
                vc.setForeignCollegeId(tc.getForeignCollege().getId());
                vc.setForeignCollegeName(tc.getForeignCollege().getForeignName());//所属国外院校名称
                voChairs.add(vc);
            }
        }
        return  voChairs;
    }
    public List<Chair> find(VoChair voChair){
        String hql = " from Chair t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voChair, hql, values);

        if (voChair.getSort() != null && voChair.getOrder() != null) {
            hql += " order by " + voChair.getSort() + " " + voChair.getOrder();
        }
        System.out.println("HQL`````````````````````````````:"+hql);
        PageBean pageBean = new PageBean(voChair.getPage(),voChair.getRows());
        return chairDAO.find(hql, values,  pageBean);
    }

    /**
     * 讲座条件查询
     * @param voChair
     * @param hql
     * @param values
     * @return
     */
    private String addWhere(VoChair voChair, String hql, List<Object> values) {

        if (voChair.getForeignCollegeId()>0){
           hql+=" and t.foreignCollege.id = ? ";
           values.add(new Integer(voChair.getForeignCollegeId()));
        }
        if(voChair.getVisitTime()!=null){
            hql+=" and TO_DAYS(t.visitTime)<=TO_DAYS('"+new SimpleDateFormat("yyyy-MM-dd").format(voChair.getVisitTime())+ "') " ;
        }
        if(voChair.getActivityTime()!=null){
            hql+=" and TO_DAYS(t.activityTime)<=TO_DAYS('"+new SimpleDateFormat("yyyy-MM-dd").format(voChair.getActivityTime())+ "') " ;
        }
        System.out.println("HQL`````````````````````````````:"+hql);
        return hql;
    }
    private Long total(VoChair voChair) {
        String hql = "select count(*) from Chair t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voChair, hql, values);
        return chairDAO.count(hql, values);
    }
}
