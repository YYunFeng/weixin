package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-2
 * Time: ÉÏÎç11:51
 * To change this template use File | Settings | File Templates.
 */
public class BigWheelRingLucky {
    private Integer Id;
    private Integer componentId;
    private String address;
    private String telphone;
    private String remark;
    private String luckyCount;
    private String luckyIntro;
    private Boolean needContact;
    private Date created;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getLuckyCount() {
        return luckyCount;
    }

    public void setLuckyCount(String luckyCount) {
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

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }
}
