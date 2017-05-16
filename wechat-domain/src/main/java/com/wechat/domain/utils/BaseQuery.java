package com.wechat.domain.utils;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-27
 * Time: ÏÂÎç6:34
 * To change this template use File | Settings | File Templates.
 */
public class BaseQuery {
    private Integer offset;
    private Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
