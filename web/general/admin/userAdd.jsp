<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;overflow: hidden;">
    <form id="userForm" method="post">
        <table class="tableForm">
            <tr>
                <th style="width: 55px;">用户名</th>
                <td><input name="userNo" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录名称'" />
                </td>
                <th style="width: 55px;">所属角色</th>
                <td><input name="roleIds" style="width: 145px;"  data-options="required:'true',missingMessage:'请选择所属角色'"/>
                </td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input name="password" type="password" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录密码'" />
                </td>
                <th>重复密码</th>
                <td><input type="password" class="easyui-validatebox" data-options="required:'true',missingMessage:'请再次填写密码',validType:'eqPassword[\'#userForm input[name=password]\']'" />
                </td>
            </tr>
            <tr>
                <th>真实姓名</th>
                <td><input name="userName" type="text" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写真实姓名'" />
                </td>
                <th>学院</th>
                <td><input type="text" name="collegeId" style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属学院'"/>
                </td>
            </tr>
            <tr>
                <th>邮箱</th>
                <td><input name="email" type="text" />
                </td>
                <th>状态</th>
                <td><select name="locked">
                    <option value="0" selected="selected">启用</option>
                    <option value="1">停用</option>
                </select>
                </td>
            </tr>
            <tr>
                <th>身份</th>
                <td><select name="sign" data-options="required:'true',missingMessage:'请选择用户身份'" >
                    <option value="0">管理员</option>
                    <option value="1">学生</option>
                </select>
                </td>
            </tr>
        </table>
    </form>
</div>
