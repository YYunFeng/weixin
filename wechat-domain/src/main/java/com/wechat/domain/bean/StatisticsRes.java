package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsRes {
    private String title;  // 组件的名称
    private Integer count; //每个奖项的中奖次数
    private String prizeId; // 奖项ID
    private Date DrawTime; // 中奖时间
    private Integer winNumber;  // 中奖次数
    private Integer componentId;
    private Integer partakeNumber;
    private Boolean lucky;
    private Integer totalAttionCount;
    private String attentionMonth;
    private Integer visitView; // 访问量
    private Boolean prize;
    private Integer surveyId;

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Boolean getPrize() {
        return prize;
    }

    public void setPrize(Boolean prize) {
        this.prize = prize;
    }

    public Integer getVisitView() {
        return visitView;
    }

    public void setVisitView(Integer visitView) {
        this.visitView = visitView;
    }

    public String getAttentionMonth() {
        return attentionMonth;
    }

    public void setAttentionMonth(String attentionMonth) {
        this.attentionMonth = attentionMonth;
    }

    public Integer getTotalAttionCount() {
        return totalAttionCount;
    }

    public void setTotalAttionCount(Integer totalAttionCount) {
        this.totalAttionCount = totalAttionCount;
    }

    public Boolean getLucky() {
        return lucky;
    }

    public void setLucky(Boolean lucky) {
        this.lucky = lucky;
    }

    public Integer getPartakeNumber() {
        return partakeNumber;
    }

    public void setPartakeNumber(Integer partakeNumber) {
        this.partakeNumber = partakeNumber;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public Date getDrawTime() {
        return DrawTime;
    }

    public void setDrawTime(Date drawTime) {
        DrawTime = drawTime;
    }

    public Integer getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(Integer winNumber) {
        this.winNumber = winNumber;
    }


}
