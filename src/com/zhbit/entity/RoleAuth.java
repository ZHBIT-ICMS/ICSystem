package com.zhbit.entity;

import javax.persistence.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:10:10
 * 描述：
 */
@Entity
@Table(name = "tb_role_auth")
public class RoleAuth implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String cid;
    private Auth auth;
    private Role role;

    public RoleAuth() {
    }

    public RoleAuth(String cid) {
        this.cid = cid;
    }

    public RoleAuth(String cid, Auth auth, Role role) {
        this.cid = cid;
        this.auth = auth;
        this.role = role;
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
    @JoinColumn(name="CAUTHID")
    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CROLEID")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
