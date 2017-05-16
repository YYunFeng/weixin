package com.wechat.service;


import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.bean.response.MaterialRes;
import com.wechat.domain.parameter.MaterialListParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-6
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public interface MaterialService {

    /**
     * 获得素材详细信息
     *
     * @param materialParameter
     * @return
     */
    MaterialRes getMaterialConent(Material materialParameter);

    /**
     * 获取素材列表
     *
     * @param materialListParameter
     * @return
     */
    List<MaterialListRes> getMaterialList(MaterialListParameter materialListParameter);


    /**
     * 创建单图文信息
     *
     * @param material
     * @param picMessage
     */
    void saveSinglePicMessageText(Material material, PicMessage picMessage);

    /**
     * 创建多图文信息
     *
     * @param material
     * @param picMessageList
     */
    void saveManyPicMessageText(Material material, List<PicMessage> picMessageList);


    /**
     * 删除素材
     *
     * @param id
     */
    void deleteMaterial(Integer id);

    /**
     * 更新图文信息
     *
     * @param picMessage
     */
    void updatePicMessage(PicMessage picMessage, List<PicMessage> picMessageList);
}
