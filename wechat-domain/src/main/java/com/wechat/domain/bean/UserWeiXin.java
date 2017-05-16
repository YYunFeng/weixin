package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 */
public class UserWeiXin {
    private Integer Id;
    private Integer userId;
    private String weixinAccount;
    private String interfaceToken;
    private String userName;
    // 是否关注有奖
    private Boolean focusLucky;
    private Date openFocusLuckyTime;
    private Date created;
    private String url;

    public Boolean getFocusLucky() {
        return focusLucky;
    }

    public void setFocusLucky(Boolean focusLucky) {
        this.focusLucky = focusLucky;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getOpenFocusLuckyTime() {
        return openFocusLuckyTime;
    }

    public void setOpenFocusLuckyTime(Date openFocusLuckyTime) {
        this.openFocusLuckyTime = openFocusLuckyTime;
    }

}
