package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoAgreement;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/22
 * @Time:10:27
 * @Description描述：
 * 协议服务接口
 */
public interface AgreementService {

    /**
     * 获得数据表格
     *
     * @param voAgreement
     * @return
     */
    public DataGrid datagrid(VoAgreement voAgreement);

    /**
     * 删除
     *
     * @param ids
     */
    public void delete(String ids);

    /**
     * 添加
     *
     * @param voAgreement
     */
    public void add(VoAgreement voAgreement);

    /**
     * 获得协议内容
     * @param id
     * @return
     */
    public String getContentById(int id);

    public void update(VoAgreement voAgreement);
}
