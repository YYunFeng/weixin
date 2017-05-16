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
 * Time: ����11:28
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsService {
    /**
     * �����ͳ���н���Ϣ
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsComponent(Integer weixinId, Integer flag);

    /**
     * �����ڲ鿴������н���Ϣ
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsComponentContent(StatisticsParameter statisticsParameter, Integer flag);

    /**
     * ͳ�Ʊ���עʱ���н������͹�ע��
     *
     * @param weixinId
     * @return
     */
    StatisticsAttentionRes statisticsAttention(Integer weixinId);

    /**
     * ͳ�Ʊ���עʱ���н������͹�ע�� ��ÿ��鿴����
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter);


    /**
     * ͳ���ʾ������н�����
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsSurvey(StatisticsParameter statisticsParameter);


    /**
     * ͳ���ʾ������н�����  ����鿴
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsSurveyContent(StatisticsParameter statisticsParameter);


    /**
     * ͳ��ÿ���𰸵�ѡ����
     *
     * @param statisticsParameter
     * @return
     */
    StatisticsAnswerRes statisticsAnswer(StatisticsParameter statisticsParameter);


    /**
     * ����ʾ�����µ���Ŀ
     *
     * @param surveyId
     * @return
     */
    List<SurveyTopic> getSurveyTopicList(Integer surveyId);

}
