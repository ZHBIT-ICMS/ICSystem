package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoLoginLog;
import com.zhbit.service.LoginLogService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: ICSystem
 * @ClassName: LoginLogAction
 * @Description: 登录记录管理Action
 * @Author: wenxuan
 * @CreateDate: 2018/6/22 8:04
 */
public class LoginLogAction extends ActionSupport implements ModelDriven<VoLoginLog> {

    @Resource
    private LoginLogService loginLogService;
    private VoLoginLog voLoginLog=new VoLoginLog();
    @Override
    public VoLoginLog getModel() {
        return voLoginLog;
    }
    public String loginLog(){
        return  "loginLog";
    }


    /**
     * 获得LoginLog数据表格
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // 提交Json
        System.out.println("sort："+voLoginLog.getSort()+" order: "+voLoginLog.getOrder());
        JSONArray rows = JSONArray.fromObject(loginLogService.datagrid(voLoginLog).getRows(),this.getJsonConfig());
        long total = loginLogService.datagrid(voLoginLog).getTotal();
        JSONObject result = new JSONObject();
        result.put("rows",rows);
        result.put("total",total);
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),result);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
    }

    //删除登录记录信息
    public void delete() {
        Json j = new Json();
        try {
            loginLogService.delete(voLoginLog.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        } catch (Exception ex) {
            j.setMsg("删除失败！");
            System.out.println("登录记录信息删除失败！");
            ex.printStackTrace();
        } finally {
            try {
                String json = JSONObject.fromObject(j, this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(), json);
            } catch (Exception ex) {
                System.out.println("ResponseUtil出现异常！");
                ex.printStackTrace();
            }
        }
    }

    //导出登录记录信息到excel中
    public void exportExcel() {

        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        HttpServletResponse response= (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
        loginLogService.export(request,response);
    }

    /**
     * json过滤器
     * @return
     */
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd HH:mm:ss"));
        return config;
    }
}
