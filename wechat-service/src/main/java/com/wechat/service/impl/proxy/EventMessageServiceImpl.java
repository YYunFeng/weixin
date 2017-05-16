package com.wechat.service.impl.proxy;



import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.TextResources;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.domain.bean.proxy.UserWeixin;
import com.wechat.domain.constant.proxy.TextResourcesConstant;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.EventMessageService;
import com.wechat.service.proxy.FocusLuckyService;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ����12:44
 * To change this template use File | Settings | File Templates.
 */
public class EventMessageServiceImpl implements EventMessageService {

    private ProxyManager proxyManager;
    private FocusLuckyService focusLuckyService;
    private Logger logger = Logger.getLogger(this.getClass());

    public DownstreamMessage getDownstreamMessage(Integer weixinAccountId, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            //�ж��Ƿ��ǹ�ע��֪ͨ��Ϣ
            if (upstreamMessage.getEvent().equals("subscribe")) {
                UserWeixin userWeixin = proxyManager.findUserWeixinById(weixinAccountId);
                if (userWeixin != null) {
                    //�ж�΢���˺��Ƿ�ͨ�˹�ע�н��
                    if (userWeixin.getFocusLucky() != null && userWeixin.getFocusLucky()) {
                        //������ע�н�������
                        downstreamMessage = focusLuckyService.getDownstreamMessage(weixinAccountId, userWeixin.getOpenFocusLuckyTime(), upstreamMessage);
                        //��¼��ע��־
                        proxyManager.insertFocusLog(upstreamMessage.getFromUserName(), weixinAccountId, downstreamMessage.getContent(), focusLuckyService.isLucky());
                    }
                    //û��ͨ
                    else {
                        //��ȡ�����ı���Դ
                        Map<String, TextResources> textResourcesMap = proxyManager.findTextResourcesByWeixinId(weixinAccountId);
                        //�Ȼ�ȡ��ע�ظ���Ϣ
                        TextResources focusMessage = textResourcesMap.get(TextResourcesConstant.FOCUS);
                        if (focusMessage != null) {
                            //ƴװ������Ϣ
                            StringBuilder resultMessage = new StringBuilder();
                            TextResources tempMessage = null;
                            String lineString = "------------------------";
                            String brString = "\r\n";

                            //�����Ҫ���ҳü
                            if (focusMessage.getAddHeader() != null && focusMessage.getAddHeader()) {
                                tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_HEADER);
                                resultMessage.append(tempMessage.getMessage()).append(brString).append(lineString).append(brString);
                            }

                            //��ӹ�ע��Ϣ
                            resultMessage.append(focusMessage.getMessage()).append(brString);

                            //�����Ҫ��Ӱ���
                            if (focusMessage.getAddHelp() != null && focusMessage.getAddHelp()) {
                                tempMessage = textResourcesMap.get(TextResourcesConstant.HELP);
                                if (tempMessage != null)
                                    resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                            }
                            //�����Ҫ���ҳ��
                            if (focusMessage.getAddFooter() != null && focusMessage.getAddFooter()) {
                                tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_FOOTER);
                                if (tempMessage != null)
                                    resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                            }
                            logger.info("focus response message:" + resultMessage.toString());
                            downstreamMessage.setMsgType("text");
                            downstreamMessage.setContent(resultMessage.toString());
                            downstreamMessage.setFuncFlag(0);
                            //��¼��ע��־
                            proxyManager.insertFocusLog(upstreamMessage.getFromUserName(), weixinAccountId, resultMessage.toString(), false);
                        }
                    }
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

    public void setFocusLuckyService(FocusLuckyService focusLuckyService) {
        this.focusLuckyService = focusLuckyService;
    }
}
