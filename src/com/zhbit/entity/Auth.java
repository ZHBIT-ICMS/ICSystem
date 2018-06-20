package com.zhbit.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/6
 * @Time:22:12
 * 描述：
 */
@Entity
@Table(name="tb_auth")
public class Auth implements java.io.Serializable {

     private static final  long serialVersionUID=1L;
     private  String cid;
     private  Auth auth;
     private  String cdesc;
     private  String cname;
     private  BigDecimal cseq;
     private  String curl;
     private  Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);
     private  Set<Auth> auths = new HashSet<Auth>(0);
     public Auth(){}
     public Auth(String cid,String canme){
         this.cid=cid;
         this.cname=canme;
     }
    public Auth(String cid, Auth auth, String cdesc, String cname, BigDecimal cseq, String curl, Set<RoleAuth> roleAuths, Set<Auth> auths) {
        this.cid = cid;
        this.auth = auth;
        this.cdesc = cdesc;
        this.cname = cname;
        this.cseq = cseq;
        this.curl = curl;
        this.roleAuths = roleAuths;
        this.auths = auths;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @Column(name="CID",length = 36)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CPID")
    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
    @Column(name="CDESC",length = 200)
    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
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
    @Column(name="CURL",length = 200)
    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "auth")
    public Set<RoleAuth> getRoleAuths() {
        return roleAuths;
    }

    public void setRoleAuths(Set<RoleAuth> roleAuths) {
        this.roleAuths = roleAuths;
    }
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "auth")
    public Set<Auth> getAuths() {
        return auths;
    }

    public void setAuths(Set<Auth> auths) {
        this.auths = auths;
    }
}
