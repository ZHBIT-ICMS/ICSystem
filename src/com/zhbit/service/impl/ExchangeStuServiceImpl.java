package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.ExchangeStudent;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoExchangeStu;
import com.zhbit.service.ExchangeStuService;
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
 * @ClassName: ExchangeStuServiceImpl
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/20 10:53
 */
@Service("exchangeStuService")
public class ExchangeStuServiceImpl implements ExchangeStuService {
    private BaseDAO<ExchangeStudent> baseDAO;

    public BaseDAO<ExchangeStudent> getBaseDAO() {
        return baseDAO;
    }
   @Autowired
    public void setBaseDAO(BaseDAO<ExchangeStudent> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public List<ExchangeStudent> showExchangeStuList(ExchangeStudent exchangeStudent, PageBean pageBean) {
        List<Object>param =new LinkedList<Object>();
        StringBuffer hql=new StringBuffer("from ExchangeStudent ");
        if(exchangeStudent!=null){
            if(StringUtil.isNotEmpty(exchangeStudent.getSchoolName())){
                hql.append(" and schoolName like ?");
                param.add("%"+exchangeStudent.getSchoolName()+"%");
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
    public Long getExchangeStuCount(ExchangeStudent exchangeStudent) {
        List<Object>param=new LinkedList <>();
        StringBuffer hql=new StringBuffer("select count(*) from ExchangeStudent");
        if(exchangeStudent!=null){
            if(StringUtil.isNotEmpty(exchangeStudent.getSchoolName())){
                hql.append(" and schoolName like ?");
                param.add("%"+exchangeStudent.getSchoolName()+"%");
            }
        }
        return (Long)baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
    }

    @Override
    public ExchangeStudent getExchangeStuById(int exchangeStuId) {
        return baseDAO.get(ExchangeStudent.class,exchangeStuId);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DataGrid datagrid(VoExchangeStu voExchangeStu) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voExchangeStu)));
        j.setTotal(total(voExchangeStu));
        return j;
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                ExchangeStudent t = baseDAO.get(ExchangeStudent.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除交换生id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void update(VoExchangeStu voExchangeStu) {
        ExchangeStudent t = baseDAO.get(ExchangeStudent.class,voExchangeStu.getId());
        if (t != null) {
            t.setReplaceCourse(voExchangeStu.getReplaceCourse());
            t.setReplaceCredit(voExchangeStu.getReplaceCredit());
            t.setSchoolName(voExchangeStu.getSchoolName());
            t.setSchoolType(voExchangeStu.getSchoolType());
            t.setGoAbroadTime(voExchangeStu.getGoAbroadTime());
            t.setExchangeName(voExchangeStu.getExchangeName());
        }
    }

    @Override
    public void add(VoExchangeStu voExchangeStu) {
        ExchangeStudent t = new ExchangeStudent();
        BeanUtils.copyProperties(voExchangeStu, t);
        baseDAO.save(t);
    }

    /**
     * 将ExchangeStu转换成VoExchangeStu（视图层模型）
     */
    private List<VoExchangeStu> changeModel(List<ExchangeStudent> exchangeStudentList) {
        List<VoExchangeStu> voExchangeStuList = new ArrayList<VoExchangeStu>();
        if (exchangeStudentList != null && exchangeStudentList.size() > 0) {
            for (ExchangeStudent tn : exchangeStudentList) {
                VoExchangeStu vn= new VoExchangeStu();
                BeanUtils.copyProperties(tn, vn);
                voExchangeStuList.add(vn);
            }
        }
        return voExchangeStuList;
    }

    private List<ExchangeStudent> find(VoExchangeStu voExchangeStu) {
        String hql = " from ExchangeStudent t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voExchangeStu, hql, values);

        if (voExchangeStu.getSort() != null && voExchangeStu.getOrder() != null) {
            hql += " order by " + voExchangeStu.getSort() + " " + voExchangeStu.getOrder();
        }
        PageBean pageBean = new PageBean(voExchangeStu.getPage(),voExchangeStu.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    private String addWhere(VoExchangeStu voExchangeStu, String hql, List<Object> values) {
        return hql;
    }

    /**
     *计算交换生信息条数
     */
    private Long total(VoExchangeStu voExchangeStu) {
        String hql = "select count(*) from ExchangeStudent t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voExchangeStu, hql, values);
        return baseDAO.count(hql, values);
    }

    /**
     * 获取交换生下拉菜单
     * @return
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoExchangeStu> combobox(){
        List<VoExchangeStu> rl = new ArrayList<VoExchangeStu>();
        List<ExchangeStudent> l = baseDAO.find("from ExchangeStudent es where es.studentList is empty ");
        if (l != null && l.size() > 0) {
            for (ExchangeStudent t : l) {
                VoExchangeStu r = new VoExchangeStu();
                r.setId(t.getId());
                r.setExchangeName(t.getExchangeName());
                rl.add(r);
            }
        }
        return rl;
    }
}
