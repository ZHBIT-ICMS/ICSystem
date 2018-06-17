package com.zhbit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.AdminUser;
import com.zhbit.entity.InternationalStudent;
import com.zhbit.service.LoginForAdminService;
import com.zhbit.service.LoginForStudentService;
import com.zhbit.util.StringUtil;
import org.apache.struts2.StrutsStatics;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/4
 * @Time:14:47
 * 描述：用户登录Action
 */
public class LoginAction extends ActionSupport {
    private String lusername;//用户名
    private String lpassword;//密码
    private int option;//用户类型
    @Resource
    private LoginForAdminService loginForAdminService;
    @Resource
    private LoginForStudentService loginForStudentService;
    private AdminUser adminUser=null;
    private InternationalStudent studentUser=null;

    public String getLusername() {
        return lusername;
    }

    public void setLusername(String lusername) {
        this.lusername = lusername;
    }

    public String getLpassword() {
        return lpassword;
    }

    public void setLpassword(String lpassword) {
        this.lpassword = lpassword;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public InternationalStudent getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(InternationalStudent studentUser) {
        this.studentUser = studentUser;
    }

    public String execute() throws Exception {
        if(StringUtil.isNotEmpty(lusername)&&StringUtil.isNotEmpty(lpassword)){
            if(option==0){
                adminUser=loginForAdminService.validateUser(lusername,lpassword);
                if (adminUser==null){
                    HttpServletRequest request=(HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
                    request.setAttribute("loginFailed","用户名或密码错误");
                }else{
                    ActionContext.getContext().getSession().put("currentUser",adminUser);
                    return "admin";
                }
            }else{//管理员登录
                studentUser=loginForStudentService.validateUser(lusername,lpassword);
                if(studentUser==null){
                    HttpServletRequest request=(HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
                    request.setAttribute("loginFailed","用户名或密码错误");
                }
                else{
                    ActionContext.getContext().getSession().put("currentUser",studentUser);
                    return "student";
                }
            }
        }
        return INPUT;
    }
}
