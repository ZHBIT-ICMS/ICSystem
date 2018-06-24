package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoClassesInfo;
import com.zhbit.exception.ValidateFieldsException;
import com.zhbit.service.ClassesInfoService;
import com.zhbit.service.CollegeInfoService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/19
 * @Time:23:55 描述：
 */
public class ClassesInfoAction extends ActionSupport implements ModelDriven<VoClassesInfo> {
   @Resource
    private ClassesInfoService classesInfoService;
   @Resource
    private CollegeInfoService collegeInfoService;

    private VoClassesInfo voClassesInfo = new VoClassesInfo();
    @Override
    public VoClassesInfo getModel() {
        return voClassesInfo;
    }
    public String classesInfos(){
        return  "classesInfos";
    }
    public String classesInfosAdd(){
        return  "classesInfosAdd";
    }
    public String classesInfosEdit(){
        return "classesInfosEdit";
    }
    public void datagrid(){
        JSONArray rows = JSONArray.fromObject(classesInfoService.dataGrid(voClassesInfo).getRows(),this.getJsonConfig());
        long total = classesInfoService.dataGrid(voClassesInfo).getTotal();
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
     *班级删除
     */
    public void delete(){
        Json j = new Json();
        try {
            classesInfoService.delete(voClassesInfo.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("班级删除失败！");
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
     * 班级添加
     */
    public void add(){
        Json j = new Json();
        System.out.println("classNo: "+ voClassesInfo.getClassNo()+" className:"+voClassesInfo.getDescInfo()+" collegeId:"+voClassesInfo.getCollegeId());
        try {
            classesInfoService.add(voClassesInfo);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (ValidateFieldsException ex){
            j.setMsg(ex.getLocalizedMessage());
            System.out.println("班级添加失败！");
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
     * 班级信息编辑
     */
    public void edit(){
        Json j = new Json();
        try {
            classesInfoService.edit(voClassesInfo);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (ValidateFieldsException ex){
            j.setMsg(ex.getLocalizedMessage());
            System.out.println("班级信息修改失败！");
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
     *获取班级下拉列表
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(classesInfoService.combobox(),this.getJsonConfig()).toString();
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
