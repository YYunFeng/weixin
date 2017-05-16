<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 下午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="list_lan">
    <span>规则名称：</span>
    <span style="width: 600px;"><s:property value="autoRespondRes.ruleName"/></span>
</div>
<div class="list_lan">
    <span>关键字：</span>
    <span><s:property value="autoRespondRes.keyword"/></span>
</div>
<div class="list_line"></div>
<div class="list_lan">
    <span>选择类型：</span>
    <s:if test="autoRespondRes.linkType==0">
        <span>纯文本</span>
    </s:if>
    <s:if test="autoRespondRes.linkType==1">
        <span>素材</span>
    </s:if>
    <s:if test="autoRespondRes.linkType==2">
        <span>组件</span>
    </s:if>
</div>
<!--纯文本区域_Begin-->
<div id="first_area" class="nav_mod" <s:if
        test="autoRespondRes.linkType==0"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <h3 class="text_title">回复：</h3>

    <div class="dev_desc">
        <s:if test="autoRespondRes.textResourceId!=null">
            <s:property escape="false" value="autoRespondRes.textResourceMessage"/>
        </s:if>
        <s:else>
            <s:property escape="false"  value="autoRespondRes.message"/>
        </s:else>
    </div>
</div>
<!--纯文本区域_End-->

<!--组件区域_Begin-->
<div class="module_area" id="module_area" <s:if
        test="autoRespondRes.linkType==1"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <div class="module_block">
        <div class="msg-item-wrapper" style="margin-bottom:0px;" onclick="setClass()">
            <div id="appmsgItem2" class="msg-item appmsgItem">
                <h4 class="msg-t"><s:property value="autoRespondRes.materialtitle"/></h4>

                <p class="msg-meta"><span class="msg-date"><s:date name="autoRespondRes.materialCreated"
                                                                   format="yyyy-MM-dd"/> </span></p>

                <div class="cover">
                    <p class="default-tip" style="display:none">封面图片</p>
                    <img src="<s:property value="autoRespondRes.materialPic"/>"
                         class="i-img" style="">
                </div>
                <p class="msg-text"><s:property value="autoRespondRes.materialAbstract"/></p>
            </div>
        </div>
    </div>
</div>
<!--组件区域_Begin-->
<div class="module_area" id="module_area" <s:if
        test="autoRespondRes.linkType==2"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <div class="module_block">
        <div class="msg-item-wrapper" style="margin-bottom:0px;" onclick="setClass()">
            <div id="appmsgItem1" class="msg-item appmsgItem">
                <h4 class="msg-t"><s:property value="autoRespondRes.componentTitle"/></h4>

                <p class="msg-meta"><span class="msg-date"><s:date name="autoRespondRes.componentCreated"
                                                                   format="yyyy-MM-dd"/> </span></p>

                <div class="cover">
                    <p class="default-tip" style="display:none">封面图片</p>
                    <img src="<s:property value="autoRespondRes.componentPic"/>"
                         class="i-img" style="">
                </div>
                <p class="msg-text"><s:property value="autoRespondRes.componentIntro"/></p>
            </div>
        </div>
    </div>
</div>
<a disable="true" id="save" href="javascript:modifyRule(<s:property value="autoRespondRes.Id"/>);"
   class="btnGreen">编辑</a>
<s:if test="autoRespondRes.textResourceId==null">
    <a disable="true" id="save" href="javascript:deleteRule(<s:property value="autoRespondRes.Id"/>);"
       class="btnGreen">删除</a>
</s:if>
