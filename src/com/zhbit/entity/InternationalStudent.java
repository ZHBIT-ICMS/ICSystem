package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */

//国际交流生
@Entity
@Table(name="tb_international_student")
public class InternationalStudent {
    private int id;//学生标识号
    private String stuId;//学号
    private String name;//姓名
    private String status;//状态
    private String major;//专业
    private ClassesInfo classInfo;//班级信息
    private OverSeasStudent overSeasStudent;//出国生  多对一
    private ExchangeStudent exchangeStudent;//交换生  一对一
    private User user; //一对一
    private List<InterStuSummerCamp> interStuSummerCampList; // 夏令营活动 多对多的关系
    private List<InterStuTrain> interStuTrainList = new ArrayList<InterStuTrain>(); //雅思培训中间表 多对多
    private List<InterStuExam> interStuExamList = new ArrayList<InterStuExam>();//雅思考试中间表 多对多
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(length=30)
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "internationalStudent")
    public List<InterStuSummerCamp> getInterStuSummerCampList() {
        return interStuSummerCampList;
    }

    public void setInterStuSummerCampList(List<InterStuSummerCamp> interStuSummerCampList) {
        this.interStuSummerCampList = interStuSummerCampList;
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "internationalStudent")
    public List<InterStuTrain> getInterStuTrainList() {
        return interStuTrainList;
    }

    public void setInterStuTrainList(List<InterStuTrain> interStuTrainList) {
        this.interStuTrainList = interStuTrainList;
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "internationalStudent")
    public List<InterStuExam> getInterStuExamList() {
        return interStuExamList;
    }

    public void setInterStuExamList(List<InterStuExam> interStuExamList) {
        this.interStuExamList = interStuExamList;
    }
}
