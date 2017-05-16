<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-9
  Time: 上午11:27
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../js/formValidator-4.1.1.min_changePass.js"></script>
<script type="text/javascript" src="../js/formValidatorRegex.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(document).ready(function () {
        jQuery.formValidator.initConfig({validatorGroup: "1", theme: "Default", submitOnce: true, mode: "FixTip", onError: function (msg) {
        }, onSuccess: function () {
            return true;
        },
            submitAfterAjaxPrompt: '有数据正在异步验证，请稍等...'
        });
        jQuery("#nowPassword").formValidator({
            validatorGroup: "1",
            onShow: "请输入密码!"
        }).inputValidator({
                    min: 3,
                    onError: "密码错误"
                }).ajaxValidator({
                    type: "post",
                    async: true,
                    url: "/setting/checkPass.action",
                    datatype: "json",
                    success: function (data) {
                        if (data == 0)
                            return false;
                        else if (data == 1)
                            return true;
                        else if (data == 2)
                            alert('系统出错');
                        return false;
                    },
                    error: function () {
                        AlertTips("服务器忙，请重试");
                    },
                    onError: "密码错误",
                    onWait: "正在合法性校验，请稍候..."
                });

        jQuery("#password").formValidator({
            validatorGroup: "1",
            onShow: "6~16个字符，包括字母、数字"
        }).inputValidator({
                    min: 6,
                    max: 16,
                    onError: "密码长度错误,请确认!"
                }).passwordValidator({
                    onErrorCompareSame: "",
                    ContinueChar: false,
                    SameChar: false,
                    compareID: "confPassword"
                });

        jQuery("#confPassword").formValidator({
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
                    desID: "password",
                    operateor: "=",
                    onError: "2次密码不一致,请确认"
                });
    });




</script>
<h3>安全设置</h3>
<table class="setting_block" border="0" width="100%" height="auto">
    <tr>
        <td width="auto" align="right" valign="top">旧密码：</td>
        <td valign="top">
            <input type="password" class="text_input" name="user.password" id="nowPassword"/>
            <label id="nowPasswordTip"></label>
        </td>

    </tr>
    <tr>
        <td width="auto" align="right" valign="top">新密码：</td>
        <td valign="top">
            <input type="password" class="text_input" id="password"/>
            <label id="passwordTip"></label>
        </td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">确认密码：</td>
        <td valign="top">
            <input type="password" class="text_input" id="confPassword"/>
            <label id="confPasswordTip">请再次输入</label>
        </td>

    </tr>
    <tr>
        <td width="auto" align="right" valign="top" class="table_left">&nbsp;</td>
        <td valign="center"><a disable="true" id="save" href="javascript:savemodifyPass();" class="btnGreen">保存</a></td>
    </tr>
</table>
