package com.wechat.manager;


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
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsManager {
    /**
     * 统计大转盘
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsBigWheelComponent(Integer weixinId);

    /**
     * 按日期查看大转盘的中奖信息
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsBigWheelComponentContent(StatisticsParameter statisticsParameter);


    /**
     * 按刮刮卡统计中奖信息
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsSacaratchCard(Integer weixinId);


    /**
     * 按日期查看刮刮卡的中奖信息
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsSacaratchCardContent(StatisticsParameter statisticsParameter);

    /**
     * 统计被关注时的中奖人数和关注量
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsAttention(Integer weixinId);

    /**
     * 统计被关注时的中奖人数和关注量 按每天查看详情
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter);

    /**
     * 按时间去统计访问量
     * @param componentId
     * @return
     */
    List<StatisticsViewRes> statisticsViewCount(Integer componentId);


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
     * 得到问卷调差的题目
     *
     * @param Id
     * @return
     */
    SurveyTopic getSurveyTopic(Integer Id);

    /**
     * 统计答案
     *
     * @param surveyId
     * @return
     */
    List<SurveyAnswer> statisticsAnswer(Integer surveyId);


    /**
     * 获得问卷调查下的题目
     *
     * @param surveyId
     * @return
     */
    List<SurveyTopic> getSurveyTopicList(Integer surveyId);


}
