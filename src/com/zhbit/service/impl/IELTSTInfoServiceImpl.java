package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.ClassesInfo;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.IELTSExam;
import com.zhbit.entity.IELTSTrain;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoCollegeInfo;
import com.zhbit.entity.vo.VoIELTSTrain;
import com.zhbit.service.IELTSTInfoService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/6/20.
 */
@Service("ieltstInfoService")
public class IELTSTInfoServiceImpl extends BaseServiceImpl implements IELTSTInfoService{
    @Autowired
    private BaseDAO<IELTSTrain> ieltsTrainBaseDAO;

    public BaseDAO <IELTSTrain> getIeltsTrainBaseDAO() {
        return ieltsTrainBaseDAO;
    }

    public void setIeltsTrainBaseDAO(BaseDAO <IELTSTrain> ieltsTrainBaseDAO) {
        this.ieltsTrainBaseDAO = ieltsTrainBaseDAO;
    }


    /**
     * 雅思配需删除
     * @param ids
     */
    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                IELTSTrain t =ieltsTrainBaseDAO.get(IELTSTrain.class, Integer.parseInt(id));
                if (t != null) {
                    ieltsTrainBaseDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void edit(VoIELTSTrain voIELTSTrain) {

//        private String ieltsTrainId;//雅思机构编号
//        private String trainName;//雅思机构名称
//        private String trainTerm;//培训的学期
//        private Date trainTime;//培训的时期
//        private String trainClassHours;//雅思课程学时
//        private List<IELTSExam> examList;//雅思考试
        IELTSTrain ieltsTrain = ieltsTrainBaseDAO.get(IELTSTrain.class,voIELTSTrain.getId());
        if(ieltsTrain!=null){
            ieltsTrain.setIeltsTrainId(voIELTSTrain.getIeltsTrainId());
            ieltsTrain.setTrainName(voIELTSTrain.getTrainName());
            ieltsTrain.setTrainTerm(voIELTSTrain.getTrainTerm());
            ieltsTrain.setTrainTime(voIELTSTrain.getTrainTime());
            ieltsTrain.setTrainClassHours(voIELTSTrain.getTrainClassHours());
        }
    }


    @Override
    public void add(VoIELTSTrain voIELTSTrain) {
        IELTSTrain ieltsTrain = new IELTSTrain();
        BeanUtils.copyProperties(voIELTSTrain,ieltsTrain);
        ieltsTrainBaseDAO.save(ieltsTrain);
    }

    @Override
    public DataGrid dataGrid(VoIELTSTrain voIELTSTrain) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voIELTSTrain)));
        j.setTotal(total(voIELTSTrain));
        return j;
    }
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List <VoIELTSTrain> combobox() {
        System.out.println("`````````````````````````````````````````````````````````````````IELTSTraincombobox");
        List<VoIELTSTrain> rl = new ArrayList<VoIELTSTrain>();
        List<IELTSTrain> l = ieltsTrainBaseDAO.find(" from IELTSTrain ");
        if (l != null && l.size() > 0) {
            for (IELTSTrain t : l) {
                VoIELTSTrain r = new VoIELTSTrain();
                r.setId(t.getId());
                r.setIeltsTrainId(t.getIeltsTrainId());
                rl.add(r);
            }
        }
        return rl;
    }

    private Long total(VoIELTSTrain voIELTSTrain){
        String hql = "select count(*) from IELTSTrain t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voIELTSTrain, hql, values);
        return ieltsTrainBaseDAO.count(hql, values);
    }
    private String addWhere(VoIELTSTrain voIELTSTrain,String hql,List<Object> values){
        return  hql;
    }

    /**
     *
     * @param ieltsTrains
     * @return
     */
    private List<VoIELTSTrain> changeModel(List<IELTSTrain> ieltsTrains){
        List<VoIELTSTrain> voIELTSTrains = new ArrayList<VoIELTSTrain>();
        if (ieltsTrains!=null&&ieltsTrains.size()>0){
            for(IELTSTrain tc : ieltsTrains){
                VoIELTSTrain vc = new VoIELTSTrain();
                BeanUtils.copyProperties(tc,vc);
                voIELTSTrains.add(vc);
            }
        }
        return voIELTSTrains;
    }

    /**
     *
     * @param voIELTSTrain
     * @return
     */
    private List<IELTSTrain> find(VoIELTSTrain voIELTSTrain){
        String hql = " from IELTSTrain where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voIELTSTrain,hql,values);
        if(voIELTSTrain.getSort()!=null && voIELTSTrain.getOrder()!=null){
            hql += " order by " + voIELTSTrain.getSort()+" "+voIELTSTrain.getOrder();
        }
        PageBean pageBean = new PageBean(voIELTSTrain.getPage(),voIELTSTrain.getRows());
        return ieltsTrainBaseDAO.find(hql,values,pageBean);
    }
}
