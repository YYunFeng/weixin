// 统计大转盘中奖信息
function statisticsBigWheelComponent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsBigWheelComponent.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            jQuery("#statisticsBigWheelComponent").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 统计大转盘中奖信息
function statisticsAttention() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsAttention.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            jQuery("#attention").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 统计大转盘中奖信息
function statisticsAttentionContent(attentionMonth) {
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsAttentionContent.action",
        data: {"attentionMonth": attentionMonth},
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#" + attentionMonth).html(msg);
            jQuery("#attention").addClass("selected");
        }
    });
}

function statisticsBigWheelComponentContent(componentId) {
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsBigWheelComponentContent.action",
        data: {"componentId": componentId},
        dataType: "html",
        success: function (msg) {
            jQuery("#" + componentId).html(msg);
            toolJS.loading(0);
        }
    });
}
// 统计大转盘中奖信息
function statisticsSacaratchCard() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsSacaratchCard.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            jQuery("#sacaratchCard").addClass("selected");
            toolJS.loading(0);
        }
    });
}


function statisticsSacaratchCardContent(componentId) {
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsSacaratchCardContent.action",
        data: {"componentId": componentId},
        dataType: "html",
        success: function (msg) {
            jQuery("#" + componentId).html(msg);
        }
    });
}
// 清楚样式
function clearStyle() {
    $("#statistics li").each(function () {
        $(this).removeClass();
    });
}


// 统计问卷调查
function statisticsSurvey() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsSurvey.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            jQuery("#survey").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 统计问卷调查 按天查看
function statisticsSurveyContent(surveyId) {
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsSurveyContent.action",
        data: {"surveyId": surveyId},
        dataType: "html",
        success: function (msg) {
            jQuery("#" + surveyId).html(msg);
        }
    });
}


// 统计有奖竞答
function statisticsPrizeQuiz() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsPrizeQuiz.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            jQuery("#prizeQuiz").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 统计有奖竞答 按天查看
function statisticsPrizeQuizContent(componentId) {
    jQuery.ajax({
        type: "post",
        url: "/statistics/statisticsPrizeQuizContent.action",
        data: {"componentId": componentId},
        dataType: "html",
        success: function (msg) {
            jQuery("#" + componentId).html(msg);
        }
    });
}



