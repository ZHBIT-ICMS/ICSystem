<%--
  Created by IntelliJ IDEA.
  User: 孔文轩
  Date: 2018/6/21
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../../inc.jsp"></jsp:include>
    <script type="text/javascript" charset="utf-8">
        var datagrid;
        $(function() {
            datagrid = $('#datagrid').datagrid({
                url : 'pubNotice!datagrid.action',
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
                sortName : 'createTime',
                sortOrder : 'desc',
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 150,
                    sortable : true,
                    checkbox : true
                }, {
                    title : '通知公告标题',
                    align: 'center',
                    field : 'title',
                    width : 150,
                    sortable : true
                } ] ],
                columns : [ [ {
                    title : '发布时间',
                    field : 'createTime',
                    align: 'center',
                    sortable : true,
                    width : 150
                }, {
                    title : '发布人',
                    field : 'people',
                    align: 'center',
                    sortable : true,
                    width : 150
                },
                    {
                        title : '公告内容',
                        field : 'content',
                        align: 'center',
                        width : 150,
                        formatter : function(value, rowData, rowIndex) {
                            return '<span class="icon-search" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span><a href="javascript:void(0);" onclick="showCdesc(' + rowIndex + ');">查看详细</a>';
                        }
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
                    title : '修改通知公告信息',
                    href : '${pageContext.request.contextPath}/pubNotice!noticeEdit.action?id=' + rows[0].id,
                    width : 800,
                    height : 550,
                    buttons : [ {
                        text : '修改',
                        handler : function() {
                            var f = p.find('form');
                            f.form({
                                url : '${pageContext.request.contextPath}/pubNotice!edit.action',
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
                        f.find('input[name=title]').val(rows[0].title);
                        f.find('input[name=people]').val(rows[0].people);
                        var editor = f.find('textarea[name=content]').xheditor({
                            tools : 'full',
                            html5Upload : true,
                            upMultiple : 4,
                            upLinkUrl : '${pageContext.request.contextPath}/pubNotice!upload.action',
                            upLinkExt : 'zip,rar,txt,doc,docx,xls,xlsx',
                            upImgUrl : '${pageContext.request.contextPath}/pubNotice!upload.action',
                            upImgExt : 'jpg,jpeg,gif,png'
                        });
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
                title : '发添加通知公告',
                href : '${pageContext.request.contextPath}/pubNotice!noticeAdd.action',
                width : 800,
                height : 550,
                buttons : [ {
                    text : '发布',
                    handler : function() {
                        var f = p.find('form');
                        f.form({
                            url : '${pageContext.request.contextPath}/pubNotice!add.action',
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
                        upLinkUrl : '${pageContext.request.contextPath}/pubNotice!upload.action',
                        upLinkExt : 'zip,rar,txt,doc,docx,xls,xlsx',
                        upImgUrl : '${pageContext.request.contextPath}/pubNotice!upload.action',
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
                            url : '${pageContext.request.contextPath}/pubNotice!delete.action',
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
                title : '通知公告标题[' + row.title + ']',
                modal : true,
                maximizable : true,
                width : 800,
                height : 600,
                content : '<iframe src="${pageContext.request.contextPath}/pubNotice!showContent.action?id=' + row.id + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>'
            });

            datagrid.datagrid('unselectAll');
        }

        //搜索实现
        function searchNotic() {
            datagrid.datagrid('load',$('#noticeSearchForm').serializeJson());
        }

        /**
         *
         * @requires jQuery
         *
         * 将form表单元素的值序列化成对象
         *
         * @returns object
         */
        (function($){
            $.fn.serializeJson=function(){
                var serializeObj={};
                var array=this.serializeArray();
                var str=this.serialize();
                $(array).each(function(){
                    if(serializeObj[this.name]){
                        if($.isArray(serializeObj[this.name])){
                            serializeObj[this.name].push(this.value);
                        }else{
                            serializeObj[this.name]=[serializeObj[this.name],this.value];
                        }
                    }else{
                        serializeObj[this.name]=this.value;
                    }
                });
                return serializeObj;
            };
        })(jQuery);
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false,title:'查询'" style="height: 55px;overflow: hidden;" align="left">
    <form id="noticeSearchForm" style="display:inline;">
        <span style="margin-left:2px;">公告标题: <input class="easyui-textbox" style="width:100px;" name="title"/></span>
        <a onclick="searchNotic();" class="easyui-linkbutton" style="width:100px;" data-options="iconCls:'icon-search'">查询</a>
    </form>
</div>
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

