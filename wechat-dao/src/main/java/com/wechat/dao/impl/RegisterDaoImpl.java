package com.wechat.dao.impl;


import com.wechat.dao.BaseDao;
import com.wechat.dao.RegisterDao;
import com.wechat.domain.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: обнГ1:00
 * To change this template use File | Settings | File Templates.
 */
public class RegisterDaoImpl extends BaseDao implements RegisterDao {
    public Integer createUser(User user) {
        return (Integer) insert("Register.createUser", user);
    }

    public User authUser(User user) {
        return (User) queryForObject("Register.authUser", user);
    }
}
