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
 * Time: ����12:40
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentManager {

    /**
     * ��ȡ����б�
     *
     * @param ComponentParameter
     * @return
     */
    List<Component> getComponent(ComponentParameter ComponentParameter);

    /**
     * ������ת�����
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    Integer  createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);

    /**
     * �����ιο����
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    void createScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);

    /**
     * ɾ�����
     *
     * @param component
     */
    void deleteComponent(Component component);

    /**
     * ���´�ת����Ϣ
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    void updateBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);

    /**
     * ���´�ת����Ϣ
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    void updateScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);


    /**
     * ��ȡ��ת�̻�����Ϣ
     *
     * @param componentId
     * @return
     */
    ComponentRes getComponentRes(Integer componentId);


    /**
     * ��ȡ�ιο�������Ϣ
     *
     * @param componentId
     * @return
     */
    ComponentRes getScaratchComponentRes(Integer componentId);

    /**
     * ��ȡ��ת�̽�����Ϣ
     *
     * @param scaratchId
     * @return
     */
    List<ScaratchCardRingLuckyPrize> getScaratchComponentRingLuckPrize(Integer scaratchId);

    /**
     * ��ȡ��ת�̽�����Ϣ
     *
     * @param luckyringId
     * @return
     */
    List<BigWheelRingLuckyPrize> getComponentRingLuckPrize(Integer luckyringId);

    /**
     * �����ʾ����
     *
     * @param component
     * @param survey
     */
    void createdSurvey(Component component, Survey survey);


    /**
     * ��ȡ�ʾ��������
     *
     * @param componentId
     * @return
     */
    SurveyRes getSurveyContent(Integer componentId);

    /**
     * �����ʾ����
     *
     * @param component
     * @param survey
     */
    void updateSurvey(Component component, Survey survey);
}
