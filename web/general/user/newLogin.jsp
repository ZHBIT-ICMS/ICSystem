<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/19
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en" class="fullscreen-bg">

<head>
    <title>系统登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/style/assets/css/demo.css">--%>

    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/style/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/style/assets/img/favicon.png">

    <script type="text/javascript">
        function check(form){
            // alert("1")
            var userNo=document.getElementById("signin-text");
            var password=document.getElementById("signin-password");
            //alert("2")
            if(userNo.value==null||userNo.value==""){
                alert("请输入用户名");
                return false;
            }
            if(password.value==null||password.value==""){
                alert("请输入密码！");
                return false;
            }
            //alert("3")
            return true;
        }
    </script>
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <div class="vertical-align-wrap">
        <div class="vertical-align-middle">
            <div class="auth-box ">
                <div class="left">
                    <div class="content">
                        <div class="header">
                            <div class="logo text-center"><img src="assets/img/logo-dark.png" alt="Klorofil Logo"></div>
                            <p class="lead">Login to your account</p>
                        </div>
                        <form class="form-auth-small" action="user!doNotNeedSession_login.action" id="loginForm" method="post" onsubmit="return check(this)">
                            <div class="form-group">
                                <label for="signin-text" class="control-label sr-only">账号</label>
                                <input type="text" class="form-control" id="signin-text"  placeholder="账号" name="userNo">
                            </div>
                            <div class="form-group">
                                <label for="signin-password" class="control-label sr-only">密码</label>
                                <input type="password" class="form-control" id="signin-password"  placeholder="密码" name="password">
                            </div>
                            <div class="form-group">
                                <label for="signin-user" class="control-label sr-only" >用户身份</label>
                                <select class="form-control" id="signin-user" name="sign">
                                    <option value="0">管理员</option>
                                    <option value="1">学生</option>
                                </select>
                            </div>
                            <div class="form-group clearfix">
                                <label class="fancy-checkbox element-left">
                                    <input type="checkbox">
                                    <span>记住密码</span>
                                </label>
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                            <div class="bottom">
                                <span class="helper-text"><i class="fa fa-lock"></i> <a href="#">忘记密码?</a></span>
                            </div>
                        </form>
                        <div class="from-group clearfix">
                            <span><font color="red"><s:property value="#request.msg"/> </font></span>
                        </div>
                    </div>
                </div>
                <div class="right">
                    <div class="overlay"></div>
                    <div class="content text">
                        <h1 class="heading">System of International Exchange & Cooperation</h1>
                        <p>by The ZHBIT</p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<!-- END WRAPPER -->
</body>

</html>

