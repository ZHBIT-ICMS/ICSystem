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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/center.css">
    <title>导航栏</title>
</head>
<body>
<div class="center page">
    <div id="main-img" class="carousel slide" data-ride="carousel">
        <!-- 指示符 -->
        <ul class="carousel-indicators">
            <li data-target="#main-img" data-slide-to="0" class="active"></li>
            <li data-target="#main-img" data-slide-to="1"></li>
            <li data-target="#main-img" data-slide-to="2"></li>
        </ul>
        <!-- 轮播图片 -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="main-img" src="${pageContext.request.contextPath}/img/main1.jpg" width="100%" height="300px">
                <div class="carousel-caption">
                    <p>访问卡迪夫大学商学院</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="main-img" src="img/main2.jpg" width="100%" height="300px">
                <div class="carousel-caption">
                    访问斯克莱德大学
                </div>
            </div>
            <div class="carousel-item">
                <img class="main-img" src="${pageContext.request.contextPath}/img/main3.jpg" width="100%" height="300px">
                <div class="carousel-caption">
                    英国莱斯特大学访问我校
                </div>
            </div>
        </div>
        <!-- 左右切换按钮 -->
        <a class="carousel-control-prev" href="#main-img" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#main-img" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
    <div class="center_box">
        <h3 class="center_box_title">国际合作</h3>
        <div class="row">
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
            <div class="col-3">
                <div style="width: 180px;height: 88px" class="box_img"></div>
            </div>
        </div>
    </div>
    <div class="center_detail clearfix">
        <div class="detail_news  detail_box clearfix">
            <div class="detail_title"><span class="detail_title_span">新闻动态</span>
                <span class="detail_title_more"><a href="${pageContext.request.contextPath}/news.action" target="_blank">more</a></span></div>
            <ul>
                <c:forEach items="${newsList}" var="n">
                <li>

                    <a href="news_getNewsById.action"?newsId=${n.id} target="_blank">${n.title }</a>
                </li>
                </c:forEach>
            </ul>
        </div>

        <div class="detail_notice detail_box clearfix">
            <div class="detail_title"><span class="detail_title_span">公告通知</span><span><a href="${pageContext.request.contextPath}/notice.action" target="_blank">more</a></span></div>
            <ul>
                <c:forEach items="${noticeList }" var="n">
                <li>

                    <a href="news_getNoticeById.action"? newsId=${n.id} target="_blank">${n.title }</a>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>