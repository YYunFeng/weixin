package com.wechat.service.impl.proxy;


import com.wechat.domain.bean.proxy.*;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.manager.proxy.ProxyManager;
import com.wechat.service.proxy.PicMessageRouteService;
import com.wechat.domain.utils.PathsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-9
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class PicMessageRouteServiceImpl implements PicMessageRouteService {

    private ProxyManager proxyManager;
    private PathsUtil pathsUtil;
    private String linkUrl;

    public DownstreamMessage getDownstreamMessage(Integer materialId, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        try {
            //查询图文信息
            List<PicMessage> picMessageList = proxyManager.findPicMessageByMaterialId(materialId);
            if (picMessageList != null) {
                downstreamMessage.setMsgType("news");
                downstreamMessage.setArticleCount(picMessageList.size());
                Articles articles = null;
                Item item = null;
                List<Item> itemList = new ArrayList<Item>();
                for (PicMessage picMessage : picMessageList) {
                    articles = new Articles();
                    item = new Item();
                    item.setTitle(picMessage.getTitle());
                    item.setDescription(picMessage.getAbstract1());
                    item.setPicUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.MATERIAL + picMessage.getPicUrl());
//                    item.setUrl(StringUtils.isNotBlank(picMessage.getLinkUr()) ? picMessage.getLinkUr() : linkUrl + "?picMessageId=" + picMessage.getPicMessageId());
                    itemList.add(item);
                }
                articles.setItem(itemList);
                downstreamMessage.setArticles(articles);
                downstreamMessage.setArticleCount(itemList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downstreamMessage;
    }

    public PicMessage getPicMessage(Integer picMessageId) {
        PicMessage picMessage = proxyManager.findPicMessageById(picMessageId);
        if (picMessage != null) {
            if (picMessage.getPicUrl() != null)
                picMessage.setPicUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.MATERIAL + picMessage.getPicUrl());
            if (picMessage.getMessage() != null)
                picMessage.setMessage(picMessage.getMessage().replaceAll("\n", "<br />"));
        }
        return picMessage;
    }

    public ProxyManager getProxyManager() {
        return proxyManager;
    }

    public void setProxyManager(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
