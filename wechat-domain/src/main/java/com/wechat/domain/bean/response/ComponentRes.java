package com.wechat.domain.bean.response;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-2
 * Time: ÏÂÎç2:42
 * To change this template use File | Settings | File Templates.
 */
public class ComponentRes {
    private Integer componentLuckyId;
    private Integer weixinId;
    private String title;
    private String pic;
    private String picPath;
    private String intro;
    private Integer componentId;
    private String address;
    private String telphone;
    private String remark;
    private Integer luckyCount;
    private String luckyIntro;
    private Boolean needContact;
    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getComponentLuckyId() {
        return componentLuckyId;
    }

    public void setComponentLuckyId(Integer componentLuckyId) {
        this.componentLuckyId = componentLuckyId;
    }

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
