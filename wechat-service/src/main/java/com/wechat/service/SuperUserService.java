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
 * Time: ����6:00
 * To change this template use File | Settings | File Templates.
 */
public interface SuperUserService {
    /**
     * ����û���ϸ��Ϣ
     *
     * @return
     */
    PageResultSet<User> getUserContent(SuperUserParameter superUserParameter, Integer flag, int sPage, int pageSize);

    /**
     * �õ������ע����
     *
     * @return
     */
    StatisUserCount getCountToday();

    /**
     * ������־��������־���ͼ�¼
     *
     * @param statisticsLogMessParameter
     * @return
     */
    LogMessageRes logMessCount(StatisticsLogMessParameter statisticsLogMessParameter);
}
