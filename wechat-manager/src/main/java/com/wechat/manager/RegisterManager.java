package com.wechat.manager;


import com.wechat.domain.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ����1:11
 * To change this template use File | Settings | File Templates.
 */
public interface RegisterManager {
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
