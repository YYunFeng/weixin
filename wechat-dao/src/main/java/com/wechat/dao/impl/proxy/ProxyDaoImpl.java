package com.wechat.dao.impl.proxy;

import com.wechat.dao.BaseDao;
import com.wechat.dao.proxy.ProxyDao;
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
 * Time: ÏÂÎç7:16
 * To change this template use File | Settings | File Templates.
 */
public class ProxyDaoImpl extends BaseDao implements ProxyDao {

    public KeywordLink findKeywordLink(KeywordLinkParameter keywordLinkParameter) {
        return (KeywordLink) queryForObject("Proxy.findKeywordLink", keywordLinkParameter);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Component findComponent(ComponentParameter componentParameter) {
        return (Component) queryForObject("Proxy.findComponent", componentParameter);
    }

    public ComponentRingLucky findComponentRingLucky(Integer componentId) {
        return (ComponentRingLucky) queryForObject("Proxy.findComponentRingLucky", componentId);
    }

    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrize(Integer luckyringId) {
        return (List<ComponentRingLuckyPrize>) queryForList("Proxy.findComponentRingLuckyPrize", luckyringId);
    }

    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrizeDaYu0(Integer luckyringId) {
        return (List<ComponentRingLuckyPrize>) queryForList("Proxy.findComponentRingLuckyPrizeDaYu0", luckyringId);
    }

    public void updateLuckyRingPrizeCount(Integer prizeId) {
        update("Proxy.updateLuckyRingPrizeCount", prizeId);
    }

    public void insertRingLuckyLog(ComponentRingLuckyLogParameter componentRingLuckyLogParameter) {
        insert("Proxy.insertRingLuckyLog", componentRingLuckyLogParameter);
    }

    public Integer findRingLuckyUserCount(ComponentRingLuckyLogParameter componentRingLuckyLogParameter) {
        return (Integer) queryForObject("Proxy.findRingLuckyUserCount", componentRingLuckyLogParameter);
    }

    public ScaratchCard findScaratchCard(Integer componentId) {
        return (ScaratchCard) queryForObject("Proxy.findScaratchCard", componentId);
    }

    public List<ScaratchCardPrize> findScaratchCardPrize(Integer scaratchCardId) {
        return (List<ScaratchCardPrize>) queryForList("Proxy.findScaratchCardPrize", scaratchCardId);
    }

    public List<ScaratchCardPrize> findScaratchCardPrizeDaYu0(Integer scaratchCardId) {
        return (List<ScaratchCardPrize>) queryForList("Proxy.findScaratchCardPrizeDaYu0", scaratchCardId);
    }

    public void updateScaratchCardPrizeCount(Integer prizeId) {
        update("Proxy.updateScaratchCardPrizeCount", prizeId);
    }

    public void insertScaratchCardLog(ScaratchCardLogParameter scaratchCardLogParameter) {
        insert("Proxy.insertScaratchCardLog", scaratchCardLogParameter);
    }

    public Integer findScaratchCardUserCount(ScaratchCardLogParameter scaratchCardLogParameter) {
        return (Integer) queryForObject("Proxy.findScaratchCardUserCount", scaratchCardLogParameter);
    }

    public UserWeixin findUserWeixinById(Integer weixinId) {
        return (UserWeixin) queryForObject("Proxy.findUserWeixinById", weixinId);
    }

    public Map<String, TextResources> findTextResourcesByWeixinId(Integer weixinId) {
        return queryForMap("Proxy.findTextResourcesByWeixinId", weixinId, "type");
    }

    public FocusLucky findFocusLuckyByWeixinId(Integer weixinId) {
        return (FocusLucky) queryForObject("Proxy.findFocusLuckyByWeixinId", weixinId);
    }

    public void insertFocusLog(FocusLog focusLog) {
        insert("Proxy.insertFocusLog", focusLog);
    }

    public synchronized Integer findFoucsCountByWeixinIdAndTime(FocusLog focusLog) {
        return (Integer) queryForObject("Proxy.findFoucsCountByWeixinIdAndTime", focusLog);
    }

    public List<PicMessage> findPicMessageByMaterialId(Integer materialId) {
        return queryForList("Proxy.findPicMessageByMaterialId", materialId);
    }

    public PicMessage findPicMessageById(Integer picMessageId) {
        return (PicMessage) queryForObject("Proxy.findPicMessageById", picMessageId);
    }

    public void insertComponentVisitLog(ComponentVisitLog componentVisitLog) {
        insert("Proxy.insertComponentVisitLog", componentVisitLog);
    }

    public void insertUpstreamMessageLog(UpstreamMessageLog upstreamMessageLog) {
        insert("Proxy.insertUpstreamMessageLog", upstreamMessageLog);
    }

    public void insertDownstreamMessageLog(DownstreamMessageLog downstreamMessageLog) {
        insert("Proxy.insertDownstreamMessageLog", downstreamMessageLog);
    }

    public List<LuckyLog> findLuckyRingScaratchCardLog(String wxOpenId) {
        return queryForList("Proxy.findLuckyRingScaratchCardLog", wxOpenId);
    }

    public List<LuckyLog> findSurveyLuckyLog(String wxOpenId) {
        return queryForList("Proxy.findSurveyLuckyLog", wxOpenId);
    }

}
