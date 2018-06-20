package com.zhbit.entity.vo;

import java.io.Serializable;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/20
 * @Time:22:18
 * 描述：ForeignCollege的pageModel
 */
public class VoForeignCollege implements Serializable {
    private static final long serialVersionUID = 1L;
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private String ids;
    //以下属性来自ForeignCollege
    private int id;//
    private String foreignName;//名称
    private String foreignType;//类型
    private String stat;//状态

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

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getForeignType() {
        return foreignType;
    }

    public void setForeignType(String foreignType) {
        this.foreignType = foreignType;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
