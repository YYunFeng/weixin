<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 上午11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-组件管理</title>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/toolJS.js"></script>
    <script type="text/javascript" src="/js/component.js"></script>

    <script type="text/javascript" src="../js/artDialog/artDialog.min.js"></script>
    <script type="text/javascript" src="../js/survey.js"></script>
    <link href="../js/artDialog/skins/green.css" rel="stylesheet" media="screen" type="text/css" />
    <link href="../css/menu.css" rel="stylesheet" type="text/css">
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg_change.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    $().ready(function () {
        jQuery("#component").addClass("selected");
        surveyListContent();
    });
</script>
<body>
<div id="header" class="header">
    <jsp:include page="include/top.jsp"></jsp:include>
    <div id="main" class="container">
        <div class="containerBox">
            <div class="boxHeader">
                <h2>组件管理</h2>
            </div>
            <div class="sideBar">
                <div class="catalogList" id="surveyList">
                    <ul>
                        <li id="bigWheel"><a href="/component/bigWheelComponent.action">幸运大转盘</a></li>
                        <li><a href="/component/scratchCard.action">刮刮卡</a></li>
                        <li id="survey" class="selected"><a href="/component/surveyList.action">问卷调查</a></li>
                        <li id="prizeQuiz"><a href="/component/prizeQuizList.action">有奖竞答</a></li>
                    </ul>
                </div>
            </div>
            <!--ajax 嵌入层-->
            <div class="content" id="content">

            </div>
            <div class="clr"></div>
        </div>
    </div>
    <jsp:include page="include/bottom.jsp"></jsp:include>
</div>
</body>
</html>