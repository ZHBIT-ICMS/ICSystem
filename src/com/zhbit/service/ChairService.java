package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoChair;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:9:25
 * 描述：
 */
public interface ChairService {
    public void delete(String ids);

    public void edit(VoChair voChair);

    public void add(VoChair voChair);

    public DataGrid dataGrid(VoChair voChair);
}
