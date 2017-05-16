<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>个人信息</h3>
<table class="setting_block" border="0" width="100%">
    <tr>
        <td width="auto" align="right" valign="top">用户名：</td>
        <td valign="top"><input type="text" class="text_input"  readonly="readonly" value="<s:property value="user.userName"/>"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">邮箱：</td>
        <td valign="top"><input type="text" class="text_input" readonly="readonly" value="<s:property value="user.mail"/>"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">公司名称：</td>
        <td valign="top"><input type="text" class="text_input" readonly="readonly" value="<s:property value="user.bussinessName "/>"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">公司简介：</td>
        <td valign="top"><input type="text" class="text_input"  readonly="readonly" value="<s:property value="user.introduction"/>"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">联系人：</td>
        <td valign="top"><input type="text" class="text_input"  readonly="readonly" value="<s:property value="user.linkMan"/>"/></td>
    </tr>
    <tr>
        <td width="auto" align="right" valign="top">联系电话：</td>
        <td valign="top"><input type="text" class="text_input" readonly="readonly" value="<s:property value="user.telephone"/>"/></td>
    </tr>
</table>
