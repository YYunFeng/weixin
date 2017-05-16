package com.wechat.domain.bean.proxy;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ÏÂÎç4:27
 * To change this template use File | Settings | File Templates.
 */
public class FocusLog {

    private Integer id;
    private String wxOpenId;
    private Integer weixinId;
    private Boolean lucky;
    private String focusMessage;
    private Date created;


    public Boolean getLucky() {
        return lucky;
    }

    public void setLucky(Boolean lucky) {
        this.lucky = lucky;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public String getFocusMessage() {
        return focusMessage;
    }

    public void setFocusMessage(String focusMessage) {
        this.focusMessage = focusMessage;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
