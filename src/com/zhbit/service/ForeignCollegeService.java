package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoForeignCollege;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/20
 * @Time:22:21
 * 描述：
 */
public interface ForeignCollegeService {
    /**
     * 获得数据表格
     *
     * @param voForeignCollege
     * @return
     */
    public DataGrid datagrid(VoForeignCollege voForeignCollege);
    public void delete(String ids);
    public void add(VoForeignCollege voForeignCollege);
    public void edit(VoForeignCollege voForeignCollege);
    public List<VoForeignCollege> combobox();
}
