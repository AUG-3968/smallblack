package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */
public class LogisticsAndContactAndOrderinfoAndOrderdetails implements Serializable {
    private String 	oid;	//订单编号
    private String	odate;	//订单时间
    private String lame;		//收件人姓名
    private Integer contactid;		//联系ID
    private String connumber;   //联系号码
    private String ladress;		//收件人地址
    private String lorder;		//快递单号
    private String lcompany;	//快递公司
    private String tbid;	//淘宝单号
    private Integer pnnumber;  //手机壳数量
    private Integer ostate;    //订单状态
    private String oremark;    //订单备注

    public LogisticsAndContactAndOrderinfoAndOrderdetails() {

    }

    public Integer getPnnumber() {
        return pnnumber;
    }


    public void setPnnumber(Integer pnnumber) {
        this.pnnumber = pnnumber;
    }


    public Integer getOstate() {
        return ostate;
    }


    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }


    public String getOremark() {
        return oremark;
    }


    public void setOremark(String oremark) {
        this.oremark = oremark;
    }


    public String getTbid() {
        return tbid;
    }

    public void setTbid(String tbid) {
        this.tbid = tbid;
    }

    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public String getOdate() {
        return odate;
    }
    public void setOdate(String odate) {
        this.odate = odate;
    }
    public String getLame() {
        return lame;
    }
    public void setLame(String lame) {
        this.lame = lame;
    }
    public Integer getContactid() {
        return contactid;
    }
    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }
    public String getConnumber() {
        return connumber;
    }
    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }
    public String getLadress() {
        return ladress;
    }
    public void setLadress(String ladress) {
        this.ladress = ladress;
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
}
