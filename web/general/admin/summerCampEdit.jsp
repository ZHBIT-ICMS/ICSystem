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
                <th style="width:80px;">夏令营活动名称</th>
                <td><input name="activityName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写夏令营活动名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">夏令营活动描述</th>
                <td><input name="activityDesc" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写夏令营活动描述'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">夏令营活动时间</th>
                <td><input name="activityTime"  class="easyui-datebox" id="visitTime"  data-options="required:true,missingMessage:'请填写夏令营活动时间'" style="width:150px;"/></td>
            </tr>
            <tr>
                <th style="width:50px;">所属国外院校</th>
                <td><input type="text" name="foreignCollegeId" style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属国外院校'"/>
                </td>
            </tr>
        </table>
    </form>
</div>
