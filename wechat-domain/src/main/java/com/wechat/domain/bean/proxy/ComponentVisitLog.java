package com.wechat.domain.bean.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-16
 * Time: ÏÂÎç4:15
 * To change this template use File | Settings | File Templates.
 */
public class ComponentVisitLog {
    private Integer id;
    private Integer componentId;
    private String wxOpenid;

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

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }
}
