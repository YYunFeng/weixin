<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-25
  Time: 下午3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/autoRespondJS.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".cb-enable").click(function () {
            var parent = $(this).parents('.switch');
            $('.cb-disable', parent).removeClass('selected');
            $(this).addClass('selected');
            document.getElementById("guanzhu_open").style.display = "block"
            document.getElementById("guanzhu_close").style.display = "none"
            $('.checkbox', parent).attr('checked', true);
        });
        $(".cb-disable").click(function () {
            var parent = $(this).parents('.switch');
            $('.cb-enable', parent).removeClass('selected');
            document.getElementById("guanzhu_open").style.display = "none"
            document.getElementById("guanzhu_close").style.display = "block"
            $(this).addClass('selected');
            $('.checkbox', parent).attr('checked', false);
        });
    });

    function award_setting_fun(){
        var len = document.getElementsByName('award_setting').length;
        var iTemp = 0;
//	alert(len);
        for(var i = 0; i < len; i++){
            if(document.getElementsByName('award_setting').item(i).checked){
                iTemp = i;
                break;
            }
        }
        if(iTemp == 1){
            document.getElementById('settingNum_span').style.visibility = '';
        }else{
            document.getElementById('settingNum_span').style.visibility = 'hidden';
        }
    }


</script>
<div class="button_block">
    <h3>被关注时自动回复</h3>

    <div class="switch_button">
        <span>有奖关注：</span>

        <p class="switch">
            <label class="cb-enable <s:if test="attentionRes.userWeiXin.focusLucky==true">selected</s:if>"><span>开</span></label>
            <label class="cb-disable <s:if test="attentionRes.userWeiXin.focusLucky==false">selected</s:if>"><span>关</span></label>
            <input type="checkbox" id="checkbox_tab" style="display:none;" class="checkbox" name="field2"/>
        </p>
    </div>
</div>
<!--关注有奖_关的状态_Begin-->
<div id="guanzhu_close"
        <s:if test="attentionRes.userWeiXin.focusLucky==false"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <div class="respond_left">
        <textarea id="close_text" class="text_block1" onkeyup="syn_3()"><s:property
                value="attentionRes.textResources.message"/></textarea>

        <p class="text_warn">建议输入200字以内</p>

        <%--  <div class="help_check">
              <input id="help_txt_check" type="checkbox"
                     <s:if test="attentionRes.textResources.addHelp==true">checked</s:if>/>
              <label for="help_txt_check">自动添加帮助说明</label>
              <input id="header_footer_check" type="checkbox"
                     <s:if test="attentionRes.textResources.addHeader==true">checked</s:if>/>
              <label for="header_footer_check">自动添加页面和页脚</label>
          </div>--%>
        <div class="compelt_button"><a
                href="javascript:saveNoPirze(<s:property  value="attentionRes.textResources.id"/>)"
                class="btnGreen">修改</a></div>
    </div>
    <!--预览窗口_Begin-->
    <div class="preview_win">
        <input id="yemei_1_pre" type="text" class="page_head"/>
        <textarea id="close_text_2" class="page_middle"><s:property
                value="attentionRes.textResources.message"/></textarea>
        <input id="yejiao_1_pre" type="text" class="page_bottom"/>
    </div>
    <!--预览窗口_End-->
