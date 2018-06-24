package com.zhbit.entity.vo;

import java.io.Serializable;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/23
 * @Time:16:41
 * @Description：
 */
public class VoInternationalStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ids;//国际班学生id的集合
    private String ieltsExamIds;
    private String ieltsExamNames; //参加的雅思考试的名称的集合
    private String summerCampIds;
    private String summerCampNames;//参加的夏令营的名称的集合
    private String ieltsTrainIds;
    private String ieltsTrainNames;//参加的雅思培训的名称的集合
    private int exchangeStudentId;
    private String exchangeStudentName;
    private int overSeasStudentId;
    private String overSeasStudentName;
    private int classInfoId; //所属班级Id
    private String classInfoName;//所属班级名称
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)



    private int id;
    private String stuId;//学号
    private String name;//姓名
    private String status;//状态
    private String major;//专业

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getIeltsExamIds() {
        return ieltsExamIds;
    }

    public void setIeltsExamIds(String ieltsExamIds) {
        this.ieltsExamIds = ieltsExamIds;
    }

    public String getIeltsExamNames() {
        return ieltsExamNames;
    }

    public void setIeltsExamNames(String ieltsExamNames) {
        this.ieltsExamNames = ieltsExamNames;
    }


    public String getSummerCampIds() {
        return summerCampIds;
    }

    public void setSummerCampIds(String summerCampIds) {
        this.summerCampIds = summerCampIds;
    }

    public String getSummerCampNames() {
        return summerCampNames;
    }

    public void setSummerCampNames(String summerCampNames) {
        this.summerCampNames = summerCampNames;
    }

    public String getIeltsTrainIds() {
        return ieltsTrainIds;
    }

    public void setIeltsTrainIds(String ieltsTrainIds) {
        this.ieltsTrainIds = ieltsTrainIds;
    }

    public String getIeltsTrainNames() {
        return ieltsTrainNames;
    }

    public void setIeltsTrainNames(String ieltsTrainNames) {
        this.ieltsTrainNames = ieltsTrainNames;
    }

    public int getExchangeStudentId() {
        return exchangeStudentId;
    }

    public void setExchangeStudentId(int exchangeStudentId) {
        this.exchangeStudentId = exchangeStudentId;
    }

    public String getExchangeStudentName() {
        return exchangeStudentName;
    }

    public void setExchangeStudentName(String exchangeStudentName) {
        this.exchangeStudentName = exchangeStudentName;
    }

    public int getOverSeasStudentId() {
        return overSeasStudentId;
    }

    public void setOverSeasStudentId(int overSeasStudentId) {
        this.overSeasStudentId = overSeasStudentId;
    }

    public String getOverSeasStudentName() {
        return overSeasStudentName;
    }

    public void setOverSeasStudentName(String overSeasStudentName) {
        this.overSeasStudentName = overSeasStudentName;
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

    public int getClassInfoId() {
        return classInfoId;
    }

    public void setClassInfoId(int classInfoId) {
        this.classInfoId = classInfoId;
    }

    public String getClassInfoName() {
        return classInfoName;
    }

    public void setClassInfoName(String classInfoName) {
        this.classInfoName = classInfoName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
