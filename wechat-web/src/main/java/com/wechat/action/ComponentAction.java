package com.wechat.action;

import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.BigWheelComponentRes;
import com.wechat.domain.bean.response.ScaratchComponentRes;
import com.wechat.domain.bean.response.SurveyRes;
import com.wechat.domain.json.ComponentJSON;
import com.wechat.domain.parameter.ComponentParameter;
import com.wechat.service.ComponentService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����11:08
 * To change this template use File | Settings | File Templates.
 */
public class ComponentAction extends BaseAction {

    private ComponentService componentService;
    private List<Component> componentList;
    private Component component;
    private List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList;
    private ScaratchCardRingLucy scaratchCardRingLucy;
    private List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList;
    private BigWheelRingLucky bigWheelRingLucky;
    private Integer componentId;
    private BigWheelComponentRes bigWheelComponentRes;
    private Survey survey;
    private SurveyRes surveyRes;
    private ScaratchComponentRes scaratchComponentRes;
    private Integer flag;
    private Integer keyword_id;

    /**
     * �������
     *
     * @return
     */
    public String componentManager() {
        return SUCCESS;
    }

    /**
     * ��ת�����
     *
     * @return
     */
    public String bigWheelComponent() {
        return SUCCESS;
    }

    /**
     * ��ת��--���� ajax���ý���
     *
     * @return
     */
    public String bigWheelComponentContent() {
        try {
            ComponentParameter componentParameter = new ComponentParameter();
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // ��ת��
            componentParameter.setComponentType(0);
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��Ӵ�ת�����
     *
     * @return
     */
    public String addBigWheelComponent() {
        return SUCCESS;
    }

    /**
     * ��ת�����
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveBigWheelCompont() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            component.setWeixinId(super.getUserWeiXin().getId());
            componentService.createBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
            componentJSON.setStatus(1);
            componentJSON.setMess("����ɹ�");

        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("����ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �޸Ĵ�ת��
     *
     * @return
     */
    public String modifyBigWheelComponent() {
        try {
            bigWheelComponentRes = componentService.getBigWheelComponent(componentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �����޸Ĵ�ת��  ���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyBigWheelComponent() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
            componentJSON.setStatus(1);
            componentJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            componentJSON.setStatus(0);
            componentJSON.setMess("�޸�ʧ��");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * ɾ�����
     *
     * @throws IOException
     * @throws JSONException
     */
    public void deleteComponent() throws IOException, JSONException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.deleteComponent(component);
            componentJSON.setStatus(1);
            componentJSON.setMess("ɾ���ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("ɾ��ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �ʾ����
     *
     * @return
     */
    public String surveyList() {
        return SUCCESS;
    }

    /**
     * �ʾ���� -ajax����ҳ��
     *
     * @return
     */
    public String surveyListContent() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // �ʾ����
            componentParameter.setComponentType(2);
            componentParameter.setSurveyType(0); // �ʾ����
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����ʾ����
     *
     * @return
     */
    public String addSurvey() {
        return SUCCESS;
    }

    /**
     * �ʾ����  --���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveSurvey() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            component.setWeixinId(super.getUserWeiXin().getId());
            survey.setWeixinId(super.getUserWeiXin().getId());
            componentService.createSurvey(component, survey);
            componentJSON.setStatus(1);
            componentJSON.setMess("����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("����ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �޸��ʾ����
     *
     * @return
     */
    public String modifySurvey() {
        try {
            surveyRes = componentService.getSurveyContent(componentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �޸��ʾ���� -- ���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifySurvey() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateSurvey(component, survey);
            componentJSON.setStatus(1);
            componentJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("�޸�ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

    }


    /**
     * �н�����
     *
     * @return
     */
    public String prizeQuizList() {
        return SUCCESS;
    }

    /**
     * �н����� -ajax����ҳ��
     *
     * @return
     */
    public String prizeQuizListListContent() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // �ʾ����
            componentParameter.setComponentType(2);
            componentParameter.setSurveyType(1); // �н�����
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����н�����
     *
     * @return
     */
    public String addPrizeQuiz() {
        return SUCCESS;
    }

    /**
     * �н�����  --���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void savePrizeQuiz() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            component.setWeixinId(super.getUserWeiXin().getId());
            survey.setWeixinId(super.getUserWeiXin().getId());
            componentService.createSurvey(component, survey);
            componentJSON.setStatus(1);
            componentJSON.setMess("����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("����ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �޸��н�����
     *
     * @return
     */
    public String modifyPrizeQuiz() {
        try {
            surveyRes = componentService.getSurveyContent(componentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �޸��н����� -- ���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyPrizeQuiz() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateSurvey(component, survey);
            componentJSON.setStatus(1);
            componentJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("�޸�ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

    }

    /**
     * �ιο�
     *
     * @return
     */
    public String scratchCard() {
        return SUCCESS;
    }

    /**
     * �ιο�-- ajax����
     *
     * @return
     */
    public String scratchCardContent() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // �ʾ����
            componentParameter.setComponentType(1);
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��ӹιο�
     *
     * @return
     */
    public String addScratchCard() {
        return SUCCESS;
    }

    /**
     * �ιο��������
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveScaratchCard() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            component.setWeixinId(super.getUserWeiXin().getId());
            componentService.createScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
            componentJSON.setStatus(1);
            componentJSON.setMess("����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("����ʧ��");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * �޸Ĺιο�
     *
     * @return
     */
    public String modifyScaratchCardComponent() {
        try {
            scaratchComponentRes = componentService.getScaratchComponent(componentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �����޸Ĵ�ת��  ���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyScaratchCardComponent() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
            componentJSON.setStatus(1);
            componentJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            componentJSON.setStatus(0);
            componentJSON.setMess("�޸�ʧ��");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public List<BigWheelRingLuckyPrize> getBigWheelRingLuckyPrizeList() {
        return bigWheelRingLuckyPrizeList;
    }

    public void setBigWheelRingLuckyPrizeList(List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        this.bigWheelRingLuckyPrizeList = bigWheelRingLuckyPrizeList;
    }

    public BigWheelRingLucky getBigWheelRingLucky() {
        return bigWheelRingLucky;
    }

    public void setBigWheelRingLucky(BigWheelRingLucky bigWheelRingLucky) {
        this.bigWheelRingLucky = bigWheelRingLucky;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }


    public BigWheelComponentRes getBigWheelComponentRes() {
        return bigWheelComponentRes;
    }

    public void setBigWheelComponentRes(BigWheelComponentRes bigWheelComponentRes) {
        this.bigWheelComponentRes = bigWheelComponentRes;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public SurveyRes getSurveyRes() {
        return surveyRes;
    }

    public void setSurveyRes(SurveyRes surveyRes) {
        this.surveyRes = surveyRes;
    }

    public ScaratchCardRingLucy getScaratchCardRingLucy() {
        return scaratchCardRingLucy;
    }

    public void setScaratchCardRingLucy(ScaratchCardRingLucy scaratchCardRingLucy) {
        this.scaratchCardRingLucy = scaratchCardRingLucy;
    }

    public List<ScaratchCardRingLuckyPrize> getScaratchCardRingLuckyPrizeList() {
        return scaratchCardRingLuckyPrizeList;
    }

    public void setScaratchCardRingLuckyPrizeList(List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        this.scaratchCardRingLuckyPrizeList = scaratchCardRingLuckyPrizeList;
    }

    public ScaratchComponentRes getScaratchComponentRes() {
        return scaratchComponentRes;
    }

    public void setScaratchComponentRes(ScaratchComponentRes scaratchComponentRes) {
        this.scaratchComponentRes = scaratchComponentRes;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(Integer keyword_id) {
        this.keyword_id = keyword_id;
    }
}
