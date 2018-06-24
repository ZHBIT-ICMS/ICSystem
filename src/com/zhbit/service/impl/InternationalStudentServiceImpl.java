package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.*;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoInternationalStudent;
import com.zhbit.exception.ValidateFieldsException;
import com.zhbit.service.InternationalStudentService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/23
 * @Time:17:07
 * @Description：
 * 国际班学生服务接口实现类
 */
@Service("internationalStudentService")
public class InternationalStudentServiceImpl extends BaseServiceImpl implements InternationalStudentService {

    private BaseDAO<InternationalStudent> internationalStudentDAO;
    private BaseDAO<SummerCamp> summerCampDAO;
    private BaseDAO<OverSeasStudent> overSeasStudentDAO;
    private BaseDAO<ExchangeStudent> exchangeStudentDAO;
    private BaseDAO<InterStuExam> interStuExamDAO;

    private BaseDAO<InterStuTrain> interStuTrainDAO;

    private BaseDAO<ClassesInfo> classesInfoDAO;
    private BaseDAO<InterStuSummerCamp> interStuSummerCampDAO;
    private BaseDAO<IELTSTrain> ieltsTrainDAO;
    private BaseDAO<IELTSExam> ieltsExamDAO;


    public BaseDAO<InternationalStudent> getInternationalStudentDAO() {
        return internationalStudentDAO;
    }
    @Autowired
    public void setInternationalStudentDAO(BaseDAO<InternationalStudent> internationalStudentDAO) {
        this.internationalStudentDAO = internationalStudentDAO;
    }

    public BaseDAO<SummerCamp> getSummerCampDAO() {
        return summerCampDAO;
    }
    @Autowired
    public void setSummerCampDAO(BaseDAO<SummerCamp> summerCampDAO) {
        this.summerCampDAO = summerCampDAO;
    }

    public BaseDAO<OverSeasStudent> getOverSeasStudentDAO() {
        return overSeasStudentDAO;
    }
    @Autowired
    public void setOverSeasStudentDAO(BaseDAO<OverSeasStudent> overSeasStudentDAO) {
        this.overSeasStudentDAO = overSeasStudentDAO;
    }

    public BaseDAO<ExchangeStudent> getExchangeStudentDAO() {
        return exchangeStudentDAO;
    }
    @Autowired
    public void setExchangeStudentDAO(BaseDAO<ExchangeStudent> exchangeStudentDAO) {
        this.exchangeStudentDAO = exchangeStudentDAO;
    }

    public BaseDAO<InterStuExam> getInterStuExamDAO() {
        return interStuExamDAO;
    }
    @Autowired
    public void setInterStuExamDAO(BaseDAO<InterStuExam> interStuExamDAO) {
        this.interStuExamDAO = interStuExamDAO;
    }

    public BaseDAO<InterStuTrain> getInterStuTrainDAO() {
        return interStuTrainDAO;
    }
    @Autowired
    public void setInterStuTrainDAO(BaseDAO<InterStuTrain> interStuTrainDAO) {
        this.interStuTrainDAO = interStuTrainDAO;
    }

    public BaseDAO<ClassesInfo> getClassesInfoDAO() {
        return classesInfoDAO;
    }
    @Autowired
    public void setClassesInfoDAO(BaseDAO<ClassesInfo> classesInfoDAO) {
        this.classesInfoDAO = classesInfoDAO;
    }

    public BaseDAO<InterStuSummerCamp> getInterStuSummerCampDAO() {
        return interStuSummerCampDAO;
    }
    @Autowired
    public void setInterStuSummerCampDAO(BaseDAO<InterStuSummerCamp> interStuSummerCampDAO) {
        this.interStuSummerCampDAO = interStuSummerCampDAO;
    }

    public BaseDAO<IELTSTrain> getIeltsTrainDAO() {
        return ieltsTrainDAO;
    }
    @Autowired
    public void setIeltsTrainDAO(BaseDAO<IELTSTrain> ieltsTrainDAO) {
        this.ieltsTrainDAO = ieltsTrainDAO;
    }

