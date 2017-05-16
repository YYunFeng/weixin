package com.wechat.domain.bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-27
 * Time: ÏÂÎç6:24
 * To change this template use File | Settings | File Templates.
 */
public class PageResultSet<T> {
    private List<T> list;
    private Page page;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
