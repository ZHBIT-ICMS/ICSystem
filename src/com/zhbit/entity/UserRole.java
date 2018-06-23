package com.zhbit.entity;

import javax.persistence.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:10:28
 * 描述：管理员用户与角色的关系实体
 */
@Entity
@Table(name ="tb_user_role" )
public class UserRole implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String cid;
    private Role role ;
    private User user;
    public  UserRole(){
    }

    public UserRole(String cid) {
        this.cid = cid;
    }

    public UserRole(String cid, Role role, User user) {
        this.cid = cid;
        this.role = role;
        this.user = user;
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
    @JoinColumn(name = "CROLEID")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSERID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
