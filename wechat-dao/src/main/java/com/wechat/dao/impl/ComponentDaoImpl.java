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
 * Time: ����12:38
 * To change this template use File | Settings | File Templates.
 */
public class ComponentDaoImpl extends BaseDao implements ComponentDao {

    public List getComponent(ComponentParameter ComponentParameter) {
        return queryForList("Component.getCompontent", ComponentParameter);
    }

    /**
     * ������ת��
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public Integer createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        // ���������
        Integer componentId = 0;
        try {
            componentId = (Integer) insert("Component.createComponent", component);
            // �����ת����Ϣ��
            bigWheelRingLucky.setComponentId(componentId);
            Integer componentRingLuckyId = (Integer) insert("Component.createComponentRingLucky", bigWheelRingLucky);
            // �����ת�̽�����Ϣ
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
     * �����ιο�
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void createScaratch(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        // ���������
        Integer componentId = (Integer) insert("Component.createComponent", component);
        // ����ιο���Ϣ��
        scaratchCardRingLucy.setComponentId(componentId);
        Integer componentRingLuckyId = (Integer) insert("Component.createScaratchRingLucky", scaratchCardRingLucy);
        // ����ιο�������Ϣ
        for (int i = 0; i < scaratchCardRingLuckyPrizeList.size(); i++) {
            scaratchCardRingLuckyPrizeList.get(i).setScaratchId(componentRingLuckyId);
            insert("Component.createScaratchRingLuckyPrize", scaratchCardRingLuckyPrizeList.get(i));
        }
    }

    /**
     * ��ȡ��ת����ϸ������Ϣ
     *
     * @param Id
     * @return
     */
    public ComponentRes getBigWheelComponent(Integer Id) {
        return (ComponentRes) queryForObject("Component.getBigWheelComponent", Id);
    }

    /**
     * ��ȡ�ιο���ϸ������Ϣ
     *
     * @param Id
     * @return
     */
    public ComponentRes getScaratchComponent(Integer Id) {
        return (ComponentRes) queryForObject("Component.getScaratchComponent", Id);
    }

    /**
     * ��ȡ�ιο�������Ϣ
     *
     * @param Id
     * @return
     */
    public List<ScaratchCardRingLuckyPrize> getScaratchRingLuckyPrize(Integer Id) {
        return queryForList("Component.getScaratchRingLuckyPrize", Id);
    }

    /**
     * ��ȡ��ת�̽�����Ϣ
     *
     * @param Id
     * @return
     */
    public List<BigWheelRingLuckyPrize> getComponentRingLuckyPrize(Integer Id) {
        return queryForList("Component.getComponentRingLuckyPrize", Id);
    }

    /**
     * �������
     *
     * @param component
     */
    public void updateComponent(Component component) {
        update("Component.updateComponent", component);
    }

    /**
     * ���´�ת�̻�����Ϣ
     *
     * @param bigWheelRingLucky
     */
    public void updateComponentRingLucky(BigWheelRingLucky bigWheelRingLucky) {
        update("Component.updateComponentRingLucky", bigWheelRingLucky);
    }

    /**
     * ���¹ιο�������Ϣ
     *
     * @param scaratchCardRingLucy
     */
    public void updateScaratchRingLucky(ScaratchCardRingLucy scaratchCardRingLucy) {
        update("Component.updateScaratchRingLucky", scaratchCardRingLucy);
    }

    /**
     * ���´�ת�̽�����Ϣ
     *
     * @param bigWheelRingLuckyPrize
     */
    public void updateComponentRingLuckyPrize(BigWheelRingLuckyPrize bigWheelRingLuckyPrize) {
        update("Component.updateComponentRingLuckyPrize", bigWheelRingLuckyPrize);
    }

    /**
     * ���¹ιο�������Ϣ
     *
     * @param scaratchCardRingLuckyPrize
     */
    public void updateScaratchRingLuckyPrize(ScaratchCardRingLuckyPrize scaratchCardRingLuckyPrize) {
        update("Component.updateScaratchRingLuckyPrize", scaratchCardRingLuckyPrize);
    }

    /**
     * ɾ�����
     *
     * @param component
     */
    public void deleteComponent(Component component) {
        delete("Component.deleteComponent", component);
    }

    /**
     * �������
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
