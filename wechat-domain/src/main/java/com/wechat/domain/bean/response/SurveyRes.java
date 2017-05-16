package com.wechat.domain.bean.response;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: ÏÂÎç1:32
 * To change this template use File | Settings | File Templates.
 */
public class SurveyRes {
    private Integer componentId;
    private String componentTitle;
    private String pic;
    private String picPath;
    private String intro;
    private Integer surveyId;
    private Integer type;
    private Double probability;
    private Integer count;

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getComponentTitle() {
        return componentTitle;
    }

    public void setComponentTitle(String componentTitle) {
        this.componentTitle = componentTitle;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
