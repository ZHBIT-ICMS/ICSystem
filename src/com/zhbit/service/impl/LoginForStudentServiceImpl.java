package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.AdminUser;
import com.zhbit.entity.InternationalStudent;
import com.zhbit.service.LoginForStudentService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/4
 * @Time:15:43 描述：
 */
@Service("loginForStudentService")
public class LoginForStudentServiceImpl implements LoginForStudentService {
    @Resource
    private BaseDAO<InternationalStudent>baseDAO;
    /**
     * 验证学生用户登录账户和密码
     */
    @Override
    public InternationalStudent validateUser(String lusername, String lpassword) {
        List<Object> param=new LinkedList<Object>();
        List<InternationalStudent> internationalStudents=null;
        StringBuffer hql=new StringBuffer("from AdminUser ");
        if(StringUtil.isNotEmpty(lusername)&&StringUtil.isNotEmpty(lpassword)){
            hql.append("and userName=? ");
            hql.append("and password=? ");
            param.add(lusername);
            param.add(lpassword);
            String newHql=hql.toString().replaceFirst("and","where");
            System.out.println("hql:"+newHql);
            internationalStudents=baseDAO.find(newHql,param);
            return internationalStudents.get(0);
        }else{
            return null;
        }
    }




}
