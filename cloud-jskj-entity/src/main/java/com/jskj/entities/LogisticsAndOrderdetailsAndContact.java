package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class LogisticsAndOrderdetailsAndContact implements Serializable {
    private Integer lid;		//物流id
    private String lame;		//收件人姓名
    private String ladress;		//收件人地址
    private String oid;			//订单id
    private String lorder;		//快递单号
    private String lcompany;	//快递公司
    private Integer contactid;		//联系ID
    private Integer	ldelete;		//是否可见：1：可见 2:不可见
    private String tbid;	//淘宝单号
    private String conway;       //联系方式
    private String connumber;   //联系号码

    public LogisticsAndOrderdetailsAndContact() {
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLame() {
        return lame;
    }

    public void setLame(String lame) {
        this.lame = lame;
    }

    public String getLadress() {
        return ladress;
    }

    public void setLadress(String ladress) {
        this.ladress = ladress;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getLorder() {
        return lorder;
    }

    public void setLorder(String lorder) {
        this.lorder = lorder;
    }

    public String getLcompany() {
        return lcompany;
    }

    public void setLcompany(String lcompany) {
        this.lcompany = lcompany;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public Integer getLdelete() {
        return ldelete;
    }

    public void setLdelete(Integer ldelete) {
        this.ldelete = ldelete;
    }

    public String getTbid() {
        return tbid;
    }

    public void setTbid(String tbid) {
        this.tbid = tbid;
    }

    public String getConway() {
        return conway;
    }

    public void setConway(String conway) {
        this.conway = conway;
    }

    public String getConnumber() {
        return connumber;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }
}
