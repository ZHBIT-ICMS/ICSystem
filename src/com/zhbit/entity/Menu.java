package com.zhbit.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:21:43
 * 描述：
 */
@Entity
@Table(name = "tb_menu")
public class Menu implements java.io.Serializable  {
    private static  final  long serivalVersionUID=1L;

    private String cid;
    private Menu menu;
    private String ciconcls;
    private String cname;
    private BigDecimal cseq;
    private String curl;
    private Set<Menu> menus=new HashSet<Menu>(0);
    public Menu(){

    }

    public Menu(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Menu(String cid, Menu menu, String ciconcls, String cname, BigDecimal cseq, String curl, Set<Menu> menus) {
        this.cid = cid;
        this.menu = menu;
        this.ciconcls = ciconcls;
        this.cname = cname;
        this.cseq = cseq;
        this.curl = curl;
        this.menus = menus;
    }

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }
    @Id
    @Column(name = "CID",length = 36)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CPID")
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    @Column(name = "CICONCLS",length = 100)
    public String getCiconcls() {
        return ciconcls;
    }

    public void setCiconcls(String ciconcls) {
        this.ciconcls = ciconcls;
    }
    @Column(name = "CNAME",nullable = false,length = 100)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    @Column(name = "CSEQ",precision = 22,scale = 0)
    public BigDecimal getCseq() {
        return cseq;
    }

    public void setCseq(BigDecimal cseq) {
        this.cseq = cseq;
    }
    @Column(name = "CURL",length = 200)

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "menu")
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
