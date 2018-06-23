package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoIELTSExam;
import com.zhbit.entity.vo.VoIELTSTrain;

import java.util.List;

/**
 * Created by wby on 2018/6/20.
 */
public  interface IELTSTExamService {

    public void delete(String ids);

    public void edit(VoIELTSExam voIELTSExam);

    public void add(VoIELTSExam voIELTSExam);

    public DataGrid dataGrid(VoIELTSExam voIELTSExam);

    public List<VoIELTSExam> combobox();
}
