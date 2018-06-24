package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */
/* 国际班雅思考试
*
*  国际班学生表和雅思考试的中间表
*
* */
@Entity
@Table(name="tb_interstu_exam")
public class InterStuExam {
    private int id;
    private IELTSExam ieltsExam;//雅思考试的编号
    private InternationalStudent internationalStudent;//国际班学生的学号
    private int score;//分数
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @ManyToOne
    @JoinColumn(name="ieltsExamId")
    public IELTSExam getIeltsExam() {
        return ieltsExam;
    }

    public void setIeltsExam(IELTSExam ieltsExam) {
        this.ieltsExam = ieltsExam;
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
