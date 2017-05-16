package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-26
 * Time: 下午3:15
 * To change this template use File | Settings | File Templates.
 */
public interface FocusLuckyService {

    //关注有奖获取下发信息
    public DownstreamMessage getDownstreamMessage(Integer weixinId, Date openFoucsLuckyTime, UpstreamMessage upstreamMessage);

    //获取关注有奖获奖状态
    public Boolean isLucky();

}
