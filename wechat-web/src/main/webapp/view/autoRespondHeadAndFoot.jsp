<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-28
  Time: 上午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="respond_left">
    <div class="help_check">
        <span class="left_title">页眉内容：</span>
        <input id="yemei_new" class="right_input" value="<s:property value="autoRespondHeadAndFootRes.textResourcesHead.message"/>" type="text" onkeyup="syn_new_mei()"/>
    </div>
    <p class="text_warn2">建议输入20字</p>

    <div class="help_check">
        <span class="left_title">页脚内容：</span>
        <input id="yejiao_new" class="right_input" type="text" onkeyup="syn_new_jiao()" value="<s:property value="autoRespondHeadAndFootRes.textResourcesFoot.message"/>"/>
    </div>
    <p class="text_warn2">建议输入20字</p>

    <div class="compelt_button"><a href="javascript:saveHeadAndFoot(<s:property value="autoRespondHeadAndFootRes.textResourcesHead.Id"/>,<s:property value="autoRespondHeadAndFootRes.textResourcesFoot.Id"/>);" class="btnGreen">修改</a></div>
</div>
<!--预览窗口_Begin-->
<div class="preview_win">
    <input id="yemei_new_pre" type="text" class="page_head" value="<s:property value="autoRespondHeadAndFootRes.textResourcesHead.message"/>"/>
    <input id="yejiao_new_pre" type="text" class="page_bottom" value="<s:property value="autoRespondHeadAndFootRes.textResourcesFoot.message"/>"/>
</div>
<!--预览窗口_End-->