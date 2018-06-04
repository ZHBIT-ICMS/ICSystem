package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/6/3.
 */
//角色
@Entity
@Table(name="tb_role")
public class Role {
    private int id;
    private String roleName;//角色名称
    private String roleCode;//角色code
    private int status;//1正常  0删除 -1全部'
    private String remark;
    private Date createDate;
    private Date updateDate;
    private int creator;
    private int updater;
    private List<UserRole>userRoleList;
    private List<RoleResource>roleResourceList;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length=10)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @Column(length=10)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @Column(length=10)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    @Column(length=10)
    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    @Column(length=10)
    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }
    @Column(length=10)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @OneToMany(mappedBy = "role",targetEntity = UserRole.class)
    public List <UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List <UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
    @OneToMany(mappedBy = "role",targetEntity = RoleResource.class)
    public List <RoleResource> getRoleResourceList() {
        return roleResourceList;
    }

    public void setRoleResourceList(List <RoleResource> roleResourceList) {
        this.roleResourceList = roleResourceList;
    }
}