    public BaseDAO<IELTSExam> getIeltsExamDAO() {
        return ieltsExamDAO;
    }
    @Autowired
    public void setIeltsExamDAO(BaseDAO<IELTSExam> ieltsExamDAO) {
        this.ieltsExamDAO = ieltsExamDAO;
    }

    @Override
    public void save(VoInternationalStudent voInternationalStudent) throws ValidateFieldsException {
          InternationalStudent iStu = new InternationalStudent();
          if (!isUniqueIntStu(voInternationalStudent.getStuId())){
                  throw new ValidateFieldsException("该学号已存在，请重新输入！");
          }
          //复制了id、stuId、name、status、major
          BeanUtils.copyProperties(voInternationalStudent,iStu);

         if (voInternationalStudent.getClassInfoId()>0){
             iStu.setClassInfo(classesInfoDAO.get(ClassesInfo.class,voInternationalStudent.getClassInfoId()));
         }
         if (voInternationalStudent.getExchangeStudentId()>0){
             iStu.setExchangeStudent(exchangeStudentDAO.get(ExchangeStudent.class,voInternationalStudent.getExchangeStudentId()));
         }
         if (voInternationalStudent.getOverSeasStudentId()>0){
             iStu.setOverSeasStudent(overSeasStudentDAO.get(OverSeasStudent.class,voInternationalStudent.getOverSeasStudentId()));
         }
         internationalStudentDAO.save(iStu);
         this.saveBatchIntlStuAndSummerCamp(voInternationalStudent,iStu,false);
         this.saveBatchIntlStuAndIeltsTrain(voInternationalStudent,iStu,false);
         this.saveBatchIntStuAndIeltsExam(voInternationalStudent,iStu,false);

    }

    /**
     * 批量保存国际班学生与夏令营活动的关系
     * @param vs
     * @param ts
     * @param sign true为批量保存 false为非批量
     */
    public void saveBatchIntlStuAndSummerCamp(VoInternationalStudent vs,InternationalStudent ts,boolean sign){
        if (sign){
            System.out.println("`````````````````BatchSaveIntlStuAndSummerCamp批量InternationalStudentId:"+ts.getId());
            if (vs.getSummerCampIds()!=null){
                for (String id:vs.getSummerCampIds().split(",")){
                    if (interStuSummerCampDAO.get(" from InterStuSummerCamp as t where t.internationalStudent = ? and t.summerCamp = ? ",new Object[]{ts,summerCampDAO.get(SummerCamp.class,Integer.parseInt(id.trim()))})!=null){
                        continue;
                    }
                    InterStuSummerCamp interStuSummerCamp = new InterStuSummerCamp();
                    interStuSummerCamp.setSummerCamp(summerCampDAO.get(SummerCamp.class,Integer.parseInt(id.trim())));
                    interStuSummerCamp.setInternationalStudent(ts);
                    interStuSummerCampDAO.save(interStuSummerCamp);
                }
            }
        }else {
            System.out.println("`````````````````BatchSaveIntlStuAndSummerCamp非批量InternationalStudentId:"+ts.getId());
            interStuSummerCampDAO.executeHql("delete InterStuSummerCamp as t  where t.internationalStudent = ? ",new Object[]{ts});
            if (vs.getSummerCampIds()!=null){
                for (String id:vs.getSummerCampIds().split(",")){
                    InterStuSummerCamp issc = new InterStuSummerCamp();
                    issc.setSummerCamp(summerCampDAO.get(SummerCamp.class,Integer.parseInt(id.trim())));
                    issc.setInternationalStudent(ts);
                    interStuSummerCampDAO.save(issc);
                }
            }
        }

    }

