<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../inc.jsp"></jsp:include>
    <script type="text/javascript" charset="utf-8">
        var datagrid;
        $(function() {
            datagrid = $('#datagrid').datagrid({
                url : 'collegeInfo!datagrid.action',
                iconCls : 'icon-save',
                pagination : true,
                pagePosition : 'bottom',
                pageSize : 10,
                pageList : [ 10, 20, 30, 40 ],
                fit : true,
                fitColumns : true,
                nowrap : false,
                border : false,
                idField : 'id',
                sortName : 'collegeName',
                sortOrder : 'desc',
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 150,
                    sortable : true,
                    checkbox : true
                }, {
                    title : '学院名称',
                    field : 'collegeName',
                    width : 150,
                    sortable : true
                } ] ],
                columns : [ [ {
                    title : '学院描述',
                    field : 'descInfo',
                    sortable : true,
                    width : 150
                }
                ] ],
                toolbar : [ {
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
                    text : '修改',
                    iconCls : 'icon-edit',
                    handler : function() {
                        edit();
                    }
                }, '-', {
                    text : '取消选中',
                    iconCls : 'icon-undo',
                    handler : function() {
                        datagrid.datagrid('unselectAll');
                    }
                }, '-' ],
                onRowContextMenu : function(e, rowIndex, rowData) {
                    e.preventDefault();
                    $(this).datagrid('unselectAll');
                    $(this).datagrid('selectRow', rowIndex);
                    $('#menu').menu('show', {
                        left : e.pageX,
                        top : e.pageY
                    });
                }
            });
        });
        function edit() {
            var rows = datagrid.datagrid('getSelections');
            if (rows.length == 1) {
                var p = parent.dj.dialog({
                    title : '修改新闻',
                    href : '${pageContext.request.contextPath}/collegeInfo!collegeInfosEdit.action?id=' + rows[0].id,
                    width : 800,
                    height : 200,
                    buttons : [ {
                        text : '修改',
                        handler : function() {
                            var f = p.find('form');
                            f.form({
                                url : '${pageContext.request.contextPath}/collegeInfo!edit.action',
                                success : function(d) {
                                    var json = $.parseJSON(d);
                                    if (json.success) {
                                        datagrid.datagrid('reload');
                                        p.dialog('close');
                                    }
                                    parent.dj.messagerShow({
                                        msg : json.msg,
                                        title : '提示'
                                    });
                                }
                            });
                            f.submit();
                        }
                    } ],
                    onLoad : function() {
                        var f = p.find('form');
                        f.find('input[name=id]').val(rows[0].id);
                        f.find('input[name=collegeName]').val(rows[0].collegeName);
                        f.find('input[name=descInfo]').val(rows[0].descInfo);

                    }
                });
            } else if (rows.length > 1) {
                parent.dj.messagerAlert('提示', '同一时间只能编辑一条记录！', 'error');
            } else {
                parent.dj.messagerAlert('提示', '请选择要编辑的记录！', 'error');
            }
        }
        function append() {
            var p = parent.dj.dialog({
                title : '增加学院',
                href : '${pageContext.request.contextPath}/collegeInfo!collegeInfosAdd.action',
                width : 800,
                height : 200,
                buttons : [ {
                    text : '增加',
                    handler : function() {
                        var f = p.find('form');
                        f.form({
                            url : '${pageContext.request.contextPath}/collegeInfo!add.action',
                            success : function(d) {
                                var json = $.parseJSON(d);
                                if (json.success) {
                                    datagrid.datagrid('reload');
                                    p.dialog('close');
                                }
                                parent.dj.messagerShow({
                                    msg : json.msg,
                                    title : '提示'
                                });
                            }
                        });
                        f.submit();
                    }
                } ],
                onLoad : function() {
                    var f = p.find('form');
                }
            });
        }
        function remove() {
            var rows = datagrid.datagrid('getChecked');
            var ids = [];
            if (rows.length > 0) {
                parent.dj.messagerConfirm('请确认', '您要删除当前所选项目？', function(r) {
                    if (r) {
                        for ( var i = 0; i < rows.length; i++) {
                            ids.push(rows[i].id);
                        }
                        $.ajax({
                            url : '${pageContext.request.contextPath}/collegeInfo!delete.action',
                            data : {
                                ids : ids.join(',')
                            },
                            dataType : 'json',
                            success : function(d) {
                                datagrid.datagrid('load');
                                datagrid.datagrid('unselectAll');
                                parent.dj.messagerShow({
                                    title : '提示',
                                    msg : d.msg
                                });
                            }
                        });
                    }
                });
            } else {
                parent.dj.messagerAlert('提示', '请勾选要删除的记录！', 'error');
            }
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="datagrid"></table>
</div>

<div id="menu" class="easyui-menu" style="width:120px;display: none;">
    <div onclick="append();" data-options="iconCls:'icon-add'">增加</div>
    <div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
    <div onclick="edit();" data-options="iconCls:'icon-edit'">编辑</div>
</div>
</body>
</html>
