<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/24
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center" style="padding: 5px;overflow: hidden;">
    <form id="userForm" method="post">
        <input name="ids" type="hidden" />
        <table>
            <tr>
                <td class="table_left">参加的雅思考试：</td>
                <td><input name="ieltsExamIds" data-options="width: 150" />
                </td>
            </tr>
        </table>
    </form>
</div>
