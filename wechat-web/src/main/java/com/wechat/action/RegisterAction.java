package com.wechat.action;

import com.wechat.domain.bean.User;
import com.wechat.domain.json.RegisterJSON;
import com.wechat.service.RegisterService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: 上午11:26
 * To change this template use File | Settings | File Templates.
 */
public class RegisterAction extends BaseAction {

    private RegisterService registerService;
    private User user;
    private String userName;

    // 注册页面
    public String register() {
        return SUCCESS;
    }


    //注册用户
    public void addRegister() throws JSONException, IOException {
        RegisterJSON registerJSON = new RegisterJSON();
        try {
            registerService.createUser(user);
            registerJSON.setStatus(1);
            registerJSON.setMess("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            registerJSON.setStatus(0);
            registerJSON.setMess("注册失败");
        }
        String json = JSONUtil.serialize(registerJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 验证用户是否存在
     */
    public void authUser() throws IOException, JSONException {
        User user = new User();
        user.setUserName(userName);
        User userRes = registerService.authUser(user);
        Integer res = 0;
        if (userRes != null) {
            res = 1;
        }
        String json = JSONUtil.serialize(res);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
