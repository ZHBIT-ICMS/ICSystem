package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoClassesInfo;
import com.zhbit.entity.vo.VoIELTSExam;
import com.zhbit.entity.vo.VoIELTSTrain;
import com.zhbit.service.IELTSTExamService;
import com.zhbit.service.IELTSTInfoService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * Created by wby on 2018/6/20.
 */
public class IELTSExamAction extends ActionSupport implements ModelDriven<VoIELTSExam> {
    @Resource
    private IELTSTExamService ieltstExamService;

    public IELTSTExamService getIeltstExamService() {
        return ieltstExamService;
    }

    public void setIeltstExamService(IELTSTExamService ieltstExamService) {
        this.ieltstExamService = ieltstExamService;
    }

    private VoIELTSExam voIELTSExam = new VoIELTSExam();

    @Override
    public VoIELTSExam getModel() {
        return voIELTSExam;
    }

    public String exam() {
        return "ieltstExam";
    }

    public String ieltstExamAdd() {
        return "ieltstExamAdd";
    }

    public String ieltstExamEdit() {
        return "ieltstExamEdit";
    }

    /**
     * 获得雅思培训的数据表格
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // 提交Json
        System.out.println("11111111111111111111111111111111111");
        JSONArray rows = JSONArray.fromObject(ieltstExamService.dataGrid(voIELTSExam).getRows(),this.getJsonConfig());
        long total = ieltstExamService.dataGrid(voIELTSExam).getTotal();
        System.out.println("11111111111111111111111111111111111222222222");
        JSONObject result = new JSONObject();
        System.out.println(voIELTSExam.getTrainName()+"777777777777");
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
     * 删除雅思培训
     */
    public void delete() {
        Json j = new Json();
        try {
            ieltstExamService.delete(voIELTSExam.getIds());
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
            ieltstExamService.add(voIELTSExam);
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
            ieltstExamService.edit(voIELTSExam);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
            System.out.println("修改失败！");
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
     *获取雅思考试下拉列表
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(ieltstExamService.combobox(),this.getJsonConfig()).toString();
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