/**
 * @author johnny
 * js工具
 */
(function () {
    settingJS = function () {


        var isErrorBOOL = true; // 是否有错误条件

//键盘监听
        document.onkeyup = function (e) {
            var act = document.activeElement.id; //获得焦点的ID

            /*
             switch(act){
             case "moduletitle": // 标题
             document.getElementById('moduletitleM').innerHTML = document.getElementById('moduletitle').value;
             document.getElementById('titleHTML5See').innerHTML = document.getElementById('moduletitle').value;

             break;

             default: break;
             }
             */
            _judge();

        }
        var _weixinAccount; // 公众平台账号
        var _businessName;  // 企业名称
        var _area; // 所在地
        var _linkman; // 联系人
        var _telephone; // 联系电话
        var _introduction; // 企业简介

        function _judge() {
            _weixinAccount = document.getElementById('weixinAccount').value;
            _businessName = document.getElementById('businessName').value;
            _area = document.getElementById('area').value;
            _linkman = document.getElementById('linkman').value;
            _telephone = document.getElementById('telephone').value;
            _introduction = document.getElementById('introduction').value;

            isErrorBOOL = false;
// 公众平台账号
            document.getElementById('weixinAccount').style.border = '';
            if (trim(_weixinAccount) == '') {
                document.getElementById('weixinAccount').style.border = '1px dotted #F03';
                isErrorBOOL = true;
            }
//
//// 企业名称
//            document.getElementById('businessName').style.border = '';
//            if (trim(_businessName) == '' || getWordsNum(_weixinAccount) > 30) {
//                document.getElementById('businessName').style.border = '1px dotted #F03';
//                isErrorBOOL = true;
//            }
//
//// 所在地
//            document.getElementById('area').style.border = '';
//            if (trim(_area) == '' || getWordsNum(_area) > 50) {
//                document.getElementById('area').style.border = '1px dotted #F03';
//                isErrorBOOL = true;
//            }

// 联系人
            document.getElementById('linkman').style.border = '';
            if (trim(_linkman) == '' || getWordsNum(_linkman) > 20) {
                document.getElementById('linkman').style.border = '1px dotted #F03';
                isErrorBOOL = true;
            }

// 联系电话
            document.getElementById('telephone').style.border = '';
            if (trim(_telephone) == '' || isNaN(_telephone) || getWordsNum(_telephone) > 20) {
                document.getElementById('telephone').style.border = '1px dotted #F03';
                isErrorBOOL = true;
            }

//// 企业简介
//            document.getElementById('introduction').style.border = '';
//            if (trim(_introduction) == '') {
//                document.getElementById('introduction').style.border = '1px dotted #F03';
//                isErrorBOOL = true;
//            }

        }


        /**
         *   // 保存微信关联账号
         **/
        function _saveFinish() {
            if (isErrorBOOL) {
                toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
            } else {
                var weixinAccount = $("#weixinAccount").val();
                var businessName = $("#businessName").val();
                var area = $("#area").val();
                var linkman = $("#linkman").val();
                var telephone = $("#telephone").val();
                var introduction = $("#introduction").val();
                jQuery.ajax({
                    type: "post",
                    url: "/setting/saveweixinaccountsetting.action",
                    data: {
                        "user.area": area,
                        "user.bussinessName": businessName,
                        "user.linkMan": linkman,
                        "user.telephone": telephone,
                        "user.introduction": introduction,
                        "userWeiXin.weixinAccount": weixinAccount
                    },
                    dataType: "html",
                    success: function (msg) {
                        jQuery("#main").html(msg);
                    }
                });
            }
        }

        /**
         * 判断是否为整数
         */
        function isPositiveInteger(value) {
            if (parseInt(value) == value) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 获取字数
         */
        function getWordsNum(text) {
            var _text = trim(text);
            var _zh = _text ? _text.match(/[^ -~]/g) : 0;
            var num = Math.ceil((_text.length + (_zh && _zh.length) || 0) / 2);
            return num;
        }

        function trim(str) { //删除左右两端的空格
            return str.replace(/(^\s*)|(\s*$)/g, "");
        }

        function ltrim(str) { //删除左边的空格
            return str.replace(/(^\s*)/g, "");
        }

        function rtrim(str) { //删除右边的空格
            return str.replace(/(\s*$)/g, "");
        }

        function isNum(str) {
            if (/[^\d]/.test(str)) {
//alert("请输入数字");
                return true
            } else {
                return false
            }
            ;
        };
        return {
            saveFinish: _saveFinish
        }
    }()
})();