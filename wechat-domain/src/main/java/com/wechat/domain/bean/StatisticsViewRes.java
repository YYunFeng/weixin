package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-16
 * Time: ÏÂÎç7:12
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsViewRes {
    private Integer count;
    private Date DrawTime;
    private Integer componentId;

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDrawTime() {
        return DrawTime;
    }

    public void setDrawTime(Date drawTime) {
        DrawTime = drawTime;
    }
}
