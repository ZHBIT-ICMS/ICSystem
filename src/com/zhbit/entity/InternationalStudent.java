package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */

//国际交流生
@Entity
@Table(name="tb_international_student")
public class InternationalStudent {
    private int id;//学生标识号
    private long stuId;//学号
    private String name;//姓名
    private String status;//状态
    private String major;//专业
    private ClassesInfo classInfo;//班级信息
    private SummerCamp summerCamp;//夏令营活动
    private OverSeasStudent overSeasStudent;//出国生
    private ExchangeStudent exchangeStudent;//交换生
    private User user;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(length=20)
    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    @Column(length=20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(length=20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(length=20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    /*国际生与班级多对一的配置*/
    @ManyToOne
    @JoinColumn(name="classInfoId")
    public ClassesInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassesInfo classInfo) {
        this.classInfo = classInfo;
    }

    /*国际生与夏令营活动多对一的配置*/
    @ManyToOne
    @JoinColumn(name="summerCampId")
    public SummerCamp getSummerCamp() {
        return summerCamp;
    }

    public void setSummerCamp(SummerCamp summerCamp) {
        this.summerCamp = summerCamp;
    }

    /*国际生与出国生多对一的配置*/
    @ManyToOne
    @JoinColumn(name="overSeasStudentId")
    public OverSeasStudent getOverSeasStudent() {
        return overSeasStudent;
    }

    public void setOverSeasStudent(OverSeasStudent overSeasStudent) {
        this.overSeasStudent = overSeasStudent;
    }
    /*国际生与交换生一对一的配置*/
    @ManyToOne
    @JoinColumn(name="exchangeStudentId",unique = true)
    public ExchangeStudent getExchangeStudent() {
        return exchangeStudent;
    }

    public void setExchangeStudent(ExchangeStudent exchangeStudent) {
        this.exchangeStudent = exchangeStudent;
    }

    /*国际班学生与用户一对一的配置*/
    @ManyToOne
    @JoinColumn(name = "userId",unique = true)
    public User getUser() {
        return user;
    }

    public void setUser(User studentUser) {
        this.user = studentUser;
    }
}
