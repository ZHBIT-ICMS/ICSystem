package com.zhbit.service;

import com.zhbit.entity.User;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoUser;
import com.zhbit.exception.ValidateFieldsException;

import javax.xml.bind.ValidationException;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/8
 * @Time:15:42
 * 描述：
 * 用户服务接口
 */
public interface UserService {
    public VoUser login(VoUser voUser);
    public void save(VoUser voUser) throws ValidateFieldsException;
    public DataGrid dataGrid(VoUser voUser);
    public void delete(String ids);
    public void update(VoUser voUser)throws ValidateFieldsException;
    public void roleEdit(VoUser voUser);
    public void editUserInfo(VoUser voUser);
}
