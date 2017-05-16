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
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ÏÂÎç6:10
 * To change this template use File | Settings | File Templates.
 */
public class RelevanceWeixinAccountIntercept extends MethodFilterInterceptor {
    private HomeService homeService;

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        try {
            ActionContext actionContext = actionInvocation.getInvocationContext();
            Map session = actionContext.getContext().getSession();
            User user = (User) session.get("weixinmanagersessionuser");
            if (user.getUserType() != 1) {
                List<UserWeiXin> userWeiXinList = homeService.authRelevanceWeixinAccount(user);
                if (userWeiXinList != null) {
                    if (userWeiXinList.size() == 0) {
                        return "setting";
                    } else {
                        session.put("weixinmangerweixinaccount", userWeiXinList.get(0));
                    }
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
