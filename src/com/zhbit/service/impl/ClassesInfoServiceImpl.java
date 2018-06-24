package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.ClassesInfo;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoClassesInfo;
import com.zhbit.exception.ValidateFieldsException;
import com.zhbit.service.ClassesInfoService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/19
 * @Time:23:06
 * 描述：
 */
@Service("classesInfoService")
public class ClassesInfoServiceImpl extends BaseServiceImpl implements ClassesInfoService{
    private BaseDAO<ClassesInfo> classesInfoDAO;
    private BaseDAO<CollegeInfo> collegeInfoDAO;

    public BaseDAO<ClassesInfo> getClassesInfoDAO() {
        return classesInfoDAO;
    }
    @Autowired
    public void setClassesInfoDAO(BaseDAO<ClassesInfo> classesInfoDAO) {
        this.classesInfoDAO = classesInfoDAO;
    }

    public BaseDAO<CollegeInfo> getCollegeInfoDAO() {
        return collegeInfoDAO;
    }
    @Autowired
    public void setCollegeInfoDAO(BaseDAO<CollegeInfo> collegeInfoDAO) {
        this.collegeInfoDAO = collegeInfoDAO;
    }

    /**
     * 班级删除
     * @param ids
     */
    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                ClassesInfo t = classesInfoDAO.get(ClassesInfo.class,Integer.parseInt(id));
                t.getCollegeInfo().getClassesInfoList().remove(t);
                t.setCollegeInfo(null);
                System.out.println("```````````````````````````````删除班级id为"+id);
                if (t != null) {
                    classesInfoDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void edit(VoClassesInfo voClassesInfo)throws ValidateFieldsException  {

        ClassesInfo classesInfo = classesInfoDAO.get(ClassesInfo.class,voClassesInfo.getId());
        if (voClassesInfo.getClassNo().equals(classesInfo.getClassNo())||isUnqiueClassesInfo(voClassesInfo.getClassNo())){
            if(classesInfo!=null){
                if (StringUtil.isNotEmpty(voClassesInfo.getDescInfo())){
                    classesInfo.setDescInfo(voClassesInfo.getDescInfo());
                }
                if (voClassesInfo.getCollegeId()>0){
                    classesInfo.setCollegeInfo(collegeInfoDAO.get(CollegeInfo.class,voClassesInfo.getCollegeId()));
                }
                if (StringUtil.isNotEmpty(voClassesInfo.getClassNo())){
                    classesInfo.setClassNo(voClassesInfo.getClassNo());
                }
            }
        }else {
            throw  new ValidateFieldsException("该班级号已存在，请重新输入！");
        }

    }

    /**
     * 班级添加
     * @param voClassesInfo
     */
    @Override
    public void add(VoClassesInfo voClassesInfo) throws ValidateFieldsException {
      if (!isUnqiueClassesInfo(voClassesInfo.getClassNo())){
          throw  new ValidateFieldsException("该班级号已存在，请重新输入！");
      }
        ClassesInfo classesInfo = new ClassesInfo();
        BeanUtils.copyProperties(voClassesInfo,classesInfo);
        classesInfo.setCollegeInfo(collegeInfoDAO.get(CollegeInfo.class,voClassesInfo.getCollegeId()));
        classesInfoDAO.save(classesInfo);
    }

    @Override
    public DataGrid dataGrid(VoClassesInfo voClassesInfo) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voClassesInfo)));
        j.setTotal(total(voClassesInfo));
        return  j;
    }

    /**
     * 将ClassesInfo（持久化模型）转换成VoClassesInfo（视图层模型）
     * @param tclassesInfos
     * @return
     */
    private List<VoClassesInfo> changeModel(List<ClassesInfo> tclassesInfos) {
        List<VoClassesInfo> vclassesInfos = new ArrayList<VoClassesInfo>();
        if (tclassesInfos != null && tclassesInfos.size() > 0) {
            for (ClassesInfo tc : tclassesInfos) {
                VoClassesInfo vc= new VoClassesInfo();
                BeanUtils.copyProperties(tc, vc);
                vc.setCollegeId(tc.getCollegeInfo().getId());
                vc.setCollegeName(tc.getCollegeInfo().getCollegeName());//所属学院名称
                vc.setStudentTotal(tc.getStudentList().size());//班级人数
                vclassesInfos.add(vc);
            }
        }
        return vclassesInfos;
    }

    /**
     *
     * @param voClassesInfo
     * @return
     */
    public List<ClassesInfo> find(VoClassesInfo voClassesInfo){
        String hql = " from ClassesInfo t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voClassesInfo, hql, values);

        if (voClassesInfo.getSort() != null && voClassesInfo.getOrder() != null) {
            hql += " order by " + voClassesInfo.getSort() + " " + voClassesInfo.getOrder();
        }
        PageBean pageBean = new PageBean(voClassesInfo.getPage(),voClassesInfo.getRows());
        return classesInfoDAO.find(hql, values,  pageBean);
    }

    /**
     * 返回班级总数
     * @param voClassesInfo
     * @return
     */
    private Long total(VoClassesInfo voClassesInfo) {
        String hql = "select count(*) from ClassesInfo t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voClassesInfo, hql, values);
        return classesInfoDAO.count(hql, values);
    }

    /**
     * 班级条件查询
     * @param voClassesInfo
     * @param hql
     * @param values
     * @return
     */
    private String addWhere(VoClassesInfo voClassesInfo, String hql, List<Object> values) {
        return hql;
    }

    /**
     * 判断班级号是否唯一
     * @param classNo
     * @return
     */
    public boolean isUnqiueClassesInfo(String classNo){
        ClassesInfo classesInfo = null;
        if (StringUtil.isNotEmpty(classNo)){
            classesInfo=this.classesInfoDAO.get(" from ClassesInfo c where c.classNo = ? ",new String[]{classNo});
            if (classesInfo==null){
                return  true;
            }
        }
        return false;
    }
    @Override
    public List<VoClassesInfo> combobox() {
        List<VoClassesInfo> rl = new ArrayList<VoClassesInfo>();
        List<ClassesInfo> l = classesInfoDAO.find("from ClassesInfo ");
        if (l != null && l.size() > 0) {
            for (ClassesInfo t : l) {
                VoClassesInfo r = new VoClassesInfo();
                r.setId(t.getId());
                r.setDescInfo(t.getDescInfo());
                rl.add(r);
            }
        }
        return rl;
    }
}
