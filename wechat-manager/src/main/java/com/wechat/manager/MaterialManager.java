package com.wechat.manager;


import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.parameter.MaterialListParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-6
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public interface MaterialManager {
    /**
     * 获得素材基本信息
     *
     * @param material
     * @return
     */
    Material getMaterial(Material material);

    /**
     * 获取图文信息---多图文
     *
     * @param materialId
     * @return
     */
    List<PicMessage> getPicMessageList(Integer materialId);

    /**
     * 获取图文信息---单图文
     *
     * @param materialId
     * @return
     */
    PicMessage getPicMessage(Integer materialId);


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
    void updatePicMessage(PicMessage picMessage);


    /**
     * 获取多图文得条数
     *
     * @param materialId
     * @return
     */
    Integer getManyImageTextCount(Integer materialId);

    /**
     * 删除文本信息
     *
     * @param materialId
     */
    void deletePicMessage(Integer materialId);

    /**
     * 创建图文信息
     *
     * @param picMessage
     */
    void createPicMessage(PicMessage picMessage);
}
