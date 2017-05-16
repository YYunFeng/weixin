package com.wechat.domain.bean.response;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-28
 * Time: ÏÂÎç7:04
 * To change this template use File | Settings | File Templates.
 */
public class LogMessageRes {
    private Integer upstreamCount;
    private Integer downstreamCount;
    private Date created;
    private String upstreamCountRes;
    private String downstreamCountRes;
    private String dateRes;
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUpstreamCountRes() {
        return upstreamCountRes;
    }

    public void setUpstreamCountRes(String upstreamCountRes) {
        this.upstreamCountRes = upstreamCountRes;
    }

    public String getDownstreamCountRes() {
        return downstreamCountRes;
    }

    public void setDownstreamCountRes(String downstreamCountRes) {
        this.downstreamCountRes = downstreamCountRes;
    }

    public String getDateRes() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes = dateRes;
    }

    public Integer getUpstreamCount() {
        return upstreamCount;
    }

    public void setUpstreamCount(Integer upstreamCount) {
        this.upstreamCount = upstreamCount;
    }

    public Integer getDownstreamCount() {
        return downstreamCount;
    }

    public void setDownstreamCount(Integer downstreamCount) {
        this.downstreamCount = downstreamCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
