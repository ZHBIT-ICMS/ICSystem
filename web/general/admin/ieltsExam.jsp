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
                url : 'ieltstExam!datagrid.action',
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
                sortOrder : 'desc',
//          private int id;//主键
//                private  String examId;//考试的编号
//            private Date examTime; //雅思考试时间
//            private String examPlace;//雅思考试地点
//            private int score;//分数
//            private IELTSTrain ieltsTrain;//培训机构
//            //一个雅思培训可以举办多个考试
//            private int ieltsTrainId;//雅思机构编号
//            private String trainName;//雅思机构名称
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 150,
                    sortable : true,
                    checkbox : true
                } ] ],
                columns : [ [ {
                    title : '考试的编号',
                    field : 'examId',
                    sortable : true,
                    width : 150
                },{
                    title : '考试类型',
                    field : 'sign',
                    sortable : true,
                    width : 80,formatter: function(value,row,index){
                        if (value=="0"){
                            return "正式考试";
                        } else {
                            return "模拟考试";
                        }
                    }
                },{
                    title : '雅思考试时间',
                    field : 'examTime',
                    sortable : true,
                    width : 150
                }, {
                    title : '雅思考试地点',
                    field : 'examPlace',
                    sortable : true,
                    width : 150
                },{
                    title : '考试时长',
                    field : 'duration',
                    sortable : true,
                    width : 150
                }, {
                    title : '所属机构名称',
                    field : 'trainName',
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
                    title : '修改雅思考试信息',
                    href : '${pageContext.request.contextPath}/ieltstExam!ieltstExamEdit.action?id=' + rows[0].id,
                    width : 800,
                    height : 300,
                    buttons : [ {
                        text : '修改',
                        handler : function() {
                            var f = p.find('form');
                            f.form({
                                url : '${pageContext.request.contextPath}/ieltstExam!edit.action',
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
                        var ieltsTrainId = f.find('input[name=ieltsTrainId]');
                        var ieltsTrainIdComboboxTree = ieltsTrainId.combobox({
                            url : '${pageContext.request.contextPath}/ieltstInfo!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'ieltsTrainId',
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
                title : '增加雅思考试',
                href : '${pageContext.request.contextPath}/ieltstExam!ieltstExamAdd.action',
                width : 800,
                height : 300,
                buttons : [ {
                    text : '增加',
                    handler : function() {
                        var f = p.find('form');
                        f.form({
                            url : '${pageContext.request.contextPath}/ieltstExam!add.action',
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
                    var ieltsTrainId = f.find('input[name=ieltsTrainId]');
                    var ieltsTrainIdComboboxTree = ieltsTrainId.combobox({
                        url : '${pageContext.request.contextPath}/ieltstInfo!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'ieltsTrainId',
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
                            url : '${pageContext.request.contextPath}/ieltstExam!delete.action',
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




























