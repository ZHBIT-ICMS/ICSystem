package com.zhbit.entity.vo;

import com.zhbit.entity.IELTSTrain;

import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/19
 * @Time:22:48
 * 描述：ClassesInfo的pageModel
 */
public class VoIELTSExam {
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;

    private int id;//主键
    private  String examId;//考试的编号
    private Date examTime;//雅思考试时间
    private String examPlace;//雅思考试地点
    private String duration; //考试时长
    private int sign;
    private int state;

//    private IELTSTrain ieltsTrain;//培训机构
    //一个雅思培训可以举办多个考试
    private int ieltsTrainId;//雅思机构编号
    private String trainName;//雅思机构名称

//    private int StudentTotal;


    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getIeltsTrainId() {
        return ieltsTrainId;
    }

    public void setIeltsTrainId(int ieltsTrainId) {
        this.ieltsTrainId = ieltsTrainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

//    public int getStudentTotal() {
//        return StudentTotal;
//    }
//
//    public void setStudentTotal(int studentTotal) {
//        StudentTotal = studentTotal;
//    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

