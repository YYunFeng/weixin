package com.wechat.action;

import com.wechat.domain.constant.PicCatalogueConstant;
import com.wechat.domain.json.UploadJSON;
import com.wechat.domain.utils.PathsUtil;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-19
 * Time: 下午6:35
 * To change this template use File | Settings | File Templates.
 */
public class UploadAction extends BaseAction {
    private File uploadFile;
    private String fileName;
    private PathsUtil pathsUtil;
    private Integer type;

    /**
     * 上传应用应用截图到本地
     *
     * @return
     * @throws IOException
     */
    public String uploadPic() throws IOException, JSONException {
        String targetDirectory = null;
        String res = null;
        if (type != null) {
            if (type.intValue() == 1) { // 上传组件封面
                targetDirectory = pathsUtil.getComponentPath();
                res = PicCatalogueConstant.COMPONET;
            }
            if (type.intValue() == 2) { // 上传素材图片
                targetDirectory = pathsUtil.getMaterialtPath();
                res = PicCatalogueConstant.MATERIAL;
            }
        }
        String extName = "";
        String newFileName = "";
        String names[] = ((MultiPartRequestWrapper) this.request).getFileNames("uploadFile");
        UploadJSON uploadJSON = new UploadJSON();
        String str = null;
        if (names[0].lastIndexOf(".") >= 0) {
            extName = names[0].substring(names[0].lastIndexOf("."));
        }
        newFileName = System.currentTimeMillis() + extName;
        File target = new File(targetDirectory, newFileName);
        FileUtils.copyFile(uploadFile, target);
        uploadJSON.setFileName(newFileName);
        uploadJSON.setViewPath(pathsUtil.getVisitUrl() + res + newFileName);
        String json = JSONUtil.serialize(uploadJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
        return null;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPathsUtil(PathsUtil pathsUtil) {
        this.pathsUtil = pathsUtil;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
