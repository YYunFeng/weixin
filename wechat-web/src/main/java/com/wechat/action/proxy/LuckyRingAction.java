package com.wechat.action.proxy;

import com.wechat.domain.json.proxy.LuckyRingInitRes;
import com.wechat.domain.json.proxy.LuckyRingLuckyRes;
import com.wechat.service.proxy.LuckyRingService;


/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class LuckyRingAction {

    private LuckyRingInitRes luckyRingInitRes;
    private LuckyRingLuckyRes luckyRingLuckyRes;
    private LuckyRingService luckyRingService;

    private Integer componentId;
    private String weixinOpenId;


    /**
     * 大转盘初始化,返回奖项
     *
     * @return
     */
    public String init() {
        luckyRingInitRes = luckyRingService.getPrizeList(componentId, weixinOpenId);
        return "init";
    }

    /**
     * 抽奖
     *
     * @return
     */
    public String lucky() {
        luckyRingLuckyRes = luckyRingService.lucky(componentId, weixinOpenId);
        return "lucky";
    }




    public LuckyRingLuckyRes getLuckyRingLuckyRes() {
        return luckyRingLuckyRes;
    }

    public void setLuckyRingLuckyRes(LuckyRingLuckyRes luckyRingLuckyRes) {
        this.luckyRingLuckyRes = luckyRingLuckyRes;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public LuckyRingInitRes getLuckyRingInitRes() {
        return luckyRingInitRes;
    }

    public void setLuckyRingInitRes(LuckyRingInitRes luckyRingInitRes) {
        this.luckyRingInitRes = luckyRingInitRes;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }


    public void setLuckyRingService(LuckyRingService luckyRingService) {
        this.luckyRingService = luckyRingService;
    }

}
