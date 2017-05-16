package com.wechat.domain.bean.response;


import com.wechat.domain.bean.BigWheelRingLuckyPrize;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-2
 * Time: ÏÂÎç5:32
 * To change this template use File | Settings | File Templates.
 */
public class BigWheelComponentRes {
    private ComponentRes componentRes;
    private List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList;

    public ComponentRes getComponentRes() {
        return componentRes;
    }

    public void setComponentRes(ComponentRes componentRes) {
        this.componentRes = componentRes;
    }

    public List<BigWheelRingLuckyPrize> getBigWheelRingLuckyPrizeList() {
        return bigWheelRingLuckyPrizeList;
    }

    public void setBigWheelRingLuckyPrizeList(List<BigWheelRingLuckyPrize> bigWheelRingLuckyPrizeList) {
        this.bigWheelRingLuckyPrizeList = bigWheelRingLuckyPrizeList;
    }
}
