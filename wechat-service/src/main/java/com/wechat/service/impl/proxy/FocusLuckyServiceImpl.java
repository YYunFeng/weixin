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
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class FocusLuckyServiceImpl implements FocusLuckyService {

    private ProxyManager proxyManager;
//    private Logger logger = Logger.getLogger(this.getClass());
    Boolean isLucky = false;

    public DownstreamMessage getDownstreamMessage(Integer weixinId, Date openFoucsLuckyTime, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            //获取关注有奖的相关信息
            FocusLucky focusLucky = proxyManager.findFocusLuckyByWeixinId(weixinId);

            if (focusLucky != null) {

                StringBuilder resultMessage = new StringBuilder();
                StringBuilder luckyMessage = new StringBuilder();
                TextResources tempMessage = null;
                String lineString = "------------------------";
                String brString = "\r\n";

                //判断是否100%中奖
                //100%中奖
                if (focusLucky.getAbsoluteLucky()) {
                    //拼装中奖信息
                    luckyMessage.append(focusLucky.getLuckyMessage()).append(brString);
//                    luckyMessage.append(lineString).append(brString);
                    isLucky =  true;
                }
                //不是100%中奖
                else {

                    isLucky = false;
                    //按位数判断获奖
                    if (focusLucky.getLuckyNumber() != null) {
                        isLucky = numberLucky(weixinId, openFoucsLuckyTime, focusLucky.getLuckyNumber());
//                        logger.info("尾数抽奖:" + isLucky);
                    }
                    //按概率判断获奖
                    if (focusLucky.getLuckyProbability() != null) {
                        isLucky = probabilityLucky(focusLucky.getLuckyProbability());
//                        logger.info("概率抽奖:" + isLucky);
                    }

                    //如果中奖了,拼装中奖信息
                    if (isLucky) {
                        luckyMessage.append(focusLucky.getLuckyMessage()).append(brString);
                    }
                    //没中奖,拼装未中奖信息
                    else {
                        luckyMessage.append(focusLucky.getNotLuckyMessage()).append(brString);
                    }
                }

                //拼装最终返回信息
                //获取所有文本资源
                Map<String, TextResources> textResourcesMap = proxyManager.findTextResourcesByWeixinId(weixinId);

                //如果需要添加页眉
                if (focusLucky.getAddHeader() != null && focusLucky.getAddHeader()) {
                    tempMessage = textResourcesMap.get(TextResourcesConstant.PAGE_HEADER);
                    resultMessage.append(tempMessage.getMessage()).append(brString).append(lineString).append(brString);
                }

                //添加中奖或者未中奖信息
                resultMessage.append(luckyMessage);

                //如果举办方信息有任意一项不为空,则显示举办方信息
                if (true/*StringUtils.isNotBlank(focusLucky.getAddress()) || StringUtils.isNotBlank(focusLucky.getTelphone()) || StringUtils.isNotBlank(focusLucky.getRemark())*/) {
                    resultMessage.append(lineString).append(brString);
                    resultMessage.append("举办方信息").append(brString);
                    resultMessage.append("地址:").append(focusLucky.getAddress()).append(brString);
                    resultMessage.append("电话:").append(focusLucky.getTelphone()).append(brString);
                    resultMessage.append("备注:").append(focusLucky.getRemark()).append(brString);
                }

                //如果需要添加帮助
                if (focusLucky.getAddHelp() != null && focusLucky.getAddHelp()) {
                    tempMessage = textResourcesMap.get(TextResourcesConstant.HELP);
                    if (tempMessage != null)
                        resultMessage.append(lineString).append(brString).append(tempMessage.getMessage()).append(brString);
                }
                //如果需要添加页脚
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
     * 尾数抽奖方法
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
            //如果当前关注的总数小于幸运尾数,直接返回未中奖
            if (foucsCount.intValue() < luckyNumber.intValue()) {
                return false;
            }
            //如果当前关注总数和幸运尾数位数相当,从第0位截取,否则从总数的尾数减去幸运尾数的尾数开始截取
            int subLength = foucsCountStr.length() == luckyNumberStr.length() ? 0 : foucsCountStr.length() - luckyNumberStr.length();
            foucsCountStr = foucsCountStr.substring(subLength);
            if (foucsCountStr.equals(String.valueOf(luckyNumber)))
                return true;
        }
        return false;
    }

    /**
     * 概率抽奖方法
     *
     * @return
     */
    private static boolean probabilityLucky(double probability) {
        // 中奖等级：未中奖
        int winningLevel = -1;
        // 中奖随机号
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
