package com.wechat.service.impl;


import com.wechat.domain.bean.User;
import com.wechat.manager.RegisterManager;
import com.wechat.service.RegisterService;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ÏÂÎç1:15
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServiceImpl implements RegisterService {
    private RegisterManager registerManager;

    /**
     * ×¢²áÓÃ»§
     *
     * @param user
     */
    public Integer createUser(User user) {
       return registerManager.createUser(user);
    }

    public User authUser(User user) {
        return registerManager.authUser(user);
    }

    public void setRegisterManager(RegisterManager registerManager) {
        this.registerManager = registerManager;
    }
}
