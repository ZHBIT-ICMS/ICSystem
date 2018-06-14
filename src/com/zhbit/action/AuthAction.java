package com.zhbit.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoAuth;
import com.zhbit.service.AuthService;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.struts2.ServletActionContext;
import javax.annotation.Resource;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/11
 * @Time:18:26
 * 描述：
 * 权限管理Action
 */

public class AuthAction extends ActionSupport implements ModelDriven<VoAuth> {
    private VoAuth voAuth=new VoAuth();
    @Resource
    private AuthService authService;

  /*  public VoAuth getVoAuth() {
        return voAuth;
    }

    public void setVoAuth(VoAuth voAuth) {
        this.voAuth = voAuth;
    }*/

    public String auth() {
        return "auth";
    }

    public String authAdd() {
        return "authAdd";
    }

    public String authEdit() {
        return "authEdit";
    }
    /**
     * 动态获取权限树（当展开下级时才去加载下级权限）
     */
    public void doNotNeedSession_tree() {
        String json= JSONArray.fromObject(authService.tree(voAuth,false),this.getJsonConfig()).toString();
        try{
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil异常！");
            ex.printStackTrace();
        }
       // super.writeJson(authService.tree(auth, false));
    }

    /**
     * 一次性加载全部权限树
     */
    public void doNotNeedSession_treeRecursive() {
        String json=JSONArray.fromObject(authService.tree(voAuth,true),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
        // super.writeJson(authService.tree(auth, true));
    }

    /**
     * 获得权限treegrid
     */
    public void treegrid() {
        String json= JSONArray.fromObject(authService.treegrid(voAuth),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        } catch (Exception e) {
            System.out.println("ResponseUtil异常！");
            e.printStackTrace();
        }
        //super.writeJson(authService.treegrid(auth));
      //  this.writeJson(authService.treegrid(voAuth));
    }
    /**
     * 删除一个权限
     */
    public void delete() {
        Json j = new Json();
        try {
            authService.delete(voAuth);
            j.setSuccess(true);
            j.setMsg("删除成功！");
            j.setObj(voAuth.getCid());
        } catch (Exception e) {
           // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("删除失败！");
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
     * 编辑权限
     */
    public void edit() {
        Json j = new Json();
        try {
            authService.edit(voAuth);
            j.setSuccess(true);
            j.setMsg("编辑成功!");
        } catch (Exception e) {
           // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("编辑失败！");
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
     * 添加权限
     */
    public void add() {
        Json j = new Json();
        try {
            authService.add(voAuth);
            j.setSuccess(true);
            j.setMsg("添加成功!");
        } catch (Exception e) {
           // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("添加失败！");
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
     * 获得JsonConfig
     * @return
     */
    public JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
       config.setIgnoreDefaultExcludes(false);
        config.setExcludes(new String[]{"auth","hibernateLazyInitializer"});
        config.registerJsonValueProcessor(java.util.Date.class,new JsonDateFormatUtil("yyyy-MM-dd"));
        return config;
    }

   /* public void writeJson(Object object ){
        try{
            String json = JSON.toJSONStringWithDateFormat(object,"yyyy-MM-dd HH:mm:ss");
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ServletActionContext.getResponse().getWriter().write(json);
            ServletActionContext.getResponse().getWriter().flush();
            ServletActionContext.getResponse().getWriter().close();
            System.out.println("1111111111111111111111111111111111111111111111:"+json);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }*/
    @Override
    public VoAuth getModel() {
        return voAuth;
    }
}
