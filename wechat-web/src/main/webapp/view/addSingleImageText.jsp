<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-6
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript" src="../js/uploadify-v2.1.4/swfobject.js"></script>
<script type="text/javascript" src="../js/uploadify-v2.1.4/jquery.uploadify.v2.1.4.min.js"></script>
<link href="../js/uploadify-v2.1.4/uploadify1.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/operatesingle_JS.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $().ready(function () {
        uploadSingleImageTexePic();
    });
</script>
<div class="z oh msg-edit">
    <div class="left msg-preview">
        <div class="msg-item-wrapper" id="appmsg" data-appid="" data-create-time="2013-04-18">
            <div id="appmsgItem1" class="msg-item appmsgItem sub-msg-opr-show">
                <h4 class="msg-t"><span class="i-title" id="titleM">标题 </span></h4>

                <s:bean var="now" name="java.util.Date"/>
                <p class="msg-meta"><span class="msg-date"><s:date name="#now" format="yyyy-MM-dd"/></span></p>

                <div class="cover">
                    <p class="default-tip" id="picTitle">封面图片</p>
                    <img src="" class="i-img" id="previewPic">
                </div>
                <p class="msg-text" id="descM"></p>
            </div>
            <div class="msg-opr">
                <ul class="f0 msg-opr-list">
                    <li class="b-dib opr-item"><a class="block tc opr-btn edit-btn"
                                                  href="/cgi-bin/operate_appmsg?token=817058715&amp;lang=zh_CN&amp;sub=edit&amp;t=wxm-appmsgs-edit-new&amp;type=10&amp;subtype=3&amp;AppMsgId=&amp;lang=zh_CN"><span
                            class="th vm dib opr-icon edit-icon">编辑</span></a></li>
                    <li class="b-dib opr-item"><a class="block tc opr-btn del-btn" href="javascript:;" data-mid=""><span
                            class="th vm dib opr-icon del-icon">删除</span></a></li>
                </ul>
            </div>
            <div class="msg-hover-mask"></div>
            <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
        </div>
    </div>

    <div class="msg-edit-area" id="msgEditArea" style="margin-top: 31px;">
        <div class="rel msg-editer-wrapper">
            <div class="msg-editer">
                <div>
                    <label class="block">标题</label>
                    <input type="text" class="msg-input" id="title" value="">
                    <label class="block"><span id="upload-tip"
                                               class="upload-tip r">大图片建议尺寸：720像素 * 400像素</span>封面</label>

                    <div>
                        <div class="oh z cover-hd">
                            <input type="file" style="padding-bottom: 20px; height:25px;"
                                   id="singleImageTextUploadpic"/>
                            <input type="hidden" id="singleImagePic"/>
                        </div>
                        <div id="fileQueue" style="width:242px;"></div>

                    </div>
                    <a id="desc-block-link" style="padding-top: 10px;"
                       href="javascript:(function(){jQuery('#desc-block').show();jQuery('#desc-block-link').hide()})()"
                       class="url-link block">添加摘要</a>

                    <div id="desc-block" class="none" style="display: none;">
                        <label class="block">摘要</label>
                        <textarea name="" id="desc" class="msg-txta"></textarea>
                    </div>
                </div>
                <label class="block">正文</label>
                <textarea class="msg-txta" style="height:320px;" id="contentTextarea"></textarea>

                <div class="oh z shadow">
                    <span class="left ls"></span><span class="right rs"></span>
                </div>
                <span class="abs msg-arrow a-out" style="margin-top: 0px;"></span>
                <span class="abs msg-arrow a-in" style="margin-top: 0px;"></span>


            </div>
            <p class="tc msg-btn">
                <a href="javascript:;" id="save" class="btnGreen" onclick="finish_operate_addJS()">完成</a>
            </p>
        </div>

    </div>
</div>