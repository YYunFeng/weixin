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
 * Time: ����12:43
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentService {
    /**
     * ��ȡ����б�
     *
     * @param ComponentParameter
     * @return
     */
    List<Component> getComponet(ComponentParameter ComponentParameter);

    /**
     * ������ת��
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    void createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);

    /**
     * �����ιο�
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
     * ���¹ιο���Ϣ
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    void updateScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);

    /**
     * ��ȡ��ת����Ϣ
     *
     * @param componentId
     * @return
     */
    BigWheelComponentRes getBigWheelComponent(Integer componentId);


    /**
     * ��ȡ��ת����Ϣ
     *
     * @param componentId
     * @return
     */
    ScaratchComponentRes getScaratchComponent(Integer componentId);


    /**
     * �����ʾ����
     *
     * @param component
     * @param survey
     */
    void createSurvey(Component component, Survey survey);

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
