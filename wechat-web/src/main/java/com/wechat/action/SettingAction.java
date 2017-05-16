package com.wechat.action;


import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.SaveweixinaccuntRes;
import com.wechat.domain.constant.TextResourcesConstant;
import com.wechat.domain.json.SettingJSON;
import com.wechat.domain.utils.Utils;
import com.wechat.service.AutoRespondService;
import com.wechat.service.RegisterService;
import com.wechat.service.SettingService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: ����3:15
 * To change this template use File | Settings | File Templates.
 */
public class SettingAction extends BaseAction {
    private SettingService settingService;
    private UserWeiXin userWeiXin;
    private User user;
    private SaveweixinaccuntRes saveweixinaccuntRes;
    private RegisterService registerService;
    private AutoRespondService autoRespondService;

    /**
     * ����
     *
     * @return
     */
    public String setting() {
        return SUCCESS;
    }

    /**
     * ΢���˺�����
     *
     * @return
     */
    public String weixinaccountsetting() {
        return SUCCESS;
    }

    /**
     * ����΢���˺�����
     */
    public String saveweixinaccountsetting() {
        user.setId(super.getUser().getId());
        // ��ʼ�� ��ע�н��ر�
        userWeiXin.setFocusLucky(false);
        try {
            Integer weixinId = settingService.saveweixinaccountsetting(user, userWeiXin);
            List<TextResources> textResourcesList = new ArrayList<TextResources>();
            // ��ʼ������ע��Ϣ
            TextResources textResourcesAttention = new TextResources();
            textResourcesAttention.setType(0);
            textResourcesAttention.setWeixinId(weixinId);
            textResourcesAttention.setMessage(TextResourcesConstant.ATTENTIONMESSAGE);
            textResourcesAttention.setAddFooter(false);
            textResourcesAttention.setAddHeader(false);
            textResourcesAttention.setAddHelp(false);
            textResourcesList.add(textResourcesAttention);
            // ��ʼ���Զ��ظ�
            TextResources textResourcesAutoRespond = new TextResources();
            textResourcesAutoRespond.setType(1);
            textResourcesAutoRespond.setWeixinId(weixinId);
            textResourcesAutoRespond.setAddFooter(false);
            textResourcesAutoRespond.setAddHeader(false);
            textResourcesAutoRespond.setAddHelp(false);
            textResourcesAutoRespond.setMessage(TextResourcesConstant.AUTORESPONDMESSAGE);
            textResourcesList.add(textResourcesAutoRespond);
            // ��ʼ������
            TextResources textResourcesHelp = new TextResources();
            textResourcesHelp.setType(2);
            textResourcesHelp.setWeixinId(weixinId);
            textResourcesHelp.setAddFooter(false);
            textResourcesHelp.setAddHeader(false);
            textResourcesHelp.setAddHelp(false);
            textResourcesHelp.setMessage(TextResourcesConstant.HELPMESSAGE);
            Integer helpId = settingService.createTextResource(textResourcesHelp);
            KeyWordLink keyWordLink = new KeyWordLink();
            keyWordLink.setTextResourceId(helpId);
            keyWordLink.setWeixinId(weixinId);
            keyWordLink.setKeyword(TextResourcesConstant.HELPMESSAGE);
            keyWordLink.setLinkType(0);
            keyWordLink.setRuleName(TextResourcesConstant.HELPMESSAGE);
            autoRespondService.createAutoRespond(keyWordLink);

            // ��ʼ����ע�н���Ϣ
            FoucsLucky foucsLucky = new FoucsLucky();
            foucsLucky.setWeixinId(weixinId);
            settingService.createdFoucsLucky(foucsLucky);
            settingService.createTextResource(textResourcesList);
            session.put("weixinmangerweixinaccount", userWeiXin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return interfaceMess();
    }

    /**
     * ��������
     *
     * @return
     */
    public String personMess() {
        User userParameter = new User();
        userParameter.setId(super.getUser().getId());
        user = settingService.getPersonMess(userParameter);
        return SUCCESS;
    }

    /**
     * �ӿ�������Ϣ
     *
     * @return
     */
    public String interfaceMess() {
        userWeiXin = settingService.getInterfaceMess(super.getUserWeiXin());
        return "interfaceMess";
    }

    /**
     * �޸�����
     *
     * @return
     */
    public String modifyPassWord() {
        return SUCCESS;
    }

    /**
     * ��֤�����Ƿ���ȷ
     *
     * @throws IOException
     * @throws JSONException
     */
    public void checkPass() throws IOException, JSONException {
        Integer flag = 0;
        try {
            user.setPassword(Utils.MD5(user.getPassword()));
            user.setUserName(super.getUser().getUserName());
            User autoUser = registerService.authUser(user);
            if (autoUser != null) {
                flag = 1;
            }

        } catch (Exception e) {
            flag = 2;
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(flag);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * �޸�����
     *
     * @throws IOException
     * @throws JSONException
     */
    public void saveModifyPass() throws IOException, JSONException {
        SettingJSON settingJSON = new SettingJSON();
        try {
            user.setId(super.getUser().getId());
            user.setPassword(Utils.MD5(user.getPassword()));
            settingService.modifyPass(user);
            settingJSON.setStatus(1);
            settingJSON.setMess("�޸ĳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            settingJSON.setStatus(0);
            settingJSON.setMess("�޸�ʧ��");
        }
        String json = JSONUtil.serialize(settingJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public void setSettingService(SettingService settingService) {
        this.settingService = settingService;
    }

    public UserWeiXin getUserWeiXin() {
        return userWeiXin;
    }

    public void setUserWeiXin(UserWeiXin userWeiXin) {
        this.userWeiXin = userWeiXin;
    }

    public SaveweixinaccuntRes getSaveweixinaccuntRes() {
        return saveweixinaccuntRes;
    }

    public void setSaveweixinaccuntRes(SaveweixinaccuntRes saveweixinaccuntRes) {
        this.saveweixinaccuntRes = saveweixinaccuntRes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RegisterService getRegisterService() {
        return registerService;
    }

    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void setAutoRespondService(AutoRespondService autoRespondService) {
        this.autoRespondService = autoRespondService;
    }
}
