package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-27
 * Time: ����5:38
 * To change this template use File | Settings | File Templates.
 */
public interface LuckyLogService {

    /**
     * ��ȡ�·���Ϣ
     *
     * @param upstreamMessage
     * @return
     */
    public DownstreamMessage getDownstreamMessage(UpstreamMessage upstreamMessage);
}
