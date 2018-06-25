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
                <td class="table_left"><font color="red">*</font>讲座主题：</td>
                <td><input name="title" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写讲座主题'" />
                </td>
                <td class="table_left"><font color="red">*</font>所属国外院校：</td>
                <td><input name="foreignCollegeId"  type="text"  id="foreignCollegeId"  data-options="width: 150,required:true,missingMessage:'请选择所属国外院校'" />
                </td>

            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>到访时间：</td>
                <td><input name="visitTime" class="easyui-datebox" id="visitTime" data-options="width: 150,required:true,missingMessage:'请填写到访日期'" />
                </td>
                <td class="table_left"><font color="red">*</font>活动时间：</td>
                <td><input name="activityTime" class="easyui-datebox" id="activityTime" data-options="width: 150,required:true,missingMessage:'请填写活动日期'" />
                </td>

            </tr>
            <tr>
                <td class="table_left">讲座内容：</td>
                <td colspan="3"><textarea name="content" style="height: 360px;"></textarea>
                </td>
            </tr>

        </table>
    </form>
</div>