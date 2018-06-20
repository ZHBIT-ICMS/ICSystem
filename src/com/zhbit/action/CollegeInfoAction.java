package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoCollegeInfo;
import com.zhbit.service.CollegeInfoService;
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
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:44
 * 描述：
 */
public class CollegeInfoAction extends ActionSupport implements ModelDriven<VoCollegeInfo> {
    @Resource
    private CollegeInfoService collegeInfoService;

    private VoCollegeInfo voCollegeInfo = new VoCollegeInfo();

    @Override
    public VoCollegeInfo getModel() {
        return voCollegeInfo;
    }


    public String collegeInfos(){
        return  "collegeInfos";
    }
    public String collegeInfosAdd(){
        return  "collegeInfosAdd";
    }
    public String collegeInfosEdit(){
        return "collegeInfosEdit";
    }

    /**
     *返回easyUI的datagrid
     */
    public void datagrid(){
     JSONArray rows = JSONArray.fromObject(collegeInfoService.datagrid(voCollegeInfo).getRows(),this.getJsonConfig());
     long total = collegeInfoService.datagrid(voCollegeInfo).getTotal();
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
     * 学院删除
     */
    public void delete(){
        Json j = new Json();
        try {
            collegeInfoService.delete(voCollegeInfo.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("学院删除失败！");
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
     * 学院添加
     */
    public void add(){
        Json j = new Json();
        try {
            collegeInfoService.add(voCollegeInfo);
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
     * 学院信息编辑
     */
    public void edit(){
        Json j = new Json();
        try {
            collegeInfoService.edit(voCollegeInfo);
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
        String json= JSONArray.fromObject(collegeInfoService.combobox(),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil异常！");
            ex.printStackTrace();
        }
    }
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }
}