    /**
     * 批量保存国际班学生与雅思培训的关系
     * @param vs
     * @param ts
     * @param sign true为批量保存 false为非批量
     */
    public void saveBatchIntlStuAndIeltsTrain(VoInternationalStudent vs,InternationalStudent ts, boolean sign){
        if (sign){
            System.out.println("`````````````````BatchSaveIntlStuAndIeltsTrain批量InternationalStudentId:"+ts.getId());
            if (vs.getIeltsTrainIds()!=null){
                for (String id:vs.getIeltsTrainIds().split(",")){
                    System.out.println("```````````````````培训的id:"+id+" 国际班学生id："+ts.getId());
                    if (interStuTrainDAO.get(" from InterStuTrain as t  where t.internationalStudent = ? and t.ieltsTrain = ? ",new Object[]{ts,ieltsTrainDAO.get(IELTSTrain.class,Integer.parseInt(id.trim()))})!=null){
                        continue;
                    }
                    InterStuTrain interStuTrain = new InterStuTrain();
                    interStuTrain.setIeltsTrain(ieltsTrainDAO.get(IELTSTrain.class,Integer.parseInt(id.trim())));
                    interStuTrain.setInternationalStudent(ts);
                    interStuTrainDAO.save(interStuTrain);
                }
            }
        }else {
            System.out.println("`````````````````BatchSaveIntlStuAndIeltsTrain非批量InternationalStudentId:"+ts.getId());
            interStuTrainDAO.executeHql(" delete InterStuTrain as t where t.internationalStudent = ? ",new Object[]{ts});
            if (vs.getIeltsTrainIds()!=null){
                for (String id:vs.getIeltsTrainIds().split(",")){
                    InterStuTrain interStuTrain = new InterStuTrain();
                    interStuTrain.setIeltsTrain(ieltsTrainDAO.get(IELTSTrain.class,Integer.parseInt(id.trim())));
                    interStuTrain.setInternationalStudent(ts);
                    interStuTrainDAO.save(interStuTrain);
                }
            }
        }


    }

