package com.wechat.domain.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class Component {
    // ID
    private Integer Id;
    // 微信账号关联表ID
    private Integer weixinId;
    // 组件类型
    private Integer componentType;
    // 标题
    private String title;
    // 图片
    private String pic;
    // 文字描述
    private String intro;

    private Date created;

    private Date endTime;
    // 改组件是否结束
    private Boolean expired;


    private Integer flag;


    private Integer keyword_id;

    public Integer getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(Integer keyword_id) {
        this.keyword_id = keyword_id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    public Integer getComponentType() {
        return componentType;
    }

    public void setComponentType(Integer componentType) {
        this.componentType = componentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
