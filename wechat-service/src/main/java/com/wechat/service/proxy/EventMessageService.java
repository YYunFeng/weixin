package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ����12:42
 * To change this template use File | Settings | File Templates.
 */
public interface EventMessageService {
    //��ȡ������Ϣ
    public DownstreamMessage getDownstreamMessage(Integer weixinAccountId, UpstreamMessage upstreamMessage);
}
