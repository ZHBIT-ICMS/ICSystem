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
                            <th style="width:80px;">考试的编号</th>
                            <td><input name="examId" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写考试的编号'" style="width: 97%;" />
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">雅思考试时间</th>
                            <td><input name="examTime" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写雅思考试时间'" style="width: 97%;" />
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">雅思考试地点</th>
                            <td><input name="examPlace" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写雅思考试地点'" style="width: 97%;" />
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">分数</th>
                            <td><input name="score" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写分数'" style="width: 97%;" />
                            </td>
                        </tr>

                        <tr>
                            <th style="width:50px;">所属机构</th>
                            <td><input type="text" name="ieltsTrainId" style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属所属机构'"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
