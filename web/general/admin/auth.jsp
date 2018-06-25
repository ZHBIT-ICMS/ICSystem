<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../inc.jsp"></jsp:include>
    <script type="text/javascript" charset="utf-8">
        var treegrid;
        $(function() {
            treegrid = $('#treegrid').treegrid({
                url : '${pageContext.request.contextPath}/auth!treegrid.action',
                toolbar : [ {
                    text : '展开',
                    iconCls : 'icon-redo',
                    handler : function() {
                        var node = treegrid.treegrid('getSelected');
                        if (node) {
                            treegrid.treegrid('expandAll', node.cid);
                        } else {
                            treegrid.treegrid('expandAll');
                        }
                    }
                }, '-', {
                    text : '折叠',
                    iconCls : 'icon-undo',
                    handler : function() {
                        var node = treegrid.treegrid('getSelected');
                        if (node) {
                            treegrid.treegrid('collapseAll', node.cid);
                        } else {
                            treegrid.treegrid('collapseAll');
                        }
                    }
                }, '-', {
                    text : '刷新',
                    iconCls : 'icon-reload',
                    handler : function() {
                        treegrid.treegrid('reload');
                    }
                }, '-', {
                    text : '增加',
                    iconCls : 'icon-add',
                    handler : function() {
                        append();
                    }
                }, '-', {
                    text : '删除',
                    iconCls : 'icon-remove',
                    handler : function() {
                        remove();
                    }
                }, '-', {
                    text : '编辑',
                    iconCls : 'icon-edit',
                    handler : function() {
                        edit();
                    }
                }, '-', {
                    text : '取消选中',
                    iconCls : 'icon-undo',
                    handler : function() {
                        treegrid.treegrid('unselectAll');
                    }
                }, '-' ],
                title : '',
                iconCls : 'icon-save',
                fit : true,
                fitColumns : false,
                nowrap : false,
                animate : false,
                border : false,
                idField : 'cid',
                treeField : 'cname',
                frozenColumns : [ [ {
                    title : 'cid',
                    field : 'cid',
                    width : 150,
                    hidden : true
                }, {
                    field : 'cname',
                    title : '权限名称',
                    width : 180,
                    formatter : function(value) {
                        if (value) {
                            return dj.fs('<span title="{0}">{1}</span>', value, value);
                        }
                    }
                } ] ],
                columns : [ [ {
                    field : 'curl',
                    title : '权限地址',
                    width : 180,
                    formatter : function(value) {
                        if (value) {
                            return dj.fs('<span title="{0}">{1}</span>', value, value);
                        }
                    }
                }, {
                    field : 'cdesc',
                    title : '权限描述',
                    width : 180,
                    formatter : function(value) {
                        if (value) {
                            return dj.fs('<span title="{0}">{1}</span>', value, value);
                        }
                    }
                }, {
                    field : 'cseq',
                    title : '排序',
                    width : 100
                }, {
                    field : 'pid',
                    title : '上级权限ID',
                    width : 150,
                    hidden : true
                }, {
                    field : 'pname',
                    title : '上级权限',
                    width : 150
                } ] ],
                onContextMenu : function(e, row) {
                    e.preventDefault();
                    $(this).treegrid('unselectAll');
                    $(this).treegrid('select', row.cid);
                    $('#menu').menu('show', {
                        left : e.pageX,
                        top : e.pageY
                    });
                },
                onLoadSuccess : function(row, data) {
                    /*var t = $(this);
                    if (data) {
                        $(data).each(function(index, d) {
                            if (this.state == 'closed') {
                                t.treegrid('expandAll');
                            }
                        });
                    }*/
                },
                onExpand : function(row) {
                    treegrid.treegrid('unselectAll');
                },
                onCollapse : function(row) {
                    treegrid.treegrid('unselectAll');
                }
            });

        });

        function edit() {
            var node = treegrid.treegrid('getSelected');
            if (node) {
                var p = parent.dj.dialog({
                    title : '编辑权限',
                    href : '${pageContext.request.contextPath}/auth!authEdit.action',
                    width : 800,
                    height : 300,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/auth!edit.action',
                                success : function(d) {
                                    var json = $.parseJSON(d);
                                    if (json.success) {
                                        treegrid.treegrid('reload');
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
                        var f = p.find('form');
                        var pid = f.find('input[name=pid]');
                        var ptree = pid.combotree({
                            lines : true,
                            url : '${pageContext.request.contextPath}/auth!doNotNeedSession_treeRecursive.action',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        f.form('load', node);
                    }
                });
            } else {
                parent.dj.messagerAlert('提示', '请选中要编辑的记录！', 'error');
            }
        }
        function append() {
            var p = parent.dj.dialog({
                title : '添加权限',
                href : '${pageContext.request.contextPath}/auth!authAdd.action',
                width : 800,
                height : 300,
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        var f = p.find('form');
                        f.form('submit', {
                            url : '${pageContext.request.contextPath}/auth!add.action',
                            success : function(d) {
                                var json = $.parseJSON(d);
                                if (json.success) {
                                    treegrid.treegrid('reload');
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
                    var f = p.find('form');
                    var pid = f.find('input[name=pid]');//////////////////////////////////////////////////////////
                    var ptree = pid.combotree({
                        lines : true,
                        url : '${pageContext.request.contextPath}/auth!doNotNeedSession_tree.action'
                    });
                }
            });
        }
        function remove() {
            var node = treegrid.treegrid('getSelected');
            if (node) {
                parent.dj.messagerConfirm('询问', '您确定要删除【' + node.cname + '】？', function(b) {
                    if (b) {
                        $.ajax({
                            url : '${pageContext.request.contextPath}/auth!delete.action',
                            data : {
                                cid : node.cid
                            },
                            cache : false,
                            dataType : 'JSON',
                            success : function(r) {
                                if (r.success) {
                                    treegrid.treegrid('remove', r.obj);
                                }
                                parent.dj.messagerShow({
                                    msg : r.msg,
                                    title : '提示'
                                });
                            }
                        });
                    }
                });
            }
        }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true">
<div data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="treegrid"></table>
</div>

<div id="menu" class="easyui-menu" style="width:120px;display: none;">
    <div onclick="append();" data-options="iconCls:'icon-add'">增加</div>
    <div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
    <div onclick="edit();" data-options="iconCls:'icon-edit'">编辑</div>
</div>
</body>
</html>
