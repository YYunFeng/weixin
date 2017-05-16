package com.wechat.manager;

import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.ComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.parameter.ComponentParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午12:40
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentManager {

    /**
     * 获取组件列表
     *
     * @param ComponentParameter
     * @return
     */
    List<Component> getComponent(ComponentParameter ComponentParameter);

    /**
     * 创建大转盘入库
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    Integer  createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);

    /**
     * 创建刮刮卡入库
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    void createScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);

    /**
     * 删除组件
     *
     * @param component
     */
    void deleteComponent(Component component);

    /**
     * 更新大转盘信息
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    void updateBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);

    /**
     * 更新大转盘信息
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    void updateScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);


    /**
     * 获取大转盘基本信息
     *
     * @param componentId
     * @return
     */
    ComponentRes getComponentRes(Integer componentId);


    /**
     * 获取刮刮卡基本信息
     *
     * @param componentId
     * @return
     */
    ComponentRes getScaratchComponentRes(Integer componentId);

    /**
     * 获取大转盘奖项信息
     *
     * @param scaratchId
     * @return
     */
    List<ScaratchCardRingLuckyPrize> getScaratchComponentRingLuckPrize(Integer scaratchId);

    /**
     * 获取大转盘奖项信息
     *
     * @param luckyringId
     * @return
     */
    List<BigWheelRingLuckyPrize> getComponentRingLuckPrize(Integer luckyringId);

    /**
     * 创建问卷调查
     *
     * @param component
     * @param survey
     */
    void createdSurvey(Component component, Survey survey);


    /**
     * 获取问卷调查详情
     *
     * @param componentId
     * @return
     */
    SurveyRes getSurveyContent(Integer componentId);

    /**
     * 更新问卷调查
     *
     * @param component
     * @param survey
     */
    void updateSurvey(Component component, Survey survey);
}
