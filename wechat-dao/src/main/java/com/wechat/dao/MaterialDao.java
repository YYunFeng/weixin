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
 * Time: ����5:35
 * To change this template use File | Settings | File Templates.
 */
public interface MaterialDao {
    /**
     * ��ȡ�ز���Ϣ
     *
     * @param material
     * @return
     */
    Material getMaterial(Material material);

    /**
     * ��ȡͼ����Ϣ---��ͼ��
     *
     * @param materialId
     * @return
     */
    List<PicMessage> getPicMessageList(Integer materialId);

    /**
     * ��ȡͼ����Ϣ---��ͼ��
     *
     * @param materialId
     * @return
     */
    PicMessage getPicMessage(Integer materialId);

    /**
     * ��ȡ�ز��б�
     *
     * @param materialListParameter
     * @return
     */
    List<MaterialListRes> getMaterialList(MaterialListParameter materialListParameter);

    /**
     * �����ز���Ϣ
     *
     * @param material
     */
    Integer createMaterial(Material material);

    /**
     * ����ͼ����Ϣ
     *
     * @param picMessage
     */
    void createPicMessage(PicMessage picMessage);

    /**
     * ɾ���ز�
     *
     * @param id
     */
    void deleteMaterial(Integer id);

    /**
     * ����ͼ����Ϣ
     *
     * @param picMessage
     */
    void updatePicMessage(PicMessage picMessage);

    /**
     * ��ȡ��ͼ�ĵ�����
     *
     * @param materialId
     * @return
     */
    Integer getManyImageTextCount(Integer materialId);

    /**
     * ɾ���ı���Ϣ
     *
     * @param materialId
     */
    void deletePicMessage(Integer materialId);
}
