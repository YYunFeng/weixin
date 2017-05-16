package com.wechat.manager.impl.proxy;



import com.wechat.dao.proxy.ProxyDao;
import com.wechat.domain.bean.proxy.*;
import com.wechat.domain.parameter.proxy.ComponentParameter;
import com.wechat.domain.parameter.proxy.ComponentRingLuckyLogParameter;
import com.wechat.domain.parameter.proxy.KeywordLinkParameter;
import com.wechat.domain.parameter.proxy.ScaratchCardLogParameter;
import com.wechat.manager.proxy.ProxyManager;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ÏÂÎç7:40
 * To change this template use File | Settings | File Templates.
 */
public class ProxyManagerImpl implements ProxyManager {

    private ProxyDao proxyDao;

    public KeywordLink findKeywordLink(Integer weixinAccountId, String keyword) {
        KeywordLinkParameter keywordLinkParameter = new KeywordLinkParameter();
        keywordLinkParameter.setWeixinId(weixinAccountId);
        keywordLinkParameter.setKeyword(keyword.trim().toLowerCase());
        return proxyDao.findKeywordLink(keywordLinkParameter);
    }

    public Component findComponent(Integer componentId) {
        ComponentParameter componentParameter = new ComponentParameter();
        componentParameter.setId(componentId);
        return proxyDao.findComponent(componentParameter);
    }

    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrize(Integer luckyringId) {
        return proxyDao.findComponentRingLuckyPrize(luckyringId);
    }

    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrizeDayu0(Integer luckyringId) {
        return proxyDao.findComponentRingLuckyPrizeDaYu0(luckyringId);
    }

    public ComponentRingLucky findComponentRingLucky(Integer componentId) {
        return proxyDao.findComponentRingLucky(componentId);
    }

    public void updateRingLuckPrizeCount(Integer prizeId) {
        proxyDao.updateLuckyRingPrizeCount(prizeId);
    }

    public void insertRingLuckyLog(String weixinOpenId, Integer luckyringId, Integer prizeId) {
        ComponentRingLuckyLogParameter componentRingLuckyLogParameter = new ComponentRingLuckyLogParameter();
        componentRingLuckyLogParameter.setWeixinOpenId(weixinOpenId);
        componentRingLuckyLogParameter.setLuckyringId(luckyringId);
        componentRingLuckyLogParameter.setPrizeId(prizeId);
        proxyDao.insertRingLuckyLog(componentRingLuckyLogParameter);
    }

    public Integer findRingLuckyUserCount(Integer luckyringId, String weixinOpenId) {
        ComponentRingLuckyLogParameter componentRingLuckyLogParameter = new ComponentRingLuckyLogParameter();
        componentRingLuckyLogParameter.setWeixinOpenId(weixinOpenId);
        componentRingLuckyLogParameter.setLuckyringId(luckyringId);

        return proxyDao.findRingLuckyUserCount(componentRingLuckyLogParameter);
    }

    public List<ScaratchCardPrize> findScaratchCardPrize(Integer scaratchCardId) {
        return proxyDao.findScaratchCardPrize(scaratchCardId);
    }

    public List<ScaratchCardPrize> findScaratchCardPrizeDayu0(Integer scaratchCardId) {
        return proxyDao.findScaratchCardPrizeDaYu0(scaratchCardId);
    }

    public ScaratchCard findScaratchCard(Integer componentId) {
        return proxyDao.findScaratchCard(componentId);
    }

    public void updateScaratchCardPrizeCount(Integer prizeId) {
        proxyDao.updateScaratchCardPrizeCount(prizeId);
    }

    public void insertScaratchCardLog(String weixinOpenId, Integer scaratchCardId, Integer prizeId) {
        ScaratchCardLogParameter scaratchCardLogParameter = new ScaratchCardLogParameter();
        scaratchCardLogParameter.setWeixinOpenId(weixinOpenId);
        scaratchCardLogParameter.setScaratchCardId(scaratchCardId);
        scaratchCardLogParameter.setPrizeId(prizeId);
        proxyDao.insertScaratchCardLog(scaratchCardLogParameter);
    }

