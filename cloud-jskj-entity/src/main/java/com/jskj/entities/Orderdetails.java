package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class Orderdetails implements Serializable {
    private int odid;		//订单详情id
    private int	pid;		//手机型号id
    private String oid;		//订单编号
    private int lid;		//物流id
    private int pnnumber;	//手机壳数量
    private String oremark;	//订单备注
    private int contactid;	//联系ID
    private int	photoid;	//图片id
    private String tbid;	//淘宝单号
    private String osendinfo;//发货信息
    private Integer uid; //用户id

    public Orderdetails() {
    }

    public String getOsendinfo() {
        return osendinfo;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setOsendinfo(String osendinfo) {
        this.osendinfo = osendinfo;
    }

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getPnnumber() {
        return pnnumber;
    }

    public void setPnnumber(int pnnumber) {
        this.pnnumber = pnnumber;
    }

    public String getOremark() {
        return oremark;
    }

    public void setOremark(String oremark) {
        this.oremark = oremark;
    }

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public String getTbid() {
        return tbid;
    }

    public void setTbid(String tbid) {
        this.tbid = tbid;
    }

    @Override
    public String toString() {
        return "Orderdetails [odid=" + odid + ", pid=" + pid + ", oid=" + oid + ", lid=" + lid + ", pnnumber="
                + pnnumber + ", oremark=" + oremark + ", contactid=" + contactid + ", photoid=" + photoid + ", tbid="
                + tbid + "]";
    }
}
