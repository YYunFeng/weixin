package com.wechat.manager.impl;

import com.wechat.dao.ComponentDao;
import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.ComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.parameter.ComponentParameter;
import com.wechat.manager.ComponentManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午12:42
 * To change this template use File | Settings | File Templates.
 */
public class ComponentManagerImpl implements ComponentManager {
    private ComponentDao componentDao;

    /**
     * 得到组件列表
     *
     * @param ComponentParameter
     * @return
     */
    public List<Component> getComponent(ComponentParameter ComponentParameter) {
        return componentDao.getComponent(ComponentParameter);
    }

    /**
     * 创建大转盘
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public Integer createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        Integer componentId = 0;
        try {
            componentId = componentDao.createBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentId;
    }

    /**
     * 创建刮刮卡
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void createScaratchComponent(Component component, ScaratchCardRingLucy
            scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        try {
            componentDao.createScaratch(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除组件
     *
     * @param component
     */
    public void deleteComponent(Component component) {
        componentDao.deleteComponent(component);
    }

    /**
     * 更新大转盘信息
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public void updateBigWheelComponent(Component component, BigWheelRingLucky
            bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        try {
            // 更新组件表
            componentDao.updateComponent(component);
            // 更新大转盘基本信息表
            componentDao.updateComponentRingLucky(bigWheelRingLucky);
            // 更新大转盘奖项表
            if (bigWheelRingLuckyPrizeList != null && bigWheelRingLuckyPrizeList.size() != 0) {
                for (int i = 0; i < bigWheelRingLuckyPrizeList.size(); i++) {
                    componentDao.updateComponentRingLuckyPrize(bigWheelRingLuckyPrizeList.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新刮刮卡信息
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void updateScaratchComponent(Component component, ScaratchCardRingLucy
            scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        try {
            // 更新组件表
            componentDao.updateComponent(component);
            // 更新刮刮卡基本信息表
            componentDao.updateScaratchRingLucky(scaratchCardRingLucy);
            // 更新刮刮卡奖项表
            if (scaratchCardRingLuckyPrizeList != null && scaratchCardRingLuckyPrizeList.size() != 0) {
                for (ScaratchCardRingLuckyPrize scaratchCardRingLuckyPrize : scaratchCardRingLuckyPrizeList) {
                    componentDao.updateScaratchRingLuckyPrize(scaratchCardRingLuckyPrize);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到大转盘基本信息
     *
     * @param componentId
     * @return
     */
    public ComponentRes getComponentRes(Integer componentId) {
        return componentDao.getBigWheelComponent(componentId);
    }

    /**
     * 得到刮刮卡基本信息
     *
     * @param componentId
     * @return
     */
    public ComponentRes getScaratchComponentRes(Integer componentId) {
        return componentDao.getScaratchComponent(componentId);
    }

    /**
     * 得到刮刮卡奖项信息
     *
     * @param scaratchId
     * @return
     */
    public List<ScaratchCardRingLuckyPrize> getScaratchComponentRingLuckPrize(Integer scaratchId) {
        return componentDao.getScaratchRingLuckyPrize(scaratchId);
    }

    /**
     * 得到大转盘奖项信息
     *
     * @param luckyringId
     * @return
     */
    public List<BigWheelRingLuckyPrize> getComponentRingLuckPrize(Integer luckyringId) {
        return componentDao.getComponentRingLuckyPrize(luckyringId);
    }

    public void createdSurvey(Component component, Survey survey) {
        try {
            Integer componentId = componentDao.createComponent(component);
            survey.setComponentId(componentId);
            componentDao.createSurvey(survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SurveyRes getSurveyContent(Integer componentId) {
        return componentDao.getSurveyContent(componentId);
    }

    public void updateSurvey(Component component, Survey survey) {
        try {
            // 更新组件表
            componentDao.updateComponent(component);
            // 更新问卷调查基本信息表
            componentDao.updateSurvey(survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setComponentDao(ComponentDao componentDao) {
        this.componentDao = componentDao;
    }
}
