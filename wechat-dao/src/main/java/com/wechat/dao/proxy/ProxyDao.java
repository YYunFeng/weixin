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
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public interface ProxyDao {

    /**
     * 根据weixinAccountId查询关键字关联信息
     *
     * @param keywordLinkParameter
     * @return
     */

    public KeywordLink findKeywordLink(KeywordLinkParameter keywordLinkParameter);


    /**
     * 根据组件id查询组件信息
     *
     * @param componentParameter
     * @return
     */
    public Component findComponent(ComponentParameter componentParameter);

    /**
     * 根据组件id查询大转盘基本信息
     *
     * @param componentId
     * @return
     */
    public ComponentRingLucky findComponentRingLucky(Integer componentId);

    /**
     * 根据组件id查询大转盘奖项信息
     *
     * @param luckyringId
     * @return
     */
    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrize(Integer luckyringId);

    /**
     * 根据组件id查询大转盘奖项信息大于0
     *
     * @param luckyringId
     * @return
     */
    public List<ComponentRingLuckyPrize> findComponentRingLuckyPrizeDaYu0(Integer luckyringId);

    /**
     * 根据奖项id更新奖项剩余个数
     *
     * @param prizeId
     */
    public void updateLuckyRingPrizeCount(Integer prizeId);

    /**
     * 记录大转盘抽奖日志
     *
     * @param componentRingLuckyLogParameter
     */
    public void insertRingLuckyLog(ComponentRingLuckyLogParameter componentRingLuckyLogParameter);

    /**
     * 查询用户参加了几次大转盘抽奖
     *
     * @param componentRingLuckyLogParameter
     * @return
     */
    public Integer findRingLuckyUserCount(ComponentRingLuckyLogParameter componentRingLuckyLogParameter);


    /**
     * 根据组件id查询刮刮卡基本信息
     *
     * @param componentId
     * @return
     */
    public ScaratchCard findScaratchCard(Integer componentId);

    /**
     * 根据组件id查询刮刮卡奖项信息
     *
     * @param scaratchCardId
     * @return
     */
    public List<ScaratchCardPrize> findScaratchCardPrize(Integer scaratchCardId);

    /**
     * 根据组件id查询刮刮卡奖项信息大于0
     *
     * @param scaratchCardId
     * @return
     */
    public List<ScaratchCardPrize> findScaratchCardPrizeDaYu0(Integer scaratchCardId);

    /**
     * 根据奖项id更新刮刮卡奖项剩余个数
     *
     * @param prizeId
     */
    public void updateScaratchCardPrizeCount(Integer prizeId);

    /**
     * 记录刮刮卡抽奖日志
     *
     * @param scaratchCardLogParameter
     */
    public void insertScaratchCardLog(ScaratchCardLogParameter scaratchCardLogParameter);

    /**
     * 查询用户参加了几次刮刮卡抽奖
     *
     * @param scaratchCardLogParameter
     * @return
     */
    public Integer findScaratchCardUserCount(ScaratchCardLogParameter scaratchCardLogParameter);


    /**
     * 根据id获取微信账号信息
     *
     * @param weixinId
     * @return
     */
    public UserWeixin findUserWeixinById(Integer weixinId);

    /**
     * 根据微信账号id获取该用户所有文本资源
     *
     * @param weixinId
     * @return
     */
    public Map<String, TextResources> findTextResourcesByWeixinId(Integer weixinId);

    /**
     * 根据微信账号id获取该用户关注有奖信息
     *
     * @param weixinId
     * @return
     */
    public FocusLucky findFocusLuckyByWeixinId(Integer weixinId);

    /**
     * 插入关注日志
     *
     * @param focusLog
     */
    public void insertFocusLog(FocusLog focusLog);


    /**
     * 根据微信账号id和开启关注有奖开关的时间来获取关注数
     *
     * @param focusLog
     * @return
     */
    public Integer findFoucsCountByWeixinIdAndTime(FocusLog focusLog);


    /**
     * 根据素材id查询图文信息
     *
     * @param materialId
     * @return
     */
    public List<PicMessage> findPicMessageByMaterialId(Integer materialId);

    /**
     * 根据图文id查询图文信息
     *
     * @param picMessageId
     * @return
     */
    public PicMessage findPicMessageById(Integer picMessageId);


    /**
     * 记录组件访问日志
     *
     * @param componentVisitLog
     */
    public void insertComponentVisitLog(ComponentVisitLog componentVisitLog);

    /**
     * 记录上行信息日志
     *
     * @param upstreamMessageLog
     */
    public void insertUpstreamMessageLog(UpstreamMessageLog upstreamMessageLog);

    /**
     * 记录下行信息日志
     *
     * @param downstreamMessageLog
     */
    public void insertDownstreamMessageLog(DownstreamMessageLog downstreamMessageLog);

    /**
     * 查询大转盘和刮刮卡的中奖纪录
     *
     * @param wxOpenId
     * @return
     */
    public List<LuckyLog> findLuckyRingScaratchCardLog(String wxOpenId);

    /**
     * 查询有奖问答中奖纪录
     *
     * @param wxOpenId
     * @return
     */
    public List<LuckyLog> findSurveyLuckyLog(String wxOpenId);
}
