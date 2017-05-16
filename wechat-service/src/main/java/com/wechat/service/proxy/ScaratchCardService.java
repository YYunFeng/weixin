package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.Component;
import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.domain.json.proxy.ScaratchCardInitRes;
import com.wechat.domain.json.proxy.ScaratchCardLuckyRes;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
public interface ScaratchCardService {
    /**
     * 获取图文下发信息
     *
     * @param component
     * @return
     */
    public DownstreamMessage getDownstreamMessage(Component component, UpstreamMessage upstreamMessage);

    /**
     * 获取奖项列表
     */
    public ScaratchCardInitRes getPrizeList(Integer componentId, String weixinOpenId);

    /**
     * 抽奖
     * @param componentId
     * @param weixinOpenId
     * @return
     */
    public ScaratchCardLuckyRes lucky(Integer componentId, String weixinOpenId);
}
