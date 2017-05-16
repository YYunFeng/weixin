<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 下午7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/settingJS.js"></script>
<script type="text/javascript" src="../js/fouseJS.js"></script>
<h3>帐号信息</h3>
<table class="setting_block" border="0" width="100%" height="auto">
    <tr>
        <td width="auto" align="right" valign="top">公众平台账号：</td>
        <td valign="top"><input type="text" id="weixinAccount" class="text_input" onfocus="fouseJS.focusFun(this)"
                                onblur="fouseJS.blurFun(this)"/></td>
    </tr>
    <tr>
        <td colspan="2"><h3>基本信息</h3></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">企业名称：</td>
        <td valign="top"><input type="text" class="text_input" id="businessName"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">所在地：</td>
        <td valign="top"><input type="text" class="text_input" id="area"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">联系人：</td>
        <td valign="top"><input type="text" class="text_input" id="linkman"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">联系电话：</td>
        <td valign="top"><input type="text" class="text_input" id="telephone"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">简介：</td>
        <td valign="top"><textarea id="introduction"></textarea></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top" class="table_left">&nbsp;</td>
        <td valign="center"><a disable="true" id="save" href="javascript:settingJS.saveFinish();"
                               class="btnGreen">保存</a>
        </td>
    </tr>
</table>
