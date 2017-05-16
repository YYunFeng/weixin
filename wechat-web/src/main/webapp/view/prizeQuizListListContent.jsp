<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-26
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<link href="../css/servey.css" rel="stylesheet" type="text/css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        servey.uid = '<s:property value="#session.weixinmangerweixinaccount.Id"/>';
        servey.token = '';
    });
</script>
<h3 class="page-sub-hd">有奖竞答列表&nbsp;(共 <s:property value="componentList.size()"/> 个)</h3>
<%--<div class="z group page-nav">
    <div class="pageNavigator right">
        <span>
            <a href="javascript:;" class="prePage textDisable">
                上一页
            </a>
        </span>
        <span class="pageNum">
            &nbsp;&nbsp;1&nbsp;/&nbsp;1&nbsp;&nbsp;
        </span>
        <span>
            <a href="javascript:;" class="nextPage textDisable">
                下一页
            </a>
        </span>
        <span class="go">
            <input data-baseurl="/cgi-bin/operate_appmsg?token=916984087&amp;lang=zh_CN&amp;sub=list&amp;type=10&amp;subtype=3&amp;t=wxm-appmsgs-list-new&amp;pagesize=10"
                   onkeypress="WXM.Plugins.pageJump(this, event, 1);" class="pageIdxInput"
                   type="text">
            <button data-baseurl="/cgi-bin/operate_appmsg?token=916984087&amp;lang=zh_CN&amp;sub=list&amp;type=10&amp;subtype=3&amp;t=wxm-appmsgs-list-new&amp;pagesize=10"
                    onclick="WXM.Plugins.pageJump(this, event, 1);" class="btnGrayS">
                跳转
            </button>
        </span>
    </div>
</div>--%>
<div class="page-bd">
    <div class="tj msg-list">
        <div id="first_col" class="b-dib vt msg-col">
            <div id="addAppmsg" class="tc add-access">
                <span class="dib vm th add-tip" style="cursor: pointer;" onclick="addPrizeQuiz();">新建消息入口</span>
            </div>
            <div id="appmsglistleft">
                <s:iterator value="componentList" status="component">
                    <s:if test="#component.odd">
                        <div class="msg-item-wrapper" id="appmsg10000014" data-appid="10000014"
                             data-create-time="2013-04-16">
                            <div id="appmsgItem1" class="msg-item appmsgItem">
                                <h4 class="msg-t">
                                    <s:property value="title"/>
                                </h4>

                                <div class="title_button"
                                     onclick="servey.openTopicListWind('<s:property value="Id"/>')">+题目
                                </div>

                                <p class="msg-meta"><span class="msg-date"> <s:date name="created"
                                                                                    format="yyyy-MM-dd"/></span></p>

                                <div class="cover">
                                    <p class="default-tip" style="display:none">封面图片</p>
                                    <img src="<s:property value="pic"/>"
                                         class="i-img" style="">
                                </div>
                                <p class="msg-text"><s:property value="intro"/></p>
                            </div>
                            <div class="msg-opr">
                                <ul class="f0 msg-opr-list">
                                    <li class="b-dib opr-item">
                                        <a class="block tc opr-btn edit-btn"
                                           href="javascript:modifyPrizeQuiz(<s:property value="Id"/>)">
                                            <span class="th vm dib opr-icon edit-icon">编辑</span>
                                        </a>
                                    </li>
                                    <li class="b-dib opr-item">
                                        <a class="block tc opr-btn del-btn"
                                           href="javascript:deletePrizeQuiz(<s:property value="Id"/>);"
                                           data-mid="10000014">
                                            <span class="th vm dib opr-icon del-icon">删除</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="msg-hover-mask">
                            </div>
                            <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
                        </div>
                    </s:if>
                </s:iterator>
            </div>
        </div>
        <div id="second_col" class="b-dib vt msg-col">
            <s:iterator value="componentList" status="component">
                <s:if test="#component.even">
                    <div class="msg-item-wrapper" id="appmsg10000009" data-appid="10000009"
                         data-create-time="2013-04-16">
                        <div class="msg-item appmsgItem">
                            <h4 class="msg-t"><s:property value="title"/></h4>

                            <p class="msg-meta"><span class="msg-date"><s:date name="created"
                                                                               format="yyyy-MM-dd"/></span></p>

                            <div class="title_button"
                                 onclick="servey.openTopicListWind('<s:property value="Id"/>')">+题目
                            </div>
                            <div class="cover">
                                <p class="default-tip" style="display:none">封面图片</p>
                                <img src="<s:property value="pic"/>"
                                     class="i-img" style="">
                            </div>
                            <p class="msg-text"><s:property value="intro"/></p>
                        </div>
                        <div class="msg-opr">
                            <ul class="f0 msg-opr-list">
                                <li class="b-dib opr-item">
                                    <a class="block tc opr-btn edit-btn"
                                       href="javascript:modifyPrizeQuiz(<s:property value="Id"/>)">
                                        <span class="th vm dib opr-icon edit-icon">编辑</span>
                                    </a>
                                </li>
                                <li class="b-dib opr-item">
                                    <a class="block tc opr-btn del-btn"
                                       href="javascript:deletePrizeQuiz(<s:property value="Id"/>);"
                                       data-mid="10000009">
                                        <span class="th vm dib opr-icon del-icon">删除</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="msg-hover-mask"></div>
                        <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
                    </div>
                </s:if>
            </s:iterator>
        </div>
        <div class="b-dib" style="width:100%;height:0;overflow:hidden;font-size:0;"></div>
    </div>
