package com.wechat.domain.bean.proxy;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-9
 * Time: ÉÏÎç11:31
 * To change this template use File | Settings | File Templates.
 */
public class PicMessage {
    private Integer materialType;
    private Integer picMessageId;
    private String title;
    private String picUrl;
    private String abstract1;
    private String message;
    private String linkUr;
    private Integer seq;
    private Date created;
    private Date modified;

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }

    public Integer getPicMessageId() {
        return picMessageId;
    }

    public void setPicMessageId(Integer picMessageId) {
        this.picMessageId = picMessageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLinkUr() {
        return linkUr;
    }

    public void setLinkUr(String linkUr) {
        this.linkUr = linkUr;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
