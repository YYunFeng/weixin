<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 下午6:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-账号设置</title>
    <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/toolJS.js"></script>
    <link href="../css/menu.css" rel="stylesheet" type="text/css">
    <link href="../css/setting.css" rel="stylesheet" type="text/css">
    <link href="../css/public.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    $().ready(function () {
        jQuery('#setting').addClass("selected");
        if ('<s:property value="#session.weixinmangerweixinaccount.weixinAccount"/>' == '') {
            weixinaccountsetting();
        } else {
            personMess();
        }
    });
    // 个人资料
    function personMess() {
        toolJS.loading(1);
        jQuery.ajax({
            type: "GET",
            url: "/setting/personMess.action",
            dataType: "html",
            success: function (msg) {
                jQuery('#main').html(msg);
                $(".catalogList ul li").each(function () {
                    $(this).removeClass();
                });
                $("#personMess").addClass("selected");
                toolJS.loading(0);
            }
        });
    }
    // 接口信息
    function interfaceMess() {
        toolJS.loading(1);
        jQuery.ajax({
            type: "GET",
            url: "/setting/interfaceMess.action",
            dataType: "html",
            success: function (msg) {
                jQuery('#main').html(msg);
                $(".catalogList ul li").each(function () {
                    $(this).removeClass();
                });
                $("#interfaceMess").addClass("selected");
                toolJS.loading(0);
            }
        });
    }
    // 关联微信账号
    function weixinaccountsetting() {
        document.getElementById("sideBar").style.display = "none";
        jQuery.ajax({
            type: "GET",
            url: "/setting/weixinaccountsetting.action",
            dataType: "html",
            success: function (msg) {
                jQuery('#main').html(msg);
            }
        });
    }

    // 修改密码
    function modifyPassWord() {
        toolJS.loading(1);
        jQuery.ajax({
            type: "post",
            url: "/setting/modifyPassWord.action",
            dataType: "html",
            success: function (msg) {
                jQuery('#main').html(msg);
                $(".catalogList ul li").each(function () {
                    $(this).removeClass();
                });
                $("#modifyPassWord").addClass("selected");
                toolJS.loading(0);
            }
        });
    }
    // 保存修改密码
    function savemodifyPass() {
        var password = $('#password').val();
        if (jQuery.formValidator.pageIsValid('1')) {
            jQuery.ajax({
                type: 'post',
                url: '/setting/saveModifyPass.action',
                data: 'user.password=' + password,
                dataType: 'json',
                success: function (data) {
                    if (data.status == 1) {
                        alert("修改成功!");
                        modifyPassWord();
                    }
                    if (data.status == 0) {
                        alert(data.mess);
                    }
                }
            });
        }
    }
</script>
<body>
<div id="header" class="header">
    <!--top-->
    <jsp:include page="include/top.jsp"></jsp:include>
    <!--内容-->
    <div class="container">
        <div class="containerBox min-height">
            <div class="boxHeader">
                <h2>设置</h2>
            </div>
            <div class="sideBar" id="sideBar">
                <div class="catalogList">
                    <ul>
                        <li id="personMess"><a href="javascript:personMess()">个人资料</a></li>
                        <li id="interfaceMess"><a href="javascript:interfaceMess()">接口配置信息</a></li>
                        <li id="modifyPassWord"><a href="javascript:modifyPassWord()">修改密码</a></li>
                    </ul>
                </div>
            </div>
            <!--个人资料设置_Begin-->
            <div class="content" style="display:block;" id="main">

            </div>
            <div class="clr"></div>
        </div>
    </div>
    <jsp:include page="include/bottom.jsp"></jsp:include>
</div>
</body>
</html>
