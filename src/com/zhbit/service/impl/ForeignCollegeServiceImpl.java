package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.ForeignCollege;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoForeignCollege;
import com.zhbit.service.ForeignCollegeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/20
 * @Time:22:24 描述：
 */
@Service("foreignCollegeService")
public class ForeignCollegeServiceImpl implements ForeignCollegeService {

   private BaseDAO<ForeignCollege> foreignCollegeDAO;

    public BaseDAO<ForeignCollege> getForeignCollegeDAO() {
        return foreignCollegeDAO;
    }
    @Autowired
    public void setForeignCollegeDAO(BaseDAO<ForeignCollege> foreignCollegeDAO) {
        this.foreignCollegeDAO = foreignCollegeDAO;
    }

    @Override
    public DataGrid datagrid(VoForeignCollege voForeignCollege) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voForeignCollege)));
        j.setTotal(total(voForeignCollege));
        return j;
    }

    /**
     * ForeignCollege（持久对象）转换成VoForeignCollege（视图对象）
     * @param foreignColleges
     * @return
     */
    private List<VoForeignCollege> changeModel(List<ForeignCollege> foreignColleges){
        List<VoForeignCollege> voForeignColleges = new ArrayList<VoForeignCollege>();
        if (foreignColleges!=null&&foreignColleges.size()>0){
            for(ForeignCollege tc : foreignColleges){
                VoForeignCollege vc = new VoForeignCollege();
                BeanUtils.copyProperties(tc,vc);
                voForeignColleges.add(vc);
            }
        }
        return voForeignColleges;
    }

    /**
     * 得到ForeignCollege的list集合
     * @param voForeignCollege
     * @return
     */
    private List<ForeignCollege> find(VoForeignCollege voForeignCollege){
        String hql = " from ForeignCollege where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voForeignCollege,hql,values);
        if(voForeignCollege.getSort()!=null && voForeignCollege.getOrder()!=null){
            hql += " order by " + voForeignCollege.getSort()+" "+voForeignCollege.getOrder();
        }
        PageBean pageBean = new PageBean(voForeignCollege.getPage(),voForeignCollege.getRows());
        return foreignCollegeDAO.find(hql,values,pageBean);
    }

    /**
     * 计算国外院校总数（含条件查询）
     * @param voForeignCollege
     * @return
     */
    private Long total(VoForeignCollege voForeignCollege){
        String hql = "select count(*) from ForeignCollege t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voForeignCollege, hql, values);
        return foreignCollegeDAO.count(hql, values);
    }


    /**
     * 删除国外院校
     * @param ids
     */
    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                ForeignCollege t = foreignCollegeDAO.get(ForeignCollege.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除学院id为"+id);
                if (t != null) {
                    foreignCollegeDAO.delete(t);
                }
            }
        }
    }

    /**
     * 增加国外院校
     * @param voForeignCollege
     */
    @Override
    public void add(VoForeignCollege voForeignCollege) {
      ForeignCollege foreignCollege = new ForeignCollege();
        BeanUtils.copyProperties(voForeignCollege,foreignCollege);
        foreignCollegeDAO.save(foreignCollege);
    }

    /**
     * 编辑国外院校信息
     * @param voForeignCollege
     */
    @Override
    public void edit(VoForeignCollege voForeignCollege) {
        ForeignCollege foreignCollege = foreignCollegeDAO.get(ForeignCollege.class,voForeignCollege.getId());
        if(foreignCollege!=null){
            foreignCollege.setForeignName(voForeignCollege.getForeignName());
            foreignCollege.setForeignType(voForeignCollege.getForeignType());
            foreignCollege.setStat(voForeignCollege.getStat());
        }
    }

    /**
     * 国外院校下拉菜单
     * @return
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoForeignCollege> combobox() {
        List<VoForeignCollege> rl = new ArrayList<VoForeignCollege>();
        List<ForeignCollege> l = foreignCollegeDAO.find(" from ForeignCollege ");
        if (l != null && l.size() > 0) {
            for (ForeignCollege t : l) {
                VoForeignCollege r = new VoForeignCollege();
                r.setId(t.getId());
                r.setForeignName(t.getForeignName());
                rl.add(r);
            }
        }
        return rl;
    }

    /**
     * 条件查询
     * @param voForeignCollege
     * @param hql
     * @param values
     * @return
     */
    private String addWhere(VoForeignCollege voForeignCollege,String hql,List<Object> values){
        return  hql;
    }
}
