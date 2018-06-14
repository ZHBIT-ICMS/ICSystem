package com.zhbit.service.impl;

import com.zhbit.comparator.AuthComparator;
import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Auth;
import com.zhbit.entity.RoleAuth;
import com.zhbit.entity.base.TreeNode;
import com.zhbit.entity.vo.VoAuth;
import com.zhbit.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:17:03
 * 描述：
 */
@Service("authService")
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {
    private BaseDAO<Auth> authDao;
    private BaseDAO<RoleAuth> roleAuthDao;

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
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoAuth> treegrid(VoAuth voAuth){
        List<Auth> l;
        System.out.println("```````````````voAuth");
        if (voAuth != null && voAuth.getId() != null) {
            l = authDao.find("from Auth t where t.auth.cid = ? order by t.cseq", new Object[] { voAuth.getId() });
        } else {
            l = authDao.find("from Auth t where t.auth is null order by t.cseq");
        }
        return changeModel(l);
    }

    /**
     *
     * @param tauths
     * @return
     */
    private List<VoAuth> changeModel(List<Auth> tauths) {
        List<VoAuth> l = new ArrayList<VoAuth>();
        if (tauths != null && tauths.size() > 0) {
            for (Auth t : tauths) {
                VoAuth a = new VoAuth();
                BeanUtils.copyProperties(t, a);
                if (t.getAuth() != null) {
                    a.setPid(t.getAuth().getCid());
                    a.setPname(t.getAuth().getCname());
                }
                if (countChildren(t.getCid()) > 0) {
                    a.setState("closed");
                }
                l.add(a);
            }
        }
        return l;
    }
    /**
     * 统计有多少子节点
     */
    private Long countChildren(String pid) {
        return authDao.count("select count(*) from Auth t where t.auth.cid = ?", new Object[] { pid });
    }
    public void delete(VoAuth voAuth){
        del(voAuth.getCid());
    }

    /**
     *
     * @param cid
     */
    private void del(String cid) {
        Auth t = authDao.get(Auth.class, cid);
        if (t != null) {
            roleAuthDao.executeHql("delete RoleAuth t where t.auth = ?", new Object[] { t });
            Set<Auth> auths = t.getAuths();
            if (auths != null && !auths.isEmpty()) {
                // 说明当前权限下面还有子权限
                for (Auth tauth : auths) {
                    del(tauth.getCid());
                }
            }
            authDao.delete(t);
        }
    }
    public void edit(VoAuth voAuth) {
        Auth t = authDao.get(Auth.class, voAuth.getCid());// 要修改的权限
        BeanUtils.copyProperties(voAuth, t);
        if (voAuth.getPid() != null && !voAuth.getPid().equals(voAuth.getCid())) {
            Auth pAuth = authDao.get(Auth.class, voAuth.getPid());// 要设置的上级权限
            if (pAuth != null) {
                if (isDown(t, pAuth)) {// 要将当前节点修改到当前节点的子节点中
                    Set<Auth> tauths = t.getAuths();// 当前要修改的权限的所有下级权限
                    if (tauths != null && tauths.size() > 0) {
                        for (Auth tauth : tauths) {
                            if (tauth != null) {
                                tauth.setAuth(null);
                            }
                        }
                    }
                }
                t.setAuth(pAuth);
            }
        }
    }
    /**
     * 判断是否是将当前节点修改到当前节点的子节点
     *
     * @param t
     * @param pt
     * @return
     */
    private boolean isDown(Auth t, Auth pt) {
        if (pt.getAuth() != null) {
            if (pt.getAuth().getCid().equals(t.getCid())) {
                return true;
            } else {
                return isDown(t, pt.getAuth());
            }
        }
        return false;
    }
    public void add(VoAuth voAuth) {
        Auth t = new Auth();
        BeanUtils.copyProperties(voAuth, t);
        t.setCid(UUID.randomUUID().toString());
        if (voAuth.getPid() != null && !voAuth.getPid().equals(voAuth.getCid())) {
            t.setAuth(authDao.get(Auth.class, voAuth.getPid()));
        }
        authDao.save(t);
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TreeNode> tree(VoAuth voAuth, boolean b) {
        List<Object> param = new ArrayList<Object>();
        String hql = "from Auth t where t.auth is null order by t.cseq";
        if (voAuth != null && voAuth.getId() != null && !voAuth.getId().trim().equals("")) {
            hql = "from Auth t where t.auth.cid = ? order by t.cseq";
            param.add(voAuth.getId());
        }
        List<Auth> l = authDao.find(hql, param);
        List<TreeNode> tree = new ArrayList<TreeNode>();
        for (Auth t : l) {
            tree.add(this.tree(t, b));
        }
        return tree;
    }
    private TreeNode tree(Auth t, boolean recursive) {
        TreeNode node = new TreeNode();
        node.setId(t.getCid());
        node.setText(t.getCname());
        Map<String, Object> attributes = new HashMap<String, Object>();
        node.setAttributes(attributes);
        if (t.getAuths() != null && t.getAuths().size() > 0) {
            node.setState("closed");
            if (recursive) {// 递归查询子节点
                List<Auth> l = new ArrayList<Auth>(t.getAuths());
                Collections.sort(l, new AuthComparator());// 排序
                List<TreeNode> children = new ArrayList<TreeNode>();
                for (Auth r : l) {
                    TreeNode tn = tree(r, true);
                    children.add(tn);
                }
                node.setChildren(children);
                node.setState("open");
            }
        }
        return node;
    }
}
