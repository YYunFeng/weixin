package com.wechat.manager.impl;

import com.wechat.dao.SettingDao;
import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.manager.SettingManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç3:47
 * To change this template use File | Settings | File Templates.
 */
public class SettingManagerImpl implements SettingManager {
    private SettingDao settingDao;

    @Override
    public Integer saveweixinaccountsetting(User user, UserWeiXin userWeiXin) {
        return settingDao.saveweixinaccountsetting(user, userWeiXin);
    }

    @Override
    public User getPersonMess(User user) {
        return settingDao.getPersonMess(user);
    }

    @Override
    public UserWeiXin getInterfaceMess(UserWeiXin userWeiXin) {
        return settingDao.getInterfaceMess(userWeiXin);
    }

    @Override
    public void createTextResource(List<TextResources> textResourcesList) {
        for (int i = 0; i < textResourcesList.size(); i++) {
            settingDao.createTextResource(textResourcesList.get(i));
        }
    }

    @Override
    public Integer createTextResource(TextResources textResources) {
        return settingDao.createTextResource(textResources);
    }

    @Override
    public void createdFoucsLucky(FoucsLucky focusLucky) {
        settingDao.createdFoucsLucky(focusLucky);
    }

    @Override
    public void modifyPass(User user) {
        settingDao.modifyPass(user);
    }

    public void setSettingDao(SettingDao settingDao) {
        this.settingDao = settingDao;
    }
}
