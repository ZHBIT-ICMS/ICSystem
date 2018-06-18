package com.zhbit.service;

import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.Policy;

import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//���߷���
public interface PolicyService {
    /**
     * չʾ���й��棬����չʾ1-8�����¹���
     * @param s_policy
     * @param pageBean
     * @return
     */
    public List<Policy>showPolicyList (Policy s_policy,PageBean pageBean);

    /**
     * ����id ������߷�������
     * @param policyId
     * @return
     */
    public Policy getPolicyById(int policyId);
    /**
     * �����ܼ�¼��
     * @param s_policy
     * @return
     */
    public Long getPolicyCount(Policy s_policy);

}
