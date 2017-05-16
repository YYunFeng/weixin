//键盘监听
document.onkeyup = function (e) {
    var act = document.activeElement.id; //获得焦点的ID
    switch (act) {
        case "title": // 标题
            document.getElementById('titleM').innerHTML = document.getElementById('title').value;
            break;
        case "desc": // 摘要
            document.getElementById('descM').innerHTML = document.getElementById('desc').value;
            break;
        default:
            break;
    }
    judge_operate_addJS();
}
var isErrorBOOL_operate_addJS = true;

function judge_operate_addJS() {
    _title = document.getElementById('title').value; // 标题
    _contentTextarea = document.getElementById('contentTextarea').value; // 正文
    isErrorBOOL_operate_addJS = false;

// 标题
    document.getElementById('title').style.border = '';
    if (trim(_title) == '') {
        document.getElementById('title').style.border = '1px solid #FF0033';
        isErrorBOOL_operate_addJS = true;
    }
    document.getElementById('contentTextarea').style.border = '';
    if (trim(_contentTextarea) == '') {
        document.getElementById('contentTextarea').style.border = '1px solid #FF0033';
        isErrorBOOL_operate_addJS = true;
    }
}

function finish_operate_addJS() {
    var title = $("#title").val();
    var picUrl = $("#singleImagePic").val();
    var abstractContent = $("#desc").val();
    var contentTextarea = $("#contentTextarea").val();

    if (isErrorBOOL_operate_addJS) {
        toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
    } else {
        jQuery.ajax({
            type: "post",
            url: "/material/saveSingleImageText.action",
            data: {"picMessage.title": title,
                "picMessage.picUrl": picUrl,
                "picMessage.abstractContent": abstractContent,
                "picMessage.message": contentTextarea
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    singleImageTextContent();
                }
                if (data.status == 0) {
                    alert(data.mess);
                }
            }
        });
    }
}





// 修改单图文 ---入库
function finish_operate_modifyJS(Id) {
    var title = $("#title").val();
    var picUrl = $("#singleImagePic").val();
    var abstractContent = $("#desc").val();
    var contentTextarea = $("#contentTextarea").val();

    if (isErrorBOOL_operate_addJS) {
        toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
    } else {
        jQuery.ajax({
            type: "post",
            url: "/material/saveModifySingleImageText.action",
            data: {
                "picMessage.Id": Id,
                "picMessage.title": title,
                "picMessage.picUrl": picUrl,
                "picMessage.abstractContent": abstractContent,
                "picMessage.message": contentTextarea
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    singleImageTextContent();
                }
                if (data.status == 0) {
                    alert(data.mess);
                }
            }
        });
    }
}

function trim(str) { //删除左右两端的空格
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

