<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-15
  Time: 下午12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="list_subcon_banner">
    <div class="border_b date"></div>
    <div class="border_b">
        <div class="list_subcon_iconX iconc1">访问量</div>
    </div>
    <div class="border_b">
        <div class="list_subcon_iconX iconc3">参与量</div>
    </div>
    <div class="border_b">
        <div class="list_subcon_iconX iconc2">中奖人数</div>
    </div>
</div>
<div class="clr"></div>
<div style="height:10px;"></div>
<!--详情for循环_start-->
<s:iterator value="statisticsResList">
    <div class="list_subcon">
        <div class="date"><s:date name="DrawTime" format="yy/MM/dd"/></div>
        <div class="border_b"><s:property value="visitView"/></div>
        <div class="border_b_ye"><s:property value="partakeNumber"/></div>
        <div class="border_b_or"><s:property value="winNumber"/></div>
    </div>
</s:iterator>
<!--详情for循环_end-->
<div class="clr"></div>
<div class="list_subcon_btn hidden_btn" style="cursor: pointer"
     onclick="statisticsJS.btn_listhidden('<s:property value="statisticsResList[0].componentId"/>',0,1)">
    <div class="hidden_btn">收起</div>
</div>
<div class="clr"></div>