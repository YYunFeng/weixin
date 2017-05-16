/**
 * @author johnny
 * js工具
 */
(function () {
    fouseJS = function () {

        function _focusFun(_element) {
            var act = _element.id;
            if (act == "weixinAccount") {
                _weixinAccountHTML(1);
            } else {
            }
        }

        function _blurFun(_element) {
            var act = _element.id;
            if (act == "weixinAccount") {
                _weixinAccountHTML(0);
            } else {
            }
        }

        /**
         * 微信号提示
         */
        var weixinAccountHTML_bg;

        function _weixinAccountHTML(statusTemp) {
            var _s = statusTemp;
            if (_s == 0) { // 关
                _weixinAccountHTMLremove();
            } else { // 开
                _weixinAccountHTMLremove();

                weixinAccountHTML_bg = document.createElement("div");
                weixinAccountHTML_bg.id = "weixinAccountHTML_bg";
                weixinAccountHTML_bg.onclick = function () {
                    fouseJS.weixinAccountHTML(0);
                }
                with (weixinAccountHTML_bg.style) {
                    position = "absolute";
                    zIndex = "10000";
//		width = window.innerWidth+"px";
                    height = document.body.scrollHeight + 'px';
                    width = "300px";
//		height = "390px";
                    top = "0px";
                    right = "0px";
                    backgroundImage = "url(../images/bg.png)";
//		backgroundImage = "url(images/help_1.png)";
//		backgroundRepeat = "no-repeat";
                }

//                weixinAccountHTML_img = document.createElement("img");
//                weixinAccountHTML_img.id = "weixinAccountHTML_img";
//                weixinAccountHTML_img.src = "../images/help_setting.png";
//                weixinAccountHTML_img.style = "width:300px;height:600px;";
                weixinAccountHTML_img = document.createElement("div");
                weixinAccountHTML_img.id = "weixinAccountHTML_img";
                with(weixinAccountHTML_img.style){
                    widht = "300px";
                    height = "600px";
                    backgroundImage = "url(../images/help_setting.png)";
                    backgroundRepeat = "no-repeat";
                }


                weixinAccountHTML_bg.appendChild(weixinAccountHTML_img);
                document.body.appendChild(weixinAccountHTML_bg);

            }
        }

        function _weixinAccountHTMLremove() {
            var loadingbgObj = document.getElementById("weixinAccountHTML_bg");
            if (weixinAccountHTML_bg != null && loadingbgObj != null) {
                var loadingbgObj = document.getElementById("weixinAccountHTML_bg");
                document.body.removeChild(document.getElementById("weixinAccountHTML_bg"));
            } else {
            }
        }


        /**
         * 配置信息帮助
         */
        function _deployhelp(temp) {
            document.getElementById('helplineicon1').className = "helplineicon_w";
            document.getElementById('helplineicon2').className = "helplineicon_w icon2";
            document.getElementById('helplineicon3').className = "helplineicon_w icon3";
            document.getElementById('helplineicon4').className = "helplineicon_w icon4";
            document.getElementById('helplineicon5').className = "helplineicon_w icon5";

            document.getElementById('help_c1').style.display = 'none';
            document.getElementById('help_c2').style.display = 'none';
            document.getElementById('help_c3').style.display = 'none';
            document.getElementById('help_c4').style.display = 'none';
            document.getElementById('help_c5').style.display = 'none';

            switch (temp) {
                case 1:
                    document.getElementById('helplineicon1').className = "helplineicon_hover";
                    document.getElementById('help_c1').style.display = 'block';

                    break;
                case 2:
                    document.getElementById('helplineicon1').className = "helplineicon_hover";
                    document.getElementById('helplineicon2').className = "helplineicon_hover icon2";
                    document.getElementById('help_c2').style.display = 'block';

                    break;
                case 3:
                    document.getElementById('helplineicon1').className = "helplineicon_hover";
                    document.getElementById('helplineicon2').className = "helplineicon_hover icon2";
                    document.getElementById('helplineicon3').className = "helplineicon_hover icon3";
                    document.getElementById('help_c3').style.display = 'block';

                    break;
                case 4:
                    document.getElementById('helplineicon1').className = "helplineicon_hover";
                    document.getElementById('helplineicon2').className = "helplineicon_hover icon2";
                    document.getElementById('helplineicon3').className = "helplineicon_hover icon3";
                    document.getElementById('helplineicon4').className = "helplineicon_hover icon4";
                    document.getElementById('help_c4').style.display = 'block';

                    break;
                case 5:
                    document.getElementById('helplineicon1').className = "helplineicon_hover";
                    document.getElementById('helplineicon2').className = "helplineicon_hover icon2";
                    document.getElementById('helplineicon3').className = "helplineicon_hover icon3";
                    document.getElementById('helplineicon4').className = "helplineicon_hover icon4";
                    document.getElementById('helplineicon5').className = "helplineicon_hover icon5";
                    document.getElementById('help_c5').style.display = 'block';

                    break;
            }

        }


        return {
            focusFun: _focusFun, blurFun: _blurFun, weixinAccountHTML: _weixinAccountHTML, deployhelp: _deployhelp
        }
    }()
})();