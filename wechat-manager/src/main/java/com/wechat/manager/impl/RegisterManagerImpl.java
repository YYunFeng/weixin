package com.wechat.manager.impl;


import com.wechat.dao.RegisterDao;
import com.wechat.domain.bean.User;
import com.wechat.manager.RegisterManager;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ÏÂÎç1:12
 * To change this template use File | Settings | File Templates.
 */
public class RegisterManagerImpl implements RegisterManager {
    private RegisterDao registerDao;

    public Integer createUser(User user) {
       return registerDao.createUser(user);
    }

    public User authUser(User user) {
        return registerDao.authUser(user);
    }

    public void setRegisterDao(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

}
