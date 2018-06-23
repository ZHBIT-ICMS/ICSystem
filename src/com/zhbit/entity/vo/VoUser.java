package com.zhbit.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:22:04
 * 描述：
 */
public class VoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ids;
    private String roleIds;
    private String roleNames;
    //private String collegeId;
    private String authIds;
    private String authNames;
    private String authUrls;
    private int page;// 当前页
    private int rows;// 每页显示记录数
    private String sort;// 排序字段名
    private String order;// 按什么排序(asc,desc)
    private Date ccreatedatetimeStart;
    private Date cmodifydatetimeStart;
    private Date ccreatedatetimeEnd;
    private Date cmodifydatetimeEnd;

//
    private int id;
    private String userNo;//用户编号
    private String userName;//用户名
    private String password;//密码
    private String loginIp;//登录ip
    private Date loginDate;//最后一次登录时间
    private String photo;//用户头像
    private int sign;//用户类型 0管理员 1学生用户
    private String phone;//联系电话
    private String email;//邮箱
    private Date birthday;//生日
    private int gender;//性别 性别 0不详 1男  2女
    private int collegeId;//学院id
    private String collegeName;//学院名称
    private int locked;// DEFAULT'0' COMMENT 是否锁定 1锁定 0未锁定',
    private String remark;//描述
    private Date createDate;//创建时间
    private Date updateDate;//更新时间
    private int creator;//创建者
    private int updater;//更新者
    public VoUser() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }

    public String getAuthNames() {
        return authNames;
    }

    public void setAuthNames(String authNames) {
        this.authNames = authNames;
    }

    public String getAuthUrls() {
        return authUrls;
    }

    public void setAuthUrls(String authUrls) {
        this.authUrls = authUrls;
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

    public Date getCcreatedatetimeStart() {
        return ccreatedatetimeStart;
    }

    public void setCcreatedatetimeStart(Date ccreatedatetimeStart) {
        this.ccreatedatetimeStart = ccreatedatetimeStart;
    }

    public Date getCmodifydatetimeStart() {
        return cmodifydatetimeStart;
    }

    public void setCmodifydatetimeStart(Date cmodifydatetimeStart) {
        this.cmodifydatetimeStart = cmodifydatetimeStart;
    }

    public Date getCcreatedatetimeEnd() {
        return ccreatedatetimeEnd;
    }

    public void setCcreatedatetimeEnd(Date ccreatedatetimeEnd) {
        this.ccreatedatetimeEnd = ccreatedatetimeEnd;
    }

    public Date getCmodifydatetimeEnd() {
        return cmodifydatetimeEnd;
    }

    public void setCmodifydatetimeEnd(Date cmodifydatetimeEnd) {
        this.cmodifydatetimeEnd = cmodifydatetimeEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }
}
