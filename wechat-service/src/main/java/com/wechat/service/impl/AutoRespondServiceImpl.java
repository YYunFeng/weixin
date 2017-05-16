package com.wechat.service.impl;


import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.AutoRespondRes;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.manager.AutoRespondManager;
import com.wechat.service.AutoRespondService;
import com.wechat.domain.utils.PathsUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午8:21
 * To change this template use File | Settings | File Templates.
 */
public class AutoRespondServiceImpl implements AutoRespondService {
    private AutoRespondManager autoRespondManager;
    private PathsUtil pathsUtil;

    public List<KeyWordLink> getAutoRespond(UserWeiXin userWeiXin) {
        return autoRespondManager.getAutoRespond(userWeiXin);
    }

    public Integer createAutoRespond(KeyWordLink keyWordLink) {
        return autoRespondManager.createAutoRespond(keyWordLink);
    }

    public void updateAutoRespond(KeyWordLink keyWordLink) {
        autoRespondManager.updateAutoRespond(keyWordLink);
    }

    public AutoRespondRes getAutoRespondById(KeyWordLink KeyWordLink) {
        AutoRespondRes autoRespondRes = autoRespondManager.getAutoRespondById(KeyWordLink);
        if (autoRespondRes.getLinkType() != null) {
            //关联组件
            if (autoRespondRes.getLinkType().intValue() == 1) {
                autoRespondRes.setMaterialPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.MATERIAL + autoRespondRes.getMaterialPic());
            }
            // 关联素材
            if (autoRespondRes.getLinkType().intValue() == 2) {
                autoRespondRes.setComponentPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + autoRespondRes.getComponentPic());
            }
        }
        return autoRespondRes;
    }

    public void deleteRule(KeyWordLink keyWordLink) {
        autoRespondManager.deleteRule(keyWordLink);
    }

    public TextResources getTextResources(TextResources textResources) {
        return autoRespondManager.getTextResources(textResources);  
    }

    public FoucsLucky getFoucsLucky(Integer weixinId) {
        return autoRespondManager.getFoucsLucky(weixinId);
    }

    public UserWeiXin getUserWeiXin(User user) {
        return autoRespondManager.getUserWeiXin(user);
    }

    public void updateTextResources(TextResources textResources) {
        autoRespondManager.updateTextResources(textResources);
    }

    public void updateFoucsLucky(FoucsLucky focusLucky) {
        autoRespondManager.updateFoucsLucky(focusLucky);
    }

    public void updateUserWeiXin(UserWeiXin userWeiXin) {
        autoRespondManager.updateUserWeiXin(userWeiXin);
    }

    public KeyWordLink autoRule(KeyWordLink keyWordLink) {
        return autoRespondManager.autoRule(keyWordLink);
    }

    public List<KeyWordLink> exportHelp(Integer weixinId) {
        return autoRespondManager.exportHelp(weixinId);
    }

    public void setAutoRespondManager(AutoRespondManager autoRespondManager) {
        this.autoRespondManager = autoRespondManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
