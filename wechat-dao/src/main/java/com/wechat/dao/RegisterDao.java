package com.wechat.dao;


import com.wechat.domain.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: 下午12:59
 * To change this template use File | Settings | File Templates.
 */
public interface RegisterDao {
    /**
     * 注册用户
     *
     * @param user
     */
    Integer createUser(User user);

    /**
     * 验证用户是否存在
     *
     * @param user
     * @return
     */
    User authUser(User user);
}
