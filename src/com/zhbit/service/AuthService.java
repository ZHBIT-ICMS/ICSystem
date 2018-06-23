package com.zhbit.service;

import com.zhbit.entity.base.TreeNode;
import com.zhbit.entity.vo.VoAuth;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:17:00
 * 描述：
 */
public interface AuthService {
    public List<VoAuth> treegrid(VoAuth voAuth);

    public void delete(VoAuth voAuth);

    public void edit(VoAuth voAuth);

    public void add(VoAuth voAuth);

    /**
     * 获取权限树
     *
     * @param voAuth
     * @param b
     *            是否递归子节点
     * @return
     */
    public List<TreeNode> tree(VoAuth voAuth, boolean b);
}
