<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-16
  Time: 下午4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../js/statistics_concernJS.js"></script>
<div class="list_title_l"></div>
<div class="list_title_c">
    <div class="list_title_c_l ltcr3">
        <div>被关注时</div>
        <div class=""></div>
    </div>
    <div class="list_title_c_r ltcr3">
        <div class="c2"><s:property value="statisticsAttentionRes.allWinnerCount"/></div>
        <div class="s2">总中奖人数</div>
    </div>
    <div class="list_title_c_r ltcr3">
        <div><s:property value="statisticsAttentionRes.allTotalAttentionCount"/></div>
        <div class="s2">总关注量</div>
    </div>
    <div class="clr"></div>
</div>
<div class="list_title_r"></div>
<div class="clr"></div>
<!--统计列表 for循环_start-->
<s:iterator value="statisticsAttentionRes.statisticsResList">
    <div class="list_title">
        <div class="list_title_l"></div>
        <div class="list_title_c">
            <div class="list_title_c_l">
                <div class="date1"><s:property value="attentionMonth"/></div>
                <div></div>
            </div>
            <div class="list_title_c_r ltcr1">
                <div class="s1"><a style="cursor: pointer" onclick="statistics_concernJS.btn_listhidden('<s:property value="attentionMonth"/>',1);">查看详情</a></div>
            </div>
            <div class="list_title_c_r ltcr2">
                <div class="c2"><s:property value="winNumber"/></div>
                <div class="s2">中奖人数</div>
            </div>
            <div class="list_title_c_r ltcr2">
                <div><s:property value="totalAttionCount"/></div>
                <div class="s2">关注量</div>
            </div>
            <div class="clr"></div>
        </div>
        <div class="list_title_r"></div>
        <div class="clr"></div>
        <div class="list_detail" id="<s:property value="attentionMonth"/>" style="display:none;">

        </div>

    </div>
</s:iterator>
