package com.wechat.service.impl;


import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.manager.SettingManager;
import com.wechat.service.SettingService;
import com.wechat.domain.utils.PathsUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç3:49
 * To change this template use File | Settings | File Templates.
 */
public class SettingServiceImpl implements SettingService {
    private SettingManager settingManager;
    private PathsUtil pathsUtil;

    public Integer saveweixinaccountsetting(User user, UserWeiXin userWeiXin) {
        Integer weixinId = null;
        try {
            String interfaceToken = user.getId() + String.valueOf(System.currentTimeMillis());
            userWeiXin.setInterfaceToken(interfaceToken);
            userWeiXin.setUserId(user.getId());
            weixinId = settingManager.saveweixinaccountsetting(user, userWeiXin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weixinId;
    }

    public User getPersonMess(User user) {
        return settingManager.getPersonMess(user);
    }

    public UserWeiXin getInterfaceMess(UserWeiXin userWeiXin) {
        UserWeiXin userWeiXinRes = settingManager.getInterfaceMess(userWeiXin);
        userWeiXinRes.setUrl(pathsUtil.getInterfaceUrl() + "?weixinAccountId=" + userWeiXin.getId());
        return userWeiXinRes;
    }

    public void createTextResource(List<TextResources> textResourcesList) {
        settingManager.createTextResource(textResourcesList);
    }

    public Integer createTextResource(TextResources textResources) {
        return settingManager.createTextResource(textResources);
    }

    public void createdFoucsLucky(FoucsLucky focusLucky) {
        settingManager.createdFoucsLucky(focusLucky);
    }

    public void modifyPass(User user) {
        settingManager.modifyPass(user);
    }

    public void setSettingManager(SettingManager settingManager) {
        this.settingManager = settingManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
