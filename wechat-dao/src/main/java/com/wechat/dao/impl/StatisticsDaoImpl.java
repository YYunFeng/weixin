package com.wechat.dao.impl;


import com.wechat.dao.BaseDao;
import com.wechat.dao.StatisticsDao;
import com.wechat.domain.bean.StatisticsRes;
import com.wechat.domain.bean.StatisticsViewRes;
import com.wechat.domain.bean.SurveyAnswer;
import com.wechat.domain.bean.SurveyTopic;
import com.wechat.domain.parameter.StatisticsParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: ÉÏÎç11:25
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsDaoImpl extends BaseDao implements StatisticsDao {

    public List<StatisticsRes> statisticsBigWheelComponent(Integer weixinId) {
        return queryForList("Statistics.statisticsBigWheelComponent", weixinId);
    }

    public List<StatisticsRes> statisticsBigWheelComponentContent(StatisticsParameter statisticsParameter) {
        return queryForList("Statistics.statisticsBigWheelComponentContent", statisticsParameter);
    }

    public List<StatisticsRes> statisticsSacaratchCard(Integer weixinId) {
        return queryForList("Statistics.statisticsSacaratchCard", weixinId);
    }

    public List<StatisticsRes> statisticsSacaratchCardContent(StatisticsParameter statisticsParameter) {
        return queryForList("Statistics.statisticsSacaratchCardContent", statisticsParameter);
    }

    public List<StatisticsRes> statisticsAttention(Integer weixinId) {
        return queryForList("Statistics.statisticsAttention", weixinId);
    }

    public List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter) {
        return queryForList("Statistics.statisticsAttentionContent", statisticsParameter);
    }

    public List<StatisticsViewRes> statisticsViewCount(Integer componentId) {
        return queryForList("Statistics.statisticsViewCount", componentId);
    }

    public List<StatisticsRes> statisticsSurvey(StatisticsParameter statisticsParameter) {
        return queryForList("Statistics.statisticsSurvey", statisticsParameter);
    }

    public List<StatisticsRes> statisticsSurveyContent(StatisticsParameter statisticsParameter) {
        return queryForList("Statistics.statisticsSurveyContent", statisticsParameter);
    }

    public SurveyTopic getSurveyTopic(Integer Id) {
        return (SurveyTopic) queryForObject("Statistics.getSurveyTopic", Id);
    }

    public List<SurveyAnswer> statisticsAnswer(Integer surveyId) {
        return queryForList("Statistics.statisticsAnswer", surveyId);
    }

    public List<SurveyTopic> getSurveyTopicList(Integer surveyId) {
        return queryForList("Statistics.getSurveyTopicList", surveyId);
    }
}
