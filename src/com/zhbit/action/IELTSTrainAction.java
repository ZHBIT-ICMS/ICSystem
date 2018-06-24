package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoIELTSTrain;
import com.zhbit.entity.vo.VoNews;
import com.zhbit.service.IELTSTInfoService;
import com.zhbit.service.NewsService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wby on 2018/6/20.
 */
public class IELTSTrainAction extends ActionSupport implements ModelDriven<VoIELTSTrain> {
    @Resource
    private IELTSTInfoService ieltstInfoService;

    public IELTSTInfoService getIeltstInfoService() {
        return ieltstInfoService;
    }

    public void setIeltstInfoService(IELTSTInfoService ieltstInfoService) {
        this.ieltstInfoService = ieltstInfoService;
    }

    public VoIELTSTrain getVoIELTSTrain() {
        return voIELTSTrain;
    }

    public void setVoIELTSTrain(VoIELTSTrain voIELTSTrain) {
        this.voIELTSTrain = voIELTSTrain;
    }

    private VoIELTSTrain voIELTSTrain = new VoIELTSTrain();

    @Override
    public VoIELTSTrain getModel() {
        return voIELTSTrain;
    }

    public String train() {
        return "ieltstInfos";
    }

    public String ieltstAdd() {
        return "ieltstAdd";
    }

    public String ieltstEdit() {
        return "ieltstEdit";
    }

    /**
     * 获得雅思培训的数据表格
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // 提交Json
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        JSONArray rows = JSONArray.fromObject(ieltstInfoService.dataGrid(voIELTSTrain).getRows(), this.getJsonConfig());
        long total = ieltstInfoService.dataGrid(voIELTSTrain).getTotal();
        JSONObject result = new JSONObject();
        System.out.println(rows+"aaaaaaaaaaaaaaaaaa");
        result.put("rows", rows);
        result.put("total", total);
        try {
            ResponseUtil.write(ServletActionContext.getResponse(), result);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
    }

    /**
     * 删除雅思培训
     */
    public void delete() {
        Json j = new Json();
        try {
            ieltstInfoService.delete(voIELTSTrain.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("删除失败！");
            ex.printStackTrace();
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            }catch (Exception ex){
                System.out.println("ResponseUtil出现异常！");
                ex.printStackTrace();
            }
        }
    }

    /**
     * 增加雅思培训
     */
    public void add() {
        Json j = new Json();
        try {
            ieltstInfoService.add(voIELTSTrain);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("添加失败！");
            ex.printStackTrace();
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            }catch (Exception ex){
                System.out.println("ResponseUtil出现异常！");
                ex.printStackTrace();
            }
        }
    }

    /**
     * 雅思培训编辑
     */
    public void edit() {
        Json j = new Json();
        try {
            ieltstInfoService.edit(voIELTSTrain);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
            System.out.println("学院信息修改失败！");
            ex.printStackTrace();
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    /**
     *获取雅思培训下拉列表
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(ieltstInfoService.combobox(),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil异常！");
            ex.printStackTrace();
        }
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