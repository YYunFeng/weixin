package com.wechat.action.proxy;

import com.wechat.domain.json.proxy.ScaratchCardInitRes;
import com.wechat.domain.json.proxy.ScaratchCardLuckyRes;
import com.wechat.service.proxy.ScaratchCardService;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: ÏÂÎç3:55
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchCardAction {

    private ScaratchCardInitRes scaratchCardInitRes;
    private ScaratchCardLuckyRes scaratchCardLuckyRes;
    private ScaratchCardService scaratchCardService;

    private Integer componentId;
    private String weixinOpenId;


    /**
     * ¹Î¹Î¿¨³õÊ¼»¯,·µ»Ø½±Ïî
     *
     * @return
     */
    public String init() {
        scaratchCardInitRes = scaratchCardService.getPrizeList(componentId, weixinOpenId);
        return "init";
    }

    /**
     * ³é½±
     *
     * @return
     */
    public String lucky() {
        scaratchCardLuckyRes = scaratchCardService.lucky(componentId, weixinOpenId);
        return "lucky";
    }

    public ScaratchCardInitRes getScaratchCardInitRes() {
        return scaratchCardInitRes;
    }

    public void setScaratchCardInitRes(ScaratchCardInitRes scaratchCardInitRes) {
        this.scaratchCardInitRes = scaratchCardInitRes;
    }

    public ScaratchCardLuckyRes getScaratchCardLuckyRes() {
        return scaratchCardLuckyRes;
    }

    public void setScaratchCardLuckyRes(ScaratchCardLuckyRes scaratchCardLuckyRes) {
        this.scaratchCardLuckyRes = scaratchCardLuckyRes;
    }

    public ScaratchCardService getScaratchCardService() {
        return scaratchCardService;
    }

    public void setScaratchCardService(ScaratchCardService scaratchCardService) {
        this.scaratchCardService = scaratchCardService;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }


    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }


}
