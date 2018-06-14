package com.zhbit.entity.vo;

import com.zhbit.entity.ProfessionInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/13
 * @Time:9:50 描述：
 */
public class VoCollegeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    //private String id;
    private String pid;
    private String pname;
    private String state = "open";// 是否展开(open,closed)
    private String iconCls;// 前面的小图标样式

    private int id;//主键
    private String collegeName;//学院名称
    private String descInfo;//学院描述
    private List<ProfessionInfo> classesInfoList=new ArrayList<ProfessionInfo>();//一个学院包括多个专业

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public List<ProfessionInfo> getClassesInfoList() {
        return classesInfoList;
    }

    public void setClassesInfoList(List<ProfessionInfo> classesInfoList) {
        this.classesInfoList = classesInfoList;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
}
