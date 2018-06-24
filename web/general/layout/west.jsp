<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    <!--
    body {
        visibility: hidden;
        font-family: helvetica, tahoma, verdana, sans-serif;
        padding: 10px;
        font-size: 13px;
        margin: 0;
    }

    *{margin:0;padding:0;border:0;}
    #nav {
        line-height: 27px;  list-style-type: none;text-align:left;
        left: -999em; width: 180px; position: absolute; margin-top: 5px;
    }
    #nav  li{
        float: left; width: 180px; margin-top: 5px;
    }
    #nav  a{
        display: block;width: 156px;text-align:left;padding-left:24px;
    }
    #nav  a:link  {
        text-decoration:none;
    }
    #nav  a:visited  {
        text-decoration:none;
    }
    #nav a:hover  {
        text-decoration:none;font-weight:normal;

    }
    #nav {
        left: auto;
    }
    #nav {
        left: auto;
    }
    #content {
        clear: left;
    }
    -->
</style>
<script type="text/javascript" charset="utf-8">

</script>
<div class="easyui-accordion" data-options="fit:true,border:false" id="eastContent" style=" font-family: 'Arial','Microsoft YaHei','黑体','宋体',sans-serif;">
    <c:forEach var="item" items="${sessionInfo.menus}">
        <c:if test="${item.pid==null}">
            <div title="${item.cname}" data-options="iconCls:'${item.ciconcls}'">
                <ul id="nav">
                    <c:forEach var="sitem" items="${sessionInfo.menus}">
                        <c:if test="${item.cid==sitem.pid}">
                            <li><a class="easyui-linkbutton" data-options="iconCls:'${sitem.ciconcls}'" plain="true" href="javascript:void(0);"  onclick="addTab('${sitem.cname}','${sitem.curl}','${sitem.ciconcls}')">${sitem.cname}</a></li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </c:forEach>
</div>
