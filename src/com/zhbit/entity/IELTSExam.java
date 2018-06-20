package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wby on 2018/4/6.
 */
/*雅思考试*/
@Entity
@Table(name="tb_ielts_exam")
public class IELTSExam {
    private int id;
    private  String examId;//考试的编号
    private Date examTime;//雅思考试时间
    private String examPlace;//雅思考试地点
    private int score;//分数
    private IELTSTrain ieltsTrain;//培训机构
   private  int sign;//0是正式考试，1是模拟考试
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExamTime() {
        return examTime;
    }
    @Column(length = 50,unique = true)
    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }
    @Column(length=50)
    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    @ManyToOne
    @JoinColumn(name="ieltsTrainId")
    public IELTSTrain getIeltsTrain() {
        return ieltsTrain;
    }

    public void setIeltsTrain(IELTSTrain ieltsTrain) {
        this.ieltsTrain = ieltsTrain;
    }
}
