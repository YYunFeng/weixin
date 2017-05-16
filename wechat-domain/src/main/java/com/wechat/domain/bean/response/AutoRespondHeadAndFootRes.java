package com.wechat.domain.bean.response;


import com.wechat.domain.bean.TextResources;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-28
 * Time: ÏÂÎç12:10
 * To change this template use File | Settings | File Templates.
 */
public class AutoRespondHeadAndFootRes {
    private TextResources textResourcesHead;
    private TextResources textResourcesFoot;

    public TextResources getTextResourcesHead() {
        return textResourcesHead;
    }

    public void setTextResourcesHead(TextResources textResourcesHead) {
        this.textResourcesHead = textResourcesHead;
    }

    public TextResources getTextResourcesFoot() {
        return textResourcesFoot;
    }

    public void setTextResourcesFoot(TextResources textResourcesFoot) {
        this.textResourcesFoot = textResourcesFoot;
    }
}
