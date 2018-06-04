package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */
//国外院校
@Entity
@Table(name="tb_foreign_college")
public class ForeignCollege {
    private int id;//
    private String foreignName;//名称
    private String foreignType;//类型
    private String stat;//状态
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 20)
    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }
    @Column(length = 20)
    public String getForeignType() {
        return foreignType;
    }

    public void setForeignType(String foreignType) {
        this.foreignType = foreignType;
    }
    @Column(length = 20)
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
