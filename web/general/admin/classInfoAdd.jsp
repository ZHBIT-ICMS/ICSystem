<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/20
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <th style="width:80px;">班级编号</th>
                <td><input name="classNo" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写学院名称'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">班级名称</th>
                <td><input name="descInfo" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写学院描述'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">所属学院</th>
                <td><input type="text" name="collegeId" style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属学院'"/>
                </td>
            </tr>
        </table>
    </form>
</div>
