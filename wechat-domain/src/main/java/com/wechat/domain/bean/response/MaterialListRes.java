package com.wechat.domain.bean.response;


/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-6
 * Time: ÏÂÎç12:51
 * To change this template use File | Settings | File Templates.
 */
public class MaterialListRes {
    private Integer Id;
    private String title;
    private String picUrl;
    private String abstractContent;
    private String message;
    private Integer manyImageTextCount;

    public Integer getManyImageTextCount() {
        return manyImageTextCount;
    }

    public void setManyImageTextCount(Integer manyImageTextCount) {
        this.manyImageTextCount = manyImageTextCount;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
