package com.wechat.action;



import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.AttentionRes;
import com.wechat.domain.bean.response.AutoRespondHeadAndFootRes;
import com.wechat.domain.bean.response.AutoRespondRes;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.json.SaveAutoRespondJSON;
import com.wechat.domain.json.SaveRuleJSON;
import com.wechat.domain.parameter.ComponentParameter;
import com.wechat.domain.parameter.MaterialListParameter;
import com.wechat.service.AutoRespondService;
import com.wechat.service.ComponentService;
import com.wechat.service.MaterialService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����2:18
 * To change this template use File | Settings | File Templates.
 */
public class AutoRespondAction extends BaseAction {
    private ComponentService componentService;
    private List<Component> componentList;
    private List<KeyWordLink> keyWordLinkList;
    private AutoRespondService autoRespondService;
    private AutoRespondRes autoRespondRes;
    private Integer Id;
    private KeyWordLink keyWordLink;
    private AttentionRes attentionRes;

    private TextResources textResources;
    private FoucsLucky foucsLucky;
    private Integer flag;
    private AutoRespondHeadAndFootRes autoRespondHeadAndFootRes;
    private List<TextResources> textResourcesList;


    private List<MaterialListRes> materialListResList;
    private MaterialService materialService;


    /**
     * �Զ���
     *
     * @return
     */
    public String autoRespond() {
        return SUCCESS;
    }

