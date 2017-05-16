<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 下午2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-自动回复</title>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/autorespond.js"></script>
    <script type="text/javascript" src="/js/toolJS.js"></script>
    <link href="../css/menu.css" rel="stylesheet" type="text/css">
    <link href="../css/respond.css" rel="stylesheet" type="text/css">
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg_change.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    $().ready(function () {
        jQuery('#autorespond').addClass("selected");
        jQuery('#attention').addClass("selected");
        attention();
    });
</script>
<body>
<div id="header" class="header">
    <jsp:include page="include/top.jsp"></jsp:include>
    <div id="main" class="container">
        <div class="containerBox min-height">
            <div class="boxHeader">
                <h2>自动回复</h2>
            </div>
            <div class="sideBar">
                <div class="catalogList">
                    <div class="respond_type">常用回复</div>
                    <ul id="normal_list">
                        <li id="attention"><a href="javascript:attention();">被关注时</a></li>
                        <li id="respond"><a href="javascript:respond();">自动回复</a></li>
                        <%--   <li id="autorespondHeadAndFoot"><a href="javascript:autorespondHeadAndFoot();">页眉页脚</a></li>
                           <li id="autoRespondHelp"><a href="javascript:autoRespondHelp();">帮助</a></li>--%>
                        <b>&nbsp;</b>
                    </ul>
                    <div class="respond_type">关键词回复</div>
                    <input class="add_rule" type="button" id="add_rule" value="+添加规则" onclick="go_up()"/>
                    <ul id="guize_list">

                    </ul>
                </div>
            </div>
            <!--ajax 嵌套层-->
            <div class="content" id="container">

            </div>
            <div class="clr"></div>
        </div>
    </div>
</div>
<jsp:include page="include/bottom.jsp"></jsp:include>
</body>
</html>
