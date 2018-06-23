package com.zhbit.service;

import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoCollegeInfo;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:46
 * 描述：
 */
public interface CollegeInfoService {
    /**
     * 获得数据表格
     *
     * @param voCollegeInfo
     * @return
     */
    public DataGrid datagrid(VoCollegeInfo voCollegeInfo);
    public void delete(String ids);
    public void add(VoCollegeInfo voCollegeInfo);
    public void edit(VoCollegeInfo voCollegeInfo);
    public List<VoCollegeInfo> combobox();
}
