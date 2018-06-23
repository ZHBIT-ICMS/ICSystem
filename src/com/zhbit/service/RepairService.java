package com.zhbit.service;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/12
 * @Time:9:54 描述：
 */
public interface RepairService {
    /**
     * 修复数据
     */
    public void repair();

    /**
     * 先清空数据，然后再修复数据
     */
    public void deleteAndRepair();

}
