<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/24
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <link href="favicon.ico" rel="shortcut icon" />
    <link rel="stylesheet" type="text/css" href="images/metinfo.css" />
    <script src="images/jQuery1.7.2.js" type="text/javascript"></script>
    <script src="images/ch.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/more.css">
</head>
<body>
<header>
    <div class="inner">
        <div class="top-logo">

            <a href="http://demo.metinfo.cn/" title="网站名称" id="web_logo">



                <%--<img src="${pageContext.request.contextPath}/img/logo.jpg" width="180px" class="header_logo">--%>
                <%--<img src="${pageContext.request.contextPath}/img/logo.jpg"alt="zhbit" title="zhbit" style="margin:20px 0px 0px 0px;" />--%>
            </a>


        </div>
        <nav>
            <ul class="list-none">
                <li id="nav_10001" style='width:121px;' ><a href='index.html' x class='nav'><span>HOME</span></a></li>
                <li class="line"></li>
                <li id='nav_1' style='width:121px;' ><a href='about.html' 0  class='hover-none nav'><span>ABOUT ZHBIT</span></a></li>
                <li class="line"></li>
                <li id='nav_2' style='width:121px;' class='navdown'><a href='news.html'  class='hover-none nav'><span>Faculty</span></a></li>
                <li class="line"></li>
                <li id='nav_3' style='width:121px;' ><a href='#'   class='hover-none nav'><span>NEWS</span></a></li>
                <li class="line"></li>
                <li id='nav_32' style='width:121px;' ><a href='#'   class='hover-none nav'><span>NOTICE</span></a></li>
                <li class="line"></li>
                <li id='nav_33' style='width:121px;' ><a href='#'   class='hover-none nav'><span>MORE</span></a></li>
                <li class="line"></li>
                <li id='nav_36' style='width:120px;' ><a href='#'   class='hover-none nav'><span>MORE</span></a></li>
                <li class="line"></li>
                <li id='nav_22' style='width:120px;' ><a href='#'   class='hover-none nav'><span>CONTRACT US</span></a></li>
            </ul></nav>
    </div>
</header>

<div class="inner met_flash"><div class="flash">


    <%--<a href='#' target='_blank' title='企业网站管理系统'><img src='images/1342430358.jpg' width='980' alt='企业网站管理系统' height='90'></a>--%>
</div></div>


<div class="sidebar inner">
    <div class="sb_nav">

        <h3 class='title myCorner' data-corner='top 5px'>QUICK EBTRY</h3>
        <div class="active" id="sidebar" data-csnow="2" data-class3="0" data-jsok="2">
            <dl class="list-none navnow"><dt id='part2_4'><a href='#'  title='公司动态' class="zm"><span>NEWS</span></a></dt></dl>
            <dl class="list-none navnow"><dt id='part2_5'><a href='#'  title='业界资讯' class="zm"><span>NOTICE</span></a></dt></dl>
            <div class="clear"></div></div>

        <h3 class='title line myCorner' data-corner='top 5px'>CONTRACT US</h3>
        <div class="active editor"><div>
          </div>
            <div>
                MOMO Company</div>
            <div>
                TEL：0663-3383330</div>
            <div>
                Code：515558</div>
            <div>
                Email：992720192@qq.com</div>
            <div>
                URL：zhbit.com</div>
            <div class="clear"></div></div>
    </div>
    <div class="sb_box">
        <h3 class="title">
            <div class="position">POSITION：<a href="index2.jsp" title="网站首页">HOME</a> &gt; <a href="notice.jsp">NOTICE</a></div>
        </h3>
        <div class="clear"></div>
        <div class="active" id="newslist">
            <ul class='list-none metlist'>
                <c:forEach items="${noticeList}" var="n">
                    <li class='list '>
                        <span>[${n.createTime}]</span>
                        <a href="notice_showNotice.action?noticeId=${n.id}" target="_blank">${n.title }</a><img class='listhot' src='images/hot.gif' alt='图片关键词' />
                    </li>
                </c:forEach>
            </ul>

            <%--分页--%>
            <div class="pager">
                <ul class="clearfix">
                    ${pageCode}
                </ul>
            </div>
                <%--<li class='list top'><span>[2012-07-17]</span><a href='shownews.html' title='如何选择网站关键词?' target='_self'>如何选择网站关键词?</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='新手使用MetInfo建站步骤' target='_self'>新手使用MetInfo建站步骤</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='企业网站应该多长时间备份一次？' target='_self'>企业网站应该多长时间备份一次？</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='如何充分发挥MetInfo的SEO功能' target='_self'>如何充分发挥MetInfo的SEO功能</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='什么是伪静态？伪静态有何作用?' target='_self'>什么是伪静态？伪静态有何作用?</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='企业用网站进行网络宣传的优势' target='_self'>企业用网站进行网络宣传的优势</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='MetInfo企业建站系统有何优势？' target='_self'>MetInfo企业建站系统有何优势？</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='商业版和免费版在系统功能上有区别吗？' target='_self'>商业版和免费版在系统功能上有区别吗？</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='为什么企业要建多国语言网站？' target='_self'>为什么企业要建多国语言网站？</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li>--%>
                <%--<li class='list '><span>[2012-07-16]</span><a href='shownews.html' title='如何获取MetInfo网站管理系统商业授权？' target='_self'>如何获取MetInfo网站管理系统商业授权？</a><img class='listhot' src='images/hot.gif' alt='图片关键词' /></li></ul>--%>


            <%--<div id="flip"><style>.digg4  { padding:3px; margin:3px; text-align:center; font-family:Tahoma, Arial, Helvetica, Sans-serif;  font-size: 12px;}.digg4  a,.digg4 span.miy{ border:1px solid #ddd; padding:2px 5px 2px 5px; margin:2px; color:#aaa; text-decoration:none;}.digg4  a:hover { border:1px solid #a0a0a0; }.digg4  a:hover { border:1px solid #a0a0a0; }--%>
            <%--.digg4  span.current {border:1px solid #e0e0e0; padding:2px 5px 2px 5px; margin:2px; color:#aaa; background-color:#f0f0f0; text-decoration:none;}.digg4  span.disabled { border:1px solid #f3f3f3; padding:2px 5px 2px 5px; margin:2px; color:#ccc;}.digg4 .disabledfy { font-family: Tahoma, Verdana;} </style><div class='digg4 metpager_8'><span class='disabled disabledfy'><b>«</b></span><span class='disabled disabledfy'>‹</span><span class='current'>1</span><span class='disabled disabledfy'>›</span><span class='disabled disabledfy'><b>»</b></span></div></div>--%>
        </div>
    </div>
    <div class="clear"></div>
</div>

<footer data-module="2" data-classnow="2">
    <div class="inner">

        <div class="foot-text">
            <p>Copyrigt zhbit <script src="http://s6.cnzz.com/stat.php?id=1670348&web_id=1670348" language="JavaScript"></script></p>
            <p>TEL：0663-3383330  QQ:992720192 Email:992720192@qq.com</p>


        </div>
    </div>
</footer>
<script src="images/fun.inc.js" type="text/javascript"></script>

</body>
</html>