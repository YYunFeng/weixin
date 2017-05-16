package com.wechat.service;


import com.wechat.domain.bean.PageResultSet;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.response.LogMessageRes;
import com.wechat.domain.bean.response.StatisUserCount;
import com.wechat.domain.parameter.StatisticsLogMessParameter;
import com.wechat.domain.parameter.SuperUserParameter;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-24
 * Time: 下午6:00
 * To change this template use File | Settings | File Templates.
 */
public interface SuperUserService {
    /**
     * 获得用户详细信息
     *
     * @return
     */
    PageResultSet<User> getUserContent(SuperUserParameter superUserParameter, Integer flag, int sPage, int pageSize);

    /**
     * 得到今天的注册量
     *
     * @return
     */
    StatisUserCount getCountToday();

    /**
     * 上行日志和下行日志发送记录
     *
     * @param statisticsLogMessParameter
     * @return
     */
    LogMessageRes logMessCount(StatisticsLogMessParameter statisticsLogMessParameter);
}