</div>
<!--关注有奖_关的状态_End-->
<!--关注有奖_开启状态_Begin-->
<div id="guanzhu_open"  <s:if
        test="attentionRes.userWeiXin.focusLucky==true"> style="display:block;"</s:if><s:else> style="display:none;"</s:else>>
    <!--中奖设置_Begin-->
    <div class="award_block">
        <ul>
            <li><input id="award_1" type="radio" name="award"
                    <s:if test="attentionRes.foucsLucky.absoluteLucky==true"> checked="checked"</s:if>
                       onclick="r_hide();" />
                <label for="award_1">100%有奖</label></li>
            <li><input id="award_2" type="radio" name="award"
                    <s:if test="attentionRes.foucsLucky.absoluteLucky==false"> checked="checked"</s:if>
                       onclick="r_show();"/>
                <label for="award_2">非100%有奖</label></li>
        </ul>
    </div>
    <!--中奖设置_End-->
    <!--100%中奖板块_Begin-->
    <div id="all"
         <s:if test="attentionRes.foucsLucky.absoluteLucky==true">style="display:block;" </s:if>
         <s:else>style="display:none;"</s:else>>
        <div class="respond_left">
            <textarea id="close_text_3" class="text_block1" onkeyup="syn_6();"><s:property
                    value="attentionRes.foucsLucky.luckyMessage"/></textarea>

            <p class="text_warn">建议输入200字以内 <s:property value="attentionRes.foucsLucky.addHelp"/></p>

            <%-- <div class="help_check">
                 <input id="help_txt_check_2" type="checkbox"
                        <s:if test="attentionRes.foucsLucky.addHelp==true">checked</s:if>/>
                 <label for="help_txt_check_2">自动添加帮助说明</label>
                 <input id="header_footer_check2" type="checkbox"
                        <s:if test="attentionRes.foucsLucky.addHeader==true">checked</s:if>/>
                 <label for="header_footer_check2">自动添加页面和页脚</label>
             </div>--%>
            <div class="compelt_button"><a
                    href="javascript:saveAbsoluePrize(<s:property  value="attentionRes.foucsLucky.id"/>);"
                    class="btnGreen">修改</a></div>
        </div>
        <!--预览窗口_Begin-->
        <div class="preview_win">
            <input id="yemei_2_pre" class="page_head" readonly="readonly"/>
            <textarea id="close_text_3_pre" class="page_middle" readonly="readonly"><s:property
                    value="attentionRes.foucsLucky.luckyMessage"/></textarea>
            <input id="yejiao_2_pre" class="page_bottom" readonly="readonly"/>
        </div>
        <!--预览窗口_End-->
    </div>
    <!--100%中奖板块_End-->
    <!--非100%中奖板块_Begin-->
    <div id="not_all"  <s:if test="attentionRes.foucsLucky.absoluteLucky==false">style="display:block;" </s:if>
    <s:else>style="display:none;"</s:else>">
        <div class="respond_left_2">
            <div class="award_setting">
                <ul>
                    <li><input type="radio" id="award_setting_1" name="award_setting" onchange="award_setting_fun()"
                               <s:if test="attentionRes.foucsLucky.luckyNumber!=null">checked="checked" </s:if>/>
                        <label for="award_setting_1">幸运尾数</label>
                    </li>
                    <li><input type="radio" id="award_setting_2" name="award_setting" onchange="award_setting_fun()"
                               <s:if test="attentionRes.foucsLucky.luckyProbability!=null">checked="checked"</s:if>/>
                         <label for="award_setting_2">随机概率</label>
                    </li>
                </ul>
                <input type="text" class="setting_num" id="settingNum"
                        <s:if test="attentionRes.foucsLucky.luckyNumber!=null"> value="<s:property
                                value="attentionRes.foucsLucky.luckyNumber"/>"</s:if>
                       <s:elseif
                               test="attentionRes.foucsLucky.luckyProbability!=null">value="<s:property value="attentionRes.foucsLucky.luckyProbability"/>"
                </s:elseif>/><span id="settingNum_span" style="line-height:35px;visibility:hidden">%</span>
                <span class="setting_num_txt"></span>
            </div>
            <!--左边_Begin-->
            <div class="zhongjiang_left">
                <h3 style=" float:left; width:320px;margin:12px 0 6px 0;">中奖时的回复</h3>
                <textarea id="close_text_4" class="text_block_new" onkeyup="syn_9();"><s:property
                        value="attentionRes.foucsLucky.luckyMessage"/></textarea>
                <p class="text_warn">建议输入200字以内</p>
                <!--中奖回复预览窗口_Begin-->
                <div class="preview_win_2">
                    <textarea id="close_text_4_pre" class="page_middle_2" readonly="readonly"><s:property
                            value="attentionRes.foucsLucky.luckyMessage"/></textarea>
                </div>
                <!--中奖回复预览窗口_End-->
            </div>
            <!--左边_End-->

            <!--右边_Begin-->
            <div class="zhongjiang_right">
                <h3 style=" float:left;margin:12px 0 6px 0;">未中奖时的回复</h3>
                <textarea id="close_text_5" class="text_block_new" onkeyup="syn_10();"><s:property
                        value="attentionRes.foucsLucky.notLuckyMessage"/></textarea>
                <p class="text_warn">建议输入200字以内</p>
                <!--未中奖预览窗口_Begin-->
                <div class="preview_win_2">
                    <textarea id="close_text_5_pre" class="page_middle_2" readonly="readonly"><s:property
                            value="attentionRes.foucsLucky.notLuckyMessage"/></textarea>
                </div>
                <!--未中奖预览窗口_End-->
            </div>
            <!--右边_End-->
            <div class="compelt_button"><a href="javascript:saveNoAbsoulePrize(<s:property  value="attentionRes.foucsLucky.id"/>)" class="btnGreen">完成</a></div>
        </div>
    </div>
    <!--非100%中奖板块_End-->
</div>
<!--关注有奖_开启状态_End-->

