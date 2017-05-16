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
 * Time: ����12:42
 * To change this template use File | Settings | File Templates.
 */
public class ComponentManagerImpl implements ComponentManager {
    private ComponentDao componentDao;

    /**
     * �õ�����б�
     *
     * @param ComponentParameter
     * @return
     */
    public List<Component> getComponent(ComponentParameter ComponentParameter) {
        return componentDao.getComponent(ComponentParameter);
    }

    /**
     * ������ת��
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
     * �����ιο�
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
     * ɾ�����
     *
     * @param component
     */
    public void deleteComponent(Component component) {
        componentDao.deleteComponent(component);
    }

    /**
     * ���´�ת����Ϣ
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public void updateBigWheelComponent(Component component, BigWheelRingLucky
            bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        try {
            // ���������
            componentDao.updateComponent(component);
            // ���´�ת�̻�����Ϣ��
            componentDao.updateComponentRingLucky(bigWheelRingLucky);
            // ���´�ת�̽����
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
     * ���¹ιο���Ϣ
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void updateScaratchComponent(Component component, ScaratchCardRingLucy
            scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        try {
            // ���������
            componentDao.updateComponent(component);
            // ���¹ιο�������Ϣ��
            componentDao.updateScaratchRingLucky(scaratchCardRingLucy);
            // ���¹ιο������
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
     * �õ���ת�̻�����Ϣ
     *
     * @param componentId
     * @return
     */
    public ComponentRes getComponentRes(Integer componentId) {
        return componentDao.getBigWheelComponent(componentId);
    }

    /**
     * �õ��ιο�������Ϣ
     *
     * @param componentId
     * @return
     */
    public ComponentRes getScaratchComponentRes(Integer componentId) {
        return componentDao.getScaratchComponent(componentId);
    }

    /**
     * �õ��ιο�������Ϣ
     *
     * @param scaratchId
     * @return
     */
    public List<ScaratchCardRingLuckyPrize> getScaratchComponentRingLuckPrize(Integer scaratchId) {
        return componentDao.getScaratchRingLuckyPrize(scaratchId);
    }

    /**
     * �õ���ת�̽�����Ϣ
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
            // ���������
            componentDao.updateComponent(component);
            // �����ʾ���������Ϣ��
            componentDao.updateSurvey(survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setComponentDao(ComponentDao componentDao) {
        this.componentDao = componentDao;
    }
}
