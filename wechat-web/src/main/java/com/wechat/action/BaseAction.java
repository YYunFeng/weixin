package com.wechat.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-1-10
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public SessionMap session;


    public void setSession(Map map) {
        this.session = (SessionMap) map;
    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    public User getUser() {
        return (User) session.get("weixinmanagersessionuser");
    }

    public UserWeiXin getUserWeiXin() {
        return (UserWeiXin) session.get("weixinmangerweixinaccount");
    }

    /**
     * 添加Cookies
     *
     * @param response
     * @param user
     */
    public void addCookie(HttpServletResponse response, User user) {
        try {
            Cookie user_cookie = new Cookie("weixinmanagersessionuserCookies", user.getUserName() + "," + user.getPassword());
            user_cookie.setMaxAge(99999);
            response.addCookie(user_cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除cookies
     *
     * @param response
     */
    public void deleteCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("weixinmanagersessionuserCookies", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public User getCookie(HttpServletRequest request) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            user = new User();
            for (int i = 0; i < cookies.length; i++) {
                if ("weixinmanagersessionuserCookies".equals(cookies[i].getName())) {
                    String userMess = cookies[i].getValue();
                    user.setUserName(userMess.split(",")[0]);
                    user.setPassword(userMess.split(",")[1]);
                }
            }
        }
        return user;
    }

    /**
     * 当前页
     */
    protected int page;

    public void setPage(int page) {
        if (page <= 0) {
            page = 1;
        }
        this.page = page;
    }

    public int getPage() {
        return page;
    }

}
