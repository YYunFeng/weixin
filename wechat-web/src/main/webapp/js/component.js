/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
// 改变样式
function style() {
    $("#surveyList li").each(function () {
        $(this).removeClass();
    });
}

// 大转盘
function bigWheelComponent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/bigWheelComponent.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}

function type_show() {
    document.getElementById("probabilityShow").style.display = "block";
    $("#probability").val('');

}
function type_hide() {
    document.getElementById("probabilityShow").style.display = "none";
    $("#probability").val(100);
}
// 删除大转盘
function deleteBigWheelComponent(id) {
    if (confirm("确定要删除?")) {
        jQuery.ajax({
            type: "POST",
            url: "/component/deleteComponent.action",
            data: {"component.Id": id },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    bigWheelComponentContent();
                } else {
                    alert("删除失败！");
                }
            }
        });
    }
}
// 删除刮刮卡
function deleteScratchCard(id) {
    if (confirm("确定要删除?")) {
        jQuery.ajax({
            type: "POST",
            url: "/component/deleteComponent.action",
            data: {"component.Id": id },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    scratchCardContent();
                } else {
                    alert("删除失败！");
                }
            }
        });
    }
}
// 添加大转盘
function addBigWheelComponent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/addBigWheelComponent.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}
// ajax 调用
function bigWheelComponentContent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/bigWheelComponentContent.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            style();
            jQuery("#bigWheel").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 上传图片
function uploadPic() {
    $("#uploadify").uploadify({
        'uploader': '/js/uploadify-v2.1.4/uploadify.swf',
        'script': "/upload/uploadPic.action",//后台处理的请求
        'cancelImg': '/js/uploadify-v2.1.4/cancel.png',
        'fileDataName': 'uploadFile',//服务器端根据这个接收文件
        'queueID': 'fileQueue',//与下面的id对应
        'queueSizeLimit': 1,
        'fileDesc': '图片文件',
        'fileExt': '*.*', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
        'auto': true,
        'multi': false,
        'scriptData': {'type': 1},
        'buttonImg': '/images/uploadimg.png',
        'width': 305,
        'onError': function (event, queueID, fileObj, errorObj) {
            alert(" 上传失败!");
        },
        'onComplete': function (event, queueID, fileObj, response) {
            if (response != '') {
                var date = jQuery.parseJSON(response)
                $('#previewPic').attr('src', date.viewPath);
                $('#bigWheelPic').val(date.fileName);
            } else {
                alert('上传失败!');
            }
        }
    });
}
// 修改大转盘
function modifyBigWheel(componentId) {
    toolJS.loading(1);
    jQuery.ajax({
        url: "/component/modifyBigWheelComponent.action",
        type: "POST",
        data: {"componentId": componentId},
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}
// 修改刮刮卡
function modifyScratchCard(componentId) {
    toolJS.loading(1);
    jQuery.ajax({
        url: "/component/modifyScaratchCardComponent.action",
        type: "POST",
        data: {"componentId": componentId},
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}
// 问卷调查content
function surveyListContent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/surveyListContent.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            style();
            jQuery("#survey").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 添加问卷调查
function addSurvey() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/addSurvey.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}
// 删除大转盘
function deleteSurveyComponent(id) {
    if (confirm("确定要删除?")) {
        jQuery.ajax({
            type: "POST",
            url: "/component/deleteComponent.action",
            data: {"component.Id": id },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    surveyListContent();
                } else {
                    alert("删除失败！");
                }
            }
        });
    }
}

// 修改问调查
function modifySurvey(id) {
    toolJS.loading(1);
    jQuery.ajax({
        url: "/component/modifySurvey.action",
        type: "POST",
        data: {"componentId": id},
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}
// 刮刮卡content
function scratchCardContent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/scratchCardContent.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            style();
            jQuery("#scratchCard").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 添加刮刮卡
function addScratchCard() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/addScratchCard.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}


// 有奖竞答content
function prizeQuizListContent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/prizeQuizListListContent.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            style();
            jQuery("#prizeQuiz").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 添加有奖竞答
function addPrizeQuiz() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/component/addPrizeQuiz.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            style();
            jQuery("#prizeQuiz").addClass("selected");
            toolJS.loading(0);
        }
    });
}


// 删除有奖竞答
function deletePrizeQuiz(id) {
    if (confirm("确定要删除?")) {
        jQuery.ajax({
            type: "POST",
            url: "/component/deleteComponent.action",
            data: {"component.Id": id },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    prizeQuizListContent();
                } else {
                    alert("删除失败！");
                }
            }
        });
    }
}


// 修改有奖竞答
function modifyPrizeQuiz(id) {
    toolJS.loading(1);
    jQuery.ajax({
        url: "/component/modifyPrizeQuiz.action",
        type: "POST",
        data: {"componentId": id},
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}

function helpzujianFun(temp){
    if(temp == 1){
        document.getElementById('addAppmsg').style.height = '170px';
//		document.getElementById('addAppmsg').style.display = 'block';
        document.getElementById('helpzujianline_btn').style.display = 'block';
        document.getElementById('helpzujianline_btn_off').style.display = 'none';
    }else{
        document.getElementById('addAppmsg').style.height = '0px';
//		document.getElementById('addAppmsg').style.display = 'none';
        document.getElementById('helpzujianline_btn').style.display = 'none';
        document.getElementById('helpzujianline_btn_off').style.display = 'block';
    }
}