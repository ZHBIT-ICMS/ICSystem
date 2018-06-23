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
public class IELTSTExamAction extends ActionSupport implements ModelDriven<VoIELTSExam> {
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
     * �����˼��ѵ�����ݱ��
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // �ύJson
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
            System.out.println("ResponseUtil�쳣��");
            e.printStackTrace();
        }
    }

    /**
     * ɾ����˼��ѵ
     */
    public void delete() {
        Json j = new Json();
        try {
            ieltstExamService.delete(voIELTSExam.getIds());
            j.setSuccess(true);
            j.setMsg("ɾ���ɹ���");
        }catch (Exception ex){
            j.setMsg("ɾ��ʧ�ܣ�");
            System.out.println("ɾ��ʧ�ܣ�");
            ex.printStackTrace();
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            }catch (Exception ex){
                System.out.println("ResponseUtil�����쳣��");
                ex.printStackTrace();
            }
        }
    }

    /**
     * ������˼��ѵ
     */
    public void add() {
        Json j = new Json();
         try {
             ieltstExamService.add(voIELTSExam);
            j.setSuccess(true);
            j.setMsg("��ӳɹ���");
        }catch (Exception ex){
            j.setMsg("���ʧ�ܣ�");
            System.out.println("���ʧ�ܣ�");
            ex.printStackTrace();
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            }catch (Exception ex){
                System.out.println("ResponseUtil�����쳣��");
                ex.printStackTrace();
            }
        }
    }

    /**
     * ��˼��ѵ�༭
     */
    public void edit() {
        Json j = new Json();
        try {
            ieltstExamService.edit(voIELTSExam);
            j.setSuccess(true);
            j.setMsg("�޸ĳɹ���");
        }catch (Exception ex){
            j.setMsg("�޸�ʧ�ܣ�");
            System.out.println("�޸�ʧ�ܣ�");
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
     *��ȡѧԺ�����б�
     */
    public void doNotNeedSession_combobox() {
        String json= JSONArray.fromObject(ieltstExamService.combobox(),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil�쳣��");
            ex.printStackTrace();
        }
    }
    /**
     * json������
     * @return
     */
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd HH:mm:ss"));
        return config;
    }
}