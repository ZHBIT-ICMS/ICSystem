package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */
//夏令营活动
@Entity
@Table(name="tb_summer_camp")
public class SummerCamp {
    private int id;
    private Date activityTime;
    private List<InternationalStudent> studentList=new ArrayList<InternationalStudent>();//一个班级信息包括多个国际班学生

    /* 主键采用本地，mysql的本地是自增长
    *
    * */
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getActivityTime() {
        return activityTime;
    }
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    /*  夏令营和国际班学生是一对多的对应关系
    *   targetEntity：对应的目标实体类(国际班学生)
    *   mappedBy：对应到对方的属性字段
    * */
    @OneToMany(mappedBy="summerCamp",targetEntity = InternationalStudent.class)
    public List <InternationalStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List <InternationalStudent> studentList) {
        this.studentList = studentList;
    }
}
