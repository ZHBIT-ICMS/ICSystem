package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoInternationalStudent;
import com.zhbit.exception.ValidateFieldsException;
import com.zhbit.service.InternationalStudentService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/23
 * @Time:22:28
 * @Description：
 * 国际班学生Action
 */
public class InternationalStudentAction extends ActionSupport implements ModelDriven<VoInternationalStudent> {

private VoInternationalStudent voInternationalStudent = new VoInternationalStudent();

@Resource
private InternationalStudentService internationalStudentService;

@Override
    public VoInternationalStudent getModel() {
        return voInternationalStudent;
    }

    public String internationalStudent(){
     return  "internationalStudent";
    }
    public String internationalStudentAdd(){
        return "internationalStudentAdd";
    }
    public String internationalStudentEdit(){
        return "internationalStudentEdit";
    }
    public String intlsSummerCampEdit(){
        return "intlsSummerCamp";
    }
    public String intlsIeltsTrainEdit(){
        return "intlsIeltsTrain";
    }
    public String intlsIeltsExamEdit(){
        return "intlsIeltsExam";
    }

    /**
     * 国际班学生添加
     */
    public void add(){
        Json j = new Json();
        System.out.println("```````````````````````internationalStudentId::"+voInternationalStudent.getId());
        try {
            internationalStudentService.save(voInternationalStudent);
            j.setMsg("添加成功！");
            j.setSuccess(true);
        } catch (ValidateFieldsException e) {
            j.setMsg(e.getLocalizedMessage());
        }catch (Exception ex){
            j.setMsg("Exception!");
            ex.printStackTrace();
        }
        finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ResponseUtil出现异常！");
            }
        }
    }

    /**
     * 国际班学生编辑
     */
    public void edit() {
        Json j = new Json();
        try {
            internationalStudentService.update(voInternationalStudent);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
        } catch (ValidateFieldsException e) {
            j.setMsg(e.getLocalizedMessage());
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println("ResponseUtil出现异常！");
            }
        }
    }

    /**
     * 国际班学生删除
     */
    public void delete() {
        Json j = new Json();
        internationalStudentService.delete(voInternationalStudent.getIds());
        j.setSuccess(true);
        j.setMsg("删除成功!");
        try {
            String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil出现异常！");
            ex.printStackTrace();
        }
    }
    /**
     * 获得国际班学生datagrid
     */
    public void datagrid() {
       /* super.writeJson(userService.datagrid(user));*/
       JSONObject result = new JSONObject();
        try{
            JSONArray rows =JSONArray.fromObject(internationalStudentService.dataGrid(voInternationalStudent).getRows(),this.getJsonConfig()) ;
            long total =internationalStudentService.dataGrid(voInternationalStudent).getTotal();

            result.put("rows",rows);
            result.put("total",total);
        } catch (Exception ex){
            ex.printStackTrace();
        }
            try {
                ResponseUtil.write(ServletActionContext.getResponse(),result);
            }catch (Exception ex){
                ex.printStackTrace();
            }
    }

    /**
     * 国际班学生与夏令营活动批量编辑
     */
    public void IntlsAndSummerCampEdit() {
        System.out.println("ids:"+voInternationalStudent.getIds()+" summerCampIds:"+voInternationalStudent.getSummerCampIds());
        Json j = new Json();
        try {
            internationalStudentService.editSummerCamp(voInternationalStudent);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
        } catch (Exception e) {
            // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("编辑失败！");
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
     * 国际班学生与雅思培训批量编辑
     */
    public void IntlsAndIeltsTrainEdit() {
        System.out.println("ids:"+voInternationalStudent.getIds()+" ieltsTrainIds:"+voInternationalStudent.getIeltsTrainIds());
        Json j = new Json();
        try {
            internationalStudentService.editIeltsTrain(voInternationalStudent);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
        } catch (Exception e) {
            // logger.error(ExceptionUtil.getExceptionMessage(e));
            e.printStackTrace();
            j.setMsg("编辑失败！");
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
     * 国际班学生与雅思考试批量编辑
     */
    public void IntlsAndIeltsExamEdit() {
        System.out.println("ids:"+voInternationalStudent.getIds()+" ieltsExamIds:"+voInternationalStudent.getIeltsExamIds());
        Json j = new Json();
        try {
            internationalStudentService.editIeltsExam(voInternationalStudent);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
        } catch (Exception e) {
            // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("编辑失败！");
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
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }
}
