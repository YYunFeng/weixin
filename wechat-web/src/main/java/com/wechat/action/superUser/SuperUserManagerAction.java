package com.wechat.action.superUser;

import com.wechat.action.BaseAction;
import com.wechat.domain.bean.Page;
import com.wechat.domain.bean.PageResultSet;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.response.LogMessageRes;
import com.wechat.domain.bean.response.StatisUserCount;
import com.wechat.domain.parameter.StatisticsLogMessParameter;
import com.wechat.domain.parameter.SuperUserParameter;
import com.wechat.service.SuperUserService;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-24
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 */
public class SuperUserManagerAction extends BaseAction {

    private SuperUserService superUserService;
    private PageResultSet<User> userList;
    private SuperUserParameter superUserParameter;
    private Integer flag;
    private StatisUserCount statisUserCount;
    private Page pageBean;
    private LogMessageRes logMessageRes;
    private StatisticsLogMessParameter statisticsLogMessParameter;


    // 管理员
    public String superUserHome() {
        statisUserCount = superUserService.getCountToday();
        return SUCCESS;
    }

    /**
     * 取得用户详细信息
     *
     * @return
     */
    public String userContent() {
        try {
            int sPage = Integer.valueOf((String) request.getParameter("page"));
            userList = superUserService.getUserContent(superUserParameter, flag, sPage, new Page().getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String logMessStatistics() {
        try {
            logMessageRes = superUserService.logMessCount(statisticsLogMessParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public void setSuperUserService(SuperUserService superUserService) {
        this.superUserService = superUserService;
    }

    public PageResultSet<User> getUserList() {
        return userList;
    }

    public void setUserList(PageResultSet<User> userList) {
        this.userList = userList;
    }

    public SuperUserParameter getSuperUserParameter() {
        return superUserParameter;
    }

    public void setSuperUserParameter(SuperUserParameter superUserParameter) {
        this.superUserParameter = superUserParameter;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public StatisUserCount getStatisUserCount() {
        return statisUserCount;
    }

    public void setStatisUserCount(StatisUserCount statisUserCount) {
        this.statisUserCount = statisUserCount;
    }

    public Page getPageBean() {
        return pageBean;
    }

    public void setPageBean(Page pageBean) {
        this.pageBean = pageBean;
    }

    public LogMessageRes getLogMessageRes() {
        return logMessageRes;
    }

    public void setLogMessageRes(LogMessageRes logMessageRes) {
        this.logMessageRes = logMessageRes;
    }

    public StatisticsLogMessParameter getStatisticsLogMessParameter() {
        return statisticsLogMessParameter;
    }

    public void setStatisticsLogMessParameter(StatisticsLogMessParameter statisticsLogMessParameter) {
        this.statisticsLogMessParameter = statisticsLogMessParameter;
    }
}
