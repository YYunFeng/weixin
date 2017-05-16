package com.wechat.domain.bean.proxy;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-27
 * Time: ÏÂÎç5:31
 * To change this template use File | Settings | File Templates.
 */
public class LuckyLog {

    private String componentTitle;
    private String prizeName;
    private Date created;

    public String getComponentTitle() {
        return componentTitle;
    }

    public void setComponentTitle(String componentTitle) {
        this.componentTitle = componentTitle;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
