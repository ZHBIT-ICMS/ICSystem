package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoExchangeStu;
import com.zhbit.service.ExchangeStuService;
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
 * @ClassName: ExchangeStuAction
 * @Description: 交换生信息
 * @Author: wenxuan
 * @CreateDate: 2018/6/20 15:23
 */
public class ExchangeStuAction extends ActionSupport implements ModelDriven<VoExchangeStu>{
   @Resource
    private ExchangeStuService exchangeStuService;
    private VoExchangeStu voExchangeStu=new VoExchangeStu();
    @Override
    public VoExchangeStu getModel() {
        return voExchangeStu;
    }
    public String exchangeStu(){
        return  "exchangeStu";
    }
    public String exchangeStuAdd(){
        return  "exchangeStuAdd";
    }

    //修改交换生信息
    public String exchangeStuEdit(){
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        request.setAttribute("content",exchangeStuService.getExchangeStuById(voExchangeStu.getId()));
        return "exchangeStuEdit";
    }

    /**
     * 获得ExchangeStu数据表格
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // 提交Json
        System.out.println("sort："+voExchangeStu.getSort()+" order: "+voExchangeStu.getOrder());
        JSONArray rows = JSONArray.fromObject(exchangeStuService.datagrid(voExchangeStu).getRows(),this.getJsonConfig());
        long total = exchangeStuService.datagrid(voExchangeStu).getTotal();
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

    //删除交换生信息
    public void delete() {
        Json j = new Json();
        try {
            exchangeStuService.delete(voExchangeStu.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        } catch (Exception ex) {
            j.setMsg("删除失败！");
            System.out.println("交换生信息删除失败！");
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
     * 添加交换生信息
     */
    public void add(){
        Json j = new Json();
        try {
            exchangeStuService.add(voExchangeStu);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("交换生信息添加失败！");
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
     * 修改交换生信息
     */
    public void edit(){
        Json j = new Json();
        try {
            exchangeStuService.update(voExchangeStu);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
            System.out.println("交换生信息修改失败！");
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
     *获取交换生下拉列表
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(exchangeStuService.combobox(),this.getJsonConfig()).toString();
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
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }
}
