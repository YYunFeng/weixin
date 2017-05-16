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
    <input type="text" id="ruleName" value="<s:property value="autoRespondRes.ruleName"/>"/>
</div>
<div class="list_lan">
    <span>关键字：</span>
    <input type="text" id="keyword" value="<s:property value="autoRespondRes.keyword"/>"
           onblur="autoModifyRule(this.value)"/>

    <div class="" id="autoRule"></div>
</div>
<div class="list_line"></div>
<div class="list_lan">
    <span>选择类型：</span>
    <select id="linkType" onchange="changeType(this.value)">
        <option value="0"  <s:if test="autoRespondRes.linkType==0"> selected="selected"</s:if>>纯文本</option>
        <s:if test="autoRespondRes.textResourceId==null">
            <option value="1"  <s:if test="autoRespondRes.linkType==1"> selected="selected"</s:if>>素材</option>
            <option value="2" <s:if test="autoRespondRes.linkType==2"> selected="selected"</s:if>>组件</option>
        </s:if>
        <!--<option>多图文</option>-->
    </select>
</div>
<!--纯文本区域_Begin-->
<div id="first_area" <s:if
        test="autoRespondRes.linkType==0"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <h3 class="text_title">回复：</h3>
    <textarea class="text_only" id="message"><s:if test="autoRespondRes.textResourceId!=null"><s:property
            value="autoRespondRes.textResourceMessage"/></s:if><s:else><s:property
            value="autoRespondRes.message"/></s:else></textarea>
</div>
<!--纯文本区域_End-->
<!--图文区域_Begin-->
<div id="material_area" class="module_area" <s:if
        test="autoRespondRes.linkType==1"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <s:iterator value="materialListResList" status="material">
        <div class="module_block">
            <div class="msg-item-wrapper" style="margin-bottom:0px;"
                 onclick="setClassMaterial(<s:property value="Id"/>)">
                <div id="appmsgItem2" class="msg-item appmsgItem">
                    <h4 class="msg-t"><s:property value="title"/></h4>

                    <p class="msg-meta"><span class="msg-date"><s:date name="created" format="yyyy-MM-dd"/> </span></p>

                    <div class="cover">
                        <p class="default-tip" style="display:none">封面图片</p>
                        <img src="<s:property value="picUrl"/>"
                             class="i-img" style="">
                    </div>
                    <p class="msg-text"><s:property value="intro"/></p>
                </div>
            </div>
            <div id="material<s:property value="Id"/>"
                    <s:if test="Id==autoRespondRes.materialId"> class="module_sel"</s:if><s:else>class="module_sel_no"</s:else>
                 onclick="setClassMaterial_2(<s:property value="Id"/>);">
                <div id="sel_icon" class="sel_icon"></div>
            </div>
        </div>
    </s:iterator>
</div>
<!--图文区域_End-->

<!--组件区域_Begin-->
<div class="module_area" id="module_area" <s:if
        test="autoRespondRes.linkType==2"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <s:iterator value="componentList" status="component">
        <div class="module_block">
            <div class="msg-item-wrapper" style="margin-bottom:0px;" onclick="setClass(<s:property value="Id"/>)">
                <div id="appmsgItem1" class="msg-item appmsgItem">
                    <h4 class="msg-t"><s:property value="title"/></h4>

                    <p class="msg-meta"><span class="msg-date"><s:date name="created" format="yyyy-MM-dd"/> </span></p>

                    <div class="cover">
                        <p class="default-tip" style="display:none">封面图片</p>
                        <img src="<s:property value="pic"/>"
                             class="i-img" style="">
                    </div>
                    <p class="msg-text"><s:property value="intro"/></p>
                </div>
            </div>
            <div id="component<s:property value="Id"/>"
                    <s:if test="Id==autoRespondRes.componentId"> class="module_sel"</s:if><s:else>class="module_sel_no"</s:else>
                 onclick="setClass_2(<s:property value="Id"/>);">
                <div id="sel_icon" class="sel_icon"></div>
            </div>
        </div>
    </s:iterator>
</div>
<input id="ruleMess" type="hidden" value="<s:property  value="autoRespondRes.keyword"/>"/>
<input id="componentId" type="hidden" value="<s:property  value="autoRespondRes.componentId"/>"/>
<input id="materialId" type="hidden" value="<s:property  value="autoRespondRes.materialId"/>"/>
<input id="textResourceId" type="hidden" value="<s:property value="autoRespondRes.textResourceId"/>"/>
<input id="flag" type="hidden" value="1"/>
<a disable="true" id="save" href="javascript:saveModifyRule(<s:property value="autoRespondRes.Id"/>);"
   class="btnGreen">保存</a>
<s:if test="autoRespondRes.textResourceId!=null">
    <a disable="true" id="save" href="javascript:exportHelp();"
    class="btnGreen">一键生成回复信息<a>
    <p>
        <a onclick="helpShortcutsFun(1)" class="helpShortcuts_what" style="cursor: pointer;">这是什么？</a>
    </p>
    <script>
        function helpShortcutsFun(temp) {
            if (temp == 1) {
                document.getElementById('helpShortcuts').style.visibility = 'inherit';
            } else {
                document.getElementById('helpShortcuts').style.visibility = 'hidden';
            }
        }
    </script>
    <div class="helpShortcuts" id="helpShortcuts" style=" visibility:hidden">
        <div class="helpShortcutsIMG"></div>
        <p>
            <b style=" text-decoration:underline;">点击一下，会将您所有的规则快速生成一段帮助的回复信息，您不用一条一条复制规则啦！</b>如果有新的规则的时候，记得重新点击一下这个按钮哦~
        </p>

        <p>
            <br/>
            例如：<br/>
            规则名：今日推荐<br/>
            关键字：q<br/>
            ...<br/>
            规则名：今日中奖信息<br/>
            关键字：w<br/>
            ...
        </p>

        <p>
            <br/>
            点击“一键生成回复信息”，生成的信息为：<br/>
            回复q：今日推荐<br/>
            回复w：今日中奖信息
        </p>

        <p style="text-align:right;text-decoration:underline; font-weight:bold;cursor: pointer;" onclick="helpShortcutsFun(0)">关闭</p>
    </div>


</s:if>
