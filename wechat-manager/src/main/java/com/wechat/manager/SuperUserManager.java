package com.wechat.manager;



import com.wechat.domain.bean.PageResultSet;
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
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
public interface SuperUserManager {
    /**
     * 获得用户详细信息
     *
     * @return
     */
    PageResultSet<User> getUserContent(SuperUserParameter superUserParameter, int sPage, int pageSize);

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
