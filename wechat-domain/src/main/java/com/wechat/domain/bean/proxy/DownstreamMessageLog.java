package com.wechat.domain.bean.proxy;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-27
 * Time: ÏÂÎç1:58
 * To change this template use File | Settings | File Templates.
 */
public class DownstreamMessageLog {
    private Integer id;
    private Integer weixinId;
    private String wxOpenId;
    private String msgType;
    private String xml;
    private Boolean isFocus;
    private Date created;

    public Boolean getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(Boolean focus) {
        isFocus = focus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
