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
 * Time: ����5:24
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
        //�������id��ѯ�ιο�������Ϣ
        ScaratchCard scaratchCard = proxyManager.findScaratchCard(componentId);
        if (scaratchCard != null) {
            //���ݹιο�id��ѯ������Ϣ
            List<ScaratchCardPrize> scaratchCardPrizeList = proxyManager.findScaratchCardPrize(scaratchCard.getId());
            //��ѯ���û��Ѿ��齱�Ĵ���
            Integer userReserveCount = proxyManager.findScaratchCardUserCount(scaratchCard.getId(), weixinOpenId);
            //�û�ʣ��齱�������� ��趨�ĳ齱������ȥ�û��Ѿ���Ĵ���
            userReserveCount = scaratchCard.getLuckyCount().intValue() - userReserveCount.intValue();
            scaratchCardInitRes.setScaratchCard(scaratchCard);
            scaratchCardInitRes.setUserReserveCount(userReserveCount);
            scaratchCardInitRes.setPrizeList(scaratchCardPrizeList);
        }
        return scaratchCardInitRes;

    }

    public ScaratchCardLuckyRes lucky(Integer componentId, String weixinOpenId) {
        ScaratchCardLuckyRes scaratchCardLuckyRes = new ScaratchCardLuckyRes();
        //�������id��ѯ��ת�̻�����Ϣ
        ScaratchCard scaratchCard = proxyManager.findScaratchCard(componentId);
        if (scaratchCard != null) {
            //��ѯ���û��Ѿ��齱�Ĵ���
            Integer userReserveCount = proxyManager.findScaratchCardUserCount(scaratchCard.getId(), weixinOpenId);
            //�û�ʣ��齱�������� ��趨�ĳ齱������ȥ�û��Ѿ���Ĵ���
            userReserveCount = scaratchCard.getLuckyCount().intValue() - userReserveCount.intValue();

            //���ʣ��齱����С��0,ֱ�ӷ���δ�н�
            if (userReserveCount <= 0) {
                scaratchCardLuckyRes.setId(-1);
            } else {
                //���ݴ�ת��id��ѯʣ�ཱƷ������0�Ľ���
                List<ScaratchCardPrize> scaratchCardPrizeList = proxyManager.findScaratchCardPrizeDayu0(scaratchCard.getId());
                //��ȡ���н���id
                Integer prizeId = getGameWinningLevel(scaratchCardPrizeList);
                scaratchCardLuckyRes.setId(prizeId);
                if (prizeId != -1) {
                    //�������δ�н�,���½�Ʒʣ������
                    proxyManager.updateScaratchCardPrizeCount(prizeId);
                }
                //��¼�齱��־
                proxyManager.insertScaratchCardLog(weixinOpenId, scaratchCard.getId(), prizeId);
            }
        }
        return scaratchCardLuckyRes;  //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * ���ֳ齱�㷨
     *
     * @param list
     * @return
     */
    private int getGameWinningLevel(List<ScaratchCardPrize> list) {

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
