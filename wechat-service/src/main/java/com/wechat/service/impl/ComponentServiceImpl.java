package com.wechat.service.impl;


import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.BigWheelComponentRes;
import com.wechat.domain.bean.response.ComponentRes;
import com.wechat.domain.bean.response.ScaratchComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.domain.parameter.ComponentParameter;
import com.wechat.manager.ComponentManager;
import com.wechat.service.ComponentService;
import com.wechat.domain.utils.PathsUtil;


import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午12:44
 * To change this template use File | Settings | File Templates.
 */
public class ComponentServiceImpl implements ComponentService {
    private ComponentManager componentManager;
    private PathsUtil pathsUtil;

    /**
     * 获取组件列表
     *
     * @param ComponentParameter
     * @return
     */
    public List<Component> getComponet(ComponentParameter ComponentParameter) {
        List<Component> componentList = componentManager.getComponent(ComponentParameter);
        for (Component component : componentList) {
            component.setPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + component.getPic());
            component.setExpired(false);
            if (component.getEndTime() != null) {
                if (component.getEndTime().before(new Date())) {
                    component.setExpired(true);
                }
            }
        }
        return componentList;
    }

    /**
     * 创建大转盘
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public void createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        Integer componentId = componentManager.createBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
    }

    /**
     * 创建刮刮卡
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void createScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        componentManager.createScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
    }

    /**
     * 删除组件
     *
     * @param component
     */
    public void deleteComponent(Component component) {
        componentManager.deleteComponent(component);
    }

    /**
     * 更新大转盘
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public void updateBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        componentManager.updateBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
    }

    /**
     * 更新刮刮卡
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void updateScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        componentManager.updateScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
    }

    /**
     * 获取大转盘详细信息
     *
     * @param componentId
     * @return
     */
    public BigWheelComponentRes getBigWheelComponent(Integer componentId) {
        BigWheelComponentRes bigWheelComponentRes = new BigWheelComponentRes();
        try {
            // 获取大转盘基本信息
            ComponentRes componentRes = componentManager.getComponentRes(componentId);
            componentRes.setPicPath(componentRes.getPic());
            // 图片访问地址
            componentRes.setPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + componentRes.getPic());
            bigWheelComponentRes.setComponentRes(componentRes);
            // 获取大转盘奖项信息
            List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList = componentManager.getComponentRingLuckPrize(componentRes.getComponentLuckyId());
            bigWheelComponentRes.setBigWheelRingLuckyPrizeList(bigWheelRingLuckyPrizeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigWheelComponentRes;
    }

    /**
     * 获得刮刮卡详细信息
     *
     * @param componentId
     * @return
     */
    public ScaratchComponentRes getScaratchComponent(Integer componentId) {
        ScaratchComponentRes scaratchComponentRes = new ScaratchComponentRes();
        try {
            // 获取大转盘基本信息
            ComponentRes componentRes = new ComponentRes();
            componentRes = componentManager.getScaratchComponentRes(componentId);
            componentRes.setPicPath(componentRes.getPic());
            // 图片访问地址
            componentRes.setPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + componentRes.getPic());
            scaratchComponentRes.setComponentRes(componentRes);
            // 获取大转盘奖项信息
            List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList = componentManager.getScaratchComponentRingLuckPrize(componentRes.getComponentLuckyId());
            scaratchComponentRes.setScaratchCardRingLuckyPrizeList(scaratchCardRingLuckyPrizeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scaratchComponentRes;
    }

    /**
     * 创建问卷调查
     *
     * @param component
     * @param survey
     */
    public void createSurvey(Component component, Survey survey) {
        try {
            componentManager.createdSurvey(component, survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SurveyRes getSurveyContent(Integer componentId) {
        SurveyRes surveyRes = new SurveyRes();
        try {
            surveyRes = componentManager.getSurveyContent(componentId);
            surveyRes.setPicPath(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + surveyRes.getPic());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surveyRes;
    }

    public void updateSurvey(Component component, Survey survey) {
        try {
            componentManager.updateSurvey(component, survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setComponentManager(ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }


}
