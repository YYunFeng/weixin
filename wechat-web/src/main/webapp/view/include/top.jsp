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
                <s:property value="#session.weixinmanagersessionuser.userName"/>,
            </span>
            <span>
                关联微信账号:
                <s:if test="#session.weixinmangerweixinaccount.weixinAccount!=null"> <s:property
                        value="#session.weixinmangerweixinaccount.weixinAccount"/></s:if>
                <s:else>
                    暂无
                </s:else>
            </span>
            <span>
                <a href="javascript:logout();">退出</a>
            </span>
    </div>
    <div class="clr"></div>
</div>
<div class="navigator">
    <ul class="textLarge">
        <li><a id="home" href="/home/home.action">首页</a></li>
        <li><a id="matter" href="/material/materialManager.action">素材管理</a></li>
        <li><a id="component" href="/component/componentManager.action">组件管理</a></li>
        <li><a id="autorespond" href="/autoRespond/autoRespond.action">自动回复</a></li>
        <li><a id="statistics" href="/statistics/statistics.action">统计</a></li>
        <li><a id="setting" href="/setting/setting.action">设置</a></li>
    </ul>
</div>