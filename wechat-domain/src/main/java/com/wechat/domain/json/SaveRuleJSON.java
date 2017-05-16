package com.wechat.domain.json;

/**
 * Created with IntelliJ IDEA.
 * User: yyfpc
 * Date: 13-4-21
 * Time: ÏÂÎç1:13
 * To change this template use File | Settings | File Templates.
 */
public class SaveRuleJSON {
    private Integer keyLinkId;
    private Integer status;
    private String mess;
    private Integer code;

    public Integer getKeyLinkId() {
        return keyLinkId;
    }

    public void setKeyLinkId(Integer keyLinkId) {
        this.keyLinkId = keyLinkId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
