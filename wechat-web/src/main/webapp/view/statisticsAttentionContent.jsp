<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-16
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--注意此id，statistics_concernJS.btn_listhidden('list_detail_1')这个函数进行了调用-->
<div class="list_subcon_banner">
    <div class="border_b date"></div>
    <div class="border_b">
        <div class="list_subcon_iconX iconc1">关注量</div>
    </div>
    <div class="border_b">
        <div class="list_subcon_iconX iconc2">中奖人数</div>
    </div>
</div>
<div class="clr"></div>
<div style="height:10px;"></div>

<s:iterator value="statisticsResList">
    <div class="list_subcon">
        <div class="date"><s:date name="DrawTime" format="yy/MM/dd"/></div>
        <div class="border_b"><s:property value="totalAttionCount"/></div>
        <div class="border_b_or"><s:property value="winNumber"/></div>
    </div>
</s:iterator>

<!--详情for循环_end-->
<div class="clr"></div>
<div class="list_subcon_btn hidden_btn" onclick="statistics_concernJS.btn_listhidden('<s:property value=" attentionMonth"/>', 0)">
    <div class="hidden_btn" style="cursor: pointer">收起</div>
</div>
<div class="clr"></div>