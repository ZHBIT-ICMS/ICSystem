<%--
  Created by IntelliJ IDEA.
  User: 孔文轩
  Date: 2018/6/20
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: 5px;">
    <form method="post">
        <input type="hidden" name="id" />
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>交换生名称：</td>
                <td><input name="exchangeName" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写交换生名称'" />
                </td>
                <td class="table_left"><font color="red">*</font>替换的课程：</td>
                <td><input name="replaceCourse" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写替换的课程'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>替换的学分：</td>
                <td><input name="replaceCredit" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写替换的学分'" />
                </td>
                <td class="table_left"><font color="red">*</font>出国的学校：</td>
                <td><input name="schoolName" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写出国的学校'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>出国的类型：</td>
                <td><input name="schoolType" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写出国的类型'" />
                </td>
                <td class="table_left"><font color="red">*</font>出国的时间：</td>
                <td><input name="goAbroadTime" id="goAbroadTime"  class="easyui-datebox" data-options="width: 150,required:true,missingMessage:'请填写出国的时间'" />
                </td>
            </tr>

        </table>
    </form>
</div>

