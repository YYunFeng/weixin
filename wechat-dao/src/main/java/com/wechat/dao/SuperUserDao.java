package com.wechat.dao;



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
 * Time: 下午5:52
 * To change this template use File | Settings | File Templates.
 */
public interface SuperUserDao {
    /**
     * 获得用户详细信息
     *
     * @return
     */
    List<User> getUserContent(SuperUserParameter superUserParameter);

    /**
     * 得到用户条数
     *
     * @param superUserParameter
     * @return
     */
    Integer getUserContentCount(SuperUserParameter superUserParameter);

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
    List<LogMessageRes> logMessCount(StatisticsLogMessParameter statisticsLogMessParameter);
}
