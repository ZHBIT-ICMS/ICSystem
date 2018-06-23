package com.zhbit.entity.vo;

import com.zhbit.entity.ClassesInfo;
import com.zhbit.entity.IELTSExam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:50
 * 描述：CollegeInfo的pageModel
 */
public class VoIELTSTrain implements Serializable {
    private static final long serialVersionUID = 1L;
    //private String id;
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;

    private int id;//自增编号
    private String ieltsTrainId;//雅思机构编号
    private String trainName;//雅思机构名称
    private String trainTerm;//培训的学期
    private Date trainTime;//培训的时期
    private String trainClassHours;//雅思课程学时
//    private List<IELTSExam> examList;//雅思考试

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getIeltsTrainId() {
        return ieltsTrainId;
    }

    public void setIeltsTrainId(String ieltsTrainId) {
        this.ieltsTrainId = ieltsTrainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

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

    public String getTrainClassHours() {
        return trainClassHours;
    }

    public void setTrainClassHours(String trainClassHours) {
        this.trainClassHours = trainClassHours;
    }
//
//    public List <IELTSExam> getExamList() {
//        return examList;
//    }
//
//    public void setExamList(List <IELTSExam> examList) {
//        this.examList = examList;
//    }
}
