<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-4-18
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微信平台-管理员首页</title>
    <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/toolJS.js"></script>
    <script type="text/javascript" src="/js/superUser/superUser.js"></script>
    <script type="text/javascript" src="/js/datePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/jquery.myPagination6.0.js"></script>
    <link href="../css/public.css" rel="stylesheet" type="text/css">
    <link href="../css/superuser/usermanager.css" rel="stylesheet" type="text/css">
</head>
<%--<script type="text/javascript">
    $().ready(function () {
        jQuery('#home').addClass("selected");
        userListContent();
    });
</script>--%>

<script type="text/javascript">
    $(function () {
        jQuery('#home').addClass("selected");
        init();
    });
    function init() {
        toolJS.loading(1);
        var myPagination = $("#demo1").myPagination({
            currPage: 1,
            pageNumber: 10,
            cssStyle: 'badoo',//分页样式，具体样式可以从css/page.css样式中选取
            panel: {
                first: '首页',
                last: '尾页',
                next: '下一页',
                prev: '上一页',
                first_on: true,
                last_on: true,
                next_on: true,
                prev_on: true,
                tipInfo_css: {
                    width: '22px'
                }
            },
            ajax: {
                on: true,//是否启用异步请求，必须启用
                type: "POST",
                url: "/superUser/userContent.action",
                dataType: 'html',
                //回调函数
                callback: function (data) {
                    jQuery("#content").html(data);
                    toolJS.loading(0);
                }
            }
        });
    }
</script>
<div id="header" class="header">
    <jsp:include page="superInclude/top.jsp"></jsp:include>
    <div id="main" class="container">
        <div class="containerBox boxIndex">

            <div class="titlehead">
                <div class="titlehead_right">
                    <p>今日新增注册用户</p>

                    <p class="num"><s:property value="statisUserCount.todayCount"/></p>
                    <p>总用户数量</p>

                    <p class="num"><s:property value="statisUserCount.totalCount"/></p>
                </div>
                <div class="titlehead_left">
                    <script>
                        function selectSearch(temp) {
                            if (temp == 0) {
                                document.getElementById('searchtype0').className = "seach_selected";
                                document.getElementById('searchtype1').className = "";
                            } else {
                                document.getElementById('searchtype0').className = "";
                                document.getElementById('searchtype1').className = "seach_selected";
                            }
                        }
                    </script>

                    <div id="searchtype0" onclick="selectSearch(0)" class="seach_selected">
                        <br/>快速搜索
                        <br/>
                        <br/>
                        <select onchange="quickSearch(this.value);" name="flag">
                            <option value="">全部</option>
                            <option value="0">最近3天</option>
                            <option value="1">最近5天</option>
                            <option value="2">最近7天</option>
                        </select>
                    </div>
                    <form name="queryForm" id="queryForm" class="jqtransformdone">
                        <div id="searchtype1">
                            <br/>精确搜索
                            <br/>
                            <br/>
                            <input type="hidden" name="superUserParameter.orderby" id="orderby"/>
                            <input id="d5221" class="Wdate input" type="text" readonly="readonly"
                                   name="superUserParameter.startTime"
                                   onclick="selectSearch(1)"
                                   onFocus="var d5222=$dp.$('d5222');WdatePicker({onpicked:function(){d5222.focus();},maxDate:'#F{$dp.$D(\'d5222\')}'})"/>
                            至
                            <input id="d5222" class="Wdate input" type="text" readonly="readonly"
                                   name="superUserParameter.endTime"
                                   onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d5221\')}'})"/>
                        </div>
                        <div class="or">Or</div>
                        <div class="clr"></div>

                        <div class="inputtext"><input id="keyWord" name="superUserParameter.keyWord"
                                                      placeholder="请输入关键字"/></div>
                    </form>
                </div>
                <div class="searchbtn" onclick="preciseSearch();">搜索</div>
                <div class="searchbtn" onclick="clearTerm();">重置条件</div>
                <div class="clr"></div>
            </div>
            <!--搜索条件end-->
            <div class="containerBox boxIndex">
                <!--part 1-->
                <div class="mainPanel" id="content">

                </div>
                <div id="demo1">
                </div>
            </div>
        </div>
    </div>
    <div id="temp" style="display: none;"></div>
    <jsp:include page="superInclude/bottom.jsp"></jsp:include>
</div>
</body>
</html>
