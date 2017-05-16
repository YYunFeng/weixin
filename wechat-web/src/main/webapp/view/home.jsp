<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-首页</title>
    <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/home.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    $().ready(function () {
        jQuery('#home').addClass("selected");
    });
</script>
<div id="header" class="header">
    <jsp:include page="include/top.jsp"></jsp:include>
    <div id="main" class="container">
        <div class="containerBox boxIndex">
            <!--part 1-->
            <div style="">
                <div class="mainPanel">
                    <h2 class="h2">欢迎你，<s:property value="#session.weixinmanagersessionuser.userName"/></h2>

                    <div id="index-permission-tip" class="index-tip-wrapper"></div>
                    <div class="todoList">
                        <h3 class="">暂无待办事项</h3>
                    </div>
                </div>
                <div class="extendPanel">
                    <div class="extInfo">
                        <h3>系统公告</h3>

                        <p>使用时有任何疑问或建议，请添加官方公众号以咨询反馈：360info<br>联系邮箱：<a href="mailto:ypwang@platomix.net">ypwang@platomix.net</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="include/bottom.jsp"></jsp:include>
</div>
</body>
</html>
