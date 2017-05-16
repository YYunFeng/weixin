<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-15
  Time: 下午12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/artDialog/artDialog.min.js"></script>
<link href="../js/artDialog/skins/green.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    /**
     * 统计答案
     * @param surveyTopicId
     * @param surveyId
     */
    function statisticsSurveyAnswer(surveyTopicId, surveyId) {
        toolJS.loading(1);
        jQuery.ajax({
            type: "post",
            url: "/statistics/statisticsSurveyAnswer.action",
            data: {"surveyId": surveyId,
                "surveyTopicId": surveyTopicId
            },
            dataType: "html",
            success: function (msg) {
                $("#statisticsAnswer").html(msg);
                art.dialog({
                    content: document.getElementById('statisticsAnswer'),
                    title:"统计答案",
                    lock :true,
                    left: '100%',
                    top: '100%',
                    fixed: true,
                    drag: false,
                    resize: false
                });
                toolJS.loading(0);
            }
        });
    }
</script>
<div class="clr"></div>
<div style="height:10px;"></div>
<!--详情for循环_start-->
<s:iterator value="surveyTopicList">
    <a href="javascript:statisticsSurveyAnswer(<s:property value="Id"/>,<s:property value="surveyId"/>)">
        <div class="list_subcon_wj">
            <s:property value="title"/>
        </div>
    </a>
</s:iterator>
<!--详情for循环_end-->
<div class="clr"></div>
<div class="list_subcon_btn hidden_btn" style="cursor: pointer"
     onclick="statisticsJS.btn_listhidden('<s:property value="surveyId"/>',0,2)">
    <div class="hidden_btn">收起</div>
</div>
<div class="clr"></div>
<div id="statisticsAnswer" style="display: none;">

</div>
