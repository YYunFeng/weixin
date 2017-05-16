/**
 * @author johnny
 * js工具
 */
(function() {
	toolJS = function() {
/**
* loadging层
*/
	var loading_bg = null;
	var loadingdiv = null;
	function _loading(statusTemp){
		var _s = statusTemp;
		if(_s == 0){ // 关
			_loadingremove();
		}else{ // 开
			loading_bg = document.createElement("div");
			loading_bg.id = "loading_bg";
			with(loading_bg.style)
			{
				position = "fixed";
				zIndex = "10000";
				width = window.innerWidth+"px";
				height = window.innerHeight+"px";
				top = "0px";
				right = "0px";
				bottom = "0px";
				left = "0px";
				backgroundImage = "url(/view/scaratchCard/jstool/bg.png)";
			}
			
			loadingdiv = document.createElement("div");
			loadingdiv.id = "loadingdiv";
			with(loadingdiv.style){
				position = "absolute";
				margin = "auto";
				padding = "auto";
				top = "0px";
				right = "0px";
				bottom = "0px";
				left = "0px";
				width = "400px";
				height = "300px";
				background = "#fff";
				backgroundImage = "url(jstool/loading.gif)";
			}
			loading_bg.appendChild(loadingdiv);
			document.body.appendChild(loading_bg);
//			setTimeout(_loadingremove, 1000)
		}

	}
	function _loadingHTML5(statusTemp){
		var _s = statusTemp;
		if(_s == 0){ // 关
			_loadingremove();
		}else{ // 开
			loading_bg = document.createElement("div");
			loading_bg.id = "loading_bg";
			with(loading_bg.style)
			{
				position = "fixed";
				zIndex = "10000";
				width = window.innerWidth+"px";
				height = window.innerHeight+"px";
				top = "0px";
				right = "0px";
				bottom = "0px";
				left = "0px";
				backgroundImage = "url(/view/scaratchCard/jstool/bg.png)";
			}
			
			loadingdiv = document.createElement("div");
			loadingdiv.id = "loadingdiv";
			with(loadingdiv.style){
				position = "absolute";
				margin = "auto";
				padding = "auto";
				top = "0px";
				right = "0px";
				bottom = "0px";
				left = "0px";
				width = "100px";
				height = "100px";
//				background = "#fff";
				color = '#fff';
			}
			loadingdiv.innerHTML = '加载中...'
			loading_bg.appendChild(loadingdiv);
			document.body.appendChild(loading_bg);
//			setTimeout(_loadingremove, 1000)
		}

	}
	function _loadingremove(){
		var loadingbgObj = document.getElementById("loading_bg");
		if(loading_bg != null && loadingbgObj != null ){
			var loadingbgObj = document.getElementById("loading_bg");
	//		document.body.removeChild(document.getElementById(loadingdiv));
			document.body.removeChild(document.getElementById("loading_bg"));
//			alert('success');
		}else{
//			setTimeout(_loading, 1000)
		}
//		setTimeout(_loading, 1000)
	}
	
/**
* 弹出框alert
*/	

	var alert_bg = null;
	var alertdiv = null;
	function _alertAuto(statusTemp, tTemp, isClick){
		var _isClick = isClick || 1;
		var _s = statusTemp;
		if(_s == 0){ // 关
			_alertremove();
		}else{ // 开
			alert_bg = document.createElement("div");
			alert_bg.id = "alert_bg";
			with(alert_bg.style)
			{
				position = "fixed";
				zIndex = "10000";
				width = window.innerWidth+"px";
				height = window.innerHeight+"px";
				top = "0px";
				right = "0px";
				bottom = "0px";
				left = "0px";
				backgroundImage = "url(/view/scaratchCard/jstool/bg.png)";
			}
			alert_bg.onclick = function(){
				if(isClick != 0){
					toolJS.alertAuto(0);
				}
			}

			alertdiv = document.createElement("div");
			alertdiv.id = "alertdiv";
			alertdiv.className = "radiusCSS";
			with(alertdiv.style){
				position = "absolute";
				margin = "auto";
				padding = "auto";
				top = "0px";
				right = "0px";
				bottom = "0px";
				left = "0px";
				width = "80%";
				height = "200px";
//				minHeight = "200px";
				background = "#fff";
				
//				backgroundImage = "url(images/selected-bg.png)";
			}
			var _alertdivHTML = '';
			_alertdivHTML += '<table style="width:100%; height:100%;"><tr>';
			_alertdivHTML += '<td style="width:100%; height:100%; text-align:center; font-size:16px; color: #000000;">';
			_alertdivHTML += tTemp || '';
			_alertdivHTML += '</td></tr></table>';
			alertdiv.innerHTML = _alertdivHTML;
			alert_bg.appendChild(alertdiv);
			document.body.appendChild(alert_bg);
//			setTimeout(_loadingremove, 1000)
		}

	}
	
	function _alertremove(){
		var alertbgObj = document.getElementById("alert_bg");
		if(alert_bg != null && alertbgObj != null ){
			var alertbgObj = document.getElementById("alert_bg");
	//		document.body.removeChild(document.getElementById(loadingdiv));
			document.body.removeChild(document.getElementById("alert_bg"));
//			alert('success');
		}else{
//			setTimeout(_loading, 1000)
		}
//		setTimeout(_loading, 1000)
	}
	
	
	
/**
* 获取字数
*/	
function _getWordsNum(text){
var _text = _trim(text);
var _zh = _text ? _text.match(/[^ -~]/g) : 0;
var num = Math.ceil((_text.length + (_zh && _zh.length) || 0)/2);
return num;
}

/**
* 删除左右两端的空格
*/	
function _trim(str){
return str.replace(/(^\s*)|(\s*$)/g, "");
}
/**
* 删除左边的空格
*/	
function _ltrim(str){
return str.replace(/(^\s*)/g,"");
}
/**
* 删除右边的空格
*/	
function _rtrim(str){
return str.replace(/(\s*$)/g,"");
}
	return {
		loading: _loading
		,loadingHTML5: _loadingHTML5
		,loadingremove: _loadingremove
		,alertAuto: _alertAuto
		,alertremove: _alertremove
		,getWordsNum: _getWordsNum
		,trim: _trim
		,ltrim: _ltrim
		,rtrim: _rtrim
	}
	
	}()
})();