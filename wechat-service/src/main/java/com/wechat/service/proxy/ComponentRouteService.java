package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: обнГ8:32
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentRouteService {
    public DownstreamMessage componentRoute(Integer componentId, UpstreamMessage upstreamMessage);
}
