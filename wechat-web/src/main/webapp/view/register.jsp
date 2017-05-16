<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 上午11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>微信平台-用户注册</title>
    <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/js/formValidator-4.1.1.min.js"></script>
    <script type="text/javascript" src="/js/formValidatorRegex.js"></script>
    <script type="text/javascript" src="/js/md5.js"></script>
    <link href="/css/sign.css" rel="stylesheet" type="text/css">
    <link href="/css/sign_2.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    $(document).ready(function () {
        jQuery.formValidator.initConfig({validatorGroup: "1", theme: "Default", submitOnce: true, formID: "addUser", mode: "FixTip", onError: function (msg) {
            alert(msg);
        }, onSuccess: function () {
            return true;
        },
            submitAfterAjaxPrompt: '有数据正在异步验证，请稍等...'
        });
        jQuery("#userName").formValidator({
            validatorGroup: "1",
            onShow: "请填写用户名，该内容将作为登录信息"
        }).inputValidator({
                    min: 3,
                    onError: "由6~15个中英文、数字或者“_”组成"
                }).functionValidator({
                    fun: function (val, elem) {
                        if (!IsDevAuthor(val, 3, 30)) {
                            return "由6~15个中英文、数字或者“_”组成";
                        }
                        return true;
                    }
                }).functionValidator({fun: checkUser});
        jQuery("#email").formValidator({
            validatorGroup: "1",
            onShow: "请输入有效邮箱地址",
            onFocus: "请输入您的电子邮箱"
        }).inputValidator({
                    min: 1,
                    onError: "电子邮箱不能为空"
                }).regexValidator({
                    regExp: "^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",
                    dataType: "string",
                    onError: "请检查邮箱格式"
                });

        jQuery("#pw1").formValidator({
            validatorGroup: "1",
            onShow: "6~16个字符，包括字母、数字、特殊符号，区分大小写"
        }).inputValidator({
                    min: 6,
                    max: 16,
                    onError: "密码长度错误,请确认!"
                });

        jQuery("#pw2").formValidator({
            validatorGroup: "1",
            onShow: "再次输入密码",
            onFocus: "至少6个长度",
            onCorrect: "密码一致"
        }).inputValidator({
                    min: 1,
                    empty: {
                        leftEmpty: false,
                        rightEmpty: false,
                        emptyError: "重复密码两边不能有空符号"},
                    onError: "重复密码不能为空,请确认"
                }).compareValidator({
                    desID: "pw1",
                    operateor: "=",
                    onError: "2次密码不一致,请确认"
                });
    });

    // 注册用户
    function createUser() {
        var userName = document.getElementById("userName").value;
        var mail = document.getElementById("email").value;
        var password1 = document.getElementById("pw1").value;
        if (jQuery.formValidator.pageIsValid('1')) {
            jQuery.ajax({
                type: "POST",
                url: "/register/addRegister.action",
                data: {
                    "user.userName": userName,
                    "user.mail": mail,
                    "user.password": hex_md5(password1)
                },
                dataType: "json",
                success: function (data) {
                    if (data.status == 1) {
                        alert("注册成功！");
                        window.location = "/login.action";
                    } else {
                        alert(data.mess);
                        window.location = "/register.action";
                    }
                }
            });
        }
    }

    function checkUser() {
        var userName = $("#userName").val();
        var temp = '';
        jQuery.ajax({
            type: "POST",
            url: "/register/authUser.action",
            data: {"userName": userName},
            async: false,
            datatype: "json",
            success: function (data) {
                if (data == 0)
                    temp = true;
                else if (data == 1)
                    temp = "该名称已被注册";
            }
        });
        return temp;
    }
</script>
<body>
<!--注册头部_Begin-->
<div id="header" class="header">
    <div class="logo_area">
        <div class="wrapper">
            <img src="/images/logo.png" onclick="javascript:location.href='/'" alt="微信公众平台">
      <span class="hd_login_info">
        <a href="mailto:ypwang@platomix.net">咨询请发邮件至：ypwang@platomix.net</a>
      </span>
        </div>
    </div>
</div>
<!--注册头部_End-->
<div id="main" class="container">
    <div class="containerBox boxIndex">
        <div class="rn-reg-t-wrapper group">
            <ul>
                <li class="tc left rn-reg-t current">用户注册</li>
            </ul>
        </div>
        <!--注册表单_Begin-->
        <form name="addUser" method="post" action="addRegister.action"
              id="addPerDcDeveloperForm">
            <div style="display: block;" class="rn-box reg-box">
                <div class="frm">
                    <div class="frm-bd group">
                        <div class="frm-section l">
                            <div class="section-bd">
                                <div id="user_name" class="group frm-control-group extra">
                                    <label for="email" class="frm-control-label">用户名</label>

                                    <div class="frm-controls">
                                        <input id="userName" placeholder="" class="frm-controlM" type="text"
                                               name="userName"/>
                                        <label class="ts" id="userNameTip"></label>
                                    </div>
                                </div>
                                <div id="email_group" class="group frm-control-group extra">
                                    <label for="email" class="frm-control-label">邮箱</label>

                                    <div class="frm-controls">
                                        <input id="email" placeholder="" class="frm-controlM" type="text">
                                        <label class="ts" id="emailTip"></label>
                                    </div>
                                </div>
                                <div id="pw1_group" class="group frm-control-group">
                                    <label for="pw1" class="frm-control-label">密码</label>

                                    <div class="frm-controls">
                                        <input id="pw1" onpaste="return false" class="frm-controlM" type="password">
                                        <label class="ts" id="pw1Tip"></label>
                                    </div>
                                </div>
                                <div id="pw2_group" class="group frm-control-group">
                                    <label for="pw2" class="frm-control-label">确认密码</label>

                                    <div class="frm-controls">
                                        <input id="pw2" onpaste="return false" class="frm-controlM" type="password">
                                        <label class="ts" id="pw2Tip"></label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="frm-tip l">
                            <p>
                                <i>●</i>已有微信直通车帐号？<a href="/login.action">立即登录</a>
                            </p>
                        </div>
                    </div>
                    <div class="frm-ft">
                        <div class="tc frm-opr">
                            <a disable="true" id="reg" href="javascript:createUser();" class="btnGreen">注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--注册表单_End-->
        <div style="display:none;" class="rn-box active-box">
            <div class="frm">
                <div class="frm-hd">
                    <div class="frm-msg">
                        <span class="msg-pic"><i class="user-icon email-icon"></i></span>

                        <div class="frm-msg-content" style="padding-top:5px">
                            <h3 class="frm-msg-t">激活公众平台帐号</h3>

                            <p class="frm-msg-text">感谢注册！确认邮件已发送至你的注册邮箱 : <span id="confirm_email"></span>。请进入邮箱查看邮件，并激活公众平台帐号。
                            </p>

                            <p class="mailto-access">
                                <a href="" id="login_email" class="btnGreen">登录邮箱</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="frm-ft">
                    <div class="frm-qa">
                        <dl class="frm-qa-list">
                            <dt class="frm-qa-t">没有收到邮件？</dt>
                            <dd class="frm-qa-item">1、请检查邮箱地址是否正确，你可以返回<a id="returnEmail" href="javascript:;">重新填写</a>。
                            </dd>
                            <dd class="frm-qa-item">2、检查你的邮件垃圾箱</dd>
                            <dd class="frm-qa-item">3、若仍未收到确认，请尝试<a id="reSendEmail" href="javascript:;">重新发送</a></dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="include/bottom.jsp"/>
</body>
</html>