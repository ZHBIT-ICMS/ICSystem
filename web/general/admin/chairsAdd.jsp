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
        <table class="tableForm">
            <tr>
                <th style="width:80px;">讲座主题</th>
                <td><input name="title" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写讲座主题'" style="width:150px;"/>
                </td>
            </tr>
            <tr>
                <th style="width:50px;">讲座内容</th>
               <%-- <td><input name="content" class="easyui-textbox" data-options="required:true,missingMessage:'请填写讲座内容'" style="width: 97%;" />
                </td>--%>
               <td><textarea name="content" style="height: 200px;width: 98%;"></textarea></td>
            </tr>
            <tr>
                <th style="width:50px;">到访时间</th>
                <td><input name="visitTime"  class="easyui-datebox" id="visitTime"  data-options="required:true,missingMessage:'请填写到访日期'" style="width:150px;"/></td>
            </tr>
            <tr>
                <th style="width:50px;">活动时间</th>
                <td><input name="activityTime"  class="easyui-datebox" id="activityTime"  data-options="required:true,missingMessage:'请填写活动日期'" style="width:150px;"/></td>
            </tr>
            <tr>
                <th style="width:50px;">所属国外院校</th>
                <td><input name="foreignCollegeId"  type="text" id="foreignCollegeId"  style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属国外院校'"/></td>
            </tr>
        </table>
    </form>
</div>