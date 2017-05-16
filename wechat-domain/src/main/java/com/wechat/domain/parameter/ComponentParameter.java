package com.wechat.domain.parameter;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç12:02
 * To change this template use File | Settings | File Templates.
 */
public class ComponentParameter {
    private Integer userId;
    private Integer weixinId;
    private String weixinAccount;
    private Integer componentType;
    private Integer surveyType;

    public Integer getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(Integer surveyType) {
        this.surveyType = surveyType;
    }

    public Integer getComponentType() {
        return componentType;
    }

    public void setComponentType(Integer componentType) {
        this.componentType = componentType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }
}
