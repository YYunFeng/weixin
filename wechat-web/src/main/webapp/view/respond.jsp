<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-28
  Time: 上午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="respond_left">
    <textarea id="auto_text" class="text_block1" onkeyup="syn_auto()"><s:property value="textResources.message"/></textarea>
    <p class="text_warn">建议输入200字以内
       </p>
    <p class="text_warn"> 温馨提示：用户发送的信息，均不是规则中的关键词时，公众号所回复的内 容。
        例如：
        用户发送“z”，当规则中没有“z”这个关键便会回复信息。</p>
    <div class="compelt_button"><a href="javascript:saveTextResource(0,<s:property value="textResources.Id"/>);" class="btnGreen">修改</a></div>
</div>
<!--预览窗口_Begin-->
<div class="preview_win_3">
    <div type="text" id="key_help_2" class="help_1" readonly="readonly">呵呵</div>
    <textarea id="auto_text_pre" class="help_2" readonly="readonly"><s:property value="textResources.message"/></textarea>
</div>