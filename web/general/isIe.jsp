<%--
  Created by IntelliJ IDEA.
  User: zhangrun
  Date: 2018/6/11
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" charset="utf-8">
    $(function() {
        if (dj.isLessThanIe8()) {
            $.messager.show({
                title : '警告',
                msg : '您使用的浏览器版本太低！<br/>建议您使用IE8及以上或谷歌浏览器来获得更快的页面响应效果！',
                timeout : 1000 * 60
            });
        }
    });
</script>
