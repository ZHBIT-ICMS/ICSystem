package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/5
 * @Time:15:51 描述：
 */
//讲座
@Entity
@Table(name="tb_chair")
public class Chair {
    private int id;
    private String title;
    private String content;
    private Date visitTime;//到访时间
    private Date activityTime;//活动时间
    private ForeignCollege foreignCollege;//国外院校
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 20)
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
    @ManyToOne
    @JoinColumn(name = "foreignCollegeId")
    public ForeignCollege getForeignCollege() {
        return foreignCollege;
    }

    public void setForeignCollege(ForeignCollege foreignCollege) {
        this.foreignCollege = foreignCollege;
    }
}
