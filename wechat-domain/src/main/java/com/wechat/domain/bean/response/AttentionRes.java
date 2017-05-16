package com.wechat.domain.bean.response;


import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.UserWeiXin;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-27
 * Time: ÏÂÎç1:36
 * To change this template use File | Settings | File Templates.
 */
public class AttentionRes {
    private FoucsLucky foucsLucky;
    private TextResources textResources;
    private UserWeiXin userWeiXin;

    public FoucsLucky getFoucsLucky() {
        return foucsLucky;
    }

    public void setFoucsLucky(FoucsLucky foucsLucky) {
        this.foucsLucky = foucsLucky;
    }

    public TextResources getTextResources() {
        return textResources;
    }

    public void setTextResources(TextResources textResources) {
        this.textResources = textResources;
    }

    public UserWeiXin getUserWeiXin() {
        return userWeiXin;
    }

    public void setUserWeiXin(UserWeiXin userWeiXin) {
        this.userWeiXin = userWeiXin;
    }
}
