package com.wechat.service.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ����5:15
 * To change this template use File | Settings | File Templates.
 */
public interface UpstreamRouteService {

    /**
     * ����weinxinAccountId�����û�������Ϣ
     *
     * @param weixinAccountId
     */
    public String userUpstream(Integer weixinAccountId, String upstreamXml);


    /**
     * ������������
     *
     * @return
     */
    String testUpstream(String upstreamXml);

}
