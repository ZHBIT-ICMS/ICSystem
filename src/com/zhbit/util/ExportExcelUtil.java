package com.zhbit.util;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ICSystem
 * @ClassName: ExportExcelUtil
 * @Description: 导出excel表
 * @Author: wenxuan
 * @CreateDate: 2018/6/22 17:05
 */
public class ExportExcelUtil implements Serializable {
    private static final long serialVersionUID = 1L;

    // 文件名
    private String fileName;
    // 标记
    private String titleName;
    // sheet名称
    private String sheetName;
    // 所有列名称
    private List<List<String>> complexColumnNames;
    private List<String> columnNames;
    private List<List<String>> datas;
    // 所有列合并列数
    private List<Map<String, String>> columnsWidth;
    //区分导出类型
    private String type;

    private HttpServletResponse response;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<List<String>> getComplexColumnNames() {
        return complexColumnNames;
    }

    public void setComplexColumnNames(List<List<String>> complexColumnNames) {
        this.complexColumnNames = complexColumnNames;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<List<String>> getDatas() {
        return datas;
    }

    public void setDatas(List<List<String>> datas) {
        this.datas = datas;
    }

    public List<Map<String, String>> getColumnsWidth() {
        return columnsWidth;
    }

    public void setColumnsWidth(List<Map<String, String>> columnsWidth) {
        this.columnsWidth = columnsWidth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
