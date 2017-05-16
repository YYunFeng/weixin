package com.wechat.service.impl;


import com.wechat.domain.bean.*;
import com.wechat.domain.parameter.StatisticsParameter;
import com.wechat.manager.StatisticsManager;
import com.wechat.service.StatisticsService;
import com.wechat.domain.utils.StatisticsAnswerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-15
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsServiceImpl implements StatisticsService {
    private StatisticsManager statisticsManager;

    public List<StatisticsRes> statisticsComponent(Integer weixinId, Integer flag) {
        List<StatisticsRes> statisticsResList = new ArrayList<StatisticsRes>();
        List<StatisticsRes> statisticsResListTmp = new ArrayList<StatisticsRes>();
        try {
            if (flag != null) {
                if (flag.intValue() == 0) { // 大转盘
                    statisticsResListTmp = statisticsManager.statisticsBigWheelComponent(weixinId);
                }
                if (flag.intValue() == 1) { // 刮刮卡
                    statisticsResListTmp = statisticsManager.statisticsSacaratchCard(weixinId);
                }
            }
            StatisticsRes temp = null;
            for (StatisticsRes statisticsRes : statisticsResListTmp) {
                if (temp == null || temp.getComponentId().intValue() != statisticsRes.getComponentId().intValue()) {
                    temp = new StatisticsRes();
                    temp.setTitle(statisticsRes.getTitle());
                    temp.setComponentId(statisticsRes.getComponentId());
                    temp.setPartakeNumber(0);
                    temp.setWinNumber(0);
                    temp.setCount(0);
                    temp.setVisitView(statisticsRes.getVisitView());
                    statisticsResList.add(temp);
                }
                if (statisticsRes.getPrizeId() != null && !statisticsRes.getPrizeId().equals("-1")) { // 中奖
                    temp.setWinNumber(temp.getWinNumber() + statisticsRes.getCount());
                }
                temp.setPartakeNumber(temp.getPartakeNumber() + statisticsRes.getCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsResList;
    }

    public List<StatisticsRes> statisticsComponentContent(StatisticsParameter statisticsParameter, Integer flag) {
        List<StatisticsRes> statisticsResListTmp = new ArrayList<StatisticsRes>();
        List<StatisticsRes> statisticsResList = new ArrayList<StatisticsRes>();
        try {
            // 查出该组件的访问数量
            List<StatisticsViewRes> statisticsViewResesList = statisticsManager.statisticsViewCount(statisticsParameter.getComponentId());
            if (flag != null) {
                if (flag.intValue() == 0) {  //  统计大转盘
                    statisticsResListTmp = statisticsManager.statisticsBigWheelComponentContent(statisticsParameter);
                }
                if (flag.intValue() == 1) {  //  统计刮刮卡
                    statisticsResListTmp = statisticsManager.statisticsSacaratchCardContent(statisticsParameter);
                }
            }
            StatisticsRes temp = null;
            for (StatisticsRes statisticsRes : statisticsResListTmp) {
                if (temp == null || !statisticsRes.getDrawTime().equals(temp.getDrawTime())) {
                    temp = new StatisticsRes();
                    temp.setDrawTime(statisticsRes.getDrawTime());
                    temp.setComponentId(statisticsRes.getComponentId());
                    temp.setPartakeNumber(0);
                    temp.setWinNumber(0);
                    temp.setCount(0);
                    statisticsResList.add(temp);
                }
                if (statisticsRes.getPrizeId() != null && !statisticsRes.getPrizeId().equals("-1")) { // 中奖
                    temp.setWinNumber(temp.getWinNumber() + statisticsRes.getCount());
                }
                temp.setPartakeNumber(temp.getPartakeNumber() + statisticsRes.getCount());
            }
            //  统计访问量
            for (StatisticsRes statisticsRes : statisticsResList) {
                for (StatisticsViewRes statisticsViewRes : statisticsViewResesList) {
                    if (statisticsRes.getDrawTime().equals(statisticsViewRes.getDrawTime())) {
                        statisticsRes.setVisitView(statisticsViewRes.getCount());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsResList;
    }

    public StatisticsAttentionRes statisticsAttention(Integer weixinId) {
        StatisticsAttentionRes statisticsAttentionRes = new StatisticsAttentionRes();
        List<StatisticsRes> statisticsResList = new ArrayList<StatisticsRes>();
        try {
            List<StatisticsRes> statisticsResListTemp = statisticsManager.statisticsAttention(weixinId);
            StatisticsRes temp = null;
            int allTotalAttentionCount = 0;
            int allWinnerCount = 0;
            for (StatisticsRes statisticsRes : statisticsResListTemp) {
                if (temp == null || !statisticsRes.getAttentionMonth().equals(temp.getAttentionMonth())) {
                    temp = new StatisticsRes();
                    temp.setAttentionMonth(statisticsRes.getAttentionMonth());
                    temp.setWinNumber(0);
                    temp.setTotalAttionCount(0);
                    temp.setCount(0);

                    statisticsResList.add(temp);
                }
                if (statisticsRes.getLucky()) {  // 中奖了
                    temp.setWinNumber(statisticsRes.getCount());
                    allWinnerCount += statisticsRes.getCount();
                }
                allTotalAttentionCount += statisticsRes.getCount();
                temp.setTotalAttionCount(temp.getTotalAttionCount() + statisticsRes.getCount());
            }
            statisticsAttentionRes.setAllTotalAttentionCount(allTotalAttentionCount);
            statisticsAttentionRes.setAllWinnerCount(allWinnerCount);
            statisticsAttentionRes.setStatisticsResList(statisticsResList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsAttentionRes;
    }

    public List<StatisticsRes> statisticsAttentionContent(StatisticsParameter statisticsParameter) {
        List<StatisticsRes> statisticsResList = new ArrayList<StatisticsRes>();
        try {
            List<StatisticsRes> statisticsResListTemp = statisticsManager.statisticsAttentionContent(statisticsParameter);
            StatisticsRes temp = null;
            for (StatisticsRes statisticsRes : statisticsResListTemp) {
                if (temp == null || !statisticsRes.getDrawTime().equals(temp.getDrawTime())) {
                    temp = new StatisticsRes();
                    temp.setDrawTime(statisticsRes.getDrawTime());
                    temp.setWinNumber(0);
                    temp.setTotalAttionCount(0);
                    temp.setCount(0);
                    statisticsResList.add(temp);
                }
                if (statisticsRes.getLucky()) {
                    temp.setWinNumber(statisticsRes.getCount());
                }
                temp.setTotalAttionCount(temp.getTotalAttionCount() + statisticsRes.getCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsResList;
    }

    public List<StatisticsRes> statisticsSurvey(StatisticsParameter statisticsParameter) {
        List<StatisticsRes> statisticsResList = new ArrayList<StatisticsRes>();
        List<StatisticsRes> statisticsResListTmp = new ArrayList<StatisticsRes>();
        try {
            statisticsResListTmp = statisticsManager.statisticsSurvey(statisticsParameter);
            StatisticsRes temp = null;
            for (StatisticsRes statisticsRes : statisticsResListTmp) {
                if (temp == null || temp.getComponentId().intValue() != statisticsRes.getComponentId().intValue()) {
                    temp = new StatisticsRes();
                    temp.setTitle(statisticsRes.getTitle());
                    temp.setComponentId(statisticsRes.getComponentId());
                    temp.setPartakeNumber(0);
                    temp.setWinNumber(0);
                    temp.setCount(0);
                    temp.setSurveyId(statisticsRes.getSurveyId());
                    temp.setVisitView(statisticsRes.getVisitView());  // 访问量
                    statisticsResList.add(temp);
                }
                if (statisticsRes.getPrize()) { // 中奖了
                    temp.setWinNumber(temp.getWinNumber() + statisticsRes.getCount());
                }
                temp.setPartakeNumber(temp.getPartakeNumber() + statisticsRes.getCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsResList;
    }

    public List<StatisticsRes> statisticsSurveyContent(StatisticsParameter statisticsParameter) {
        List<StatisticsRes> statisticsResListTmp = new ArrayList<StatisticsRes>();
        List<StatisticsRes> statisticsResList = new ArrayList<StatisticsRes>();
        try {
            // 查出该组件的访问数量
            List<StatisticsViewRes> statisticsViewResesList = statisticsManager.statisticsViewCount(statisticsParameter.getComponentId());
            statisticsResListTmp = statisticsManager.statisticsSurveyContent(statisticsParameter);
            StatisticsRes temp = null;
            for (StatisticsRes statisticsRes : statisticsResListTmp) {
                if (temp == null || !statisticsRes.getDrawTime().equals(temp.getDrawTime())) {
                    temp = new StatisticsRes();
                    temp.setDrawTime(statisticsRes.getDrawTime());
                    temp.setComponentId(statisticsRes.getComponentId());
                    temp.setPartakeNumber(0);
                    temp.setWinNumber(0);
                    temp.setCount(0);
                    statisticsResList.add(temp);
                }
                if (statisticsRes.getPrize()) { // 中奖
                    temp.setWinNumber(temp.getWinNumber() + statisticsRes.getCount());
                }
                temp.setPartakeNumber(temp.getPartakeNumber() + statisticsRes.getCount());
            }
            //  统计访问量
            for (StatisticsRes statisticsRes : statisticsResList) {
                for (StatisticsViewRes statisticsViewRes : statisticsViewResesList) {
                    if (statisticsRes.getDrawTime().equals(statisticsViewRes.getDrawTime())) {
                        statisticsRes.setVisitView(statisticsViewRes.getCount());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsResList;
    }

    public StatisticsAnswerRes statisticsAnswer(StatisticsParameter statisticsParameter) {
        StatisticsAnswerRes statisticsAnswerRes = new StatisticsAnswerRes();
        try {
            // 获取题目内容
            SurveyTopic surveyTopic = statisticsManager.getSurveyTopic(statisticsParameter.getId());
            StringBuffer stringBuffer = new StringBuffer();
            if (surveyTopic.getSel1() != null && !surveyTopic.getSel1().equals("")) {
                stringBuffer.append("'" + surveyTopic.getSel1() + "',");
            }
            if (surveyTopic.getSel2() != null && !surveyTopic.getSel2().equals("")) {
                stringBuffer.append("'" + surveyTopic.getSel2() + "',");
            }
            if (surveyTopic.getSel3() != null && !surveyTopic.getSel3().equals("")) {
                stringBuffer.append("'" + surveyTopic.getSel3() + "',");
            }
            if (surveyTopic.getSel4() != null && !surveyTopic.getSel4().equals("")) {
                stringBuffer.append("'" + surveyTopic.getSel4() + "',");
            }
            if (surveyTopic.getSel5() != null && !surveyTopic.getSel5().equals("")) {
                stringBuffer.append("'" + surveyTopic.getSel5() + "'");
            }
            // 得到答案
            List<SurveyAnswer> surveyAnswerList = statisticsManager.statisticsAnswer(statisticsParameter.getSurveyId());
            Integer[] dates = new Integer[6];
            dates[0] = 0;
            dates[1] = 0;
            dates[2] = 0;
            dates[3] = 0;
            dates[4] = 0;
            dates[5] = 0;
            for (SurveyAnswer surveyAnswer : surveyAnswerList) {
                List<Answer> answerList = StatisticsAnswerUtil.getAnswer(surveyAnswer.getAnswer(), statisticsParameter.getSurveyId());
                for (Answer answer : answerList) {
                    if (answer.getSurveyTopicId() != null && answer.getSurveyTopicId().intValue() == statisticsParameter.getId()) {
                        if (answer.getAnswer() != null && answer.getAnswer().equals("1")) { // 答案一
                            dates[0] += 1;
                        }
                        if (answer.getAnswer() != null && answer.getAnswer().equals("2")) { // 答案二
                            dates[1] += 1;
                        }
                        if (answer.getAnswer() != null && answer.getAnswer().equals("3")) { // 答案三
                            dates[2] += 1;
                        }
                        if (answer.getAnswer() != null && answer.getAnswer().equals("4")) { // 答案四
                            dates[3] += 1;
                        }
                        if (answer.getAnswer() != null && answer.getAnswer().equals("5")) { // 答案五
                            dates[4] += 1;
                        }
                        if (answer.getAnswer() != null && answer.getAnswer().equals("6")) { // 答案六
                            dates[5] += 1;
                        }
                    }
                }
            }

            StringBuffer stringBuffer1 = new StringBuffer();
            for (int i = 0; i < stringBuffer.toString().split(",").length; i++) {
                stringBuffer1.append(dates[i] + ",");
            }
            statisticsAnswerRes.setDates(stringBuffer1.toString());
            statisticsAnswerRes.setCategories(stringBuffer.toString());
            statisticsAnswerRes.setQuestionTitle(surveyTopic.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsAnswerRes;
    }

    public List<SurveyTopic> getSurveyTopicList(Integer surveyId) {
        return statisticsManager.getSurveyTopicList(surveyId);
    }

    public void setStatisticsManager(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
    }
}
