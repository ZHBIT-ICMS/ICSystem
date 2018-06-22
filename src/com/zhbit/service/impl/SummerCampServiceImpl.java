package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.ForeignCollege;
import com.zhbit.entity.SummerCamp;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoSummerCamp;
import com.zhbit.service.SummerCampService;
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
 * @Time:22:59
 * @Description描述：
 */
@Service("summerCampService")
public class SummerCampServiceImpl extends BaseServiceImpl implements SummerCampService {

    private BaseDAO<SummerCamp> summerCampDAO;
    private BaseDAO<ForeignCollege> foreignCollegeDAO;

    public BaseDAO<SummerCamp> getSummerCampDAO() {
        return summerCampDAO;
    }
    @Autowired
    public void setSummerCampDAO(BaseDAO<SummerCamp> summerCampDAO) {
        this.summerCampDAO = summerCampDAO;
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
                SummerCamp t = summerCampDAO.get(SummerCamp.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除夏令营活动id为"+id);
                if (t != null) {
                    summerCampDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void edit(VoSummerCamp voSummerCamp) {
        SummerCamp summerCamp = summerCampDAO.get(SummerCamp.class,voSummerCamp.getId());
        if(summerCamp!=null){
            if (voSummerCamp.getForeignCollegeId()>0){
                summerCamp.setForeignCollege(foreignCollegeDAO.get(ForeignCollege.class,voSummerCamp.getForeignCollegeId()));
            }
            if (StringUtil.isNotEmpty(voSummerCamp.getActivityName())){
               summerCamp.setActivityName(voSummerCamp.getActivityName());
            }
            if (StringUtil.isNotEmpty(voSummerCamp.getActivityDesc())){
                summerCamp.setActivityDesc(voSummerCamp.getActivityDesc());
            }
            if (voSummerCamp.getActivityTime()!=null){
                summerCamp.setActivityTime(voSummerCamp.getActivityTime());
            }
        }
    }

    @Override
    public void add(VoSummerCamp voSummerCamp) {
        SummerCamp summerCamp = new SummerCamp();
        BeanUtils.copyProperties(voSummerCamp,summerCamp);
        summerCamp.setForeignCollege(foreignCollegeDAO.get(ForeignCollege.class,voSummerCamp.getForeignCollegeId()));
        summerCampDAO.save(summerCamp);
    }

    @Override
    public DataGrid dataGrid(VoSummerCamp voSummerCamp) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voSummerCamp)));
        j.setTotal(total(voSummerCamp));
        return  j;
    }

    /**
     *
     * @param tsummerCamps
     * @return
     */
    private List<VoSummerCamp> changeModel(List<SummerCamp> tsummerCamps) {
        List<VoSummerCamp> vsummerCamps = new ArrayList<VoSummerCamp>();
        if (tsummerCamps != null && tsummerCamps.size() > 0) {
            for (SummerCamp ts : tsummerCamps) {
                VoSummerCamp vs= new VoSummerCamp();
                BeanUtils.copyProperties(ts, vs);
                vs.setForeignCollegeId(ts.getForeignCollege().getId());
                vs.setForeignCollegeName(ts.getForeignCollege().getForeignName());
                vsummerCamps.add(vs);
            }
        }
        return vsummerCamps;
    }

    /**
     *
     * @param voSummerCamp
     * @return
     */
    public List<SummerCamp> find(VoSummerCamp voSummerCamp){
        String hql = " from SummerCamp t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voSummerCamp, hql, values);

        if (voSummerCamp.getSort() != null && voSummerCamp.getOrder() != null) {
            hql += " order by " + voSummerCamp.getSort() + " " + voSummerCamp.getOrder();
        }
        PageBean pageBean = new PageBean(voSummerCamp.getPage(),voSummerCamp.getRows());
        return summerCampDAO.find(hql, values,  pageBean);
    }
    private Long total(VoSummerCamp voSummerCamp) {
        String hql = "select count(*) from SummerCamp t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voSummerCamp, hql, values);
        return summerCampDAO.count(hql, values);
    }

    private String addWhere(VoSummerCamp voSummerCamp, String hql, List<Object> values) {
        if (voSummerCamp.getForeignCollegeId()>0){
            hql+=" and t.foreignCollege.id = ? ";
            values.add(new Integer(voSummerCamp.getForeignCollegeId()));
        }
        if (voSummerCamp.getActivityTime()!=null){
            hql+=" and TO_DAYS(t.activityTime)<=TO_DAYS('"+new SimpleDateFormat("yyyy-MM-dd").format(voSummerCamp.getActivityTime())+ "') " ;
        }
        return hql;
    }


    /**
     * 获取夏令营活动下拉菜单
     * @return
     */
    @Override
    public List<VoSummerCamp> combobox() {
        List<VoSummerCamp> rl = new ArrayList<VoSummerCamp>();
        List<SummerCamp> l = summerCampDAO.find("from SummerCamp ");
        if (l != null && l.size() > 0) {
            for (SummerCamp t : l) {
                VoSummerCamp r = new VoSummerCamp();
                r.setId(t.getId());
                r.setActivityName(t.getActivityName());
                rl.add(r);
            }
        }
        return rl;
    }
}
