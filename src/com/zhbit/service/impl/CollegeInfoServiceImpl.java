package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.vo.VoCollegeInfo;
import com.zhbit.service.CollegeInfoService;
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
 * @Time:9:58 描述：
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

    @Override
    public List<VoCollegeInfo> treegrid(VoCollegeInfo voCollegeInfo) {
        return null;
    }

    @Override
    public void delete(VoCollegeInfo voCollegeInfo) {

    }

    @Override
    public void add(VoCollegeInfo voCollegeInfo) {

    }

    @Override
    public void edit(VoCollegeInfo voCollegeInfo) {

    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoCollegeInfo> findAll() {
        List<VoCollegeInfo> lvc = new ArrayList<VoCollegeInfo>();
        String hql="from CollegeInfo";
        List<CollegeInfo> lc=collegeInfoDAO.find(hql);
        if(lc!=null&& lc.size()>0){
            for(CollegeInfo ci:lc){
                VoCollegeInfo vc = new VoCollegeInfo();
                vc.setId(ci.getId());
                vc.setCollegeName(ci.getCollegeName());
                vc.setDescInfo(ci.getDescInfo());
                lvc.add(vc);
                System.out.println("222222222222222222222222:"+vc.getId());
            }
        }
        return lvc;
    }
}
