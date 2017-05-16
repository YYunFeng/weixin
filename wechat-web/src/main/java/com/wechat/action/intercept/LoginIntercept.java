package com.wechat.action.intercept;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;
import com.wechat.service.HomeService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-1-11
 * Time: 下午2:34
 * To change this template use File | Settings | File Templates.
 */
public class LoginIntercept extends MethodFilterInterceptor {
    private HomeService homeService;

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        try {
            ActionContext actionContext = actionInvocation.getInvocationContext();
            Map session = actionContext.getContext().getSession();
            User user = (User) session.get("weixinmanagersessionuser");
            UserWeiXin userWeiXin = (UserWeiXin) session.get("weixinmangerweixinaccount");

            // 判断是否填写关联用户账号
            if (user == null) {
                return "login";
            } else if (!user.getSuperUser() && userWeiXin == null) {
                List<UserWeiXin> userWeiXinList = homeService.authRelevanceWeixinAccount(user);
                if (userWeiXinList.size() == 0) {
                    if (!actionInvocation.getInvocationContext().getName().equals("setting"))
                        return "setting";
                    else
                        return actionInvocation.invoke();
                } else {
                    session.put("weixinmangerweixinaccount", userWeiXinList.get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actionInvocation.invoke();
    }

    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }
}
