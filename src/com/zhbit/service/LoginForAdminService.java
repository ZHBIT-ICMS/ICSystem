package com.zhbit.service;

import com.zhbit.entity.User;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/4
 * @Time:16:08 描述：
 */
public interface LoginForAdminService {
    /**
     * 验证用户登录账户和密码
     */
    public User validateUser(String lusername, String lpassword);
}
