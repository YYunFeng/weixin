<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<div class="logoArea">
    <a class="logo left block" href="#">
        <img src="../images/logo2.png" alt="微信公众平台">
    </a>
    <div class="accountOp right">
            <span>
                <s:property value="#session.weixinmanagersessionuser.userName"/>(管理员)
            </span>
            <span>
                <a href="javascript:logout();">退出</a>
            </span>
    </div>
    <div class="clr"></div>
</div>
<div class="navigator">
    <ul class="textLarge">
        <li><a id="home" href="/superUser/superUserHome.action">用户管理</a></li>
    </ul>
</div>