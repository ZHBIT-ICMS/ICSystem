<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/21
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <input name="id"  type="hidden">
        <table class="tableForm">
            <tr>
                <th style="width:80px;">讲座主题</th>
                <td><input name="title" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写讲座名称'" style="width: 97% ;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">讲座内容</th>
                <td><input name="content" class="easyui-textbox" data-options="required:true,missingMessage:'请填写讲座主题'" style="width: 97%; height:70px;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">到访时间</th>
                <td><input name="visitTime"  class="easyui-datebox" id="visitTime" size="10" data-options="required:true,missingMessage:'请填写到访日期'"/></td>
            </tr>
            <tr>
                <th style="width:50px;">活动时间</th>
                <td><input name="activityTime"  class="easyui-datebox" id="activityTime" size="10" data-options="required:true,missingMessage:'请填写活动日期'"/></td>
            </tr>
            <tr>
                <th style="width:50px;">所属国外院校</th>
                <td><input name="foreignCollegeId"  type="text" id="foreignCollegeId"  style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属国外院校'"/></td>
            </tr>
        </table>
    </form>
</div>
