package com.wechat.domain.parameter;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: ÏÂÎç2:22
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsParameter {
    private Integer weixinId;
    private Integer componentId;
    private String attentionMonth;
    private Integer type;
    private Integer surveyId;
    private Integer Id;
    private String questionTitle;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAttentionMonth() {
        return attentionMonth;
    }

    public void setAttentionMonth(String attentionMonth) {
        this.attentionMonth = attentionMonth;
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
}
