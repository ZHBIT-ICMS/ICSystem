package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/5
 * @Time:16:08 描述：
 */
//国外院校和协议的中间表
@Entity
@Table(name="tb_foreign_college_agreement")
public class ForCollegeAgreement {
    private int id;
    private Agreement agreement;
    private ForeignCollege foreignCollege;
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "agreementId")
    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }
    @ManyToOne
    @JoinColumn(name = "foreignCollegeId")
    public ForeignCollege getForeignCollege() {
        return foreignCollege;
    }

    public void setForeignCollege(ForeignCollege foreignCollege) {
        this.foreignCollege = foreignCollege;
    }
}
