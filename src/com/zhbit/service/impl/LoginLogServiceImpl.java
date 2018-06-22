package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.LoginLog;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoLoginLog;
import com.zhbit.service.LoginLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: ICSystem
 * @ClassName: LoginLogServiceImpl
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/22 8:03
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    private BaseDAO<LoginLog> baseDAO;

    public BaseDAO<LoginLog> getBaseDAO() {
        return baseDAO;
    }
    @Autowired
    public void setBaseDAO(BaseDAO<LoginLog> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public LoginLog getLoginLogById(int loginLogId) {
        return baseDAO.get(LoginLog.class,loginLogId);
    }

    @Override
    public DataGrid datagrid(VoLoginLog voLoginLog) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voLoginLog)));
        j.setTotal(total(voLoginLog));
        return j;
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                LoginLog t = baseDAO.get(LoginLog.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除登录记录id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }
    }

    /**
     * 将LoginLog转换成voLoginLog（视图层模型）
     */
    private List<VoLoginLog> changeModel(List<LoginLog> loginLogList) {
        List<VoLoginLog> voLoginLogList = new ArrayList<VoLoginLog>();
        if (loginLogList != null && loginLogList.size() > 0) {
            for (LoginLog tn : loginLogList) {
                VoLoginLog vn= new VoLoginLog();
                BeanUtils.copyProperties(tn, vn);
                voLoginLogList.add(vn);
            }
        }
        return voLoginLogList;
    }

    private List<LoginLog> find(VoLoginLog voLoginLog) {
        String hql = " from LoginLog t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voLoginLog, hql, values);

        if (voLoginLog.getSort() != null && voLoginLog.getOrder() != null) {
            hql += " order by " + voLoginLog.getSort() + " " + voLoginLog.getOrder();
        }
        PageBean pageBean = new PageBean(voLoginLog.getPage(),voLoginLog.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    private String addWhere(VoLoginLog voLoginLog, String hql, List<Object> values) {
        return hql;
    }

    /**
     *计算登录记录信息条数
     */
    private Long total(VoLoginLog voLoginLog) {
        String hql = "select count(*) from LoginLog t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voLoginLog, hql, values);
        return baseDAO.count(hql, values);
    }
}
