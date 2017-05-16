package com.wechat.domain.bean.proxy;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: ÏÂÎç3:56
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchCardPrize {
    private Integer id;
    private Integer componentId;
    private String prizeName;
    private double probability;
    private Integer count;
    private Integer reserveCount;
    private Date created;

    public Integer getReserveCount() {
        return reserveCount;
    }

    public void setReserveCount(Integer reserveCount) {
        this.reserveCount = reserveCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
