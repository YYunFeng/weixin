package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: ÉÏÎç10:59
 * To change this template use File | Settings | File Templates.
 */
public class Survey {
    private Integer Id;
    private Integer weixinId;
    private Integer componentId;
    private Double  probability;
    private String type;
    private Integer count;
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

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
