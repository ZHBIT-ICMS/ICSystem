package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoCollegeInfo;
import com.zhbit.service.CollegeInfoService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:58
 * 描述：
 */
@Service("collegeInfoService")
public class CollegeInfoServiceImpl extends BaseServiceImpl implements CollegeInfoService {

    private BaseDAO<CollegeInfo> collegeInfoDAO;

    public BaseDAO<CollegeInfo> getCollegeInfoDAO() {
        return collegeInfoDAO;
    }
   @Autowired
    public void setCollegeInfoDAO(BaseDAO<CollegeInfo> collegeInfoDAO) {
        this.collegeInfoDAO = collegeInfoDAO;
    }

    /**
     * 返回easyUI所需的datagrid
     * @param voCollegeInfo
     * @return
     */
    @Override
    public DataGrid datagrid(VoCollegeInfo voCollegeInfo) {
       DataGrid j = new DataGrid();
       j.setRows(this.changeModel(this.find(voCollegeInfo)));
       j.setTotal(total(voCollegeInfo));
        return j;
    }
    private Long total(VoCollegeInfo voCollegeInfo){
        String hql = "select count(*) from CollegeInfo t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voCollegeInfo, hql, values);
        return collegeInfoDAO.count(hql, values);
    }

    /**
     * 将CollegeInfo（持久对象）转换成VoCollegeInfo（视图对象）
     * @param collegeInfos
     * @return
     */
    private List<VoCollegeInfo> changeModel(List<CollegeInfo> collegeInfos){
        List<VoCollegeInfo> voCollegeInfos = new ArrayList<VoCollegeInfo>();
        if (collegeInfos!=null&&collegeInfos.size()>0){
            for(CollegeInfo tc : collegeInfos){
                VoCollegeInfo vc = new VoCollegeInfo();
                BeanUtils.copyProperties(tc,vc);
                voCollegeInfos.add(vc);
            }
        }
        return voCollegeInfos;
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                CollegeInfo t = collegeInfoDAO.get(CollegeInfo.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除学院id为"+id);
                if (t != null) {
                    collegeInfoDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void add(VoCollegeInfo voCollegeInfo) {

        CollegeInfo collegeInfo = new CollegeInfo();
        BeanUtils.copyProperties(voCollegeInfo,collegeInfo);
        collegeInfoDAO.save(collegeInfo);
    }

    @Override
    public void edit(VoCollegeInfo voCollegeInfo) {
        CollegeInfo collegeInfo = collegeInfoDAO.get(CollegeInfo.class,voCollegeInfo.getId());
        if(collegeInfo!=null){
            collegeInfo.setCollegeName(voCollegeInfo.getCollegeName());
            collegeInfo.setDescInfo(voCollegeInfo.getDescInfo());
        }
    }

    /**
     *
     * @param voCollegeInfo
     * @return
     */
    private List<CollegeInfo> find(VoCollegeInfo voCollegeInfo){
        String hql = " from CollegeInfo where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voCollegeInfo,hql,values);
        if(voCollegeInfo.getSort()!=null && voCollegeInfo.getOrder()!=null){
            hql += " order by " + voCollegeInfo.getSort()+" "+voCollegeInfo.getOrder();
        }
        PageBean pageBean = new PageBean(voCollegeInfo.getPage(),voCollegeInfo.getRows());
        return collegeInfoDAO.find(hql,values,pageBean);
    }

    /**
     * 获取学院下拉菜单
     * @return
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoCollegeInfo> combobox(){
        List<VoCollegeInfo> rl = new ArrayList<VoCollegeInfo>();
        List<CollegeInfo> l = collegeInfoDAO.find("from CollegeInfo ");
        if (l != null && l.size() > 0) {
            for (CollegeInfo t : l) {
                VoCollegeInfo r = new VoCollegeInfo();
                r.setId(t.getId());
                r.setCollegeName(t.getCollegeName());
                rl.add(r);
            }
        }
        return rl;
    }

    /**
     * 条件查询
     * @param voCollegeInfo
     * @param hql
     * @param values
     * @return
     */
    private String addWhere(VoCollegeInfo voCollegeInfo,String hql,List<Object> values){
      return  hql;
    }


}
