package com.wechat.domain.json.proxy;



import com.wechat.domain.bean.proxy.ScaratchCard;
import com.wechat.domain.bean.proxy.ScaratchCardPrize;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-5-13
 * Time: ÏÂÎç3:57
 * To change this template use File | Settings | File Templates.
 */
public class ScaratchCardInitRes {

    private List<ScaratchCardPrize> prizeList;
    private ScaratchCard scaratchCard;
    private Integer userReserveCount;


    public Integer getUserReserveCount() {
        return userReserveCount;
    }

    public void setUserReserveCount(Integer userReserveCount) {
        this.userReserveCount = userReserveCount;
    }

    public List<ScaratchCardPrize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<ScaratchCardPrize> prizeList) {
        this.prizeList = prizeList;
    }

    public ScaratchCard getScaratchCard() {
        return scaratchCard;
    }

    public void setScaratchCard(ScaratchCard scaratchCard) {
        this.scaratchCard = scaratchCard;
    }
}
