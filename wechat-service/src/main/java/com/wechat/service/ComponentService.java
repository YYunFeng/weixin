package com.wechat.service;

import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.BigWheelComponentRes;
import com.wechat.domain.bean.response.ScaratchComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.parameter.ComponentParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午12:43
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentService {
    /**
     * 获取组件列表
     *
     * @param ComponentParameter
     * @return
     */
    List<Component> getComponet(ComponentParameter ComponentParameter);

    /**
     * 创建大转盘
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    void createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);

    /**
     * 创建刮刮卡
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
     * 更新刮刮卡信息
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    void updateScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);

    /**
     * 获取大转盘信息
     *
     * @param componentId
     * @return
     */
    BigWheelComponentRes getBigWheelComponent(Integer componentId);


    /**
     * 获取大转盘信息
     *
     * @param componentId
     * @return
     */
    ScaratchComponentRes getScaratchComponent(Integer componentId);


    /**
     * 创建问卷调查
     *
     * @param component
     * @param survey
     */
    void createSurvey(Component component, Survey survey);

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
