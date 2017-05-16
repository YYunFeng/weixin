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
 * Time: ����4:56
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
     * �زĹ���
     *
     * @return
     */
    public String materialManager() {
        return SUCCESS;
    }

    /**
     * ��ͼ��
     *
     * @return
     */
    public String singleImageTextContent() {
        MaterialListParameter materialListParameter = new MaterialListParameter();
        try {
            // ��ͼ��
            materialListParameter.setType(0);
            materialListParameter.setWeixinId(super.getUserWeiXin().getId());
            materialListResList = materialService.getMaterialList(materialListParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��ӵ�ͼ��
     *
     * @return
     */
    public String addSingleImageText() {
        return SUCCESS;
    }

    /**
     * ���浥ͼ����Ϣ ---���
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
            materialJSON.setMess("�����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            materialJSON.setStatus(0);
            materialJSON.setMess("����ʧ��");
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * ɾ���ز�
     *
     * @throws JSONException
     * @throws IOException
     */
    public void delteMaterial() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            materialService.deleteMaterial(Id);
            materialJSON.setStatus(1);
            materialJSON.setMess("ɾ���ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            materialJSON.setStatus(0);
            materialJSON.setMess("ɾ��ʧ��");
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �޸ĵ�ͼ��
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
     * �޸ĵ�ͼ��--���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifySingleImageText() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            materialService.updatePicMessage(picMessage, null);
            materialJSON.setStatus(1);
            materialJSON.setMess("���³ɹ�");
        } catch (Exception e) {
            materialJSON.setStatus(0);
            materialJSON.setMess("����ʧ��");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * ��ͼ�ġ�ajax ����
     *
     * @return
     */
    public String manyImageTextConent() {
        MaterialListParameter materialListParameter = new MaterialListParameter();
        try {
            // ��ͼ��
            materialListParameter.setType(1);
            materialListParameter.setWeixinId(super.getUserWeiXin().getId());
            materialListResList = materialService.getMaterialList(materialListParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ��Ӷ�ͼ��
     *
     * @return
     */
    public String addManyImageText() {
        return SUCCESS;
    }

    /**
     * �����ͼ��
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
            materialJSON.setMess("�����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            materialJSON.setStatus(0);
            materialJSON.setMess("����ʧ��");
        }
        String json = JSONUtil.serialize(materialJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * �޸Ķ�ͼ��
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
     * �޸Ķ�ͼ��--���
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyManyImageText() throws JSONException, IOException {
        MaterialJSON materialJSON = new MaterialJSON();
        try {
            materialService.updatePicMessage(null, picMessageList);
            materialJSON.setStatus(1);
            materialJSON.setMess("���³ɹ�");
        } catch (Exception e) {
            materialJSON.setStatus(0);
            materialJSON.setMess("����ʧ��");
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
