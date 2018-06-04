package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/6/3.
 */
//角色表和资源表的中间表
@Entity
@Table(name="tb_role_resource")
public class RoleResource {
    private int id;
    private Role role;
    private Resources resources;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne//资源-角色的中间表和角色表的关系
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToOne//资源-角色的中间表和角色表的关系
    @JoinColumn(name="resource_id")
    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }
}
