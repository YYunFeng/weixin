package com.wechat.domain.parameter.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: ÏÂÎç4:06
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchCardLogParameter {

    private String weixinOpenId;
    private Integer scaratchCardId;
    private Integer prizeId;

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public Integer getScaratchCardId() {
        return scaratchCardId;
    }

    public void setScaratchCardId(Integer scaratchCardId) {
        this.scaratchCardId = scaratchCardId;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }
}
