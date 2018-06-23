<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/14
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
    function logout(b) {
        $('#sessionInfoDiv').html('');
        $.post('user!doNotNeedSession_logout.action', function() {
            if (b) {
                if (dj.isLessThanIe8()) {
                    loginDialog.dialog('open');
                } else {
                    location.replace('${pageContext.request.contextPath}/');
                }
            } else {
                loginDialog.dialog('open');
            }
        });
    }
    function showUserInfo() {
        var p = parent.dj.dialog({
            title : '用户信息',
            href : 'user!doNotNeedAuth_userInfo.action',
            width : 490,
            height : 285,
            buttons : [ {
                text : '修改密码',
                handler : function() {
                    var f = p.find('form');
                    f.form('submit', {
                        url : 'user!doNotNeedAuth_editUserInfo.action',
                        success : function(d) {
                            var json = $.parseJSON(d);
                            if (json.success) {
                                p.dialog('close');
                            }
                            parent.dj.messagerShow({
                                msg : json.msg,
                                title : '提示'
                            });
                        }
                    });
                }
            } ],
            onLoad : function() {
                var authIds = p.find('ul');
                var authIdsTree = authIds.tree({
                    url : 'auth!doNotNeedSession_treeRecursive.action',
                    lines : true,
                    checkbox : true,
                    onLoadSuccess : function(node, data) {
                        var f = p.find('form');
                        var ids = f.find('input[name=authIds]').val();
                        var idList = dj.getList(ids);
                        if (idList.length > 0) {
                            for ( var i = 0; i < idList.length; i++) {
                                var n = authIdsTree.tree('find', idList[i]);
                                authIdsTree.tree('check', n.target);
                            }
                        }
                        authIdsTree.unbind();
                    }
                });
            }
        });
    }
</script>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <strong>Amaze</strong> <small>国际合作交流管理系统</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> ${sessionInfo.loginName} <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="javascript:void(0);" onclick="showUserInfo();"><span class="am-icon-user"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="javascript:void(0);"  onclick="$.messager.confirm('注销','您确定要退出么?',function(r){logout(true);});"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

