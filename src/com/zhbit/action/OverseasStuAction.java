package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoOverseasStu;
import com.zhbit.service.OverseasStuService;
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
 * @ProjectName: ICSystem
 * @ClassName: OverseasStuAction
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/20 23:43
 */
public class OverseasStuAction  extends ActionSupport implements ModelDriven<VoOverseasStu> {
    @Resource
    private OverseasStuService overseasStuService;
    private VoOverseasStu voOverseasStu=new VoOverseasStu();
    @Override
    public VoOverseasStu getModel() {
        return voOverseasStu;
    }
    public String overseasStu(){
        return  "overseasStu";
    }
    public String overseasStuAdd(){
        return  "overseasStuAdd";
    }

    //修改出国生信息
    public String overseasStuEdit(){
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        request.setAttribute("content",overseasStuService.getOverseasStuById(voOverseasStu.getId()));
        return "overseasStuEdit";
    }

    /**
     * 获得OverseasStu数据表格
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // 提交Json
        System.out.println("sort："+voOverseasStu.getSort()+" order: "+voOverseasStu.getOrder());
        JSONArray rows = JSONArray.fromObject(overseasStuService.datagrid(voOverseasStu).getRows(),this.getJsonConfig());
        long total = overseasStuService.datagrid(voOverseasStu).getTotal();
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

    //删除出国生信息
    public void delete() {
        Json j = new Json();
        try {
            overseasStuService.delete(voOverseasStu.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        } catch (Exception ex) {
            j.setMsg("删除失败！");
            System.out.println("出国生信息删除失败！");
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
    /**
     * 添加出国生信息
     */
    public void add(){
        Json j = new Json();
        try {
            overseasStuService.add(voOverseasStu);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("出国生信息添加失败！");
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
     * 修改出国生信息
     */
    public void edit(){
        Json j = new Json();
        try {
            overseasStuService.update(voOverseasStu);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
            System.out.println("出国生信息修改失败！");
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
     *获取出国生下拉列表
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(overseasStuService.combobox(),this.getJsonConfig()).toString();
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
