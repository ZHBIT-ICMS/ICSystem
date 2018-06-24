package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */
/*雅思培训*/
@Entity
@Table(name="tb_ielts_train")
public class IELTSTrain {
    private int id;//自增编号
    private String ieltsTrainId;//雅思机构编号
    private String trainName;//雅思机构名称
    private String trainTerm;//培训的学期
    private Date trainTime;//培训的时期
    private String trainClassHours;//雅思课程学时
    private List<IELTSExam> examList;//雅思考试
    private List<InterStuTrain> interStuTrainList;//国际班学生&雅思培训中间
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    @Column(length = 50,unique = true)
    public String getIeltsTrainId() {
        return ieltsTrainId;
    }

    public void setIeltsTrainId(String ieltsTrainId) {
        this.ieltsTrainId = ieltsTrainId;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 20)
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    @Column(length = 20)
    public String getTrainTerm() {
        return trainTerm;
    }

    public void setTrainTerm(String trainTerm) {
        this.trainTerm = trainTerm;
    }

    public Date getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(Date trainTime) {
        this.trainTime = trainTime;
    }
    @Column(length = 20)
    public String getTrainClassHours() {
        return trainClassHours;
    }

    public void setTrainClassHours(String trainClassHours) {
        this.trainClassHours = trainClassHours;
    }

    /*雅思培训举办雅思考试1->n*/
    @OneToMany(mappedBy="ieltsTrain", targetEntity = IELTSExam.class)
    public List <IELTSExam> getExamList() {
        return examList;
    }

    public void setExamList(List <IELTSExam> examList) {
        this.examList = examList;
    }

    /*雅思培训与【国际班学生&雅思培训中间实体】 1对多*/
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "ieltsTrain")
    public List<InterStuTrain> getInterStuTrainList() {
        return interStuTrainList;
    }

    public void setInterStuTrainList(List<InterStuTrain> interStuTrainList) {
        this.interStuTrainList = interStuTrainList;
    }
}
