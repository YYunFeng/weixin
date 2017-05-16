package com.wechat.service;

import com.wechat.domain.bean.FoucsLucky;
import com.wechat.domain.bean.TextResources;
import com.wechat.domain.bean.User;
import com.wechat.domain.bean.UserWeiXin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public interface SettingService {
    /**
     * 关联微信账号 并且返回Id,更新用户账号信息
     *
     * @param user
     * @param userWeiXin
     * @return
     */
    Integer saveweixinaccountsetting(User user, UserWeiXin userWeiXin);

    /**
     * 获得个人基本信息
     *
     * @param user
     * @return
     */
    User getPersonMess(User user);

    /**
     * 获得个人接口信息
     *
     * @param userWeiXin
     * @return
     */
    UserWeiXin getInterfaceMess(UserWeiXin userWeiXin);

    /**
     * 批量创建文本信息
     *
     * @param textResourcesList
     */
    void createTextResource(List<TextResources> textResourcesList);

    /**
     * 创建单条文本信息
     *
     * @param textResources
     * @return
     */
    Integer createTextResource(TextResources textResources);

    /**
     * 创建被关注有奖信息
     *
     * @param focusLucky
     */
    void createdFoucsLucky(FoucsLucky focusLucky);

    /**
     * 修改密码
     *
     * @param user
     */
    void modifyPass(User user);


}
