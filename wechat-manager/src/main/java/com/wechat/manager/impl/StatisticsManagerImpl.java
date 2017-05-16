package com.wechat.manager.impl;


import com.wechat.dao.StatisticsDao;
import com.wechat.domain.bean.StatisticsRes;
import com.wechat.domain.bean.StatisticsViewRes;
import com.wechat.domain.bean.SurveyAnswer;
import com.wechat.domain.bean.SurveyTopic;
import com.wechat.domain.parameter.StatisticsParameter;
import com.wechat.manager.StatisticsManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: ÉÏÎç11:27
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsManagerImpl implements StatisticsManager {
    private StatisticsDao statisticsDao;

    public List<StatisticsRes> statisticsBigWheelComponent(Integer weixinId) {
        return statisticsDao.statisticsBigWheelComponent(weixinId);
    }

    public List<StatisticsRes> statisticsBigWheelComponentContent(StatisticsParameter statisticsParameter) {
        return statisticsDao.statisticsBigWheelComponentContent(statisticsParameter);
    }

    public List<StatisticsRes> statisticsSacaratchCard(Integer weixinId) {
        return statisticsDao.statisticsSacaratchCard(weixinId);
    }

    public List<StatisticsRes> statisticsSacaratchCardContent(StatisticsParameter statisticsParameter) {
        return statisticsDao.statisticsSacaratchCardContent(statisticsParameter);
    }

    public List<StatisticsRes> statisticsAttention(Integer weixinId) {
        return statisticsDao.statisticsAttention(weixinId);
    }

    public List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter) {
        return statisticsDao.statisticsAttentionContent(statisticsParameter);
    }

    public List<StatisticsViewRes> statisticsViewCount(Integer componentId) {
        return statisticsDao.statisticsViewCount(componentId);
    }

    public List<StatisticsRes> statisticsSurvey(StatisticsParameter statisticsParameter) {
        return statisticsDao.statisticsSurvey(statisticsParameter);
    }

    public List<StatisticsRes> statisticsSurveyContent(StatisticsParameter statisticsParameter) {
        return statisticsDao.statisticsSurveyContent(statisticsParameter);
    }

    public SurveyTopic getSurveyTopic(Integer Id) {
        return statisticsDao.getSurveyTopic(Id);
    }

    public List<SurveyAnswer> statisticsAnswer(Integer surveyId) {
        return statisticsDao.statisticsAnswer(surveyId);
    }

    public List<SurveyTopic> getSurveyTopicList(Integer surveyId) {
        return statisticsDao.getSurveyTopicList(surveyId);
    }

    public void setStatisticsDao(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }
}
