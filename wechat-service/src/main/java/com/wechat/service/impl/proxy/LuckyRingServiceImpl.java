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
 * Time: ����8:54
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
        //�������id��ѯ��ת�̻�����Ϣ
        ComponentRingLucky componentRingLucky = proxyManager.findComponentRingLucky(componentId);
        if (componentRingLucky != null) {
            //���ݴ�ת��id��ѯ������Ϣ
            List<ComponentRingLuckyPrize> componentRingLuckyPrizeList = proxyManager.findComponentRingLuckyPrize(componentRingLucky.getId());
            //��ѯ���û��Ѿ��齱�Ĵ���
            Integer userReserveCount = proxyManager.findRingLuckyUserCount(componentRingLucky.getId(), weixinOpenId);
            //�û�ʣ��齱�������� ��趨�ĳ齱������ȥ�û��Ѿ���Ĵ���
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
        //�������id��ѯ��ת�̻�����Ϣ
        ComponentRingLucky componentRingLucky = proxyManager.findComponentRingLucky(componentId);
        if (componentRingLucky != null) {
            //��ѯ���û��Ѿ��齱�Ĵ���
            Integer userReserveCount = proxyManager.findRingLuckyUserCount(componentRingLucky.getId(), weixinOpenId);
            //�û�ʣ��齱�������� ��趨�ĳ齱������ȥ�û��Ѿ���Ĵ���
            userReserveCount = componentRingLucky.getLuckyCount().intValue() - userReserveCount.intValue();

            //���ʣ��齱����С��0,ֱ�ӷ���δ�н�
            if (userReserveCount <= 0) {
                luckyRingLuckyRes.setId(-1);
            } else {
                //���ݴ�ת��id��ѯʣ�ཱƷ������0�Ľ���
                List<ComponentRingLuckyPrize> componentRingLuckyPrizeList = proxyManager.findComponentRingLuckyPrizeDayu0(componentRingLucky.getId());
                //��ȡ���н���id
                Integer prizeId = getGameWinningLevel(componentRingLuckyPrizeList);
                luckyRingLuckyRes.setId(prizeId);
                if (prizeId != -1) {
                    //�������δ�н�,���½�Ʒʣ������
                    proxyManager.updateRingLuckPrizeCount(prizeId);
                }
                //��¼�齱��־
                proxyManager.insertRingLuckyLog(weixinOpenId, componentRingLucky.getId(), prizeId);
            }
        }
        return luckyRingLuckyRes;  //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * ���ֳ齱�㷨
     *
     * @param list
     * @return
     */
    private int getGameWinningLevel(List<ComponentRingLuckyPrize> list) {

        // �н��ȼ���δ�н�
        int winningLevel = -1;

        if (list == null || list.size() <= 0) {
            return winningLevel;
        }

        // �н������
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
