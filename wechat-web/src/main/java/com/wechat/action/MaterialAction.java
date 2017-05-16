package com.wechat.action;


import com.wechat.domain.bean.Material;
import com.wechat.domain.bean.PicMessage;
import com.wechat.domain.bean.response.MaterialListRes;
import com.wechat.domain.bean.response.MaterialRes;
import com.wechat.domain.json.MaterialJSON;
import com.wechat.domain.parameter.MaterialListParameter;
import com.wechat.service.MaterialService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-3
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class MaterialAction extends BaseAction {

    private MaterialService materialService;
    private Material material;
    private PicMessage picMessage;
    private List<PicMessage> picMessageList;
    private List<MaterialListRes> materialListResList;
    private Integer Id;
    private MaterialRes materialRes;

    /**
     * 素材管理
     *
     * @return
     */
    public String materialManager() {
        return SUCCESS;
    }

    /**
     * 单图文
     *
     * @return
     */
    public String singleImageTextContent() {
        MaterialListParameter materialListParameter = new MaterialListParameter();
        try {
            // 单图文
            materialListParameter.setType(0);
            materialListParameter.setWeixinId(super.getUserWeiXin().getId());
            materialListResList = materialService.getMaterialList(materialListParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 添加单图文
     *
     * @return
     */
    public String addSingleImageText() {
        return SUCCESS;
    }

    /**
     * 保存单图文信息 ---入库
     *
     * @throws IOException
     * @throws JSONException
     */
    public void saveSingleImageText() throws IOException, JSONException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            material = new Material();
            material.setType(0);
            material.setWeixinId(super.getUserWeiXin().getId());
            materialService.saveSinglePicMessageText(material, picMessage);
            materialJSON.setStatus(1);
            materialJSON.setMess("创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            materialJSON.setStatus(0);
            materialJSON.setMess("创建失败");
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * 删除素材
     *
     * @throws JSONException
     * @throws IOException
     */
    public void delteMaterial() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            materialService.deleteMaterial(Id);
            materialJSON.setStatus(1);
            materialJSON.setMess("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            materialJSON.setStatus(0);
            materialJSON.setMess("删除失败");
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 修改单图文
     *
     * @return
     */
    public String modifySingleImageText() {
        try {
            materialRes = materialService.getMaterialConent(material);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 修改单图文--入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifySingleImageText() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            materialService.updatePicMessage(picMessage, null);
            materialJSON.setStatus(1);
            materialJSON.setMess("更新成功");
        } catch (Exception e) {
            materialJSON.setStatus(0);
            materialJSON.setMess("更新失败");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 多图文　ajax 调用
     *
     * @return
     */
    public String manyImageTextConent() {
        MaterialListParameter materialListParameter = new MaterialListParameter();
        try {
            // 单图文
            materialListParameter.setType(1);
            materialListParameter.setWeixinId(super.getUserWeiXin().getId());
            materialListResList = materialService.getMaterialList(materialListParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 添加多图文
     *
     * @return
     */
    public String addManyImageText() {
        return SUCCESS;
    }

    /**
     * 保存多图文
     *
     * @return
     */
    public void saveManyImageText() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            material = new Material();
            material.setType(1);
            material.setWeixinId(super.getUserWeiXin().getId());
            materialService.saveManyPicMessageText(material, picMessageList);
            materialJSON.setStatus(1);
            materialJSON.setMess("创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            materialJSON.setStatus(0);
            materialJSON.setMess("创建失败");
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 修改多图文
     *
     * @return
     */
    public String modifyManyImageText() {
        try {
            materialRes = materialService.getMaterialConent(material);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 修改多图文--入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyManyImageText() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            materialService.updatePicMessage(null, picMessageList);
            materialJSON.setStatus(1);
            materialJSON.setMess("更新成功");
        } catch (Exception e) {
            materialJSON.setStatus(0);
            materialJSON.setMess("更新失败");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public PicMessage getPicMessage() {
        return picMessage;
    }

    public void setPicMessage(PicMessage picMessage) {
        this.picMessage = picMessage;
    }

    public List<MaterialListRes> getMaterialListResList() {
        return materialListResList;
    }

    public void setMaterialListResList(List<MaterialListRes> materialListResList) {
        this.materialListResList = materialListResList;
    }

    public List<PicMessage> getPicMessageList() {
        return picMessageList;
    }

    public void setPicMessageList(List<PicMessage> picMessageList) {
        this.picMessageList = picMessageList;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public MaterialRes getMaterialRes() {
        return materialRes;
    }

    public void setMaterialRes(MaterialRes materialRes) {
        this.materialRes = materialRes;
    }
}
