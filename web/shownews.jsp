<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<!DOCTYPE HTML>
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
                <li class="t"><a href='#' onclick='SetHome(this,window.location,"非IE浏览器不支持此功能，请手动设置！");' style='cursor:pointer;' title='设为首页'  >设为首页</a><span>|</span><a href='#' onclick='addFavorite("非IE浏览器不支持此功能，请手动设置！");' style='cursor:pointer;' title='收藏本站'  >收藏本站</a><span>|</span><a class="fontswitch" id="StranLink" href="javascript:StranBody()">繁体中文</a><span>|</span><a href='#' title='WAP'>WAP</a><span>|</span><a href='#' title='English'  >English</a><span>|</span><a href='#' title='我的订单' class='shopweba'>我的订单</a></li>
                <li class="b"><a href="admin/"><strong><span style="color:#ffff00;"><span style="font-size: 16px;">后台演示请点击这里进入</span></span></strong></a></li>
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
            <dl class="list-none navnow"><dt id='part2_4'><a href='#'  title='公司动态' class="zm"><span>NEWS</span></a></dt></dl>
            <dl class="list-none navnow"><dt id='part2_5'><a href='#'  title='业界资讯' class="zm"><span>NOTICE</span></a></dt></dl>
            <div class="clear"></div></div>

        <h3 class='title line myCorner' data-corner='top 5px'>CONTRACT US</h3>
        <div class="active editor"><div>
        </div>
            <div>
                某某有限公司</div>
            <div>
                电 &nbsp;话：0663-3383330</div>
            <div>
                邮 &nbsp;编：515558</div>
            <div>
                Email：992720192@qq.com</div>
            <div>
                网 &nbsp;址：zhbit.com</div>
            <div class="clear"></div></div>
    </div>
    <div class="sb_box">
        <h3 class="title">
            <div class="position">POSITION：<a href="index.html" title="网站首页">HOME</a> &gt; <a href="news.html">NEWS</a></div>
            <span>SHOW NEWS</span>
        </h3>
        <div class="clear"></div>

        <div class="active" id="shownews">
            <h1 class="title">如何选择网站关键词?</h1>
            <div class="editor"><div><div>
                &nbsp; &nbsp; &nbsp;网站关键词是SEO优化的核心，关键词的选择将直接影响网站优化推广效果及网站的价值，选择关键词应该注意一下几点：</div>
                <div>
                    &nbsp;</div>
                <ol>
                    <li>
                        <span style="font-size:13px;"><strong>考虑用户搜索习惯</strong><span style="font-size:12px;">，</span></span>而并非企业名称或产品名称，尤其是对于一种新的产品，当市场还没有人知道的时候，自然不会有人去搜索这个关键词，因此选择关键词首先就应该去分析你的目标群体会在搜索引擎中搜索哪些关键词，而你应该选择那些与你的产品相关并能为你的销售带来帮助的关键词。<br />
                        &nbsp;</li>
                    <li>
                        中小企业切忌<span style="font-size:13px;"><strong>不要将自己的公司名称或品牌作为主要关键词</strong><span style="font-size:12px;">，</span></span>因为在你的目标群体中，很多人是没有听说过你的公司和品牌的，小企业做产品，对于中小企业来说，客户一般都是通过产品和服务来了解你的公司和品牌的，因此，网站关键词如果设置为公司名称，则不能达到良好的营销效果。<br />
                        &nbsp;</li>
                    <li>
                        <span style="font-size:13px;"><strong>关键词不宜过长</strong><span style="font-size:12px;">，</span></span>太长的关键词很少会有人搜索；点击量不宜太热，点击量太大搜索的人越多那么竞争也就会越激烈；同时关键词也不能太冷门，冷门关键词排到第一位也不会有多少人搜索访问，具体可以参考&ldquo;百度指数&rdquo;中的关键词访问量。<br />
                        &nbsp;</li>
                    <li>
                        碰到热门关键词时，<span style="font-size:13px;"><strong>最好在关键词前面或后面加上地域限制</strong></span>，譬如&ldquo;塑钢门窗&rdquo;，这个关键词竞争是非常激烈，但是&ldquo;长沙塑钢门窗&rdquo;就比较好做了，而且如果你做的是有地域限制的业务，那么其他地方搜索到你的网站也没有多大意义。<br />
                        &nbsp;</li>
                    <li>
                        <span style="font-size:13px;"><strong>标题关键词应该控制在1-3个之间</strong></span>，除非第四个以后的关键词是比较冷门的，否则在标题中添加多个关键词是没有任何意义的，反而会影响主关键词的排名。<br />
                        &nbsp;</li>
                </ol>
                <div id="metinfo_additional"></div></div><div class="clear"></div></div>
            <div class="met_hits"><div class='metjiathis'><div class="jiathis_style"><span class="jiathis_txt">分享到：</span><a class="jiathis_button_icons_1"></a><a class="jiathis_button_icons_2"></a><a class="jiathis_button_icons_3"></a><a class="jiathis_button_icons_4"></a><a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a></div><script type="text/javascript" src="http://v3.jiathis.com/code/jia.js?uid=1346378669840136" charset="utf-8"></script></div>点击次数：<span><script language='javascript' src='../include/hits.php?type=news&id=10'></script></span>&nbsp;&nbsp;更新时间：2012-07-17 16:53:59&nbsp;&nbsp;【<a href="javascript:window.print()">打印此页</a>】&nbsp;&nbsp;【<a href="javascript:self.close()">关闭</a>】</div>
            <div class="met_page">上一条：没有了&nbsp;&nbsp;下一条：<a href='shownews.php?lang=cn&id=4' >新手使用MetInfo建站步骤</a></div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<footer data-module="2" data-classnow="5">
    <div class="inner">
        <div class="foot-nav"><a href='../news/news.php?lang=cn&class2=4'  title='公司动态'>公司动态</a><span>|</span><a href='../message/'  title='在线留言'>在线留言</a><span>|</span><a href='../feedback/'  title='在线反馈'>在线反馈</a><span>|</span><a href='../link/'  title='友情链接'>友情链接</a><span>|</span><a href='../member/'  title='会员中心'>会员中心</a><span>|</span><a href='../search/'  title='站内搜索'>站内搜索</a><span>|</span><a href='../sitemap/'  title='网站地图'>网站地图</a><span>|</span><a href='http://gc04430.d215.51kweb.com/admin/'  title='网站管理'>网站管理</a></div>
        <div class="foot-text">
            <p>Copyrigt zhbit <script src="http://s6.cnzz.com/stat.php?id=1670348&web_id=1670348" language="JavaScript"></script></p>
            <p>TEL：0663-3383330  QQ:992720192 Email:992720192@qq.com</p>


        </div>
    </div>
</footer>
<script src="images/fun.inc.js" type="text/javascript"></script>

</body>
</html>