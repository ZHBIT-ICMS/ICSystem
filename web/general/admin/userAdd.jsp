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
                <td class="table_left"><font color="red">*</font>用户名：</td>
                <td><input name="userNo" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写登录名称'" />
                </td>
                <td class="table_left"><font color="red">*</font>真实姓名：</td>
                <td><input name="userName" type="text"  class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写真实姓名'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>密码：</td>
                <td><input name="password" type="password" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写登录密码'" />
                </td>
                <td class="table_left"><font color="red">*</font>重复密码：</td>
                <td><input type="password" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请再次填写密码',validType:'eqPassword[\'#userForm input[name=password]\']'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>所属角色：</td>
                <td><input name="roleIds" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请选择所属角色'" />
                </td>
                <td class="table_left"><font color="red">*</font>学院：</td>
                <td><input name="collegeId" type="text"  data-options="width: 150,required:true,missingMessage:'请选择所属学院'" />
                </td>
            </tr>
            <tr>
                <td class="table_left">邮箱：</td>
                <td><input name="email" type="text" data-options="width: 150" />
                </td>
                <td class="table_left">状态：</td>
                <td><select name="locked">
                    <option value="0" selected="selected">启用</option>
                    <option value="1">停用</option>
                </select>
                </td>
            </tr>
            <tr>
                <td class="table_left">身份：</td>
                <td><select name="sign" data-options="required:'true',missingMessage:'请选择用户身份'" >
                    <option value="0">管理员</option>
                    <option value="1">学生</option>
                </select>
                </td>
            </tr>
        </table>
    </form>
</div>
