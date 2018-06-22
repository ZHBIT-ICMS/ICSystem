package com.zhbit.entity.vo;

import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/22
 * @Time:10:16
 * @Description描述：
 */
public class VoAgreement {
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;

    private int id;
    private String type;
    private String title;
    private Date agreementTime;
    private String content;
    private int foreignCollegeId;
    private String foreignCollegeName;

    public int getForeignCollegeId() {
        return foreignCollegeId;
    }

    public void setForeignCollegeId(int foreignCollegeId) {
        this.foreignCollegeId = foreignCollegeId;
    }

    public String getForeignCollegeName() {
        return foreignCollegeName;
    }

    public void setForeignCollegeName(String foreignCollegeName) {
        this.foreignCollegeName = foreignCollegeName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAgreementTime() {
        return agreementTime;
    }

    public void setAgreementTime(Date agreementTime) {
        this.agreementTime = agreementTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
