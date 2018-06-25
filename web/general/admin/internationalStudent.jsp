<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 22:46
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
                url : 'intls!datagrid.action',
                pagination : true,
                pagePosition : 'bottom',
                pageSize : 10,
                pageList : [ 10, 20, 30, 40 ],
                fit : true,
                fitColumns : true,
                nowrap : true,
                border : false,
                idField : 'id',
                sortName : 'stuId',
                sortOrder : 'desc',
                checkOnSelect : true,
                selectOnCheck : true,
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 10,
                    sortable : true,
                    checkbox : true
                }, {
                    title : '学号',
                    field : 'stuId',
                    width : 100,
                    sortable : true
                }, {
                    title : '学生姓名',
                    field : 'name',
                    width : 80
                } ] ],
                columns : [ [ {
                    title : '状态',
                    field : 'status',
                    width : 10,
                    hidden : true
                }, {
                    title : '专业',
                    field : 'major',
                    width : 80
                }, {
                    title : '所属班级',
                    field : 'classInfoName',
                    width : 100
                }, {
                    title : '参加的夏令营',
                    field : 'summerCampNames',
                    width : 100
                }, {
                    title : '参加的雅思培训',
                    field : 'ieltsTrainNames',
                    sortable : true,
                    width : 100
                }, {
                    title : '参加的雅思考试',
                    field : 'ieltsExamNames',
                    sortable : true,
                    width : 100
                }, {
                    title : '所属出国生身份',
                    field : 'overSeasStudentName',
                    sortable : true,
                    width : 80
                },{
                    title : '所属交换生身份',
                    field : 'exchangeStudentName',
                    sortable : true,
                    width : 80
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
                    text : '批量参加雅思考试',
                    iconCls : 'icon-edit',
                    handler : function() {
                        editStuExam();
                    }
                }, '-' , {
                    text : '批量参加雅思培训',
                    iconCls : 'icon-edit',
                    handler : function() {
                        editStuTrain();
                    }
                }, '-' , {
                    text : '批量参加夏令营',
                    iconCls : 'icon-edit',
                    handler : function() {
                        editStuSummerCamp();
                    }
                }, '-'],
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

        function editStuExam() {
            var rows = datagrid.datagrid('getSelections');
            var ids = [];
            if (rows.length > 0) {
                for ( var i = 0; i < rows.length; i++) {
                    ids.push(rows[i].id);
                }
                var p = parent.dj.dialog({
                    title : '批量参加雅思考试',
                    href : '${pageContext.request.contextPath}/intls!intlsIeltsExamEdit.action',
                    width : 400,
                    height : 150,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/intls!IntlsAndIeltsExamEdit.action',
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
                        var ieltsExamIds = f.find('input[name=ieltsExamIds]');
                        var ieltsExamIdsCombobox = ieltsExamIds.combobox({
                            url : '${pageContext.request.contextPath}/ieltstExam!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'examId',
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

        function editStuTrain() {
            var rows = datagrid.datagrid('getSelections');
            var ids = [];
            if (rows.length > 0) {
                for ( var i = 0; i < rows.length; i++) {
                    ids.push(rows[i].id);
                }
                var p = parent.dj.dialog({
                    title : '批量参加雅思培训',
                    href : '${pageContext.request.contextPath}/intls!intlsIeltsTrainEdit.action',
                    width : 400,
                    height : 150,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/intls!IntlsAndIeltsTrainEdit.action',
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
                        var ieltsTrainIds = f.find('input[name=ieltsTrainIds]');
                        var ieltsTrainIdsCombobox = ieltsTrainIds.combobox({
                            url : '${pageContext.request.contextPath}/ieltstInfo!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'ieltsTrainId',
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

        function editStuSummerCamp() {
            var rows = datagrid.datagrid('getSelections');
            var ids = [];
            if (rows.length > 0) {
                for ( var i = 0; i < rows.length; i++) {
                    ids.push(rows[i].id);
                }
                var p = parent.dj.dialog({
                    title : '批量参加夏令营',
                    href : '${pageContext.request.contextPath}/intls!intlsSummerCampEdit.action',
                    width : 400,
                    height : 150,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/intls!IntlsAndSummerCampEdit.action',
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
                        var summerCampIds = f.find('input[name=summerCampIds]');
                        var summerCampIdsCombobox = summerCampIds.combobox({
                            url : '${pageContext.request.contextPath}/summerCamp!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'activityName',
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
                    title : '编辑国际班学生',
                    href : '${pageContext.request.contextPath}/intls!internationalStudentEdit.action',
                    width : 800,
                    height : 300,
                    buttons : [ {
                        text : '编辑',
                        handler : function() {
                            var f = p.find('form');
                            f.form('submit', {
                                url : '${pageContext.request.contextPath}/intls!edit.action',
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

                        var summerCampIds = f.find('input[name=summerCampIds]');
                        var summerCampIdsCombobox = summerCampIds.combobox({
                            url : '${pageContext.request.contextPath}/summerCamp!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'activityName',
                            multiple : true,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        var ieltsTrainIds = f.find('input[name=ieltsTrainIds]');
                        var ieltsTrainIdsCombobox = ieltsTrainIds.combobox({
                            url : '${pageContext.request.contextPath}/ieltstInfo!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'ieltsTrainId',
                            multiple : true,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        var ieltsExamIds = f.find('input[name=ieltsExamIds]');
                        var ieltsExamIdsCombobox = ieltsExamIds.combobox({
                            url : '${pageContext.request.contextPath}/ieltstExam!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'examId',
                            multiple : true,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        var classInfoId = f.find('input[name=classInfoId]');
                        var classInfoIdComboboxTree = classInfoId.combobox({
                            url : '${pageContext.request.contextPath}/classesInfo!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'descInfo',
                            multiple : false,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        var overSeasStudentId = f.find('input[name=overSeasStudentId]');
                        var overSeasStudentIdComboboxTree = overSeasStudentId.combobox({
                            url : '${pageContext.request.contextPath}/overseasStu!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'overSeasName',
                            multiple : false,
                            editable : false,
                            panelHeight : 'auto',
                            onLoadSuccess : function() {
                                parent.$.messager.progress('close');
                            }
                        });
                        var exchangeStudentId = f.find('input[name=exchangeStudentId]');
                        var exchangeStudentIdComboboxTree = exchangeStudentId.combobox({
                            url : '${pageContext.request.contextPath}/exchangeStu!doNotNeedSession_combobox.action',
                            valueField : 'id',
                            textField : 'exchangeName',
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
                title : '添加国际班学生',
                href : '${pageContext.request.contextPath}/intls!internationalStudentAdd.action',
                width : 800,
                height : 300,
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        var f = p.find('form');
                        f.form('submit', {
                            url : '${pageContext.request.contextPath}/intls!add.action',
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
                    var summerCampIds = f.find('input[name=summerCampIds]');
                    var summerCampIdsCombobox = summerCampIds.combobox({
                        url : '${pageContext.request.contextPath}/summerCamp!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'activityName',
                        multiple : true,
                        editable : false,
                        panelHeight : 'auto',
                        onLoadSuccess : function() {
                            parent.$.messager.progress('close');
                        }
                    });

                    var ieltsTrainIds = f.find('input[name=ieltsTrainIds]');
                    var ieltsTrainIdsCombobox = ieltsTrainIds.combobox({
                        url : '${pageContext.request.contextPath}/ieltstInfo!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'ieltsTrainId',
                        multiple : true,
                        editable : false,
                        panelHeight : 'auto',
                        onLoadSuccess : function() {
                            parent.$.messager.progress('close');
                        }
                    });

                    var ieltsExamIds = f.find('input[name=ieltsExamIds]');
                    var ieltsExamIdsCombobox = ieltsExamIds.combobox({
                        url : '${pageContext.request.contextPath}/ieltstExam!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'examId',
                        multiple : true,
                        editable : false,
                        panelHeight : 'auto',
                        onLoadSuccess : function() {
                            parent.$.messager.progress('close');
                        }
                    });
                    var classInfoId = f.find('input[name=classInfoId]');
                    var classInfoIdComboboxTree = classInfoId.combobox({
                        url : '${pageContext.request.contextPath}/classesInfo!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'descInfo',
                        multiple : false,
                        editable : false,
                        panelHeight : 'auto',
                        onLoadSuccess : function() {
                            parent.$.messager.progress('close');
                        }
                    });
                    var overSeasStudentId = f.find('input[name=overSeasStudentId]');
                    var overSeasStudentIdComboboxTree = overSeasStudentId.combobox({
                        url : '${pageContext.request.contextPath}/overseasStu!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'overSeasName',
                        multiple : false,
                        editable : false,
                        panelHeight : 'auto',
                        onLoadSuccess : function() {
                            parent.$.messager.progress('close');
                        }
                    });
                    var exchangeStudentId = f.find('input[name=exchangeStudentId]');
                    var exchangeStudentIdComboboxTree = exchangeStudentId.combobox({
                        url : '${pageContext.request.contextPath}/exchangeStu!doNotNeedSession_combobox.action',
                        valueField : 'id',
                        textField : 'exchangeName',
                        multiple : false,
                        editable : false,
                        panelHeight : 'auto',
                        onLoadSuccess : function() {
                            parent.$.messager.progress('close');
                        }
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
                            url : '${pageContext.request.contextPath}/intls!delete.action',
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
<body class="easyui-layout" data-options="fit:true">
<%--<div data-options="region:'north',border:false,title:'过滤条件'" style="height: 55px;overflow: hidden;" align="left">
    <form id="searchForm">
        <table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
            <tr>
                <th>用户名</th>
                <td><input name="cname" style="width:317px;" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" onclick="_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="cleanSearch();">取消</a></td>
            </tr>
        </table>
    </form>
</div>--%>
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
