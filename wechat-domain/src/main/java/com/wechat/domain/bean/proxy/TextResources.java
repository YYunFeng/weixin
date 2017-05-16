package com.wechat.domain.bean.proxy;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ÏÂÎç1:01
 * To change this template use File | Settings | File Templates.
 */
public class TextResources {

    private Integer id;
    private Integer weixinId;
    private Integer type;
    private String message;
    private Boolean addHeader;
    private Boolean addFooter;
    private Boolean addHelp;
    private Date created;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getAddHeader() {
        return addHeader;
    }

    public void setAddHeader(Boolean addHeader) {
        this.addHeader = addHeader;
    }

    public Boolean getAddFooter() {
        return addFooter;
    }

    public void setAddFooter(Boolean addFooter) {
        this.addFooter = addFooter;
    }

    public Boolean getAddHelp() {
        return addHelp;
    }

    public void setAddHelp(Boolean addHelp) {
        this.addHelp = addHelp;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
