/**
 * @author johnny
 * js工具
 */
(function () {
    statisticsJS = function () {


        var isErrorBOOL = true; // 是否有错误条件

//键盘监听
        document.onkeyup = function (e) {
            var act = document.activeElement.id; //获得焦点的ID
        }

        function _btn_listhidden(temp, isbool, flag) {
            if (isbool == 0) {
                document.getElementById(temp).style.display = 'none';
            } else {
                document.getElementById(temp).style.display = 'block';
                if (flag == 0) { // 大转盘
                    statisticsBigWheelComponentContent(temp);
                }
                if (flag == 1) { // 刮刮卡
                    statisticsSacaratchCardContent(temp);
                }
                if (flag == 2) { // 问卷调查
                    statisticsSurveyContent(temp);
                }
                if (flag == 3) { // 有奖竞答
                    statisticsPrizeQuizContent(temp);
                }
            }

        }

        return {
            btn_listhidden: _btn_listhidden
        }
    }()
})();