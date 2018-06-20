<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/20
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <th style="width:80px;">国外院校名称</th>
                <td><input name="foreignName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写国外院校名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">国外院校类型</th>
                <td><input name="foreignType" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写国外院校类型'" style="width: 97%;" />
                </td>
                <th style="width:50px;">国外院校状态</th>
                <td><input name="stat" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写国外院校状态'" style="width: 97%;" />
                </td>
            </tr>
        </table>
    </form>
</div>
