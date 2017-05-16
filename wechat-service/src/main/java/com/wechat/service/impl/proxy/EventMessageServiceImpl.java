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
 * Time: 下午12:44
 * To change this template use File | Settings | File Templates.
 */
public class EventMessageServiceImpl implements EventMessageService {

    private ProxyManager proxyManager;
    private FocusLuckyService focusLuckyService;
    private Logger logger = Logger.getLogger(this.getClass());

    public DownstreamMessage getDownstreamMessage(Integer weixinAccountId, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            //判断是否是关注的通知消息
            if (upstreamMessage.getEvent().equals("subscribe")) {
                UserWeixin userWeixin = proxyManager.findUserWeixinById(weixinAccountId);
                if (userWeixin != null) {
                    //判断微信账号是否开通了关注有奖活动
                    if (userWeixin.getFocusLucky() != null && userWeixin.getFocusLucky()) {
                        //交给关注有奖程序处理
                        downstreamMessage = focusLuckyService.getDownstreamMessage(weixinAccountId, userWeixin.getOpenFocusLuckyTime(), upstreamMessage);
                        //记录关注日志
                        proxyManager.insertFocusLog(upstreamMessage.getFromUserName(), weixinAccountId, downstreamMessage.getContent(), focusLuckyService.isLucky());
                    }
                    //没开通
                    else {
                        //获取所有文本资源
                        Map<String, TextResources> textResourcesMap = proxyManager.findTextResourcesByWeixinId(weixinAccountId);
                        //先获取关注回复信息
                        TextResources focusMessage = textResourcesMap.get(TextResourcesConstant.FOCUS);
                        if (focusMessage != null) {
                            //拼装返回信息
                            StringBuilder resultMessage = new StringBuilder();
                            TextResources tempMessage = null;
                            String lineString = "------------------------";
                            String brString = "\r\n";

                            //如果需要添加页眉
                            if (focusMessage.getAddHeader() != null && focusMessage.getAddHeader()) {
                                tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_HEADER);
                                resultMessage.append(tempMessage.getMessage()).append(brString).append(lineString).append(brString);
                            }

                            //添加关注信息
                            resultMessage.append(focusMessage.getMessage()).append(brString);

                            //如果需要添加帮助
                            if (focusMessage.getAddHelp() != null && focusMessage.getAddHelp()) {
                                tempMessage = textResourcesMap.get(TextResourcesConstant.HELP);
                                if (tempMessage != null)
                                    resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                            }
                            //如果需要添加页脚
                            if (focusMessage.getAddFooter() != null && focusMessage.getAddFooter()) {
                                tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_FOOTER);
                                if (tempMessage != null)
                                    resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                            }
                            logger.info("focus response message:" + resultMessage.toString());
                            downstreamMessage.setMsgType("text");
                            downstreamMessage.setContent(resultMessage.toString());
                            downstreamMessage.setFuncFlag(0);
                            //记录关注日志
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
