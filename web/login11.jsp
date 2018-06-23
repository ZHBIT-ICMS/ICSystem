<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%


%>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            list-style: none;
            font-family: "微软雅黑",Arial,Helvetica,sans-serif;
        }
        body{
            min-width: 960px;
            background: url("img/loginOld.jpg");
            background-size: cover;
            /*background-color: #F6F6F6 !important;*/

        }
        .on{
            color: #00a7ea !important;
        }
        .clearfix:after { content: ""; display: block; clear: both;}
        a:hover{
            text-decoration: none !important;
        }
        .container{
            width: 100% !important;
            margin: 0 !important;
            padding: 0 !important;
            overflow: hidden;
        }
        .header{
            position: relative;
            height: 80px;
            background: #fff;
        }
        .header_logo{
            position: relative;
            top: 13px;
        }
        .login_container{
            width: 100%;
            height: 680px;
            /*background: url("./images/loginOld.jpg");*/

        }

        .login_box{
            position: relative;
            left: 60%;
            top: 100px;
        }
        .login_box_form input,.login_box_form button{
            position: relative;
            left: 50%;
            transform: translateX(-50%);
        }
        .login_box_header {
            text-align: center;
        }
        .login_box_header a{
            display: inline-block;
            margin-top: 50px;
            font-size: 18px;
            color: #515151;
            margin-bottom: 50px;
        }
        #footer{
            bottom: 0;
            text-align: center;
            background-color: #ffffff;
            width: 100%;
            height: 50px;
        }
        #footer p{
            position: relative;
            top: 50%;
            transform: translateY(-50%);
        }

    </style>
    <script type="text/javascript">
        //      function checkForm(){
        //          var userName=document.getElementById("userName").value;
        //          var password=document.getElementById("password").value;
        //          if(userName==null || userName==""){a
        //              document.getElementById("error").innerHTML="用户名不能为空";
        //              return false;
        //          }
        //          if(password==null || password==""){
        //              document.getElementById("error").innerHTML="密码不能为空";
        //              return false;
        //          }
        //          return true;
        //      }
    </script>
</head>
<body>
<div class="container">
    <%--<div class="header clearfix">--%>
    <%--<div class="header_logo">--%>
    <%----%>
    <%--</div>--%>
    <%--</div>--%>
    <div class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                    <p>One fine body&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <div class="login_container">
        <div class="login_box" style="width: 350px;height: 400px;background-color: white">
            <div class="login_box_header">
                <a href="javascript:void(0)" style="margin-right: 20px" class="on">账号登陆</a> |
                <a href="javascript:void(0)" style="margin-left: 20px">验证码登陆</a>
            </div>
            <div class="login_box_form" >
                <form action="shopping_cart.html">
                    <input type="text" placeholder="   Flyme账号/手机号" style="width: 300px;height: 46px;border: 1px solid #DADADA"required="required"><br>
                    <input type="password" placeholder="   密码" style="width: 300px;height: 46px;border: 1px solid #DADADA;margin-top: 30px"  required="required"><br>
                    <div style="margin-top: 20px;margin-left: 30px"><input type="checkbox" style="position: relative;left: 0px">记住登陆状态</div>
                    <button class="btn btn-primary" style="width: 300px;height: 46px;background-color: #00a7ea;border: none;margin-top: 20px">登陆</button>
                    <br>
                    <div class="login_box_footer clearfix" style="margin-top: 10px;margin-left: 30px;width: 300px">
                        <a href="javascript:void(0)" style="float: left">注册</a>
                        <a href="javascript:void(0)" style="float: right">忘记密码?</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>