</div>




<!---start添加问卷调查题目-->
<div id="addTopicWind" style="display:none">
    <div class="msg-editer">
        <div>
            <label for="" class="block">题目名称</label>
            <input type="hidden" value="" id="survey_id"/>
            <input type="hidden" value="" id="survey_type"/>
            <input type="hidden" value="" id="topic_id" name="topic_id"/>
            <input type="text" class="msg-input" id="s_title" name="s_title" value="">
        </div>
        <div>
            <div class="block" style="margin-top:5px; margin-bottom:5px;">
                题目类型&nbsp;&nbsp;&nbsp;&nbsp;
                单选<input name="i_type" class="i_type" id="i_type" type="checkbox" value="0" checked="checked" onclick="servey.selTopicType(this)"/>
                多选<input name="i_type" class="i_type" id="i_type" type="checkbox" value="1" onclick="servey.selTopicType(this)"/>

                <span class="otherButton">问答<input name="i_type" class="i_type" id="i_type" type="checkbox" value="2" onclick="servey.selTopicType(this)"/></span>
            </div>
        </div>


        <div id="div_sel">
            <div>
                <label for="" class="block">选项A</label>
                <input type="text" class="msg-input" id="s_selOne" name="s_selOne" value="" style="width:350px;">
                 
                 <span class="answerSpan">答案：
                 <input name="s_c_answer" type="checkbox" value="" class="c_checkbox" style="display:none"/>
                 <input name="s_r_answer" type="radio" value="1" class="c_radio"/>
                 </span>
            </div>

            <div>
                <label for="" class="block">选项B</label>
                <input type="text" class="msg-input" id="s_selTwo" name="s_selTwo" value="" style="width:350px;">
                 
                 <span class="answerSpan">答案：<input name="s_c_answer" type="checkbox" value="" class="c_checkbox" style="display:none"/>
                 <input name="s_r_answer" type="radio" value="2" class="c_radio"/>
                 </span>
            </div>

            <div>
                <label for="" class="block">选项C</label>
                <input type="text" class="msg-input" id="s_selThree" name="s_selThree" value="" style="width:350px;">
                 
                 <span class="answerSpan">
                 答案：
                 <input name="s_c_answer" type="checkbox" value="" class="c_checkbox" style="display:none"/>
                 <input name="s_r_answer" type="radio" value="3" class="c_radio"/>
                 </span>
            </div>

            <div>
                <label for="" class="block">选项D</label>
                <input type="text" class="msg-input" id="s_selFour" name="s_selFour" value="" style="width:350px;">
                 <span class="answerSpan">
                 答案：
                 <input name="s_c_answer" type="checkbox" value="" class="c_checkbox" style="display:none"/>
                 <input name="s_r_answer" type="radio" value="4" class="c_radio" />
                 </span>
            </div>

            <div>
                <label for="" class="block">选项E</label>
                <input type="text" class="msg-input" id="s_selFive" name="s_selFive" value="" style="width:350px;">
                 <span class="answerSpan">
                 答案：
                 <input name="s_c_answer" type="checkbox" value="" class="c_checkbox" style="display:none"/>
                 <input name="s_r_answer" type="radio" value="5" class="c_radio"/>
                 </span>
            </div>

            <div class="otherDiv">
                <label for="" class="block">其 它</label>
                <input type="text" class="msg-input_" id="s_other" name="s_other" value="" style="width:350px;">
            </div>

        </div>
        <p class="tc msg-btn">
            <a href="javascript:void(0);" id="topic_save" class="btnGreen" onclick="servey.submitTopic()">保  存</a>
        </p>
    </div>
</div>
<!---end添加问卷调查题目-->

<!---start题目列表-->
<div id="div_topicList" style="display:none">
    <div class="list">
        <div id="div_topicButton"></div>
        <ul id="t_list">
            <li>
                <div class="li_title" style="width:170px;">题目</div>
                <div class="li_title">内容</div>
                <div class="li_title_time">类型</div>
                <div class="li_title_button" style="width:80px;">操 作</div>
            </li>
            <li id="t_loading"><div class="loading">正在加载....</div></li>
        </ul>
    </div>
    <div style="clear:none;"></div>
</div>
<!---end题目列表-->




