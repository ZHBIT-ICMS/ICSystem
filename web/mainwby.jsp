<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
         <%--pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <%--<title>Insert title here</title>--%>
    <%--<style type="text/css">--%>
        <%--.clearfix:after{content:".";display:block;height:0;clear:both;visibility:hidden}--%>
        <%--.clearfix{display:inline-block}--%>
        <%--.clearfix{display:block}--%>
        <%--.pager { margin-top:15px; }--%>
        <%--.pager ul { float:right; }--%>
        <%--.pager ul li { float:left; border:1px solid #eee; line-height:18px; padding:0 3px; margin:0 1px; display:inline; }--%>
        <%--.pager ul li.current { font-weight:bold; color:#630; }--%>
        <%--ul { list-style:none; }--%>
        <%--a:link, a:visited { color:#3a52a8; text-decoration:none; }--%>
        <%--a:hover, a:active { color:#3a52a8; text-decoration:underline; }--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div id="news" class="right-main">--%>
    <%--<h1>${news.title}</h1>--%>
    <%--<div class="content">--%>
        <%--${news.content}--%>
    <%--</div>--%>
<%--</div>--%>


<%--<div class="product-list">--%>
    <%--<h2>全部商品</h2>--%>
    <%--<ul class="product clearfix">--%>
        <%--<c:forEach items="${noticeList }" var="p">--%>
            <%--<li>--%>
                <%--<dl>--%>

                    <%--<dd class="title">--%>
                        <%--<a href="news_getNewsById.action" target="_blank">${p.title }</a>--%>
                    <%--</dd>--%>
                    <%--<dd class="price">--%>
                        <%--￥${p.people }--%>
                    <%--</dd>--%>
                <%--</dl>--%>
            <%--</li>--%>
        <%--</c:forEach>--%>
    <%--</ul>--%>
    <%--<div class="clear"></div>--%>
    <%--<div class="pager">--%>
        <%--<ul class="clearfix">--%>
            <%--${pageCode }--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


<%--<%@ page language="java" contentType="text/html; charset=utf-8"--%>
         <%--pageEncoding="utf-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<%--<%--%>


<%--%>--%>
<%--<html lang="zh">--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<title>登录</title>--%>
    <%--<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>--%>
    <%--<style type="text/css">--%>
        <%--*{--%>
            <%--margin: 0;--%>
            <%--padding: 0;--%>
            <%--list-style: none;--%>
            <%--font-family: "微软雅黑",Arial,Helvetica,sans-serif;--%>
        <%--}--%>
        <%--body{--%>
            <%--min-width: 960px;--%>
            <%--background: url("./images/login.jpg");--%>
            <%--background-size: cover;--%>
            <%--/*background-color: #F6F6F6 !important;*/--%>

        <%--}--%>
        <%--.on{--%>
            <%--color: #00a7ea !important;--%>
        <%--}--%>
        <%--.clearfix:after { content: ""; display: block; clear: both;}--%>
        <%--a:hover{--%>
            <%--text-decoration: none !important;--%>
        <%--}--%>
        <%--.container{--%>
            <%--width: 100% !important;--%>
            <%--margin: 0 !important;--%>
            <%--padding: 0 !important;--%>
            <%--overflow: hidden;--%>
        <%--}--%>
        <%--.header{--%>
            <%--position: relative;--%>
            <%--height: 80px;--%>
            <%--background: #fff;--%>
        <%--}--%>
        <%--.header_logo{--%>
            <%--position: relative;--%>
            <%--top: 13px;--%>
        <%--}--%>
        <%--.login_container{--%>
            <%--width: 100%;--%>
            <%--height: 680px;--%>
            <%--/*background: url("./images/login.jpg");*/--%>

        <%--}--%>

        <%--.login_box{--%>
            <%--position: relative;--%>
            <%--left: 60%;--%>
            <%--top: 100px;--%>
        <%--}--%>
        <%--.login_box_form input,.login_box_form button{--%>
            <%--position: relative;--%>
            <%--left: 50%;--%>
            <%--transform: translateX(-50%);--%>
        <%--}--%>
        <%--.login_box_header {--%>
            <%--text-align: center;--%>
        <%--}--%>
        <%--.login_box_header a{--%>
            <%--display: inline-block;--%>
            <%--margin-top: 50px;--%>
            <%--font-size: 18px;--%>
            <%--color: #515151;--%>
            <%--margin-bottom: 50px;--%>
        <%--}--%>
        <%--#footer{--%>
            <%--bottom: 0;--%>
            <%--text-align: center;--%>
            <%--background-color: #ffffff;--%>
            <%--width: 100%;--%>
            <%--height: 50px;--%>
        <%--}--%>
        <%--#footer p{--%>
            <%--position: relative;--%>
            <%--top: 50%;--%>
            <%--transform: translateY(-50%);--%>
        <%--}--%>

    <%--</style>--%>
    <%--<script type="text/javascript">--%>
        <%--//      function checkForm(){--%>
        <%--//          var userName=document.getElementById("userName").value;--%>
        <%--//          var password=document.getElementById("password").value;--%>
        <%--//          if(userName==null || userName==""){a--%>
        <%--//              document.getElementById("error").innerHTML="用户名不能为空";--%>
        <%--//              return false;--%>
        <%--//          }--%>
        <%--//          if(password==null || password==""){--%>
        <%--//              document.getElementById("error").innerHTML="密码不能为空";--%>
        <%--//              return false;--%>
        <%--//          }--%>
        <%--//          return true;--%>
        <%--//      }--%>
    <%--</script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--&lt;%&ndash;<div class="header clearfix">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="header_logo">&ndash;%&gt;--%>
    <%--&lt;%&ndash;&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="modal fade" tabindex="-1" role="dialog">--%>
        <%--<div class="modal-dialog" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                    <%--<h4 class="modal-title">Modal title</h4>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<p>One fine body&hellip;</p>--%>
                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                    <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
                <%--</div>--%>
            <%--</div><!-- /.modal-content -->--%>
        <%--</div><!-- /.modal-dialog -->--%>
    <%--</div><!-- /.modal -->--%>
    <%--<div class="login_container">--%>
        <%--<div class="login_box" style="width: 350px;height: 400px;background-color: white">--%>
            <%--<div class="login_box_header">--%>
                <%--<a href="javascript:void(0)" style="margin-right: 20px" class="on">账号登陆</a> |--%>
                <%--<a href="javascript:void(0)" style="margin-left: 20px">验证码登陆</a>--%>
            <%--</div>--%>
            <%--<div class="login_box_form" >--%>
                <%--<form action="shopping_cart.html">--%>
                    <%--<input type="text" placeholder="   Flyme账号/手机号" style="width: 300px;height: 46px;border: 1px solid #DADADA"required="required"><br>--%>
                    <%--<input type="password" placeholder="   密码" style="width: 300px;height: 46px;border: 1px solid #DADADA;margin-top: 30px"  required="required"><br>--%>
                    <%--<div style="margin-top: 20px;margin-left: 30px"><input type="checkbox" style="position: relative;left: 0px">记住登陆状态</div>--%>
                    <%--<button class="btn btn-primary" style="width: 300px;height: 46px;background-color: #00a7ea;border: none;margin-top: 20px">登陆</button>--%>
                    <%--<br>--%>
                    <%--<div class="login_box_footer clearfix" style="margin-top: 10px;margin-left: 30px;width: 300px">--%>
                        <%--<a href="javascript:void(0)" style="float: left">注册</a>--%>
                        <%--<a href="javascript:void(0)" style="float: right">忘记密码?</a>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<div>--%>
    <%--<h4>新闻动态</h4>--%>
    <%--<ul>--%>

        <%--<li><a href="news.action">aaa</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>

<%--<div>--%>
    <%--<h4>公告动态</h4>--%>
    <%--<ul>--%>

        <%--<li><a href="notice.action">aaa</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>

<%--<div>--%>
    <%--<h4>政策动态</h4>--%>
    <%--<ul>--%>

        <%--<li><a href="policy.action">aaa</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>
<%--<%@ page language="java" contentType="text/html; charset=utf-8"--%>
         <%--pageEncoding="utf-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<%--<%--%>


<%--%>--%>
<%--<html lang="zh">--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<title>登录</title>--%>
    <%--<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>--%>
    <%--<style type="text/css">--%>
        <%--*{--%>
            <%--margin: 0;--%>
            <%--padding: 0;--%>
            <%--list-style: none;--%>
            <%--font-family: "微软雅黑",Arial,Helvetica,sans-serif;--%>
        <%--}--%>
        <%--body{--%>
            <%--min-width: 960px;--%>
            <%--background: url("./images/login.jpg");--%>
            <%--background-size: cover;--%>
            <%--/*background-color: #F6F6F6 !important;*/--%>

        <%--}--%>
        <%--.on{--%>
            <%--color: #00a7ea !important;--%>
        <%--}--%>
        <%--.clearfix:after { content: ""; display: block; clear: both;}--%>
        <%--a:hover{--%>
            <%--text-decoration: none !important;--%>
        <%--}--%>
        <%--.container{--%>
            <%--width: 100% !important;--%>
            <%--margin: 0 !important;--%>
            <%--padding: 0 !important;--%>
            <%--overflow: hidden;--%>
        <%--}--%>
        <%--.header{--%>
            <%--position: relative;--%>
            <%--height: 80px;--%>
            <%--background: #fff;--%>
        <%--}--%>
        <%--.header_logo{--%>
            <%--position: relative;--%>
            <%--top: 13px;--%>
        <%--}--%>
        <%--.login_container{--%>
            <%--width: 100%;--%>
            <%--height: 680px;--%>
            <%--/*background: url("./images/login.jpg");*/--%>

        <%--}--%>

        <%--.login_box{--%>
            <%--position: relative;--%>
            <%--left: 60%;--%>
            <%--top: 100px;--%>
        <%--}--%>
        <%--.login_box_form input,.login_box_form button{--%>
            <%--position: relative;--%>
            <%--left: 50%;--%>
            <%--transform: translateX(-50%);--%>
        <%--}--%>
        <%--.login_box_header {--%>
            <%--text-align: center;--%>
        <%--}--%>
        <%--.login_box_header a{--%>
            <%--display: inline-block;--%>
            <%--margin-top: 50px;--%>
            <%--font-size: 18px;--%>
            <%--color: #515151;--%>
            <%--margin-bottom: 50px;--%>
        <%--}--%>
        <%--#footer{--%>
            <%--bottom: 0;--%>
            <%--text-align: center;--%>
            <%--background-color: #ffffff;--%>
            <%--width: 100%;--%>
            <%--height: 50px;--%>
        <%--}--%>
        <%--#footer p{--%>
            <%--position: relative;--%>
            <%--top: 50%;--%>
            <%--transform: translateY(-50%);--%>
        <%--}--%>

    <%--</style>--%>
    <%--<script type="text/javascript">--%>
        <%--//      function checkForm(){--%>
        <%--//          var userName=document.getElementById("userName").value;--%>
        <%--//          var password=document.getElementById("password").value;--%>
        <%--//          if(userName==null || userName==""){a--%>
        <%--//              document.getElementById("error").innerHTML="用户名不能为空";--%>
        <%--//              return false;--%>
        <%--//          }--%>
        <%--//          if(password==null || password==""){--%>
        <%--//              document.getElementById("error").innerHTML="密码不能为空";--%>
        <%--//              return false;--%>
        <%--//          }--%>
        <%--//          return true;--%>
        <%--//      }--%>
    <%--</script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--&lt;%&ndash;<div class="header clearfix">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="header_logo">&ndash;%&gt;--%>
    <%--&lt;%&ndash;&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="modal fade" tabindex="-1" role="dialog">--%>
        <%--<div class="modal-dialog" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                    <%--<h4 class="modal-title">Modal title</h4>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<p>One fine body&hellip;</p>--%>
                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                    <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
                <%--</div>--%>
            <%--</div><!-- /.modal-content -->--%>
        <%--</div><!-- /.modal-dialog -->--%>
    <%--</div><!-- /.modal -->--%>
    <%--<div class="login_container">--%>
        <%--<div class="login_box" style="width: 350px;height: 400px;background-color: white">--%>
            <%--<div class="login_box_header">--%>
                <%--<a href="javascript:void(0)" style="margin-right: 20px" class="on">账号登陆</a> |--%>
                <%--<a href="javascript:void(0)" style="margin-left: 20px">验证码登陆</a>--%>
            <%--</div>--%>
            <%--<div class="login_box_form" >--%>
                <%--<form action="shopping_cart.html">--%>
                    <%--<input type="text" placeholder="   Flyme账号/手机号" style="width: 300px;height: 46px;border: 1px solid #DADADA"required="required"><br>--%>
                    <%--<input type="password" placeholder="   密码" style="width: 300px;height: 46px;border: 1px solid #DADADA;margin-top: 30px"  required="required"><br>--%>
                    <%--<div style="margin-top: 20px;margin-left: 30px"><input type="checkbox" style="position: relative;left: 0px">记住登陆状态</div>--%>
                    <%--<button class="btn btn-primary" style="width: 300px;height: 46px;background-color: #00a7ea;border: none;margin-top: 20px">登陆</button>--%>
                    <%--<br>--%>
                    <%--<div class="login_box_footer clearfix" style="margin-top: 10px;margin-left: 30px;width: 300px">--%>
                        <%--<a href="javascript:void(0)" style="float: left">注册</a>--%>
                        <%--<a href="javascript:void(0)" style="float: right">忘记密码?</a>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<div>--%>
    <%--<h4>新闻动态</h4>--%>
    <%--<ul>--%>

        <%--<li><a href="news.action">aaa</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>

<%--<div>--%>
    <%--<h4>公告动态</h4>--%>
    <%--<ul>--%>

        <%--<li><a href="notice.action">aaa</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>

<%--<div>--%>
    <%--<h4>政策动态</h4>--%>
    <%--<ul>--%>

        <%--<li><a href="policy.action">aaa</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%--</body>--%>
<%--</html>--%>