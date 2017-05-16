package com.wechat.service;



import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: обнГ6:08
 * To change this template use File | Settings | File Templates.
 */
public interface HomeService {
    List<UserWeiXin> authRelevanceWeixinAccount(User user);
}
