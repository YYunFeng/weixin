/**
 * @author johnny
 * js工具
 */
/**
 * 关注有奖 关
 */
var isErrorBOOL1 = true; // 是否有错误条件
var _close_text;

function judge1() {
    isErrorBOOL1 = false;

    _close_text = document.getElementById('close_text').value;
    document.getElementById('close_text').style.border = '';
    if (trim(_close_text).length < 1) {
        document.getElementById('close_text').style.border = '1px dotted #F03';
        isErrorBOOL1 = true;
    }
    return isErrorBOOL1;
}

/**
 * 关注有奖 开 100%中奖
 */
var isErrorBOOL2 = true; // 是否有错误条件
var _close_text_3;

function judge2() {
    isErrorBOOL2 = false;

    _close_text_3 = document.getElementById('close_text_3').value;
    document.getElementById('close_text_3').style.border = '';
    if (trim(_close_text_3).length < 1) {
        document.getElementById('close_text_3').style.border = '1px dotted #F03';
        isErrorBOOL2 = true;
    }
    return isErrorBOOL2;
}

/**
 * 关注有奖 开 非100%中奖
 */
var isErrorBOOL3 = true; // 是否有错误条件
var _settingNum;
var _close_text_4;
var _close_text_5;

function judge3() {
    isErrorBOOL3 = false;

    _settingNum = document.getElementById('settingNum').value;
    _close_text_4 = document.getElementById('close_text_4').value;
    _close_text_5 = document.getElementById('close_text_5').value;
    document.getElementById('settingNum').style.border = '';
    if (trim(_settingNum).length < 1 || trim(_settingNum) < 0 || isNaN(_settingNum)) {
        document.getElementById('settingNum').style.border = '1px dotted #F03';
        isErrorBOOL3 = true;
    }
    if (document.getElementById('award_setting_1').checked) { // 如果是幸运尾数
        if (_settingNum > 9 || _settingNum != parseInt(_settingNum) || _settingNum.length > 1) {
            document.getElementById('settingNum').style.border = '1px dotted #F03';
            isErrorBOOL3 = true;
        }
    } else if (document.getElementById('award_setting_2').checked) { // 如果是随机概率
        if (_settingNum > 100) {
            document.getElementById('settingNum').style.border = '1px dotted #F03';
            isErrorBOOL3 = true;
        }
    }
    if (trim(_close_text_4).length < 1) {
        document.getElementById('close_text_4').style.border = '1px dotted #F03';
        isErrorBOOL3 = true;
    }
    if (trim(_close_text_5).length < 1) {
        document.getElementById('close_text_5').style.border = '1px dotted #F03';
        isErrorBOOL3 = true;
    }
    return isErrorBOOL3;
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
}

