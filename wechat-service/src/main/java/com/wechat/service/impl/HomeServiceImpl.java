package com.wechat.service.impl;


import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.manager.HomeManager;
import com.wechat.service.HomeService;
import com.wechat.domain.utils.PathsUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ÏÂÎç6:08
 * To change this template use File | Settings | File Templates.
 */
public class HomeServiceImpl implements HomeService {
    private HomeManager homeManager;
    private PathsUtil pathsUtil;

    public void setHomeManager(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    public List<UserWeiXin> authRelevanceWeixinAccount(User user) {
        return homeManager.authRelevanceWeixinAccount(user);
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
