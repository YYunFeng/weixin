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
 * Time: ����5:52
 * To change this template use File | Settings | File Templates.
 */
public interface SuperUserDao {
    /**
     * ����û���ϸ��Ϣ
     *
     * @return
     */
    List<User> getUserContent(SuperUserParameter superUserParameter);

    /**
     * �õ��û�����
     *
     * @param superUserParameter
     * @return
     */
    Integer getUserContentCount(SuperUserParameter superUserParameter);

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
