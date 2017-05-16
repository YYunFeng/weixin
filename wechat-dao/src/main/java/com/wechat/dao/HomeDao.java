package com.wechat.dao;


import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: 下午6:02
 * To change this template use File | Settings | File Templates.
 */
public interface HomeDao {
    /**
     * 验证该用户是否关联微信账号
     *
     * @return
     */
    List<UserWeiXin> authRelevanceWeixinAccount(User user);

}
