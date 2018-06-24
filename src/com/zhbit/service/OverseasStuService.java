package com.zhbit.service;

import com.zhbit.entity.OverSeasStudent;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoOverseasStu;

import java.util.List;

/**
 * @ProjectName: ICSystem
 * @ClassName: OverseasStuService
 * @Description: java类作用描述
 * @Author: wenxuan
 * @CreateDate: 2018/6/21 16:56
 */
public interface OverseasStuService {

    /**
     * 显示所有出国生的信息
     * @param overSeasStudent
     * @param pageBean
     * @return
     */
    public List<OverSeasStudent> showOverseasStuList(OverSeasStudent overSeasStudent, PageBean pageBean);

    public Long getOverseasStuCount(OverSeasStudent overSeasStudent);

    public OverSeasStudent getOverseasStuById(int overSeasStuId);

    public DataGrid datagrid(VoOverseasStu voOverseasStu);

    //删除
    public void delete(String ids);

    //修改
    public void update(VoOverseasStu voOverseasStu);

    //添加
    public void add(VoOverseasStu voOverseasStu);

    public List<VoOverseasStu> combobox();
}
