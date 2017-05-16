package com.wechat.manager.impl;

import com.wechat.dao.AutoRespondDao;
import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.AutoRespondRes;
import com.wechat.manager.AutoRespondManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç8:19
 * To change this template use File | Settings | File Templates.
 */
public class AutoRespondManagerImpl implements AutoRespondManager {
    private AutoRespondDao autoRespondDao;

    public List<KeyWordLink> getAutoRespond(UserWeiXin userWeiXin) {
        return autoRespondDao.getAutoRespond(userWeiXin);
    }

    public Integer createAutoRespond(KeyWordLink keyWordLink) {
        return autoRespondDao.createAutoRespond(keyWordLink);
    }

    public void updateAutoRespond(KeyWordLink keyWordLink) {
        autoRespondDao.updateAutoRespond(keyWordLink);
    }

    public AutoRespondRes getAutoRespondById(KeyWordLink keyWordLink) {
        return autoRespondDao.getAutoRespondById(keyWordLink);
    }

    public void deleteRule(KeyWordLink keyWordLink) {
        autoRespondDao.deleteRule(keyWordLink);
    }

    public TextResources getTextResources(TextResources textResources) {
        return autoRespondDao.gerTextResource(textResources);
    }

    public FoucsLucky getFoucsLucky(Integer weixinId) {
        return autoRespondDao.getFoucsLucky(weixinId);
    }

    public UserWeiXin getUserWeiXin(User user) {
        return autoRespondDao.getUserWeiXin(user);
    }

    public void updateTextResources(TextResources textResources) {
        autoRespondDao.updateTextResources(textResources);
    }

    public void updateFoucsLucky(FoucsLucky focusLucky) {
        autoRespondDao.updateFoucsLucky(focusLucky);
    }

    public void updateUserWeiXin(UserWeiXin userWeiXin) {
        autoRespondDao.updateUserWeiXin(userWeiXin);
    }

    public KeyWordLink autoRule(KeyWordLink keyWordLink) {
        return autoRespondDao.autoRule(keyWordLink);
    }

    public List<KeyWordLink> exportHelp(Integer weixinId) {
        return autoRespondDao.exportHelp(weixinId);
    }

    public void setAutoRespondDao(AutoRespondDao autoRespondDao) {
        this.autoRespondDao = autoRespondDao;
    }


}
