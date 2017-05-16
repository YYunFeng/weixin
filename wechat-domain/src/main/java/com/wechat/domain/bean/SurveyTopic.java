package com.wechat.domain.bean;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-21
 * Time: ÉÏÎç11:31
 * To change this template use File | Settings | File Templates.
 */
public class SurveyTopic {
    private Integer Id;
    private Integer surverId;
    private String title;
    private String sel1;
    private String sel2;
    private String sel3;
    private String sel4;
    private String sel5;
    private String sel6;

    public String getSel1() {
        return sel1;
    }

    public void setSel1(String sel1) {
        this.sel1 = sel1;
    }

    public String getSel2() {
        return sel2;
    }

    public void setSel2(String sel2) {
        this.sel2 = sel2;
    }

    public String getSel3() {
        return sel3;
    }

    public void setSel3(String sel3) {
        this.sel3 = sel3;
    }

    public String getSel4() {
        return sel4;
    }

    public void setSel4(String sel4) {
        this.sel4 = sel4;
    }

    public String getSel5() {
        return sel5;
    }

    public void setSel5(String sel5) {
        this.sel5 = sel5;
    }

    public String getSel6() {
        return sel6;
    }

    public void setSel6(String sel6) {
        this.sel6 = sel6;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getSurverId() {
        return surverId;
    }

    public void setSurverId(Integer surverId) {
        this.surverId = surverId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
