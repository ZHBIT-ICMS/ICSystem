package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.Agreement;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoAgreement;
import com.zhbit.service.AgreementService;
import com.zhbit.util.ExceptionUtil;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResourceUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/22
 * @Time:10:52
 * @Description：
 */
public class PubAgreementAction extends ActionSupport implements ModelDriven<VoAgreement> {

@Resource
private AgreementService agreementService;
private  VoAgreement voAgreement = new VoAgreement();
    @Override
    public VoAgreement getModel() {
        return voAgreement;
    }
    public String agreements(){
        return  "agreements";
    }
    public String agreementsAdd(){
        return  "agreementsAdd";
    }
    public String agreementsEdit(){
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        request.setAttribute("content",agreementService.getContentById(voAgreement.getId()));
        return "agreementsEdit";
    }

    public void datagrid() {

        JSONArray rows = JSONArray.fromObject(agreementService.datagrid(voAgreement).getRows(),this.getJsonConfig());
        long total = agreementService.datagrid(voAgreement).getTotal();
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
            agreementService.delete(voAgreement.getIds());
            j.setSuccess(true);
            j.setMsg("删除成功！");
        }catch (Exception ex){
            j.setMsg("删除失败！");
            System.out.println("协议删除失败！");
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
            agreementService.add(voAgreement);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        }catch (Exception ex){
            j.setMsg("添加失败！");
            System.out.println("协议添加失败！");
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
            agreementService.update(voAgreement);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        }catch (Exception ex){
            j.setMsg("修改失败！");
            System.out.println("协议修改失败！");
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

    public  String showContent(){
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        request.setAttribute("content",agreementService.getContentById(voAgreement.getId()));
        return "showContent";
    }

    /**
     * 文件上传
     */
    public void upload(){
        // 文件保存目录路径
        String savePath = ServletActionContext.getServletContext().getRealPath("/")+ ResourceUtil.getAgreementUploadDirectory()+"/";
        System.out.println("path:"+savePath);
        // 文件保存目录URL
        String saveUrl = "/" + ResourceUtil.getAgreementUploadDirectory() + "/";
        // 如果是HTML5上传文件，那么这里有相应头的
        String contentDisposition = ServletActionContext.getRequest().getHeader("Content-Disposition");
        if(contentDisposition!=null){
            Long fileSize = Long.valueOf(ServletActionContext.getRequest().getHeader("Content-Length"));// 上传的文件大小
            String fileName = contentDisposition.substring(contentDisposition.lastIndexOf("filename=\""));// 文件名称
            fileName = fileName.substring(fileName.indexOf("\"") + 1);
            fileName = fileName.substring(0, fileName.indexOf("\""));
            ServletInputStream inputStream;
            try {
                inputStream = ServletActionContext.getRequest().getInputStream();
            } catch (IOException e) {
                this.uploadError("上传文件出错！");
                ExceptionUtil.getExceptionMessage(e);
                return;
            }
            if (inputStream == null) {
                this.uploadError("您没有上传任何文件！");
                return;
            }

            if (fileSize > ResourceUtil.getUploadFileMaxSize()) {
                this.uploadError("上传文件超出限制大小！", fileName);
                return;
            }
            // 检查文件扩展名
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!Arrays.<String> asList(ResourceUtil.getUploadFileExts().split(",")).contains(fileExt)) {
                this.uploadError("上传文件扩展名是不允许的扩展名。\n只允许" + ResourceUtil.getUploadFileExts() + "格式！");
                return;
            }

            savePath += fileExt + "/";
            saveUrl += fileExt + "/";

            SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
            SimpleDateFormat monthDf = new SimpleDateFormat("MM");
            SimpleDateFormat dateDf = new SimpleDateFormat("dd");
            Date date = new Date();
            String ymd = yearDf.format(date) + "/" + monthDf.format(date) + "/" + dateDf.format(date) + "/";
            savePath += ymd;
            saveUrl += ymd;
            File uploadDir = new File(savePath);// 创建要上传文件到指定的目录
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            //避免文件名冲突，使用UUID重新命名
            String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;// 新的文件名称
            File uploadedFile = new File(savePath, newFileName);

            try {
                FileCopyUtils.copy(inputStream, new FileOutputStream(uploadedFile));
            } catch (FileNotFoundException e) {
                this.uploadError("上传文件出错！");
                ExceptionUtil.getExceptionMessage(e);
                return;
            } catch (IOException e) {
                this.uploadError("上传文件出错！");
                ExceptionUtil.getExceptionMessage(e);
                return;
            }

            this.uploadSuccess(ServletActionContext.getRequest().getContextPath() + saveUrl + newFileName, fileName, 0);// 文件上传成功

            return;
        }

        MultiPartRequestWrapper multiPartRequest = (MultiPartRequestWrapper) ServletActionContext.getRequest();// 由于struts2上传文件时自动使用了request封装
        File[] files = multiPartRequest.getFiles(ResourceUtil.getUploadFieldName());// 上传的文件集合
        String[] fileNames = multiPartRequest.getFileNames(ResourceUtil.getUploadFieldName());// 上传文件名称集合

        if (files == null || files.length < 1) {
            this.uploadError("您没有上传任何文件！");
            return;
        }
        for (int i = 0; i < files.length; i++) {// 循环所有文件
            File file = files[i];// 上传的文件(临时文件)
            String fileName = fileNames[i];// 上传文件名

            if (file.length() > ResourceUtil.getUploadFileMaxSize()) {
                this.uploadError("上传文件超出限制大小！", fileName);
                return;
            }

            // 检查文件扩展名
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!Arrays.<String> asList(ResourceUtil.getUploadFileExts().split(",")).contains(fileExt)) {
                this.uploadError("上传文件扩展名是不允许的扩展名。\n只允许" + ResourceUtil.getUploadFileExts() + "格式！");
                return;
            }

            savePath += fileExt + "/";
            saveUrl += fileExt + "/";

            SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
            SimpleDateFormat monthDf = new SimpleDateFormat("MM");
            SimpleDateFormat dateDf = new SimpleDateFormat("dd");
            Date date = new Date();
            String ymd = yearDf.format(date) + "/" + monthDf.format(date) + "/" + dateDf.format(date) + "/";
            savePath += ymd;
            saveUrl += ymd;

            File uploadDir = new File(savePath);// 创建要上传文件到指定的目录
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;// 新的文件名称
            File uploadedFile = new File(savePath, newFileName);

            try {
                FileCopyUtils.copy(file, uploadedFile);// 利用spring的文件工具上传
            } catch (Exception e) {
                this.uploadError("上传文件失败！", fileName);
                return;
            }
            this.uploadSuccess(ServletActionContext.getRequest().getContextPath() + saveUrl + newFileName, fileName, i);// 文件上传成功
        }
    }
    private void uploadError(String err, String msg) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("err", err);
        m.put("msg", msg);
        // super.writeJson(m);
        String json = JSONObject.fromObject(m,this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
    }
    private void uploadError(String err) {
        //
        this.uploadError(err, "");
    }
    private void uploadSuccess(String newFileName, String fileName, int id) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("err", "");
        Map<String, Object> nm = new HashMap<String, Object>();
        nm.put("url", newFileName);
        nm.put("localfile", fileName);
        nm.put("id", id);
        m.put("msg", nm);
        try {
            //将数据转换为json
            String json = JSONObject.fromObject(m,this.getJsonConfig()).toString();
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
    }

    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }
}
