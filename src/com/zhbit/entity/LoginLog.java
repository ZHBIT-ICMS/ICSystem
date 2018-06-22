package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @ProjectName: ICSystem
 * @ClassName: LoginLog
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/21 23:35
 */

@Entity
@Table(name="tb_login_log")
public class LoginLog {
    private int id;//标号
    private String userNo;//登录账号
    private String loginIp;//登录ip地址
    private String userAgent;//操作系统
    private Date loginTime;//登录时间

    public LoginLog() {
    }


    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length=128)
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Column(length=32)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Column(length=64)
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
