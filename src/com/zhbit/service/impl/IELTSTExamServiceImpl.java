package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.ClassesInfo;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.IELTSExam;
import com.zhbit.entity.IELTSTrain;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoClassesInfo;
import com.zhbit.entity.vo.VoIELTSExam;
import com.zhbit.entity.vo.VoIELTSTrain;
import com.zhbit.service.IELTSTExamService;
import com.zhbit.service.IELTSTInfoService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/6/21.
 */
@Service("ieltstExamService")
public class IELTSTExamServiceImpl extends BaseServiceImpl implements IELTSTExamService{


    private BaseDAO<IELTSExam>  ieltsExamBaseDAO;
    public BaseDAO <IELTSExam> getIeltsExamBaseDAO() {
        return ieltsExamBaseDAO;
    }
    @Autowired
    public void setIeltsExamBaseDAO(BaseDAO <IELTSExam> ieltsExamBaseDAO) {
        this.ieltsExamBaseDAO = ieltsExamBaseDAO;
    }



    private BaseDAO<IELTSTrain> ieltsTrainBaseDAO;

    public BaseDAO <IELTSTrain> getIeltsTrainBaseDAO() {
        return ieltsTrainBaseDAO;
    }
    @Autowired
    public void setIeltsTrainBaseDAO(BaseDAO <IELTSTrain> ieltsTrainBaseDAO) {
        this.ieltsTrainBaseDAO = ieltsTrainBaseDAO;
    }


    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                IELTSExam t =ieltsExamBaseDAO.get(IELTSExam.class, Integer.parseInt(id));
                if (t != null) {
                    ieltsExamBaseDAO.delete(t);
                }
            }
        }

    }

    @Override
    public void edit(VoIELTSExam voIELTSExam) {
//        private  String examId;//���Եı��
//        private Date examTime;//��˼����ʱ��
//        private String examPlace;//��˼���Եص�
//        private int score;//����
//        private IELTSTrain ieltsTrain;//��ѵ����
        IELTSExam ieltsExam=ieltsExamBaseDAO.get(IELTSExam.class,voIELTSExam.getId());

        if(ieltsExam!=null){
            ieltsExam.setExamId(voIELTSExam.getExamId());
            ieltsExam.setExamTime(voIELTSExam.getExamTime());
            ieltsExam.setExamPlace(voIELTSExam.getExamPlace());
            ieltsExam.setScore(voIELTSExam.getScore());
//            ieltsExam.setIeltsTrain(voIELTSExam.getIeltsTrain());

            if (voIELTSExam.getExamId()!=null){
                ieltsExam.setIeltsTrain(ieltsTrainBaseDAO.get(IELTSTrain.class,voIELTSExam.getIeltsTrainId()));
            }
//            if (StringUtil.isNotEmpty(voClassesInfo.getClassNo())){
//                classesInfo.setClassNo(voClassesInfo.getClassNo());
//            }
        }

    }

    @Override
    public void add(VoIELTSExam voIELTSExam) {
        IELTSExam ieltsExam = new IELTSExam();
        BeanUtils.copyProperties(voIELTSExam,ieltsExam);
        //classesInfo.setCollegeInfo(collegeInfoDAO.get(CollegeInfo.class,voClassesInfo.getCollegeId())
        ieltsExam.setIeltsTrain(ieltsTrainBaseDAO.get(IELTSTrain.class,(voIELTSExam.getIeltsTrainId())));
        ieltsExamBaseDAO.save(ieltsExam);
    }

    @Override
    public DataGrid dataGrid(VoIELTSExam voIELTSExam) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voIELTSExam)));
        j.setTotal(total(voIELTSExam));
        return  j;
    }

    @Override
    public List <VoIELTSExam> combobox() {
        return null;
    }

    /**
     * ������˼��������
     * @param voIELTSExam
     * @return
     */
    private Long total(VoIELTSExam voIELTSExam) {
        String hql = "select count(*) from IELTSExam t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voIELTSExam, hql, values);
        return ieltsExamBaseDAO.count(hql, values);
    }
    /**
     * �༶������ѯ
     *
     * @param hql
     * @param values
     * @return
     */
    private String addWhere(VoIELTSExam voIELTSExam, String hql, List<Object> values) {
        return hql;
    }
    /**
     *
     * @param voIELTSExam
     * @return
     */
    public List<IELTSExam> find(VoIELTSExam voIELTSExam){
        String hql = " from IELTSExam t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voIELTSExam, hql, values);

        if (voIELTSExam.getSort() != null && voIELTSExam.getOrder() != null) {
            hql += " order by " + voIELTSExam.getSort() + " " + voIELTSExam.getOrder();
        }
        PageBean pageBean = new PageBean(voIELTSExam.getPage(),voIELTSExam.getRows());
        return ieltsExamBaseDAO.find(hql, values,  pageBean);
    }


    /**
     * ���־û�ģ�ͣ�ת���ɣ���ͼ��ģ�ͣ�
     * @param
     * @return
     */
    private List<VoIELTSExam> changeModel(List<IELTSExam> ieltsExams) {
        List<VoIELTSExam> voIELTSExams = new ArrayList<VoIELTSExam>();
        if (ieltsExams != null && ieltsExams.size() > 0) {
            for (IELTSExam tc : ieltsExams) {
                VoIELTSExam vc= new VoIELTSExam();
                BeanUtils.copyProperties(tc, vc);
                vc.setIeltsTrainId(tc.getIeltsTrain().getId());
               vc.setTrainName(tc.getIeltsTrain().getTrainName());

                voIELTSExams.add(vc);
            }
        }
        return voIELTSExams;
    }

}
