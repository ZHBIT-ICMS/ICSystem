package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */
//出国生
@Entity
@Table(name="tb_overseas_student")
public class OverSeasStudent {
    private int id;
    private String overSeasName;//出国生的名称
    private String schoolName;//出国的学校
    private String schoolType;//出国类型
    private String replaceCourse;//替换课程
    private String replaceCredit;//替换学分
    private Date goAbroadTime;//出国时间
    private List <InternationalStudent> studentList = new ArrayList <InternationalStudent>();//出国生与国际班学生一对多

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 50)
    public String getOverSeasName() {
        return overSeasName;
    }

    public void setOverSeasName(String overSeasName) {
        this.overSeasName = overSeasName;
    }

    @Column(length = 20)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(length = 20)
    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    @Column(length = 20)
    public String getReplaceCourse() {
        return replaceCourse;
    }

    public void setReplaceCourse(String replaceCourse) {
        this.replaceCourse = replaceCourse;
    }

    @Column(length = 20)
    public String getReplaceCredit() {
        return replaceCredit;
    }

    public void setReplaceCredit(String replaceCredit) {
        this.replaceCredit = replaceCredit;
    }

    public Date getGoAbroadTime() {
        return goAbroadTime;
    }

    public void setGoAbroadTime(Date goAbroadTime) {
        this.goAbroadTime = goAbroadTime;
    }

    /* 出国生与国际班学生一对多
         *   targetEntity：对应的目标实体类(国际班学生)
         *   mappedBy：对应到对方的属性字段
        * */
    @OneToMany(mappedBy="overSeasStudent", targetEntity = InternationalStudent.class)
    public List <InternationalStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List <InternationalStudent> studentList) {
        this.studentList = studentList;
    }
}
