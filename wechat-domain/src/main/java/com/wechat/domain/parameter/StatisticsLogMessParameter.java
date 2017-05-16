package com.wechat.domain.parameter;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-29
 * Time: ÉÏÎç11:03
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsLogMessParameter {
    private Integer Id;
    private String startTime;
    private String endTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
