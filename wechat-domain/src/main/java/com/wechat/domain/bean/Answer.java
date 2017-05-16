package com.wechat.domain.bean;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-21
 * Time: обнГ3:21
 * To change this template use File | Settings | File Templates.
 */
public class Answer {
    private Integer surveyTopicId;
    private String answer;

    public Integer getSurveyTopicId() {
        return surveyTopicId;
    }

    public void setSurveyTopicId(Integer surveyTopicId) {
        this.surveyTopicId = surveyTopicId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

