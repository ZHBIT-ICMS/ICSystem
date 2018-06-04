package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wby on 2018/4/6.
 */

//政策法规
@Entity
@Table(name="tb_policy")
public class Policy {
    private int id;//标号
    private String title;//标题题目
    private String content;//具体内容
    private Date createTime;//通知时间
    private String people;//发通知的人

    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(length=50)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    @Column(columnDefinition="TEXT")
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
    @Column(length=20)
    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

}
