<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css">
    <title>导航栏</title>
</head>
<body>
<div class="header page">
    <div class="header_head">
    <img src="${pageContext.request.contextPath}/img/logo.jpg" width="180px" class="header_logo">
    </div>
<nav class="header_nav">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link text-white" href="main.jsp" target="center">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="news.jsp" target="center">新闻</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">通知公告</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">院校信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">国际班</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">政策法规</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#">联系我们</a>
            </li>
        </ul>
    </nav>
</div>
</div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>