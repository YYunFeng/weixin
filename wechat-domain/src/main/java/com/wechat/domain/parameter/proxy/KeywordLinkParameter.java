package com.wechat.domain.parameter.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: обнГ7:30
 * To change this template use File | Settings | File Templates.
 */
public class KeywordLinkParameter {
    private Integer weixinId;
    private String keyword;

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
