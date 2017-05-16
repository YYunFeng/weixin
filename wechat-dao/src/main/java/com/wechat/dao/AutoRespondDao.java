package com.wechat.dao;

import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.AutoRespondRes;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����8:16
 * To change this template use File | Settings | File Templates.
 */
public interface AutoRespondDao {
    /**
     * �ؼ����б�
     * ���˵�
     *
     * @param userWeiXin
     * @return
     */
    List<KeyWordLink> getAutoRespond(UserWeiXin userWeiXin);

    /**
     * �����ؼ���
     *
     * @param keyWordLink
     */
    Integer createAutoRespond(KeyWordLink keyWordLink);

    /**
     * ���¹ؼ���
     *
     * @param keyWordLink
     */
    void updateAutoRespond(KeyWordLink keyWordLink);

    /**
     * ��ID��ùؼ�������
     *
     * @param keyWordLink
     * @return
     */

    AutoRespondRes getAutoRespondById(KeyWordLink keyWordLink);

    /**
     * ɾ���ؼ���
     *
     * @param keyWordLink
     */
    void deleteRule(KeyWordLink keyWordLink);

    /**
     * ��ȡ�ı���Դ��Ϣ
     *
     * @param textResources
     * @return
     */
    TextResources gerTextResource(TextResources textResources);

    /**
     * ��ȡ��ע�н���Ϣ
     *
     * @param weixinId
     * @return
     */
    FoucsLucky getFoucsLucky(Integer weixinId);

    /**
     * ��ȡ΢�Ź����˺�
     *
     * @param user
     * @return
     */
    UserWeiXin getUserWeiXin(User user);

    /**
     * �����ı���Դ��Ϣ
     *
     * @param textResources
     */
    void updateTextResources(TextResources textResources);

    /**
     * ���±���ע�н���Ϣ
     *
     * @param focusLucky
     */
    void updateFoucsLucky(FoucsLucky focusLucky);

    /**
     * �����û��н�״̬
     *
     * @param userWeiXin
     */
    void updateUserWeiXin(UserWeiXin userWeiXin);

    /**
     * ��֤�ؼ����Ƿ����
     *
     * @param keyWordLink
     * @return
     */
    KeyWordLink autoRule(KeyWordLink keyWordLink);

    /**
     * ���ؼ��ֵ����ɰ���
     *
     * @param weixinId
     * @return
     */
    List<KeyWordLink> exportHelp(Integer weixinId);
}
