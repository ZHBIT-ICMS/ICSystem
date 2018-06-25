package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.Policy;
import com.zhbit.entity.vo.VoPolicy;
import com.zhbit.service.PolicyService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 * modified by wenxuan
 */
@Service("policyService")
public class PolicyServiceImpl implements PolicyService {
    @Resource
    private BaseDAO<Policy> baseDAO;

    public BaseDAO<Policy> getBaseDAO() {
        return baseDAO;
    }

    public void setBaseDAO(BaseDAO<Policy> baseDAO) {
        this.baseDAO = baseDAO;
    }

    /**
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
     * @param policyId
     * @return
     */
    @Override
    public Policy getPolicyById(int policyId) {
        return baseDAO.get(Policy.class,policyId);
    }
    /**
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
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DataGrid datagrid(VoPolicy voPolicy) {
        DataGrid j = new DataGrid();
        String where;
        j.setRows(this.changeModel(this.find(voPolicy)));
        j.setTotal(total(voPolicy));
        return j;
    }

    /**
     *将Policy转换成VoPolicy（视图层模型）
     */
    private List<VoPolicy> changeModel(List<Policy> policyList) {
        List<VoPolicy> voPolicyList = new ArrayList<VoPolicy>();
        if (policyList != null && policyList.size() > 0) {
            for (Policy tn : policyList) {
                VoPolicy vn= new VoPolicy();
                BeanUtils.copyProperties(tn, vn);
                voPolicyList.add(vn);
            }
        }
        return voPolicyList;
    }

    private List<Policy> find(VoPolicy voPolicy) {
        String hql = " from Policy t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voPolicy, hql, values);

        if (voPolicy.getSort() != null && voPolicy.getOrder() != null) {
            hql += " order by " + voPolicy.getSort() + " " + voPolicy.getOrder();
        }
        PageBean pageBean = new PageBean(voPolicy.getPage(),voPolicy.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    private String addWhere(VoPolicy voPolicy, String hql, List<Object> values) {
        String where;
        String title=voPolicy.getTitle();
        if(title!=null) {
            where = "t.title like '%" + title + "%'";
        }else{
            where=" 1=1";
        }
        hql=hql+where+" ";
        return hql;
    }

    /**
     *计算政策法规信息总数
     */
    private Long total(VoPolicy voPolicy) {
        String hql = "select count(*) from Policy t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voPolicy, hql, values);
        return baseDAO.count(hql, values);
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                Policy t = baseDAO.get(Policy.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除政策法规信息id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }
    }

    //添加政策法规信息
    @Override
    public void add(VoPolicy voPolicy) {
        if (voPolicy.getCreateTime() == null) {
            voPolicy.setCreateTime(new Date());
        }
        Policy t = new Policy();
        BeanUtils.copyProperties(voPolicy, t);
        baseDAO.save(t);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String getContentById(int id) {
        Policy t = baseDAO.get(Policy.class, id);
        return t.getContent();
    }

    //修改政策法规信息
    @Override
    public void update(VoPolicy voPolicy) {
        Policy t = baseDAO.get(Policy.class,voPolicy.getId());
        if (t != null) {
            t.setTitle(voPolicy.getTitle());
            t.setContent(voPolicy.getContent());
            t.setCreateTime(new Date());
            t.setPeople(voPolicy.getPeople());
        }
    }

    ;
}
