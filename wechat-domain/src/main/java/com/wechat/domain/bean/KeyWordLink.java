package com.wechat.domain.bean;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç8:05
 * To change this template use File | Settings | File Templates.
 */
public class KeyWordLink {
    private Integer Id;
    private String ruleName;
    private Integer weixinId;
    private String keyword;
    private Integer linkType;
    private String message;
    private Integer materialId;
    private Integer componentId;
    private Integer textResourceId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
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

    public Integer getTextResourceId() {
        return textResourceId;
    }

    public void setTextResourceId(Integer textResourceId) {
        this.textResourceId = textResourceId;
    }
}
