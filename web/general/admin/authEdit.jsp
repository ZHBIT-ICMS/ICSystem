<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:46
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
    <form method="post">
        <input name="cid" type="hidden" />
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>权限名称：</td>
                <td><input name="cname" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写菜单名称'" />
                </td>
                <td class="table_left">排序：</td>
                <td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="10" style="width:120px;" /></td>
            </tr>
            <tr>
                <td class="table_left">权限地址：</td>
                <td><input name="curl" style="width:98%;" /></td>
                <td class="table_left">上级权限：</td>
                <td><input name="pid" style="width: 240px;" /></td>

            </tr>
            <tr>
                <td class="table_left">权限描述：</td>
                <td colspan="3">
                    <input name="cdesc" class="easyui-validatebox" data-options="width: 150" />
                </td>
            </tr>
        </table>
    </form>
</div>
