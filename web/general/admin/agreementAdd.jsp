<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;">
    <form method="post">
        <table class="tableForm">
            <tr>
                <th style="width:80px;">协议标题</th>
                <td><input name="title" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写协议标题'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">协议类型</th>
                <td><input name="type" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写协议类型'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th style="width:50px;">签订国外院校</th>
                <td><input type="text" name="foreignCollegeId" style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属国外院校'"/>
                </td>
            </tr>
            <tr>
                <th style="width:50px;">签订时间</th>
                <td><input name="agreementTime" class="easyui-datebox" data-options="required:true,missingMessage:'请填写签订时间'" style="width: 97%;" />
                </td>
            </tr>
            <tr>
                <th>协议内容</th>
                <td><textarea name="content" style="height: 460px;width: 98%;"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
