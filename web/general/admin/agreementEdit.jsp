<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/22
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <input name="id"  type="hidden">
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>协议标题：</td>
                <td><input name="title" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写协议标题'" />
                </td>
                <td class="table_left"><font color="red">*</font>协议类型：</td>
                <td><input name="type" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写协议类型'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>签订国外院校：</td>
                <td><input type="text" name="foreignCollegeId" data-options="width: 150,required:true,missingMessage:'请选择所属国外院校'" />
                </td>
                <td class="table_left"><font color="red">*</font>签订时间：</td>
                <td><input name="agreementTime" class="easyui-datebox" data-options="width: 150,required:true,missingMessage:'请填写签订时间'" />
                </td>

            </tr>
            <tr>
                <td class="table_left">协议内容：</td>
                <td colspan="3"><textarea name="content" style="height: 360px;"></textarea>
                </td>
            </tr>

        </table>
    </form>
</div>
