package com.wechat.dao;


import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����3:45
 * To change this template use File | Settings | File Templates.
 */
public interface SettingDao {
    /**
     * ����΢���˺� ���ҷ���Id,�����û��˺���Ϣ
     *
     * @param user
     * @param userWeiXin
     * @return
     */
    Integer saveweixinaccountsetting(User user, UserWeiXin userWeiXin);

    /**
     * ����˻�������Ϣ
     *
     * @param user
     * @return
     */
    User getPersonMess(User user);

    /**
     * ��ȡ�ӿڵ�ַ
     *
     * @param userWeiXin
     * @return
     */
    UserWeiXin getInterfaceMess(UserWeiXin userWeiXin);

    /**
     * �����ı���Ϣ
     *
     * @param textResources
     */
    Integer createTextResource(TextResources textResources);

    /**
     * ��������ע�н���Ϣ
     *
     * @param focusLucky
     */
    void createdFoucsLucky(FoucsLucky focusLucky);

    /**
     * �޸�����
     *
     * @param user
     */
    void modifyPass(User user);

}
