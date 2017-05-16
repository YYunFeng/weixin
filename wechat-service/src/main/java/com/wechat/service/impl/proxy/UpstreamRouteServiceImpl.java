package com.wechat.service.impl.proxy;


import com.thoughtworks.xstream.XStream;
import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.EventMessageService;
import com.wechat.service.proxy.TextMessageService;
import com.wechat.service.proxy.UpstreamRouteService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ����5:27
 * To change this template use File | Settings | File Templates.
 */
public class UpstreamRouteServiceImpl implements UpstreamRouteService {

    private Logger logger = Logger.getLogger(this.getClass());

    private TextMessageService textMessageService;
    private EventMessageService eventMessageService;
    private ProxyManager proxyManager;

    public String userUpstream(Integer weixinAccountId, String upstreamXml) {
        XStream xStream = null;
        String resultXml = "";
        UpstreamMessage upstreamMessage = null;
        DownstreamMessage downstreamMessage = null;
        //����Ƿ�Ϊһ���¼���������Ϣ
        boolean isEvent = false;
        try {
            //����xml
            xStream = new XStream();
            xStream.alias("xml", UpstreamMessage.class);
            upstreamMessage = (UpstreamMessage) xStream.fromXML(upstreamXml);
            //�ı���Ϣ����
            if (upstreamMessage.getMsgType().toLowerCase().equals("text")) {
                downstreamMessage = textMessageService.getDownstreamMessage(weixinAccountId, upstreamMessage);
            }
            //�¼�����Ϣ����
            if (upstreamMessage.getMsgType().toLowerCase().equals("event")) {
                downstreamMessage = eventMessageService.getDownstreamMessage(weixinAccountId, upstreamMessage);
                isEvent = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(downstreamMessage.getContent()) || downstreamMessage.getArticles() != null) {
            downstreamMessage.setToUserName(upstreamMessage.getFromUserName());
            downstreamMessage.setFromUserName(upstreamMessage.getToUserName());
            downstreamMessage.setCreateTime(System.currentTimeMillis() + "");
            xStream.alias("xml", DownstreamMessage.class);
            resultXml = xStream.toXML(downstreamMessage);
            resultXml = StringUtils.replaceOnce(resultXml, "<item>", "");
            resultXml = StringUtils.replaceOnce(resultXml, "</item>", "");
            resultXml = StringUtils.replace(resultXml, "<com.wechat.domain.bean.proxy.Item>", "<item>");
            resultXml = StringUtils.replace(resultXml, "</com.wechat.domain.bean.proxy.Item>", "</item>");
            logger.info("resultXml:" + resultXml);
            //��¼������Ϣ��־
            proxyManager.insertDownstreamMessageLog(weixinAccountId, downstreamMessage.getToUserName(), downstreamMessage.getMsgType(), resultXml, isEvent);
        }
        return resultXml;
    }

    /**
     * ������������
     *
     * @param upstreamXml
     * @return
     */
    public String testUpstream(String upstreamXml) {

        XStream xStream = null;
        String resultXml = "";
        UpstreamMessage upstreamMessage = null;
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        //����Ƿ�Ϊһ���¼���������Ϣ
        boolean isEvent = false;
        try {
            //����xml
            xStream = new XStream();
            xStream.alias("xml", UpstreamMessage.class);
            upstreamMessage = (UpstreamMessage) xStream.fromXML(upstreamXml);
            //�ı���Ϣ����
            if (upstreamMessage.getMsgType().toLowerCase().equals("text")) {
                downstreamMessage.setContent("��ֻ�Ǹ����ԣ�");
                downstreamMessage.setFromUserName(upstreamMessage.getFromUserName());
                downstreamMessage.setFuncFlag(0);
                downstreamMessage.setMsgType("text");
            }
            //�¼�����Ϣ����
            if (upstreamMessage.getMsgType().toLowerCase().equals("event")) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(downstreamMessage.getContent()) || downstreamMessage.getArticles() != null) {
            downstreamMessage.setToUserName(upstreamMessage.getFromUserName());
            downstreamMessage.setFromUserName(upstreamMessage.getToUserName());
            downstreamMessage.setCreateTime(System.currentTimeMillis() + "");
            xStream.alias("xml", DownstreamMessage.class);
            resultXml = xStream.toXML(downstreamMessage);
            resultXml = StringUtils.replaceOnce(resultXml, "<item>", "");
            resultXml = StringUtils.replaceOnce(resultXml, "</item>", "");
            resultXml = StringUtils.replace(resultXml, "<com.wechat.domain.bean.proxy.Item>", "<item>");
            resultXml = StringUtils.replace(resultXml, "</com.wechat.domain.bean.proxy.Item>", "</item>");
            logger.info("resultXml:" + resultXml);
        }
        return resultXml;
    }


    public void setTextMessageService(TextMessageService textMessageService) {
        this.textMessageService = textMessageService;
    }

    public void setEventMessageService(EventMessageService eventMessageService) {
        this.eventMessageService = eventMessageService;
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }
}
