package com.wechat.dao;


import com.wechat.domain.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ����12:59
 * To change this template use File | Settings | File Templates.
 */
public interface RegisterDao {
    /**
     * ע���û�
     *
     * @param user
     */
    Integer createUser(User user);

    /**
     * ��֤�û��Ƿ����
     *
     * @param user
     * @return
     */
    User authUser(User user);
}
