package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoClassesInfo;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/19
 * @Time:22:49
 * 描述：
 */
public interface ClassesInfoService {
    public void delete(String ids);

    public void edit(VoClassesInfo voClassesInfo);

    public void add(VoClassesInfo voClassesInfo);

    public DataGrid dataGrid(VoClassesInfo voClassesInfo);
}
