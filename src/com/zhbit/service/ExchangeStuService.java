package com.zhbit.service;

import com.zhbit.entity.ExchangeStudent;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoExchangeStu;

import java.util.List;

/**
 * @ProjectName: ICSystem
 * @ClassName: ExchangeStuService
 * @Description: ExchangeStudent management
 * @Author: wenxuan
 * @CreateDate: 2018/6/20 10:41
 */
public interface ExchangeStuService {

    /**
     * 显示所有交换生的信息
     * @param exchangeStudent
     * @param pageBean
     * @return
     */
    public List<ExchangeStudent> showExchangeStuList(ExchangeStudent exchangeStudent, PageBean pageBean);

    public Long getExchangeStuCount(ExchangeStudent exchangeStudent);

    public ExchangeStudent getExchangeStuById(int exchangeStuId);

    public DataGrid datagrid(VoExchangeStu voExchangeStu);

    //删除
    public void delete(String ids);

    //修改
    public void update(VoExchangeStu voExchangeStu);

    //添加
    public void add(VoExchangeStu voExchangeStu);

    public List<VoExchangeStu> combobox();
}
