<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <th style="width: 70px;">权限名称</th>
                <td><input name="cname" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写菜单名称'" style="width: 155px;" /></td>
                <th style="width: 50px;">排序</th>
                <td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="10" style="width:120px;" /></td>
            </tr>
            <tr>
                <th>权限地址</th>
                <td colspan="3"><input name="curl" style="width:98%;" /></td>
            </tr>
            <tr>
                <th>权限描述</th>
                <td colspan="3"><input name="cdesc" style="width:98%;" /></td>
            </tr>
            <tr>
                <th>上级权限</th>
                <td colspan="3"><input name="pid" style="width: 335px;" /></td>
            </tr>
        </table>
    </form>
</div>
