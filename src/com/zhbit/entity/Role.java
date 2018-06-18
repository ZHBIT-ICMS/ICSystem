package com.zhbit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:10:08
 * 描述：角色实体类
 */
@Entity
@Table(name = "tb_role")
public class Role implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    private String cid;
    private String cdesc;
    private String cname;
    private Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);
    public Role(){}

    public Role(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Role(String cid, String cdesc, String cname, Set<RoleAuth> roleAuths, Set<UserRole> userRoles) {
        this.cid = cid;
        this.cdesc = cdesc;
        this.cname = cname;
        this.roleAuths = roleAuths;
        this.userRoles = userRoles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @Column(name = "CID",nullable = false,length = 36)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    @Column(name = "CDESC",length = 200)
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
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    public Set<RoleAuth> getRoleAuths() {
        return roleAuths;
    }

    public void setRoleAuths(Set<RoleAuth> roleAuths) {
        this.roleAuths = roleAuths;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
