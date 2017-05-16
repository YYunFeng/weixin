package com.wechat.dao;


import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.parameter.MaterialListParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: 下午5:35
 * To change this template use File | Settings | File Templates.
 */
public interface MaterialDao {
    /**
     * 获取素材信息
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
     * 创建素材信息
     *
     * @param material
     */
    Integer createMaterial(Material material);

    /**
     * 创建图文信息
     *
     * @param picMessage
     */
    void createPicMessage(PicMessage picMessage);

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
}
