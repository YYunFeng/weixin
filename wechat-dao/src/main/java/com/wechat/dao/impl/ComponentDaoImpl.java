package com.wechat.dao.impl;

import com.wechat.dao.BaseDao;
import com.wechat.dao.ComponentDao;
import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.ComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.parameter.ComponentParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午12:38
 * To change this template use File | Settings | File Templates.
 */
public class ComponentDaoImpl extends BaseDao implements ComponentDao {

    public List getComponent(ComponentParameter ComponentParameter) {
        return queryForList("Component.getCompontent", ComponentParameter);
    }

    /**
     * 创建大转盘
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public Integer createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        // 插入组件表
        Integer componentId = 0;
        try {
            componentId = (Integer) insert("Component.createComponent", component);
            // 插入大转盘信息表
            bigWheelRingLucky.setComponentId(componentId);
            Integer componentRingLuckyId = (Integer) insert("Component.createComponentRingLucky", bigWheelRingLucky);
            // 插入大转盘奖项信息
            for (int i = 0; i < bigWheelRingLuckyPrizeList.size(); i++) {
                bigWheelRingLuckyPrizeList.get(i).setLuckyringId(componentRingLuckyId);
                insert("Component.createComponentRingLuckyPrize", bigWheelRingLuckyPrizeList.get(i));
            }
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
    public void createScaratch(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        // 插入组件表
        Integer componentId = (Integer) insert("Component.createComponent", component);
        // 插入刮刮卡信息表
        scaratchCardRingLucy.setComponentId(componentId);
        Integer componentRingLuckyId = (Integer) insert("Component.createScaratchRingLucky", scaratchCardRingLucy);
        // 插入刮刮卡奖项信息
        for (int i = 0; i < scaratchCardRingLuckyPrizeList.size(); i++) {
            scaratchCardRingLuckyPrizeList.get(i).setScaratchId(componentRingLuckyId);
            insert("Component.createScaratchRingLuckyPrize", scaratchCardRingLuckyPrizeList.get(i));
        }
    }

    /**
     * 获取大转盘详细基本信息
     *
     * @param Id
     * @return
     */
    public ComponentRes getBigWheelComponent(Integer Id) {
        return (ComponentRes) queryForObject("Component.getBigWheelComponent", Id);
    }

    /**
     * 获取刮刮卡详细基本信息
     *
     * @param Id
     * @return
     */
    public ComponentRes getScaratchComponent(Integer Id) {
        return (ComponentRes) queryForObject("Component.getScaratchComponent", Id);
    }

    /**
     * 获取刮刮卡奖项信息
     *
     * @param Id
     * @return
     */
    public List<ScaratchCardRingLuckyPrize> getScaratchRingLuckyPrize(Integer Id) {
        return queryForList("Component.getScaratchRingLuckyPrize", Id);
    }

    /**
     * 获取大转盘奖项信息
     *
     * @param Id
     * @return
     */
    public List<BigWheelRingLuckyPrize> getComponentRingLuckyPrize(Integer Id) {
        return queryForList("Component.getComponentRingLuckyPrize", Id);
    }

    /**
     * 更新组件
     *
     * @param component
     */
    public void updateComponent(Component component) {
        update("Component.updateComponent", component);
    }

    /**
     * 更新大转盘基本信息
     *
     * @param bigWheelRingLucky
     */
    public void updateComponentRingLucky(BigWheelRingLucky bigWheelRingLucky) {
        update("Component.updateComponentRingLucky", bigWheelRingLucky);
    }

    /**
     * 更新刮刮卡基本信息
     *
     * @param scaratchCardRingLucy
     */
    public void updateScaratchRingLucky(ScaratchCardRingLucy scaratchCardRingLucy) {
        update("Component.updateScaratchRingLucky", scaratchCardRingLucy);
    }

    /**
     * 更新大转盘奖项信息
     *
     * @param bigWheelRingLuckyPrize
     */
    public void updateComponentRingLuckyPrize(BigWheelRingLuckyPrize bigWheelRingLuckyPrize) {
        update("Component.updateComponentRingLuckyPrize", bigWheelRingLuckyPrize);
    }

    /**
     * 更新刮刮卡奖项信息
     *
     * @param scaratchCardRingLuckyPrize
     */
    public void updateScaratchRingLuckyPrize(ScaratchCardRingLuckyPrize scaratchCardRingLuckyPrize) {
        update("Component.updateScaratchRingLuckyPrize", scaratchCardRingLuckyPrize);
    }

    /**
     * 删除组件
     *
     * @param component
     */
    public void deleteComponent(Component component) {
        delete("Component.deleteComponent", component);
    }

    /**
     * 创建组件
     *
     * @param component
     * @return
     */
    public Integer createComponent(Component component) {
        return (Integer) insert("Component.createComponent", component);
    }

    public void createSurvey(Survey survey) {
        insert("Component.createSurvey", survey);
    }

    public SurveyRes getSurveyContent(Integer componentId) {
        return (SurveyRes) queryForObject("Component.getSurveyContent", componentId);
    }

    public void updateSurvey(Survey survey) {
        update("Component.updateSurvey", survey);
    }
}
