package com.wechat.manager.impl;

import com.wechat.dao.MaterialDao;
import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.parameter.MaterialListParameter;
import com.wechat.manager.MaterialManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-6
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public class MaterialManagerImpl implements MaterialManager {
    private MaterialDao materialDao;


    public Material getMaterial(Material material) {
        return materialDao.getMaterial(material);
    }

    public List<PicMessage> getPicMessageList(Integer materialId) {
        return materialDao.getPicMessageList(materialId);
    }

    public PicMessage getPicMessage(Integer materialId) {
        return materialDao.getPicMessage(materialId);
    }


    public List<MaterialListRes> getMaterialList(MaterialListParameter materialListParameter) {
        return materialDao.getMaterialList(materialListParameter);
    }

    public void saveSinglePicMessageText(Material material, PicMessage picMessage) {
        try {
            // 创建素材信息
            Integer materialId = null;
            if (material != null) {
                // 单图文
                material.setType(0);
                materialId = materialDao.createMaterial(material);
            }
            // 创建图文信息
            if (picMessage != null && materialId != null) {
                //排序默认为1
                picMessage.setSeq(1);
                picMessage.setMaterialId(materialId);
                materialDao.createPicMessage(picMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveManyPicMessageText(Material material, List<PicMessage> picMessageList) {
        try {
            // 创建素材信息
            Integer materialId = null;
            if (material != null) {
                materialId = materialDao.createMaterial(material);
            }
            // 创建多图文信息
            if (picMessageList != null && picMessageList.size() != 0 && materialId != null) {
                for (PicMessage picMessage : picMessageList) {
                    // 判断图文信息不能为空
                    if (picMessage != null && picMessage.getPicUrl() != null && !picMessage.getPicUrl().equals("") && picMessage.getTitle() != null && !picMessage.equals("") && picMessage.getMessage() != null && !picMessage.equals("")) {
                        picMessage.setMaterialId(materialId);
                        materialDao.createPicMessage(picMessage);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMaterial(Integer id) {
        materialDao.deleteMaterial(id);
    }

    public void updatePicMessage(PicMessage picMessage) {
        materialDao.updatePicMessage(picMessage);
    }

    public Integer getManyImageTextCount(Integer materialId) {
        return materialDao.getManyImageTextCount(materialId);
    }

    public void deletePicMessage(Integer materialId) {
        materialDao.deletePicMessage(materialId);
    }

    public void createPicMessage(PicMessage picMessage) {
        materialDao.createPicMessage(picMessage);
    }

    public void setMaterialDao(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }
}
