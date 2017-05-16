package com.wechat.dao.proxy;


import com.wechat.domain.bean.proxy.*;
import com.wechat.domain.parameter.proxy.ComponentParameter;
import com.wechat.domain.parameter.proxy.ComponentRingLuckyLogParameter;
import com.wechat.domain.parameter.proxy.KeywordLinkParameter;
import com.wechat.domain.parameter.proxy.ScaratchCardLogParameter;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ����7:04
 * To change this template use File | Settings | File Templates.
 */
public interface ProxyDao {

    /**
     * ����weixinAccountId��ѯ�ؼ��ֹ�����Ϣ
     *
     * @param keywordLinkParameter
     * @return
     */

    public KeywordLink findKeywordLink(KeywordLinkParameter keywordLinkParameter);


    /**
     * �������id��ѯ�����Ϣ
     *
     * @param componentParameter
     * @return
     */
    public Component findComponent(ComponentParameter componentParameter);

    /**
     * �������id��ѯ��ת�̻�����Ϣ
     *
     * @param componentId
     * @return
     */
    public ComponentRingLucky findComponentRingLucky(Integer componentId);

    /**
     * �������id��ѯ��ת�̽�����Ϣ
     *
     * @param luckyringId
     * @return
     */
    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrize(Integer luckyringId);

    /**
     * �������id��ѯ��ת�̽�����Ϣ����0
     *
     * @param luckyringId
     * @return
     */
    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrizeDaYu0(Integer luckyringId);

    /**
     * ���ݽ���id���½���ʣ�����
     *
     * @param prizeId
     */
    public void updateLuckyRingPrizeCount(Integer prizeId);

    /**
     * ��¼��ת�̳齱��־
     *
     * @param componentRingLuckyLogParameter
     */
    public void insertRingLuckyLog(ComponentRingLuckyLogParameter componentRingLuckyLogParameter);

    /**
     * ��ѯ�û��μ��˼��δ�ת�̳齱
     *
     * @param componentRingLuckyLogParameter
     * @return
     */
    public Integer findRingLuckyUserCount(ComponentRingLuckyLogParameter componentRingLuckyLogParameter);


    /**
     * �������id��ѯ�ιο�������Ϣ
     *
     * @param componentId
     * @return
     */
    public ScaratchCard findScaratchCard(Integer componentId);

    /**
     * �������id��ѯ�ιο�������Ϣ
     *
     * @param scaratchCardId
     * @return
     */
    public List<ScaratchCardPrize> findScaratchCardPrize(Integer scaratchCardId);

    /**
     * �������id��ѯ�ιο�������Ϣ����0
     *
     * @param scaratchCardId
     * @return
     */
    public List<ScaratchCardPrize> findScaratchCardPrizeDaYu0(Integer scaratchCardId);

    /**
     * ���ݽ���id���¹ιο�����ʣ�����
     *
     * @param prizeId
     */
    public void updateScaratchCardPrizeCount(Integer prizeId);

    /**
     * ��¼�ιο��齱��־
     *
     * @param scaratchCardLogParameter
     */
    public void insertScaratchCardLog(ScaratchCardLogParameter scaratchCardLogParameter);

    /**
     * ��ѯ�û��μ��˼��ιιο��齱
     *
     * @param scaratchCardLogParameter
     * @return
     */
    public Integer findScaratchCardUserCount(ScaratchCardLogParameter scaratchCardLogParameter);


    /**
     * ����id��ȡ΢���˺���Ϣ
     *
     * @param weixinId
     * @return
     */
    public UserWeixin findUserWeixinById(Integer weixinId);

    /**
     * ����΢���˺�id��ȡ���û������ı���Դ
     *
     * @param weixinId
     * @return
     */
    public Map<String, TextResources> findTextResourcesByWeixinId(Integer weixinId);

    /**
     * ����΢���˺�id��ȡ���û���ע�н���Ϣ
     *
     * @param weixinId
     * @return
     */
    public FocusLucky findFocusLuckyByWeixinId(Integer weixinId);

    /**
     * �����ע��־
     *
     * @param focusLog
     */
    public void insertFocusLog(FocusLog focusLog);


    /**
     * ����΢���˺�id�Ϳ�����ע�н����ص�ʱ������ȡ��ע��
     *
     * @param focusLog
     * @return
     */
    public Integer findFoucsCountByWeixinIdAndTime(FocusLog focusLog);


    /**
     * �����ز�id��ѯͼ����Ϣ
     *
     * @param materialId
     * @return
     */
    public List<PicMessage> findPicMessageByMaterialId(Integer materialId);

    /**
     * ����ͼ��id��ѯͼ����Ϣ
     *
     * @param picMessageId
     * @return
     */
    public PicMessage findPicMessageById(Integer picMessageId);


    /**
     * ��¼���������־
     *
     * @param componentVisitLog
     */
    public void insertComponentVisitLog(ComponentVisitLog componentVisitLog);

    /**
     * ��¼������Ϣ��־
     *
     * @param upstreamMessageLog
     */
    public void insertUpstreamMessageLog(UpstreamMessageLog upstreamMessageLog);

    /**
     * ��¼������Ϣ��־
     *
     * @param downstreamMessageLog
     */
    public void insertDownstreamMessageLog(DownstreamMessageLog downstreamMessageLog);

    /**
     * ��ѯ��ת�̺͹ιο����н���¼
     *
     * @param wxOpenId
     * @return
     */
    public List<LuckyLog> findLuckyRingScaratchCardLog(String wxOpenId);

    /**
     * ��ѯ�н��ʴ��н���¼
     *
     * @param wxOpenId
     * @return
     */
    public List<LuckyLog> findSurveyLuckyLog(String wxOpenId);
}
