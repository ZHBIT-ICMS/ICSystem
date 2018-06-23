package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wby on 2018/6/2.
 */
//学院信息
@Entity
@Table(name="tb_college_info")
public class CollegeInfo {
    private int id;//主键
    private String collegeName;//学院名称
    private String descInfo;//学院描述
    private List<ClassesInfo> classesInfoList=new ArrayList<ClassesInfo>();//一个学院包括多个班级


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
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    @Lob
    @Column(columnDefinition="TEXT")
    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }
    @OneToMany(mappedBy = "collegeInfo",targetEntity = ClassesInfo.class ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<ClassesInfo> getClassesInfoList() {
        return classesInfoList;
    }

    public void setClassesInfoList(List<ClassesInfo> classesInfoList) {
        this.classesInfoList = classesInfoList;
    }
}
