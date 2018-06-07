package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.AdminUser;
import com.zhbit.service.LoginForAdminService;
import com.zhbit.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/4
 * @Time:16:09
 * 描述：
 */
@Service("loginForAdminService")
public class LoginForAdminServiceImpl implements LoginForAdminService{
    @Resource
    private BaseDAO<AdminUser> baseDAO;

    /**
     *验证管理员的用户名与密码
     * @param lusername
     * @param lpassword
     * @return
     */
    @Override
    public AdminUser validateUser(String lusername,String lpassword){
         List<Object> param=new LinkedList<Object>();
         List<AdminUser> adminUsers=null;
         StringBuffer hql=new StringBuffer("from AdminUser ");
         if(StringUtil.isNotEmpty(lusername)&&StringUtil.isNotEmpty(lpassword)){
             hql.append("and userName=? ");
             hql.append("and password=? ");
             param.add(lusername);
             param.add(lpassword);
             String newHql=hql.toString().replaceFirst("and","where");
             System.out.println("hql:"+newHql);
             adminUsers=baseDAO.find(newHql,param);
             return adminUsers.get(0);
         }else{
             return null;
         }

    }
}
