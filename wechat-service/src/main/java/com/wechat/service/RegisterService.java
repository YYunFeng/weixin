package com.wechat.service;


import com.wechat.domain.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ����1:14
 * To change this template use File | Settings | File Templates.
 */
public interface RegisterService {
    /**
     * ע���û�
     *
     * @param user
     */
    Integer createUser(User user);

    /**
     * ��֤�û��Ƿ���ڣ��û���¼
     *
     * @param user
     * @return
     */
    User authUser(User user);
}
