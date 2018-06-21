package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */

//班级信息
@Entity
@Table(name="tb_classes_info")
public class ClassesInfo {
    private int id;//主键
    private String classNo;//班级号
    private String descInfo;//班级描述
    private List<InternationalStudent>studentList=new ArrayList <InternationalStudent>();//一个班级信息包括多个国际班学生
    private CollegeInfo collegeInfo;//一个学院包括多个班

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
    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }


    @Lob
    @Column(columnDefinition="TEXT")
    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }
//    @OneToMany(targetEntity=Order.class,cascade=CascadeType.ALL)
//    @JoinColumn(name="userId",updatable=false)


    /*  班级信息和国际班学生是一对多的对应关系
   *   targetEntity：对应的目标实体类(国际班学生)
   *   mappedBy：对应到对方的属性字段
   * */
    @OneToMany(mappedBy="classInfo",targetEntity = InternationalStudent.class)
    public List <InternationalStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List <InternationalStudent> studentList) {
        this.studentList = studentList;
    }


    //多个班对应一个学院
    @ManyToOne
    @JoinColumn(name="CollegeInfoId")
    public CollegeInfo getCollegeInfo() {
        return collegeInfo;
    }

    public void setCollegeInfo(CollegeInfo collegeInfo) {
        this.collegeInfo = collegeInfo;
    }
}
