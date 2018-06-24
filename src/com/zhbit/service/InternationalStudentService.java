package com.zhbit.service;

import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.vo.VoInternationalStudent;
import com.zhbit.exception.ValidateFieldsException;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/23
 * @Time:16:53
 * @Description：
 * 国际班学生服务接口
 */
public interface InternationalStudentService {
    public void save(VoInternationalStudent voInternationalStudent) throws ValidateFieldsException;;
    public DataGrid dataGrid(VoInternationalStudent voInternationalStudent);
    public void delete(String ids);
    public void update(VoInternationalStudent voInternationalStudent) throws ValidateFieldsException;;
    public void editSummerCamp(VoInternationalStudent voInternationalStudent);
    public void editIeltsExam(VoInternationalStudent voInternationalStudent);
    public void editIeltsTrain(VoInternationalStudent voInternationalStudent);
   /* public void editInStuInfo(VoInternationalStudent voInternationalStudent);*/
}
