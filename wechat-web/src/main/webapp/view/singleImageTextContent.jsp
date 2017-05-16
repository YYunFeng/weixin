<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-26
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3 class="page-sub-hd">单图文列表&nbsp;(共 <s:property value="materialListResList.size()"/> 个)</h3>
<div class="page-bd">
    <div class="tj msg-list">
        <div id="first_col" class="b-dib vt msg-col">
            <div id="addAppmsg" class="tc add-access">
                <span class="dib vm th add-tip" style="cursor: pointer;" onclick="addSingleImageText();">新建消息入口</span>
            </div>
            <div id="appmsglistleft">
                <s:iterator value="materialListResList" status="materia">
                    <s:if test="#materia.odd">
                        <div class="msg-item-wrapper" id="appmsg10000014" data-appid="10000014"
                             data-create-time="2013-04-16">
                            <div id="appmsgItem1" class="msg-item appmsgItem">
                                <h4 class="msg-t">
                                    <s:property value="title"/>
                                </h4>

                                <p class="msg-meta"><span class="msg-date"> <s:date name="created"
                                                                                    format="yyyy-MM-dd"/></span></p>

                                <div class="cover">
                                    <p class="default-tip" style="display:none">封面图片</p>
                                    <img src="<s:property value="picUrl"/>"
                                         class="i-img" style="">
                                </div>
                                <p class="msg-text"><s:property value="abstractContent"/></p>
                            </div>
                            <div class="msg-opr">
                                <ul class="f0 msg-opr-list">
                                    <li class="b-dib opr-item">
                                        <a class="block tc opr-btn edit-btn"
                                           href="javascript:modifySingleImageText(<s:property value="Id"/>)">
                                            <span class="th vm dib opr-icon edit-icon">编辑</span>
                                        </a>
                                    </li>
                                    <li class="b-dib opr-item">
                                        <a class="block tc opr-btn del-btn"
                                           href="javascript:deleteMaterial(<s:property value="Id"/>,0);"
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
            <s:iterator value="materialListResList" status="material">
                <s:if test="#material.even">
                    <div class="msg-item-wrapper" id="appmsg10000009" data-appid="10000009"
                         data-create-time="2013-04-16">
                        <div class="msg-item appmsgItem">
                            <h4 class="msg-t"><s:property value="title"/></h4>

                            <p class="msg-meta"><span class="msg-date"><s:date name="created"
                                                                               format="yyyy-MM-dd"/></span></p>

                            <div class="cover">
                                <p class="default-tip" style="display:none">封面图片</p>
                                <img src="<s:property value="picUrl"/>"
                                     class="i-img" style="">
                            </div>
                            <p class="msg-text"><s:property value="abstractContent"/></p>
                        </div>
                        <div class="msg-opr">
                            <ul class="f0 msg-opr-list">
                                <li class="b-dib opr-item">
                                    <a class="block tc opr-btn edit-btn"
                                       href="javascript:modifySingleImageText(<s:property value="Id"/>)">
                                        <span class="th vm dib opr-icon edit-icon">编辑</span>
                                    </a>
                                </li>
                                <li class="b-dib opr-item">
                                    <a class="block tc opr-btn del-btn"
                                       href="javascript:deleteMaterial(<s:property value="Id"/>,0);"
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