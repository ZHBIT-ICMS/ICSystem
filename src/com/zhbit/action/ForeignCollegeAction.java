package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoForeignCollege;
import com.zhbit.service.ForeignCollegeService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/20
 * @Time:22:47
 * 描述：
 * ForeignCollegeAction
 */
public class ForeignCollegeAction extends ActionSupport implements ModelDriven<VoForeignCollege>{

    @Resource
    private ForeignCollegeService foreignCollegeService;
    private VoForeignCollege voForeignCollege = new VoForeignCollege();
    @Override
    public VoForeignCollege getModel() {
        return voForeignCollege;
    }
    public String foreignColleges(){
        return  "foreignColleges";
    }
    public String foreignCollegesAdd(){
        return  "foreignCollegesAdd";
    }
    public String foreignCollegesEdit(){
        return "foreignCollegesEdit";
    }

    /**
     * 返回easyUI的datagrid
     */
    public void datagrid(){
        JSONArray rows = JSONArray.fromObject(foreignCollegeService.datagrid(voForeignCollege).getRows(),this.getJsonConfig());
        long total = foreignCollegeService.datagrid(voForeignCollege).getTotal();
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

    /**
     * 国外院校删除
     */
    public void delete(){
        Json j = new Json();
        try {
            foreignCollegeService.delete(voForeignCollege.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("国外院校删除失败！");
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
     * 国外院校添加
     */
    public void add(){
        Json j = new Json();
        try {
            foreignCollegeService.add(voForeignCollege);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("学院添加失败！");
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
     * 国外院校信息编辑
     */
    public void edit(){
        Json j = new Json();
        try {
            foreignCollegeService.edit(voForeignCollege);
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
     *获取学院下拉列表
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(foreignCollegeService.combobox(),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil异常！");
            ex.printStackTrace();
        }
    }
    /**
     * Json过滤器
     * @return
     */
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }
}
