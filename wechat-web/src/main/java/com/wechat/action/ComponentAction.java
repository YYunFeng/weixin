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
 * Time: 上午11:08
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
     * 组件管理
     *
     * @return
     */
    public String componentManager() {
        return SUCCESS;
    }

    /**
     * 大转盘组件
     *
     * @return
     */
    public String bigWheelComponent() {
        return SUCCESS;
    }

    /**
     * 大转盘--内容 ajax调用界面
     *
     * @return
     */
    public String bigWheelComponentContent() {
        try {
            ComponentParameter componentParameter = new ComponentParameter();
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // 大转盘
            componentParameter.setComponentType(0);
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 添加大转盘组件
     *
     * @return
     */
    public String addBigWheelComponent() {
        return SUCCESS;
    }

    /**
     * 大转盘入库
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
            componentJSON.setMess("保存成功");

        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("保存失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 修改大转盘
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
     * 保存修改大转盘  入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyBigWheelComponent() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateBigWheelComponent(component, bigWheelRingLucky, bigWheelRingLuckyPrizeList);
            componentJSON.setStatus(1);
            componentJSON.setMess("修改成功");
        } catch (Exception e) {
            componentJSON.setStatus(0);
            componentJSON.setMess("修改失败");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * 删除组件
     *
     * @throws IOException
     * @throws JSONException
     */
    public void deleteComponent() throws IOException, JSONException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.deleteComponent(component);
            componentJSON.setStatus(1);
            componentJSON.setMess("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("删除失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 问卷调查
     *
     * @return
     */
    public String surveyList() {
        return SUCCESS;
    }

    /**
     * 问卷调查 -ajax调用页面
     *
     * @return
     */
    public String surveyListContent() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // 问卷调查
            componentParameter.setComponentType(2);
            componentParameter.setSurveyType(0); // 问卷调查
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 添加问卷调查
     *
     * @return
     */
    public String addSurvey() {
        return SUCCESS;
    }

    /**
     * 问卷调查  --入库
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
            componentJSON.setMess("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("保存失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 修改问卷调查
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
     * 修改问卷调查 -- 入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifySurvey() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateSurvey(component, survey);
            componentJSON.setStatus(1);
            componentJSON.setMess("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("修改失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

    }


    /**
     * 有奖竞猜
     *
     * @return
     */
    public String prizeQuizList() {
        return SUCCESS;
    }

    /**
     * 有奖竞猜 -ajax调用页面
     *
     * @return
     */
    public String prizeQuizListListContent() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // 问卷调查
            componentParameter.setComponentType(2);
            componentParameter.setSurveyType(1); // 有奖竞答
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 添加有奖竞答
     *
     * @return
     */
    public String addPrizeQuiz() {
        return SUCCESS;
    }

    /**
     * 有奖竞答  --入库
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
            componentJSON.setMess("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("保存失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 修改有奖竞答
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
     * 修改有奖竞答 -- 入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyPrizeQuiz() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateSurvey(component, survey);
            componentJSON.setStatus(1);
            componentJSON.setMess("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("修改失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

    }

    /**
     * 刮刮卡
     *
     * @return
     */
    public String scratchCard() {
        return SUCCESS;
    }

    /**
     * 刮刮卡-- ajax调用
     *
     * @return
     */
    public String scratchCardContent() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            // 问卷调查
            componentParameter.setComponentType(1);
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 添加刮刮卡
     *
     * @return
     */
    public String addScratchCard() {
        return SUCCESS;
    }

    /**
     * 刮刮卡保存入库
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
            componentJSON.setMess("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            componentJSON.setStatus(0);
            componentJSON.setMess("保存失败");
        }
        String json = JSONUtil.serialize(componentJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * 修改刮刮卡
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
     * 保存修改大转盘  入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyScaratchCardComponent() throws JSONException, IOException {
        ComponentJSON componentJSON = new ComponentJSON();
        try {
            componentService.updateScaratchComponent(component, scaratchCardRingLucy, scaratchCardRingLuckyPrizeList);
            componentJSON.setStatus(1);
            componentJSON.setMess("修改成功");
        } catch (Exception e) {
            componentJSON.setStatus(0);
            componentJSON.setMess("修改失败");
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
