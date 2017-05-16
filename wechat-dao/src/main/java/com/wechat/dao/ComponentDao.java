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
 * Time: ����11:41
 * To change this template use File | Settings | File Templates.
 */
public interface ComponentDao {
    /**
     * ����б�
     *
     * @param ComponentParameter
     * @return
     */
    List getComponent(ComponentParameter ComponentParameter);

    /**
     * ������ת��
     *
     * @param component
     * @param bigWheelRingLuckyPrizeList
     * @param bigWheelRingLucky
     */
    Integer  createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList);


    /**
     * �����ιο�
     *
     * @param component
     * @param scaratchCardRingLuckyPrizeList
     * @param scaratchCardRingLucy
     */
    void createScaratch(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList);

    /**
     * ��ô�ת�̻�����Ϣ
     *
     * @param Id
     * @return
     */
    ComponentRes getBigWheelComponent(Integer Id);


    /**
     * ��ùιο�������Ϣ
     *
     * @param Id
     * @return
     */
    ComponentRes getScaratchComponent(Integer Id);


    /**
     * ��ȡ��ת�̽���
     *
     * @param Id
     * @return
     */
    List<ScaratchCardRingLuckyPrize> getScaratchRingLuckyPrize(Integer Id);

    /**
     * ��ȡ��ת�̽���
     *
     * @param Id
     * @return
     */
    List<BigWheelRingLuckyPrize> getComponentRingLuckyPrize(Integer Id);

    /**
     * ���������
     *
     * @param component
     */
    void updateComponent(Component component);

    /**
     * ���´�ת�̻�����Ϣ��
     *
     * @param bigWheelRingLucky
     */
    void updateComponentRingLucky(BigWheelRingLucky bigWheelRingLucky);


    /**
     * ���¹ιο�������Ϣ��
     *
     * @param scaratchCardRingLucy
     */
    void updateScaratchRingLucky(ScaratchCardRingLucy scaratchCardRingLucy);


    /**
     * ���´�ת�̽����
     *
     * @param bigWheelRingLuckyPrize
     */
    void updateComponentRingLuckyPrize(BigWheelRingLuckyPrize bigWheelRingLuckyPrize);


    /**
     * ���´�ת�̽����
     *
     * @param scaratchCardRingLuckyPrize
     */
    void updateScaratchRingLuckyPrize(ScaratchCardRingLuckyPrize scaratchCardRingLuckyPrize);

    /**
     * ɾ�����
     *
     * @param component
     */
    void deleteComponent(Component component);

    /**
     * �������
     *
     * @param component
     */
    Integer createComponent(Component component);

    /**
     * �����ʾ����
     *
     * @param survey
     */
    void createSurvey(Survey survey);

    /**
     * ��ȡ�ʾ��������
     *
     * @param componentId
     * @return
     */
    SurveyRes getSurveyContent(Integer componentId);

    /**
     * �����ʾ���������Ϣ��
     *
     * @param survey
     */
    void updateSurvey(Survey survey);
}
