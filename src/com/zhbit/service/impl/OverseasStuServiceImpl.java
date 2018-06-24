package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.OverSeasStudent;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoOverseasStu;
import com.zhbit.service.OverseasStuService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: ICSystem
 * @ClassName: OverseasStuServiceImpl
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/21 17:00
 */
@Service("overseasStuService")
public class OverseasStuServiceImpl implements OverseasStuService {
    private BaseDAO<OverSeasStudent> baseDAO;

    public BaseDAO<OverSeasStudent> getBaseDAO() {
        return baseDAO;
    }
    @Autowired
    public void setBaseDAO(BaseDAO<OverSeasStudent> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public List<OverSeasStudent> showOverseasStuList(OverSeasStudent overSeasStudent, PageBean pageBean) {
        List<Object>param =new LinkedList<Object>();
        StringBuffer hql=new StringBuffer("from OverSeasStudent ");
        if(overSeasStudent!=null){
            if(StringUtil.isNotEmpty(overSeasStudent.getSchoolName())){
                hql.append(" and schoolName like ?");
                param.add("%"+overSeasStudent.getSchoolName()+"%");
            }
        }
        hql.append("order by id desc");
        if(pageBean!=null){
            System.out.println("sql:"+hql.toString().replaceFirst("and","where"));
            return baseDAO.find(hql.toString().replaceFirst("and","where"),param,pageBean);
        }else {
            return null;
        }
    }

    @Override
    public Long getOverseasStuCount(OverSeasStudent overSeasStudent) {
        List<Object>param=new LinkedList <>();
        StringBuffer hql=new StringBuffer("select count(*) from OverSeasStudent");
        if(overSeasStudent!=null){
            if(StringUtil.isNotEmpty(overSeasStudent.getSchoolName())){
                hql.append(" and schoolName like ?");
                param.add("%"+overSeasStudent.getSchoolName()+"%");
            }
        }
        return (Long)baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
    }

    @Override
    public OverSeasStudent getOverseasStuById(int overSeasStuId) {
        return baseDAO.get(OverSeasStudent.class,overSeasStuId);
    }


    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DataGrid datagrid(VoOverseasStu voOverseasStu) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voOverseasStu)));
        j.setTotal(total(voOverseasStu));
        return j;
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                OverSeasStudent t = baseDAO.get(OverSeasStudent.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除出国生id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void update(VoOverseasStu voOverseasStu) {
        OverSeasStudent t = baseDAO.get(OverSeasStudent.class,voOverseasStu.getId());
        if (t != null) {
            t.setReplaceCourse(voOverseasStu.getReplaceCourse());
            t.setReplaceCredit(voOverseasStu.getReplaceCredit());
            t.setSchoolName(voOverseasStu.getSchoolName());
            t.setSchoolType(voOverseasStu.getSchoolType());
            t.setGoAbroadTime(voOverseasStu.getGoAbroadTime());
            t.setOverSeasName(voOverseasStu.getOverSeasName());
        }
    }

    @Override
    public void add(VoOverseasStu voOverseasStu) {
        OverSeasStudent t = new OverSeasStudent();
        BeanUtils.copyProperties(voOverseasStu, t);
        baseDAO.save(t);
    }

    /**
     * 将OverseasStu转换成VoOverseasStu（视图层模型）
     */
    private List<VoOverseasStu> changeModel(List<OverSeasStudent> overSeasStudentList) {
        List<VoOverseasStu> voOverseasStuList = new ArrayList<VoOverseasStu>();
        if (overSeasStudentList != null && overSeasStudentList.size() > 0) {
            for (OverSeasStudent tn : overSeasStudentList) {
                VoOverseasStu vn= new VoOverseasStu();
                BeanUtils.copyProperties(tn, vn);
                voOverseasStuList.add(vn);
            }
        }
        return voOverseasStuList;
    }

    private List<OverSeasStudent> find(VoOverseasStu voOverseasStu) {
        String hql = " from OverSeasStudent t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voOverseasStu, hql, values);

        if (voOverseasStu.getSort() != null && voOverseasStu.getOrder() != null) {
            hql += " order by " + voOverseasStu.getSort() + " " + voOverseasStu.getOrder();
        }
        PageBean pageBean = new PageBean(voOverseasStu.getPage(),voOverseasStu.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    private String addWhere(VoOverseasStu voOverseasStu, String hql, List<Object> values) {
        return hql;
    }

    /**
     *计算出国生信息条数
     */
    private Long total(VoOverseasStu voOverseasStu) {
        String hql = "select count(*) from OverSeasStudent t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voOverseasStu, hql, values);
        return baseDAO.count(hql, values);
    }
    /**
     * 获取交换生下拉菜单
     * @return
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoOverseasStu> combobox(){
        List<VoOverseasStu> rl = new ArrayList<VoOverseasStu>();
        List<OverSeasStudent> l = baseDAO.find("from OverSeasStudent ");
        if (l != null && l.size() > 0) {
            for (OverSeasStudent t : l) {
                VoOverseasStu r = new VoOverseasStu();
                r.setId(t.getId());
                r.setOverSeasName(t.getOverSeasName());
                rl.add(r);
            }
        }
        return rl;
    }

}
