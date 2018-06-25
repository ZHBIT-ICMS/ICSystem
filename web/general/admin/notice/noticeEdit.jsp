<%--
  Created by IntelliJ IDEA.
  User: 孔文轩
  Date: 2018/6/21
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: 5px;">
    <form method="post">
        <input type="hidden" name="id" />
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>通知公告标题：</td>
                <td><input name="title" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写通知公告标题'" />
                </td>
                <td class="table_left"><font color="red">*</font>发布人：</td>
                <td><input name="people" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写发布人'" />
                </td>
            </tr>
            <tr>
                <td class="table_left">通知公告内容：</td>
                <td colspan="3"><textarea name="content" style="height: 360px;">${content}</textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
