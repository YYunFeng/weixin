<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-7
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript" src="../js/uploadify-v2.1.4/swfobject.js"></script>
<script type="text/javascript" src="../js/uploadify-v2.1.4/jquery.uploadify.v2.1.4.min.js"></script>
<link href="../js/uploadify-v2.1.4/uploadify1.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/operatemore_JS.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $().ready(function () {
        uploadManyImageTexePic(1);
    });
</script>
<div class="z oh msg-edit">
<div class="left msg-preview">
    <div class="msg-item-wrapper" id="appmsg" data-appid="" data-create-time="2013-04-18">
        <div class="msg-item multi-msg">
            <div id="appmsgItem1" class="appmsgItem">
                <s:bean var="now" name="java.util.Date"/>
                <p class="msg-meta">
                    <span class="msg-date"><s:date name="#now" format="yyyy-MM-dd"/></span>
                </p>

                <div class="cover">
                    <p class="default-tip" id="default_appmsgItem1" style="">封面图片</p>
                    <h4 class="msg-t"><span class="i-title" id="title_appmsgItem1"></span></h4>
                    <img src="" class="i-img" id="i_img_appmsgItem1" style="display:none">
                </div>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem2">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem2" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem2" style="display:none">
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem2"></span>
                </h4>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem3" style="display:none;">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem3" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem3" style="display:none">
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem3"></span>
                </h4>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem4" style="display:none;">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem4" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem4" style="display:none">
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem4"></span>
                </h4>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem5" style="display:none;">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem5" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem5" style="display:none">
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem5"></span>
                </h4>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem6" style="display:none;">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem6" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem6" style="display:none">
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem6"></span>
                </h4>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem7" style="display:none;">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem7" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem7" style="display:none">
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem7"></span>
                </h4>
            </div>

            <div class="rel sub-msg-item appmsgItem" id="appmsgItem8" style="display:none;">
            	<span class="thumb">
                	<span class="default-tip" id="default_appmsgItem8" style="">缩略图</span>
                    <img src="" class="i-img" id="i_img_appmsgItem8" style="display:none"/>
                </span>
                <h4 class="msg-t">
                    <span class="i-title" id="title_appmsgItem8"></span>
                </h4>
            </div>

        </div>


        <div class="msg-hover-mask"></div>
        <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
    </div>
</div>


<div class="msg-edit-area" id="msgEditArea" style="margin-top: 31px;">
<div class="pagehtml">
    <div class="pagehtml_rect p_new_btn_hover" id="tuwencont1" onclick="operatemore_JS.selectPage(1)">第 1 张<br/>图
        文
    </div>
    <div class="pagehtml_rect" id="tuwencont2" onclick="operatemore_JS.selectPage(2)">第 2 张<br/>图 文</div>
    <div class="pagehtml_rect border-dotted" id="tuwencont3" onclick="operatemore_JS.selectPage(3)">第 3 张<br/>图 文
    </div>
    <div class="pagehtml_rect hide" id="tuwencont4" onclick="operatemore_JS.selectPage(4)">第 4 张<br/>图 文</div>
    <div class="pagehtml_rect hide" id="tuwencont5" onclick="operatemore_JS.selectPage(5)">第 5 张<br/>图 文</div>
    <div class="pagehtml_rect hide" id="tuwencont6" onclick="operatemore_JS.selectPage(6)">第 6 张<br/>图 文</div>
    <div class="pagehtml_rect hide" id="tuwencont7" onclick="operatemore_JS.selectPage(7)">第 7 张<br/>图 文</div>
    <div class="pagehtml_rect hide" id="tuwencont8" onclick="operatemore_JS.selectPage(8)">第 8 张<br/>图 文</div>
</div>

<div class="rel msg-editer-wrapper">
<div class="msg-editer" id="tuwen1">
    <label class="block">图文1：<br/>标题</label>
    <input type="text" class="msg-input" id="title1" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：720像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem1" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic1"/>
        </div>
        <div id="fileQueue1" style="width:242px;"></div>
    </div>

    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody1"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: -30px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: -30px;"></span>
</div>


<div class="msg-editer" id="tuwen2" style="display:none;">
    <label class="block">图文2：<br/>标题</label>
    <input type="text" class="msg-input" id="title2" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem2" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic2"/>
        </div>
        <div id="fileQueue2" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody2"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 45px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 45px;"></span>
</div>


<div class="msg-editer" id="tuwen3" style="display:none;">
    <label class="block">图文3：<br/>标题</label>
    <input type="text" class="msg-input" id="title3" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem3" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic3"/>
        </div>
        <div id="fileQueue3" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody3"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 140px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 140px;"></span>
</div>


<div class="msg-editer" id="tuwen4" style="display:none;">
    <label class="block">图文4：<br/>标题</label>
    <input type="text" class="msg-input" id="title4" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem4" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic4"/>
        </div>
        <div id="fileQueue4" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody4"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 240px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 240px;"></span>
</div>

<div class="msg-editer" id="tuwen5" style="display:none;">
    <label class="block">图文5：<br/>标题</label>
    <input type="text" class="msg-input" id="title5" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem5" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic5"/>
        </div>
        <div id="fileQueue5" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody5"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 340px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 340px;"></span>
</div>

<div class="msg-editer" id="tuwen6" style="display:none;">
    <label class="block">图文6：<br/>标题</label>
    <input type="text" class="msg-input" id="title6" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem6" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic6"/>
        </div>
        <div id="fileQueue6" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody6"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 440px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 440px;"></span>
</div>

<div class="msg-editer" id="tuwen7" style="display:none;">
    <label class="block">图文7：<br/>标题</label>
    <input type="text" class="msg-input" id="title7" value="">
    <label class="block"><span class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem7" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic7"/>
        </div>
        <div id="fileQueue7" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody7"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 530px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 530px;"></span>
</div>

<div class="msg-editer" id="tuwen8" style="display:none;">
    <label class="block">图文8：<br/>标题</label>
    <input type="text" class="msg-input" id="title8" value="">
    <label class="block"><span id="upload-tip" class="upload-tip r">大图片建议尺寸：400像素 * 400像素</span>封面</label>
    <input type="hidden" class="msg-input" id="i_img_hidden_appmsgItem8" value="">

    <div>
        <div class="oh z cover-hd">
            <input type="file" style="padding-bottom: 20px; height:25px;"
                   id="ManyImageTextUploadpic8"/>
        </div>
        <div id="fileQueue8" style="width:242px;"></div>
    </div>
    <label class="block">正文</label>
    <textarea class="msg-txta" style="height:320px;" id="contentbody8"></textarea>

    <div style="clear:both"></div>
    <div class="oh z shadow">
        <span class="left ls"></span><span class="right rs"></span>
    </div>
    <span class="abs msg-arrow a-out" style="margin-top: 630px;"></span>
    <span class="abs msg-arrow a-in" style="margin-top: 630px;"></span>
</div>


<p class="tc msg-btn">
    <a href="javascript:void(0);" id="save" class="btnGreen" onclick="operatemore_JS.saveFinish()">完成</a>
</p>
</div>

</div>
</div>