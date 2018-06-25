<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/17
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<div style="padding: 5px;">
    <form method="post">
        <%--private int id;//主键--%>
        <%--private  String examId;//考试的编号--%>
        <%--private Date examTime;//雅思考试时间--%>
        <%--private String examPlace;//雅思考试地点--%>
        <%--private int score;//分数--%>
        <%--//    private IELTSTrain ieltsTrain;//培训机构--%>
        <%--//一个雅思培训可以举办多个考试--%>
        <%--private int ieltsTrainId;//雅思机构编号--%>
        <%--private String trainName;//雅思机构名称--%>
        <table class="tableForm">
            <tr>
                <td class="table_left"><font color="red">*</font>考试的编号：</td>
                <td><input name="examId" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写考试的编号'" />
                </td>
                <td class="table_left">考试类型：</td>
                <td>
                    <select name="sign">
                        <option value="0" selected="selected">正式考试</option>
                        <option value="1">模拟考试</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>雅思考试地点：</td>
                <td><input name="examPlace" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写雅思考试地点'" />
                </td>
                <td class="table_left"><font color="red">*</font>考试时长：</td>
                <td><input name="duration" class="easyui-validatebox" data-options="width: 150,required:true,missingMessage:'请填写考试时长'" />
                </td>
            </tr>
            <tr>
                <td class="table_left"><font color="red">*</font>雅思考试时间：</td>
                <td><input name="examTime" class="easyui-datetimebox" data-options="width: 150,required:true,missingMessage:'请填写雅思考试时间'" />
                </td>
                <td class="table_left"><font color="red">*</font>所属机构：</td>
                <td><input name="ieltsTrainId" type="text" data-options="width: 150,required:true,missingMessage:'请选择所属所属机构'" />
                </td>
            </tr>
        </table>
    </form>
</div>
