package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoSummerCamp;
import com.zhbit.service.ForeignCollegeService;
import com.zhbit.service.SummerCampService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:23:24
 * @Description描述：
 */
public class SummerCampAction extends ActionSupport implements ModelDriven<VoSummerCamp> {
 @Resource
 private SummerCampService summerCampService;
 @Resource
 private ForeignCollegeService foreignCollegeService;

 private VoSummerCamp voSummerCamp = new VoSummerCamp();

    @Override
    public VoSummerCamp getModel() {
        return voSummerCamp;
    }
    public String summerCamps(){
        return  "summerCamps";
    }
    public String summerCampsAdd(){
        return  "summerCampsAdd";
    }
    public String summerCampsEdit(){
        return "summerCampsEdit";
    }

    public void datagrid(){
        JSONArray rows = JSONArray.fromObject(summerCampService.dataGrid(voSummerCamp).getRows(),this.getJsonConfig());
        long total = summerCampService.dataGrid(voSummerCamp).getTotal();
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

    public void delete(){
        Json j = new Json();
        try {
            summerCampService.delete(voSummerCamp.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("夏令营活动删除失败！");
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

    public void add(){
        Json j = new Json();

        try {
            summerCampService.add(voSummerCamp);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("夏令营活动添加失败！");
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

    public void edit(){
        Json j = new Json();
        try {
            summerCampService.edit(voSummerCamp);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
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
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(summerCampService.combobox(),this.getJsonConfig()).toString();
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
