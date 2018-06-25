package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.Policy;
import com.zhbit.entity.vo.VoPolicy;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 * modified by wenxuan
 */

public interface PolicyService {
    /**
     * 展示所有政策法规信息，
     */
    public List<Policy> showPolicyList(Policy s_policy, PageBean pageBean);

    /**
     * 根据id 查出政策法规信息详情
     */
    public Policy getPolicyById(int noticeId);

    /**
     * 计算总记录数
     */
    public Long getPolicyCount(Policy s_policy);


    /**
     * 获得数据表格
     */
    public DataGrid datagrid(VoPolicy voPolicy);

    /**
     * 删除
     */
    public void delete(String ids);

    /**
     * 添加
     */
    public void add(VoPolicy voPolicy);

    /**
     * 获得政策法规信息内容
     */
    public String getContentById(int id);

    public void update(VoPolicy voPolicy);
}
