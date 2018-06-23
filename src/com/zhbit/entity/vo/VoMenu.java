package com.zhbit.entity.vo;

import com.zhbit.entity.Menu;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:22:02
 * 描述：
 */
public class VoMenu implements Serializable {
    private static  final  long serivalVersionUID=1L;

    private String id;
    private String pid;
    private String pname;
    private String state = "open";// 是否展开(open,closed)
    private String iconCls;// 前面的小图标样式

    //来自entity.Menu
    private String cid;
    private Menu menu;
    private String ciconcls;
    private String cname;
    private BigDecimal cseq;
    private String curl;

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getCiconcls() {
        return ciconcls;
    }

    public void setCiconcls(String ciconcls) {
        this.ciconcls = ciconcls;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public BigDecimal getCseq() {
        return cseq;
    }

    public void setCseq(BigDecimal cseq) {
        this.cseq = cseq;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }
}
