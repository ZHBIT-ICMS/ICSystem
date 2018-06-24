<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>国际合作交流管理系统</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body class="easyui-layout">
<div data-options="region:'north',href:'${pageContext.request.contextPath}/general/layout/north.jsp'" style="height: 55px; overflow: hidden;" ></div>
<div data-options="region:'west',title:'功能导航',href:'${pageContext.request.contextPath}/general/layout/west.jsp'" style="width: 200px;overflow: hidden;"></div>
<div data-options="region:'east',title:'日历',split:true,href:'${pageContext.request.contextPath}/general/layout/east.jsp'" style="width: 210px;overflow: hidden;"></div>
<div data-options="region:'center',title:'欢迎使用国际合作交流管理平台',href:'${pageContext.request.contextPath}/general/layout/center.jsp'" style="overflow: hidden;"></div>
<div data-options="region:'south',href:'${pageContext.request.contextPath}/general/layout/south.jsp'" style="height: 20px;overflow: hidden;"></div>

<jsp:include page="isIe.jsp"></jsp:include>
</body>
</html>