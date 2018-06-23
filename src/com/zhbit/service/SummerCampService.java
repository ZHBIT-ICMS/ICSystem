package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoSummerCamp;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:22:40
 * @Description描述：
 */
public interface SummerCampService {
    public void delete(String ids);

    public void edit(VoSummerCamp voSummerCamp);

    public void add(VoSummerCamp voSummerCamp);

    public DataGrid dataGrid(VoSummerCamp voSummerCamp);

    public List<VoSummerCamp> combobox();
}
