package com.zhbit.service;

import com.zhbit.entity.InternationalStudent;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/4
 * @Time:15:34
 * 描述：
 */
public interface LoginForStudentService {
    /**
     * 验证用户登录账户和密码
     */
  public InternationalStudent validateUser(String lusername, String lpassword);

}
