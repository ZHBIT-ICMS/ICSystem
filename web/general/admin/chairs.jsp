<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/21
  Time: 10:29
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
                url : 'chair!datagrid.action',
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
                sortName : 'title',
                sortOrder : 'desc',
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 150,
                    sortable : true,
                    checkbox : true
                }, {
                    title : '讲座主题',
                    field : 'title',
                    width : 150,
                    sortable : true
                } ] ],
                columns : [ [ {
                    title : '讲座内容',
                    field : 'content',
                    sortable : true,
                    width : 150
                }, {
                    title : '到访时间',
                    field : 'visitTime',
                    sortable : true,
                    width : 150
                },{
                    title : '活动时间',
                    field : 'activityTime',
                    sortable : true,
                    width : 150
                },{
                    title : '所属国外院校',
                    field : 'foreignCollegeName',
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
                    title : '修改讲座信息',
                    href : '${pageContext.request.contextPath}/chair!chairsEdit.action?id=' + rows[0].id,
                    width : 800,
                    height : 400,
                    buttons : [ {
                        text : '修改',
                        handler : function() {
                            var f = p.find('form');
                            f.form({
                                url : '${pageContext.request.contextPath}/chair!edit.action',
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
                        var foreignCollegeId = f.find('input[name=foreignCollegeId]');
                        var collegeIdComboboxTree = foreignCollegeId.combobox({
                            url : '${pageContext.request.contextPath}/foreignCollege!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'foreignName',
                            multiple : false,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
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
                title : '增加讲座',
                href : '${pageContext.request.contextPath}/chair!chairsAdd.action',
                width : 800,
                height : 400,
                buttons : [ {
                    text : '增加',
                    handler : function() {
                        var f = p.find('form');
                        f.form({
                            url : '${pageContext.request.contextPath}/chair!add.action',
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
                    var foreignCollegeId = f.find('input[name=foreignCollegeId]');
                    var collegeIdComboboxTree = foreignCollegeId.combobox({
                        url : '${pageContext.request.contextPath}/foreignCollege!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'foreignName',
                        multiple : false,
                        editable : false,
                        panelHeight : 'auto'
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
                            url : '${pageContext.request.contextPath}/chair!delete.action',
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

        function _search() {
            datagrid.datagrid('load', dj.serializeObject($('#searchForm')));
        }
        function cleanSearch() {
            datagrid.datagrid('load', {});
            $('#searchForm input').val('');
        }
    </script>
</head>
<body class="easyui-layout">

<div data-options="region:'north',border:false,title:'过滤条件'" style="height: 55px;overflow: hidden;" align="left">
    <form id="searchForm">
        <table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
           <%-- <tr>
                <td>截止到访时间&nbsp&nbsp</td>
                <td><input name="visitTime"  class="easyui-datebox" id="visitTime" size="10"/></td>
                <td>截止活动时间&nbsp&nbsp</td>
                <td><input name="activityTime"  class="easyui-datebox" id="activityTime" size="10"/></td>
                <td>所属国外院校&nbsp&nbsp</td>
                <td><input class="easyui-combobox" id="foreignCollegeId" name="foreignCollegeId" size="10" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'foreignCollegeName',url:'${pageContext.request.contextPath}/foreignCollege!doNotNeedSession_combobox.action'"/></td>
                <td> <a href="javascript:void(0);" class="easyui-linkbutton" onclick="_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="cleanSearch();">取消</a></td>
            </tr>--%>
         <tr>
             <th>截止到访时间</th><td><input name="visitTime"  class="easyui-datebox" id="visitTime" style="width: 120px;"/></td>
             <th>截止活动时间</th><td><input name="activityTime"  class="easyui-datebox" id="activityTime"style="width: 120px;"/> </td>
             <th>所属国外院校</th>
             <td><input class="easyui-combobox"  name="foreignCollegeId" style="width: 100px;" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'foreignName',url:'${pageContext.request.contextPath}/foreignCollege!doNotNeedSession_combobox.action'"/>
                 <a href="javascript:void(0);" class="easyui-linkbutton" onclick="_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="cleanSearch();">取消</a>
             </td>
         </tr>
        </table>
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
