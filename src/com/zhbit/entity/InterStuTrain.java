package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */
/* 国际班学生参加雅思培训
*
*  国际班学生表和雅思培训表的中间表
* */
@Entity
@Table(name="tb_interstu_train")
public class InterStuTrain {
    private int id;
    private IELTSTrain ieltsTrain;//雅思培训的编号
    private InternationalStudent internationalStudent;//国际班学生的学号
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name="ieltsTrainId")
    public IELTSTrain getIeltsTrain() {
        return ieltsTrain;
    }

    public void setIeltsTrain(IELTSTrain ieltsTrain) {
        this.ieltsTrain = ieltsTrain;
    }
    @ManyToOne
    @JoinColumn(name="internationalStudentId")
    public InternationalStudent getInternationalStudent() {
        return internationalStudent;
    }

    public void setInternationalStudent(InternationalStudent internationalStudent) {
        this.internationalStudent = internationalStudent;
    }
}
