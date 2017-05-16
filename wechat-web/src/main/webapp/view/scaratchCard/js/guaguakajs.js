var prize1 = ''; // 一等奖内容
var prize2 = ''; // 二等奖内容
var prize3 = ''; // 三等奖内容
var prize1ID = 0; // 一等奖id
var prize2ID = 0; // 二等奖id
var prize3ID = 0; // 三等奖id
var prize1Num = ''; // 一等奖中奖人数
var prize2Num = ''; // 二等奖中奖人数
var prize3Num = ''; // 三等奖中奖人数
var ruleContent = ''; // 活动详情
var remainingNum = 1; // 剩余次数

var organizersContactBool = true; // 是否需要显示举办方联系方式
var o_address = ''; // 地址
var o_tel = ''; // 电话
var o_remark = ''; // 备注
var winnersContactBool = false; // 是否需要填写中奖者联系方式

/*
 http://weixin.360info.com.cn/luckyring/init.action?componentId=4&weixinOpenId=fsdfdsafasdfasdfasm  这个是初始化接口
 http://weixin.360info.com.cn/luckyring/lucky.action?componentId=4&weixinOpenId=afasdadsad 这个是抽奖接口
 */
var urlPath = 'http://weixin.360info.com.cn/scaratchcard/'; // 公共的url地址
var randomTemp = -1; // 奖项id值
var componentIdURL = $("#componentId").val();
var weixinOpenIdURL = $("#weixinOpenId").val();
function addNumberhtml() {
    document.getElementById("numberhtml").innerHTML = '您还有' + remainingNum + '次抽奖机会';
}
function isJQueryFun(_text) {
//	var _obj = jQuery.parseJSON(_text);
    var _obj = _text;
    return _obj
}

/**
 * 页面加载完成时调用的函数
 * 页面加载后，运行此函数，获取 获奖相关信息、抽奖次数 等信息
 */
function loadFun() {
//    loadcan();
//  	toolJS.loadingHTML5(1);
//    loadcanvas();
    initNetwork();
    /*
     dataTemp = '{"componentRingLucky":{"address":"北京市海淀区复兴路1606","luckyIntro":"幸运大转盘123123幸运大转盘123123","needContact":true,"remark":"备注信息","telphone":"18600022925"},"prizeList":[{"id":37,"prizeName":"lzl  "},{"id":38,"prizeName":"yyf"},{"id":39,"prizeName":"gy"}],"userReserveCount":0}';
     success_initNetwork(dataTemp)
     */


    //测试弹出框
//	randomTemp = 1;
//	btn_callback();
}


/**
 * 初始化 联网
 */
