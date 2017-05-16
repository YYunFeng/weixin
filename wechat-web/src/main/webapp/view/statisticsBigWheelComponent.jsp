<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-15
  Time: 下午12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:iterator value="statisticsResList">
    <div class="list_title_l"></div>
    <div class="list_title_c">
        <div class="list_title_c_l">
            <div><s:property value="title"/> </div>
            <div></div>
        </div>
        <div class="list_title_c_r ltcr1">
            <div class="s1"><a style="cursor: pointer" onclick="statisticsJS.btn_listhidden('<s:property value="componentId"/>', 1,0)">查看详情</a></div>
        </div>
        <div class="list_title_c_r ltcr2">
            <div class="c2"><s:property value="winNumber"/> </div>
            <div class="s2">中奖人数</div>
        </div>
        <div class="list_title_c_r ltcr2">
            <div class="c3"><s:property value="partakeNumber"/> </div>
            <div class="s2">参与量</div>
        </div>
        <div class="list_title_c_r ltcr2">
            <div><s:property value="visitView"/></div>
            <div class="s2">访问量</div>
        </div>
        <div class="clr"></div>
    </div>
    <div class="list_title_r"></div>
    <div class="clr"></div>
    <div class="list_detail" id="<s:property value="componentId"/>" style="display:none;">
    </div>
    <!--统计列表 for循环_end-->
</s:iterator>