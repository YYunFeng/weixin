package com.wechat.domain.bean.proxy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-4-19
 * Time: обнГ9:04
 * To change this template use File | Settings | File Templates.
 */
public class Articles {

    private List<Item> item;

    public List getItem() {
        return item;
    }

    public void setItem(List item) {
        this.item = item;
    }
}
