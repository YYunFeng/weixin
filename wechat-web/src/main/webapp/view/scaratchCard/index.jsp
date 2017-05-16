<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--?xml version="1.0" encoding="UTF-8"?-->
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="apple-touch-fullscreen" content="YES">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Cache-Control" content="max-age=0">
    <!--
    <meta name="viewport" content="width=device-width; initial-scale=1.0;  minimum-scale=1.0; maximum-scale=1.0; ">
    -->
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="MobileOptimized" content="320">
    <title>刮刮卡</title>
    <link rel="stylesheet" type="text/css" href="/view/scaratchCard/style/guaguakacss.css"/>

    <style type="text/css">

    </style>
    <input type="hidden" id="componentId" value="<s:property value="componentId"/>">
    <input type="hidden" id="weixinOpenId" value="<s:property value="weixinOpenId"/>">
    <script type="text/javascript" src="/view/scaratchCard/js/jquery-1.js"></script>
    <script type="text/javascript" src="/view/scaratchCard/jstool/toolJS.js"></script>
    <script type="text/javascript" src="/view/scaratchCard/js/guaguakajs.js"></script>
    <script type="text/javascript">
//     function loadcanvas(){
        var hasTouch = 'ontouchstart' in window;
        var canvas;
        var ctx;
        var color = "#fff";
        var lines = [];
        var points = [];
        $(document).ready(function () {
//        function loadcan(){
//            alert('0')
            var offset = $("#myCanvas").offset();
            var canvas_left = offset.left;
            var canvas_top = offset.top;

            canvas = document.getElementById('myCanvas');
            ctx = canvas.getContext('2d');
            ctx.fillStyle = "#999";
            ctx.fillRect(0, 0, 80, 17);
            //移动
            var START_EV = hasTouch ? 'touchstart' : 'mousedown';
            var MOVE_EV = hasTouch ? 'touchmove' : 'mousemove';
            var END_EV = hasTouch ? 'touchend' : 'mouseup';
            document.getElementById("myCanvas").addEventListener(START_EV, touchCheck, false);
            document.getElementById("myCanvas").addEventListener(MOVE_EV, touchCheck, false);
            document.getElementById("myCanvas").addEventListener(END_EV, touchCheck, false);
            var startTouch;
            var isDrag = false;
            var lastPoint;

            function touchCheck(evt) {
                evt.preventDefault();
                var touchX;
                var touchY;
                if (hasTouch) {
                    if (evt.touches.length > 0) {
                        touchX = evt.touches[0].pageX - canvas_left;
                        touchY = evt.touches[0].pageY - canvas_top;
                    }
                    else {
                        if (lastPoint) {
                            touchX = lastPoint.x;
                            touchY = lastPoint.y;
                        }
                    }
                }
                else {
                    touchX = evt.pageX - canvas_left;
                    touchY = evt.pageY - canvas_top;
                }

                switch (evt.type) {
                    case START_EV:
                        DrawLine();
                        points = [];
                        points.push({ x: touchX, y: touchY });
                        isDrag = true;
                        lastPoint = { x: touchX, y: touchY };
                        break;
                    case MOVE_EV:
                        if (isDrag) {
                            points.push({ x: touchX, y: touchY });
                            lastPoint = { x: touchX, y: touchY };
                            DrawLine();
                        }
                        break;
                    case END_EV:
                        isDrag = false;
                        if (points.length > 0) {
                            points.push({ x: touchX, y: touchY });
                            lines.push(points);
                            DrawLine();
                        }
                        break;
                }
            }

            function DrawSingleLine(ctx, line) {
                for (var j = 0; j < line.length; j++) {
                    var point = line[j];
                    if (j == 0)
                        ctx.moveTo(point.x, point.y);
                    else
                        ctx.lineTo(point.x, point.y);
                }
            }

            function DrawLine() {
                ctx.clearRect(0, 0, 80, 17);
                ctx.globalCompositeOperation = "source-over";
                ctx.fillStyle = "#999";
                /*
                 var img = new Image();
                 img.src = "images/luck.png";
                 ctx.drawImage(img, 0, 0);*/
                ctx.fillRect(0, 0, 80, 17);
                ctx.globalCompositeOperation = "destination-out";
                ctx.beginPath();
                ctx.strokeStyle = color;
                ctx.lineWidth = 4;
                var tempLines = lines;
                if (tempLines.length == 0) {
                    tempLines.push(points);
                }
                for (var i = 0; i < tempLines.length; i++) {
                    var line = tempLines[i];
                    DrawSingleLine(ctx, line);
                }
                if (isDrag && points.length > 0)
                    DrawSingleLine(ctx, points);
                ctx.stroke();
                ctx.closePath();
            }
//        }
       });
//     }
    </script>

</head>
<body onload="loadFun()">


<div class="wrapper">
    <div class="float_lan">
        <div class="header">
            <img src="/view/scaratchCard/images/gaga.png" border="0"/>

            <div class="luck" id="priceinfo">谢谢</div>
            <canvas id="myCanvas" class="myCanvas" width="80" height="17">your browser does not support the canvas
            </canvas>
            <img src="/view/scaratchCard/images/guajiang.png"
                 style="width: 55px; height:20px; position:absolute; right:3%; bottom:43px; z-index:3;"/>

            <div class="headtitle">
                <table class="titletable">
                    <tr class="titletr">
                        <td class="titletd">
      <span class="titlespan" id="componentTitleId">

		</span></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="content">


        <div class="float_lan">
            <div class="content_title">
                <img src="/view/scaratchCard/images/title_bg.png" border="0"/>
                <span>刮奖说明</span>
            </div>
        </div>

        <div class="float_lan">
            <div class="content_block">
                <p>
                    &nbsp;&nbsp;一等奖：<b><font id="prizehtml_1"></font></b>
                </p>

                <p>
                    &nbsp;&nbsp;二等奖：<font id="prizehtml_2"></font>
                </p>

                <p>
                    &nbsp;&nbsp;三等奖：<font id="prizehtml_3"></font>
                </p>
            </div>
        </div>

        <div class="float_lan_btn" id="againBtn">
            <div class="content_title">
                <div class="radiusCSS"
                     style="width: 60%; margin-left:20%; margin-top:10px; margin-bottom:10px; height:40px; line-height:40px; background:#fea800; border:0px solid #09F; text-align:center; color:#fff; font-weight:bold; display:block;"
                     onclick="againLoadClick()">再来一张
                </div>
            </div>
        </div>


        <div class="float_lan">
            <div class="content_block">
                <font id="rulehtml"></font>

                <p id="numberhtml"></p>
            </div>
        </div>

        <!--
            <div class="float_lan_btn" id="againBtn">
              <div class="content_title">
                <div class="radiusCSS" style="width: 60%; margin-left:20%; margin-top:10px; margin-bottom:10px; height:40px; line-height:40px; background:#fea800; border:0px solid #09F; text-align:center; color:#fff; font-weight:bold; display:block;">查看中奖信息</div>
              </div>
            </div>
        -->

    </div>


    <div class="float_lan">
        <div class="content_title">
            <div class="radiusCSS"
                 style="width: 90%; margin-left:5%; margin-top:20px; text-align:center; color:#fff; font-size:12px; ">
                本服务技术由360info提供<br/>http://weixin.360info.com.cn
            </div>
        </div>
    </div>

</div>

</body>
</html>
