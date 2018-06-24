
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
            <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <%--//  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
            <div style="padding: 5px;">
                <form method="post">
                    <input type="hidden" name="id" />
                    <table class="tableForm">
                        <tr>
                            <th style="width:80px;">考试的编号</th>
                            <td><input name="examId" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写考试的编号'" style="width: 97%;" />
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">考试类型</th>
                            <td>
                                <select name="sign">
                                    <option value="0" selected="selected">正式考试</option>
                                    <option value="1">模拟考试</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">雅思考试时间</th>
                            <td><input name="examTime" class="easyui-datetimebox" data-options="required:true,missingMessage:'请填写雅思考试时间'" style="width: 97%;" />
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">雅思考试地点</th>
                            <td><input name="examPlace" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写雅思考试地点'" style="width: 97%;" />
                            </td>
                        </tr>
                        <tr>
                            <th style="width:50px;">考试时长</th>
                            <td><input name="duration" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写考试时长'" style="width: 97%;" />
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
        </table>
    </form>
</div>