package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.*;
import com.zhbit.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/12
 * @Time:9:55
 * 描述：
 */
@Service("repairService")
public class RepairServiceImpl extends BaseServiceImpl implements RepairService {
    private BaseDAO<User> userDao;
    private BaseDAO<CollegeInfo>collegeInfoDao;
    private BaseDAO<Menu> menuDAO;
    private BaseDAO<Auth> authDao;
    private BaseDAO<Role> roleDao;
    private BaseDAO<UserRole> userRoleDao;
    private BaseDAO<RoleAuth> roleAuthDao;

    public BaseDAO<User> getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(BaseDAO<User> userDao) {
        this.userDao = userDao;
    }

    public BaseDAO<CollegeInfo> getCollegeInfoDao() {
        return collegeInfoDao;
    }
    @Autowired
    public void setCollegeInfoDao(BaseDAO<CollegeInfo> collegeInfoDao) {
        this.collegeInfoDao = collegeInfoDao;
    }

    public BaseDAO<Menu> getMenuDAO() {
        return menuDAO;
    }
    @Autowired
    public void setMenuDAO(BaseDAO<Menu> menuDAO) {
        this.menuDAO = menuDAO;
    }

    public BaseDAO<Auth> getAuthDao() {
        return authDao;
    }
    @Autowired
    public void setAuthDao(BaseDAO<Auth> authDao) {
        this.authDao = authDao;
    }

    public BaseDAO<Role> getRoleDao() {
        return roleDao;
    }
    @Autowired
    public void setRoleDao(BaseDAO<Role> roleDao) {
        this.roleDao = roleDao;
    }

    public BaseDAO<UserRole> getUserRoleDao() {
        return userRoleDao;
    }
    @Autowired
    public void setUserRoleDao(BaseDAO<UserRole> userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    public BaseDAO<RoleAuth> getRoleAuthDao() {
        return roleAuthDao;
    }
    @Autowired
    public void setRoleAuthDao(BaseDAO<RoleAuth> roleAuthDao) {
        this.roleAuthDao = roleAuthDao;
    }
    synchronized public void deleteAndRepair(){
        menuDAO.executeHql("update Menu t set t.menu = null");
        menuDAO.executeHql("delete Menu");
        roleAuthDao.executeHql("delete RoleAuth");
        userRoleDao.executeHql("delete UserRole");
        authDao.executeHql("update Auth t set t.auth = null");
        authDao.executeHql("delete Auth");
        roleDao.executeHql("delete Role");
       // userDao.executeHql("delete User");
        repair();
    }
    synchronized public void repair() {
      /*  repairMenu();// 修复菜单
        repairAuth();// 修复权限
        repairRole();// 修复角色
        repairDept();// 修复用户
        repairUser();// 修复用户
        repairRoleAuth();// 修复角色和权限的关系
        repairUserRole();// 修复用户和角色的关系*/
    }
}
