package com.zhbit.service.impl;

import com.zhbit.comparator.MenuComparator;
import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.Menu;
import com.zhbit.entity.base.TreeNode;
import com.zhbit.entity.vo.VoMenu;
import com.zhbit.service.MenuService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:16:16
 * 描述：
 */
@Service("menuService")
public class MenuServiceImpl extends  BaseServiceImpl implements MenuService {
    private BaseDAO<Menu> menuDao;

    public BaseDAO<Menu> getMenuDao() {
        return menuDao;
    }
    @Autowired
    public void setMenuDao(BaseDAO<Menu> menuDao) {
        this.menuDao = menuDao;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoMenu> findAll() {
        List<VoMenu> lm = new ArrayList<VoMenu>();
        String hql = "from Menu m order by m.cseq";
        List<Menu> ltm = menuDao.find(hql);
        for (Menu tm : ltm) {
            VoMenu vm = new VoMenu();
            vm.setCid(tm.getCid());
            vm.setCname(tm.getCname());
            vm.setCiconcls(tm.getCiconcls());
            vm.setCurl(tm.getCurl());
            if(tm.getMenu()!=null){
                vm.setPid(tm.getMenu().getCid());
            }
            lm.add(vm);
        }
        return lm;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TreeNode> tree(VoMenu voMenu, Boolean b) {
        List<Object> param = new ArrayList<Object>();
        String hql = "from Menu t where t.menu is null order by t.cseq";
        if (voMenu != null && voMenu.getId() != null && !voMenu.getId().trim().equals("")) {
            hql = "from Menu t where t.menu.cid = ? order by t.cseq";
            param.add(voMenu.getId());
        }
        List<Menu> l = menuDao.find(hql, param);
        List<TreeNode> tree = new ArrayList<TreeNode>();
        for (Menu t : l) {
            tree.add(this.tree(t, b));
        }
        return tree;
    }
    private TreeNode tree(Menu t, boolean recursive) {
        TreeNode node = new TreeNode();
        node.setId(t.getCid());
        node.setText(t.getCname());
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("url", t.getCurl());
        node.setAttributes(attributes);
        if (t.getCiconcls() != null) {
            node.setIconCls(t.getCiconcls());
        } else {
            node.setIconCls("");
        }
        if (t.getMenus() != null && t.getMenus().size() > 0) {
            node.setState("closed");
            if (recursive) {// 递归查询子节点
                List<Menu> l = new ArrayList<Menu>(t.getMenus());
                Collections.sort(l, new MenuComparator());// 排序
                List<TreeNode> children = new ArrayList<TreeNode>();
                for (Menu r : l) {
                    TreeNode tn = tree(r, true);
                    children.add(tn);
                }
                node.setChildren(children);
                node.setState("open");
            }
        }
        return node;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VoMenu> treegrid(VoMenu voMenu) {
        List<Menu> l;
        if (voMenu != null && voMenu.getId() != null) {
            l = menuDao.find("from Tmenu t where t.tmenu.cid = ? order by t.cseq", new Object[] { voMenu.getId() });
        } else {
            l = menuDao.find("from Tmenu t where t.tmenu is null order by t.cseq");
        }
        return changeModel(l);
    }
    private List<VoMenu> changeModel(List<Menu> Tmenus) {
        List<VoMenu> l = new ArrayList<VoMenu>();
        if (Tmenus != null && Tmenus.size() > 0) {
            for (Menu t : Tmenus) {
                VoMenu m = new VoMenu();
                BeanUtils.copyProperties(t, m);
                if (t.getMenu() != null) {
                    m.setPid(t.getMenu().getCid());
                    m.setPname(t.getMenu().getCname());
                }
                if (countChildren(t.getCid()) > 0) {
                    m.setState("closed");
                }
                if (t.getCiconcls() == null) {
                    m.setIconCls("");
                } else {
                    m.setIconCls(t.getCiconcls());
                }
                l.add(m);
            }
        }
        return l;
    }

    /**
     * 统计有多少子节点
     * @param pid
     * @return
     */
    private Long countChildren(String pid) {
        return menuDao.count("select count(*) from Menu t where t.menu.cid = ?", new Object[] { pid });
    }
    public void delete(VoMenu voMenu){
        del(voMenu.getCid());
    }
    private void del(String cid) {
        Menu t = menuDao.get(Menu.class, cid);
        if (t != null) {
            Set<Menu> menus = t.getMenus();
            if (menus != null && !menus.isEmpty()) {
                // 说明当前菜单下面还有子菜单
                for (Menu tmenu : menus) {
                    del(tmenu.getCid());
                }
            }
            menuDao.delete(t);
        }
    }

    public void add(VoMenu voMenu) {
        Menu t = new Menu();
        BeanUtils.copyProperties(voMenu, t);
        t.setCid(UUID.randomUUID().toString());
        if (voMenu.getPid() != null) {
            t.setMenu(menuDao.get(Menu.class, voMenu.getPid()));
        }
        if (voMenu.getIconCls() != null) {
            t.setCiconcls(voMenu.getIconCls());
        }
        menuDao.save(t);
    }
    public void edit(VoMenu voMenu) {
        Menu t = menuDao.get(Menu.class, voMenu.getCid());
        BeanUtils.copyProperties(voMenu, t);
        if (voMenu.getIconCls() != null) {
            t.setCiconcls(voMenu.getIconCls());
        }
        if (voMenu.getPid() != null && !voMenu.getPid().equals(voMenu.getCid())) {
            Menu pt = menuDao.get(Menu.class, voMenu.getPid());
            if (pt != null) {
                if (isDown(t, pt)) {// 要将当前节点修改到当前节点的子节点中
                    Set<Menu> tmenus = t.getMenus();// 当前要修改的节点的所有下级节点
                    if (tmenus != null && tmenus.size() > 0) {
                        for (Menu tmenu : tmenus) {
                            if (tmenu != null) {
                                tmenu.setMenu(null);
                            }
                        }
                    }
                }
                t.setMenu(pt);
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
    private boolean isDown(Menu t, Menu pt) {
        if (pt.getMenu() != null) {
            if (pt.getMenu().getCid().equals(t.getCid())) {
                return true;
            } else {
                return isDown(t, pt.getMenu());
            }
        }
        return false;
    }
}
