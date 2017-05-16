package com.wechat.domain.bean.response;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-29
 * Time: обнГ5:57
 * To change this template use File | Settings | File Templates.
 */
public class StatisUserCount {
    private Integer todayCount;
    private Integer totalCount;

    public Integer getTodayCount() {
        return todayCount;
    }

    public void setTodayCount(Integer todayCount) {
        this.todayCount = todayCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
