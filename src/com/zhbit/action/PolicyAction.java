package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.Policy;
import com.zhbit.service.PolicyService;
import com.zhbit.util.PageUtil;
import com.zhbit.util.StringUtil;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wby on 2018/5/29.
 */
public class PolicyAction extends ActionSupport implements ServletRequestAware{
    @Resource
    private PolicyService policyService;

    private int policyId;
    private Policy policy;
    private HttpServletRequest request;
    private String page;//当前页面
    private Policy s_policy;//分页用到的对象
    private Long total;//总记录数
    private List<Policy> policyList;
    private String pageCode;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Policy getS_policy() {
        return s_policy;
    }

    public void setS_policy(Policy s_policy) {
        this.s_policy = s_policy;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List <Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List <Policy> policyList) {
        this.policyList = policyList;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String execute() throws Exception {
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),8);
        policyList=policyService.showPolicyList(s_policy,pageBean);
        total=(Long) policyService.getPolicyCount(s_policy);
        StringBuffer param=new StringBuffer();
        pageCode= PageUtil.genPagination(request.getContextPath()+"/policy.action", total, Integer.parseInt(page), 8, param.toString());
        return super.execute();

    }

    /**
     * 展示政策法规详情
     * @return
     */
    public String showPolicy(){
        policy=policyService.getPolicyById(policyId);
        return "success";
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
