package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.Menu;
import com.zhbit.entity.base.Json;
import com.zhbit.entity.vo.VoMenu;
import com.zhbit.service.MenuService;
import com.zhbit.util.ExceptionUtil;
import com.zhbit.util.JsonDateFormatUtil;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/10
 * @Time:22:39 描述：
 */
public class MenuAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    //private static final Logger logger = Logger.getLogger(MenuAction.class);
    private MenuService menuService;
    private VoMenu voMenu;

    public VoMenu getVoMenu() {
        return voMenu;
    }

    public void setVoMenu(VoMenu voMenu) {
        this.voMenu = voMenu;
    }

    public MenuService getMenuService() {
        return menuService;
    }
    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
    /**
     * 动态加载菜单树（当展开下级时才会加载下级菜单）
     */
    public void doNotNeedSession_tree() {
        //super.writeJson(menuService.tree(menu, false));

        String json= JSONObject.fromObject(menuService.tree(voMenu,false),this.getJsonConfig()).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 一次性加载全部菜单树
     */
    public void doNotNeedSession_treeRecursive() {
       // super.writeJson(menuService.tree(menu, true));

        String json= JSONObject.fromObject(menuService.tree(voMenu,true),this.getJsonConfig()).toString();
       try {
           ResponseUtil.write(ServletActionContext.getResponse(),json);
       }catch (Exception ex){
           System.out.println("ResponseUtil异常！");
           ex.printStackTrace();
       }
    }

    public String menu() {
        return "menu";
    }
    /**
     * 获得菜单treegrid
     */
    public void treegrid() {

        String json= JSONObject.fromObject(menuService.treegrid(voMenu)).toString();
        try {
            ResponseUtil.write(ServletActionContext.getResponse(),json);
        }catch (Exception ex){
            System.out.println("ResponseUtil异常！");
            ex.printStackTrace();
        }
        //super.writeJson(menuService.treegrid(menu));
    }
    /**
     * 删除一个菜单
     */
    public void delete() {
        Json j = new Json();
        try {
            menuService.delete(voMenu);
            j.setSuccess(true);
            j.setMsg("删除成功！");
            j.setObj(voMenu.getCid());
        } catch (Exception e) {
           // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("删除失败！");
        }finally {
            String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
            try {
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            } catch (Exception e) {
                System.out.println("ResponseUtil异常！");
                e.printStackTrace();
            }
        }
    }
    public void add(){
        Json j = new Json();
        try {
            menuService.add(voMenu);
            j.setSuccess(true);
            j.setMsg("添加成功！");
        } catch (Exception e) {
            //logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("添加失败！");
        }finally {
            String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
            try {
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            } catch (Exception e) {
                System.out.println("ResponseUtil异常！");
                e.printStackTrace();
            }
        }
        //super.writeJson(j);
    }

    /**
     * 编辑菜单
     */
    public void edit() {
        Json j = new Json();
        try {
            menuService.edit(voMenu);
            j.setSuccess(true);
            j.setMsg("编辑成功!");
        } catch (Exception e) {
           // logger.error(ExceptionUtil.getExceptionMessage(e));
            j.setMsg("编辑失败！");
        }finally {
            String json= JSONObject.fromObject(j,this.getJsonConfig()).toString();
            try {
                ResponseUtil.write(ServletActionContext.getResponse(),json);
            } catch (Exception e) {
                System.out.println("ResponseUtil异常！");
                e.printStackTrace();
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
