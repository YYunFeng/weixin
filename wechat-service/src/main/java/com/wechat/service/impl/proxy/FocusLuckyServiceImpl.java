package com.wechat.service.impl.proxy;



import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.FocusLucky;
import com.wechat.domain.bean.proxy.TextResources;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.domain.constant.proxy.TextResourcesConstant;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.FocusLuckyService;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ����3:17
 * To change this template use File | Settings | File Templates.
 */
public class FocusLuckyServiceImpl implements FocusLuckyService {

    private ProxyManager proxyManager;
//    private Logger logger = Logger.getLogger(this.getClass());
    Boolean isLucky = false;

    public DownstreamMessage getDownstreamMessage(Integer weixinId, Date openFoucsLuckyTime, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            //��ȡ��ע�н��������Ϣ
            FocusLucky focusLucky = proxyManager.findFocusLuckyByWeixinId(weixinId);

            if (focusLucky != null) {

                StringBuilder resultMessage = new StringBuilder();
                StringBuilder luckyMessage = new StringBuilder();
                TextResources tempMessage = null;
                String lineString = "------------------------";
                String brString = "\r\n";

                //�ж��Ƿ�100%�н�
                //100%�н�
                if (focusLucky.getAbsoluteLucky()) {
                    //ƴװ�н���Ϣ
                    luckyMessage.append(focusLucky.getLuckyMessage()).append(brString);
//                    luckyMessage.append(lineString).append(brString);
                    isLucky =  true;
                }
                //����100%�н�
                else {

                    isLucky = false;
                    //��λ���жϻ�
                    if (focusLucky.getLuckyNumber() != null) {
                        isLucky = numberLucky(weixinId, openFoucsLuckyTime, focusLucky.getLuckyNumber());
//                        logger.info("β���齱:" + isLucky);
                    }
                    //�������жϻ�
                    if (focusLucky.getLuckyProbability() != null) {
                        isLucky = probabilityLucky(focusLucky.getLuckyProbability());
//                        logger.info("���ʳ齱:" + isLucky);
                    }

                    //����н���,ƴװ�н���Ϣ
                    if (isLucky) {
                        luckyMessage.append(focusLucky.getLuckyMessage()).append(brString);
                    }
                    //û�н�,ƴװδ�н���Ϣ
                    else {
                        luckyMessage.append(focusLucky.getNotLuckyMessage()).append(brString);
                    }
                }

                //ƴװ���շ�����Ϣ
                //��ȡ�����ı���Դ
                Map<String, TextResources> textResourcesMap = proxyManager.findTextResourcesByWeixinId(weixinId);

                //�����Ҫ���ҳü
                if (focusLucky.getAddHeader() != null && focusLucky.getAddHeader()) {
                    tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_HEADER);
                    resultMessage.append(tempMessage.getMessage()).append(brString).append(lineString).append(brString);
                }

                //����н�����δ�н���Ϣ
                resultMessage.append(luckyMessage);

                //����ٰ췽��Ϣ������һ�Ϊ��,����ʾ�ٰ췽��Ϣ
                if (true/*StringUtils.isNotBlank(focusLucky.getAddress()) || StringUtils.isNotBlank(focusLucky.getTelphone()) || StringUtils.isNotBlank(focusLucky.getRemark())*/) {
                    resultMessage.append(lineString).append(brString);
                    resultMessage.append("�ٰ췽��Ϣ").append(brString);
                    resultMessage.append("��ַ:").append(focusLucky.getAddress()).append(brString);
                    resultMessage.append("�绰:").append(focusLucky.getTelphone()).append(brString);
                    resultMessage.append("��ע:").append(focusLucky.getRemark()).append(brString);
                }

                //�����Ҫ��Ӱ���
                if (focusLucky.getAddHelp() != null && focusLucky.getAddHelp()) {
                    tempMessage = textResourcesMap.get(TextResourcesConstant.HELP);
                    if (tempMessage != null)
                        resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                }
                //�����Ҫ���ҳ��
                if (focusLucky.getAddFooter() != null && focusLucky.getAddFooter()) {
                    tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_FOOTER);
                    if (tempMessage != null)
                        resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                }
//                logger.info("focus lucky response message:" + resultMessage.toString());
                downstreamMessage.setMsgType("text");
                downstreamMessage.setContent(resultMessage.toString());
                downstreamMessage.setFuncFlag(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downstreamMessage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Boolean isLucky() {
        return this.isLucky;
    }

    /**
     * β���齱����
     *
     * @param weixinId
     * @param openFoucsLuckyTime
     * @param luckyNumber
     * @return
     */
    private boolean numberLucky(Integer weixinId, Date openFoucsLuckyTime, Integer luckyNumber) {
        Integer foucsCount = proxyManager.findFoucsCountByWeixinIdAndTime(weixinId, openFoucsLuckyTime);
        String foucsCountStr = "";
        String luckyNumberStr = "";
        if (foucsCount != null) {
            foucsCountStr = String.valueOf(foucsCount);
            luckyNumberStr = String.valueOf(luckyNumber);
            //�����ǰ��ע������С������β��,ֱ�ӷ���δ�н�
            if (foucsCount.intValue() < luckyNumber.intValue()) {
                return false;
            }
            //�����ǰ��ע����������β��λ���൱,�ӵ�0λ��ȡ,�����������β����ȥ����β����β����ʼ��ȡ
            int subLength = foucsCountStr.length() == luckyNumberStr.length() ? 0 : foucsCountStr.length() - luckyNumberStr.length();
            foucsCountStr = foucsCountStr.substring(subLength);
            if (foucsCountStr.equals(String.valueOf(luckyNumber)))
                return true;
        }
        return false;
    }

    /**
     * ���ʳ齱����
     *
     * @return
     */
    private static boolean probabilityLucky(double probability) {
        // �н��ȼ���δ�н�
        int winningLevel = -1;
        // �н������
        int randomWinningNo = 0;
        int args[] = new int[1 * 2];
        int temp = (int) Math.round(Math.random() * 1000000000) % 1000000;
        int j = 0;
        for (int i = 0; i < 1; i++) {
            double tmpWinningPro = probability;
            if (j == 0) {
                args[j] = randomWinningNo;
            } else {
                args[j] = args[j - 1] + 1;
            }
            args[j + 1] = args[j] + (int) Math.round(tmpWinningPro * 10000) - 1;
            if (temp >= args[j] && temp <= args[j + 1]) {
                winningLevel = 1;
            }
            j += 2;
        }
        if (winningLevel != -1)
            return true;
        return false;
    }


    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }


}
