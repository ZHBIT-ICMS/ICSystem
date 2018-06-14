package com.zhbit.service;

import com.zhbit.entity.Menu;
import com.zhbit.entity.base.TreeNode;
import com.zhbit.entity.vo.VoMenu;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:16:12
 * 描述：
 */
public interface MenuService {
    /**
     * 获取菜单树
     *
     * @param
     * @param b
     *            是否递归子节点
     * @return
     */
    public List<TreeNode> tree(VoMenu voMenu, Boolean b);

    /**
     * 获得菜单treegrid
     *
     * @param voMenu
     * @return
     */
    public List<VoMenu> treegrid(VoMenu voMenu);

    /**
     * 删除菜单
     *
     * @param voMenu
     */
    public void delete(VoMenu voMenu);

    /**
     * 添加菜单
     *
     * @param voMenu
     */
    public void add(VoMenu voMenu);

    /**
     * 编辑菜单
     *
     * @param voMenu
     */
    public void edit(VoMenu voMenu);

    /**
     * 查询所有菜单项
     *
     * @param
     */
    public List<VoMenu> findAll();

}
