package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoRole;
import com.zhbit.service.RoleService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/12
 * @Time:22:10
 * 描述：RoleAction
 */
public class RoleAction extends ActionSupport implements ModelDriven<VoRole> {
    private VoRole voRole = new VoRole();
    @Resource
    private RoleService roleService;

    @Override
    public VoRole getModel() {
        return voRole;
    }

    public String role() {
        return "role";
    }

    public String roleAdd() {
        return "roleAdd";
    }

    public String roleEdit() {
        return "roleEdit";
    }
    /**
     * 获得角色datagrid
     */
    public void datagrid() {
       // super.writeJson(roleService.datagrid(role));
        String json= JSONObject.fromObject(roleService.datagrid(voRole),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 添加一个角色
     */
    public void add() {
        Json j = new Json();
        try {
            roleService.add(voRole);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        } catch (Exception e) {
            j.setMsg("添加失败！");
            //logger.error(ExceptionUtil.getExceptionMessage(e));
        }finally {
            String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
            try {
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            } catch (Exception e) {
                System.out.println("ResponseUtil异常！");
                e.printStackTrace();
            }
        }

    }

    /**
     * 编辑一个角色
     */
    public void edit() {
        Json j = new Json();
        try {
            roleService.edit(voRole);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
        } catch (Exception e) {
            //logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("编辑失败！");
        }finally {
            String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
            try {
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            } catch (Exception e) {
                System.out.println("ResponseUtil异常！");
                e.printStackTrace();
            }
        }
        //super.writeJson(j);
    }

    /**
     * 删除一个或多个角色
     */
    public void delete() {
        Json j = new Json();
        roleService.delete(voRole.getIds());
        j.setSuccess(true);
        j.setMsg("删除成功！");
        String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
    }

    /**
     * 获得角色下拉列表
     */
    public void doNotNeedSession_combobox() {
       // super.writeJson(roleService.combobox());
        String json= JSONArray.fromObject(roleService.combobox(),this.getJsonConfig()).toString();
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
