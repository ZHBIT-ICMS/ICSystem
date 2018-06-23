package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */
@Entity
@Table(name="tb_forcollege_ieltstrain")
public class ForCollegeIELTSTrain {
    private int id;
    private IELTSTrain ieltsTrain;//雅思培训编号
    private ForeignCollege foreignCollege;//国外院校编号

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "ieltsTrainId")
    public IELTSTrain getIeltsTrain() {
        return ieltsTrain;
    }


    public void setIeltsTrain(IELTSTrain ieltsTrain) {
        this.ieltsTrain = ieltsTrain;
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


