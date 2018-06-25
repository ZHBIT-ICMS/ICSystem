<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/20
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <input type="hidden" name="id" />
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>班级编号：</td>
                <td><input name="classNo" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写班级编号'" />
                </td>
                <td class="table_left"><font color="red">*</font>班级名称：</td>
                <td><input name="descInfo" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写班级名称'" />
                </td>

            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>所属学院：</td>
                <td><input type="text" name="collegeId"  data-options="width: 150,required:true,missingMessage:'请选择所属学院'" />
                </td>
            </tr>
        </table>
    </form>
</div>
