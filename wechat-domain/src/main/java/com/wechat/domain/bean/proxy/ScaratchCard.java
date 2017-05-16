package com.wechat.domain.bean.proxy;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: ÏÂÎç3:56
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchCard {
    private Integer id;
    private String componentTitle;
    private Integer componentId;
    private String address;
    private String telphone;
    private String remark;
    private Integer luckyCount;
    private String luckyIntro;
    private Boolean needContact;
    private Date created;

    public String getComponentTitle() {
        return componentTitle;
    }

    public void setComponentTitle(String componentTitle) {
        this.componentTitle = componentTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
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

    public Integer getLuckyCount() {
        return luckyCount;
    }

    public void setLuckyCount(Integer luckyCount) {
        this.luckyCount = luckyCount;
    }

    public String getLuckyIntro() {
        return luckyIntro;
    }

    public void setLuckyIntro(String luckyIntro) {
        this.luckyIntro = luckyIntro;
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
