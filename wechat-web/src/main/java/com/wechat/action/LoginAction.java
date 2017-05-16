package com.wechat.action;

import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.domain.json.LoginJSON;
import com.wechat.service.HomeService;
import com.wechat.service.RegisterService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-1-10
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends BaseAction {

    private User user;
    private Integer rememberFlag;
    private RegisterService registerService;
    private HomeService homeService;

    public String index() {
        return LOGIN;
    }

    public String login() {
        return LOGIN;
    }

    public void checkLogin() throws IOException, JSONException {
        User loginUser = registerService.authUser(user);
        LoginJSON loginJSON = new LoginJSON();
        try {
            if (loginUser != null) {
                session.put("weixinmanagersessionuser", loginUser);
                List<UserWeiXin> userWeiXinList = homeService.authRelevanceWeixinAccount(loginUser);
                // 登录成功
                loginJSON.setMess("登录成功");
                loginJSON.setStatus(1);
                if (userWeiXinList == null || userWeiXinList.size() == 0) {
                    session.put("weixinmangerweixinaccount", null);
                } else {
                    session.put("weixinmangerweixinaccount", userWeiXinList.get(0));
                }
                if (rememberFlag != null) {
                    if (rememberFlag.intValue() == 1) {  // 记住密码
                        addCookie(response, user);
                    }
                    if (rememberFlag.intValue() == 0) { // 去除记住密码
                        deleteCookies(response);
                    }
                }
                // 超级管理员
                if (loginUser.getSuperUser()) {
                    loginJSON.setSuperUser(true);
                } else {
                    loginJSON.setSuperUser(false);
                }
            } else {
                loginJSON.setMess("用户名或密码错误");
                loginJSON.setStatus(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            loginJSON.setMess("系统错误");
            loginJSON.setStatus(2);
        }
        String json = JSONUtil.serialize(loginJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 登出
     *
     * @return
     */
    public void logout() throws JSONException, IOException {
        session.clear();
        String json = JSONUtil.serialize(1);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public Integer getRememberFlag() {
        return rememberFlag;
    }

    public void setRememberFlag(Integer rememberFlag) {
        this.rememberFlag = rememberFlag;
    }

    public HomeService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }
}
