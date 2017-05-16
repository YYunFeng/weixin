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
    <div class="help_check">
        <span class="left_title">关键字：</span>
        <span>帮助</span>
    </div>
    <textarea id="help_txt" class="text_block1" onkeyup="syn_2()"><s:property value="textResources.message"/></textarea>

    <p class="text_warn">建议输入200字</p>

    <div class="compelt_button"><a href="javascript:saveTextResource(1,<s:property value="textResources.Id"/>);"
                                   class="btnGreen">修改</a></div>
</div>
<!--预览窗口_Begin-->
<div class="preview_win_3">
    <input type="text" id="key_help_2" class="help_1" readonly="readonly"/>
    <textarea id="help_txt_2" class="help_2" readonly="readonly"><s:property value="textResources.message"/></textarea>
</div>
<!--预览窗口_End-->