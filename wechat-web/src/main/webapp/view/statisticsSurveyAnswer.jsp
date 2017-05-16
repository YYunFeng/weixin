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
        var colors = Highcharts.getOptions().colors,
                categories = [<s:property value="statisticsAnswerRes.categories"/>],
                name = '选择人数',
                data = [<s:property value="statisticsAnswerRes.dates"/>];

        function setChart(name, categories, data, color) {
            chart.xAxis[0].setCategories(categories, false);
            chart.series[0].remove(false);
            chart.addSeries({
                name: name,
                data: data,
                color: '#579E0D'
            }, false);
            chart.redraw();
        }

        var chart = $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '问题:<s:property value="statisticsAnswerRes.questionTitle"/>'
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                title: {
                    text: '选择人数'
                },
                min: 1,
                allowDecimals:false
            },
            credits: {
                enabled: false
            },
            plotOptions: {
                column: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                var drilldown = this.drilldown;
                                setChart(name, categories, data);
                            }
                        }
                    },
                    dataLabels: {
                        enabled: true,
                        color: colors[0],
                        style: {
                            fontWeight: 'bold'
                        },
                        formatter: function () {
                            return this.y + '次';
                        }
                    }
                }
            },
            tooltip: {
                formatter: function () {
                    var point = this.point,
                            s = this.x + ':<b>' + this.y + '人选择</b><br/>';
                    return s;
                }
            },

            series: [
                {
                    name: name,
                    data: data,
                    color: '#579E0D'
                }
            ],
            exporting: {
                enabled: false
            }
        }).highcharts(); // return chart
    });
</script>
<div class="list_subcon_banner">
    <div id="container" style="width: 650px; height: 400px; margin: 0 auto">
    </div>
</div>
<div class="clr"></div>
