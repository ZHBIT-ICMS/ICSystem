package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:0:41
 * 描述：
 */
@Entity
@Table(name="tb_interStu_summerCamp")
public class InterStuSummerCamp {
private int id;
private InternationalStudent internationalStudent;
private SummerCamp summerCamp;

    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internationalStudentId")
    public InternationalStudent getInternationalStudent() {
        return internationalStudent;
    }

    public void setInternationalStudent(InternationalStudent internationalStudent) {
        this.internationalStudent = internationalStudent;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "summerCampId")
    public SummerCamp getSummerCamp() {
        return summerCamp;
    }

    public void setSummerCamp(SummerCamp summerCamp) {
        this.summerCamp = summerCamp;
    }

}
