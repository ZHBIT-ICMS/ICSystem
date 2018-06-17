<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 15:53
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
<div id="sessionInfoDiv" style="overflow: hidden; height: 30px;
        background: #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="padding-left:10px; font-size: 20px; text-align: inherit;" ><strong style="color: white;">国际合作交流管理系统</strong></span>
    <span style="position: absolute; right: 0px; bottom: 0px; "><c:if test="${sessionInfo.userId != null}"><strong style="color: white;">[${sessionInfo.loginName}]，欢迎您！您使用[${sessionInfo.ip}]IP登录！</strong></c:if>
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-theme'"><strong style="color: white;">更换皮肤</strong></a>
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="iconCls:'icon-blank'" onclick="showUserInfo();"><strong style="color: white;">个人信息</strong></a>
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="iconCls:'icon-quit'" onclick="$.messager.confirm('注销','您确定要退出么?',function(r){logout(true);});"><strong style="color: white;">注销</strong></a></span>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
    <div onclick="dj.changeTheme('default');">默认</div>
    <div onclick="dj.changeTheme('gray');">灰色</div>
    <div onclick="dj.changeTheme('bootstrap');">bootstrap</div>
    <div onclick="dj.changeTheme('material');">material</div>
    <div onclick="dj.changeTheme('metro');">metro</div>
</div>
