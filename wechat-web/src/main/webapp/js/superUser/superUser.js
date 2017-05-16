function userListContent() {
    jQuery.ajax({
        url: "/superUser/userContent.action",
        type: "POST",
        dateType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
        }
    });
}

function quickSearch(val) {
    toolJS.loading(1);
    var myPagination = $("#demo1").myPagination({
        currPage: 1,
        pageNumber: 10,
        cssStyle: 'badoo',//分页样式，具体样式可以从css/page.css样式中选取
        panel: {
            first: '首页',
            last: '尾页',
            next: '下一页',
            prev: '上一页',
            first_on: true,
            last_on: true,
            next_on: true,
            prev_on: true,
            tipInfo_css: {
                width: '22px'
            }
        },
        ajax: {
            on: true,//是否启用异步请求，必须启用
            type: "POST",
            url: "/superUser/userContent.action",
            dataType: 'html',
            param: "flag=" + val,
            //回调函数
            callback: function (data) {
                jQuery("#content").html(data);
                toolJS.loading(0);
            }
        }
    });
    myPagination.onReload();
}
function preciseSearch() {
    toolJS.loading(1);
    var myPagination1;
    var params = $("#queryForm").serialize();//序列化表单
    params = decodeURIComponent(params, true);	//解码
    myPagination1 = $("#demo1").myPagination({
        currPage: 1,
        pageNumber: 10,
        cssStyle: 'badoo',//分页样式，具体样式可以从css/page.css样式中选取
        panel: {
            first: '首页',
            last: '尾页',
            next: '下一页',
            prev: '上一页',
            first_on: true,
            last_on: true,
            next_on: true,
            prev_on: true,
            tipInfo_css: {
                width: '22px'
            }
        },
        ajax: {
            on: true,//是否启用异步请求，必须启用
            type: "POST",
            url: "/superUser/userContent.action",
            dataType: 'html',
            param: params,
            //回调函数
            callback: function (data) {
                jQuery("#content").html(data);
                toolJS.loading(0);
            }
        }
    });
    myPagination1.onReload();
}

function clearTerm() {
    $("#d5221").val('');
    $("#d5222").val('');
    $("#keyWord").val('');
    $("#orderby").val('');
}

function orderby() {
    var orderby = $("#orderby").val();
    if (orderby == 0) {
        $("#orderby").val(1);
    } else {
        $("#orderby").val(0);
    }
    preciseSearch();
}


//前N天
function getBeforNday(date, n) {
    var yesterday_milliseconds = date.getTime() - n * 1000 * 60 * 60 * 24;
    var yesterday = new Date();
    yesterday.setTime(yesterday_milliseconds);

    var strYear = yesterday.getFullYear();
    var strDay = yesterday.getDate();
    var strMonth = yesterday.getMonth() + 1;
    if (strMonth < 10) {
        strMonth = "0" + strMonth;
    }
    datastr = strYear + "/" + strMonth + "/" + strDay;
    return datastr;
}

Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}


function checkLog(Id) {
    var today = new Date();
    var startTime = new Date(getBeforNday(today, 6)).format('yyyy-MM-dd');
    var month = today.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var endTime = today.getFullYear() + "-" + month + "-" + today.getDate();
    $("#d5223").val(startTime);
    $("#d5224").val(endTime);
    $("#weixinId").val(Id);
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/superUser/logMessStatistics.action",
        data: {"statisticsLogMessParameter.Id": Id,
            "statisticsLogMessParameter.startTime": startTime,
            "statisticsLogMessParameter.endTime": endTime
        },
        dataType: "html",
        success: function (msg) {
            $("#statisticsLogMess").html(msg);
            art.dialog({
                content: document.getElementById('statisticsLog'),
                title: "上行信息条数和下行信息条数",
                lock: true,
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

function searchCheckLog() {
    var startTime = $("#d5223").val();
    var endTime = $("#d5224").val();
    var Id = $("#weixinId").val();
    toolJS.loading(1);
    jQuery.ajax({
        type: "post",
        url: "/superUser/logMessStatistics.action",
        data: {"statisticsLogMessParameter.Id": Id,
            "statisticsLogMessParameter.startTime": startTime,
            "statisticsLogMessParameter.endTime": endTime
        },
        dataType: "html",
        success: function (msg) {
            $("#statisticsLogMess").html(msg);
            toolJS.loading(0);
        }
    });

}