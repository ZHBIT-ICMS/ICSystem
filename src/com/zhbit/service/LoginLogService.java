package com.zhbit.service;

import com.zhbit.entity.LoginLog;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoLoginLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @ProjectName: ICSystem
 * @ClassName: LoginLogService
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/22 8:02
 */
public interface LoginLogService {


    public LoginLog getLoginLogById(int loginLogId);

    public DataGrid datagrid(VoLoginLog voLoginLog);

    //删除
    public void delete(String ids);

    //导出excel
    public void export(HttpServletRequest request, HttpServletResponse response);

}
