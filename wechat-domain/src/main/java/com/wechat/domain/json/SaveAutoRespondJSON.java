package com.wechat.domain.json;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-27
 * Time: ÏÂÎç7:35
 * To change this template use File | Settings | File Templates.
 */
public class SaveAutoRespondJSON {
    private Integer status;
    private String mess;
    private Integer code;

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
