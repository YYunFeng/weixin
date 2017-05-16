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
 * Time: ����11:27
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsManager {
    /**
     * ͳ�ƴ�ת��
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsBigWheelComponent(Integer weixinId);

    /**
     * �����ڲ鿴��ת�̵��н���Ϣ
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsBigWheelComponentContent(StatisticsParameter statisticsParameter);


    /**
     * ���ιο�ͳ���н���Ϣ
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsSacaratchCard(Integer weixinId);


    /**
     * �����ڲ鿴�ιο����н���Ϣ
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsSacaratchCardContent(StatisticsParameter statisticsParameter);

    /**
     * ͳ�Ʊ���עʱ���н������͹�ע��
     *
     * @param weixinId
     * @return
     */
    List<StatisticsRes> statisticsAttention(Integer weixinId);

    /**
     * ͳ�Ʊ���עʱ���н������͹�ע�� ��ÿ��鿴����
     *
     * @param statisticsParameter
     * @return
     */
    List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter);

    /**
     * ��ʱ��ȥͳ�Ʒ�����
     * @param componentId
     * @return
     */
    List<StatisticsViewRes> statisticsViewCount(Integer componentId);


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
     * �õ��ʾ�������Ŀ
     *
     * @param Id
     * @return
     */
    SurveyTopic getSurveyTopic(Integer Id);

    /**
     * ͳ�ƴ�
     *
     * @param surveyId
     * @return
     */
    List<SurveyAnswer> statisticsAnswer(Integer surveyId);


    /**
     * ����ʾ�����µ���Ŀ
     *
     * @param surveyId
     * @return
     */
    List<SurveyTopic> getSurveyTopicList(Integer surveyId);


}
