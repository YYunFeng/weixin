/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */


// 选择组件
function setClass(id) {
    jQuery("#componentId").val(id);
    $(".module_sel").each(function () {
        $(this).attr("class", "module_sel_no");
    });
    jQuery("#component" + id).attr("class", "module_sel");
}

// 规则菜单
function ruleMenu() {
    document.getElementById("add_rule").style.display = "block";
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/ruleMenu.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#guize_list").html(msg);
        }
    });
}

// 去除选择组件
function setClass_2(id) {
    jQuery("#component" + id).attr("class", "module_sel_no");
    jQuery("#componentId").val('');
}


// 选择素材
function setClassMaterial(id) {
    jQuery("#materialId").val(id);
    $(".module_sel").each(function () {
        $(this).attr("class", "module_sel_no");
    });
    jQuery("#material" + id).attr("class", "module_sel");
}


// 去除选择组件
function setClassMaterial_2(id) {
    jQuery("#material" + id).attr("class", "module_sel_no");
    jQuery("#materialId").val('');
}
// 添加新规则
function go_up() {
    addNewRule();
//   var len = document.getElementById('guize_list').innerHTML += '<li class="selected"><a href="javascript:addNewRule();">新规则</a></li>';

    var temp = document.getElementById('guize_list').innerHTML;
    document.getElementById('guize_list').innerHTML = '<li class="selected"><a href="javascript:addNewRule();">新规则</a></li>' + temp;
}
// 改变样式
function style() {
    $("#guize_list li").each(function () {
        $(this).removeClass();
    });
    $("#normal_list li").each(function () {
        $(this).removeClass();
    });
}
// 改变类型
function changeType(val) {
    // 0 纯文本
    if (val == 0) {
        jQuery("#first_area").show();
        jQuery("#material_area").hide();
        jQuery("#module_area").hide();
        jQuery("#componentId").val('');
    }
    // 1 素材
    if (val == 1) {
        jQuery("#first_area").hide();
        jQuery("#material_area").show();
        jQuery("#module_area").hide();
        materialList();
    }
    // 2 组件
    if (val == 2) {
        jQuery("#first_area").hide();
        jQuery("#material_area").hide();
        jQuery("#module_area").show();
        jQuery("#module_area").html("");
        jQuery("#message").val("");
        componentList();
    }
}
//  组件List
function componentList() {
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/componentList.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#module_area").html(msg);
        }
    });
}
/**
 * 添加新的规则
 */
