package com.wechat.dao;


import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.ComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.parameter.ComponentParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 上午11:41
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentDao {
    /**
     * 组件列表
     *
     * @param ComponentParameter
     * @return
     */
    List getComponent(ComponentParameter ComponentParameter);

    /**
     * 创建大转盘
     *
     * @param component
     * @param bigWheelRingLuckyPrizeList
     * @param bigWheelRingLucky
     */
    Integer  createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);


    /**
     * 创建刮刮卡
     *
     * @param component
     * @param scaratchCardRingLuckyPrizeList
     * @param scaratchCardRingLucy
     */
    void createScaratch(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);

    /**
     * 获得大转盘基本信息
     *
     * @param Id
     * @return
     */
    ComponentRes getBigWheelComponent(Integer Id);


    /**
     * 获得刮刮卡基本信息
     *
     * @param Id
     * @return
     */
    ComponentRes getScaratchComponent(Integer Id);


    /**
     * 获取大转盘奖项
     *
     * @param Id
     * @return
     */
    List<ScaratchCardRingLuckyPrize> getScaratchRingLuckyPrize(Integer Id);

    /**
     * 获取大转盘奖项
     *
     * @param Id
     * @return
     */
    List<BigWheelRingLuckyPrize> getComponentRingLuckyPrize(Integer Id);

    /**
     * 更新组件表
     *
     * @param component
     */
    void updateComponent(Component component);

    /**
     * 更新大转盘基本信息表
     *
     * @param bigWheelRingLucky
     */
    void updateComponentRingLucky(BigWheelRingLucky bigWheelRingLucky);


    /**
     * 更新刮刮卡基本信息表
     *
     * @param scaratchCardRingLucy
     */
    void updateScaratchRingLucky(ScaratchCardRingLucy scaratchCardRingLucy);


    /**
     * 更新大转盘奖项表
     *
     * @param bigWheelRingLuckyPrize
     */
    void updateComponentRingLuckyPrize(BigWheelRingLuckyPrize bigWheelRingLuckyPrize);


    /**
     * 更新大转盘奖项表
     *
     * @param scaratchCardRingLuckyPrize
     */
    void updateScaratchRingLuckyPrize(ScaratchCardRingLuckyPrize scaratchCardRingLuckyPrize);

    /**
     * 删除组件
     *
     * @param component
     */
    void deleteComponent(Component component);

    /**
     * 创建组件
     *
     * @param component
     */
    Integer createComponent(Component component);

    /**
     * 创建问卷调查
     *
     * @param survey
     */
    void createSurvey(Survey survey);

    /**
     * 获取问卷调查详情
     *
     * @param componentId
     * @return
     */
    SurveyRes getSurveyContent(Integer componentId);

    /**
     * 更新问卷调查基本信息表
     *
     * @param survey
     */
    void updateSurvey(Survey survey);
}
