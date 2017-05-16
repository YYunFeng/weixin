<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-3
  Time: 下午1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-22
  Time: 下午12:04
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript" src="../js/uploadify-v2.1.4/swfobject.js"></script>
<script type="text/javascript" src="/js/toolSurvey.js"></script>
<script type="text/javascript" src="../js/uploadify-v2.1.4/jquery.uploadify.v2.1.4.min.js"></script>
<link href="../js/uploadify-v2.1.4/uploadify.css" rel="stylesheet" type="text/css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $().ready(function () {
        uploadPic();
    });
</script>
<div class="page-bd">
    <div class="tj msg-list">
        <div id="first_col1" class="b-dib vt msg-col">
            <div class="msg-item-wrapper" data-appid="10000014" data-create-time="2013-04-16">
                <div class="msg-item appmsgItem">
                    <h4 class="msg-t"><a class="i-title" id="moduletitleM"><s:property value="surveyRes.title"/></a></h4>
                    <s:bean var="now" name="java.util.Date"/>
                    <p class="msg-meta"><span class="msg-date"><s:date name="#now" format="yyyy-MM-dd"/></span></p>

                    <div class="cover">
                        <p class="default-tip" style="display:none">封面图片</p>
                        <img src="<s:property value="surveyRes.picPath"/>"
                             class="i-img" style="" id="previewPic">
                        <input type="hidden" value="<s:property value="surveyRes.pic"/>" id="bigWheelPic"/>
                    </div>
                    <p class="msg-text" id="modulecontentM"></p>
                </div>
                <div class="msg-hover-mask"></div>
                <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
            </div>
        </div>

        <div class="b-dib vt msg-col" style="">
            <div>
            </div>
            <div>
            </div>
            <p class="p_new">
                <font>标题</font>
                <input type="text" placeholder="请输入标题" id="title" value="<s:property value="surveyRes.componentTitle"/>"/>
            </p>

            <p class="p_new">
                <font>封面</font>

            <div>
                <div class="p_new_btn_l p_new_btn_hover" id="updata_img_btn_d" style="cursor: pointer"
                     onclick="javascript:(function(){toolSurvey.moduleUpdateimg('d');jQuery('#upload_block').hide();})()">
                    默认封面
                </div>
                <div class="p_new_btn_r" id="updata_img_btn_u" style="cursor: pointer"
                     onclick="javascript:(function(){toolSurvey.moduleUpdateimg('u');jQuery('#upload_block').show();})()">
                    自定义封面
                </div>
                <div class="clear"></div>
            </div>
            </p>
            <p class="p_new" id="upload_block" style="display: none;">
                <input type="file" style="padding-bottom: 20px; height:25px;" id="uploadify"/>

            <div id="fileQueue" style="width:560px;"></div>
            </p>
            <p class="p_new">
                <font>摘要</font>
                <textarea placeholder="请输入摘要" id="surveyContent"><s:property value="surveyRes.intro"/></textarea>
            </p>
        </div>
        <div class="b-dib vt msg-col">
        </div>
        <div class="b-dib vt msg-col" style="">
           <%-- <p class="p_new">
                <font>属性</font>
                <!--中奖设置_Begin-->
            <ul>
                <li><input id="award_1" type="radio" name="award" onclick="type_hide()" <s:if test="surveyRes.type==1">checked="checked" </s:if>/>
                    <label for="award_1" onclick="">有奖竞答</label></li>
                <li><input id="award_2" type="radio" name="award" onclick="type_show()" <s:if test="surveyRes.type==0">checked="checked" </s:if>/>
                    <label for="award_2">问卷调查</label></li>
            </ul>
            </p>--%>

            <p class="p_new" id="probabilityShow">
                <font>中奖概率</font>
                <input placeholder="请输入中奖概率" id="probability" type="text" value="<s:property value="surveyRes.probability"/>"/>
            </p>

            <p class="p_new">
                <font>奖项总数</font>
                <input placeholder="请输入奖项总数" id="count" type="text" value="<s:property value="surveyRes.count"/>"/>
            </p>
        </div>
        <div class="b-dib" style="width:100%;height:0;overflow:hidden;font-size:0;"></div>
    </div>
    <p class="tc msg-btn">
        <a href="javascript:void(0);" id="save" class="btnGreen" onclick="toolSurvey.modifySurvey(<s:property value="surveyRes.componentId"/>,<s:property value="surveyRes.surveyId"/>);">完成</a>
    </p>
</div>
<div class="clr"></div>

