package com.zhbit.service;

import com.zhbit.entity.AdminUser;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/4
 * @Time:16:08 描述：
 */
public interface LoginForAdminService {
    /**
     * 验证用户登录账户和密码
     */
    public AdminUser validateUser(String lusername, String lpassword);
}
