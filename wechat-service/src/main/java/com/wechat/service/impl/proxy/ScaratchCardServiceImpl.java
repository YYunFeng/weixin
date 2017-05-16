package com.wechat.service.impl.proxy;



import com.wechat.domain.bean.proxy.*;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.domain.json.proxy.ScaratchCardInitRes;
import com.wechat.domain.json.proxy.ScaratchCardLuckyRes;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.ScaratchCardService;
import com.wechat.domain.utils.PathsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchCardServiceImpl implements ScaratchCardService {
    private ProxyManager proxyManager;

    private String scaratchCardUrl;
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
        item.setUrl(scaratchCardUrl + "?componentId=" + component.getId() + "&weixinOpenId=" + upstreamMessage.getFromUserName());
//        logger.info("url:" + scaratchCardUrl + "?componentId=" + component.getId() + "&weixinOpenId=" + upstreamMessage.getFromUserName());
        itemList.add(item);

        articles.setItem(itemList);

        downstreamMessage.setArticles(articles);
        downstreamMessage.setArticleCount(itemList.size());


        return downstreamMessage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ScaratchCardInitRes getPrizeList(Integer componentId, String weixinOpenId) {
        ScaratchCardInitRes scaratchCardInitRes = new ScaratchCardInitRes();
        //根据组件id查询刮刮卡基本信息
        ScaratchCard scaratchCard = proxyManager.findScaratchCard(componentId);
        if (scaratchCard != null) {
            //根据刮刮卡id查询奖项信息
            List<ScaratchCardPrize> scaratchCardPrizeList = proxyManager.findScaratchCardPrize(scaratchCard.getId());
            //查询该用户已经抽奖的次数
            Integer userReserveCount = proxyManager.findScaratchCardUserCount(scaratchCard.getId(), weixinOpenId);
            //用户剩余抽奖次数等于 活动设定的抽奖次数减去用户已经抽的次数
            userReserveCount = scaratchCard.getLuckyCount().intValue() - userReserveCount.intValue();
            scaratchCardInitRes.setScaratchCard(scaratchCard);
            scaratchCardInitRes.setUserReserveCount(userReserveCount);
            scaratchCardInitRes.setPrizeList(scaratchCardPrizeList);
        }
        return scaratchCardInitRes;

    }

    public ScaratchCardLuckyRes lucky(Integer componentId, String weixinOpenId) {
        ScaratchCardLuckyRes scaratchCardLuckyRes = new ScaratchCardLuckyRes();
        //根据组件id查询大转盘基本信息
        ScaratchCard scaratchCard = proxyManager.findScaratchCard(componentId);
        if (scaratchCard != null) {
            //查询该用户已经抽奖的次数
            Integer userReserveCount = proxyManager.findScaratchCardUserCount(scaratchCard.getId(), weixinOpenId);
            //用户剩余抽奖次数等于 活动设定的抽奖次数减去用户已经抽的次数
            userReserveCount = scaratchCard.getLuckyCount().intValue() - userReserveCount.intValue();

            //如果剩余抽奖次数小于0,直接返回未中奖
            if (userReserveCount <= 0) {
                scaratchCardLuckyRes.setId(-1);
            } else {
                //根据大转盘id查询剩余奖品数大于0的奖项
                List<ScaratchCardPrize> scaratchCardPrizeList = proxyManager.findScaratchCardPrizeDayu0(scaratchCard.getId());
                //获取所中奖项id
                Integer prizeId = getGameWinningLevel(scaratchCardPrizeList);
                scaratchCardLuckyRes.setId(prizeId);
                if (prizeId != -1) {
                    //如果不是未中奖,更新奖品剩余数量
                    proxyManager.updateScaratchCardPrizeCount(prizeId);
                }
                //记录抽奖日志
                proxyManager.insertScaratchCardLog(weixinOpenId, scaratchCard.getId(), prizeId);
            }
        }
        return scaratchCardLuckyRes;  //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * 积分抽奖算法
     *
     * @param list
     * @return
     */
    private int getGameWinningLevel(List<ScaratchCardPrize> list) {

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


    public String getScaratchCardUrl() {
        return scaratchCardUrl;
    }

    public void setScaratchCardUrl(String scaratchCardUrl) {
        this.scaratchCardUrl = scaratchCardUrl;
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
