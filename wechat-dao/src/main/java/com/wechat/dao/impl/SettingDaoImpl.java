package com.wechat.dao.impl;


import com.wechat.dao.BaseDao;
import com.wechat.dao.SettingDao;
import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ÏÂÎç3:45
 * To change this template use File | Settings | File Templates.
 */
public class SettingDaoImpl extends BaseDao implements SettingDao {


    public Integer saveweixinaccountsetting(User user, UserWeiXin userWeiXin) {
        update("Setting.updateUser", user);
        return (Integer) insert("Setting.createWeixinUser", userWeiXin);
    }

    public User getPersonMess(User user) {
        return (User) queryForObject("Setting.getPersonMess", user);
    }

    public UserWeiXin getInterfaceMess(UserWeiXin userWeiXin) {
        return (UserWeiXin) queryForObject("Setting.interfaceMess", userWeiXin);
    }

    public Integer createTextResource(TextResources textResources) {
        return (Integer) insert("Setting.createTextResource", textResources);
    }

    public void createdFoucsLucky(FoucsLucky focusLucky) {
        insert("Setting.createdFoucsLucky", focusLucky);
    }

    public void modifyPass(User user) {
        update("Setting.modifyPass", user);
    }
}
