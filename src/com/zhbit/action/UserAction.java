package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.base.SessionInfo;
import com.zhbit.entity.vo.VoUser;
import com.zhbit.exception.ValidateFieldsException;
import com.zhbit.service.MenuService;
import com.zhbit.service.UserService;
import com.zhbit.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/8
 * @Time:15:37
 * 描述：
 */

public class UserAction extends ActionSupport implements ModelDriven<VoUser> {
    //private static final Logger logger = Logger.getLogger(UserAction.class);
    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;
    private VoUser voUser = new VoUser();

    public String user() {
        return "user";
    }

    public String userAdd() {
        return "userAdd";
    }

    public String userEdit() {
        return "userEdit";
    }

    public String userRoleEdit() {
        return "userRoleEdit";
    }

    public String doNotNeedAuth_userInfo() {
        return "doNotNeedAuth_userInfo";
    }

    public String doNotNeedSession_index() {
       // SessionInfo sessionInfo = (SessionInfo) httpSession.getAttribute("sessionInfo");
        SessionInfo sessionInfo =(SessionInfo) ActionContext.getContext().getSession().get("sessionInfo");
        if (sessionInfo != null) {
            return "doNotNeedAuth_index";
        } else {
            return "login";
        }
    }

    public void doNotNeedAuth_editUserInfo() {
        Json j = new Json();
        try {
            userService.editUserInfo(voUser);
            j.setSuccess(true);
            j.setMsg("修改成功！");
        } catch (Exception e) {
            //logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("修改失败！");
            e.printStackTrace();
        }finally {
            try {
                String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
                ResponseUtil.write(ServletActionContext.getResponse(), json);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("ResponseUtil出现异常！！！");
            }
        }
    }

    /**
     * 用户登录
     * @return
     */
    public String doNotNeedSession_login() {
        System.out.println("userNo:"+voUser.getUserNo()+" password:"+voUser.getPassword()+" sign:"+voUser.getSign());

        if (StringUtil.isEmpty(voUser.getUserNo())) {
           HttpServletRequest request= (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
           request.setAttribute("msg", "提示：请输入用户名！");
            return "login";
        }
        if (StringUtil.isEmpty(voUser.getPassword())) {
            HttpServletRequest request= (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
            request.setAttribute("msg", "提示：请输入用户密码！");
            return "login";
        }
        VoUser u = userService.login(voUser);
        if (u != null) {
            userService.addLoginLog(u.getUserNo());
            //放入到sessionInfo中
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.setUserId(Integer.toString(u.getId()));
            sessionInfo.setLoginName(voUser.getUserNo());
            sessionInfo.setLoginPassword(voUser.getPassword());
            sessionInfo.setIp(IpUtil.getIpAddr((HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST)));
            sessionInfo.setMenus(menuService.findAll());
            sessionInfo.setAuthIds(u.getAuthIds());
            sessionInfo.setAuthNames(u.getAuthNames());
            sessionInfo.setRoleIds(u.getRoleIds());
            sessionInfo.setRoleNames(u.getRoleNames());
            sessionInfo.setAuthUrls(u.getAuthUrls());
            ActionContext.getContext().getSession().put("sessionInfo", sessionInfo);
        } else {
            HttpServletRequest request= (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
            request.setAttribute("msg", "提示：用户名或密码错误!");
            return "login";
        }
        if(u.getSign()==0){
            return "doNotNeedAuth_index";
        }else{
            return "doNotNeedAuth_studentIndex";
        }

    }

    /**
     * 用户注销（不需要session）
     */
    public void doNotNeedSession_logout() {
        //清理session
       ActionContext.getContext().getSession().clear();
        Json j = new Json();
        j.setSuccess(true);
        String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
      try {
          ResponseUtil.write(ServletActionContext.getResponse(),json);
      }catch (Exception ex){
          ex.printStackTrace();
          System.out.println("ResponseUtil出现异常！");
      }
    }

    /**
     * 用户添加
     */
    public void add() {
        Json j = new Json();
        System.out.println("```````````````````````userNO:"+voUser.getUserNo());
        try {
            userService.save(voUser);
            j.setMsg("添加成功！");
            j.setSuccess(true);
        } catch (ValidateFieldsException e) {
            j.setMsg(e.getLocalizedMessage());
            //System.out.println("333333333333333333333"+e.getLocalizedMessage());
        }finally {
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
     * 用户编辑
     */
    public void edit() {
        Json j = new Json();
        try {
            userService.update(voUser);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
        } catch (ValidateFieldsException e) {
            j.setMsg("编辑失败，用户名已存在！");
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
     * 用户角色批量编辑
     */
    public void roleEdit() {
        System.out.println("ids:"+voUser.getIds()+" roleIds:"+voUser.getRoleIds());
        Json j = new Json();
        try {
            userService.editRole(voUser);
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
     * 用户删除
     */
    public void delete() {
        Json j = new Json();
        userService.delete(voUser.getIds());
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
     * 获得用户datagrid
     */
    public void datagrid() {
        JSONArray rows =JSONArray.fromObject(userService.dataGrid(voUser).getRows(),this.getJsonConfig()) ;
        long total =userService.dataGrid(voUser).getTotal();
        JSONObject result = new JSONObject();
        result.put("rows",rows);
        result.put("total",total);
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),result);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }

    @Override
    public VoUser getModel() {
        return voUser;
    }
}
