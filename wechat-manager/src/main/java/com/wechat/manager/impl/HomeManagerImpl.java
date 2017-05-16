package com.wechat.manager.impl;


import com.wechat.dao.HomeDao;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.manager.HomeManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: обнГ6:06
 * To change this template use File | Settings | File Templates.
 */
public class HomeManagerImpl implements HomeManager {
    private HomeDao homeDao;

    public List<UserWeiXin> authRelevanceWeixinAccount(User user) {
        return homeDao.authRelevanceWeixinAccount(user);
    }



    public void setHomeDao(HomeDao homeDao) {
        this.homeDao = homeDao;
    }
}
