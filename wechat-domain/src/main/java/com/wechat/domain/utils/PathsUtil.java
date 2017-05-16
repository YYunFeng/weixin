package com.wechat.domain.utils;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-1-10
 * Time: 下午5:52
 * To change this template use File | Settings | File Templates.
 */
public class PathsUtil {

    private String interfaceUrl; // 接口地址
    private String visitUrl;  // 图片访问地址
    private String respondUploadPath; // 自动回复图片上传地址
    private String componentPath;  // 组件图片上传地址
    private String materialtPath;  // 素材图片上传地址


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
