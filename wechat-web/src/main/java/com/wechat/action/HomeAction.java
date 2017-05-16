package com.wechat.action;


import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.domain.bean.response.SaveweixinaccuntRes;
import com.wechat.service.HomeService;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ÏÂÎç4:57
 * To change this template use File | Settings | File Templates.
 */
public class HomeAction extends BaseAction {
    private User user;
    private UserWeiXin userWeiXin;
    private String userName;
    private HomeService homeService;
    private SaveweixinaccuntRes saveweixinaccuntRes;

    /**
     * @return
     */
    public String home() {
        return SUCCESS;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserWeiXin getUserWeiXin() {
        return userWeiXin;
    }

    public void setUserWeiXin(UserWeiXin userWeiXin) {
        this.userWeiXin = userWeiXin;
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    public SaveweixinaccuntRes getSaveweixinaccuntRes() {
        return saveweixinaccuntRes;
    }

    public void setSaveweixinaccuntRes(SaveweixinaccuntRes saveweixinaccuntRes) {
        this.saveweixinaccuntRes = saveweixinaccuntRes;
    }
}
