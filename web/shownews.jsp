<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8" />
    <meta name="generator" content="MetInfo 5.1.7" />
    <link href="favicon.ico" rel="shortcut icon" />
    <link rel="stylesheet" type="text/css" href="images/metinfo.css" />
    <script src="images/jQuery1.7.2.js" type="text/javascript"></script>
    <script src="images/ch.js" type="text/javascript"></script>

</head>
<body>
<header>
    <div class="inner">
        <div class="top-logo">

            <%--<a href="http://demo.metinfo.cn/" title="网站名称" id="web_logo">--%>
                <%--<img src="images/logo.png" alt="网站名称" title="网站名称" style="margin:20px 0px 0px 0px;" />--%>
            <%--</a>--%>

            <ul class="top-nav list-none">
                <li class="t"><span>|</span><a href='#' onclick='addFavorite("非IE浏览器不支持此功能，请手动设置！");' style='cursor:pointer;' title='collection'  >collection</a><span>|</span><a class="fontswitch" id="StranLink" href="javascript:StranBody()">chinese</a><span>|</span><a href='#' title='WAP'>WAP</a><span>|</span><a href='#' title='English'  >English</a><span>|</span><a href='index2.jsp' title='HOME' class='shopweba'>HOME</a></li>
                <%--<li class="b"><a href="admin/"><strong><span style="color:#ffff00;"><span style="font-size: 16px;">后台演示请点击这里进入</span></span></strong></a></li>--%>
            </ul>
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

        <h3 class='title myCorner' data-corner='top 5px'>QUICK ENTRY</h3>
        <div class="active" id="sidebar" data-csnow="2" data-class3="0" data-jsok="2">
            <dl class="list-none navnow"><dt id='part2_4'><a href='#'  title='NEWS' class="zm"><span></span></a></dt></dl>
            <dl class="list-none navnow"><dt id='part2_5'><a href='#'  title='NOTICE' class="zm"><span>NOTICE</span></a></dt></dl>
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
            <div class="position">POSITION：<a href="index2.jsp" title="网站首页">HOME</a> &gt; <a href="shownews.jsp">NEWS</a></div>
            <span>SHOW NEWS</span>
        </h3>
        <div class="clear"></div>

        <div class="active" id="shownews">
            <h1 class="title">${news.title}</h1>
            <div class="editor"><div><div>
               ${news.content}
            </div>

                <div id="metinfo_additional"></div></div><div class="clear"></div></div>
            <div class="met_hits"><div class='metjiathis'><div class="jiathis_style"><span class="jiathis_txt">share：</span><a class="jiathis_button_icons_1"></a><a class="jiathis_button_icons_2"></a><a class="jiathis_button_icons_3"></a><a class="jiathis_button_icons_4"></a><a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a></div><script type="text/javascript" src="http://v3.jiathis.com/code/jia.js?uid=1346378669840136" charset="utf-8"></script></div>点击次数：<span><script language='javascript' src='../include/hits.php?type=news&id=10'></script></span>&nbsp;&nbsp;更新时间：2012-07-17 16:53:59&nbsp;&nbsp;【<a href="javascript:window.print()">打印此页</a>】&nbsp;&nbsp;【<a href="javascript:self.close()">关闭</a>】</div>
            <div class="met_page">pre：none&nbsp;&nbsp;next：<a href='shownews.php?lang=cn&id=4' ></a></div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<footer data-module="2" data-classnow="5">
    <div class="inner">
        <div class="foot-nav"><a href=''  title='company'>company</a><span>|</span><a href='../message/'  title='comment'>Comment</a><span>|</span><a href=''  title='Rsponse'>Rsponse</a><span>|</span><a href='../link/'  title='Friendship link'>Friendship link</a><span>|</span><a href='../member/'  title='Member Center'>Member Center</a><span>|</span><a href='../search/'  title='Search'>Search</a><span>|</span><a href='../sitemap/'  title='Map'>Map</a><span>|</span><a href=''  title='Website management'>Website-management</a></div>
        <div class="foot-text">
            <p>Copyrigt zhbit <script src="http://s6.cnzz.com/stat.php?id=1670348&web_id=1670348" language="JavaScript"></script></p>
            <p>TEL：0663-3383330  QQ:992720192 Email:992720192@qq.com</p>


        </div>
    </div>
</footer>
<script src="images/fun.inc.js" type="text/javascript"></script>

</body>
</html>