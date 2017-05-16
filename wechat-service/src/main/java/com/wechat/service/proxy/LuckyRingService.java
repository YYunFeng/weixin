package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.Component;
import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;
import com.wechat.domain.json.proxy.LuckyRingInitRes;
import com.wechat.domain.json.proxy.LuckyRingLuckyRes;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
public interface LuckyRingService {

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
    public LuckyRingInitRes getPrizeList(Integer componentId, String weixinOpenId);

    /**
     * 抽奖
     * @param componentId
     * @param weixinOpenId
     * @return
     */
    public LuckyRingLuckyRes lucky(Integer componentId, String weixinOpenId);
}
