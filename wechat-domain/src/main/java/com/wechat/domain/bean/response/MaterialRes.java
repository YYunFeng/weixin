package com.wechat.domain.bean.response;


import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: ÏÂÎç5:44
 * To change this template use File | Settings | File Templates.
 */
public class MaterialRes {
    private Material material;
    private PicMessage picMessage;
    private List<PicMessage> picMessageList;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<PicMessage> getPicMessageList() {
        return picMessageList;
    }

    public void setPicMessageList(List<PicMessage> picMessageList) {
        this.picMessageList = picMessageList;
    }

    public PicMessage getPicMessage() {
        return picMessage;
    }

    public void setPicMessage(PicMessage picMessage) {
        this.picMessage = picMessage;
    }
}
