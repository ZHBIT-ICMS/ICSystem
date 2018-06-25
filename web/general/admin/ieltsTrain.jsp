<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/17
  Time: 17:09
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
                url : 'ieltstInfo!datagrid.action',
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
//                sortName : 'createTime',
//                sortOrder : 'desc',

                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 150,
                    sortable : true,
                    checkbox : true
                } ] ],
                columns : [ [ {
                    title : '雅思机构编号',
                    field : 'ieltsTrainId',
                    sortable : true,
                    width : 150
                }, {
                    title : '雅思机构名称',
                    field : 'trainName',
                    sortable : true,
                    width : 150
                }, {
                    title : '培训的学期',
                    field : 'trainTerm',
                    sortable : true,
                    width : 150
                },{
                    title : '培训开始时期',
                    field : 'trainTime',
                    sortable : true,
                    width : 150
                },
                    {
                    title : '雅思课程学时',
                    field : 'trainClassHours',
                    width : 150,
                        sortable : true

                } ] ],
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
                    title : '修改机构信息',
                    href : '${pageContext.request.contextPath}/ieltstInfo!ieltstEdit.action?id=' + rows[0].id,
                    width : 800,
                    height : 300,
                    buttons : [ {
                        text : '修改',
                        handler : function() {
                            var f = p.find('form');
                            f.form({
                                url : '${pageContext.request.contextPath}/ieltstInfo!edit.action',
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
                        f.form("reset");
                        f.form("load",rows[0]);
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
                title : '发布机构信息',
                href : '${pageContext.request.contextPath}/ieltstInfo!ieltstAdd.action',
                width : 800,
                height : 300,
                buttons : [ {
                    text : '发布',
                    handler : function() {
                        var f = p.find('form');
                        f.form({
                            url : '${pageContext.request.contextPath}/ieltstInfo!add.action',
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
                    var editor = f.find('textarea[name=content]').xheditor({
                        tools : 'full',
                        html5Upload : true,
                        upMultiple : 4,
                        upLinkUrl : '${pageContext.request.contextPath}/ieltstInfo!upload.action',
                        upLinkExt : 'zip,rar,txt,doc,docx,xls,xlsx',
                        upImgUrl : '${pageContext.request.contextPath}/ieltstInfo!upload.action',
                        upImgExt : 'jpg,jpeg,gif,png'
                    });
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
                            url : '${pageContext.request.contextPath}/ieltstInfo!delete.action',
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
        function showCdesc(rowIndex) {
            var rows = datagrid.datagrid('getRows');
            var row = rows[rowIndex];

            var p = parent.dj.dialog({
                title : '新闻标题[' + row.title + ']',
                modal : true,
                maximizable : true,
                width : 800,
                height : 600,
                content : '<iframe src="${pageContext.request.contextPath}/ieltstInfo!showContent.action?id=' + row.id + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>'
            });

            datagrid.datagrid('unselectAll');
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
