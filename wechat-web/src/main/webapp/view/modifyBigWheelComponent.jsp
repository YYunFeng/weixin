<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-22
  Time: 下午12:04
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript" src="../js/uploadify-v2.1.4/swfobject.js"></script>
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
            <div class="msg-item-wrapper" data-appid="10000014">
                <div class="msg-item appmsgItem">
                    <h4 class="msg-t"><a href="#" class="i-title" target="_blank" id="moduletitleM"><s:property
                            value="bigWheelComponentRes.componentRes.title"/></a></h4>
                    <s:bean var="now" name="java.util.Date"/>
                    <p class="msg-meta"><span class="msg-date"><s:date name="#now" format="yyyy-MM-dd"/></span></p>

                    <div class="cover">
                        <p class="default-tip" style="display:none">封面图片</p>
                        <img src="<s:property value="bigWheelComponentRes.componentRes.pic"/>"
                             class="i-img" style="" id="previewPic">
                        <input type="hidden" value="<s:property value="bigWheelComponentRes.componentRes.picPath"/>"
                               id="bigWheelPic"/>
                    </div>
                    <p class="msg-text" id="modulecontentM"><s:property
                            value="bigWheelComponentRes.componentRes.intro"/></p>
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
                <input type="text" placeholder="请输入标题" id="moduletitle"
                       value="<s:property value ="bigWheelComponentRes.componentRes.title"/>"/>
            </p>

            <p class="p_new">
                <font>封面</font>

            <div>
                <div class="p_new_btn_l p_new_btn_hover" id="updata_img_btn_d" style="cursor: pointer"
                     onclick="javascript:(function(){toolBigWheelComponet.moduleUpdateimg('d');jQuery('#upload_block').hide();})()">
                    默认封面
                </div>
                <div class="p_new_btn_r" id="updata_img_btn_u" style="cursor: pointer"
                     onclick="javascript:(function(){toolBigWheelComponet.moduleUpdateimg('u');jQuery('#upload_block').show();})()">
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
                <textarea placeholder="请输入摘要" id="modulecontent"><s:property
                        value="bigWheelComponentRes.componentRes.intro"/></textarea>
            </p>
            <p class="p_new">
                <font>结束时间<span style="font-size: 12px; color: #999;">(选填项。如果不填，组件无结束时间)</span></font>
                <input type="text" id="endTime" class="Wdate" style="width:170px; height:20px;color: #73AE1F; border: #73AE1F 1px solid; "
                       onFocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<s:date name="bigWheelComponentRes.componentRes.endTime"
                        format="yyyy-MM-dd HH:MM:ss"/>"/>
            </p>
        </div>
        <div class="b-dib" style="width:100%;height:0;overflow:hidden;font-size:0;"></div>
        <div class="b-dib vt msg-col">
            <div class="msg-item-wrapper" data-appid="10000014" data-create-time="2013-04-16">
                <div class="msg-item appmsgItem">
                    <h4 class="msg-t"><a href="#" class="i-title" target="_blank">网页预览</a></h4>


                    <div>
                        <div class="cover_change">
                            <table class="titletable">
                                <tr class="titletr">
                                    <td class="titleclass" id="titleHTML5See">
                                        幸运大转盘
                                    </td>
                                </tr>
                            </table>
                            <div class="contentclass">
                                <div><b>奖项说明：</b></div>
                            </div>
                            <img src="../images/all_1.jpg" class="i-img">
                        </div>
                        <div class="contentclass1">
                            <div><b>一等奖</b>：<span id="moduleprize1M"><s:property
                                    value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].prizeName"/></span>（<span id="moduleprize1NumM"> <s:property
                                    value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].count"/> </span>名）</div>
                            <div><b>二等奖</b>：<span id="moduleprize2M"><s:property
                                    value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].prizeName"/></span>（<span id="moduleprize2NumM"> <s:property
                                    value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].count"/> </span>名）</div>
                            <div><b>三等奖</b>：<span id="moduleprize3M"><s:property
                                    value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].prizeName"/></span>（<span id="moduleprize3NumM"><s:property
                                    value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].count"/>  </span>名）</div>
                            <div id="moduleprizeContentM"></div>
                            <div>每名参与者最多可以抽取 <b id="moduleExtractionNumM"></b> 次</div>

                        </div>

                    </div>



                </div>
                <div class="msg-opr">
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
                <font>奖项设置</font>
            </p>

            <p class="p_new">

            <div class="p_new_rect">一等奖</div>
            <div class="p_new_rect_r">
                <input type="text" placeholder="请输入奖项内容" id="moduleprize1" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].prizeName"/> "/>
                <input type="text" class="p_new_rect_input" placeholder="请输入中奖概率" id="moduleprize1Probability" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].probability"/> "/>%
                <input type="text" readonly="readonly" class="p_new_rect_input" placeholder="请输入中奖数量" id="moduleprize1Num" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].count"/>"/>
                <span class="prizeNum">中奖次数：<s:property
                         value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].count-bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].reserveCount"/>个</span>
                <input type="hidden" id="bigWheelRingLuckyPrizeList" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[0].Id"/>"/>
            </div>
            <div class="clear"></div>
            </p>
            <p class="p_new">

            <div class="p_new_rect">二等奖</div>
            <div class="p_new_rect_r">
                <input type="text" placeholder="请输入奖项内容" id="moduleprize2" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].prizeName"/>"/>
                <input type="text" class="p_new_rect_input" placeholder="请输入中奖概率" id="moduleprize2Probability" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].probability"/>"/>%
                <input type="text" readonly="readonly" class="p_new_rect_input" placeholder="请输入中奖数量" id="moduleprize2Num" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].count"/>"/>
                <span class="prizeNum">中奖次数：<s:property
                         value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].count-bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].reserveCount"/>个</span>
                <input type="hidden" id="bigWheelRingLuckyPrizeList1" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[1].Id"/>"/>
            </div>
            <div class="clear"></div>
            </p>
            <p class="p_new">

            <div class="p_new_rect">三等奖</div>
            <div class="p_new_rect_r">
                <input type="text" placeholder="请输入奖项内容" id="moduleprize3" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].prizeName"/>"/>
                <input type="text" class="p_new_rect_input" placeholder="请输入中奖概率" id="moduleprize3Probability" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].probability"/>"/>%
                <input type="text"  readonly="readonly" class="p_new_rect_input" placeholder="请输入中奖数量" id="moduleprize3Num" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].count"/>"/>
                <span class="prizeNum">中奖次数：<s:property
                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].count-bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].reserveCount"/>个</span>
                <input type="hidden" id="bigWheelRingLuckyPrizeList2" value="<s:property
                                        value="bigWheelComponentRes.bigWheelRingLuckyPrizeList[2].Id"/>"/>
            </div>
            <div class="clear"></div>
            </p>
            <p class="p_new">

            <div class="p_new_rect p_new_rect_short">次数</div>
            <div class="p_new_rect_r">
                每名参与者抽取次数<br/>
                <input type="text" class="p_new_rect_input" placeholder="请输入抽取次数" id="moduleExtractionNum" value="<s:property
                                        value="bigWheelComponentRes.componentRes.luckyCount"/>"/>次
            </div>
            <div class="clear"></div>
            </p>
            <p class="p_new">
                <font> <input type="checkbox" style="width:20px;height:10px;" <s:if test="bigWheelComponentRes.componentRes.needContact">checked="checked"</s:if> id="needContanct"/>是否需要中奖人填写联系信息</font>
            <div class="clear"></div>
            </p>
            <p class="p_new">

            <div class="p_new_rect">奖项说明</div>
            <div class="p_new_rect_r">
                <textarea class="p_new_rect_r_textarea" id="moduleprizeContent"><s:property
                        value="bigWheelComponentRes.componentRes.luckyIntro"/></textarea>
            </div>
            <div class="clear"></div>
            </p>
        </div>
        <div class="b-dib" style="width:100%;height:0;overflow:hidden;font-size:0;"></div>
        <div id="first_col" class="b-dib vt msg-col">
            <div class="msg-item-wrapper"  data-appid="10000014" data-create-time="2013-04-16" style="display: none;">
                <div id="appmsgItem1" class="msg-item appmsgItem">
                    <h4 class="msg-t"><a href="#" class="i-title">弹出框预览</a></h4>

                    <div id="moduletelM"><s:property
                            value="bigWheelComponentRes.componentRes.telphone"/></div>
                    <div id="moduleaddressM"><s:property
                            value="bigWheelComponentRes.componentRes.address"/></div>
                    <div id="modulebeizhuM"><s:property
                            value="bigWheelComponentRes.componentRes.remark"/></div>
                </div>
                <div class="msg-opr">
                </div>
                <div class="msg-hover-mask"></div>
                <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
            </div>
        </div>
        <div id="second_col" class="b-dib vt msg-col" style="">
            <div>
            </div>
            <div>
            </div>
            <p class="p_new">
                <font>举办方联系方式</font>
            </p>

            <p class="p_new">

            <div class="p_new_rect">联系方式</div>
            <div class="p_new_rect_r">
                <input type="text" placeholder="请输入电话" id="moduletel" value="<s:property
                        value="bigWheelComponentRes.componentRes.telphone"/>"/>
                <input type="text" placeholder="请输入联系地址" id="moduleaddress" value="<s:property
                        value="bigWheelComponentRes.componentRes.address"/>"/>
                <textarea class="p_new_rect_r_textarea" placeholder="备注" id="modulebeizhu"><s:property
                        value="bigWheelComponentRes.componentRes.remark"/></textarea>
            </div>
            <div class="clear"></div>
            </p>
        </div>
        <div class="b-dib" style="width:100%;height:0;overflow:hidden;font-size:0;"></div>
    </div>
    <p class="tc msg-btn">
        <a href="javascript:void(0);" id="save" class="btnGreen" onclick="toolBigWheelComponet.modifyBigWheelComponent(<s:property
                value="bigWheelComponentRes.componentRes.componentId"/>,<s:property
                value="bigWheelComponentRes.componentRes.componentLuckyId"/>)">完成</a>
    </p>
</div>
<div class="clr"></div>

