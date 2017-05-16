package com.wechat.service.impl.proxy;



import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.LuckyLog;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.LuckyLogService;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-27
 * Time: ����5:38
 * To change this template use File | Settings | File Templates.
 */
public class LuckyLogServiceImpl implements LuckyLogService {

    private ProxyManager proxyManager;
//    private Logger logger = Logger.getLogger(this.getClass());

    public DownstreamMessage getDownstreamMessage(UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            List<LuckyLog> ringLuckyAndScaratchCard = proxyManager.findLuckyRingScaratchCardLog(upstreamMessage.getFromUserName());
            List<LuckyLog> survey = proxyManager.findSurveyLuckyLog(upstreamMessage.getFromUserName());

            //û�ҵ��κ��н���¼
            if (ringLuckyAndScaratchCard.isEmpty() && survey.isEmpty()) {
                downstreamMessage.setContent("û�в�ѯ�������н���¼");
            }
            if (!ringLuckyAndScaratchCard.isEmpty() || !survey.isEmpty()) {
                String brString = "\r\n";
                StringBuilder content = new StringBuilder();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                for (LuckyLog luckyLog : ringLuckyAndScaratchCard) {
                    content.append(sdf.format(luckyLog.getCreated())).append(" ").append(luckyLog.getComponentTitle()).append("��л�ý�Ʒ:").append(luckyLog.getPrizeName()).append(brString);
                }
                for (LuckyLog luckyLog : survey) {
                    content.append(sdf.format(luckyLog.getCreated())).append(" ").append(luckyLog.getComponentTitle()).append("����н�").append(brString);
                }
                downstreamMessage.setContent(content.toString());
            }
            downstreamMessage.setMsgType("text");
            downstreamMessage.setFuncFlag(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downstreamMessage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }
}
