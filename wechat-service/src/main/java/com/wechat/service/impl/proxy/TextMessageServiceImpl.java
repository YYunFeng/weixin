package com.wechat.service.impl.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.KeywordLink;
import com.wechat.domain.bean.proxy.TextResources;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.domain.constant.proxy.KeywordLinkConstant;
import com.wechat.domain.constant.proxy.TextResourcesConstant;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.LuckyLogService;
import com.wechat.service.proxy.TextMessageService;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ����6:53
 * To change this template use File | Settings | File Templates.
 */
public class TextMessageServiceImpl implements TextMessageService {

    private ProxyManager proxyManager;
    private ComponentRouteServiceImpl componentRouteService;
    private PicMessageRouteServiceImpl picMessageRouteService;
    private LuckyLogService luckyLogService;

    private Logger logger = Logger.getLogger(this.getClass());

    public DownstreamMessage getDownstreamMessage(Integer weixinAccountId, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            //��¼������Ϣ��־
            proxyManager.insertUpstreamMessageLog(weixinAccountId, upstreamMessage.getFromUserName(), upstreamMessage.getMsgType(), upstreamMessage.getMsgId(), upstreamMessage.getContent(), null, null, null, null, null);

            //�н���ѯ
            if (upstreamMessage.getContent().trim().equals("�н���ѯ")) {
                downstreamMessage = luckyLogService.getDownstreamMessage(upstreamMessage);
                return downstreamMessage;
            }
            KeywordLink keywordLink = proxyManager.findKeywordLink(weixinAccountId, upstreamMessage.getContent());
            if (keywordLink != null) {
                //�������Ǵ��ı�
                if (keywordLink.getLinkType() == KeywordLinkConstant.TEXT) {
                    downstreamMessage.setMsgType("text");
                    downstreamMessage.setContent(keywordLink.getMessage());
                    downstreamMessage.setFuncFlag(0);
                }
                //�����������
                if (keywordLink.getLinkType() == KeywordLinkConstant.COMPONENT) {
                    downstreamMessage = componentRouteService.componentRoute(keywordLink.getComponentId(), upstreamMessage);
                }
                //���������ز�
                if (keywordLink.getLinkType() == KeywordLinkConstant.MATERIAL) {
                    downstreamMessage = picMessageRouteService.getDownstreamMessage(keywordLink.getMaterialId(), upstreamMessage);
                }
            }

            //��ƥ��,������ƥ����Ϣ
            else {
                TextResources mismatchingMessage = proxyManager.findTextResourcesByWeixinId(weixinAccountId).get(TextResourcesConstant.MISMATCHING);
                if (mismatchingMessage != null) {
                    downstreamMessage.setMsgType("text");
                    downstreamMessage.setContent(mismatchingMessage.getMessage());
                    downstreamMessage.setFuncFlag(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return downstreamMessage;
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }

    public void setComponentRouteService(ComponentRouteServiceImpl componentRouteService) {
        this.componentRouteService = componentRouteService;
    }

    public void setPicMessageRouteService(PicMessageRouteServiceImpl picMessageRouteService) {
        this.picMessageRouteService = picMessageRouteService;
    }

    public void setLuckyLogService(LuckyLogService luckyLogService) {
        this.luckyLogService = luckyLogService;
    }
}
