package com.wechat.service;

import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����3:48
 * To change this template use File | Settings | File Templates.
 */
public interface SettingService {
    /**
     * ����΢���˺� ���ҷ���Id,�����û��˺���Ϣ
     *
     * @param user
     * @param userWeiXin
     * @return
     */
    Integer saveweixinaccountsetting(User user, UserWeiXin userWeiXin);

    /**
     * ��ø��˻�����Ϣ
     *
     * @param user
     * @return
     */
    User getPersonMess(User user);

    /**
     * ��ø��˽ӿ���Ϣ
     *
     * @param userWeiXin
     * @return
     */
    UserWeiXin getInterfaceMess(UserWeiXin userWeiXin);

    /**
     * ���������ı���Ϣ
     *
     * @param textResourcesList
     */
    void createTextResource(List<TextResources> textResourcesList);

    /**
     * ���������ı���Ϣ
     *
     * @param textResources
     * @return
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
