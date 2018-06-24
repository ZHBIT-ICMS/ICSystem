package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String duration; //考试时长
    private IELTSTrain ieltsTrain;//培训机构
    private  int sign;//0是正式考试，1是模拟考试

    private List<InterStuExam> interStuExamList = new ArrayList<InterStuExam>();

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
    @Column(length=50)
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "ieltsExam")
    public List<InterStuExam> getInterStuExamList() {
        return interStuExamList;
    }

    public void setInterStuExamList(List<InterStuExam> interStuExamList) {
        this.interStuExamList = interStuExamList;
    }
}
