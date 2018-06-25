<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/22
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <input type="hidden" name="id" />
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>夏令营活动名称：</td>
                <td><input name="activityName" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写夏令营活动名称'" />
                </td>
                <td class="table_left"><font color="red">*</font>夏令营活动描述：</td>
                <td><input name="activityDesc" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写夏令营活动描述'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>夏令营活动时间：</td>
                <td><input name="activityTime" class="easyui-datebox" id="visitTime" data-options="width: 150,required:true,missingMessage:'请填写夏令营活动时间'" />
                </td>
                <td class="table_left"><font color="red">*</font>所属国外院校：</td>
                <td><input type="text" name="foreignCollegeId" data-options="width: 150,required:true,missingMessage:'请选择所属国外院校'" />
                </td>
            </tr>
        </table>
    </form>
</div>
