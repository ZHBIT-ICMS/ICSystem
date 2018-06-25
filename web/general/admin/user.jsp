<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/12
  Time: 9:48
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
                url : 'user!datagrid.action',
                pagination : true,
                pagePosition : 'bottom',
                pageSize : 10,
                pageList : [ 10, 20, 30, 40 ],
                fit : true,
                fitColumns : true,
                nowrap : true,
                border : false,
                idField : 'id',
                sortName : 'locked',
                sortOrder : 'asc',
                checkOnSelect : true,
                selectOnCheck : true,
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 10,
                    sortable : true,
                    checkbox : true
                }, {
                    title : '用户名',
                    field : 'userNo',
                    width : 100,
                    sortable : true
                }, {
                    title : '真实姓名',
                    field : 'userName',
                    width : 100
                } ] ],
                columns : [ [ {
                    title : '所属角色ID',
                    field : 'roleIds',
                    width : 10,
                    hidden : true
                }, {
                    title : '所属角色',
                    field : 'roleNames',
                    width : 100
                }, {
                    title : '所属学院',
                    field : 'collegeName',
                    width : 120
                }, {
                    title : '邮箱地址',
                    field : 'email',
                    width : 80
                }, {
                    title : '创建时间',
                    field : 'createDate',
                    sortable : true,
                    width : 120
                }, {
                    title : '最后修改时间',
                    field : 'updateDate',
                    sortable : true,
                    width : 120
                }, {
                    title : '状态',
                    field : 'locked',
                    sortable : true,
                    width : 40,formatter: function(value,row,index){
                        if (value=="0"){
                            return "启用";
                        } else {
                            return "停用";
                        }
                    }
                },{
                    title : '身份',
                    field : 'sign',
                    sortable : true,
                    width : 40,formatter: function(value,row,index){
                        if (value==0){
                            return "管理员";
                        } else {
                            return "学生";
                        }
                    }
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
                        datagrid.datagrid('clearSelections');
                        datagrid.datagrid('unselectAll');
                    }
                }, '-', {
                    text : '批量修改用户角色',
                    iconCls : 'icon-edit',
                    handler : function() {
                        editRole();
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

        function editRole() {
            var rows = datagrid.datagrid('getSelections');
            var ids = [];
            if (rows.length > 0) {
                for ( var i = 0; i < rows.length; i++) {
                    ids.push(rows[i].id);
                }
                var p = parent.dj.dialog({
                    title : '批量编辑用户角色',
                    href : '${pageContext.request.contextPath}/user!userRoleEdit.action',
                    width : 250,
                    height : 130,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/user!roleEdit.action',
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
                        }
                    } ],
                    onLoad : function() {
                        var f = p.find('form');
                        var idsInput = f.find('input[name=ids]');
                        var roleIds = f.find('input[name=roleIds]');
                        var roleIdsCombobox = roleIds.combobox({
                            url : '${pageContext.request.contextPath}/role!doNotNeedSession_combobox.action',
                            valueField : 'cid',
                            textField : 'cname',
                            multiple : true,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                f.form('load', {
                                    ids : ids.join(',')
                                });
                            }
                        });
                    }
                });
            } else {
                parent.dj.messagerAlert('提示', '请选择要编辑的记录！', 'error');
            }
        }

        function edit() {
            var rows = datagrid.datagrid('getSelections');
            if (rows.length == 1) {
                var p = parent.dj.dialog({
                    title : '编辑用户',
                    href : '${pageContext.request.contextPath}/user!userEdit.action',
                    width : 800,
                    height : 400,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/user!edit.action',
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
                        }
                    } ],
                    onLoad : function() {
                        var f = p.find('form');
                        var roleIds = f.find('input[name=roleIds]');
                        var roleIdsCombobox = roleIds.combobox({
                            url : '${pageContext.request.contextPath}/role!doNotNeedSession_combobox.action',
                            valueField : 'cid',
                            textField : 'cname',
                            multiple : true,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        var collegeId = f.find('input[name=collegeId]');
                        var collegeIdComboboxTree = collegeId.combobox({
                            url : '${pageContext.request.contextPath}/collegeInfo!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'collegeName',
                            multiple : false,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        f.form('load', {
                            id : rows[0].id,
                            userNo : rows[0].userNo,
                            userName : rows[0].userName,
                            locked : rows[0].locked,
                            sign:rows[0].sign,
                            email : rows[0].email,
                            collegeId : rows[0].collegeId,
                            roleIds : dj.getList(rows[0].roleIds),
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
                title : '添加用户',
                href : '${pageContext.request.contextPath}/user!userAdd.action',
                width : 800,
                height : 400,
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        var f = p.find('form');
                        f.form('submit', {
                            url : '${pageContext.request.contextPath}/user!add.action',
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
                    }
                } ],
                onLoad : function() {
                    var f = p.find('form');
                    var roleIds = f.find('input[name=roleIds]');
                    var roleIdsCombobox = roleIds.combobox({
                        url : '${pageContext.request.contextPath}/role!doNotNeedSession_combobox.action',
                        valueField : 'cid',
                        textField : 'cname',
                        multiple : true,
                        editable : false,
                        panelHeight : 'auto'
                    });
                    var collegeId = f.find('input[name=collegeId]');
                    var collegeIdComboboxTree = collegeId.combobox({
                        url : '${pageContext.request.contextPath}/collegeInfo!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'collegeName',
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
                            url : '${pageContext.request.contextPath}/user!delete.action',
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
        function searchUser() {
            datagrid.datagrid('load',$('#userSearchForm').serializeJson());
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

        function cleanSearch() {
            datagrid.datagrid('load', {});
            $('#userSearchForm input').val('');
        }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true">
<div data-options="region:'north',border:false,title:'查询'" style="height: 55px;overflow: hidden;" align="left">
    <form id="userSearchForm">
        <span style="margin-left:2px;">所属学院:
            <input class="easyui-combobox" style="width: 100px"  name="collegeId" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'collegeName',url:'${pageContext.request.contextPath}/collegeInfo!doNotNeedSession_combobox.action'"/>
            </span>
        <span style="margin-left:2px;">状态:
            <select id="sLocked" class="easyui-combobox" name="locked" size="3" data-options="editable:false,panelHeight:'auto'" style="width:100px;">
                <option value="0">&nbsp;</option>
                <option value="1">启动</option>
                <option value="2">禁用</option>
            </select></span>
        <span style="margin-left:2px;">身份:
            <select id="sSign" class="easyui-combobox" name="sign" size="3" data-options="editable:false,panelHeight:'auto'" style="width:100px;">
                <option value="0">&nbsp;</option>
                <option value="1">管理员</option>
                <option value="2">学生</option>
            </select></span>
        <a onclick="searchUser();" class="easyui-linkbutton" style="width:100px;" data-options="iconCls:'icon-search'">查询</a>
        <a onclick="cleanSearch();" class="easyui-linkbutton" style="width:100px;" data-options="iconCls:'icon-cancel'">取消</a>
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
