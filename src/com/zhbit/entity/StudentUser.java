package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/5
 * @Time:16:34 描述：
 */
//学生用户表
@Entity
@Table(name="tb_student_user")
public class StudentUser {
    private int id;
    private String userNo;//用户编号
    private String userName;
    private String password;
    private String nickName;//昵称
    private String loginIp;//登录ip
    private Date loginDate;//最后一次登录时间
    private String photo;//用户头像
    private String phone;//联系电话
    private String email;//邮箱
    private Date birthday;//生日
    private int gender;//性别 性别 0不详 1男  2女
    private int collegeId;//学院id
    private int locked;// DEFAULT'0' COMMENT 是否锁定 1锁定 0未锁定',
    private String remark;//描述
    private String status;//DEFAULT '1' COMMENT '1正常  0删除 -1全部'
    private Date createDate;//创建时间
    private Date updateDate;//更新时间
    private int creator;//创建者
    private int updater;//更新者
    private List<InternationalStudent>internationalStudentList;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 64)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(length = 128)
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    @Column(length =64 )
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    @Column(length = 128)
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
    @Column(length = 512)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Column(length = 16)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
   @Column(length = 64)
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
    @Column(length = 2)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    @Column(length = 11)
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
    @Column(length = 1)
    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
    @Column(length = 512)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(length = 20)
    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    @Column(length = 20)
    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }

    @OneToMany(mappedBy = "studentUser",targetEntity = InternationalStudent.class)
    public List<InternationalStudent> getInternationalStudentList() {
        return internationalStudentList;
    }

    public void setInternationalStudentList(List<InternationalStudent> internationalStudentList) {
        this.internationalStudentList = internationalStudentList;
    }
}
