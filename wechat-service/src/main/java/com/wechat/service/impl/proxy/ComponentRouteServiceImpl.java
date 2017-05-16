package com.wechat.service.impl.proxy;


import com.wechat.domain.bean.proxy.Component;
import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.domain.constant.proxy.ComponentConstant;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.ComponentRouteService;
import com.wechat.service.proxy.LuckyRingService;
import com.wechat.service.proxy.ScaratchCardService;
import com.wechat.service.proxy.SurveyService;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class ComponentRouteServiceImpl implements ComponentRouteService {

    private ProxyManager proxyManager;
    private LuckyRingService luckyRingService;
    private SurveyService surveyService;
    private ScaratchCardService scaratchCardService;

    public DownstreamMessage componentRoute(Integer componentId, UpstreamMessage upstreamMessage) {

//        logger.info("componentRoute-componentId:" + componentId);
        DownstreamMessage downstreamMessage = null;
        try {
            Component component = proxyManager.findComponent(componentId);
            if (component != null) {
                //大转盘
                if (component.getComponentType().intValue() == ComponentConstant.LUCKYRING) {
                    downstreamMessage = luckyRingService.getDownstreamMessage(component, upstreamMessage);
                }
                //刮刮卡
                if (component.getComponentType().intValue() == ComponentConstant.SCARATCHCARD) {
                    downstreamMessage = scaratchCardService.getDownstreamMessage(component, upstreamMessage);
                }
                //调查问卷
                if (component.getComponentType().intValue() == ComponentConstant.SURVEY) {
                    downstreamMessage = surveyService.getSurveryDownstreamMessage(component, upstreamMessage);
                }
                //记录访问日志
                proxyManager.insertComponentVisitLog(componentId, upstreamMessage.getFromUserName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downstreamMessage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }

    public void setLuckyRingService(LuckyRingService luckyRingService) {
        this.luckyRingService = luckyRingService;
    }

    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    public void setScaratchCardService(ScaratchCardService scaratchCardService) {
        this.scaratchCardService = scaratchCardService;
    }
}
