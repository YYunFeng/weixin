var runningBool = false; // 是否正在旋转

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
var remainingNum = 0; // 剩余次数
var awardsObj = ["一等奖", "加油哦", "三等奖", "努力吧", "二等奖", "别灰心", "三等奖"];

var organizersContactBool = true; // 是否需要显示举办方联系方式
var o_address = ''; // 地址
var o_tel = ''; // 电话
var o_remark = ''; // 备注
var winnersContactBool = false; // 是否需要填写中奖者联系方式

/*
 http://weixin.360info.com.cn/luckyring/init.action?componentId=4&weixinOpenId=fsdfdsafasdfasdfasm  这个是初始化接口
 http://weixin.360info.com.cn/luckyring/lucky.action?componentId=4&weixinOpenId=afasdadsad 这个是抽奖接口
 */
//var urlPath = 'http://weixin.360info.com.cn/luckyring/'; // 公共的url地址
var urlPath = 'http://weixin.360info.com.cn/luckyring/'; // 公共的url地址
var randomTemp = -1; // 奖项id值
//var componentIdURL = '<s:property value="componentId"/>'; // componentId
//var weixinOpenIdURL = '<s:property value="weixinOpenId"/>'; // weixinOpenId
var componentIdURL = $("#componentId").val();
var weixinOpenIdURL = $("#weixinOpenId").val();

/**val();
 * 页面加载完成时调用的函数
 * 页面加载后，运行此函数，获取 获奖相关信息、抽奖次数 等信息
 */
function loadFun() {


    initNetwork();
//  dataTemp = '{"componentRingLucky":{"address":"主办方地址","luckyIntro":"抽奖简介信息","needContact":true,"remark":"主办方备注","telphone":"主办方电话"},"prizeList":[{"id":1,"prizeName":"一等奖"},{"id":2,"prizeName":"二等奖"},{"id":3,"prizeName":"三等奖"}],"userReserveCount":0}';
    // success_initNetwork(dataTemp)


    runningBool = false; // 初始化 是否旋转的标志位
    //测试弹出框
//	randomTemp = 1;
//	btn_callback();
}


/**
 * 初始化 联网
 */
