package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoClassesInfo;
import com.zhbit.entity.vo.VoCollegeInfo;
import com.zhbit.entity.vo.VoIELTSTrain;

import java.util.List;

/**
 * Created by wby on 2018/6/20.
 */
public  interface IELTSTInfoService {

    public void delete(String ids);

    public void edit(VoIELTSTrain voIELTSTrain);

    public void add(VoIELTSTrain voIELTSTrain);

    public DataGrid dataGrid(VoIELTSTrain voIELTSTrain);

    public List<VoIELTSTrain> combobox();
}
