/**
 * @author johnny
 * js工具
 */
(function () {
    toolJS = function () {

        var loading_bg = null;
        var loadingdiv = null;

        function _loading(statusTemp) {
            try {
                var _s = statusTemp;
                if (_s == 0) { // 关
                    _loadingremove();
                } else { // 开
                    loading_bg = document.createElement("div");
                    loading_bg.id = "loading_bg";
                    with (loading_bg.style) {
                        position = "fixed";
                        zIndex = "10000";
                        width = window.innerWidth + "px";
                        height = window.innerHeight + "px";
                        top = "0px";
                        right = "0px";
                        bottom = "0px";
                        left = "0px";
                        backgroundImage = "url(../images/selected-bg.png)";
                    }

                    loadingdiv = document.createElement("div");
                    loadingdiv.id = "loadingdiv";
                    with (loadingdiv.style) {
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
                        backgroundImage = "url(../images/loading.gif)";
                    }
                    loading_bg.appendChild(loadingdiv);
                    document.body.appendChild(loading_bg);
                }
            } catch (e) {
            }

        }

        function _loadingremove() {
            var loadingbgObj = document.getElementById("loading_bg");
            if (loading_bg != null && loadingbgObj != null) {
                var loadingbgObj = document.getElementById("loading_bg");
                //		document.body.removeChild(document.getElementById(loadingdiv));
                document.body.removeChild(document.getElementById("loading_bg"));
            }


        }

        var alert_bg = null;
        var alertdiv = null;

        /**
         * 弹出框alert
         */
        function _alertAuto(statusTemp, tTemp) {
            var _s = statusTemp;
            if (_s == 0) { // 关
                _alertremove();
            } else { // 开
                alert_bg = document.createElement("div");
                alert_bg.id = "alert_bg";
                with (alert_bg.style) {
                    position = "fixed";
                    zIndex = "10000";
                    width = window.innerWidth + "px";
                    height = window.innerHeight + "px";
                    top = "0px";
                    right = "0px";
                    bottom = "0px";
                    left = "0px";
                    backgroundImage = "url(../images/bg.png)";
                }
                alert_bg.onclick = function () {
                    toolJS.alertAuto(0);
                }

                alertdiv = document.createElement("div");
                alertdiv.id = "alertdiv";
                with (alertdiv.style) {
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
                }
                var _alertdivHTML = '';
                _alertdivHTML += '<table style="width:100%; height:100%;"><tr>';
                _alertdivHTML += '<td style="width:100%; height:100%; text-align:center; font-size:20px;">';
                _alertdivHTML += tTemp || '';
                _alertdivHTML += '</td></tr></table>';
                alertdiv.innerHTML = _alertdivHTML;
                alert_bg.appendChild(alertdiv);
                document.body.appendChild(alert_bg);
            }

        }

        function _alertremove() {
            var alertbgObj = document.getElementById("alert_bg");
            if (alert_bg != null && alertbgObj != null) {
                var alertbgObj = document.getElementById("alert_bg");
                //		document.body.removeChild(document.getElementById(loadingdiv));
                document.body.removeChild(document.getElementById("alert_bg"));
            }
        }

        return {
            loading: _loading, loadingremove: _loadingremove,
            alertAuto: _alertAuto
        }

    }()
})();