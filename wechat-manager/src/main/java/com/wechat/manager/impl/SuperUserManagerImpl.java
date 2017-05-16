package com.wechat.manager.impl;



import com.wechat.dao.SuperUserDao;
import com.wechat.domain.bean.Page;
import com.wechat.domain.bean.PageResultSet;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.response.LogMessageRes;
import com.wechat.domain.bean.response.StatisUserCount;
import com.wechat.domain.parameter.StatisticsLogMessParameter;
import com.wechat.domain.parameter.SuperUserParameter;
import com.wechat.manager.SuperUserManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-24
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
public class SuperUserManagerImpl implements SuperUserManager {
    private SuperUserDao superUserDao;

    public PageResultSet<User> getUserContent(SuperUserParameter superUserParameter, int sPage, int pageSize) {
        PageResultSet<User> pageResultSet = new PageResultSet<User>();
        try {
            // 获取总条数
            Integer totalRow = superUserDao.getUserContentCount(superUserParameter);
            if (totalRow != 0) {
                Page pages = new Page(totalRow, pageSize, sPage);
                if (superUserParameter == null) {
                    superUserParameter = new SuperUserParameter();
                }
                superUserParameter.setOffset(pages.getBeginIndex());
                superUserParameter.setLimit(pageSize);
                pageResultSet.setList(superUserDao.getUserContent(superUserParameter));
                pageResultSet.setPage(pages);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResultSet;
    }

    public StatisUserCount getCountToday() {
        return superUserDao.getCountToday();
    }

    public List<LogMessageRes> logMessCount(StatisticsLogMessParameter statisticsLogMessParameter) {
        return superUserDao.logMessCount(statisticsLogMessParameter);
    }

    public void setSuperUserDao(SuperUserDao superUserDao) {
        this.superUserDao = superUserDao;
    }
}
