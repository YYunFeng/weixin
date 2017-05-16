<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YUNFENG
  Date: 13-5-15
  Time: 下午12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/highcharts.js"></script>
<script type="text/javascript" src="../js/exporting.js"></script>
<script type="text/javascript">
    $(function () {
        $('#container').highcharts({
            chart: {
                type: 'column',
                marginRight: 100,
                marginBottom: 25
            },
            title: {
                text: '上行信息条数和下行信息条数',
                x: -20 //center
            },
            xAxis: {
                categories: [<s:property value="logMessageRes.dateRes"/>]
            },
            yAxis: {
                title: {
                    text: '条数'
                },
                allowDecimals: false
            },
            credits: {
                enabled: false
            },
            tooltip: {
                valueSuffix: '条数'
            },
            exporting: {
                enabled: false
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: [
                {
                    name: '上行信息',
                    data: [<s:property value="logMessageRes.upstreamCountRes"/>],
                    color: '#1FBBA6'
                },
                {
                    name: '下行信息',
                    data: [<s:property value="logMessageRes.downstreamCountRes"/>],
                    color: '#FFBC54'
                }
            ]
        });
    });
</script>
<div class="list_subcon_banner">
    <div id="container" style="width: 880px; height: 430px; margin: 0 auto">

    </div>
</div>

<div class="clr"></div>
