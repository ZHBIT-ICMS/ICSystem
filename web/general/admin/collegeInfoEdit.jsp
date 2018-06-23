<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: 5px;">
    <form method="post">
        <input type="hidden" name="id" />
        <table class="tableForm">
            <tr>
                <th style="width:80px;">学院名称</th>
                <td><input name="collegeName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写学院名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
            <tr>
                <th style="width:80px;">学院描述</th>
                <td><input name="descInfo" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写学院描述'" style="width: 97%;" />
                </td>
            </tr>
        </table>
    </form>
</div>
