package com.wechat.service;


import com.wechat.domain.bean.StatisticsAnswerRes;
import com.wechat.domain.bean.StatisticsAttentionRes;
import com.wechat.domain.bean.StatisticsRes;
import com.wechat.domain.bean.SurveyTopic;
import com.wechat.domain.parameter.StatisticsParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsService {
    /**
     * 按组件统计中奖信息
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsComponent(Integer weixinId, Integer flag);

    /**
     * 按日期查看组件的中奖信息
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsComponentContent(StatisticsParameter statisticsParameter, Integer flag);

    /**
     * 统计被关注时的中奖人数和关注量
     *
     * @param weixinId
     * @return
     */
    StatisticsAttentionRes statisticsAttention(Integer weixinId);

    /**
     * 统计被关注时的中奖人数和关注量 按每天查看详情
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter);


    /**
     * 统计问卷调查和有奖竞答
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsSurvey(StatisticsParameter statisticsParameter);


    /**
     * 统计问卷调查和有奖竞答  按天查看
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsSurveyContent(StatisticsParameter statisticsParameter);


    /**
     * 统计每个答案的选择量
     *
     * @param statisticsParameter
     * @return
     */
    StatisticsAnswerRes statisticsAnswer(StatisticsParameter statisticsParameter);


    /**
     * 获得问卷调查下的题目
     *
     * @param surveyId
     * @return
     */
    List<SurveyTopic> getSurveyTopicList(Integer surveyId);

}
