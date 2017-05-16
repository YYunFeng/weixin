package com.wechat.domain.bean.response;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: обнГ8:00
 * To change this template use File | Settings | File Templates.
 */
public class SaveweixinaccuntRes {
    private String interfaceUrl;
    private String token;

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
