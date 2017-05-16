package com.wechat.domain.bean.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ÏÂÎç6:29
 * To change this template use File | Settings | File Templates.
 */
public class DownstreamMessage {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;
    private Integer ArticleCount;
    private Articles Articles;
    private Integer FuncFlag;

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public Articles getArticles() {
        return Articles;
    }

    public void setArticles(Articles articles) {
        Articles = articles;
    }


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Integer getFuncFlag() {
        return FuncFlag;
    }

    public void setFuncFlag(Integer funcFlag) {
        FuncFlag = funcFlag;
    }
}
