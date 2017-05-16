package com.wechat.action.proxy;


import com.wechat.domain.bean.proxy.PicMessage;
import com.wechat.service.proxy.PicMessageRouteService;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-9
 * Time: ÏÂÎç2:28
 * To change this template use File | Settings | File Templates.
 */
public class Html5 {

    private Integer picMessageId;
    private PicMessageRouteService picMessageRouteService;

    private PicMessage picMessage;

    private Integer componentId;
    private String weixinOpenId;

    public String scaratchCard() {
        return "scaratchCard";
    }

    public String luckyRing() {
        return "luckyring";
    }

    public String picMessage() {
        picMessage = picMessageRouteService.getPicMessage(picMessageId);
        return "picmessage";
    }

    public Integer getPicMessageId() {
        return picMessageId;
    }

    public void setPicMessageId(Integer picMessageId) {
        this.picMessageId = picMessageId;
    }

    public PicMessageRouteService getPicMessageRouteService() {
        return picMessageRouteService;
    }

    public void setPicMessageRouteService(PicMessageRouteService picMessageRouteService) {
        this.picMessageRouteService = picMessageRouteService;
    }

    public PicMessage getPicMessage() {
        return picMessage;
    }

    public void setPicMessage(PicMessage picMessage) {
        this.picMessage = picMessage;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }
}
