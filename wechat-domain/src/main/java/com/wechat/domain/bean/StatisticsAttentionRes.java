package com.wechat.domain.bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-16
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsAttentionRes {
    private Integer allTotalAttentionCount; // 总的关注量
    private Integer allWinnerCount;// 总的中奖人数
    private List<StatisticsRes> statisticsResList;

    public Integer getAllTotalAttentionCount() {
        return allTotalAttentionCount;
    }

    public void setAllTotalAttentionCount(Integer allTotalAttentionCount) {
        this.allTotalAttentionCount = allTotalAttentionCount;
    }

    public Integer getAllWinnerCount() {
        return allWinnerCount;
    }

    public void setAllWinnerCount(Integer allWinnerCount) {
        this.allWinnerCount = allWinnerCount;
    }

    public List<StatisticsRes> getStatisticsResList() {
        return statisticsResList;
    }

    public void setStatisticsResList(List<StatisticsRes> statisticsResList) {
        this.statisticsResList = statisticsResList;
    }
}
