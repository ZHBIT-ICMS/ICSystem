<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>雅思机构编号：</td>
                <td><input name="ieltsTrainId" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写雅思机构编号'" />
                </td>
                <td class="table_left"><font color="red">*</font>雅思机构名称：</td>
                <td><input name="trainName" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写雅思机构名称'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>培训的学期：</td>
                <td><input name="trainTerm" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写培训的学期'" />
                </td>
                <td class="table_left"><font color="red">*</font>培训的开始时期：</td>
                <td><input name="trainClassHours" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写雅思课程学时'" />
                </td>
            </tr>

            <tr>
                <td class="table_left"><font color="red">*</font>培训的开始时期：</td>
                <td><input name="trainTime" class="easyui-datebox" data-options="width: 150,required:true,missingMessage:'请填写培训的时期'" />
                </td>

            </tr>
        </table>
    </form>
</div>