package com.wechat.domain.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-4-17
 * Time: ����11:55
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    private Integer Id; // �û�ID
    private String userName;  // �û���
    private String password; // ����
    private String bussinessName; // ��ҵ����
    private String area; // ���ڵ�
    private String mail; // ����
    private String telephone; // ��ϵ�绰
    private String linkMan; // ��ϵ��
    private String introduction; // ��ҵ���
    private Boolean superUser; //  �Ƿ��ǹ���Ա
    private Date created; // ��¼����ʱ��
    private Integer upCount; // ������־����
    private Integer downCount; // ������־����
    private String weixinaccount;
    // �û�������  0 ����վע��  1��������ƽ̨
    private Integer userType = 0;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getWeixinaccount() {
        return weixinaccount;
    }

    public void setWeixinaccount(String weixinaccount) {
        this.weixinaccount = weixinaccount;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public Boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
