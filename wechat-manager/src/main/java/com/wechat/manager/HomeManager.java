package com.wechat.manager;



import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ����6:06
 * To change this template use File | Settings | File Templates.
 */
public interface HomeManager {

    List<UserWeiXin> authRelevanceWeixinAccount(User user);

}
