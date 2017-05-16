/**
 * @author johnny
 * js工具
 */
(function () {
    operatemore_JS = function () {

        var tuwenNumber = 2; // 图文数量
        var _title1 = '';
        var _contentbody1 = '';
        var _i_img_appmsgItem1 = '';
        var _title2 = '';
        var _contentbody2 = '';
        var _i_img_appmsgItem2 = '';
        var _title3 = '';
        var _contentbody3 = '';
        var _i_img_appmsgItem3 = '';
        var _title4 = '';
        var _contentbody4 = '';
        var _i_img_appmsgItem4 = '';
        var _title5 = '';
        var _contentbody5 = '';
        var _i_img_appmsgItem5 = '';
        var _title6 = '';
        var _contentbody6 = '';
        var _i_img_appmsgItem6 = '';
        var _title7 = '';
        var _contentbody7 = '';
        var _i_img_appmsgItem7 = '';
        var _title8 = '';
        var _contentbody8 = '';
        var _i_img_appmsgItem8 = '';


//键盘监听
        document.onkeyup = function (e) {
            var act = document.activeElement.id; //获得焦点的ID
            switch (act) {
                case "title1": // 标题
                    document.getElementById('title_appmsgItem1').innerHTML = document.getElementById('title1').value;
                    break;
                case "title2": // 标题
                    document.getElementById('title_appmsgItem2').innerHTML = document.getElementById('title2').value;
                    break;
                case "title3": // 标题
                    document.getElementById('title_appmsgItem3').innerHTML = document.getElementById('title3').value;
                    break;
                case "title4": // 标题
                    document.getElementById('title_appmsgItem4').innerHTML = document.getElementById('title4').value;
                    break;
                case "title5": // 标题
                    document.getElementById('title_appmsgItem5').innerHTML = document.getElementById('title5').value;
                    break;
                case "title6": // 标题
                    document.getElementById('title_appmsgItem6').innerHTML = document.getElementById('title6').value;
                    break;
                case "title7": // 标题
                    document.getElementById('title_appmsgItem7').innerHTML = document.getElementById('title7').value;
                    break;
                case "title8": // 标题
                    document.getElementById('title_appmsgItem8').innerHTML = document.getElementById('title8').value;
                    break;
                default:
                    break;
            }

        }

        var isFirstSelect1 = false;
        var isFirstSelect2 = false;
        var isFirstSelect3 = false;
        var isFirstSelect4 = false;
        var isFirstSelect5 = false;
        var isFirstSelect6 = false;
        var isFirstSelect7 = false;
        var isFirstSelect8 = false;

        function _selectPage(_temp) {
            tuwenNumber = _temp < 2 ? 2 : _temp;

            document.getElementById('appmsgItem3').style.display = 'none';
            document.getElementById('appmsgItem4').style.display = 'none';
            document.getElementById('appmsgItem5').style.display = 'none';
            document.getElementById('appmsgItem6').style.display = 'none';
            document.getElementById('appmsgItem7').style.display = 'none';
            document.getElementById('appmsgItem8').style.display = 'none';

            document.getElementById('tuwen1').style.display = 'none';
            document.getElementById('tuwen2').style.display = 'none';
            document.getElementById('tuwen3').style.display = 'none';
            document.getElementById('tuwen4').style.display = 'none';
            document.getElementById('tuwen5').style.display = 'none';
            document.getElementById('tuwen6').style.display = 'none';
            document.getElementById('tuwen7').style.display = 'none';
            document.getElementById('tuwen8').style.display = 'none';
            document.getElementById('tuwencont1').className = 'pagehtml_rect';
            document.getElementById('tuwencont2').className = 'pagehtml_rect';
            document.getElementById('tuwencont3').className = 'pagehtml_rect hide';
            document.getElementById('tuwencont4').className = 'pagehtml_rect hide';
            document.getElementById('tuwencont5').className = 'pagehtml_rect hide';
            document.getElementById('tuwencont6').className = 'pagehtml_rect hide';
            document.getElementById('tuwencont7').className = 'pagehtml_rect hide';
            document.getElementById('tuwencont8').className = 'pagehtml_rect hide';
            switch (_temp) {
                case 1:
                    document.getElementById('tuwencont1').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen1').style.display = 'block';
                    if (!isFirstSelect1) {
                        /*uploadManyImageTexePic(1);*/
                    }
                    isFirstSelect1 = true;
                    break;
                case 2:
                    document.getElementById('tuwencont2').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen2').style.display = 'block';
                    if (!isFirstSelect2) {
                        uploadManyImageTexePic(2);
                    }
                    isFirstSelect2 = true;
                    break;
                case 3:
                    document.getElementById('appmsgItem3').style.display = 'block';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont4').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen3').style.display = 'block';
                    if (!isFirstSelect3) {
                        uploadManyImageTexePic(3);
                    }
                    isFirstSelect3 = true;
                    break;
                case 4:
                    document.getElementById('appmsgItem3').style.display = 'block';
                    document.getElementById('appmsgItem4').style.display = 'block';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect';
                    document.getElementById('tuwencont4').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont5').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen4').style.display = 'block';
                    if (!isFirstSelect4) {
                        uploadManyImageTexePic(4);
                    }
                    isFirstSelect4 = true;
                    break;
                case 5:
                    document.getElementById('appmsgItem3').style.display = 'block';
                    document.getElementById('appmsgItem4').style.display = 'block';
                    document.getElementById('appmsgItem5').style.display = 'block';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect';
                    document.getElementById('tuwencont4').className = 'pagehtml_rect';
                    document.getElementById('tuwencont5').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont6').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen5').style.display = 'block';
                    if (!isFirstSelect5) {
                        uploadManyImageTexePic(5);
                    }
                    isFirstSelect5 = true;
                    break;
                case 6:
                    document.getElementById('appmsgItem3').style.display = 'block';
                    document.getElementById('appmsgItem4').style.display = 'block';
                    document.getElementById('appmsgItem5').style.display = 'block';
                    document.getElementById('appmsgItem6').style.display = 'block';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect';
                    document.getElementById('tuwencont4').className = 'pagehtml_rect';
                    document.getElementById('tuwencont5').className = 'pagehtml_rect';
                    document.getElementById('tuwencont6').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont7').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen6').style.display = 'block';
                    if (!isFirstSelect6) {
                        uploadManyImageTexePic(6);
                    }
                    isFirstSelect6 = true;
                    break;
                case 7:
                    document.getElementById('appmsgItem3').style.display = 'block';
                    document.getElementById('appmsgItem4').style.display = 'block';
                    document.getElementById('appmsgItem5').style.display = 'block';
                    document.getElementById('appmsgItem6').style.display = 'block';
                    document.getElementById('appmsgItem7').style.display = 'block';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect';
                    document.getElementById('tuwencont4').className = 'pagehtml_rect';
                    document.getElementById('tuwencont5').className = 'pagehtml_rect';
                    document.getElementById('tuwencont6').className = 'pagehtml_rect';
                    document.getElementById('tuwencont7').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwencont8').className = 'pagehtml_rect border-dotted';
                    document.getElementById('tuwen7').style.display = 'block';
                    if (!isFirstSelect7) {
                        uploadManyImageTexePic(7);
                    }
                    isFirstSelect7 = true;
                    break;
                case 8:
                    document.getElementById('appmsgItem3').style.display = 'block';
                    document.getElementById('appmsgItem4').style.display = 'block';
                    document.getElementById('appmsgItem5').style.display = 'block';
                    document.getElementById('appmsgItem6').style.display = 'block';
                    document.getElementById('appmsgItem7').style.display = 'block';
                    document.getElementById('appmsgItem8').style.display = 'block';
                    document.getElementById('tuwencont3').className = 'pagehtml_rect';
                    document.getElementById('tuwencont4').className = 'pagehtml_rect';
                    document.getElementById('tuwencont5').className = 'pagehtml_rect';
                    document.getElementById('tuwencont6').className = 'pagehtml_rect';
                    document.getElementById('tuwencont7').className = 'pagehtml_rect';
                    document.getElementById('tuwencont8').className = 'pagehtml_rect p_new_btn_hover';
                    document.getElementById('tuwen8').style.display = 'block';
                    if (!isFirstSelect8) {
                        uploadManyImageTexePic(8);
                    }
                    isFirstSelect8 = true;
                    break;
                default:
                    break;
            }
        }


        /**
         * 判断
         **/
        function _judge() {
            var errorTempAll = false;
            var errorTemp1 = false;
            var errorTemp2 = false;
            var errorTemp3 = false;
            var errorTemp4 = false;
            var errorTemp5 = false;
            var errorTemp6 = false;
            var errorTemp7 = false;
            var errorTemp8 = false;
            document.getElementById('appmsgItem1').style.border = '';
            document.getElementById('appmsgItem2').style.border = '';
            document.getElementById('appmsgItem3').style.border = '';
            document.getElementById('appmsgItem4').style.border = '';
            document.getElementById('appmsgItem5').style.border = '';
            document.getElementById('appmsgItem6').style.border = '';
            document.getElementById('appmsgItem7').style.border = '';
            document.getElementById('appmsgItem8').style.border = '';


            _title1 = document.getElementById('title1').value;
            _contentbody1 = document.getElementById('contentbody1').value;
            _i_img_appmsgItem1 = document.getElementById('i_img_hidden_appmsgItem1').value;
            if (trim(_title1).length < 1 || trim(_contentbody1).length < 1 || trim(_i_img_appmsgItem1).length < 1 || getWordsNum(_title1) > 30) {
                errorTemp1 = true;
                document.getElementById('appmsgItem1').style.border = '1px dotted #F03';
            }

            _title2 = document.getElementById('title2').value;
            _contentbody2 = document.getElementById('contentbody2').value;
            _i_img_appmsgItem2 = document.getElementById('i_img_hidden_appmsgItem2').value;
            if (trim(_title2).length < 1 || trim(_contentbody2).length < 1 || trim(_i_img_appmsgItem2).length < 1 || getWordsNum(_title2) > 30) {
                errorTemp2 = true;
                document.getElementById('appmsgItem2').style.border = '1px dotted #F03';
            }

            _title3 = document.getElementById('title3').value;
            _contentbody3 = document.getElementById('contentbody3').value;
            _i_img_appmsgItem3 = document.getElementById('i_img_hidden_appmsgItem3').value;
            if (trim(_title3).length < 1 || trim(_contentbody3).length < 1 || trim(_i_img_appmsgItem3).length < 1 || getWordsNum(_title3) > 30) {
                errorTemp3 = true;
                document.getElementById('appmsgItem3').style.border = '1px dotted #F03';
            }

            _title4 = document.getElementById('title4').value;
            _contentbody4 = document.getElementById('contentbody4').value;
            _i_img_appmsgItem4 = document.getElementById('i_img_hidden_appmsgItem4').value;
            if (trim(_title4).length < 1 || trim(_contentbody4).length < 1 || trim(_i_img_appmsgItem4).length < 1 || getWordsNum(_title4) > 30) {
                errorTemp4 = true;
                document.getElementById('appmsgItem4').style.border = '1px dotted #F03';
            }

            _title5 = document.getElementById('title5').value;
            _contentbody5 = document.getElementById('contentbody5').value;
            _i_img_appmsgItem5 = document.getElementById('i_img_hidden_appmsgItem5').value;
            if (trim(_title5).length < 1 || trim(_contentbody5).length < 1 || trim(_i_img_appmsgItem5).length < 1 || getWordsNum(_title5) > 30) {
                errorTemp5 = true;
                document.getElementById('appmsgItem5').style.border = '1px dotted #F03';
            }

            _title6 = document.getElementById('title6').value;
            _contentbody6 = document.getElementById('contentbody6').value;
            _i_img_appmsgItem6 = document.getElementById('i_img_hidden_appmsgItem6').value;
            if (trim(_title6).length < 1 || trim(_contentbody6).length < 1 || trim(_i_img_appmsgItem6).length < 1 || getWordsNum(_title6) > 30) {
                errorTemp6 = true;
                document.getElementById('appmsgItem6').style.border = '1px dotted #F03';
            }

            _title7 = document.getElementById('title7').value;
            _contentbody7 = document.getElementById('contentbody7').value;
            _i_img_appmsgItem7 = document.getElementById('i_img_hidden_appmsgItem7').value;
            if (trim(_title7).length < 1 || trim(_contentbody7).length < 1 || trim(_i_img_appmsgItem7).length < 1 || getWordsNum(_title7) > 30) {
                errorTemp7 = true;
                document.getElementById('appmsgItem7').style.border = '1px dotted #F03';
            }

            _title8 = document.getElementById('title8').value;
            _contentbody8 = document.getElementById('contentbody8').value;
            _i_img_appmsgItem8 = document.getElementById('i_img_hidden_appmsgItem8').value;
            if (trim(_title8).length < 1 || trim(_contentbody8).length < 1 || trim(_i_img_appmsgItem8).length < 1 || getWordsNum(_title8) > 30) {
                errorTemp8 = true;
                document.getElementById('appmsgItem8').style.border = '1px dotted #F03';
            }

            switch (tuwenNumber) {
                case 1:
                    if (errorTemp1 || errorTemp2) {
                        errorTempAll = true;
                    }
                    break;
                case 2:
                    if (errorTemp1 || errorTemp2) {
                        errorTempAll = true;
                    }
                    break;
                case 3:
                    if (errorTemp1 || errorTemp2 || errorTemp3) {
                        errorTempAll = true;
                    }
                    break;
                case 4:
                    if (errorTemp1 || errorTemp2 || errorTemp3 || errorTemp4) {
                        errorTempAll = true;
                    }
                    break;
                case 5:
                    if (errorTemp1 || errorTemp2 || errorTemp3 || errorTemp4 || errorTemp5) {
                        errorTempAll = true;
                    }
                    break;
                case 6:
                    if (errorTemp1 || errorTemp2 || errorTemp3 || errorTemp4 || errorTemp5 || errorTemp6) {
                        errorTempAll = true;
                    }
                    break;
                case 7:
                    if (errorTemp1 || errorTemp2 || errorTemp3 || errorTemp4 || errorTemp5 || errorTemp6 || errorTemp7) {
                        errorTempAll = true;
                    }
                    break;
                case 8:
                    if (errorTemp1 || errorTemp2 || errorTemp3 || errorTemp4 || errorTemp5 || errorTemp6 || errorTemp7 || errorTemp8) {
                        errorTempAll = true;
                    }
                    break;
                default:
                    break;
            }
            return errorTempAll
        }

        /**
         * 完成
         **/
        function _saveFinish() {
            var isError = _judge();
            var title1 = $("#title1").val();
            var picUrl1 = $("#i_img_hidden_appmsgItem1").val();
            var contentTextarea1 = $("#contentbody1").val();
            var title2 = $("#title2").val();
            var picUrl2 = $("#i_img_hidden_appmsgItem2").val();
            var contentTextarea2 = $("#contentbody2").val();
            var title3 = $("#title3").val();
            var picUrl3 = $("#i_img_hidden_appmsgItem3").val();
            var contentTextarea3 = $("#contentbody3").val();
            var title4 = $("#title4").val();
            var picUrl4 = $("#i_img_hidden_appmsgItem4").val();
            var contentTextarea4 = $("#contentbody4").val();
            var title5 = $("#title5").val();
            var picUrl5 = $("#i_img_hidden_appmsgItem5").val();
            var contentTextarea5 = $("#contentbody5").val();
            var title6 = $("#title6").val();
            var picUrl6 = $("#i_img_hidden_appmsgItem6").val();
            var contentTextarea6 = $("#contentbody6").val();
            var title7 = $("#title7").val();
            var picUrl7 = $("#i_img_hidden_appmsgItem7").val();
            var contentTextarea7 = $("#contentbody7").val();
            var title8 = $("#title8").val();
            var picUrl8 = $("#i_img_hidden_appmsgItem8").val();
            var contentTextarea8 = $("#contentbody8").val();
            if (isError) {
                toolJS.alertAuto(1, '对不起，您有不符合规则的条件<br /><div style="font-size: 16px; text-align: left; width: 80%; padding: 0px 10%;">温馨提示：<br />标题不能为空且长度不能超过30个字<br />上传图片不能为空<br />正文内容不能为空</div>');
            } else {

                jQuery.ajax({
                    type: "post",
                    url: "/material/saveManyImageText.action",
                    data: {
                        "picMessageList[0].title": title1,
                        "picMessageList[0].picUrl": picUrl1,
                        "picMessageList[0].message": contentTextarea1,
                        "picMessageList[0].seq": 1,
                        "picMessageList[1].title": title2,
                        "picMessageList[1].picUrl": picUrl2,
                        "picMessageList[1].message": contentTextarea2,
                        "picMessageList[1].seq": 2,
                        "picMessageList[2].title": title3,
                        "picMessageList[2].picUrl": picUrl3,
                        "picMessageList[2].message": contentTextarea3,
                        "picMessageList[2].seq": 3,
                        "picMessageList[3].title": title4,
                        "picMessageList[3].picUrl": picUrl4,
                        "picMessageList[3].message": contentTextarea4,
                        "picMessageList[3].seq": 4,
                        "picMessageList[4].title": title5,
                        "picMessageList[4].picUrl": picUrl5,
                        "picMessageList[4].message": contentTextarea5,
                        "picMessageList[4].seq": 5,
                        "picMessageList[5].title": title6,
                        "picMessageList[5].picUrl": picUrl6,
                        "picMessageList[5].message": contentTextarea6,
                        "picMessageList[5].seq": 6,
                        "picMessageList[6].title": title7,
                        "picMessageList[6].picUrl": picUrl7,
                        "picMessageList[6].message": contentTextarea7,
                        "picMessageList[6].seq": 7,
                        "picMessageList[7].title": title8,
                        "picMessageList[7].picUrl": picUrl8,
                        "picMessageList[7].message": contentTextarea8,
                        "picMessageList[7].seq": 8
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.status == 1) {
                            manyImageTextConent();
                        }
                        if (data.status == 0) {
                            alert(data.mess);
                        }
                    }
                });

            }
        }

        // 修改多图文
        function _savemodifyManyImageText() {
            var picMessageCount = $("manyImageCount").val();
            if (picMessageCount != tuwenNumber) {
                if(confirm("你确定要修改成"+tuwenNumber+"条图文")){
                    for (var i = tuwenNumber + 1; i < 8; i++) {
                        $("#title" + i).val('');
                        $("#contentbody" + i).val('');
                        $("#i_img_hidden_appmsgItem" + i).val('');
                    }
                }
            }
            var isError = _judge();
            var title1 = $("#title1").val();
            var picUrl1 = $("#i_img_hidden_appmsgItem1").val();
            var contentTextarea1 = $("#contentbody1").val();
            var id1 = $("#i_img_hidden_Id1").val();
            var title2 = $("#title2").val();
            var picUrl2 = $("#i_img_hidden_appmsgItem2").val();
            var contentTextarea2 = $("#contentbody2").val();
            var title3 = $("#title3").val();
            var picUrl3 = $("#i_img_hidden_appmsgItem3").val();
            var contentTextarea3 = $("#contentbody3").val();
            var title4 = $("#title4").val();
            var picUrl4 = $("#i_img_hidden_appmsgItem4").val();
            var contentTextarea4 = $("#contentbody4").val();
            var title5 = $("#title5").val();
            var picUrl5 = $("#i_img_hidden_appmsgItem5").val();
            var contentTextarea5 = $("#contentbody5").val();
            var title6 = $("#title6").val();
            var picUrl6 = $("#i_img_hidden_appmsgItem6").val();
            var contentTextarea6 = $("#contentbody6").val();
            var title7 = $("#title7").val();
            var picUrl7 = $("#i_img_hidden_appmsgItem7").val();
            var contentTextarea7 = $("#contentbody7").val();
            var title8 = $("#title8").val();
            var picUrl8 = $("#i_img_hidden_appmsgItem8").val();
            var contentTextarea8 = $("#contentbody8").val();
            if (isError) {
                toolJS.alertAuto(1, '对不起，您有不符合规则的条件<br /><div style="font-size: 16px; text-align: left; width: 80%; padding: 0px 10%;">温馨提示：<br />标题不能为空且长度不能超过30个字<br />上传图片不能为空<br />正文内容不能为空</div>');
            } else {

                jQuery.ajax({
                    type: "post",
                    url: "/material/saveModifyManyImageText.action",
                    data: {
                        "picMessageList[0].materialId": id1,
                        "picMessageList[0].title": title1,
                        "picMessageList[0].picUrl": picUrl1,
                        "picMessageList[0].message": contentTextarea1,
                        "picMessageList[0].seq": 1,
                        "picMessageList[1].title": title2,
                        "picMessageList[1].picUrl": picUrl2,
                        "picMessageList[1].message": contentTextarea2,
                        "picMessageList[1].seq": 2,
                        "picMessageList[2].title": title3,
                        "picMessageList[2].picUrl": picUrl3,
                        "picMessageList[2].message": contentTextarea3,
                        "picMessageList[2].seq": 3,
                        "picMessageList[3].title": title4,
                        "picMessageList[3].picUrl": picUrl4,
                        "picMessageList[3].message": contentTextarea4,
                        "picMessageList[3].seq": 4,
                        "picMessageList[4].title": title5,
                        "picMessageList[4].picUrl": picUrl5,
                        "picMessageList[4].message": contentTextarea5,
                        "picMessageList[4].seq": 5,
                        "picMessageList[5].title": title6,
                        "picMessageList[5].picUrl": picUrl6,
                        "picMessageList[5].message": contentTextarea6,
                        "picMessageList[5].seq": 6,
                        "picMessageList[6].title": title7,
                        "picMessageList[6].picUrl": picUrl7,
                        "picMessageList[6].message": contentTextarea7,
                        "picMessageList[6].seq": 7,
                        "picMessageList[7].title": title8,
                        "picMessageList[7].picUrl": picUrl8,
                        "picMessageList[7].message": contentTextarea8,
                        "picMessageList[7].seq": 8
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.status == 1) {
                            manyImageTextConent();
                        }
                        if (data.status == 0) {
                            alert(data.mess);
                        }
                    }
                });
            }

        }

        /**
         * 上传封面图片
         */
        function _uploadImg_Finish(numTemp, srcTemp, picUrl) {
            switch (numTemp) {
                case 1:
                    document.getElementById('default_appmsgItem1').style.display = 'none';
                    document.getElementById('i_img_appmsgItem1').style.display = 'block';
                    document.getElementById('i_img_appmsgItem1').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem1').value = picUrl;
                    break;
                case 2:
                    document.getElementById('default_appmsgItem2').style.display = 'none';
                    document.getElementById('i_img_appmsgItem2').style.display = 'block';
                    document.getElementById('i_img_appmsgItem2').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem2').value = picUrl;
                    break;
                case 3:
                    document.getElementById('default_appmsgItem3').style.display = 'none';
                    document.getElementById('i_img_appmsgItem3').style.display = 'block';
                    document.getElementById('i_img_appmsgItem3').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem3').value = picUrl;
                    break;
                case 4:
                    document.getElementById('default_appmsgItem4').style.display = 'none';
                    document.getElementById('i_img_appmsgItem4').style.display = 'block';
                    document.getElementById('i_img_appmsgItem4').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem4').value = picUrl;
                    break;
                case 5:
                    document.getElementById('default_appmsgItem5').style.display = 'none';
                    document.getElementById('i_img_appmsgItem5').style.display = 'block';
                    document.getElementById('i_img_appmsgItem5').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem5').value = picUrl;
                    break;
                case 6:
                    document.getElementById('default_appmsgItem6').style.display = 'none';
                    document.getElementById('i_img_appmsgItem6').style.display = 'block';
                    document.getElementById('i_img_appmsgItem6').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem6').value = picUrl;
                    break;
                case 7:
                    document.getElementById('default_appmsgItem7').style.display = 'none';
                    document.getElementById('i_img_appmsgItem7').style.display = 'block';
                    document.getElementById('i_img_appmsgItem7').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem7').value = picUrl;
                    break;
                case 8:
                    document.getElementById('default_appmsgItem8').style.display = 'none';
                    document.getElementById('i_img_appmsgItem8').style.display = 'block';
                    document.getElementById('i_img_appmsgItem8').setAttribute('src', srcTemp || '');
                    document.getElementById('i_img_hidden_appmsgItem8').value = picUrl;
                    break;
                default:
                    break;
            }
        }


        /* */
        /**
         * 加载jq上传组件
         */
        /*
         function _runUploadimgFun(temp) {
         uploadManyImageTexePic(temp);
         }
         */

        /**
         * 删除左右两端的空格
         */
        function trim(str) { //删除左右两端的空格
            return str.replace(/(^\s*)|(\s*$)/g, "");
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

        return {
            selectPage: _selectPage, saveFinish: _saveFinish, uploadImg_Finish: _uploadImg_Finish, savemodifyManyImageText: _savemodifyManyImageText
        }
    }()
})();