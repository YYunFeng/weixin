package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.PicMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-9
 * Time: ионГ11:13
 * To change this template use File | Settings | File Templates.
 */
public interface PicMessageRouteService {
    public DownstreamMessage getDownstreamMessage(Integer weixinAccountId, UpstreamMessage upstreamMessage);

    public PicMessage getPicMessage(Integer picMessageId);
}