function addNewRule() {
    style();
    document.getElementById("add_rule").style.display = "none";
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/addNewRule.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#container").html(msg);
        }
    });
}
// 保存规则
function saveRule() {
    var ruleName = jQuery("#ruleName").val();
    var keyword = jQuery("#keyword").val();
    var linkType = jQuery("#linkType").val();
    var message = jQuery("#message").val();
    var componentId = jQuery("#componentId").val();
    var materialId = $("#materialId").val();
    var flag = $("#flag").val();
    if (linkType == 1) {
        componentId = '';
    }
    if (linkType == 2) {
        materialId = '';
    }
    if (ruleName == '') {
        alert("规则名称不能为空");
    } else if (keyword == '') {
        alert("关键字不能为空");
    } else if (flag == 0) {
        alert("关键不能重复");
    } else if (linkType == 0 && message == '') {
        alert("文本信息不能为空")
    } else if (linkType == '') {
        alert("请选择关键字类型");
    } else if (linkType == 2 && componentId == '') {
        alert('请选择组件')
    } else if (linkType == 1 && materialId == '') {
        alert('请选择素材')
    } else {
        jQuery.ajax({
            type: "POST",
            url: "/autoRespond/saveRule.action",
            data: {"keyWordLink.ruleName": ruleName,
                "keyWordLink.keyword": keyword,
                "keyWordLink.linkType": linkType,
                "keyWordLink.message": message,
                "keyWordLink.materialId": materialId,
                "keyWordLink.componentId": componentId
            },
            dataType: "json",
            success: function (data) {
                // 添加成功a
                if (data.status == 1) {
                    ruleContent(data.keyLinkId);
                }
                // 添加失败
                if (data.status == 0) {
                    alert(date.mess);
                }
            }
        });

    }
}
// 按Id查看规则
function ruleContent(id) {
    ruleMenu();
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/ruleContent.action",
        data: {"Id": id},
        dataType: "html",
        success: function (msg) {
            style();
            jQuery("#" + id).addClass("selected");
            jQuery("#container").html(msg);
            toolJS.loading(0);
        }
    });
}
//    验证关键字是否存在
function autoRule(val) {
    $("#autoRule").addClass("key_check");
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/autoRule.action",
        data: {
            "keyWordLink.keyword": val
        },
        dataType: "JSON",
        success: function (data) {
            if (data.status == 0) {
                document.getElementById('keyword').style.border = '1px dotted #F03';
                $("#autoRule").removeClass();
                $("#autoRule").addClass("key_check_n");
                $("#flag").val('0');
            } else {
                document.getElementById('keyword').style.border = '';
                $("#autoRule").removeClass();
                $("#autoRule").addClass("key_check_y");
                $("#flag").val('1');
            }
        }
    });
}
function autoModifyRule(val) {
    var ruleMess = $("#ruleMess").val();
    if (ruleMess != '') {
        if (ruleMess != val) {
            $("#autoRule").addClass("key_check");
            jQuery.ajax({
                type: "POST",
                url: "/autoRespond/autoRule.action",
                data: {
                    "keyWordLink.keyword": val
                },
                dataType: "JSON",
                success: function (data) {
                    if (data.status == 0) {
                        document.getElementById('keyword').style.border = '1px dotted #F03';
                        $("#autoRule").removeClass();
                        $("#autoRule").addClass("key_check_n");
                        $("#flag").val('0');
                    } else {
                        document.getElementById('keyword').style.border = '';
                        $("#autoRule").removeClass();
                        $("#autoRule").addClass("key_check_y");
                        $("#flag").val('1');
                    }
                }
            });
        }
    }
}
// 修改规则
function modifyRule(id) {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/modifyRule.action",
        data: {"Id": id},
        dataType: "html",
        success: function (msg) {
            jQuery("#container").html(msg);
            toolJS.loading(0);
        }
    });
}
// 修改规则 入库
function saveModifyRule(id) {
    var ruleName = jQuery("#ruleName").val();
    var keyword = jQuery("#keyword").val();
    var linkType = jQuery("#linkType").val();
    var message = jQuery("#message").val();
    var componentId = jQuery("#componentId").val();
    var materialId = $("#materialId").val();
    var textResourceId = $("#textResourceId").val();
    var flag = $("#flag").val();
    if (linkType == 1) {
        componentId = '';
    }
    if (linkType == 2) {
        materialId = '';
    }
    if (confirm("确定要修改")) {
        if (ruleName == '') {
            alert("规则名称不能为空");
        } else if (keyword == '') {
            alert("关键字不能为空");
        } else if (flag == 0) {
            alert("关键不能重复");
        } else if (linkType == 0 && message == '') {
            alert("文本信息不能为空")
        } else if (linkType == '') {
            alert("请选择关键字类型");
        } else if (linkType == 2 && componentId == '') {
            alert('请选择组件')
        } else if (linkType == 1 && materialId == '') {
            alert('请选择素材')
        } else {
            jQuery.ajax({
                type: "POST",
                url: "/autoRespond/saveModifyRule.action",
                data: {"keyWordLink.Id": id,
                    "keyWordLink.ruleName": ruleName,
                    "keyWordLink.keyword": keyword,
                    "keyWordLink.linkType": linkType,
                    "keyWordLink.message": message,
                    "keyWordLink.materialId": materialId,
                    "keyWordLink.componentId": componentId,
                    "textResources.Id": textResourceId,
                    "textResources.message": message
                },
                dataType: "json",
                success: function (data) {
                    // 修改成功
                    if (data.status == 1) {
                        ruleContent(id);
                    }
                    // 修改失败
                    if (data.status == 0) {
                        alert(date.mess);
                    }
                }
            });
        }

    }
}
// 删除规则
function deleteRule(id) {
    if (confirm("确定要删除！")) {
        jQuery.ajax({
            type: "POST",
            url: "/autoRespond/deleteRule.action",
            data: {"keyWordLink.Id": id },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    window.location = "/autoRespond/autoRespond.action";
                }
            }
        });
    }
}


