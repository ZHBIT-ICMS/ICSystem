package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoRole;

import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/9
 * @Time:22:49
 * 描述：
 */
public interface RoleService {
    public DataGrid datagrid(VoRole voRole);
    public void add(VoRole voRole);

    public void edit(VoRole voRole);

    public void delete(String ids);

    public List<VoRole> combobox();
}
