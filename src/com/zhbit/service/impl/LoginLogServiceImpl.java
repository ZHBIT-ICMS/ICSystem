package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.LoginLog;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoLoginLog;
import com.zhbit.service.LoginLogService;
import com.zhbit.util.ExportExcelKit;
import com.zhbit.util.ExportExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: ICSystem
 * @ClassName: LoginLogServiceImpl
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/22 8:03
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    private BaseDAO<LoginLog> baseDAO;

    public BaseDAO<LoginLog> getBaseDAO() {
        return baseDAO;
    }
    @Autowired
    public void setBaseDAO(BaseDAO<LoginLog> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public LoginLog getLoginLogById(int loginLogId) {
        return baseDAO.get(LoginLog.class,loginLogId);
    }

    @Override
    public DataGrid datagrid(VoLoginLog voLoginLog) {
        DataGrid j = new DataGrid();
        j.setRows(this.changeModel(this.find(voLoginLog)));
        j.setTotal(total(voLoginLog));
        return j;
    }

    @Override
    public void delete(String ids) {
        if (ids != null) {
            for (String id : ids.split(",")) {
                LoginLog t = baseDAO.get(LoginLog.class, Integer.parseInt(id));
                System.out.println("```````````````````````````````删除登录记录id为"+id);
                if (t != null) {
                    baseDAO.delete(t);
                }
            }
        }
    }

    /**
     * 导出excel表中去
     */
    @Override
    public void export(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> columns = Arrays.asList(new String[]{"ID","登录用户","IP地址","登录时间","操作系统"});
        ExportExcelUtil exportData = new ExportExcelUtil();
        exportData.setDatas(getDataList());
        exportData.setFileName("登录记录_"+format.format(new Date()));
        exportData.setSheetName("登录记录");
        exportData.setTitleName("登录记录");
        exportData.setColumnNames(columns);
        exportData.setResponse(response);
        ExportExcelKit.setFileDownloadHeader(exportData.getFileName(), response, request);
        HSSFWorkbook book = new HSSFWorkbook();
        new ExportExcelKit(book).exportExcel(exportData);
        try {
            book.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<List<String>> getDataList(){

        List<LoginLog> list  = this.getLoginLogList();
        List<List<String>> datas = new ArrayList<List<String>>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (LoginLog model : list) {
            List<String> rowdata = new ArrayList<String>();
            rowdata.add(String.valueOf(model.getId()));
            rowdata.add(String.valueOf(model.getUserNo()));
            rowdata.add(String.valueOf(model.getLoginIp()));
            rowdata.add(String.valueOf(format.format(model.getLoginTime())));
            rowdata.add(String.valueOf(model.getUserAgent()));
            datas.add(rowdata);
        }
        return datas;
    }

    /**
     * 将LoginLog转换成voLoginLog（视图层模型）
     */
    private List<VoLoginLog> changeModel(List<LoginLog> loginLogList) {
        List<VoLoginLog> voLoginLogList = new ArrayList<VoLoginLog>();
        if (loginLogList != null && loginLogList.size() > 0) {
            for (LoginLog tn : loginLogList) {
                VoLoginLog vn= new VoLoginLog();
                BeanUtils.copyProperties(tn, vn);
                voLoginLogList.add(vn);
            }
        }
        return voLoginLogList;
    }

    private List<LoginLog> find(VoLoginLog voLoginLog) {
        String hql = " from LoginLog t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voLoginLog, hql, values);
        if (voLoginLog.getSort() != null && voLoginLog.getOrder() != null) {
            hql += " order by " + voLoginLog.getSort() + " " + voLoginLog.getOrder();
        }
        PageBean pageBean = new PageBean(voLoginLog.getPage(),voLoginLog.getRows());
        return baseDAO.find(hql, values,  pageBean);
    }

    private List<LoginLog> getLoginLogList() {
        String hql = " from LoginLog t where 1=1 ";
        List<Object> values = new ArrayList<Object>();
        return baseDAO.find(hql);
    }

    private String addWhere(VoLoginLog voLoginLog, String hql, List<Object> values) {
        String where;
        String userNo=voLoginLog.getUserNo();
        if(userNo!=null) {
            where = " t.userNo like '%" + userNo + "%'";
        }else{
            where=" 1=1";
        }
        hql=hql+where+" ";
        return hql;
    }

    /**
     *计算登录记录信息条数
     */
    private Long total(VoLoginLog voLoginLog) {
        String hql = "select count(*) from LoginLog t where ";
        List<Object> values = new ArrayList<Object>();
        hql = addWhere(voLoginLog, hql, values);
        return baseDAO.count(hql, values);
    }
}
