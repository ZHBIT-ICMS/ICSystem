package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoChair;
import com.zhbit.service.ChairService;
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
 * @Date 2018/6/21
 * @Time:10:10
 * 描述：
 */
public class ChairAction extends ActionSupport implements ModelDriven<VoChair> {

    @Resource
    private ChairService chairService;
    @Resource
    private ForeignCollegeService foreignCollegeService;
    private  VoChair voChair = new VoChair();
    @Override
    public VoChair getModel() {
        return voChair;
    }
    public String chairs(){
        return  "chairs";
    }
    public String chairsAdd(){
        return  "chairsAdd";
    }
    public String chairsEdit(){
        return "chairsEdit";
    }

    /**
     * EasyUI的datagrid
     */
    public void datagrid(){
        JSONArray rows = JSONArray.fromObject(chairService.dataGrid(voChair).getRows(),this.getJsonConfig());
        long total = chairService.dataGrid(voChair).getTotal();
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
            chairService.delete(voChair.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("讲座删除失败！");
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
            chairService.add(voChair);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("讲座添加失败！");
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
            chairService.edit(voChair);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
            System.out.println("讲座修改失败！");
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
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }
}