<!--同步文字方法-->
function syn_1() {
    document.getElementById("key_help_2").value = document.getElementById("key_help").value;
}

function syn_2() {
    document.getElementById("help_txt_2").innerHTML = document.getElementById("help_txt").value;
}

function syn_3() {
    document.getElementById("close_text_2").innerHTML = document.getElementById("close_text").value;
}

function syn_4() {
    document.getElementById("yemei_1_pre").value = document.getElementById("yemei_1").value;
}

function syn_5() {
    document.getElementById("yejiao_1_pre").value = document.getElementById("yejiao_1").value;
}

function syn_6() {
    document.getElementById("close_text_3_pre").innerHTML = document.getElementById("close_text_3").value;
}

function syn_7() {
    document.getElementById("yemei_2_pre").value = document.getElementById("yemei_2").value;
}

function syn_8() {
    document.getElementById("yejiao_2_pre").value = document.getElementById("yejiao_2").value;
}

function syn_9() {
    document.getElementById("close_text_4_pre").innerHTML = document.getElementById("close_text_4").value;
}

function syn_10() {
    document.getElementById("close_text_5_pre").innerHTML = document.getElementById("close_text_5").value;
}

function syn_auto() {
    document.getElementById("auto_text_pre").innerHTML = document.getElementById("auto_text").value;
}

function syn_new_mei() {
    document.getElementById("yemei_new_pre").value = document.getElementById("yemei_new").value;
}

function syn_new_jiao() {
    document.getElementById("yejiao_new_pre").value = document.getElementById("yejiao_new").value;
}

<!--同步文字方法-->

// 被关注时候
function attention() {
    ruleMenu();
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/attention.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#container").html(msg);
            style();
            jQuery("#attention").addClass("selected");
            toolJS.loading(0);
        }
    });
}


function r_show() {
    document.getElementById("all").style.display = "none";
    document.getElementById("not_all").style.display = "block";
}

function r_hide() {
    document.getElementById("all").style.display = "block";
    document.getElementById("not_all").style.display = "none";
}

// 关注没奖更新
function saveNoPirze(id) {
    if (!judge1()) {
        if (confirm("确定要修改！")) {
            var message = $("#close_text").val();
            jQuery.ajax({
                type: "post",
                url: "/autoRespond/saveAttention.action",
                data: {
                    "textResources.id": id,
                    "textResources.message": message,
                    "flag": 1
                },
                dataType: "json",
                success: function (data) {
                    if (data.status == 1) {
                        attention();
                    }
                    if (data.status == 0) {
                        alert(data.mess);
                    }
                }

            });
        }
    }
}

/**
 * 关注100%有奖
 */
function saveAbsoluePrize(id) {
    if (!judge2()) {
        if (confirm("确定要修改！")) {
            var message = $("#close_text_3").val();

            jQuery.ajax({
                type: "post",
                url: "/autoRespond/saveAttention.action",
                data: {
                    "foucsLucky.id": id,
                    "foucsLucky.luckyMessage": message,
                    "foucsLucky.absoluteLucky": true,
                    "flag": 2
                },
                dataType: "json",
                success: function (data) {
                    if (data.status == 1) {
                        attention();
                    }
                    if (data.status == 0) {
                        alert(data.mess);
                    }
                }

            });
        }
    }
}

