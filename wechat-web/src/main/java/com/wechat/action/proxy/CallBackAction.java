package com.wechat.action.proxy;


import com.wechat.action.BaseAction;
import com.wechat.service.proxy.UpstreamRouteService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * User: gaoyang
 * <p>
 * Date: 13-4-19
 * <p>
 * Time: ����2:21
 * <p>
 * To change this template use File | Settings | File Templates.
 */

public class CallBackAction extends BaseAction {
    private Logger logger = Logger.getLogger(this.getClass());
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
    private Integer weixinAccountId;
    private UpstreamRouteService upstreamRouteService;

    /**
     * �����û�������Ϣ
     *
     * @return
     */
    public String upstream() throws IOException {
        logger.info("weixinAccountId:" + weixinAccountId);
        //�ж��Ƿ��������,��get��������echostr��Ϊ��Ϊ��������
        if (request.getMethod().toLowerCase().equals("get") && StringUtils.isNotBlank(echostr)) {
            response.getWriter().write(echostr);
            return null;
        } else {  //����������Ϣ
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String buffer = null;
            StringBuffer upstreamXml = new StringBuffer();
            while ((buffer = br.readLine()) != null) {
                upstreamXml.append(buffer);
            }
            logger.info(upstreamXml.toString());
            if (StringUtils.isNotBlank(upstreamXml.toString()) && weixinAccountId != null) {
                //�ύ����·�ɳ�����д���
                String resultXml = upstreamRouteService.userUpstream(weixinAccountId, upstreamXml.toString());
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resultXml);
            }
        }
        return null;
    }


    public String test() {
        String xml = "<xml><ToUserName><![CDATA[gh_475fa3676a39]]></ToUserName><FromUserName><![CDATA[oyLUDjxF5Hp4r02pl3WTQCAKF2Ng]]></FromUserName><CreateTime>1371625480</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[�н���ѯ]]></Content><MsgId>5891086578960303430</MsgId></xml> ";
        upstreamRouteService.userUpstream(43, xml);
        return null;
    }


    public Integer getWeixinAccountId() {
        return weixinAccountId;
    }

    public void setWeixinAccountId(Integer weixinAccountId) {
        this.weixinAccountId = weixinAccountId;
    }


    public void setUpstreamRouteService(UpstreamRouteService upstreamRouteService) {
        this.upstreamRouteService = upstreamRouteService;
    }


    public Logger getLogger() {
        return logger;
    }


    public void setLogger(Logger logger) {
        this.logger = logger;
    }


    public String getSignature() {
        return signature;
    }


    public void setSignature(String signature) {
        this.signature = signature;
    }


    public String getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public String getNonce() {
        return nonce;
    }


    public void setNonce(String nonce) {
        this.nonce = nonce;
    }


    public String getEchostr() {
        return echostr;
    }


    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

}