    /**
     * ����˵�
     *
     * @return
     */
    public String ruleMenu() {
        try {
            UserWeiXin userWeiXin = super.getUserWeiXin();
            keyWordLinkList = autoRespondService.getAutoRespond(userWeiXin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��ID�鿴����
     *
     * @return
     */

    public String ruleContent() {
        try {
            KeyWordLink keyWordLinkParameter = new KeyWordLink();
            keyWordLinkParameter.setId(Id);
            autoRespondRes = autoRespondService.getAutoRespondById(keyWordLinkParameter);
            if (autoRespondRes.getTextResourceMessage() != null) {
                autoRespondRes.setTextResourceMessage(autoRespondRes.getTextResourceMessage().replaceAll("\n", "<br>"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��ȡ����б�
     *
     * @return
     */
    public String componentList() {
        ComponentParameter componentParameter = new ComponentParameter();
        try {
            componentParameter.setUserId(super.getUser().getId());
            componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
            componentList = componentService.getComponet(componentParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��ȡ�ز��б�
     *
     * @return
     */
    public String materialList() {
        MaterialListParameter materialListParameter = new MaterialListParameter();
        try {
            materialListParameter.setWeixinId(super.getUserWeiXin().getId());
            materialListResList = materialService.getMaterialList(materialListParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����µĹ���
     *
     * @return
     */
    public String addNewRule() {
        return SUCCESS;
    }

    /**
     * �����¹���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveRule() throws JSONException, IOException {
        SaveRuleJSON saveRuleJSON = new SaveRuleJSON();
        try {
            saveRuleJSON.setStatus(1); // ��ӳɹ�
            saveRuleJSON.setMess("��ӳɹ�");
            keyWordLink.setWeixinId(super.getUserWeiXin().getId());
            Integer keyLinkId = autoRespondService.createAutoRespond(keyWordLink);
            saveRuleJSON.setKeyLinkId(keyLinkId);
        } catch (Exception e) {
            saveRuleJSON.setMess("���ʧ�ܣ������ԣ�");
            saveRuleJSON.setStatus(0); //���ʧ��
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(saveRuleJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * ����б�
     *
     * @return
     */
    public String modifyRule() {
        KeyWordLink keyWordLinkParemeter = new KeyWordLink();
        try {
            keyWordLinkParemeter.setId(Id);
            // ����
            autoRespondRes = autoRespondService.getAutoRespondById(keyWordLinkParemeter);
            if (autoRespondRes != null) {
                if (autoRespondRes.getLinkType() != null) {
                    if (autoRespondRes.getLinkType().intValue() == 1) {
                        MaterialListParameter materialListParameter = new MaterialListParameter();
                        materialListParameter.setWeixinId(super.getUserWeiXin().getId());
                        //�ز��б�
                        materialListResList = materialService.getMaterialList(materialListParameter);
                    }
                    if (autoRespondRes.getLinkType().intValue() == 2) {
                        ComponentParameter componentParameter = new ComponentParameter();
                        componentParameter.setUserId(super.getUser().getId());
                        componentParameter.setWeixinAccount(super.getUserWeiXin().getWeixinAccount());
                        // ����б�
                        componentList = componentService.getComponet(componentParameter);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �޸Ĺ��� ���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyRule() throws JSONException, IOException {
        SaveRuleJSON SaveRuleJSON = new SaveRuleJSON();
        try {
            SaveRuleJSON.setStatus(1); // ���³ɹ�
            SaveRuleJSON.setMess("���³ɹ�");
            //���ı�
            if (keyWordLink.getLinkType() == 0) {
                keyWordLink.setComponentId(null);
                keyWordLink.setMaterialId(null);
            }
            //�ز�
            if (keyWordLink.getLinkType() == 1) {
                keyWordLink.setMessage(null);
                keyWordLink.setComponentId(null);
            }
            // ���
            if (keyWordLink.getLinkType() == 2) {
                keyWordLink.setMessage(null);
                keyWordLink.setMaterialId(null);
            }
            //  ����ǰ�����Ϣ�������ı���Դ��
            if (textResources.getMessage() != null) {
                autoRespondService.updateTextResources(textResources);
            }
            autoRespondService.updateAutoRespond(keyWordLink);
        } catch (Exception e) {
            SaveRuleJSON.setMess("����ʧ�ܣ������ԣ�");
            SaveRuleJSON.setStatus(0); //����ʧ��
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(SaveRuleJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * ɾ������
     *
     * @throws JSONException
     * @throws IOException
     */
    public void deleteRule() throws JSONException, IOException {
        SaveRuleJSON SaveRuleJSON = new SaveRuleJSON();
        try {
            SaveRuleJSON.setStatus(1);
            autoRespondService.deleteRule(keyWordLink);
        } catch (Exception e) {
            SaveRuleJSON.setStatus(0);
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(SaveRuleJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * ����עʱ
     *
     * @return
     */
    public String attention() {
        // ��ȡ΢���Ƿ��ע��Ϣ
        UserWeiXin userWeiXin = autoRespondService.getUserWeiXin(super.getUser());
        attentionRes = new AttentionRes();
        if (userWeiXin != null) {
            attentionRes.setUserWeiXin(userWeiXin);
            FoucsLucky foucsLucky = autoRespondService.getFoucsLucky(userWeiXin.getId());
            attentionRes.setFoucsLucky(foucsLucky);
            TextResources textResourcesParameter = new TextResources();
            textResourcesParameter.setType(0);
            textResourcesParameter.setWeixinId(userWeiXin.getId());
            TextResources textResources = autoRespondService.getTextResources(textResourcesParameter);
            attentionRes.setTextResources(textResources);
        }
        return SUCCESS;
    }

    /**
     * ����עʱ��  �ظ���Ϣ���
     *
     * @throws IOException
     * @throws JSONException
     */
    public void saveAttention() throws IOException, JSONException {
        // ��ʾ��������
        SaveAutoRespondJSON saveAutoRespondJSON = new SaveAutoRespondJSON();
        UserWeiXin userWeiXin = super.getUserWeiXin();
        try {
            if (flag != null) {
                // ��ע�н��ر�
                if (flag.intValue() == 1) {
                    // ����΢�Ź����˺�Ϊ��ע�н��ر�
                    userWeiXin.setFocusLucky(false);
                    autoRespondService.updateUserWeiXin(userWeiXin);
                    // �����ı���Դ��Ϣ
                    autoRespondService.updateTextResources(textResources);
                    saveAutoRespondJSON.setStatus(1);
                    saveAutoRespondJSON.setMess("����ɹ�");
                }
                // ��ע100%�н� �͹�ע��100%�н�
                if (flag.intValue() == 2) {
                    // ����΢�Ź����˺Ź�ע�н�����
                    userWeiXin.setFocusLucky(true);
                    autoRespondService.updateUserWeiXin(userWeiXin);
                    //���¹�ע�н���Ϣ
                    autoRespondService.updateFoucsLucky(foucsLucky);
                    saveAutoRespondJSON.setStatus(1);
                    saveAutoRespondJSON.setMess("����ɹ�");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            saveAutoRespondJSON.setStatus(0);
            saveAutoRespondJSON.setMess("����ʧ��");
        }

        String json = JSONUtil.serialize(saveAutoRespondJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

    }

    /**
     * �Զ��ظ�
     *
     * @return
     */
    public String respond() {
        try {
            TextResources textResourcesParameter = new TextResources();
            textResourcesParameter.setWeixinId(super.getUserWeiXin().getId());
            textResourcesParameter.setType(1);
            textResources = autoRespondService.getTextResources(textResourcesParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �Զ��ظ�����ҳ��
     *
     * @return
     */
    public String autoRespondHelp() {
        try {
            TextResources textResourcesParameter = new TextResources();
            textResourcesParameter.setWeixinId(super.getUserWeiXin().getId());
            textResourcesParameter.setType(2);
            textResources = autoRespondService.getTextResources(textResourcesParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �Զ��ظ�ҳü��ҳ��ҳ��
     *
     * @return
     */
    public String autoRespondHeadAndFoot() {
        try {
            TextResources textResourcesParameter = new TextResources();
            autoRespondHeadAndFootRes = new AutoRespondHeadAndFootRes();
            textResourcesParameter.setWeixinId(super.getUserWeiXin().getId());
            textResourcesParameter.setType(3);
            TextResources textResourcesHead = autoRespondService.getTextResources(textResourcesParameter);
            textResourcesParameter.setType(4);
            TextResources textResourcesFoot = autoRespondService.getTextResources(textResourcesParameter);
            autoRespondHeadAndFootRes.setTextResourcesHead(textResourcesHead);
            autoRespondHeadAndFootRes.setTextResourcesFoot(textResourcesFoot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * �޸��ı���Դ��Ϣ
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveTextResource() throws JSONException, IOException {
        SaveAutoRespondJSON saveAutoRespondJSON = new SaveAutoRespondJSON();
        try {
            autoRespondService.updateTextResources(textResources);
            saveAutoRespondJSON.setStatus(1);
            saveAutoRespondJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            saveAutoRespondJSON.setStatus(0);
            saveAutoRespondJSON.setMess("�޸�ʧ��");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(saveAutoRespondJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �޸�ҳü��ҳ��
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveHeadAndFoot() throws JSONException, IOException {
        SaveAutoRespondJSON saveAutoRespondJSON = new SaveAutoRespondJSON();
        try {
            if (textResourcesList != null && textResourcesList.size() != 0) {
                for (int i = 0; i < textResourcesList.size(); i++) {
                    autoRespondService.updateTextResources(textResourcesList.get(i));
                }
            }
            saveAutoRespondJSON.setStatus(1);
            saveAutoRespondJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            saveAutoRespondJSON.setStatus(0);
            saveAutoRespondJSON.setMess("�޸�ʧ��");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(saveAutoRespondJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * ��֤�ؼ����Ƿ����
     *
     * @throws JSONException
     * @throws IOException
     */
    public void autoRule() throws JSONException, IOException {
        SaveAutoRespondJSON saveAutoRespondJSON = new SaveAutoRespondJSON();
        try {
            keyWordLink.setWeixinId(super.getUserWeiXin().getId());
            KeyWordLink keyWordRes = autoRespondService.autoRule(keyWordLink);
            if (keyWordRes != null) {
                saveAutoRespondJSON.setStatus(0);
                saveAutoRespondJSON.setMess("�ùؼ����Ѿ����ڣ�");
            } else {
                saveAutoRespondJSON.setStatus(1);
                saveAutoRespondJSON.setMess("�ùؼ��ֿ���ʹ�ã�");
            }
        } catch (Exception e) {
            saveAutoRespondJSON.setStatus(2);
            saveAutoRespondJSON.setMess("ϵͳ����");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(saveAutoRespondJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �����򵼳�������Ϣ
     *
     * @throws JSONException
     * @throws IOException
     */
    public void exportHelp() throws JSONException, IOException {
        String helpMess = "";
        try {
            List<KeyWordLink> keyWordLinks = autoRespondService.exportHelp(super.getUserWeiXin().getId());
            for (KeyWordLink keyWordLink1 : keyWordLinks) {
                helpMess += "�ظ� " + keyWordLink1.getKeyword() + "�� " + keyWordLink1.getRuleName() + "\r\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        helpMess.toString();
        String json = JSONUtil.serialize(helpMess.trim());
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

    public void setKeyWordLinkList(List<KeyWordLink> keyWordLinkList) {
        this.keyWordLinkList = keyWordLinkList;
    }

    public void setAutoRespondService(AutoRespondService autoRespondService) {
        this.autoRespondService = autoRespondService;
    }

    public AutoRespondRes getAutoRespondRes() {
        return autoRespondRes;
    }

    public void setAutoRespondRes(AutoRespondRes autoRespondRes) {
        this.autoRespondRes = autoRespondRes;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<KeyWordLink> getKeyWordLinkList() {
        return keyWordLinkList;
    }

    public KeyWordLink getKeyWordLink() {
        return keyWordLink;
    }

    public void setKeyWordLink(KeyWordLink keyWordLink) {
        this.keyWordLink = keyWordLink;
    }

    public AttentionRes getAttentionRes() {
        return attentionRes;
    }

    public void setAttentionRes(AttentionRes attentionRes) {
        this.attentionRes = attentionRes;
    }

    public TextResources getTextResources() {
        return textResources;
    }

    public void setTextResources(TextResources textResources) {
        this.textResources = textResources;
    }

    public FoucsLucky getFoucsLucky() {
        return foucsLucky;
    }

    public void setFoucsLucky(FoucsLucky foucsLucky) {
        this.foucsLucky = foucsLucky;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public AutoRespondHeadAndFootRes getAutoRespondHeadAndFootRes() {
        return autoRespondHeadAndFootRes;
    }

    public void setAutoRespondHeadAndFootRes(AutoRespondHeadAndFootRes autoRespondHeadAndFootRes) {
        this.autoRespondHeadAndFootRes = autoRespondHeadAndFootRes;
    }

    public List<TextResources> getTextResourcesList() {
        return textResourcesList;
    }

    public void setTextResourcesList(List<TextResources> textResourcesList) {
        this.textResourcesList = textResourcesList;
    }

    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
    }

    public List<MaterialListRes> getMaterialListResList() {

        return materialListResList;
    }

    public void setMaterialListResList(List<MaterialListRes> materialListResList) {
        this.materialListResList = materialListResList;
    }
}
