<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-19
  Time: 上午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-组件管理</title>
    <script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/component.js"></script>
    <link href="../css/menu.css" rel="stylesheet" type="text/css">
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg.css" rel="stylesheet" type="text/css">
    <link href="../css/wxm_appmsg_list.css" rel="stylesheet" type="text/css">
    <link href="../css/ueditor.css" rel="stylesheet" type="text/css">
    <link href="../css/ueditor14e99c.css" rel="stylesheet" type="text/css">
    <link href="../css/operate_appmsg_change.css" rel="stylesheet" type="text/css">
    <link href="../css/module_list_change.css" rel="stylesheet" type="text/css">
</head>
<body>
<script type="text/javascript">
    $().ready(function () {
        jQuery("#component").addClass("selected");
    });
</script>
<div id="header" class="header">
    <jsp:include page="include/top.jsp"></jsp:include>
    <div id="main" class="container">
        <div class="containerBox">
            <div class="boxHeader">
                <h2>组件列表</h2>
            </div>
            <s:bean var="now" name="java.util.Date"/>
            <div class="content_change">
                <div class="page-bd">
                    <div class="tj msg-list">
                        <div id="addAppmsg" class="helpzujianbg">
                            <!--
                              <div class="helpzujian_btn" style=""><div class="helpzujian_btn_img" onclick="submitFeedback()"></div></div>
                              <textarea class="helpzujian_textarea" placeholder="直接输入您的反馈意见给产品经理吧，记得输入你的邮箱哦"></textarea>
                            -->
                        </div>
                        <div class="helpzujianlinebg">
                            <div class="helpzujianline"></div>
                            <div id="helpzujianline_btn" class="helpzujianline_btn" onclick="helpzujianFun(0)"></div>
                            <div id="helpzujianline_btn_off" class="helpzujianline_btn_off" onclick="helpzujianFun(1)"
                                 style="display:none;"></div>
                        </div>
                        <div id="first_col" class="b-dib vt msg-col">
                            <a href="/component/scratchCard.action" class="i-title" style="text-decoration: none;">
                                <div class="msg-item-wrapper" data-appid="10000014"
                                     data-create-time="2013-04-16">
                                    <div id="appmsgItem1" class="msg-item appmsgItem">
                                        <h4 class="msg-t">刮刮卡</h4>

                                        <p class="msg-meta"><span class="msg-date"><s:date name="#now"
                                                                                           format="yyyy-MM-dd"/></span>
                                        </p>

                                        <div class="cover">
                                            <p class="default-tip" style="display:none">封面图片</p>
                                            <img src="../images/scaratch.jpg" class="i-img" style="">
                                        </div>
                                        <p class="msg-text">&nbsp;</p>
                                    </div>
                                    <%--<div class="msg-opr">
                                        <ul class="f0 msg-opr-list">
                                            <li class="b-dib opr-item-change">&lt;%&ndash;<a class="block tc opr-btn"
                                                                                 href="javascript:;"><span
                                                    class="th vm dib opr-icon edit-icon">编辑</span></a>&ndash;%&gt;</li>
                                        </ul>
                                    </div>--%>
                                    <div class="msg-hover-mask"></div>
                                    <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
                                </div>
                            </a>
                            <!--组件start-->
                            <a href="/component/surveyList.action" class="i-title" style="text-decoration: none;">
                                <div class="msg-item-wrapper" id="appmsg10000014" data-appid="10000014"
                                     data-create-time="2013-04-16">
                                    <div id="appmsgItem3" class="msg-item appmsgItem">
                                        <h4 class="msg-t">问卷调查
                                        </h4>

                                        <p class="msg-meta"><span class="msg-date"><s:date name="#now"
                                                                                           format="yyyy-MM-dd"/></span>
                                        </p>

                                        <div class="cover">
                                            <p class="default-tip" style="display:none">封面图片</p>
                                            <img src="../images/survey.jpg" class="i-img" style="">
                                        </div>
                                        <p class="msg-text">&nbsp;</p>
                                    </div>
                                    <%--<div class="msg-opr">
                                        <ul class="f0 msg-opr-list">
                                            <li class="b-dib opr-item-change">&lt;%&ndash;<a class="block tc opr-btn"
                                                                                 href="javascript:;"><span
                                                    class="th vm dib opr-icon edit-icon">编辑</span></a>&ndash;%&gt;</li>
                                        </ul>
                                    </div>--%>
                                    <div class="msg-hover-mask"></div>
                                    <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
                                </div>
                            </a>
                            <!--组件end-->
                        </div>

                        <div id="second_col" class="b-dib vt msg-col">
                            <!--组件start-->
                            <a href="/component/bigWheelComponent.action" class="i-title"
                               style="text-decoration: none;">
                                <div class="msg-item-wrapper" data-appid="10000014" data-create-time="2013-04-16">
                                    <div id="appmsgItem2" class="msg-item appmsgItem">
                                        <h4 class="msg-t">幸运大转盘 </h4>

                                        <p class="msg-meta"><span class="msg-date"><s:date name="#now"
                                                                                           format="yyyy-MM-dd"/></span>
                                        </p>

                                        <div class="cover">
                                            <p class="default-tip" style="display:none">封面图片</p>
                                            <img src="../images/module_list_1.jpg" class="i-img" style="">
                                        </div>
                                        <p class="msg-text">&nbsp;</p>
                                    </div>
                                    <%--<div class="msg-opr">
                                        <ul class="f0 msg-opr-list">
                                            <li class="b-dib opr-item-change">&lt;%&ndash;<a class="block tc opr-btn"
                                                                                 href="javascript:;"><span
                                                    class="th vm dib opr-icon edit-icon">编辑</span></a>&ndash;%&gt;</li>
                                        </ul>
                                    </div>--%>
                                    <div class="msg-hover-mask"></div>
                                    <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
                                </div>
                            </a>
                            <!--组件end-->
                            <a href="/component/prizeQuizList.action" class="i-title" style="text-decoration: none;">
                                <div class="msg-item-wrapper" id="appmsg10000015" data-appid="10000014"
                                     data-create-time="2013-04-16">
                                    <div id="appmsgItem4" class="msg-item appmsgItem">
                                        <h4 class="msg-t">有奖竞答
                                        </h4>

                                        <p class="msg-meta"><span class="msg-date"><s:date name="#now"
                                                                                           format="yyyy-MM-dd"/></span>
                                        </p>

                                        <div class="cover">
                                            <p class="default-tip" style="display:none">封面图片</p>
                                            <img src="../images/prizequiz.jpg" class="i-img" style="">
                                        </div>
                                        <p class="msg-text">&nbsp;</p>
                                    </div>
                                    <%-- <div class="msg-opr">
                                         <ul class="f0 msg-opr-list">
                                             <li class="b-dib opr-item-change">&lt;%&ndash;<a class="block tc opr-btn"
                                                                                  href="javascript:;"><span
                                                     class="th vm dib opr-icon edit-icon">编辑</span></a>&ndash;%&gt;</li>
                                         </ul>
                                     </div>--%>
                                    <div class="msg-hover-mask"></div>
                                    <div class="msg-mask"><span class="dib msg-selected-tip"></span></div>
                                </div>
                            </a>
                            <!--组件end-->
                        </div>

                        <div class="b-dib" style="width:100%;height:0;overflow:hidden;font-size:0;"></div>
                    </div>
                </div>
            </div>
            <div class="clr"></div>
        </div>
    </div>
    <jsp:include page="include/bottom.jsp"></jsp:include>
</div>
</body>
</html>
