package com.wechat.domain.bean.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ÏÂÎç7:00
 * To change this template use File | Settings | File Templates.
 */
public class KeywordLink {

    private Integer id;
    private Integer weixinId;
    private String keyword;
    private Integer linkType;
    private String message;
    private Integer materialId;
    private Integer componentId;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }
}
