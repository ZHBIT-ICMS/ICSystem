package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/6/3.
 */
//资源
@Entity
@Table(name="tb_resource")
public class Resources {
    private int id;
    private String name;//资源名称
    private String url;//资源地址
    private int parentId;
    private String permtId;//权限编码
    private String iconCls;//资源图标
    private int level;//资源级别
    private int sort;//排序
    private String type;
    private String remark;
    private Date createDate;
    private Date updateDate;
    private int creator;
    private int updater;
    private String status;
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

    @Column(length=32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(length=64)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Column(length=20)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPermtId() {
        return permtId;
    }
    @Column(length=64)
    public void setPermtId(String permtId) {
        this.permtId = permtId;
    }
    @Column(length=64)
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    @Column(length=4)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Column(length=8)
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
    @Column(length=1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Column(length=255)
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
    @Column(length=20)
    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    @Column(length=20)
    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }
    @Column(length=1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @OneToMany(mappedBy = "resources",targetEntity = RoleResource.class)
    public List <RoleResource> getRoleResourceList() {
        return roleResourceList;
    }

    public void setRoleResourceList(List <RoleResource> roleResourceList) {
        this.roleResourceList = roleResourceList;
    }
}
