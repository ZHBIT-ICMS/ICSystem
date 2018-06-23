package com.zhbit.entity.vo;

import com.zhbit.entity.ForeignCollege;

import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:9:16
 * 描述：Chair的PageModel
 */
public class VoChair  {
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;

    private int id;
    private String title;
    private String content;
    private Date visitTime;//到访时间
    private Date activityTime;//活动时间
    private String foreignCollegeName;//国外院校名称
    private int foreignCollegeId;
    //private ForeignCollege foreignCollege;//国外院校


    public int getForeignCollegeId() {
        return foreignCollegeId;
    }

    public void setForeignCollegeId(int foreignCollegeId) {
        this.foreignCollegeId = foreignCollegeId;
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

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getForeignCollegeName() {
        return foreignCollegeName;
    }

    public void setForeignCollegeName(String foreignCollegeName) {
        this.foreignCollegeName = foreignCollegeName;
    }
}
