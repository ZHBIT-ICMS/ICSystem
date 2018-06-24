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
                <th style="width:80px;">雅思机构编号</th>
                <td><input name="ieltsTrainId" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写雅思机构编号'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">雅思机构名称</th>
                <td><input name="trainName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写雅思机构名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">培训的学期</th>
                <td><input name="trainTerm" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写培训的学期'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">培训的开始时期</th>
                <td><input name="trainTime" class="easyui-datebox" data-options="required:true,missingMessage:'请填写培训的时期'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">雅思课程学时</th>
                <td><input name="trainClassHours" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写雅思课程学时'" style="width: 97%;" />
                </td>
            </tr>
        </table>
    </form>
</div>
