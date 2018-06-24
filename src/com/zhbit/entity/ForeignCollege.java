package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */
//国外院校
@Entity
@Table(name="tb_foreign_college")
public class ForeignCollege {
    private int id;//
    private String foreignName;//名称
    private String foreignType;//类型
    private String stat;//状态
    private List<Chair>chairList;//一个院校对应多个讲座
    private List<Agreement>agreementList;
    //private List<ForCollegeAgreement> forCollegeAgreementList;//一个院校可以与本校签订多分协议
    private List<SummerCamp> summerCampList;
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 50)
    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }
    @Column(length = 50)
    public String getForeignType() {
        return foreignType;
    }

    public void setForeignType(String foreignType) {
        this.foreignType = foreignType;
    }
    @Column(length = 50)
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    //一个院校对应多个讲座
    @OneToMany(mappedBy = "foreignCollege" ,targetEntity = Chair.class)
    public List<Chair> getChairList() {
        return chairList;
    }

    public void setChairList(List<Chair> chairList) {
        this.chairList = chairList;
    }
   /* //一个院校可以与本校签订多份协议
    @OneToMany(mappedBy = "foreignCollege",targetEntity = ForCollegeAgreement.class)
    public List<ForCollegeAgreement> getForCollegeAgreementList() {
        return forCollegeAgreementList;
    }

    public void setForCollegeAgreementList(List<ForCollegeAgreement> forCollegeAgreementList) {
        this.forCollegeAgreementList = forCollegeAgreementList;
    }*/
    @OneToMany(mappedBy ="foreignCollege",targetEntity = Agreement.class)
    public List<Agreement> getAgreementList() {
        return agreementList;
    }

    public void setAgreementList(List<Agreement> agreementList) {
        this.agreementList = agreementList;
    }

    @OneToMany(mappedBy = "foreignCollege",targetEntity =SummerCamp.class )
    public List<SummerCamp> getSummerCampList() {
        return summerCampList;
    }

    public void setSummerCampList(List<SummerCamp> summerCampList) {
        this.summerCampList = summerCampList;
    }
}
