package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.CollegeInfo;
import com.zhbit.entity.vo.VoCollegeInfo;
import com.zhbit.service.CollegeInfoService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:44
 * 描述：
 */
public class CollegeInfoAction extends ActionSupport implements ModelDriven<VoCollegeInfo> {
    @Resource
    private CollegeInfoService collegeInfoService;
    private VoCollegeInfo voCollegeInfo;

    @Override
    public VoCollegeInfo getModel() {
        return voCollegeInfo;
    }

    /*public VoCollegeInfo getVoCollegeInfo() {
            return voCollegeInfo;
        }

        public void setVoCollegeInfo(VoCollegeInfo voCollegeInfo) {
            this.voCollegeInfo = voCollegeInfo;
        }*/
    public  void doNotNeedSession_combobox(){
        String json= JSONArray.fromObject(collegeInfoService.findAll(),this.getJsonConfig()).toString();
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
