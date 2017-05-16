<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-3
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-素材管理</title>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="/js/material.js"></script>
    <script type="text/javascript" src="/js/toolJS.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <link href="../css/menu.css" rel="stylesheet" type="text/css">
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_add.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg_change.css" rel="stylesheet" type="text/css">
    <link href="../css/wxm_appmsg_list.css" rel="stylesheet" type="text/css">
    <link href="../css/ueditor.css" rel="stylesheet" type="text/css">
    <link href="../css/ueditor14e99c.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_add.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    $().ready(function () {
        jQuery('#matter').addClass("selected");
        jQuery('#singleImageText').addClass("selected");
        singleImageTextContent();
    });
</script>
<body>
<div id="header" class="header">
    <jsp:include page="include/top.jsp"></jsp:include>
    <div id="main" class="container">
        <div class="containerBox">
            <div class="boxHeader">
                <h2>素材管理</h2>
            </div>
            <div class="sideBar">
                <div class="catalogList">
                    <ul id="materialList">
                        <li id="singleImageText"><a href="javascript:singleImageTextContent();">单图文消息</a></li>
                        <li id="manyImageText"><a href="javascript:manyImageTextConent();">多图文消息</a></li>
                    </ul>
                </div>
            </div>


            <div class="content" id="content">
            </div>
            <div class="clr"></div>
        </div>
    </div>
    <jsp:include page="include/bottom.jsp"></jsp:include>
</div>
</body>
</html>