// 关注有奖，但是不是100%有奖
function saveNoAbsoulePrize(id) {
    if (!judge3()) {
        if (confirm("确定要修改！")) {
            var luckyMessage = $("#close_text_4").val();
            var noLuckyMessage = $("#close_text_5").val();
            /* var help = '';
             var headFoot = '';
             if (document.getElementById('help_txt2').checked == true) {
             help = true;
             } else {
             help = false;
             }
             if (document.getElementById('header_footer_check3').checked == true) {
             headFoot = true;
             } else {
             headFoot = false;
             }*/
            var luckyNum = '';
            var luckyProbability = '';
            if (document.getElementById('award_setting_1').checked == true && document.getElementById('award_setting_2').checked == false) {
                luckyNum = $("#settingNum").val();
                luckyProbability = '';
            }
            if (document.getElementById('award_setting_1').checked == false && document.getElementById('award_setting_2').checked == true) {
                luckyProbability = $("#settingNum").val();
                luckyNum = '';
            }

            jQuery.ajax({
                type: "post",
                url: "/autoRespond/saveAttention.action",
                data: {
                    "foucsLucky.id": id,
                    "foucsLucky.luckyMessage": luckyMessage,
                    "foucsLucky.notLuckyMessage": noLuckyMessage,
                    "foucsLucky.absoluteLucky": false,
                    "foucsLucky.luckyProbability": luckyProbability,
                    "foucsLucky.luckyNumber": luckyNum,
                    "flag": 2
                },
                dataType: "json",
                success: function (data) {
                    if (data.status == 1) {
                        attention();
                    }
                    if (data.status == 0) {
                        alert(data.mess);
                    }
                }
            });
        }
    }
}

// 自动回复信息页面
function respond() {
    ruleMenu();
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/respond.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#container").html(msg);
            style();
            jQuery("#respond").addClass("selected");
            toolJS.loading(0);
        }
    });
}

// 自动回复帮助页面
function autoRespondHelp() {
    ruleMenu();
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/autoRespondHelp.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#container").html(msg);
            style();
            jQuery("#autoRespondHelp").addClass("selected");
            toolJS.loading(0);
        }
    });
}


// 自动回复页眉和页脚页面
function autorespondHeadAndFoot() {
    ruleMenu();
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/autoRespondHeadAndFoot.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#container").html(msg);
            style();
            jQuery("#autorespondHeadAndFoot").addClass("selected");
            toolJS.loading(0);
        }
    });
}

// 修改文本资源信息
function saveTextResource(falg, id) {
    if (confirm("确定要修改？")) {
        var message = '';
        // 自动回复
        if (falg == 0) {
            message = $("#auto_text").val();
        }
        // 帮助
        if (falg == 1) {
            message = $("#help_txt").val();
        }
        jQuery.ajax({
            url: "/autoRespond/saveTextResource.action",
            type: "post",
            dataType: "json",
            data: {
                "textResources.id": id,
                "textResources.message": message
            },
            success: function (data) {
                // 修改成功
                if (data.status == 1) {
                    if (falg == 0) {
                        respond();
                    }
                    if (falg == 1) {
                        autoRespondHelp();
                    }
                }
                // 修改失败
                if (data.status == 0) {
                    alert(data.mess);
                }
            }
        });
    }
}

//修改页眉和页脚
function saveHeadAndFoot(yemei_id, yejiao_id) {
    if (confirm("确定要修改？")) {
        var yemei_new = $("#yemei_new").val();
        var yejiao_new = $("#yejiao_new").val();
        jQuery.ajax({
            url: "/autoRespond/saveHeadAndFoot.action",
            type: "post",
            data: {"textResourcesList[0].id": yemei_id,
                "textResourcesList[0].message": yemei_new,
                "textResourcesList[1].id": yejiao_id,
                "textResourcesList[1].message": yejiao_new
            },
            dataType: "json",
            success: function (data) {
                // 修改成功
                if (data.status == 1) {
                    autorespondHeadAndFoot();
                }
                // 修改失败
                if (data.status == 0) {
                    alert(data.mess);
                }
            }
        });
    }
}

// 素材列表
function materialList() {
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/materialList.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#material_area").html(msg);
        }
    });
}
// 导出帮助
function exportHelp() {
    jQuery.ajax({
        type: "POST",
        url: "/autoRespond/exportHelp.action",
        dataType: "json",
        success: function (msg) {
            jQuery("#message").val(msg);
        }
    });
}
