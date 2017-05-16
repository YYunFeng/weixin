package com.wechat.service.impl.proxy;



import com.wechat.domain.bean.proxy.*;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.domain.json.proxy.LuckyRingInitRes;
import com.wechat.domain.json.proxy.LuckyRingLuckyRes;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.LuckyRingService;
import com.wechat.domain.utils.PathsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: 下午8:54
 * To change this template use File | Settings | File Templates.
 */
public class LuckyRingServiceImpl implements LuckyRingService {

    private ProxyManager proxyManager;

    private String luckyRingUrl;
    private PathsUtil pathsUtil;
//    private Logger logger = Logger.getLogger(this.getClass());

    public DownstreamMessage getDownstreamMessage(Component component, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        downstreamMessage.setMsgType("news");
        downstreamMessage.setArticleCount(1);

        Articles articles = new Articles();

        List<Item> itemList = new ArrayList<Item>();
        Item item = new Item();
        item.setTitle(component.getTitle());
        item.setDescription(component.getIntro());
        item.setPicUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + component.getPic());
        item.setUrl(luckyRingUrl + "?componentId=" + component.getId() + "&weixinOpenId=" + upstreamMessage.getFromUserName());
//        logger.info("url:" + luckyRingUrl + "?componentId=" + component.getId() + "&weixinOpenId=" + upstreamMessage.getFromUserName());
        itemList.add(item);

        articles.setItem(itemList);

        downstreamMessage.setArticles(articles);
        downstreamMessage.setArticleCount(itemList.size());


        return downstreamMessage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public LuckyRingInitRes getPrizeList(Integer componentId, String weixinOpenId) {
        LuckyRingInitRes luckyRingInitRes = new LuckyRingInitRes();
        //根据组件id查询大转盘基本信息
        ComponentRingLucky componentRingLucky = proxyManager.findComponentRingLucky(componentId);
        if (componentRingLucky != null) {
            //根据大转盘id查询奖项信息
            List<ComponentRingLuckyPrize> componentRingLuckyPrizeList = proxyManager.findComponentRingLuckyPrize(componentRingLucky.getId());
            //查询该用户已经抽奖的次数
            Integer userReserveCount = proxyManager.findRingLuckyUserCount(componentRingLucky.getId(), weixinOpenId);
            //用户剩余抽奖次数等于 活动设定的抽奖次数减去用户已经抽的次数
            userReserveCount = componentRingLucky.getLuckyCount().intValue() - userReserveCount.intValue();
            luckyRingInitRes.setComponentRingLucky(componentRingLucky);
            luckyRingInitRes.setUserReserveCount(userReserveCount);
            luckyRingInitRes.setPrizeList(componentRingLuckyPrizeList);
            proxyManager.insertComponentVisitLog(componentId, weixinOpenId);
        }
        return luckyRingInitRes;

    }

    public LuckyRingLuckyRes lucky(Integer componentId, String weixinOpenId) {
        LuckyRingLuckyRes luckyRingLuckyRes = new LuckyRingLuckyRes();
        //根据组件id查询大转盘基本信息
        ComponentRingLucky componentRingLucky = proxyManager.findComponentRingLucky(componentId);
        if (componentRingLucky != null) {
            //查询该用户已经抽奖的次数
            Integer userReserveCount = proxyManager.findRingLuckyUserCount(componentRingLucky.getId(), weixinOpenId);
            //用户剩余抽奖次数等于 活动设定的抽奖次数减去用户已经抽的次数
            userReserveCount = componentRingLucky.getLuckyCount().intValue() - userReserveCount.intValue();

            //如果剩余抽奖次数小于0,直接返回未中奖
            if (userReserveCount <= 0) {
                luckyRingLuckyRes.setId(-1);
            } else {
                //根据大转盘id查询剩余奖品数大于0的奖项
                List<ComponentRingLuckyPrize> componentRingLuckyPrizeList = proxyManager.findComponentRingLuckyPrizeDayu0(componentRingLucky.getId());
                //获取所中奖项id
                Integer prizeId = getGameWinningLevel(componentRingLuckyPrizeList);
                luckyRingLuckyRes.setId(prizeId);
                if (prizeId != -1) {
                    //如果不是未中奖,更新奖品剩余数量
                    proxyManager.updateRingLuckPrizeCount(prizeId);
                }
                //记录抽奖日志
                proxyManager.insertRingLuckyLog(weixinOpenId, componentRingLucky.getId(), prizeId);
            }
        }
        return luckyRingLuckyRes;  //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * 积分抽奖算法
     *
     * @param list
     * @return
     */
    private int getGameWinningLevel(List<ComponentRingLuckyPrize> list) {

        // 中奖等级：未中奖
        int winningLevel = -1;

        if (list == null || list.size() <= 0) {
            return winningLevel;
        }

        // 中奖随机号
        int randomWinningNo = 0;
        int args[] = new int[list.size() * 2];
        int temp = (int) Math.round(Math.random() * 1000000000) % 1000000;
        int j = 0;

        for (int i = 0; i < list.size(); i++) {
            double tmpWinningPro = list.get(i).getProbability();
            if (j == 0) {
                args[j] = randomWinningNo;
            } else {
                args[j] = args[j - 1] + 1;
            }
            args[j + 1] = args[j] + (int) Math.round(tmpWinningPro * 10000) - 1;
            if (temp >= args[j] && temp <= args[j + 1]) {
//                winningLevel = i + 1;
                winningLevel = list.get(i).getId();
                return winningLevel;
            }
            j += 2;
        }
//        return winningLevel;
        return -1;
    }


    public String getLuckyRingUrl() {
        return luckyRingUrl;
    }

    public void setLuckyRingUrl(String luckyRingUrl) {
        this.luckyRingUrl = luckyRingUrl;
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
