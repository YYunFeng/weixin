package com.wechat.domain.bean;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-21
 * Time: ÏÂÎç12:07
 * To change this template use File | Settings | File Templates.
 */
public class SurveyAnswer {
    private Integer Id;
    private Integer surveyId;
    private String answer;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
