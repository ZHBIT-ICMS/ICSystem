package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Auth;
import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuth;
import com.zhbit.entity.UserRole;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoRole;
import com.zhbit.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:22:50
 * 描述：
 */
@Service("roleSerivce")
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
    private BaseDAO<Role> roleDao;
    private BaseDAO<Auth> authDao;
    private BaseDAO<RoleAuth> roleAuthDao;
    private BaseDAO<UserRole> userRoleDao;

    public BaseDAO<Role> getRoleDao() {
        return roleDao;
    }
    @Autowired
    public void setRoleDao(BaseDAO<Role> roleDao) {
        this.roleDao = roleDao;
    }

    public BaseDAO<Auth> getAuthDao() {
        return authDao;
    }
    @Autowired
    public void setAuthDao(BaseDAO<Auth> authDao) {
        this.authDao = authDao;
    }

    public BaseDAO<RoleAuth> getRoleAuthDao() {
        return roleAuthDao;
    }
    @Autowired
    public void setRoleAuthDao(BaseDAO<RoleAuth> roleAuthDao) {
        this.roleAuthDao = roleAuthDao;
    }

    public BaseDAO<UserRole> getUserRoleDao() {
        return userRoleDao;
    }
    @Autowired
    public void setUserRoleDao(BaseDAO<UserRole> userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DataGrid datagrid(VoRole voRole) {
        DataGrid j = new DataGrid();
        j.setRows(changeModel(find(voRole)));
        j.setTotal(total(voRole));
        return j;
    }
    private List<VoRole> changeModel(List<Role> troles) {
        List<VoRole> roles = new ArrayList<VoRole>();
        if (troles != null && troles.size() > 0) {
            for (Role tu : troles) {
                VoRole u = new VoRole();
                BeanUtils.copyProperties(tu, u);

                Set<RoleAuth> troletauths = tu.getRoleAuths();
                String authIds = "";
                String authNames = "";
                boolean b = false;
                if (troletauths != null && troletauths.size() > 0) {
                    for (RoleAuth troletauth : troletauths) {
                        if (troletauth.getAuth() != null) {
                            if (b) {
                                authIds += ",";
                                authNames += ",";
                            }
                            authIds += troletauth.getAuth().getCid();
                            authNames += troletauth.getAuth().getCname();
                            b = true;
                        }
                    }
                }
                u.setAuthIds(authIds);
                u.setAuthNames(authNames);

                roles.add(u);
            }
        }
        return roles;
    }
    private List<Role> find(VoRole voRole) {
        String hql = "from Role t where 1=1 ";

        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voRole, hql, values);

        if (voRole.getSort() != null && voRole.getOrder() != null) {
            hql += " order by " + voRole.getSort() + " " + voRole.getOrder();
        }
        PageBean pg =new PageBean(voRole.getPage(),voRole.getRows());
        return roleDao.find(hql, values, pg );
    }
    private Long total(VoRole voRole) {
        String hql = "select count(*) from Role t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voRole, hql, values);
        return roleDao.count(hql, values);
    }
    private String addWhere(VoRole voRole, String hql, List<Object> values) {
        return hql;
    }
    public void add(VoRole voRole) {
        Role r = new Role();
        BeanUtils.copyProperties(voRole, r);
        r.setCid(UUID.randomUUID().toString());
        roleDao.save(r);

        this.saveRoleAuth(voRole, r);
    }

    /**
     * 保存Role和Auth的关系
     * @param voRole
     * @param r
     */
    private void saveRoleAuth(VoRole voRole, Role r) {
        roleAuthDao.executeHql("delete RoleAuth t where t.role = ?", new Object[] { r });
        if (voRole.getAuthIds() != null) {
            for (String id : voRole.getAuthIds().split(",")) {
                RoleAuth troletauth = new RoleAuth();
                troletauth.setCid(UUID.randomUUID().toString());
                troletauth.setAuth(authDao.get(Auth.class, id.trim()));
                troletauth.setRole(r);
                roleAuthDao.save(troletauth);
            }
        }
    }
    public void edit(VoRole voRole) {
        Role r = roleDao.get(Role.class, voRole.getCid());
        BeanUtils.copyProperties(voRole, r, new String[] { "cid" });
        this.saveRoleAuth(voRole, r);
    }
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                Role r = roleDao.get(Role.class, id.trim());
                if (r != null) {
                    roleAuthDao.executeHql("delete RoleAuth t where t.role = ?", new Object[] { r });
                    userRoleDao.executeHql("delete UserRole t where t.role = ?", new Object[] { r });
                    roleDao.delete(r);
                }
            }
        }
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoRole> combobox() {
        List<VoRole> rl = new ArrayList<VoRole>();
        List<Role> l = roleDao.find("from Role");
        if (l != null && l.size() > 0) {
            for (Role t : l) {
                VoRole r = new VoRole();
                r.setCid(t.getCid());
                r.setCname(t.getCname());
                rl.add(r);
            }
        }
        return rl;
    }
}
