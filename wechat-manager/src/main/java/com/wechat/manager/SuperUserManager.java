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
 * Time: ����5:58
 * To change this template use File | Settings | File Templates.
 */
public interface SuperUserManager {
    /**
     * ����û���ϸ��Ϣ
     *
     * @return
     */
    PageResultSet<User> getUserContent(SuperUserParameter superUserParameter, int sPage, int pageSize);

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
    List<LogMessageRes> logMessCount(StatisticsLogMessParameter statisticsLogMessParameter);
}
