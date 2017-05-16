package com.wechat.domain.parameter.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ÏÂÎç8:36
 * To change this template use File | Settings | File Templates.
 */
public class ComponentRingLuckyLogParameter {
    private String weixinOpenId;
    private Integer luckyringId;
    private Integer prizeId;

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public Integer getLuckyringId() {
        return luckyringId;
    }

    public void setLuckyringId(Integer luckyringId) {
        this.luckyringId = luckyringId;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }
}
