package com.wechat.manager.proxy;


import com.wechat.domain.bean.proxy.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ÏÂÎç6:59
 * To change this template use File | Settings | File Templates.
 */
public interface ProxyManager {

    public KeywordLink findKeywordLink(Integer weixinAccountId, String keyword);

    public Component findComponent(Integer componentId);

    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrize(Integer luckyringId);

    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrizeDayu0(Integer luckyringId);

    public ComponentRingLucky findComponentRingLucky(Integer componentId);

    public void updateRingLuckPrizeCount(Integer prizeId);

    public void insertRingLuckyLog(String weixinOpenId, Integer luckyringId, Integer prizeId);

    public Integer findRingLuckyUserCount(Integer luckyringId, String weixinOpenId);

    public List<ScaratchCardPrize> findScaratchCardPrize(Integer scaratchCardId);

    public List<ScaratchCardPrize> findScaratchCardPrizeDayu0(Integer scaratchCardId);

    public ScaratchCard findScaratchCard(Integer componentId);

    public void updateScaratchCardPrizeCount(Integer prizeId);

    public void insertScaratchCardLog(String weixinOpenId, Integer scaratchCardId, Integer prizeId);

    public Integer findScaratchCardUserCount(Integer scaratchCardId, String weixinOpenId);

    public UserWeixin findUserWeixinById(Integer weixinId);

    public Map<String, TextResources> findTextResourcesByWeixinId(Integer weixinId);

    public FocusLucky findFocusLuckyByWeixinId(Integer weixinId);

    public void insertFocusLog(String wxOpenId, Integer weixinId, String focusMessage, Boolean lucky);

    public Integer findFoucsCountByWeixinIdAndTime(Integer weixinId, Date foucsLuckyOpenTime);

    public List<PicMessage> findPicMessageByMaterialId(Integer materialId);

    public PicMessage findPicMessageById(Integer picMessageId);

    public void insertComponentVisitLog(Integer componentId, String weixinOpenid);

    public void insertUpstreamMessageLog(Integer weixinId, String wxOpenId, String msgType, String msgId, String text, String picUrl, String locationX, String locationY, Integer scale, String label);

    public void insertDownstreamMessageLog(Integer weixinId, String wxOpenId, String msgType, String xml, boolean is_event);

    public List<LuckyLog> findLuckyRingScaratchCardLog(String wxOpenId);

    public List<LuckyLog> findSurveyLuckyLog(String wxOpenId);

}
