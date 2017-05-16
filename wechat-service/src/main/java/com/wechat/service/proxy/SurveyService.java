package com.wechat.service.proxy;


import com.wechat.domain.bean.proxy.Component;
import com.wechat.domain.bean.proxy.DownstreamMessage;
import com.wechat.domain.bean.proxy.UpstreamMessage;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-9
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
public interface SurveyService {
    /**
     * 获取图文下发信息
     *
     * @param component
     * @return
     */
    public DownstreamMessage getSurveryDownstreamMessage(Component component, UpstreamMessage upstreamMessage);

}
