<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/24
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;overflow: hidden;">
    <form id="userForm" method="post">
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>学号：</td>
                <td><input name="stuId" class="easyui-numberbox" type="text" data-options="min:0, max:999999999999,width: 150,required:true,missingMessage:'请填写学号'" />
                </td>
                <td class="table_left"><font color="red">*</font>学生姓名：</td>
                <td><input name="name" type="text"  class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写学生姓名'" />
                </td>

            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>学生专业：</td>
                <td><input name="major" class="easyui-validatebox" type="text" data-options="width: 150,required:true,missingMessage:'请填写学生专业'" />
                </td>
                <td class="table_left">学生状态：</td>
                <td><select name="status">
                    <option value="在校" selected="selected">在校</option>
                    <option value="出国">出国</option>
                    <option value="外出学习">外出学习</option>
                    <option value="休学">休学</option>
                </select>
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>所属班级：</td>
                <td><input name="classInfoId" type="text" data-options="width: 150,required:true,missingMessage:'请选择所属班级'" />
                </td>
                <td class="table_left">参加的夏令营：</td>
                <td><input name="summerCampIds" type="text" data-options="width: 150,required:true,missingMessage:'请选择参加的夏令营'" />
                </td>
            </tr>

            <tr>
                <td class="table_left"><font color="red">*</font>参加的雅思培训：</td>
                <td><input name="ieltsTrainIds" type="text" data-options="width: 150,required:true,missingMessage:'请选择参加的雅思培训'" />
                </td>
                <td class="table_left">参加的雅思考试：</td>
                <td><input name="ieltsExamIds" type="text" data-options="width: 150,required:true,missingMessage:'请选择参加的雅思考试'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>所属出国生身份：</td>
                <td><input name="overSeasStudentId" type="text" data-options="width: 150,required:true,missingMessage:'请选择所属出国生身份'" />
                </td>
                <td class="table_left">所属交换生身份：</td>
                <td><input name="exchangeStudentId" type="text" data-options="width: 150,required:true,missingMessage:'请选择所属交换生身份'" />
                </td>
            </tr>
        </table>
    </form>
</div>
