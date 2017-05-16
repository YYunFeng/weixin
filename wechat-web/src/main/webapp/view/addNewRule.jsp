<%--
  Created by IntelliJ IDEA.
  User: yyfpc
  Date: 13-4-20
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="list_lan">
    <span>规则名称：</span>
    <input type="text" id="ruleName"/>
</div>
<div class="list_lan">
    <span>关键字：</span>
    <input type="text" id="keyword" onblur="autoRule(this.value)"/>
    <div class="" id="autoRule"></div>
</div>
<div class="list_line"></div>
<div class="list_lan">
    <span>选择类型：</span>
    <select id="linkType" onchange="changeType(this.value)">
        <option value="0">纯文本</option>
        <option value="1">素材</option>
        <option value="2">组件</option>
    </select>
</div>
<!--纯文本区域_Begin-->
<div id="first_area" style="display:block;">
    <h3 class="text_title">回复</h3>
    <textarea class="text_only" id="message"></textarea>
</div>
<!--纯文本区域_End-->
<!--组件区域_start-->
<div id="material_area" class="module_area" style="display:none;">
</div>
<!--组件区域_End-->

<!--组件区域_Begin-->
<div class="module_area" id="module_area" style="display:none;">
</div>
<!--组件区域_End-->
<input id="componentId" type="hidden"/>
<input id="materialId" type="hidden"/>
<input id="ruleMess" type="hidden" value=""/>
<input id="flag" type="hidden" value="0"/>
<a disable="true" id="save" href="javascript:saveRule();" class="btnGreen">保存</a>