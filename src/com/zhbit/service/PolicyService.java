package com.zhbit.service;

import com.zhbit.entity.News;
import com.zhbit.entity.Notice;
import com.zhbit.entity.PageBean;
import com.zhbit.entity.Policy;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//政策法规
public interface PolicyService {
    /**
     * 展示所有公告，这里展示1-8条最新公告
     * @param s_policy
     * @param pageBean
     * @return
     */
    public List<Policy>showPolicyList (Policy s_policy,PageBean pageBean);

    /**
     * 根据id 查出政策法规详情
     * @param policyId
     * @return
     */
    public Policy getPolicyById(int policyId);
    /**
     * 计算总记录数
     * @param s_policy
     * @return
     */
    public Long getPolicyCount(Policy s_policy);

}
