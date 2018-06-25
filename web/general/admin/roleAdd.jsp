<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center" style="padding: 5px;overflow: hidden;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>角色名称：</td>
                <td><input name="cname" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写菜单名称'" />
                </td>
                <td class="table_left"><font color="red">*</font>拥有权限：</td>
                <td><input name="authIds" style="width:250px;" />
                </td>
            </tr>
            <tr>
                <td class="table_left">备注：</td>
                <td colspan="3"><textarea name="cdesc" style="height: 150px;"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
