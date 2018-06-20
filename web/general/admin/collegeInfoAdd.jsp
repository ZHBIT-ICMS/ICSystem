<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <th style="width:80px;">学院名称</th>
                <td><input name="collegeName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写学院名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">学院描述</th>
                <td><input name="descInfo" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写学院描述'" style="width: 97%;" />
                </td>
            </tr>
        </table>
    </form>
</div>
