/**
 * @author johnny
 * js工具
 */
(function() {
	toolJSOpAdd = function() {

//键盘监听
document.onkeyup = function (e){
var act = document.activeElement.id; //获得焦点的ID
switch(act){
	/*
	case "moduletitle": // 标题
		document.getElementById('moduletitleM').innerHTML = document.getElementById('moduletitle').value;
		break;
	default: break;
	*/
}}
		/**
		* 幸运大转盘 封面btn替换class
		**/
		function _selectPage(_temp) {
			document.getElementById('tuwencont1').className = 'pagehtml_rect';
			document.getElementById('tuwencont2').className = 'pagehtml_rect';
			document.getElementById('tuwencont3').className = 'pagehtml_rect';
			document.getElementById('tuwencont4').className = 'pagehtml_rect';
			document.getElementById('tuwencont5').className = 'pagehtml_rect';
			document.getElementById('tuwencont6').className = 'pagehtml_rect';
			document.getElementById('tuwencont7').className = 'pagehtml_rect';
			document.getElementById('tuwencont8').className = 'pagehtml_rect';
			switch(_temp){
				case 1:
					document.getElementById('tuwencont1').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 2:
					document.getElementById('tuwencont2').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 3:
					document.getElementById('tuwencont3').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 4:
					document.getElementById('tuwencont4').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 5:
					document.getElementById('tuwencont5').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 6:
					document.getElementById('tuwencont6').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 7:
					document.getElementById('tuwencont7').className = 'pagehtml_rect p_new_btn_hover';
					break;
				case 8:
					document.getElementById('tuwencont8').className = 'pagehtml_rect p_new_btn_hover';
					break;
				default: break;
			}
		}
		
		/**
		* 完成
		**/
		function _moduleFinish() {
			/*
			document.getElementById('moduletitle').value; // 标题
			document.getElementById('modulecontent').value; // 摘要
			document.getElementById('moduleprize1').value; // 1等奖
			document.getElementById('moduleprize1Probability').value; // 概率
			document.getElementById('moduleprize1Num').value; // 数量
			document.getElementById('moduleprize2').value; // 2等奖
			document.getElementById('moduleprize2Probability').value;
			document.getElementById('moduleprize2Num').value;
			document.getElementById('moduleprize3').value; // 3等奖
			document.getElementById('moduleprize3Probability').value;
			document.getElementById('moduleprize3Num').value;
			document.getElementById('moduleprizeContent').value; // 奖项说明
			document.getElementById('moduletel').value; // 联系电话
			document.getElementById('moduleaddress').value; // 联系地址
			document.getElementById('modulebeizhu').value; // 联系备注
			*/
		}
		
		return {
			selectPage: _selectPage
		}
	}()
})();