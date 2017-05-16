package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-26
 * Time: ÏÂÎç2:30
 * To change this template use File | Settings | File Templates.
 */
public class BigWheelRingLuckyPrize {
    private Integer Id;
    private Integer luckyringId;
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getLuckyringId() {
        return luckyringId;
    }

    public void setLuckyringId(Integer luckyringId) {
        this.luckyringId = luckyringId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
