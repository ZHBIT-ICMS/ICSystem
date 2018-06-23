package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoIELTSTrain;
import com.zhbit.entity.vo.VoNews;
import com.zhbit.service.IELTSTInfoService;
import com.zhbit.service.NewsService;
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
 * Created by wby on 2018/6/20.
 */
public class IELTSTInfoAction extends ActionSupport implements ModelDriven<VoIELTSTrain> {
    @Resource
    private IELTSTInfoService ieltstInfoService;

    public IELTSTInfoService getIeltstInfoService() {
        return ieltstInfoService;
    }

    public void setIeltstInfoService(IELTSTInfoService ieltstInfoService) {
        this.ieltstInfoService = ieltstInfoService;
    }

    public VoIELTSTrain getVoIELTSTrain() {
        return voIELTSTrain;
    }

    public void setVoIELTSTrain(VoIELTSTrain voIELTSTrain) {
        this.voIELTSTrain = voIELTSTrain;
    }

    private VoIELTSTrain voIELTSTrain = new VoIELTSTrain();

    @Override
    public VoIELTSTrain getModel() {
        return voIELTSTrain;
    }

    public String train() {
        return "ieltstInfos";
    }

    public String ieltstAdd() {
        return "ieltstAdd";
    }

    public String ieltstEdit() {
        return "ieltstEdit";
    }

    /**
     * �����˼��ѵ�����ݱ��
     */
    public void datagrid() {
        //super.writeJson(bugService.datagrid(bug));
        // �ύJson
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        JSONArray rows = JSONArray.fromObject(ieltstInfoService.dataGrid(voIELTSTrain).getRows(), this.getJsonConfig());
        long total = ieltstInfoService.dataGrid(voIELTSTrain).getTotal();
        JSONObject result = new JSONObject();
        System.out.println(rows+"aaaaaaaaaaaaaaaaaa");
        result.put("rows", rows);
        result.put("total", total);
        try {
            ResponseUtil.write(ServletActionContext.getResponse(), result);
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
            ieltstInfoService.delete(voIELTSTrain.getIds());
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
            ieltstInfoService.add(voIELTSTrain);
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
            ieltstInfoService.edit(voIELTSTrain);
            j.setSuccess(true);
            j.setMsg("�޸ĳɹ���");
        }catch (Exception ex){
            j.setMsg("�޸�ʧ�ܣ�");
            System.out.println("ѧԺ��Ϣ�޸�ʧ�ܣ�");
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
        String json= JSONArray.fromObject(ieltstInfoService.combobox(),this.getJsonConfig()).toString();
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