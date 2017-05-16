<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:iterator value="materialListResList" status="material">
    <div class="module_block">
        <div class="msg-item-wrapper" style="margin-bottom:0px;" onclick="setClassMaterial(<s:property value="Id"/>)">
            <div id="appmsgItem1" class="msg-item appmsgItem">
                <h4 class="msg-t"><s:property value="title"/>
                <span style="color:#73ae1f;">(共<b><s:property
                        value="manyImageTextCount"/></b>张图文)</span></h4>

                <p class="msg-meta"><span class="msg-date"><s:date name="created" format="yyyy-MM-dd"/> </span></p>

                <div class="cover">
                    <p class="default-tip" style="display:none">封面图片</p>
                    <img src="<s:property value="picUrl"/>"
                         class="i-img" style="">
                </div>
                <p class="msg-text"><s:property value="intro"/></p>
            </div>
        </div>
        <div id="material<s:property value="Id"/>" class="module_sel_no"
             onclick="setClassMaterial_2(<s:property value="Id"/>);">
            <div id="sel_icon" class="sel_icon"></div>
        </div>
    </div>
</s:iterator>