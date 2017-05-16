package com.wechat.dao;

import com.wechat.domain.bean.*;
import com.wechat.domain.bean.response.AutoRespondRes;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public interface AutoRespondDao {
    /**
     * 关键字列表
     * 左侧菜单
     *
     * @param userWeiXin
     * @return
     */
    List<KeyWordLink> getAutoRespond(UserWeiXin userWeiXin);

    /**
     * 创建关键字
     *
     * @param keyWordLink
     */
    Integer createAutoRespond(KeyWordLink keyWordLink);

    /**
     * 更新关键字
     *
     * @param keyWordLink
     */
    void updateAutoRespond(KeyWordLink keyWordLink);

    /**
     * 按ID获得关键字详情
     *
     * @param keyWordLink
     * @return
     */

    AutoRespondRes getAutoRespondById(KeyWordLink keyWordLink);

    /**
     * 删除关键字
     *
     * @param keyWordLink
     */
    void deleteRule(KeyWordLink keyWordLink);

    /**
     * 获取文本资源信息
     *
     * @param textResources
     * @return
     */
    TextResources gerTextResource(TextResources textResources);

    /**
     * 获取关注有奖信息
     *
     * @param weixinId
     * @return
     */
    FoucsLucky getFoucsLucky(Integer weixinId);

    /**
     * 获取微信关联账号
     *
     * @param user
     * @return
     */
    UserWeiXin getUserWeiXin(User user);

    /**
     * 更新文本资源信息
     *
     * @param textResources
     */
    void updateTextResources(TextResources textResources);

    /**
     * 更新被关注有奖信息
     *
     * @param focusLucky
     */
    void updateFoucsLucky(FoucsLucky focusLucky);

    /**
     * 更新用户有奖状态
     *
     * @param userWeiXin
     */
    void updateUserWeiXin(UserWeiXin userWeiXin);

    /**
     * 验证关键字是否存在
     *
     * @param keyWordLink
     * @return
     */
    KeyWordLink autoRule(KeyWordLink keyWordLink);

    /**
     * 将关键字导出成帮助
     *
     * @param weixinId
     * @return
     */
    List<KeyWordLink> exportHelp(Integer weixinId);
}
