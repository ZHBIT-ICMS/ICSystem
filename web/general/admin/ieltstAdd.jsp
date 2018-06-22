<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <%--private int id;//自增编号--%>
        <%--private String ieltsTrainId;//雅思机构编号--%>
        <%--private String trainName;//雅思机构名称--%>
        <%--private String trainTerm;//培训的学期--%>
        <%--private Date trainTime;//培训的时期--%>
        <%--private String trainClassHours;//雅思课程学时--%>
        <table class="tableForm">
            <tr>
                <th style="width:80px;">雅思机构编号</th>
                <td><input name="ieltsTrainId" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写新闻标题'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">雅思机构名称</th>
                <td><input name="trainName" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写发布人'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">培训的学期</th>
                <td><input name="trainTerm" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写发布人'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">培训的时期</th>
                <td><input name="trainTime" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写发布人'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">雅思课程学时</th>
                <td><input name="trainClassHours" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写发布人'" style="width: 97%;" />
                </td>
            </tr>
        </table>
    </form>
</div>