    /**
     * 批量保存国际班学生与雅思考试的关系
     * @param vs
     * @param ts
     * @param sign true为批量保存 false为非批量
     */
    public void saveBatchIntStuAndIeltsExam(VoInternationalStudent vs,InternationalStudent ts,boolean sign){
       if (sign){//批量保存
           System.out.println("`````````````````BatchSaveIntStuAndIeltsExam批量InternationalStudentId:"+ts.getId());
           if (vs.getIeltsExamIds()!=null){
               for (String id:vs.getIeltsExamIds().split(",")){
                   if (interStuExamDAO.get(" from InterStuExam as t where t.internationalStudent = ? and t.ieltsExam = ? ",new Object[]{ts,ieltsExamDAO.get(IELTSExam.class,Integer.parseInt(id.trim()))})!=null){
                       continue;
                   }
                   InterStuExam interStuExam = new InterStuExam();
                   interStuExam.setIeltsExam(ieltsExamDAO.get(IELTSExam.class,Integer.parseInt(id.trim())));
                   interStuExam.setInternationalStudent(ts);
                   interStuExamDAO.save(interStuExam);
               }
           }
       }else {//非批量保存
           System.out.println("`````````````````BatchSaveIntStuAndIeltsExam非批量InternationalStudentId:" + ts.getId());
           interStuExamDAO.executeHql("delete InterStuExam as t where t.internationalStudent = ? ", new Object[]{ts});
           if (vs.getIeltsExamIds() != null) {
               for (String id : vs.getIeltsExamIds().split(",")) {
                   InterStuExam interStuExam = new InterStuExam();
                   interStuExam.setIeltsExam(ieltsExamDAO.get(IELTSExam.class,Integer.parseInt(id.trim())));
                   interStuExam.setInternationalStudent(ts);
                   interStuExamDAO.save(interStuExam);
               }
           }
       }
    }
    /**
     * 判断学号是否唯一
     * @param stuId
     * @return
     */
   private boolean isUniqueIntStu(String stuId){
       InternationalStudent ti = null;
       if (StringUtil.isNotEmpty(stuId)){
           //获取一条记录
           ti=this.internationalStudentDAO.get("from InternationalStudent stu where stu.stuId = ?",new String[]{stuId});
           if(ti==null){
               return  true;
           }
       }
       return false;
   }
    @Override
    public DataGrid dataGrid(VoInternationalStudent voInternationalStudent) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voInternationalStudent)));
        j.setTotal(this.total(voInternationalStudent));
       return j;
    }

    /**
     *
     * @param intlStus
     * @return
     */
   public List<VoInternationalStudent> changeModel(List<InternationalStudent> intlStus){
       List<VoInternationalStudent> voIntlStus = new ArrayList<VoInternationalStudent>();
       if (intlStus!=null&&intlStus.size()>0){
           for (InternationalStudent ts :intlStus){
               VoInternationalStudent vs = new VoInternationalStudent();
               BeanUtils.copyProperties(ts,vs);
               vs.setClassInfoId(ts.getClassInfo().getId());
               vs.setClassInfoName(ts.getClassInfo().getDescInfo());
               if (ts.getExchangeStudent()!=null){
                   vs.setExchangeStudentId(ts.getExchangeStudent().getId());
                   vs.setExchangeStudentName(ts.getExchangeStudent().getExchangeName());
               }
               if (ts.getOverSeasStudent()!=null){
                   vs.setOverSeasStudentId(ts.getOverSeasStudent().getId());
                   vs.setOverSeasStudentName(ts.getOverSeasStudent().getOverSeasName());
               }
               //
               String summerCampIds ="";
               String summerCampNames="";
               String ieltsExamIds="";
               String ieltsExamNames="";
               String ieltsTrainIds="";
               String ieltsTrainNames="";
               boolean b1=false,b2=false,b3 =false;
               List<InterStuSummerCamp> ISSCList = ts.getInterStuSummerCampList();
               if (ISSCList!=null&&ISSCList.size()>0){
                   for (InterStuSummerCamp issc : ISSCList){
                       if (issc.getSummerCamp()!=null){
                           if (b1){
                               summerCampIds+=",";
                               summerCampNames+=",";
                           }
                           summerCampIds+=issc.getSummerCamp().getId();
                           summerCampNames+=issc.getSummerCamp().getActivityName();
                           b1=true;
                       }
                   }
               }
               vs.setSummerCampIds(summerCampIds);
               vs.setSummerCampNames(summerCampNames);
               //
               List<InterStuExam> ISEList =ts.getInterStuExamList();
               if (ISEList!=null&&ISEList.size()>0){
                   for (InterStuExam ise:ISEList){
                       if (ise.getIeltsExam()!=null){
                           if (b2){
                               ieltsExamIds+=",";
                               ieltsExamNames+=",";
                           }
                           ieltsExamIds+=ise.getIeltsExam().getId();
                           ieltsExamNames+=ise.getIeltsExam().getExamId();
                           b2=true;
                       }
                   }
               }
               System.out.println("··················ieltsExamNames："+ieltsExamNames);
               vs.setIeltsExamIds(ieltsExamIds);
               vs.setIeltsExamNames(ieltsExamNames);

               List<InterStuTrain> ISTList = ts.getInterStuTrainList();
               if (ISTList!=null&&ISEList.size()>0){
                   for (InterStuTrain ist:ISTList){
                       if (ist.getIeltsTrain()!=null){
                           if (b3){
                               ieltsTrainIds+=",";
                               ieltsTrainNames+=",";
                           }
                           ieltsTrainIds+=ist.getIeltsTrain().getId();
                           ieltsTrainNames+=ist.getIeltsTrain().getIeltsTrainId();
                           b3=true;
                       }
                   }
               }
               System.out.println("··················ieltsTrainNames："+ieltsTrainNames);
               vs.setIeltsTrainIds(ieltsTrainIds);
               vs.setIeltsTrainNames(ieltsTrainNames);
               voIntlStus.add(vs);
           }
       }
       return voIntlStus;
   }


   private List<InternationalStudent> find(VoInternationalStudent voInternationalStudent){
       String hql = " from InternationalStudent s where 1=1 ";
       List<Object> values = new ArrayList<Object>();
       hql=addWhere(voInternationalStudent,hql,values);
       if(voInternationalStudent.getSort()!=null&&voInternationalStudent.getOrder()!=null){
           hql+=" order by "+ voInternationalStudent.getSort()+" "+voInternationalStudent.getOrder();
       }
       PageBean pageBean = new PageBean(voInternationalStudent.getPage(),voInternationalStudent.getRows());
       return internationalStudentDAO.find(hql,values,pageBean);
   }

   private Long total(VoInternationalStudent vs){
       String hql="select count(*) from InternationalStudent s where 1=1 ";
       List<Object> values=new ArrayList<Object>();
       hql=addWhere(vs,hql,values);
       return internationalStudentDAO.count(hql,values);
   }

    /**
     * 国际班学生的条件查询
     * @param vs
     * @param hql
     * @param values
     * @return
     */
   private String addWhere(VoInternationalStudent vs,String hql,List<Object>values ){
       return hql;
   }

    /**
     * 国际班学生删除
     * @param ids
     */
    @Override
    public void delete(String ids) {
        System.out.println("Test Point ids:"+ids);
        if (ids!=null){
            for(String id:ids.split(",")){
                if(!id.trim().equals("0")){
                    InternationalStudent s=internationalStudentDAO.get(InternationalStudent.class,Integer.parseInt(id.trim()));
                    if (s!=null){
                        interStuExamDAO.executeHql(" delete InterStuExam s where s.internationalStudent = ? ",new Object[]{s});
                        interStuTrainDAO.executeHql(" delete InterStuTrain s where s.internationalStudent = ? ",new Object[]{s});
                        interStuSummerCampDAO.executeHql(" delete InterStuSummerCamp s where s.internationalStudent = ? ",new Object[]{s});
                        internationalStudentDAO.delete(s);
                        System.out.println("删除了id："+id);
                    }
                }
            }
        }
    }

    @Override
    public void update(VoInternationalStudent vs) throws ValidateFieldsException {
        InternationalStudent ts = internationalStudentDAO.get(InternationalStudent.class,vs.getId());
        if (vs.getStuId().equals(ts.getStuId())||isUniqueIntStu(vs.getStuId())){
            if (StringUtil.isNotEmpty(vs.getMajor())){
                ts.setMajor(vs.getMajor());
            }
            if (StringUtil.isNotEmpty(vs.getName())){
                ts.setName(vs.getName());
            }
            if (StringUtil.isNotEmpty(vs.getStatus())){
                ts.setStatus(vs.getStatus());
            }
            if (vs.getOverSeasStudentId()>0){
                ts.setOverSeasStudent(overSeasStudentDAO.get(OverSeasStudent.class,vs.getOverSeasStudentId()));
            }
            if (vs.getExchangeStudentId()>0){
                ts.setExchangeStudent(exchangeStudentDAO.get(ExchangeStudent.class,vs.getExchangeStudentId()));
            }
            if (vs.getClassInfoId()>0){
                ts.setClassInfo(classesInfoDAO.get(ClassesInfo.class,vs.getClassInfoId()));
            }
        }else {
            throw new ValidateFieldsException("该国际班学生学号已存在，请重新输入！");
        }
        this.saveBatchIntlStuAndSummerCamp(vs,ts,false);
        this.saveBatchIntStuAndIeltsExam(vs,ts,false);
        this.saveBatchIntlStuAndIeltsTrain(vs,ts,false);
    }

    /**
     * 国际班学生与夏令营关系批量编辑
     * @param vs
     */
    @Override
    public void editSummerCamp(VoInternationalStudent vs) {
          if(vs.getIds()!=null){
              for(String id:vs.getIds().split(",")){
                  InternationalStudent ts = internationalStudentDAO.get(InternationalStudent.class,Integer.parseInt(id.trim()));
                  this.saveBatchIntlStuAndSummerCamp(vs,ts,true);
              }
          }
    }

    /**
     * 国际班学生与雅思考试关系批量编辑
     * @param vs
     */
    @Override
    public void editIeltsExam(VoInternationalStudent vs) {
         if (vs.getIeltsExamIds()!=null){
             for (String id:vs.getIds().split(",")){
                 InternationalStudent ts = internationalStudentDAO.get(InternationalStudent.class,Integer.parseInt(id.trim()));
                 this.saveBatchIntStuAndIeltsExam(vs,ts,true);
             }
         }
    }

    /**
     * 国际班学生与雅思培训关系批量编辑
     * @param vs
     */
    @Override
    public void editIeltsTrain(VoInternationalStudent vs) {
          if (vs.getIeltsTrainIds()!=null){
              for (String id:vs.getIds().split(",")){
                  InternationalStudent ts = internationalStudentDAO.get(InternationalStudent.class,Integer.parseInt(id.trim()));
                  this.saveBatchIntlStuAndIeltsTrain(vs,ts,true);
              }
          }
    }


}
