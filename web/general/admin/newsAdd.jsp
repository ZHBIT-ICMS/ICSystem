<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/17
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <th style="width:80px;">新闻标题</th>
                <td><input name="title" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写新闻标题'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">发布人</th>
                <td><input name="people" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写发布人'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th>新闻内容</th>
                <td><textarea name="content" style="height: 460px;width: 98%;"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
