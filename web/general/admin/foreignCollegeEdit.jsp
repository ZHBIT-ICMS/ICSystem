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
        <input type="hidden" name="id"/>
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>国外院校名称：</td>
                <td><input name="foreignName" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写国外院校名称'" />
                </td>
                <td class="table_left"><font color="red">*</font>国外院校类型：</td>
                <td><input name="foreignType" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'国外院校类型'" />
                </td>

            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>国外院校状态：</td>
                <td><input name="stat" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写国外院校状态'" />
                </td>
            </tr>
        </table>
    </form>
</div>
