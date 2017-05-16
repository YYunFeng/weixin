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
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-统计</title>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/toolJS.js"></script>
    <script type="text/javascript" src="/js/statisticsJS.js"></script>
    <script type="text/javascript" src="/js/statistics.js"></script>
    <link href="../css/menu.css" rel="stylesheet" type="text/css">
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/statistics.css" rel="stylesheet" type="text/css">
    <link href="../css/menu.css" rel="stylesheet" type="text/css">

</head>
<script type="text/javascript">
    $().ready(function () {
        jQuery("#statistics").addClass("selected");
        statisticsAttention();
    });
</script>
<body>
<div id="header" class="header">
    <jsp:include page="include/top.jsp"/>
    <div id="main" class="container">
        <div class="containerBox min-height">
            <div class="boxHeader">
                <h2>统计</h2>
            </div>
            <div class="sideBar">
                <div class="catalogList">
                    <ul id="statistics">
                        <li id="attention"><a
                                href="javascript:statisticsAttention();">被关注时统计</a></li>
                        <li id="statisticsBigWheelComponent"><a
                                href="javascript:statisticsBigWheelComponent();">大转盘统计</a></li>
                        <li id="sacaratchCard"><a href="javascript:statisticsSacaratchCard();">刮刮卡统计</a></li>
                        <li id="survey"><a href="javascript:statisticsSurvey();">问卷调查统计</a></li>
                        <li id="prizeQuiz"><a href="javascript:statisticsPrizeQuiz();">有奖竞答统计</a></li>
                    </ul>
                </div>
            </div>
            <!--账号设置_Begin-->
            <div class="content">
                <h3>统计列表</h3>
                <!--统计列表 for循环_start-->
                <div class="list_title" id="content">

                </div>
                <div class="clr"></div>

            </div>
            <div class="clr"></div>
        </div>
    </div>
    <jsp:include page="include/bottom.jsp"/>
</body>
</html>
