package com.wechat.domain.bean;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-21
 * Time: 下午12:12
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsAnswerRes {
    /**
     * 问题
     */
    private String questionTitle;
    /**
     * 答案內容
     */
    private String categories;
    /**
     * 选择答案的人数
     */
    private String dates;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
}