function initNetwork() {
    var _url = urlPath + "init.action?componentId=" + componentIdURL + "&weixinOpenId=" + weixinOpenIdURL; // 联网获取 初始化
    $.get(
        _url,
        {},
        function (data) {
            success_initNetwork(data); // 异步回调
        }
    );
}
function success_initNetwork(_d) {
//	alert(_d)
//  _dJ = jQuery.parseJSON(_d);
    _dJ = _d;
//	alert(_dJ)
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

//    alert(_d.componentRingLucky.address);
    var _componentTitle;
    try{
        _componentTitle = _dJ.componentRingLucky.componentTitle || '幸运大转盘';
    }catch(e){
        _componentTitle = '幸运大转盘';
    }


    try {
        _address = _dJ.componentRingLucky.address || '-';
    } catch (e) {
        _address = '-';
    }
    try {
        _luckyIntro = _dJ.componentRingLucky.luckyIntro || '-';
    } catch (e) {
        _luckyIntro = '-';
    }
    try {
        _needContact = _dJ.componentRingLucky.needContact || false;
    } catch (e) {
        _needContact = false;
    }
    try {
        _remark = _dJ.componentRingLucky.remark || '-';
    } catch (e) {
        _remark = '-';
    }
    try {
        _telphone = _dJ.componentRingLucky.telphone || '-';
    } catch (e) {
        _telphone = '-';
    }
    try {
        _luckyIntro = _dJ.componentRingLucky.luckyIntro || '-';
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
    document.getElementById("numberhtml").innerHTML = '您还有' + remainingNum + '次抽奖机会';

    /*
     prize1Num = '1'; // 一等奖中奖人数
     prize2Num = '10'; // 二等奖中奖人数
     prize3Num = '100'; // 三等奖中奖人数
     */
}
/**
 * 点击抽奖按钮，让罗盘开始旋转，并开始联网获取是否中奖的信息
 */
function btn_click() {
    if (runningBool) { //如果罗盘正在旋转，则不运行下面的语句
        return;
    }

    runningBool = true;
    if (remainingNum > 0) { // 如果允许抽奖的次数大于0
        remainingNum = remainingNum - 1;

        document.getElementById("lotterybg").className = "lotterybg_animation"; // 旋转背景
        document.getElementById("imgs").className = "imgs_animation"; // 旋转罗盘

//		setTimeout('network_success()', 500)
        var _url = urlPath + "lucky.action?componentId=" + componentIdURL + "&weixinOpenId=" + weixinOpenIdURL; // 联网获取 是否中奖的信息
        $.get(
            _url,
            {},
            function (data) {
                success_remaining(data); // 异步回调
            }
        );
    } else { // 如果允许抽奖的次数小于 1
        popupboxOpen('不要贪心哦，您的抽奖次数已到，请关注下一期！')
    }
}

/**
 * 回调函数 获取抽奖信息后触发的函数
 */
function success_remaining(_d) {
    /*
     try {
     d_id = _d.id || 2;
     } catch (e) {
     d_id = 2;
     }
     */
    var d_id = _d.id; // 中奖的id，如果为负数，则没有中奖

    network_success(d_id);
}


/**
 * 获取到中奖值，将这个id值准备在罗盘中显示
 */
function network_success(_r) { //
    document.getElementById("imgs").className = ""; // 旋转罗盘的class变回空

    var awardsSize = awardsObj.length;
    var awardsSizeTemp = 180 / awardsSize;
    // randomTemp = parseInt(Math.random()*awardsSize+1); // 随机数 // 奖项值
//    alert('_r: '+ _r);
    randomTemp = _r || -1;
//    alert('randomTemp: '+ randomTemp);
//  var awardsObj = ["一等奖", "加油哦", "三等奖", "努力吧", "二等奖", "别灰心", "三等奖"];

    var __tempAngle;
    if (parseInt(_r) < 0) {
        var _temp = parseInt(Math.random() * 3 + 1); // 随机数
        if (_temp == 1) {
            __tempAngle = 2;
        } else if (_temp == 2) {
            __tempAngle = 4;
        } else if (_temp == 3) {
            __tempAngle = 6;
        }
    }else{
        if (randomTemp == prize1ID) {
            __tempAngle = 1;
        }
        else if (randomTemp == prize2ID) {
            __tempAngle = 5;
        }
        else if (randomTemp == prize3ID) {
            var _temp3 = parseInt(Math.random() * 2 + 1); // 随机数
            __tempAngle = _temp3 == 1 ? 3 : 7;
        }
    }

    var tempAngle = 360 * __tempAngle / awardsSize;
    tempAngle = tempAngle - awardsSizeTemp;
    tempAngle = 3600 + tempAngle;
    for (var i = 0; i <= tempAngle; i++) {
        $("#imgs").rotate({
            animateTo: i,
            angle: 0,
            duration: 6000,
            callback: btn_callback
        });
        if (i >= tempAngle) {
            break;
        }
    }
}


/**
 * 旋转完成后调用的函数
 */
function btn_callback() { //
    clearAndInit();

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

    document.getElementById("numberhtml").innerHTML = '您还有' + remainingNum + '次抽奖机会';
//alert('2::randomTemp: '+ randomTemp);
    // 获奖的逻辑
    if (randomTemp == prize1ID) {
        popupboxOpen('<p>&nbsp;</p><p>恭喜你获得 一等奖</p>' + organizersText);
    }
    else if (randomTemp == prize2ID) {
        popupboxOpen('<p>&nbsp;</p><p>恭喜你获得 二等奖</p>' + organizersText);
    }
    else if (randomTemp == prize3ID) {
        popupboxOpen('<p>&nbsp;</p><p>恭喜你获得 三等奖</p>' + organizersText);
    }
    else if (randomTemp == prize3ID) {
        popupboxOpen('<p>&nbsp;</p><p>恭喜你获得 三等奖</p>' + organizersText);
    } else {
        if(remainingNum <= 0){
            popupboxOpenM('<p>&nbsp;</p><p>很遗憾~您没抽到奖</p><p>&nbsp;</p>');
        }
    }
}

/**
 * 清空
 */
function clearAndInit() { //
    runningBool = false;
    document.getElementById("imgs").className = ""; // 旋转罗盘的class变回空
    document.getElementById("lotterybg").className = "lotterybg"; // 停止旋转背景
}

