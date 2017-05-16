<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-24
  Time: 下午6:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/artDialog/artDialog.min.js"></script>
<link href="../js/artDialog/skins/green.css" rel="stylesheet" type="text/css">
<link href="/css/pagination/page.css" rel="stylesheet" type="text/css"/>
<table class="manage_table" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <th class="tdnum">序号</th>
        <th class="cus">用户名</th>
        <th class="cus">企业名称</th>
        <th class="cus">所在地</th>
        <th class="cus">联系人</th>
        <th class="cus cusorderby" onclick="orderby();"><img src="../images/boult.png" width="12">上行</th>
        <th class="cus">下行</th>
        <th class="cus">电话</th>
        <th class="cus">微信账号</th>
        <th class="cus">注册时间</th>
        <th class="btn">操作</th>
    </tr>
    <s:if test="userList.size()==0">
        <tr>
            <td colspan="8">暂无用户，请修改搜索条件试试！</td>
        </tr>
    </s:if>
    <s:else>
        <s:iterator value="userList.list">
            <tr>
                <td class="tdnum"><s:property value="Id"/></td>
                <td><s:property value="userName"/></td>
                <td><s:property value="businessName"/></td>
                <td><s:property value="area"/></td>
                <td style="text-align:left"><s:property value="mail"/></td>
                <td><s:property value="upCount"/></td>
                <td><s:property value="downCount"/></td>
                <td><s:property value="telephone"/></td>
                <td><s:property value="weixinaccount"/></td>
                <td><s:date format="yyyy-MM-dd" name="created"/></td>
                <td class="btn"><input type="button" style="cursor: pointer;" value="查看日志" onclick="checkLog(<s:property value="Id"/>);"/></td>
            </tr>
        </s:iterator>
    </s:else>
</table>
<div  id="statisticsLog" style="display: none;">
    <div style="margin-left: 36px;margin-bottom: 5px;">
        统计时间：<input id="d5223" class="Wdate input" type="text" readonly="readonly" name="superUserParameter.startTime"
                  onFocus="var d5222=$dp.$('d5222');WdatePicker({onpicked:function(){d5224.focus();},maxDate:'#F{$dp.$D(\'d5222\')}'})"/>
        至
        <input id="d5224" class="Wdate input" type="text" readonly="readonly" name="superUserParameter.endTime"
               onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d5223\')}'})"/>
        <input type="button" value="搜索" onclick="searchCheckLog()"/>
    </div>
    <div id="statisticsLogMess">

    </div>
</div>
<input type='hidden' id='pageCount' value="<s:property value="userList.page.totalPage"/>" />
<input type="hidden" id="resultPageCount" value="<s:property value="userList.page.totalPage"/>"/>
<input type="hidden" id="toltalRow" value="<s:property value="userList.page.totalRow"/>"/>
<input type="hidden" id="pageSize" value="<s:property value="userList.page.pageSize"/>"/>
<input id="weixinId" type="hidden" value="<s:property value="logMessageRes.Id"/>">
<!--搜索列表end-->