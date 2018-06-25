<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
    $.messager.progress({
        text : '数据加载中....',
        interval : 100
    });
</script>
<div style="padding: 5px;">
    <form id="userForm" method="post">
        <input name="id" type="hidden" />
        <table class="tableForm">
            <tr>
                <td class="table_left">用户名：</td>
                <td><input name="userNo" readonly="readonly" />
                </td>
                <td class="table_left">所属角色：</td>
                <td><input name="roleIds" style="width: 150px;" /></td>
            </tr>
            <tr>
                <td class="table_left">密码：</td>
                <td><input name="password" type="password" />
                </td>
                <td colspan="2" style="text-align: left;">如果不修改请留空</td>
            </tr>
            <tr>
                <td class="table_left">真实姓名：</td>
                <td><input name="userName" type="text"  class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写真实姓名'" />
                <td class="table_left">学院：</td>
                <td><input type="text" name="collegeId" style="width: 145px;" />
                </td>
            </tr>
            <tr>
                <td class="table_left">邮箱：</td>
                <td><input name="email" type="text" />
                </td>
                <td class="table_left">状态：</td>
                <td><select name="locked">
                    <option value="0">启用</option>
                    <option value="1">停用</option>
                </select>
                </td>
            </tr>
            <tr>
                <%--  <th>邮箱</th>
                  <td><input name="email" type="text" />
                  </td>--%>
                <td class="table_left">身份：</td>
                <td><select name="sign" >
                    <option value="0" >管理员</option>
                    <option value="1">学生</option>
                </select>
                </td>
            </tr>
        </table>
    </form>
</div>