function initNetwork() {
    toolJS.loadingHTML5(1);
    var _url = urlPath + "init.action?componentId=" + componentIdURL + "&weixinOpenId=" + weixinOpenIdURL; // 联网获取 初始化
    $.get(
        _url,
        {},
        function (data) {
            toolJS.loadingHTML5(0);
            success_initNetwork(data); // 异步回调
        }
    );
}
function success_initNetwork(_d) {
//	alert(_d)
    var _dJ = isJQueryFun(_d);
//  var _dJ = _d;
//	alert(_dJ);
    var _address; // 主办方地址
    var _luckyIntro; // 抽奖简介信息
    var _needContact;
    var _remark; // 主办方备注
    var _telphone; // 主办方电话
    var _luckyIntro; // 抽奖简介信息
    var _prizeList;
    var _prizeList_prizeName1;
    var _prizeList_prizeName2;
    var _prizeList_prizeName3;
    var _userReserveCount;
    var _componentTitle;
    try {
        _componentTitle = _dJ.scaratchCard.componentTitle || '刮刮卡';
    } catch (e) {
        _componentTitle = '刮刮卡';
    }
    try {
        _address = _dJ.scaratchCard.address || '-';
    } catch (e) {
        _address = '-';
    }
    try {
        _luckyIntro = _dJ.scaratchCard.luckyIntro || '-';
    } catch (e) {
        _luckyIntro = '-';
    }
    try {
        _needContact = _dJ.scaratchCard.needContact || false;
    } catch (e) {
        _needContact = false;
    }
    try {
        _remark = _dJ.scaratchCard.remark || '-';
    } catch (e) {
        _remark = '-';
    }
    try {
        _telphone = _dJ.scaratchCard.telphone || '-';
    } catch (e) {
        _telphone = '-';
    }
    try {
        _luckyIntro = _dJ.scaratchCard.luckyIntro || '-';
    } catch (e) {
        _luckyIntro = '-';
    }

    try {
        _prizeList = _dJ.prizeList || '';
    } catch (e) {
        _prizeList = '';
    }

    var _prizeNameX;
    var _prizeIdX;
    for (var _key in _prizeList) {
        //	alert(_key)
        try {
            _prizeNameX = _prizeList[_key].prizeName || '-';
            _prizeIdX = _prizeList[_key].id || -1;
        } catch (e) {
            _prizeNameX = '-';
            _prizeIdX = -1;
        }
        if (_key == 0) {
            prize1 = _prizeNameX || '-';
            prize1ID = _prizeIdX;
        } else if (_key == 1) {
            prize2 = _prizeNameX || '-';
            prize2ID = _prizeIdX;
        } else if (_key == 2) {
            prize3 = _prizeNameX || '-';
            prize3ID = _prizeIdX;
        }
    }

    try {
        _userReserveCount = _dJ.userReserveCount || 0;
    } catch (e) {
        _userReserveCount = 0;
    }


    o_address = _address;
    o_tel = _telphone;
    o_remark = _remark;
    ruleContent = _luckyIntro;
    organizersContactBool = _needContact;
    remainingNum = _userReserveCount;

    document.getElementById("componentTitleId").innerHTML = _componentTitle;
    document.getElementById("prizehtml_1").innerHTML = prize1 + (prize1Num == '' ? '' : '(' + prize1Num + '名)');
    document.getElementById("prizehtml_2").innerHTML = prize2 + (prize2Num == '' ? '' : '(' + prize2Num + '名)');
    document.getElementById("prizehtml_3").innerHTML = prize3 + (prize3Num == '' ? '' : '(' + prize3Num + '名)');
    document.getElementById("rulehtml").innerHTML = ruleContent;
    addNumberhtml();

    /*
     */
    if (remainingNum <= 0) { // 判断是否显示 再刮一次 按钮
        document.getElementById('againBtn').style.display = 'none';
    } else {
        document.getElementById('againBtn').style.display = 'block';
    }

    if (remainingNum <= 0) { // 判断是否显示 再刮一次 按钮
        toolJS.alertAuto(1, '不要贪心哦，请关注下一期！', 0);
        document.getElementById('againBtn').style.display = 'none';
    } else {
        infoNetwork();
    }
}

/**
 * 点击再来一次按钮，重新联网获取数据，并开始联网获取是否中奖的信息
 */
function infoNetwork() {
    document.getElementById('priceinfo').innerHTML = '谢谢';

    toolJS.loadingHTML5(1);
    var _url = urlPath + "lucky.action?componentId=" + componentIdURL + "&weixinOpenId=" + weixinOpenIdURL; // 联网获取 初始化
    $.get(
        _url,
        {},
        function (data) {
            toolJS.loadingHTML5(0);
            success_infoNetwork(data); // 异步回调
        }
    );
}
function success_infoNetwork(_d) {
    var _dJ = isJQueryFun(_d);

    var _idTemp = _dJ.id;
    if (_idTemp == prize1ID) {
        document.getElementById('priceinfo').innerHTML = '一等奖';
    } else if (_idTemp == prize2ID) {
        document.getElementById('priceinfo').innerHTML = '二等奖';
    } else if (_idTemp == prize3ID) {
        document.getElementById('priceinfo').innerHTML = '三等奖';
    } else {
        document.getElementById('priceinfo').innerHTML = '谢谢';
    }

}
/**
 * 旋转完成后调用的函数
 */
function btn_callback() { //

    var organizersText = '';
    if (organizersContactBool) {
        organizersText += '<p>';
        organizersText += '主办方地址：';
        organizersText += o_address;
        organizersText += '</p>';
        organizersText += '<p>';
        organizersText += '电话：';
        organizersText += o_tel;
        organizersText += '</p>';
        organizersText += '<p>';
        organizersText += '备注：';
        organizersText += o_remark;
        organizersText += '</p><p>&nbsp;</p>';
    }

//  document.getElementById("numberhtml").innerHTML = '您还有'+ remainingNum +'次抽奖机会';

}

function againLoadClick() {
    if (remainingNum <= 0) { // 判断是否显示 再刮一次 按钮
        toolJS.alertAuto(1, '不要贪心哦，请关注下一期！', 0);
        document.getElementById('againBtn').style.display = 'none';
    } else {
        document.getElementById('againBtn').style.display = 'block';
        remainingNum = remainingNum - 1;
//        window;
//        loadcanvas();
        parent.location.reload()
//        infoNetwork();
    }
    addNumberhtml()
}
