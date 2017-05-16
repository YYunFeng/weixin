package com.wechat.dao.impl;


import com.wechat.dao.BaseDao;
import com.wechat.dao.MaterialDao;
import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.parameter.MaterialListParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: ÏÂÎç5:59
 * To change this template use File | Settings | File Templates.
 */
public class MaterialDaoImpl extends BaseDao implements MaterialDao {
    public Material getMaterial(Material material) {
        return (Material) queryForObject("Material.getMaterial", material);
    }

    public List<PicMessage> getPicMessageList(Integer materialId) {
        return queryForList("Material.getPicMessage", materialId);
    }

    public PicMessage getPicMessage(Integer materialId) {
        return (PicMessage) queryForObject("Material.getPicMessage", materialId);
    }

    public List<MaterialListRes> getMaterialList(MaterialListParameter materialListParameter) {
        return queryForList("Material.getMaterialList", materialListParameter);
    }

    public Integer createMaterial(Material material) {
        return (Integer) insert("Material.createMaterial", material);
    }

    public void createPicMessage(PicMessage picMessage) {
        insert("Material.createPicMessage", picMessage);
    }

    public void deleteMaterial(Integer id) {
        delete("Material.deleteMaterial", id);
    }

    public void updatePicMessage(PicMessage picMessage) {
        update("Material.updatePicMessage", picMessage);
    }

    public Integer getManyImageTextCount(Integer materialId) {
        return (Integer) queryForObject("Material.getManyImageTextCount", materialId);
    }

    public void deletePicMessage(Integer materialId) {
        delete("Material.deletePicMessage", materialId);
    }
}
