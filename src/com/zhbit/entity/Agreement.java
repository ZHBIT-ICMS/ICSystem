package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/5
 * @Time:16:02 描述：
 */
//协议
@Entity
@Table(name="tb_agreement")
public class Agreement {
    private int id;
    private String title;
    private String type;
    private Date agreementTime;
    private String content;
    private ForeignCollege foreignCollege;//国外院校

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAgreementTime() {
        return agreementTime;
    }

    public void setAgreementTime(Date agreementTime) {
        this.agreementTime = agreementTime;
    }
    @Column(length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    @Column(columnDefinition="TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String conyent) {
        this.content = conyent;
    }

    @ManyToOne
    @JoinColumn(name="foreignCollegeId")
    public ForeignCollege getForeignCollege() {
        return foreignCollege;
    }

    public void setForeignCollege(ForeignCollege foreignCollege) {
        this.foreignCollege = foreignCollege;
    }
}
