<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:iterator value="componentList" status="component">
    <div class="module_block">
        <div class="msg-item-wrapper" style="margin-bottom:0px;" <s:if test="!expired">onclick="setClass(<s:property value="Id"/>)"</s:if>>
            <div id="appmsgItem1" class="msg-item appmsgItem">
                <h4 class="msg-t"><s:property value="title"/></h4>
                <p class="msg-meta"><span class="msg-date"><s:date name="created" format="yyyy-MM-dd" /> </span></p>
                <div class="cover">
                    <s:if test="expired"><div class="over"></div></s:if>
                    <p class="default-tip" style="display:none">封面图片</p>
                    <img src="<s:property value="pic"/>"
                         class="i-img" style="">
                </div>
                <p class="msg-text">
                    <s:if test="%{null!=intro&&intro.length()>30}">
                        <s:property value="%{intro.substring(0, 20)}" />……
                    </s:if>
                    <s:else>
                        <s:property value="intro"/>
                    </s:else>
                </p>
            </div>
        </div>
        <div id="component<s:property value="Id"/>" class="module_sel_no" onclick="setClass_2(<s:property value="Id"/>);">
            <div id="sel_icon" class="sel_icon"></div>
        </div>
    </div>
</s:iterator>