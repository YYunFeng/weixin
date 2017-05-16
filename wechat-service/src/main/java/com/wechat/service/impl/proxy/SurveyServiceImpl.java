package com.wechat.service.impl.proxy;



import com.wechat.domain.bean.proxy.*;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.service.proxy.SurveyService;
import com.wechat.domain.utils.PathsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-9
 * Time: ÏÂÎç1:55
 * To change this template use File | Settings | File Templates.
 */
public class SurveyServiceImpl implements SurveyService {

    private PathsUtil pathsUtil;
    private String surverUrl;
//    private Logger logger = Logger.getLogger(this.getClass());

    public DownstreamMessage getSurveryDownstreamMessage(Component component, UpstreamMessage upstreamMessage) {
        DownstreamMessage downstreamMessage = new DownstreamMessage();
        downstreamMessage.setMsgType("news");
        downstreamMessage.setArticleCount(1);

        Articles articles = new Articles();

        List<Item> itemList = new ArrayList<Item>();
        Item item = new Item();
        item.setTitle(component.getTitle());
        item.setDescription(component.getIntro());
        item.setPicUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + component.getPic());
        item.setUrl(surverUrl + "?component_id=" + component.getId() + "&openuid=" + upstreamMessage.getFromUserName());
//        logger.info("url:" + surverUrl + "?component_id=" + component.getId() + "&openuid=" + upstreamMessage.getFromUserName());
        itemList.add(item);

        articles.setItem(itemList);

        downstreamMessage.setArticles(articles);
        downstreamMessage.setArticleCount(itemList.size());


        return downstreamMessage;  //To change body of implemented methods use File | Settings | F
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }

    public void setSurverUrl(String surverUrl) {
        this.surverUrl = surverUrl;
    }
}
