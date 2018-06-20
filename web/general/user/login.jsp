
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html lang="zh">
<head>
    <base href="<%=basePath%>">

    <title>用户登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="login">
    <meta http-equiv="description" content="login">
    <script type="text/javascript">
         function check(form){
            // alert("1")
            var userNo=document.getElementById("username");
            var password=document.getElementById("password");
            //alert("2")
            if(userNo.value==null||userNo.value==""){
                alert("请输入用户名");
                return false;
            }
            if(password.value==null||password.value==""){
                alert("请输入密码！");
                return false;
            }
           if (radioCheck()==false){
                alert("请选择身份！");
                return false;
           }
             //alert("3")
          return true;
         }
         function radioCheck() {
             var check=0;
             var radio=document.getElementsByName("sign");
             for (var i=0;i<radio.length;i++){
                 if(radio[i].checked==true){
                     check++;
                     //alert(""+radio[i].value);
                 }
             }
             if(check>0){

                 return true;
             }
             else {
                 return false;
             }
            /* logForm.action="user!doNotNeedSession_login.action";*/
         }
    </script>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            font-size: 12px;
            background: url(${pageContext.request.contextPath}/img/bg.jpg) top repeat-x;
        }

        /*.input {
            width: 150px;
            height: 17px;
            border-top: 1px solid #404040;
            border-left: 1px solid #404040;
            border-right: 1px solid #D4D0C8;
            border-bottom: 1px solid #D4D0C8;
        }*/
    </style>
</head>

<body>
<form id="loginForm" action="user!doNotNeedSession_login.action"
      method="post" onsubmit="return check(this)">
    <table width="750" border="0" align="center" cellpadding="0"
           cellspacing="0">
        <tbody>
        <tr>
            <td height="200">&nbsp;</td>
        </tr>
        <tr>
            <td><table width="100%" border="0" cellspacing="0"
                       cellpadding="0">
                <tbody>
                <tr>
                    <td width="423" height="280" valign="top"><table
                            width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/img/ltop.jpg">
                            </td>
                        </tr>
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/img/llogo.jpg">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    </td>
                    <td width="40" align="center" valign="bottom"><img
                            src="${pageContext.request.contextPath}/img/line.jpg" width="23" height="232">
                    </td>
                    <td valign="top"><table width="100%" border="0"
                                            cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td height="90" align="center" valign="bottom"><img
                                    src="${pageContext.request.contextPath}/img/ltitle.jpg">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div></div>
                                <table width="100%" border="0" align="center"
                                       cellpadding="0" cellspacing="5">
                                    <tbody>
                                    <tr>
                                        <td colspan="3" align="center"> <font color="red"><s:property value="#request.msg"/> </font></td>
                                    </tr>
                                    <tr>
                                        <td width="80"  align="left">
                                            <strong>用户名：</strong>
                                        </td>
                                        <td width="50"><input type="text" id="username" name="userNo" class="input">
                                        </td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td align="left" width="80"><strong>密码：</strong>
                                        </td>
                                        <td ><input name="password" type="password" id="password" class="input">
                                        </td>
                                        <td></td>
                                    </tr>
                                    <tr >
                                        <td width="100" align="left"><strong>用户类型：</strong>
                                        </td>
                                        <td width="100">
                                            学生<input name="sign" type="radio" id="userTypeStu"  value="1">
                                            管理员<input name="sign" type="radio" id="userTypeAdmin"  value="0">
                                        </td>
                                        <td >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="40" colspan="2" align="center"><input type="submit" name="submit1" value="登录"/></td>
                                        <td height="40" colspan="2" align="center"><input type="reset" name="submit1" value="重置"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    </td>
                </tr>
                </tbody>
            </table>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
