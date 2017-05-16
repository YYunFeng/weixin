package com.wechat.service.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */
public interface UpstreamRouteService {

    /**
     * 根据weinxinAccountId处理用户上行信息
     *
     * @param weixinAccountId
     */
    public String userUpstream(Integer weixinAccountId, String upstreamXml);


    /**
     * 测试上行数据
     *
     * @return
     */
    String testUpstream(String upstreamXml);

}
