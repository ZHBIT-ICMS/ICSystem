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
                <th style="width:80px;">通知公告标题</th>
                <td><input name="title" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写新闻标题'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
            <tr>
                <th style="width:80px;">发布人</th>
                <td><input name="people" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写新闻标题'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th>通知公告内容</th>
                <td><textarea name="content" style="height: 460px;width: 98%;">${content}</textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
