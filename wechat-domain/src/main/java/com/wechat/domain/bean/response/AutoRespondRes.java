package com.wechat.domain.bean.response;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yyfpc
 * Date: 13-4-20
 * Time: ÏÂÎç8:21
 * To change this template use File | Settings | File Templates.
 */
public class AutoRespondRes {
    private Integer Id;
    private String keyword;
    private String ruleName;
    private Integer linkType;
    private String message;
    private Integer materialId;
    private Integer componentId;
    private Integer compontType;
    private String componentIntro;
    private Date componentDate;
    private String componentPic;
    private String componentTitle;
    private String materialtitle;
    private String materialPic;
    private String materialAbstract;
    private Date materialCreated;
    private String textResourceMessage;
    private Integer textResourceId;

    public String getTextResourceMessage() {
        return textResourceMessage;
    }

    public void setTextResourceMessage(String textResourceMessage) {
        this.textResourceMessage = textResourceMessage;
    }

    public Integer getTextResourceId() {
        return textResourceId;
    }

    public void setTextResourceId(Integer textResourceId) {
        this.textResourceId = textResourceId;
    }

    public Date getMaterialCreated() {
        return materialCreated;
    }

    public void setMaterialCreated(Date materialCreated) {
        this.materialCreated = materialCreated;
    }

    public String getMaterialtitle() {
        return materialtitle;
    }

    public void setMaterialtitle(String materialtitle) {
        this.materialtitle = materialtitle;
    }

    public String getMaterialPic() {
        return materialPic;
    }

    public void setMaterialPic(String materialPic) {
        this.materialPic = materialPic;
    }

    public String getMaterialAbstract() {
        return materialAbstract;
    }

    public void setMaterialAbstract(String materialAbstract) {
        this.materialAbstract = materialAbstract;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
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

    public Integer getCompontType() {
        return compontType;
    }

    public void setCompontType(Integer compontType) {
        this.compontType = compontType;
    }

    public String getComponentIntro() {
        return componentIntro;
    }

    public void setComponentIntro(String componentIntro) {
        this.componentIntro = componentIntro;
    }

    public Date getComponentDate() {
        return componentDate;
    }

    public void setComponentDate(Date componentDate) {
        this.componentDate = componentDate;
    }

    public String getComponentPic() {
        return componentPic;
    }

    public void setComponentPic(String componentPic) {
        this.componentPic = componentPic;
    }

    public String getComponentTitle() {
        return componentTitle;
    }

    public void setComponentTitle(String componentTitle) {
        this.componentTitle = componentTitle;
    }
}
