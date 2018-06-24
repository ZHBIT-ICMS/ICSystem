package com.zhbit.entity.vo;

import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/21
 * @Time:22:28
 * 描述：SummerCamp的PageModel
 */
public class VoSummerCamp {
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;

    private int id;
    private String activityName;
    private String activityDesc;
    private Date activityTime;//夏令营活动开始时间
    private int foreignCollegeId;
    private String foreignCollegeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

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
}
