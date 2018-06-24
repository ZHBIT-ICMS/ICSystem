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
                <th style="width: 65px;">学号</th>
                <td><input name="stuId" class="easyui-numberbox" type="text" data-options="min:0, max:999999999999,required:'true',missingMessage:'请填写学号'" style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">学生姓名</th>
                <td><input name="name" type="text" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写学生姓名'" style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">学生专业</th>
                <td><input name="major" type="text" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写学生专业'" style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">学生状态</th>
                <td><select name="status">
                    <option value="在校" selected="selected">在校</option>
                    <option value="出国">出国</option>
                    <option value="外出学习">外出学习</option>
                    <option value="休学">休学</option>
                </select>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">所属班级</th>
                <td><input name="classInfoId" type="text"  data-options="required:'true',missingMessage:'请选择所属班级'"  style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">参加的夏令营</th>
                <td><input name="summerCampIds" type="text" data-options="missingMessage:'请选择参加的夏令营'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">参加的雅思培训</th>
                <td><input name="ieltsTrainIds" type="text" data-options="missingMessage:'请选择参加的雅思培训'" style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">参加的雅思考试</th>
                <td><input name="ieltsExamIds" type="text" data-options="missingMessage:'请选择参加的雅思考试'" style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">所属出国生身份</th>
                <td><input name="overSeasStudentId" type="text"  data-options="missingMessage:'请选择所属出国生身份'"  style="width: 97%;"/>
                </td>
            </tr>
            <tr>
                <th style="width: 65px;">所属交换生身份</th>
                <td><input name="exchangeStudentId" type="text"  data-options="missingMessage:'请选择所属交换生身份'"  style="width: 97%;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
