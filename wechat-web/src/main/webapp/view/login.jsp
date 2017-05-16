<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>专业的微信公众号营销服务平台</title>
    <meta name="keywords" content="微信公众号"/>
    <meta name="description" content="微信营销,微信公众账号,公众号服务"/>
    <script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="../js/md5.js"></script>
    <link href="../new/css/reset.css" rel="stylesheet" type="text/css">
    <link href="../new/css/style.css" rel="stylesheet" type="text/css">
    <link href="../new/css/supersized.css" rel="stylesheet" type="text/css">

</head>
<script type="text/javascript">
   /* $().ready(function () {
        getCookie();
    });*/
    document.onkeydown = function (event_e) {
        if (window.event)
            event_e = window.event;
        var int_keycode = event_e.charCode || event_e.keyCode;
        if (int_keycode == 13) {
            login();
        }
    }

    function login() {
        var flag = $("#flag").val();
        var userName = document.getElementById("userName").value;
        var password = document.getElementById("password").value;
        var rememberFlag = $("#rememberUser").val();
        if (flag == 0) {
            password = hex_md5(password);
        }
        jQuery.ajax({
            type: "POST",
            url: "/checkLogin.action",
            data: {
                "user.userName": userName,
                "user.password": password,
                "rememberFlag": rememberFlag
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    if (data.superUser) {
                        window.location = "/superUser/superUserHome.action";
                    } else {
                        window.location = "/home/home.action";
                    }
                } else {
                    alert(data.mess);
                }
            }
        });
    }

    /* function getCookie() { //获取cookie
     var userMess = $.cookie("weixinmanagersessionuserCookies");//获取cookie中的用户名*!/
     if (userMess) {//密码存在的话把“记住用户名和密码”复选框勾选住
     userMess = userMess.replace(/\"+/g, "");
     $("#rememberUser").val('1');
     $("#flag").val('1');
     $("#rememberPwdIcon").removeClass();
     $("#rememberPwdIcon").addClass("icon24-login checkbox_checked");
     if (userMess.split(",")[0] != null) {//用户名存在的话把用户名填充到用户名文本框
     $("#userName").val(userMess.split(",")[0]);
     }
     if (userMess.split(",")[1] != null) {//密码存在的话把密码填充到密码文本框
     $("#password").val(userMess.split(",")[1]);
     }
     }

     }*/

    // 记住密码
    function rememberUser() {
        var rememberFlag = $("#rememberUser").val();
        if (rememberFlag == 0) {
            $("#rememberUser").val('1');
        }
        if (rememberFlag == 1) {
            $("#rememberUser").val('0');
        }
        rememberFlag = $("#rememberUser").val();
        $("#rememberPwdIcon").removeClass();
        if (rememberFlag != '') {
            if (rememberFlag == 0) {
                $("#rememberPwdIcon").addClass("icon24-login checkbox");
            }
            if (rememberFlag == 1) {
                $("#rememberPwdIcon").addClass("icon24-login checkbox_checked");
            }
        }
    }
    function chacngeUser() {
        $("#flag").val('0');
        $("#password").val('');
        $("#flag").val('0');
        $("#rememberUser").val('0');
        $("#rememberPwdIcon").removeClass();
        $("#rememberPwdIcon").addClass("icon24-login checkbox");
    }
</script>
<body>

<div class="page-container">
    <h1>登录</h1>

    <input type="text" name="username" id="userName" class="username" placeholder="请输入您的用户名！">
    <input type="password" name="password" id="password" class="password" placeholder="请输入您的用户密码！">
    <button type="submit" class="submit_button" onclick="login();">登录</button>
    <input id="flag" value="0" type="hidden"/>

    <div class="register">
        <span>第一次使用公众平台？</span><a style="color: #EF5A20;font-weight:bolder; " href="/register/register.action">立即注册</a></span>
    </div>

</div>

<!-- Javascript -->
<script src="../new/js/supersized.3.2.7.min.js"></script>
<script src="../new/js/supersized-init.js"></script>
<script src="../new/js/scripts.js"></script>
</body>
<%--
<div id="header">
    <div class="wrapper">
        <a href="" class="dib"><img src="../images/logo2.png" border="0"/></a>
     <span class="hd_login_info">
        <span>第一次使用公众平台？</span><a href="/register/register.action">立即注册</a></span>
    </div>
</div>
<div id="banner">
    <div class="wrapper">
        <div class="login-panel">
            <h3>登录</h3>

            <div class="login-mod">
                <div class="login-err-panel dn" id="err_area">
                    <span class="icon-wrapper"><i class="icon24-login err" style="margin-top:-.2em;*margin-top:0;"></i></span>
                    <span id="err_tips"></span>
                </div>
                <form class="login-form" id="login-form">
                    <div class="login-un">
                        <span class="icon-wrapper"><i class="icon24-login un"></i></span>
                        <input id="userName" placeholder="用户名" type="text" onblur="chacngeUser()">
                    </div>
                    <div class="login-pwd">
                        <span class="icon-wrapper"><i class="icon24-login pwd"></i></span>
                        <input id="password" placeholder="密码" type="password">
                    </div>
                </form>
                <div class="login-help-panel">
                    <a id="rememberPwd" class="login-remember-pwd" href="javascript:rememberUser();"><i
                            id="rememberPwdIcon"
                            class="icon24-login checkbox"></i>记住帐号</a>

                    <input id="rememberUser" value="0" type="hidden"/>
                    <input id="flag" value="" type="hidden"/>
                </div>
                <div class="login-btn-panel"><a class="login-btn" title="点击登录" href="javascript:login();"
                                                id="login_button">登录</a></div>
            </div>
        </div>
    </div>
</div>
<div id="contain">
    <div class="wrapper">    <!-- 功能模块 -->
        <div class="mp_fnc_mod">
            <dl class="mp_fnc">
                <dt class="mp_fnc_hd"><span class="icon_wrapper"><i class="icon_mp_fnc maxcode"></i></span>
                <h4 class="mp_fnc_t">统计</h4>        </dt>
                <dd class="mp_fnc_bd"><p class="mp_fnc_c"> 将用过组件的用户<br>进行分类系统的统计 </p></dd>
            </dl>
            <dl class="mp_fnc">
                <dt class="mp_fnc_hd"><span class="icon_wrapper"><i class="icon_mp_fnc msg"></i></span>
                <h4 class="mp_fnc_t">自动回复</h4>        </dt>
                <dd class="mp_fnc_bd"><p class="mp_fnc_c"> 通过设置规则或编程开发<br>自动回复消息，为用户提供服务 </p></dd>
            </dl>
            <dl class="mp_fnc">
                <dt class="mp_fnc_hd"><span class="icon_wrapper"><i class="icon_mp_fnc trans"></i></span>
                <h4 class="mp_fnc_t">组件管理</h4>        </dt>
                <dd class="mp_fnc_bd"><p class="mp_fnc_c"> 这里有最给力的营销工具<br>增加企业与用户的沟通与粘性
                </p></dd>
            </dl>
            <dl class="mp_fnc" style="width:100%;height:0;overflow:hidden;font-size:0;"></dl>
        </div>
    </div>
</div>
<jsp:include page="include/bottom.jsp"/>--%>
