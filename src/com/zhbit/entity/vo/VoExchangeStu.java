package com.zhbit.entity.vo;

import java.util.Date;

/**
 * @ProjectName: ICSystem
 * @ClassName: VoExchangeStu
 * @Description: 交换生管理
 * @Author: wenxuan
 * @CreateDate: 2018/6/20 10:25
 */
public class VoExchangeStu {
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;
    private String exchangeName;//交换生的名称
    //以下属性来自ExchangeStu实体
    private int id;//交换生标识号
    private Date goAbroadTime;//出国的时间
    private String replaceCourse;//替换的课程
    private String replaceCredit;//替换的时间
    private String schoolName;//出国的学校
    private String schoolType;//出国的类型

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
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

    public Date getGoAbroadTime() {
        return goAbroadTime;
    }

    public void setGoAbroadTime(Date goAbroadTime) {
        this.goAbroadTime = goAbroadTime;
    }

    public String getReplaceCourse() {
        return replaceCourse;
    }

    public void setReplaceCourse(String replaceCourse) {
        this.replaceCourse = replaceCourse;
    }

    public String getReplaceCredit() {
        return replaceCredit;
    }

    public void setReplaceCredit(String replaceCredit) {
        this.replaceCredit = replaceCredit;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }
}
