/**
 * @author johnny
 * js工具
 */
(function () {
    toolBigWheelComponet = function () {

        var _title; // 标题
        var _content; // 摘要
        var _prize1; // 1等奖
        var _prize1Probability; // 概率
        var _prize1Num; // 数量
        var _prize2; // 2等奖
        var _prize2Probability;
        var _prize2Num;
        var _prize3; // 3等奖
        var _prize3Probability;
        var _prize3Num;
        var _ExtractionNum; // 抽取次数
        var _prizeContent; // 奖项说明
        var _tel; // 联系电话
        var _address; // 联系地址
        var _beizhu; // 联系备注

        var isErrorBOOL = true; // 是否有错误条件

//键盘监听
        document.onkeyup = function (e) {
            var act = document.activeElement.id; //获得焦点的ID
            switch (act) {
                case "moduletitle": // 标题
                    document.getElementById('moduletitleM').innerHTML = document.getElementById('moduletitle').value;
                    document.getElementById('titleHTML5See').innerHTML = document.getElementById('moduletitle').value;
                    break;
                case "modulecontent": // 摘要
                    document.getElementById('modulecontentM').innerHTML = document.getElementById('modulecontent').value;
                    break;
                case "moduleprize1": // 1等奖
                    document.getElementById('moduleprize1M').innerHTML = document.getElementById('moduleprize1').value;
                    break;
                case "moduleprize1Num":
                    document.getElementById('moduleprize1NumM').innerHTML = document.getElementById('moduleprize1Num').value;
                    break;
                case "moduleprize2": // 2等奖
                    document.getElementById('moduleprize2M').innerHTML = document.getElementById('moduleprize2').value;
                    break;
                case "moduleprize2Num":
                    document.getElementById('moduleprize2NumM').innerHTML = document.getElementById('moduleprize2Num').value;
                    break;
                case "moduleprize3": // 3等奖
                    document.getElementById('moduleprize3M').innerHTML = document.getElementById('moduleprize3').value;
                    break;
                case "moduleprize3Num":
                    document.getElementById('moduleprize3NumM').innerHTML = document.getElementById('moduleprize3Num').value;
                    break;
                case "moduleprizeContent": // 奖项说明
                    document.getElementById('moduleprizeContentM').innerHTML = document.getElementById('moduleprizeContent').value;
                    break;
                case "moduleExtractionNum": // 抽取次数
                    document.getElementById('moduleExtractionNumM').innerHTML = document.getElementById('moduleExtractionNum').value;
                    break;
                case "moduletel": // 联系电话
                    document.getElementById('moduletelM').innerHTML = document.getElementById('moduletel').value;
                    break;
                case "moduleaddress": // 联系地址
                    document.getElementById('moduleaddressM').innerHTML = document.getElementById('moduleaddress').value;
                    break;
                case "modulebeizhu": // 联系备注
                    document.getElementById('modulebeizhuM').innerHTML = document.getElementById('modulebeizhu').value;
                    break;
                default:
                    break;
            }

            judge();

        }

        function judge() {
            _title = document.getElementById('moduletitle').value; // 标题
            _content = document.getElementById('modulecontent').value; // 摘要
            _prize1 = document.getElementById('moduleprize1').value; // 1等奖
            _prize1Probability = document.getElementById('moduleprize1Probability').value; // 概率
            _prize1Num = document.getElementById('moduleprize1Num').value; // 数量
            _prize2 = document.getElementById('moduleprize2').value; // 2等奖
            _prize2Probability = document.getElementById('moduleprize2Probability').value;
            _prize2Num = document.getElementById('moduleprize2Num').value;
            _prize3 = document.getElementById('moduleprize3').value; // 3等奖
            _prize3Probability = document.getElementById('moduleprize3Probability').value;
            _prize3Num = document.getElementById('moduleprize3Num').value;
            _ExtractionNum = document.getElementById('moduleExtractionNum').value; // 抽取次数
            _prizeContent = document.getElementById('moduleprizeContent').value; // 奖项说明
            _tel = document.getElementById('moduletel').value; // 联系电话
            _address = document.getElementById('moduleaddress').value; // 联系地址
            _beizhu = document.getElementById('modulebeizhu').value; // 联系备注

            isErrorBOOL = false;
// 标题
            document.getElementById('moduletitle').className = '';
            if (trim(_title) == '' || getWordsNum(_title) > 30) {
                document.getElementById('moduletitle').className = 'errorinput';
                isErrorBOOL = true;
            }

// 摘要
            document.getElementById('modulecontent').className = '';
            if (trim(_content) == '' || getWordsNum(_content) > 180) {
                document.getElementById('modulecontent').className = 'errorinput';
                isErrorBOOL = true;

            }

// 1等奖
            document.getElementById('moduleprize1').className = '';
            if (trim(_prize1) == '') {
                document.getElementById('moduleprize1').className = 'errorinput';
                isErrorBOOL = true;
            }
// 1等奖 概率
            document.getElementById('moduleprize1Probability').className = 'p_new_rect_input';
            if (trim(_prize1Probability) == '' || isNaN(_prize1Probability) || _prize1Probability <= 0 || _prize1Probability > 100 ) {
                document.getElementById('moduleprize1Probability').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }
// 1等奖 数量
            document.getElementById('moduleprize1Num').className = 'p_new_rect_input';
            if(trim(_prize1Num)=='' || isNaN(_prize1Num) || _prize1Num <= 0 || !isPositiveInteger(_prize1Num)){ //--0507
                document.getElementById('moduleprize1Num').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }

// 2等奖
            document.getElementById('moduleprize2').className = '';
            if (trim(_prize2) == '') {
                document.getElementById('moduleprize2').className = 'errorinput';
                isErrorBOOL = true;
            }
// 2等奖 概率
            document.getElementById('moduleprize2Probability').className = 'p_new_rect_input';
            if(trim(_prize2Probability)=='' || isNaN(_prize2Probability)  || _prize2Probability <= 0 || _prize2Probability > 100){ //--0507
                document.getElementById('moduleprize2Probability').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }
// 2等奖 数量
            document.getElementById('moduleprize2Num').className = 'p_new_rect_input';
            if(trim(_prize2Num)=='' || isNaN(_prize2Num) || _prize2Num <= 0 || !isPositiveInteger(_prize2Num)){ //--0507
                document.getElementById('moduleprize2Num').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }

// 3等奖
            document.getElementById('moduleprize3').className = '';
            if (trim(_prize3) == '') {
                document.getElementById('moduleprize3').className = 'errorinput';
                isErrorBOOL = true;
            }
// 3等奖 概率
            document.getElementById('moduleprize3Probability').className = 'p_new_rect_input';
            if(trim(_prize3Probability)=='' || isNaN(_prize3Probability) || _prize3Probability <= 0 || _prize3Probability > 100){ //--0507
                document.getElementById('moduleprize3Probability').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }
// 3等奖 数量
            document.getElementById('moduleprize3Num').className = 'p_new_rect_input';
            if(trim(_prize3Num)=='' || isNaN(_prize3Num) || _prize3Num <= 0 || !isPositiveInteger(_prize3Num)){ //--0507
                document.getElementById('moduleprize3Num').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }

// 抽取次数
            document.getElementById('moduleExtractionNum').className = 'p_new_rect_input';
            if(trim(_ExtractionNum)=='' || isNaN(_ExtractionNum) || _ExtractionNum <= 0 || !isPositiveInteger(_ExtractionNum)){ //--0507
                document.getElementById('moduleExtractionNum').className = 'p_new_rect_input errorinput';
                isErrorBOOL = true;
            }

// 奖项说明
            document.getElementById('moduleprizeContent').className = 'p_new_rect_r_textarea';
            if (trim(_prizeContent) == '') {
                document.getElementById('moduleprizeContent').className = 'p_new_rect_r_textarea errorinput';
                isErrorBOOL = true;
            }

            //--0507 start
            var _moduletel = document.getElementById('moduletel').value;
            document.getElementById('moduletel').className = '';
            if(_moduletel.length > 0){
                if(isNaN(_moduletel) || _moduletel.length != 11){
                    document.getElementById('moduletel').className = 'errorinput';
                    isErrorBOOL = true;
                }else{
                }
            } //--0507 end
        }


        /**
         * 幸运大转盘 封面btn替换class
         **/
        function _moduleUpdateimg(_temp) {
            if (_temp == 'd') {
                document.getElementById('updata_img_btn_d').className = 'p_new_btn_l p_new_btn_hover';
                document.getElementById('updata_img_btn_u').className = 'p_new_btn_r';
                $('#previewPic').attr('src', '../images/module_list_1.jpg');
                $('#bigWheelPic').val('module_list_1.jpg');
            } else if (_temp == 'u') {
                document.getElementById('updata_img_btn_d').className = 'p_new_btn_l';
                document.getElementById('updata_img_btn_u').className = 'p_new_btn_r p_new_btn_hover';
            }
        }

        /**
         * 完成
         **/
        function _moduleFinish() {
            if (isErrorBOOL) {
                toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
            } else {
                var title = document.getElementById('moduletitle').value; // 标题
                var intro = document.getElementById('modulecontent').value; // 摘要
                var pic = document.getElementById('bigWheelPic').value; // 摘要
                var moduleprize1 = document.getElementById('moduleprize1').value; // 1等奖
                var moduleprize1Probability = document.getElementById('moduleprize1Probability').value; // 概率
                var moduleprize1Num = document.getElementById('moduleprize1Num').value; // 数量
                var moduleprize2 = document.getElementById('moduleprize2').value; // 2等奖
                var moduleprize2Probability = document.getElementById('moduleprize2Probability').value;
                var moduleprize2Num = document.getElementById('moduleprize2Num').value;
                var moduleprize3 = document.getElementById('moduleprize3').value; // 3等奖
                var moduleprize3Probability = document.getElementById('moduleprize3Probability').value;
                var moduleprize3Num = document.getElementById('moduleprize3Num').value;
                var moduleExtractionNum = document.getElementById('moduleExtractionNum').value; // 抽取次数
                var moduleprizeContent = document.getElementById('moduleprizeContent').value; // 奖项说明
                var moduletel = document.getElementById('moduletel').value; // 联系电话
                var moduleaddress = document.getElementById('moduleaddress').value; // 联系地址
                var modulebeizhu = document.getElementById('modulebeizhu').value; // 联系备注
                var endTime = document.getElementById('endTime').value; // 结束时间
                var needContact = document.getElementById("needContanct").checked;
                // 判断是否需要调用接口
                var flag = document.getElementById('flag').value;
                var keyword_id = document.getElementById('keyword_id').value;
                jQuery.ajax({
                    type: "POST",
                    url: "/component/saveBigWheelCompont.action",
                    data: {'bigWheelRingLuckyPrizeList[0].prizeName': moduleprize1, 'bigWheelRingLuckyPrizeList[0].probability': moduleprize1Probability, "bigWheelRingLuckyPrizeList[0].count": moduleprize1Num,
                        'bigWheelRingLuckyPrizeList[1].prizeName': moduleprize2, 'bigWheelRingLuckyPrizeList[1].probability': moduleprize2Probability, "bigWheelRingLuckyPrizeList[1].count": moduleprize2Num,
                        'bigWheelRingLuckyPrizeList[2].prizeName': moduleprize3, 'bigWheelRingLuckyPrizeList[2].probability': moduleprize3Probability, "bigWheelRingLuckyPrizeList[2].count": moduleprize3Num,
                        'bigWheelRingLucky.luckyCount': moduleExtractionNum,
                        'bigWheelRingLucky.luckyIntro': moduleprizeContent,
                        'bigWheelRingLucky.address': moduleaddress,
                        'bigWheelRingLucky.telphone': moduletel,
                        'bigWheelRingLucky.remark': modulebeizhu,
                        'bigWheelRingLucky.needContact': needContact,
                        'component.componentType': 0,
                        'component.endTime': endTime,
                        'component.title': title,
                        'component.intro': intro,
                        'component.pic': pic,
                        'component.flag':flag,
                        'component.keyword_id':keyword_id
                    },
                    dataType: "JSON",
                    success: function (data) {
                        if (data.status == 1) {
                            bigWheelComponentContent();
                        }
                        if (data.status == 0) {
                            alert('保存失败');
                        }
                    }
                });
            }
        }

        /**
         * 修改大转盘
         * @param componentId
         * @param luckyring_id
         * @private
         */
        function _modifyBigWheelComponent(componentId, luckyring_id) {
            judge();
            if (confirm("确定要修改？")) {
                if (isErrorBOOL) {
                    toolJS.alertAuto(1, '对不起，您有不符合规则的条件');
                } else {
                    var title = document.getElementById('moduletitle').value; // 标题
                    var intro = document.getElementById('modulecontent').value; // 摘要
                    var pic = document.getElementById('bigWheelPic').value;
                    var moduleprize1 = document.getElementById('moduleprize1').value; // 1等奖
                    var moduleprize1Probability = document.getElementById('moduleprize1Probability').value; // 概率
                    var moduleprize1Num = document.getElementById('moduleprize1Num').value; // 数量
                    var moduleprize2 = document.getElementById('moduleprize2').value; // 2等奖
                    var moduleprize2Probability = document.getElementById('moduleprize2Probability').value;
                    var moduleprize2Num = document.getElementById('moduleprize2Num').value;
                    var moduleprize3 = document.getElementById('moduleprize3').value; // 3等奖
                    var moduleprize3Probability = document.getElementById('moduleprize3Probability').value;
                    var moduleprize3Num = document.getElementById('moduleprize3Num').value;
                    var moduleExtractionNum = document.getElementById('moduleExtractionNum').value; // 抽取次数
                    var moduleprizeContent = document.getElementById('moduleprizeContent').value; // 奖项说明
                    var moduletel = document.getElementById('moduletel').value; // 联系电话
                    var moduleaddress = document.getElementById('moduleaddress').value; // 联系地址
                    var modulebeizhu = document.getElementById('modulebeizhu').value; // 联系备注
                    var bigWheelRingLuckyId = document.getElementById('bigWheelRingLuckyPrizeList').value; // 奖项1，ID
                    var bigWheelRingLuckyId1 = document.getElementById('bigWheelRingLuckyPrizeList1').value;// 奖项2，ID
                    var bigWheelRingLuckyId2 = document.getElementById('bigWheelRingLuckyPrizeList2').value;// 奖项3，ID
                    var endTime = document.getElementById('endTime').value; // 结束时间
                    var needContact = document.getElementById("needContanct").checked;
                    jQuery.ajax({
                        type: "POST",
                        url: "/component/saveModifyBigWheelComponent.action",
                        data: {'bigWheelRingLuckyPrizeList[0].prizeName': moduleprize1, 'bigWheelRingLuckyPrizeList[0].probability': moduleprize1Probability,  "bigWheelRingLuckyPrizeList[0].Id": bigWheelRingLuckyId,
                            'bigWheelRingLuckyPrizeList[1].prizeName': moduleprize2, 'bigWheelRingLuckyPrizeList[1].probability': moduleprize2Probability,  "bigWheelRingLuckyPrizeList[1].Id": bigWheelRingLuckyId1,
                            'bigWheelRingLuckyPrizeList[2].prizeName': moduleprize3, 'bigWheelRingLuckyPrizeList[2].probability': moduleprize3Probability, "bigWheelRingLuckyPrizeList[2].Id": bigWheelRingLuckyId2,
                            'bigWheelRingLucky.luckyCount': moduleExtractionNum,
                            'bigWheelRingLucky.luckyIntro': moduleprizeContent,
                            'bigWheelRingLucky.address': moduleaddress,
                            'bigWheelRingLucky.Id': luckyring_id,
                            'bigWheelRingLucky.telphone': moduletel,
                            'bigWheelRingLucky.remark': modulebeizhu,
                            'bigWheelRingLucky.needContact': needContact,
                            'component.componentType': 0,
                            'component.endTime': endTime,
                            'component.title': title,
                            'component.intro': intro,
                            'component.pic': pic,
                            'component.Id': componentId
                        },
                        dataType: "JSON",
                        success: function (data) {
                            if (data.status == 1) {
                                bigWheelComponentContent();
                            }
                            if (data.status == 0) {
                                alert('保存失败');
                            }
                        }
                    });
                }
            }
        }


        function isPositiveInteger(value){
            if(parseInt(value)==value){
                return true;
            }else {
                return false;
            }
        }
        /**
         * 获取字数
         */
        function getWordsNum(text){
            var _text = trim(text);
            var _zh = _text ? _text.match(/[^ -~]/g) : 0;
            var num = Math.ceil((_text.length + (_zh && _zh.length) || 0)/2);
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
            moduleUpdateimg: _moduleUpdateimg, moduleFinish: _moduleFinish, modifyBigWheelComponent: _modifyBigWheelComponent
        }
    }()
})();