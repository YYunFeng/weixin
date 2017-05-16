package com.wechat.service.impl;


import com.wechat.domain.bean.PageResultSet;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.response.LogMessageRes;
import com.wechat.domain.bean.response.StatisUserCount;
import com.wechat.domain.parameter.StatisticsLogMessParameter;
import com.wechat.domain.parameter.SuperUserParameter;
import com.wechat.manager.SuperUserManager;
import com.wechat.service.SuperUserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-24
 * Time: 下午6:00
 * To change this template use File | Settings | File Templates.
 */
public class SuperUserServiceImpl implements SuperUserService {
    private SuperUserManager superUserManager;

    public PageResultSet<User> getUserContent(SuperUserParameter superUserParameter, Integer flag, int sPage, int pageSize) {
        PageResultSet<User> userList = new PageResultSet<User>();
        try {
            if (flag != null) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                String endTime = sd.format(new Date());
                String startTime = null;
                Calendar c = Calendar.getInstance();
                Date date = new Date();
                if (flag.intValue() == 0) { // 最近三天
                    c.setTime(date);
                    int day = c.get(Calendar.DATE);
                    c.set(Calendar.DATE, day - 3);
                    startTime = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                }
                if (flag.intValue() == 1) { // 最近五天
                    c.setTime(date);
                    int day = c.get(Calendar.DATE);
                    c.set(Calendar.DATE, day - 5);
                    startTime = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                }
                if (flag.intValue() == 2) { // 最近七天
                    c.setTime(date);
                    int day = c.get(Calendar.DATE);
                    c.set(Calendar.DATE, day - 7);
                    startTime = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                }
                if (superUserParameter == null) {
                    superUserParameter = new SuperUserParameter();
                }
                superUserParameter.setStartTime(startTime);
                superUserParameter.setEndTime(endTime);

            }
            userList = superUserManager.getUserContent(superUserParameter, sPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public StatisUserCount getCountToday() {
        return superUserManager.getCountToday();
    }

    public LogMessageRes logMessCount(StatisticsLogMessParameter statisticsLogMessParameter) {
        List<LogMessageRes> logMessageResList = new ArrayList<LogMessageRes>();
        LogMessageRes logMessageRes = new LogMessageRes();
        try {
            logMessageResList = superUserManager.logMessCount(statisticsLogMessParameter);
            StringBuffer upstreamCountRes = new StringBuffer();
            StringBuffer downstreamCountRes = new StringBuffer();
            StringBuffer dateRes = new StringBuffer();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            if (logMessageResList != null && logMessageResList.size() != 0) {
                for (LogMessageRes logMessageResTmp : logMessageResList) {
                    upstreamCountRes.append(logMessageResTmp.getUpstreamCount() + ",");
                    downstreamCountRes.append(logMessageResTmp.getDownstreamCount() + ",");
                    dateRes.append("'" + formatter.format(logMessageResTmp.getCreated()) + "',");
                }
                logMessageRes.setId(logMessageResList.get(0).getId());
                logMessageRes.setUpstreamCountRes(upstreamCountRes.toString());
                logMessageRes.setDownstreamCountRes(downstreamCountRes.toString());
                logMessageRes.setDateRes(dateRes.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logMessageRes;
    }

    public void setSuperUserManager(SuperUserManager superUserManager) {
        this.superUserManager = superUserManager;
    }
}
