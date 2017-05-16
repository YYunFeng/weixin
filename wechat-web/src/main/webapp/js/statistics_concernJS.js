/**
 * @author johnny
 * js工具
 */
(function () {
    statistics_concernJS = function () {


        var isErrorBOOL = true; // 是否有错误条件

//键盘监听
        document.onkeyup = function (e) {
            var act = document.activeElement.id; //获得焦点的ID

            /*
             switch(act){
             case "moduletitle": // 标题
             document.getElementById('moduletitleM').innerHTML = document.getElementById('moduletitle').value;
             document.getElementById('titleHTML5See').innerHTML = document.getElementById('moduletitle').value;

             break;

             default: break;
             }
             */

        }

        function _btn_listhidden(temp, isbool) {
            if (isbool == 0) {
                document.getElementById(temp).style.display = 'none';
            } else {
                document.getElementById(temp).style.display = 'block';
                statisticsAttentionContent(temp);
            }
        }

        return {
            btn_listhidden: _btn_listhidden
        }
    }()
})();