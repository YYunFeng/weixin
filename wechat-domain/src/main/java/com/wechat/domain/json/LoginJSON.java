package com.wechat.domain.json;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-18
 * Time: ÏÂÎç4:54
 * To change this template use File | Settings | File Templates.
 */
public class LoginJSON {
    private String code;
    private Integer status;
    private String mess;
    private Boolean superUser;

    public Boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
