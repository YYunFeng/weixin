package com.wechat.service.impl;


import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.BigWheelComponentRes;
import com.wechat.domain.bean.response.ComponentRes;
import com.wechat.domain.bean.response.ScaratchComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.domain.parameter.ComponentParameter;
import com.wechat.manager.ComponentManager;
import com.wechat.service.ComponentService;
import com.wechat.domain.utils.PathsUtil;


import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����12:44
 * To change this template use File | Settings | File Templates.
 */
public class ComponentServiceImpl implements ComponentService {
    private ComponentManager componentManager;
    private PathsUtil pathsUtil;

    /**
     * ��ȡ����б�
     *
     * @param ComponentParameter
     * @return
     */
    public List<Component> getComponet(ComponentParameter ComponentParameter) {
        List<Component> componentList = componentManager.getComponent(ComponentParameter);
        for (Component component : componentList) {
            component.setPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + component.getPic());
            component.setExpired(false);
            if (component.getEndTime() != null) {
                if (component.getEndTime().before(new Date())) {
                    component.setExpired(true);
                }
            }
        }
        return componentList;
    }

    /**
     * ������ת��
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public void createBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        Integer componentId = componentManager.createBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
    }

    /**
     * �����ιο�
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void createScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        componentManager.createScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
    }

    /**
     * ɾ�����
     *
     * @param component
     */
    public void deleteComponent(Component component) {
        componentManager.deleteComponent(component);
    }

    /**
     * ���´�ת��
     *
     * @param component
     * @param bigWheelRingLucky
     * @param bigWheelRingLuckyPrizeList
     */
    public void updateBigWheelComponent(Component component, BigWheelRingLucky bigWheelRingLucky, List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        componentManager.updateBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
    }

    /**
     * ���¹ιο�
     *
     * @param component
     * @param scaratchCardRingLucy
     * @param scaratchCardRingLuckyPrizeList
     */
    public void updateScaratchComponent(Component component, ScaratchCardRingLucy scaratchCardRingLucy, List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        componentManager.updateScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
    }

    /**
     * ��ȡ��ת����ϸ��Ϣ
     *
     * @param componentId
     * @return
     */
    public BigWheelComponentRes getBigWheelComponent(Integer componentId) {
        BigWheelComponentRes bigWheelComponentRes = new BigWheelComponentRes();
        try {
            // ��ȡ��ת�̻�����Ϣ
            ComponentRes componentRes = componentManager.getComponentRes(componentId);
            componentRes.setPicPath(componentRes.getPic());
            // ͼƬ���ʵ�ַ
            componentRes.setPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + componentRes.getPic());
            bigWheelComponentRes.setComponentRes(componentRes);
            // ��ȡ��ת�̽�����Ϣ
            List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList = componentManager.getComponentRingLuckPrize(componentRes.getComponentLuckyId());
            bigWheelComponentRes.setBigWheelRingLuckyPrizeList(bigWheelRingLuckyPrizeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigWheelComponentRes;
    }

    /**
     * ��ùιο���ϸ��Ϣ
     *
     * @param componentId
     * @return
     */
    public ScaratchComponentRes getScaratchComponent(Integer componentId) {
        ScaratchComponentRes scaratchComponentRes = new ScaratchComponentRes();
        try {
            // ��ȡ��ת�̻�����Ϣ
            ComponentRes componentRes = new ComponentRes();
            componentRes = componentManager.getScaratchComponentRes(componentId);
            componentRes.setPicPath(componentRes.getPic());
            // ͼƬ���ʵ�ַ
            componentRes.setPic(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + componentRes.getPic());
            scaratchComponentRes.setComponentRes(componentRes);
            // ��ȡ��ת�̽�����Ϣ
            List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList = componentManager.getScaratchComponentRingLuckPrize(componentRes.getComponentLuckyId());
            scaratchComponentRes.setScaratchCardRingLuckyPrizeList(scaratchCardRingLuckyPrizeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scaratchComponentRes;
    }

    /**
     * �����ʾ����
     *
     * @param component
     * @param survey
     */
    public void createSurvey(Component component, Survey survey) {
        try {
            componentManager.createdSurvey(component, survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SurveyRes getSurveyContent(Integer componentId) {
        SurveyRes surveyRes = new SurveyRes();
        try {
            surveyRes = componentManager.getSurveyContent(componentId);
            surveyRes.setPicPath(pathsUtil.getVisitUrl() + PicCatalogueConstant.COMPONET + surveyRes.getPic());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surveyRes;
    }

    public void updateSurvey(Component component, Survey survey) {
        try {
            componentManager.updateSurvey(component, survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setComponentManager(ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }


}
