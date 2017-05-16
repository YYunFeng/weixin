package com.wechat.domain.json.proxy;

import com.wechat.domain.bean.proxy.ComponentRingLucky;
import com.wechat.domain.bean.proxy.ComponentRingLuckyPrize;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: ÏÂÎç10:23
 * To change this template use File | Settings | File Templates.
 */
public class LuckyRingInitRes {

    private List<ComponentRingLuckyPrize> prizeList;
    private ComponentRingLucky componentRingLucky;
    private Integer userReserveCount;


    public ComponentRingLucky getComponentRingLucky() {
        return componentRingLucky;
    }

    public void setComponentRingLucky(ComponentRingLucky componentRingLucky) {
        this.componentRingLucky = componentRingLucky;
    }

    public Integer getUserReserveCount() {
        return userReserveCount;
    }

    public void setUserReserveCount(Integer userReserveCount) {
        this.userReserveCount = userReserveCount;
    }

    public List<ComponentRingLuckyPrize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<ComponentRingLuckyPrize> prizeList) {
        this.prizeList = prizeList;
    }
}
