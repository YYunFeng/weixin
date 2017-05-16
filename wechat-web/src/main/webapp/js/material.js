/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: 下午5:31
 * To change this template use File | Settings | File Templates.
 */

// 单图文
function singleImageTextContent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/material/singleImageTextContent.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            $("#singleImageText").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 添加单图文
function addSingleImageText() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/material/addSingleImageText.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}


// 修改单图文
function modifySingleImageText(id) {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/material/modifySingleImageText.action",
        data: {"material.id": id,
            "material.type": 0
        },
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}

// 上传图片---单图文
function uploadSingleImageTexePic() {
    $("#singleImageTextUploadpic").uploadify({
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
        'scriptData': {'type': 2},
        'buttonImg': '/images/uploadimgMaterial.png',
        'width': 242,
        'onError': function (event, queueID, fileObj, errorObj) {
            alert(" 上传失败!");
        },
        'onComplete': function (event, queueID, fileObj, response) {
            if (response != '') {
                var date = jQuery.parseJSON(response);
                $('#previewPic').attr('src', date.viewPath);
                document.getElementById('picTitle').style.display = "none";
                $('#singleImagePic').val(date.fileName);
            } else {
                alert('上传失败!');
            }
        }
    });
}


// 上传图片---多图文
function uploadManyImageTexePic(Id) {
    $("#ManyImageTextUploadpic" + Id).uploadify({
        'uploader': '/js/uploadify-v2.1.4/uploadify.swf',
        'script': "/upload/uploadPic.action",//后台处理的请求
        'cancelImg': '/js/uploadify-v2.1.4/cancel.png',
        'fileDataName': 'uploadFile',//服务器端根据这个接收文件
        'queueID': 'fileQueue' + Id,//与下面的id对应
        'queueSizeLimit': 1,
        'fileDesc': '图片文件',
        'fileExt': '*.*', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
        'auto': true,
        'multi': false,
        'scriptData': {'type': 2},
        'buttonImg': '/images/uploadimgMaterial.png',
        'width': 242,
        'onError': function (event, queueID, fileObj, errorObj) {
            alert(" 上传失败!");
        },
        'onComplete': function (event, queueID, fileObj, response) {
            if (response != '') {
                var date = jQuery.parseJSON(response);
                operatemore_JS.uploadImg_Finish(Id, date.viewPath, date.fileName);
            } else {
                alert('上传失败!');
            }
        }
    });
}
// 清除样式
function clearStyle() {
    $("#materialList li").each(function () {
        $(this).removeClass();
    });
}
// 删除图文
function deleteMaterial(id, type) {
    if (confirm("确定要删除?")) {
        jQuery.ajax({
            type: "POST",
            url: "/material/delteMaterial.action",
            data: {"Id": id },
            dataType: "json",
            success: function (data) {
                if (data.status == 1) {
                    if (type == 0) {
                        singleImageTextContent();
                    } else {
                        manyImageTextConent();
                    }
                } else {
                    alert("删除失败！");
                }
            }
        });
    }
}

//多图文
function manyImageTextConent() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/material/manyImageTextConent.action",
        dataType: "html",
        success: function (msg) {
            clearStyle();
            jQuery("#content").html(msg);
            $("#manyImageText").addClass("selected");
            toolJS.loading(0);
        }
    });
}
// 添加多图文
function addManyImageText() {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/material/addManyImageText.action",
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}


// 修改单图文
function modifyManyImageText(id) {
    toolJS.loading(1);
    jQuery.ajax({
        type: "POST",
        url: "/material/modifyManyImageText.action",
        data: {"material.id": id,
            "material.type": 1
        },
        dataType: "html",
        success: function (msg) {
            jQuery("#content").html(msg);
            toolJS.loading(0);
        }
    });
}