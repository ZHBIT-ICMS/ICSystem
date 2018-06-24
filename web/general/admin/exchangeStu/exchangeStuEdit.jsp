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
                <th style="width:80px;">交换生名称</th>
                <td><input name="exchangeName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写交换生名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:80px;">替换的课程</th>
                <td><input name="replaceCourse" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写替换的课程'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:80px;">替换的学分</th>
                <td><input name="replaceCredit" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写替换的学分'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:80px;">出国的学校</th>
                <td><input name="schoolName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写出国的学校'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:80px;">出国的类型</th>
                <td><input name="schoolType" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写出国的类型'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">出国的时间</th>
                <td><input name="goAbroadTime" id="goAbroadTime" class="easyui-datebox" data-options="required:true,missingMessage:'请填写出国的时间'" style="width: 97%;" />
                </td>
            </tr>

        </table>
    </form>
</div>

