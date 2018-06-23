package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.Policy;
import com.zhbit.service.PolicyService;
import com.zhbit.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
@Service("policyService")
public class PolicyServiceImpl implements PolicyService {
    @Resource
    private BaseDAO<Policy> baseDAO;
    /**
     * չʾ�������߷��棬����չʾ1-8���������߷���
     * @param s_policy
     * @param pageBean
     * @return
     */
    @Override
    public List<Policy> showPolicyList(Policy s_policy, PageBean pageBean) {
        List <Object> param = new LinkedList <Object>();
        StringBuffer hql = new StringBuffer("from Policy ");
        if (s_policy != null) {
            if (StringUtil.isNotEmpty(s_policy.getTitle())) {
                hql.append(" and title like ?");
                param.add("%" + s_policy.getTitle() + "%");
            }
        }
        hql.append("order by id desc");
        if (pageBean != null) {
            return baseDAO.find(hql.toString().replaceFirst("and", "where"), param, pageBean);

        } else {
            return null;
        }
    }
    /**
     * ����id ������߷�������
     * @param policyId
     * @return
     */
    @Override
    public Policy getPolicyById(int policyId) {
        return baseDAO.get(Policy.class,policyId);
    }
    /**
     * �����ܼ�¼��
     * @param s_policy
     * @return
     */
    @Override
    public Long getPolicyCount(Policy s_policy) {
        List<Object>param=new LinkedList <>();
        StringBuffer hql=new StringBuffer("select count(*) from Notice");
        if(s_policy!=null){
            if(StringUtil.isNotEmpty(s_policy.getTitle())){
                hql.append(" and title like ?");
                param.add("%"+s_policy.getTitle()+"%");
            }
        }
        return (Long)baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
    };
}
