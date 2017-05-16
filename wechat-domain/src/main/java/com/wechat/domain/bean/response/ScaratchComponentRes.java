package com.wechat.domain.bean.response;


import com.wechat.domain.bean.ScaratchCardRingLuckyPrize;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-6
 * Time: ÏÂÎç7:46
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchComponentRes {
    private ComponentRes componentRes;
    private List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList;

    public ComponentRes getComponentRes() {
        return componentRes;
    }

    public void setComponentRes(ComponentRes componentRes) {
        this.componentRes = componentRes;
    }

    public List<ScaratchCardRingLuckyPrize> getScaratchCardRingLuckyPrizeList() {
        return scaratchCardRingLuckyPrizeList;
    }

    public void setScaratchCardRingLuckyPrizeList(List<ScaratchCardRingLuckyPrize> scaratchCardRingLuckyPrizeList) {
        this.scaratchCardRingLuckyPrizeList = scaratchCardRingLuckyPrizeList;
    }
}
