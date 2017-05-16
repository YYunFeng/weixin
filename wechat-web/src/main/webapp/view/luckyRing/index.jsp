<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>幸运大转盘</title>
    <link href="/view/luckyRing/jquery-mobile/jquery.mobile-1.0a3.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/view/luckyRing/style/luopan.css"/>
    <script src="/view/luckyRing/jquery-mobile/jquery-1.5.min.js" type="text/javascript"></script>
    <script src="/view/luckyRing/jquery-mobile/jquery.mobile-1.0a3.min.js" type="text/javascript"></script>
    <script class="jquery library" src="/view/luckyRing/js/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/view/luckyRing/js/jQueryRotate.2.2.js"></script>


</head>
<body onLoad="loadFun()">

<input type="hidden" id="componentId" value="<s:property value="componentId"/>">
<input type="hidden" id="weixinOpenId" value="<s:property value="weixinOpenId"/>">
<script type="text/javascript" src="/view/luckyRing/js/xyluopanjs.js"></script>
<div id="winnercontenthtml" class="winnercontenthtml winnerfont">
</div>
<div data-role="page" id="page">

    <img src="/view/luckyRing/images/bg_2.png" width="100%" class="lotterybg" id="lotterybg"/>


    <div id="lottery">
        <img id="imgs" src="/view/luckyRing/images/disc-rotate_1.png" viewBox="0 0 176 176"
             style="position: absolute; left: 23px; top: 23px; width: 176px; height: 176px;" id="imgs" class="image"/>

        <div class="arrow"></div>
        <div class="lot-btn first" id="lotbtn" onClick="btn_click()">
            <span></span>
        </div>
    </div>

    <div style="width:90%; margin-left:5%; margin-top:10px; position:absolute; z-index:1;">
        <img src="/view/luckyRing/images/top.png" width="100%"/>
        <!--
        <div style="margin: auto; position:absolute; top:0px; right:0px; bottom:0px; left:0px; z-index:2; width:90%; text-align:center; vertical-align:middle;">asdasdff</div>
        -->
        <table class="titletable">
            <tr class="titletr">
                <td class="titletd">
<span class="titlespan" id="componentTitleId">

</span></td>
            </tr>
        </table>
    </div>


    <div class="jiangxiang">
        <img src="/view/luckyRing/images/words_bg_1.png" style="width:100%; margin:0px; padding:0px;"/>
        <!--
        <img src="images/words_bg_2.png" style="width:100%; height:100px; margin:0px; padding:0px; margin-top:-10px;" />
        -->
        <div style="position:absolute; width:270px; height:36px; line-height:36px; top:0px; font-size:16px; padding:0px 10px; color:#fff; font-size:16px;">
            <b>奖项说明</b>
        </div>
        <div style="width:100%; min-height:100px; margin:0px; padding:0px; margin-top:-8px; background:#fcfaee;">
            <div style="width:90%; padding:0px 5%; color:#a91119; font-size:14px;">
                <p>
                    &nbsp;&nbsp;一等奖：<b><font id="prizehtml_1"></font></b>
                </p>

                <p>
                    &nbsp;&nbsp;二等奖：<font id="prizehtml_2"></font>
                </p>

                <p>
                    &nbsp;&nbsp;三等奖：<font id="prizehtml_3"></font>
                </p>
                <font id="rulehtml"></font><br/>
                <font id="numberhtml"></font><br/>
                <br/>
            </div>
        </div>

        <div class="float_lan">
            <div class="content_title">
                <div class="radiusCSS" style="width: 90%; margin-left:5%; margin-top:20px; text-align:center; color:#fff; font-size:12px; ">本服务技术由360info提供<br />http://weixin.360info.com.cn</div>
            </div>
        </div>

    </div>

    <div id="maskbg" class="maskbg" style="display:none;"></div>
    <!--
  <div id="maskbg" class="maskbg" style="display:none;" onClick="popupboxClose()"></div>
    <div id="popupboxbg" class="popupboxbg" onClick="popupboxClose()" style="display:none;" >
    <span id="popupboxhtml"></span>
    </div>
    -->
</div>

</body>
</html>
<script>
    function popupboxOpenM(_html) {
        var winnerHTML = document.getElementById('winnercontenthtml');

//        document.getElementById("maskbg").style.display = 'block';
//	document.getElementById("popupboxbg").style.display = 'block';
//	document.getElementById("popupboxhtml").innerHTML = _html || '很遗憾~您没抽到奖';
        winnerHTML.innerHTML = _html || '很遗憾~您没抽到奖';

        winnerHTML.innerHTML = _html;
        var _h = winnerHTML.offsetHeight + 150;
        winnerHTML.style.height = _h + 'px';
        document.getElementById('page').style.marginTop = parseInt(_h) + 'px';
    }
    function popupboxOpen(_html) {
        var winnerHTML = document.getElementById('winnercontenthtml');

        document.getElementById("maskbg").style.display = 'block';
//	document.getElementById("popupboxbg").style.display = 'block';	
//	document.getElementById("popupboxhtml").innerHTML = _html || '很遗憾~您没抽到奖';
        winnerHTML.innerHTML = _html || '很遗憾~您没抽到奖';

        winnerHTML.innerHTML = _html;
        var _h = winnerHTML.offsetHeight;
        winnerHTML.style.height = _h + 'px';
        document.getElementById('page').style.marginTop = parseInt(_h) + 'px';
    }
    function popupboxClose() {
        document.getElementById("maskbg").style.display = 'none';
//	document.getElementById("popupboxbg").style.display = 'none';

        winnerHTML.innerHTML = '';
        winnerHTML.style.height = '0px';
        document.getElementById('page').style.marginTop = '0px';
    }
</script>