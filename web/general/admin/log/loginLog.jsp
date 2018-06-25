<%--
  Created by IntelliJ IDEA.
  User: 孔文轩
  Date: 2018/6/22
  Time: 7:59
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
                url : 'loginLog!datagrid.action',
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
                sortName : 'loginTime',
                sortOrder : 'desc',
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 100,
                    sortable : true,
                    checkbox : true
                }, {
                    title : '登录账号',
                    field : 'userNo',
                    width : 130,
                    align: 'center',
                    sortable : true
                } ] ],
                columns : [ [ {
                    title : '登录ip',
                    field : 'loginIp',
                    sortable : true,
                    align: 'center',
                    width : 80
                }, {
                    title : '操作系统',
                    field : 'userAgent',
                    align: 'center',
                    sortable : true,
                    width : 100
                },{
                    title : '登录时间',
                    field : 'loginTime',
                    align: 'center',
                    sortable : true,
                    width : 100
                } ] ],
                toolbar : [ {
                    text : '删除',
                    iconCls : 'icon-remove',
                    handler : function() {
                        remove();
                    }
                }, '-', {
                    text : '取消选中',
                    iconCls : 'icon-undo',
                    handler : function() {
                        datagrid.datagrid('unselectAll');
                    }
                }, '-', {
                    text : '导出Excel',
                    iconCls : 'icon-print',
                    handler : function() {
                        exportExcel();
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
                            url : '${pageContext.request.contextPath}/loginLog!delete.action',
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

        function exportExcel() {
            window.location.href="loginLog!exportExcel.action";
        }
        //搜索实现
        function searchLoginlog() {
            datagrid.datagrid('load',$('#loginLogSearchForm').serializeJson());
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
    <form id="loginLogSearchForm" style="display:inline;">
        <span style="margin-left:2px;">登录账号: <input class="easyui-textbox" style="width:100px;" name="userNo"/></span>
        <a onclick="searchLoginlog();" class="easyui-linkbutton" style="width:100px;" data-options="iconCls:'icon-search'">查询</a>
    </form>
</div>
<div data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="datagrid"></table>
</div>

<div id="menu" class="easyui-menu" style="width:120px;display: none;">
    <div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
</div>
</body>
</html>
