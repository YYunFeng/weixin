package com.wechat.domain.parameter;


import com.wechat.domain.utils.BaseQuery;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-27
 * Time: ÉÏÎç10:31
 * To change this template use File | Settings | File Templates.
 */
public class SuperUserParameter extends BaseQuery {
    private String startTime;
    private String endTime;
    private String keyWord;
    private Integer orderby;

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
