package com.wechat.action;



import com.wechat.domain.bean.StatisticsAnswerRes;
import com.wechat.domain.bean.StatisticsAttentionRes;
import com.wechat.domain.bean.StatisticsRes;
import com.wechat.domain.bean.SurveyTopic;
import com.wechat.domain.parameter.StatisticsParameter;
import com.wechat.service.StatisticsService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: 上午10:09
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsAction extends BaseAction {
    private StatisticsService statisticsService;
    private List<StatisticsRes> statisticsResList;
    private Integer componentId;
    private StatisticsAttentionRes statisticsAttentionRes;
    private String attentionMonth;
    private StatisticsAnswerRes statisticsAnswerRes;
    private Integer surveyId;
    private Integer surveyTopicId;
    private List<SurveyTopic> surveyTopicList;

    /**
     * 统计
     *
     * @return
     */
    public String statistics() {

        return SUCCESS;
    }

    /**
     * 按大转盘统计中奖信息
     *
     * @return
     */
    public String statisticsBigWheelComponent() {
        try {
            statisticsResList = statisticsService.statisticsComponent(super.getUserWeiXin().getId(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 按日期查看大转盘的中奖信息
     *
     * @return
     */
    public String statisticsBigWheelComponentContent() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setComponentId(componentId);
            statisticsParameter.setWeixinId(super.getUserWeiXin().getId());
            statisticsResList = statisticsService.statisticsComponentContent(statisticsParameter, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 统计刮刮卡
     *
     * @return
     */
    public String statisticsSacaratchCard() {
        try {
            statisticsResList = statisticsService.statisticsComponent(super.getUserWeiXin().getId(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 按日期查看刮刮卡的中奖信息
     *
     * @return
     */
    public String statisticsSacaratchCardContent() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setComponentId(componentId);
            statisticsParameter.setWeixinId(super.getUserWeiXin().getId());
            statisticsResList = statisticsService.statisticsComponentContent(statisticsParameter, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 查看被关注时 统计关注量和中奖人数
     *
     * @return
     */
    public String statisticsAttention() {
        try {
            statisticsAttentionRes = statisticsService.statisticsAttention(super.getUserWeiXin().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 按天查看被关注时  关注量和中奖人数
     *
     * @return
     */
    public String statisticsAttentionContent() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setAttentionMonth(attentionMonth);
            statisticsParameter.setWeixinId(super.getUserWeiXin().getId());
            statisticsResList = statisticsService.statisticsAttentionContent(statisticsParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 统计问卷调查
     *
     * @return
     */
    public String statisticsSurvey() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setWeixinId(super.getUserWeiXin().getId());
            statisticsParameter.setType(0);// 问卷调查
            statisticsResList = statisticsService.statisticsSurvey(statisticsParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 统计问卷调查
     *
     * @return
     */
    public String statisticsSurveyContent() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            surveyTopicList = statisticsService.getSurveyTopicList(surveyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 统计问卷调查答案
     *
     * @return
     */
    public String statisticsSurveyAnswer() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setSurveyId(surveyId);
            statisticsParameter.setId(surveyTopicId);
            statisticsAnswerRes = statisticsService.statisticsAnswer(statisticsParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    /**
     * 统计有奖竞答
     *
     * @return
     */
    public String statisticsPrizeQuiz() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setWeixinId(super.getUserWeiXin().getId());
            statisticsParameter.setType(1);// 问卷调查
            statisticsResList = statisticsService.statisticsSurvey(statisticsParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 统计有奖竞答--按天查看
     *
     * @return
     */
    public String statisticsPrizeQuizContent() {
        StatisticsParameter statisticsParameter = new StatisticsParameter();
        try {
            statisticsParameter.setWeixinId(super.getUserWeiXin().getId());
            statisticsParameter.setType(1);// 问卷调查
            statisticsParameter.setComponentId(componentId);
            statisticsResList = statisticsService.statisticsSurveyContent(statisticsParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 统计答案的选择人数
     *
     * @return
     */
    public String statisticsAnswer() {
        try {
            StatisticsParameter statisticsParameter = new StatisticsParameter();
            statisticsParameter.setSurveyId(57);
            statisticsService.statisticsAnswer(statisticsParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public List<StatisticsRes> getStatisticsResList() {
        return statisticsResList;
    }

    public void setStatisticsResList(List<StatisticsRes> statisticsResList) {
        this.statisticsResList = statisticsResList;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public StatisticsAttentionRes getStatisticsAttentionRes() {
        return statisticsAttentionRes;
    }

    public void setStatisticsAttentionRes(StatisticsAttentionRes statisticsAttentionRes) {
        this.statisticsAttentionRes = statisticsAttentionRes;
    }

    public String getAttentionMonth() {
        return attentionMonth;
    }

    public void setAttentionMonth(String attentionMonth) {
        this.attentionMonth = attentionMonth;
    }

    public StatisticsAnswerRes getStatisticsAnswerRes() {
        return statisticsAnswerRes;
    }

    public void setStatisticsAnswerRes(StatisticsAnswerRes statisticsAnswerRes) {
        this.statisticsAnswerRes = statisticsAnswerRes;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getSurveyTopicId() {
        return surveyTopicId;
    }

    public void setSurveyTopicId(Integer surveyTopicId) {
        this.surveyTopicId = surveyTopicId;
    }

    public List<SurveyTopic> getSurveyTopicList() {
        return surveyTopicList;
    }

    public void setSurveyTopicList(List<SurveyTopic> surveyTopicList) {
        this.surveyTopicList = surveyTopicList;
    }
}
