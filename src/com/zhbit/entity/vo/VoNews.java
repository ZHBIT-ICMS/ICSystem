package com.zhbit.entity.vo;

import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/15
 * @Time:10:17
 * 描述：
 * 视图层模型VoNews（对应持久化模型News）
 */
public class VoNews  {
    //easyUI的datagrid所用到的属性
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;

     //以下属性来自News实体
    private int id;//标号
    private String title;//标题题目
    private String content;//具体内容
    private Date createTime;//发布时间
    private String people;//发通知的人

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
