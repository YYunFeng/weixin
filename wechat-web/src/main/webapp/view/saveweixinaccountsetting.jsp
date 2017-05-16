<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 下午7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>帐号信息</h3>
<table class="setting_block" border="0" width="100%" height="auto">
    <tr>
        <td width="auto" align="right" valign="top">URL：</td>
        <td valign="top"><input type="text" class="text_input" readonly="readonly"
                                value="<s:property value="saveweixinaccuntRes.interfaceUrl"/>"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">TOKEN：</td>
        <td valign="top"><input type="text" id="weixinAccount" class="text_input" readonly="readonly"
                                value="<s:property value="saveweixinaccuntRes.token"/>"/></td>
    </tr>
</table>
