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
 * Time: ����10:22
 * To change this template use File | Settings | File Templates.
 */
public interface MaterialService {

    /**
     * ����ز���ϸ��Ϣ
     *
     * @param materialParameter
     * @return
     */
    MaterialRes getMaterialConent(Material materialParameter);

    /**
     * ��ȡ�ز��б�
     *
     * @param materialListParameter
     * @return
     */
    List<MaterialListRes> getMaterialList(MaterialListParameter materialListParameter);


    /**
     * ������ͼ����Ϣ
     *
     * @param material
     * @param picMessage
     */
    void saveSinglePicMessageText(Material material, PicMessage picMessage);

    /**
     * ������ͼ����Ϣ
     *
     * @param material
     * @param picMessageList
     */
    void saveManyPicMessageText(Material material, List<PicMessage> picMessageList);


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
    void updatePicMessage(PicMessage picMessage, List<PicMessage> picMessageList);
}
