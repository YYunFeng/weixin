package com.wechat.domain.utils;


import com.wechat.domain.bean.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-22
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsAnswerUtil {
    public static List<Answer> getAnswer(String answer, Integer surveyId) {
        List<Answer> answerList = new ArrayList<Answer>();
        try {
            if (answer.indexOf(surveyId) >= -1) { // 如果有该题目的ID，开始分解字符串
                String[] answerArrey = answer.split("},");
                for (int i = 0; i < answerArrey.length; i++) {
                    String answertemp = answerArrey[i].replaceAll("}", "").replaceAll("\\{", "").replaceAll("\"", "").replaceAll("\"", "");
                    String[] answertempArry = answertemp.split(":");
                    Answer answerTemp = new Answer();
                    answerTemp.setSurveyTopicId(Integer.valueOf(answertempArry[0]));
                    answerTemp.setAnswer(answertempArry[2]);
                    answerList.add(answerTemp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return answerList;
    }

}
