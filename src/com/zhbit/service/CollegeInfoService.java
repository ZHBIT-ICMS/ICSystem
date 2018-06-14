package com.zhbit.service;

import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.vo.VoCollegeInfo;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:46
 * 描述：
 */
public interface CollegeInfoService {
    public List<VoCollegeInfo> treegrid(VoCollegeInfo voCollegeInfo);
    public void delete(VoCollegeInfo voCollegeInfo);
    public void add(VoCollegeInfo voCollegeInfo);
    public void edit(VoCollegeInfo voCollegeInfo);
    public List<VoCollegeInfo> findAll();

}
