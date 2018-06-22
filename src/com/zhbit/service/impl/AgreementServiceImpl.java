package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Agreement;
import com.zhbit.entity.ForeignCollege;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoAgreement;
import com.zhbit.service.AgreementService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/22
 * @Time:10:31
 * @Description描述：
 */
@Service("agreementService")
public class AgreementServiceImpl extends BaseServiceImpl implements AgreementService {


    private BaseDAO<Agreement> agreementDAO;
    private BaseDAO<ForeignCollege> foreignCollegeDAO;
    //private BaseDAO<ForCollegeAgreement> forCollegeAgreementDAO;


    public BaseDAO<ForeignCollege> getForeignCollegeDAO() {
        return foreignCollegeDAO;
    }
    @Autowired
    public void setForeignCollegeDAO(BaseDAO<ForeignCollege> foreignCollegeDAO) {
        this.foreignCollegeDAO = foreignCollegeDAO;
    }

    public BaseDAO<Agreement> getAgreementDAO() {
        return agreementDAO;
    }
    @Autowired
    public void setAgreementDAO(BaseDAO<Agreement> agreementDAO) {
        this.agreementDAO = agreementDAO;
    }

    @Override
    public DataGrid datagrid(VoAgreement voAgreement) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voAgreement)));
        j.setTotal(total(voAgreement));
        return j;
    }

    /**
     * 将Agreement（持久层模型）转化为VoAgreement（视图层模型）
     * @param agreements
     * @return
     */
    private List<VoAgreement> changeModel(List<Agreement> agreements) {
        List<VoAgreement> voAgreements = new ArrayList<VoAgreement>();
        if (agreements != null && agreements.size() > 0) {
            for (Agreement tn : agreements) {
                VoAgreement vn= new VoAgreement();
                BeanUtils.copyProperties(tn, vn);
                vn.setForeignCollegeId(tn.getForeignCollege().getId());
                vn.setForeignCollegeName(tn.getForeignCollege().getForeignName());
                voAgreements.add(vn);

            }
        }
        return voAgreements;
    }

    private List<Agreement> find(VoAgreement voAgreement) {
        String hql = " from Agreement t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voAgreement, hql, values);

        if (voAgreement.getSort() != null && voAgreement.getOrder() != null) {
            hql += " order by " + voAgreement.getSort() + " " + voAgreement.getOrder();
        }
        PageBean pageBean = new PageBean(voAgreement.getPage(),voAgreement.getRows());
        return agreementDAO.find(hql, values,  pageBean);
    }

    private Long total(VoAgreement voAgreement) {
        String hql = "select count(*) from Agreement t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voAgreement, hql, values);
        return agreementDAO.count(hql, values);
    }

    private String addWhere(VoAgreement voAgreement, String hql, List<Object> values) {
        return hql;
    }

    /**
     * 删除协议
     * @param ids
     */
    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                Agreement t = agreementDAO.get(Agreement.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除协议id为"+id);
                if (t != null) {
                    agreementDAO.delete(t);
                }
            }
        }
    }

    @Override
    public void add(VoAgreement voAgreement) {
        if (voAgreement.getAgreementTime() == null) {
            voAgreement.setAgreementTime(new Date());
        }
        Agreement t = new Agreement();
        BeanUtils.copyProperties(voAgreement, t);
        //t.setId(UUID.randomUUID().toString());
        t.setForeignCollege(foreignCollegeDAO.get(ForeignCollege.class,voAgreement.getForeignCollegeId()));
        agreementDAO.save(t);
    }

    @Override
    public String getContentById(int id) {
        Agreement t = agreementDAO.get(Agreement.class, id);
        return t.getContent();
    }

    /**
     * 更新协议
     * @param voAgreement
     */
    @Override
    public void update(VoAgreement voAgreement) {
        Agreement t = agreementDAO.get(Agreement.class,voAgreement.getId());
        if (t != null) {
            if (StringUtil.isNotEmpty(voAgreement.getTitle())){
                t.setTitle(voAgreement.getTitle());
            }
            if (voAgreement.getAgreementTime()!=null){
                t.setAgreementTime(voAgreement.getAgreementTime());
            }
            if (StringUtil.isNotEmpty(voAgreement.getContent())){
                t.setContent(voAgreement.getContent());
            }
            if (StringUtil.isNotEmpty(voAgreement.getType())){
                t.setType(voAgreement.getType());
            }
            if (voAgreement.getForeignCollegeId()>0){
                t.setForeignCollege(foreignCollegeDAO.get(ForeignCollege.class,voAgreement.getForeignCollegeId()));
            }
        }
    }
}
