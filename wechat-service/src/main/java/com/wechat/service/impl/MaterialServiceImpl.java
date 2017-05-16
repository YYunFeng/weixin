package com.wechat.service.impl;



import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.bean.response.MaterialRes;
import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.domain.parameter.MaterialListParameter;
import com.wechat.manager.MaterialManager;
import com.wechat.service.MaterialService;
import com.wechat.domain.utils.PathsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-6
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public class MaterialServiceImpl implements MaterialService {
    private MaterialManager materialManager;
    private PathsUtil pathsUtil;


    public MaterialRes getMaterialConent(Material material) {
        MaterialRes materailRes = new MaterialRes();
        try {
            if (material != null) {
                // 获得素材基本信息
              /*  Material material = materialManager.getMaterial(materialParameter);
                materailRes.setMaterial(material);*/
                // 获得图文信息
                // 单图文
                if (material.getType().intValue() == 0) {
                    PicMessage picMessage = materialManager.getPicMessage(material.getId());
                    picMessage.setVisitUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.MATERIAL + picMessage.getPicUrl());
                    materailRes.setPicMessage(picMessage);
                }
                // 多图文
                if (material.getType().intValue() == 1) {
                    List<PicMessage> picMessageList = materialManager.getPicMessageList(material.getId());
                    for (PicMessage picMessage : picMessageList) {
                        picMessage.setVisitUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.MATERIAL + picMessage.getPicUrl());
                    }
                    materailRes.setPicMessageList(picMessageList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return materailRes;
    }

    public List<MaterialListRes> getMaterialList(MaterialListParameter materialListParameter) {
        List<MaterialListRes> materialListResList = new ArrayList<MaterialListRes>();
        try {
            materialListResList = materialManager.getMaterialList(materialListParameter);
            for (MaterialListRes materialListRes : materialListResList) {
                materialListRes.setPicUrl(pathsUtil.getVisitUrl() + PicCatalogueConstant.MATERIAL + materialListRes.getPicUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return materialListResList;
    }

    public void saveSinglePicMessageText(Material material, PicMessage picMessage) {
        try {
            materialManager.saveSinglePicMessageText(material, picMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveManyPicMessageText(Material material, List<PicMessage> picMessageList) {
        try {
            materialManager.saveManyPicMessageText(material, picMessageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMaterial(Integer id) {
        try {
            if (id != null) {
                materialManager.deleteMaterial(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePicMessage(PicMessage picMessage, List<PicMessage> picMessageList) {
        try {
            // 单图文修改
            if (picMessage != null) {
                picMessage.setSeq(1);
                materialManager.updatePicMessage(picMessage);
            }
            // 多图文修改
            if (picMessageList != null && picMessageList.size() != 0) {
                // 首先删除所有文本信息
                Integer marterId = picMessageList.get(0).getMaterialId();
                materialManager.deletePicMessage(marterId);
                for (PicMessage picMessage1 : picMessageList) {
                    if(picMessage1 != null && picMessage1.getPicUrl() != null && !picMessage1.getPicUrl().equals("") && picMessage1.getTitle() != null && !picMessage1.equals("") && picMessage1.getMessage() != null && !picMessage1.equals("")){
                        picMessage1.setMaterialId(marterId);
                        materialManager.createPicMessage(picMessage1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMaterialManager(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }
}