    public Integer findScaratchCardUserCount(Integer scaratchCardId, String weixinOpenId) {
        ScaratchCardLogParameter scaratchCardLogParameter = new ScaratchCardLogParameter();
        scaratchCardLogParameter.setWeixinOpenId(weixinOpenId);
        scaratchCardLogParameter.setScaratchCardId(scaratchCardId);
        return proxyDao.findScaratchCardUserCount(scaratchCardLogParameter);
    }

    public UserWeixin findUserWeixinById(Integer weixinId) {
        return proxyDao.findUserWeixinById(weixinId);
    }

    public Map<String, TextResources> findTextResourcesByWeixinId(Integer weixinId) {
        return proxyDao.findTextResourcesByWeixinId(weixinId);
    }

    public FocusLucky findFocusLuckyByWeixinId(Integer weixinId) {
        return proxyDao.findFocusLuckyByWeixinId(weixinId);
    }

    public void insertFocusLog(String wxOpenId, Integer weixinId, String focusMessage, Boolean lucky) {
        FocusLog focusLog = new FocusLog();
        focusLog.setWxOpenId(wxOpenId);
        focusLog.setWeixinId(weixinId);
        focusLog.setFocusMessage(focusMessage);
        focusLog.setLucky(lucky);
        proxyDao.insertFocusLog(focusLog);
    }

    public Integer findFoucsCountByWeixinIdAndTime(Integer weixinId, Date foucsLuckyOpenTime) {
        FocusLog focusLog = new FocusLog();
        focusLog.setWeixinId(weixinId);
        focusLog.setCreated(foucsLuckyOpenTime);
        return proxyDao.findFoucsCountByWeixinIdAndTime(focusLog);
    }

    public List<PicMessage> findPicMessageByMaterialId(Integer materialId) {
        return proxyDao.findPicMessageByMaterialId(materialId);
    }

    public PicMessage findPicMessageById(Integer picMessageId) {
        return proxyDao.findPicMessageById(picMessageId);
    }

    public void insertComponentVisitLog(Integer componentId, String weixinOpenid) {
        ComponentVisitLog componentVisitLog = new ComponentVisitLog();
        componentVisitLog.setComponentId(componentId);
        componentVisitLog.setWxOpenid(weixinOpenid);
        proxyDao.insertComponentVisitLog(componentVisitLog);
    }

    public void insertUpstreamMessageLog(Integer weixinId, String wxOpenId, String msgType, String msgId, String text, String picUrl, String locationX, String locationY, Integer scale, String label) {
        UpstreamMessageLog upstreamMessageLog = new UpstreamMessageLog();
        upstreamMessageLog.setWeixinId(weixinId);
        upstreamMessageLog.setWxOpenId(wxOpenId);
        upstreamMessageLog.setMsgType(msgType);
        upstreamMessageLog.setMsgId(msgId);
        upstreamMessageLog.setText(text);
        upstreamMessageLog.setPicUrl(picUrl);
        upstreamMessageLog.setLocationX(locationX);
        upstreamMessageLog.setLocationY(locationY);
        upstreamMessageLog.setScale(scale);
        upstreamMessageLog.setLabel(label);
        proxyDao.insertUpstreamMessageLog(upstreamMessageLog);
    }

    public void insertDownstreamMessageLog(Integer weixinId, String wxOpenId, String msgType, String xml, boolean is_event) {
        DownstreamMessageLog downstreamMessageLog = new DownstreamMessageLog();
        downstreamMessageLog.setWeixinId(weixinId);
        downstreamMessageLog.setWxOpenId(wxOpenId);
        downstreamMessageLog.setMsgType(msgType);
        downstreamMessageLog.setXml(xml);
        downstreamMessageLog.setIsFocus(is_event);
        proxyDao.insertDownstreamMessageLog(downstreamMessageLog);
    }

    public List<LuckyLog> findLuckyRingScaratchCardLog(String wxOpenId) {
        return proxyDao.findLuckyRingScaratchCardLog(wxOpenId);
    }

    public List<LuckyLog> findSurveyLuckyLog(String wxOpenId) {
        return proxyDao.findSurveyLuckyLog(wxOpenId);
    }


    public void setProxyDao(ProxyDao proxyDao) {
        this.proxyDao = proxyDao;
    }
}
