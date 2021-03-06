package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
    private List<Chair>chairList;//一个院校对应多个讲座
    private List<FroCollegeAgreement>froCollegeAgreementList;
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
    //一个院校对应多个讲座
    @OneToMany(mappedBy = "foreignCollege" ,targetEntity = Chair.class)
    public List<Chair> getChairList() {
        return chairList;
    }

    public void setChairList(List<Chair> chairList) {
        this.chairList = chairList;
    }
    @OneToMany(mappedBy = "foreignCollege",targetEntity = FroCollegeAgreement.class)
    public List<FroCollegeAgreement> getFroCollegeAgreementList() {
        return froCollegeAgreementList;
    }

    public void setFroCollegeAgreementList(List<FroCollegeAgreement> froCollegeAgreementList) {
        this.froCollegeAgreementList = froCollegeAgreementList;
    }
}
