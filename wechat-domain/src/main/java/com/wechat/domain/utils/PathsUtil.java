package com.wechat.domain.utils;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-1-10
 * Time: ����5:52
 * To change this template use File | Settings | File Templates.
 */
public class PathsUtil {

    private String interfaceUrl; // �ӿڵ�ַ
    private String visitUrl;  // ͼƬ���ʵ�ַ
    private String respondUploadPath; // �Զ��ظ�ͼƬ�ϴ���ַ
    private String componentPath;  // ���ͼƬ�ϴ���ַ
    private String materialtPath;  // �ز�ͼƬ�ϴ���ַ


    public String getComponentPath() {
        return componentPath;
    }

    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }

    public String getRespondUploadPath() {
        return respondUploadPath;
    }

    public void setRespondUploadPath(String respondUploadPath) {
        this.respondUploadPath = respondUploadPath;
    }

    public String getMaterialtPath() {
        return materialtPath;
    }

    public void setMaterialtPath(String materialtPath) {
        this.materialtPath = materialtPath;
    }
}
