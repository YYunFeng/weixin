package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: ����3:15
 * To change this template use File | Settings | File Templates.
 */
public interface FocusLuckyService {

    //��ע�н���ȡ�·���Ϣ
    public DownstreamMessage getDownstreamMessage(Integer weixinId, Date openFoucsLuckyTime, UpstreamMessage upstreamMessage);

    //��ȡ��ע�н���״̬
    public Boolean isLucky();

}
