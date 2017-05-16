package com.wechat.domain.bean.proxy;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ÏÂÎç5:50
 * To change this template use File | Settings | File Templates.
 */
public class UserWeixin {
    private Integer id;
    private Integer userId;
    private String weixinAccount;
    private String interfaceToken;
    private Date openFocusLuckyTime;
    private Boolean focusLucky;
    private Date created;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }

    public String getInterfaceToken() {
        return interfaceToken;
    }

    public void setInterfaceToken(String interfaceToken) {
        this.interfaceToken = interfaceToken;
    }

    public Date getOpenFocusLuckyTime() {
        return openFocusLuckyTime;
    }

    public void setOpenFocusLuckyTime(Date openFocusLuckyTime) {
        this.openFocusLuckyTime = openFocusLuckyTime;
    }

    public Boolean getFocusLucky() {
        return focusLucky;
    }

    public void setFocusLucky(Boolean focusLucky) {
        this.focusLucky = focusLucky;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
