package com.wechat.dao.impl;


import com.wechat.dao.BaseDao;
import com.wechat.dao.SuperUserDao;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.response.LogMessageRes;
import com.wechat.domain.bean.response.StatisUserCount;
import com.wechat.domain.parameter.StatisticsLogMessParameter;
import com.wechat.domain.parameter.SuperUserParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-24
 * Time: ÏÂÎç5:52
 */
public class SuperUserDaoImpl extends BaseDao implements SuperUserDao {
    public List<User> getUserContent(SuperUserParameter superUserParameter) {
        return queryForList("SuperUser.getUserContent", superUserParameter);
    }

    public Integer getUserContentCount(SuperUserParameter superUserParameter) {
        return (Integer) queryForObject("SuperUser.getUserContentCount", superUserParameter);
    }

    public StatisUserCount getCountToday() {
        return (StatisUserCount) queryForObject("SuperUser.getCountToday");
    }

    public List<LogMessageRes> logMessCount(StatisticsLogMessParameter statisticsLogMessParameter) {
        return queryForList("SuperUser.logMessCount", statisticsLogMessParameter);
    }
}
