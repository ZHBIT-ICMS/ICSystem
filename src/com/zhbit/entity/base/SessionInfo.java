package com.zhbit.entity.base;

import com.zhbit.entity.vo.VoMenu;

import java.io.Serializable;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:23:14 描述：
 */
public class SessionInfo implements Serializable {
    private String userId;// 用户ID
    private String loginName;// 用户登录名称
    private String loginPassword;// 登录密码
    private String ip;// IP地址
    private String authIds;// 拥有的权限ID集合
    private String authNames;
    private String authUrls;
    private String roleIds;
    private String roleNames;
    private List<VoMenu> menus;

     @Override
     public  String toString(){
         return loginName;
     }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }

    public String getAuthNames() {
        return authNames;
    }

    public void setAuthNames(String authNames) {
        this.authNames = authNames;
    }

    public String getAuthUrls() {
        return authUrls;
    }

    public void setAuthUrls(String authUrls) {
        this.authUrls = authUrls;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public List<VoMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<VoMenu> menus) {
        this.menus = menus;
    }
}
