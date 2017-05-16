package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-27
 * Time: ÉÏÎç10:42
 * To change this template use File | Settings | File Templates.
 */
public class FoucsLucky {
    private Integer Id;
    private Integer weixinId;
    private Boolean absoluteLucky;
    private Integer luckyNumber;
    private Double luckyProbability;
    private String address;
    private String telphone;
    private String remark;
    private String luckyMessage;
    private String notLuckyMessage;
    private Boolean addHeader;
    private Boolean addFooter;
    private Boolean addHelp;
    private Boolean needContact;
    private Date created;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public Boolean getAbsoluteLucky() {
        return absoluteLucky;
    }

    public void setAbsoluteLucky(Boolean absoluteLucky) {
        this.absoluteLucky = absoluteLucky;
    }

    public Integer getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(Integer luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public Double getLuckyProbability() {
        return luckyProbability;
    }

    public void setLuckyProbability(Double luckyProbability) {
        this.luckyProbability = luckyProbability;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLuckyMessage() {
        return luckyMessage;
    }

    public void setLuckyMessage(String luckyMessage) {
        this.luckyMessage = luckyMessage;
    }

    public String getNotLuckyMessage() {
        return notLuckyMessage;
    }

    public void setNotLuckyMessage(String notLuckyMessage) {
        this.notLuckyMessage = notLuckyMessage;
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

    public Boolean getNeedContact() {
        return needContact;
    }

    public void setNeedContact(Boolean needContact) {
        this.needContact = needContact;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
