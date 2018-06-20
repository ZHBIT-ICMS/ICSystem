package com.zhbit.entity.base;

import java.io.Serializable;
import java.util.List;


/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:23:12
 * 描述：
 *easyui的datagrid模型
 */
public class DataGrid implements Serializable {

	private Long total;// 总记录数
	private List rows;// 每行记录
	private List footer;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}

}
