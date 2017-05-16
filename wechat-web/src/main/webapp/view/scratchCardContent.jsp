<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-26
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3 class="page-sub-hd">刮刮卡列表&nbsp;(共 <s:property value="componentList.size()"/> 个)</h3>
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
                <span class="dib vm th add-tip" style="cursor: pointer;" onclick="addScratchCard();">新建消息入口</span>
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

                                <p class="msg-meta"><span class="msg-date"> <s:date name="created"
                                                                                    format="yyyy-MM-dd"/></span></p>
                                <div class="cover">
                                    <s:if test="expired"><div class="over"></div></s:if>
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
                                           href="javascript:modifyScratchCard(<s:property value="Id"/>);">
                                            <span class="th vm dib opr-icon edit-icon">编辑</span>
                                        </a>
                                    </li>
                                    <li class="b-dib opr-item">
                                        <a class="block tc opr-btn del-btn"
                                           href="javascript:deleteScratchCard(<s:property value="Id"/>);"
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
                                       href="javascript:modifyScratchCard(<s:property value="Id"/>)">
                                        <span class="th vm dib opr-icon edit-icon">编辑</span>
                                    </a>
                                </li>
                                <li class="b-dib opr-item">
                                    <a class="block tc opr-btn del-btn"
                                       href="javascript:deleteScratchCard(<s:property value="Id"/>);"
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