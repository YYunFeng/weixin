/**
 * @author johnny
 * js工具
 */
(function () {
    toolPrizeQuiz = function () {

        var _title; // 标题
        var _content; // 摘要
        var _count; // 数量

        var isErrorBOOL = true; // 是否有错误条件
        //键盘监听
        document.onkeyup = function (e) {
            var act = document.activeElement.id; //获得焦点的ID
            switch (act) {
                case "title": // 标题
                    document.getElementById('moduletitleM').innerHTML = document.getElementById('title').value;
                    break;
                case "surveyContent": // 摘要
                    document.getElementById('modulecontentM').innerHTML = document.getElementById('surveyContent').value;
                    break;
                default:
                    break;
            }
            judge();
        }

        function judge() {
            _title = document.getElementById('title').value; // 标题
            _content = document.getElementById('surveyContent').value; // 摘要
            _count = document.getElementById('count').value; // 数量
            isErrorBOOL = false;
            // 标题
            document.getElementById('title').className = '';
            if (trim(_title) == '') {
                document.getElementById('title').className = 'errorinput';
                isErrorBOOL = true;
            }

            // 摘要
            document.getElementById('surveyContent').className = '';
            if (trim(_content) == '') {
                document.getElementById('surveyContent').className = 'errorinput';
                isErrorBOOL = true;
            }

            // 奖品数量
            document.getElementById('count').className = 'p_new_rect_input';
            if (trim(_count) == '' || isNaN(_count)) {
                document.getElementById('count').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;

            }

        }

        /**
         * 问卷调查 封面btn替换class
         **/
        function _moduleUpdateimg(_temp) {
            if (_temp == 'd') {
                document.getElementById('updata_img_btn_d').className = 'p_new_btn_l p_new_btn_hover';
                document.getElementById('updata_img_btn_u').className = 'p_new_btn_r';
                $('#previewPic').attr('src', '../images/prizequiz.jpg');
                $('#bigWheelPic').val('prizequiz.jpg');
            } else if (_temp == 'u') {
                document.getElementById('updata_img_btn_d').className = 'p_new_btn_l';
                document.getElementById('updata_img_btn_u').className = 'p_new_btn_r p_new_btn_hover';
            }
        }

        /**
         * 保存问卷调查  ---入库
         **/
        function _savePrizeQuiz() {
            if (isErrorBOOL) {
                toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
            } else {
                var title = $("#title").val();
                var content = $("#surveyContent").val();
                var pic = $("#bigWheelPic").val();
                var count = $("#count").val();
                jQuery.ajax({
                    type: "POST",
                    url: "/component/savePrizeQuiz.action",
                    data: {"component.title": title,
                        "component.intro": content,
                        "component.pic": pic,
                        "component.componentType": 2,
                        "survey.type": 1,
                        "survey.probability": 100,
                        "survey.count": count
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.status == 1) {
                            prizeQuizListContent();
                        }
                        if (data.status == 0) {
                            alert(data.mess);
                        }
                    }

                });
            }
        }

        /**
         * 修改问卷调查
         * @private
         */
        function _modifyPrizeQuiz(componentId, surveyId) {
            judge();
            if (confirm("确定要修改？")) {
                if (isErrorBOOL) {
                    toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
                } else {
                    var title = $("#title").val();
                    var content = $("#surveyContent").val();
                    var pic = $("#bigWheelPic").val();
                    var count = $("#count").val();
                    jQuery.ajax({
                        type: "POST",
                        url: "/component/saveModifyPrizeQuiz.action",
                        data: {
                            "component.Id": componentId,
                            "component.title": title,
                            "component.intro": content,
                            "component.pic": pic,
                            "survey.Id": surveyId,
                            "survey.type": 1,
                            "survey.probability": 100,
                            "survey.count": count
                        },
                        dataType: "json",
                        success: function (data) {
                            if (data.status == 1) {
                                prizeQuizListContent();
                            }
                            if (data.status == 0) {
                                alert(data.mess);
                            }
                        }
                    });
                }
            }
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
            moduleUpdateimg: _moduleUpdateimg, savePrizeQuiz: _savePrizeQuiz, modifyPrizeQuiz: _modifyPrizeQuiz
        }
    }()
})();
