package com.wechat.dao.impl;

import com.wechat.dao.BaseDao;
import com.wechat.dao.HomeDao;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: обнГ6:04
 */
public class HomeDaoImpl extends BaseDao implements HomeDao {
    public List<UserWeiXin> authRelevanceWeixinAccount(User user) {
        return queryForList("Home.getWeixinAccount", user);
    }

}
