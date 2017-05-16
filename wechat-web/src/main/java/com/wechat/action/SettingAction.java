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
 * Time: 下午3:15
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
     * 设置
     *
     * @return
     */
    public String setting() {
        return SUCCESS;
    }

    /**
     * 微信账号设置
     *
     * @return
     */
    public String weixinaccountsetting() {
        return SUCCESS;
    }

    /**
     * 保存微信账号设置
     */
    public String saveweixinaccountsetting() {
        user.setId(super.getUser().getId());
        // 初始化 关注有奖关闭
        userWeiXin.setFocusLucky(false);
        try {
            Integer weixinId = settingService.saveweixinaccountsetting(user, userWeiXin);
            List<TextResources> textResourcesList = new ArrayList<TextResources>();
            // 初始化被关注信息
            TextResources textResourcesAttention = new TextResources();
            textResourcesAttention.setType(0);
            textResourcesAttention.setWeixinId(weixinId);
            textResourcesAttention.setMessage(TextResourcesConstant.ATTENTIONMESSAGE);
            textResourcesAttention.setAddFooter(false);
            textResourcesAttention.setAddHeader(false);
            textResourcesAttention.setAddHelp(false);
            textResourcesList.add(textResourcesAttention);
            // 初始化自动回复
            TextResources textResourcesAutoRespond = new TextResources();
            textResourcesAutoRespond.setType(1);
            textResourcesAutoRespond.setWeixinId(weixinId);
            textResourcesAutoRespond.setAddFooter(false);
            textResourcesAutoRespond.setAddHeader(false);
            textResourcesAutoRespond.setAddHelp(false);
            textResourcesAutoRespond.setMessage(TextResourcesConstant.AUTORESPONDMESSAGE);
            textResourcesList.add(textResourcesAutoRespond);
            // 初始化帮助
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

            // 初始化关注有奖信息
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
     * 个人资料
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
     * 接口配置信息
     *
     * @return
     */
    public String interfaceMess() {
        userWeiXin = settingService.getInterfaceMess(super.getUserWeiXin());
        return "interfaceMess";
    }

    /**
     * 修改密码
     *
     * @return
     */
    public String modifyPassWord() {
        return SUCCESS;
    }

    /**
     * 验证密码是否正确
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
     * 修改密码
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
            settingJSON.setMess("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            settingJSON.setStatus(0);
            settingJSON.setMess("修改失败");
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
