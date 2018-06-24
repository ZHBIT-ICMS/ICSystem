<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/more.css">--%>

</head>
<body>
<iframe name="head" src="${pageContext.request.contextPath}/common/header.jsp" width="100%" height="130px" scrolling="no" frameborder="0"></iframe>

<div class="more page">
    <div class="more_container">
        <ul>

            <c:forEach items="${exchangeStudentList }" var="n">
                <li>

                    <a href="news_getExchangestuId.action"? exchangestuId=${n.id} target="_blank">${n.schoolName }</a>
                </li>
            </c:forEach>
        </ul>
        <%--分页--%>
        <div class="pager">
            <ul class="clearfix">
                ${pageCode}
            </ul>
        </div>
    </div>

</div>
</body>
</html>