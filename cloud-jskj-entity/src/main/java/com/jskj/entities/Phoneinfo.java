package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class Phoneinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pid;//手机型号id
    private String pmodel;//型号名称
    private String pphoto;//模具图层
    private String pcamera;//摄像头图层
    private Integer bid;//手机品牌id
    private Integer psale;

    public Phoneinfo() {
    }

    public Integer getPsale() {
        return psale;
    }

    public void setPsale(Integer psale) {
        this.psale = psale;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPmodel() {
        return pmodel;
    }

    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }

    public String getPphoto() {
        return pphoto;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }

    public String getPcamera() {
        return pcamera;
    }

    public void setPcamera(String pcamera) {
        this.pcamera = pcamera;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String toString() {
        return "Phoneinfo [pid=" + pid + ", pmodel=" + pmodel + ", pphoto="
                + pphoto + ", pcamera=" + pcamera + ", bid=" + bid + "]";
    }
}
