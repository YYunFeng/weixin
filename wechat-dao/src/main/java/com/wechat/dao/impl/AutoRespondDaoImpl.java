package com.wechat.dao.impl;
import com.wechat.dao.AutoRespondDao;
import com.wechat.dao.BaseDao;
import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.AutoRespondRes;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç8:17
 * To change this template use File | Settings | File Templates.
 */
public class AutoRespondDaoImpl extends BaseDao implements AutoRespondDao {


    public List<KeyWordLink> getAutoRespond(UserWeiXin userWeiXin) {
        return queryForList("AutoRespond.getAutoRespond", userWeiXin);
    }

    public Integer createAutoRespond(KeyWordLink keyWordLink) {
        return (Integer) insert("AutoRespond.createAutoRespond", keyWordLink);
    }

    public void updateAutoRespond(KeyWordLink keyWordLink) {
        update("AutoRespond.updateAutoRespond", keyWordLink);
    }

    public AutoRespondRes getAutoRespondById(KeyWordLink keyWordLink) {
        return (AutoRespondRes) queryForObject("AutoRespond.getAutoRespondById", keyWordLink);
    }

    public void deleteRule(KeyWordLink keyWordLink) {
        delete("AutoRespond.deleteRule", keyWordLink);
    }

    public TextResources gerTextResource(TextResources textResources) {
        return (TextResources) queryForObject("AutoRespond.getTextResource", textResources);
    }

    public FoucsLucky getFoucsLucky(Integer weixinId) {
        return (FoucsLucky) queryForObject("AutoRespond.getFoucsLucky", weixinId);
    }

    public UserWeiXin getUserWeiXin(User user) {
        return (UserWeiXin) queryForObject("Home.getWeixinAccount", user);
    }

    public void updateTextResources(TextResources textResources) {
        update("AutoRespond.updateTextResources", textResources);
    }

    public void updateFoucsLucky(FoucsLucky focusLucky) {
        update("AutoRespond.updateFoucsLucky", focusLucky);
    }

    public void updateUserWeiXin(UserWeiXin userWeiXin) {
        update("AutoRespond.updateUserWeiXin", userWeiXin);
    }

    public KeyWordLink autoRule(KeyWordLink keyWordLink) {
        return (KeyWordLink) queryForObject("AutoRespond.autoRule", keyWordLink);
    }

    public List<KeyWordLink> exportHelp(Integer weixinId) {
        return queryForList("AutoRespond.exportHelp", weixinId);
    }

}
