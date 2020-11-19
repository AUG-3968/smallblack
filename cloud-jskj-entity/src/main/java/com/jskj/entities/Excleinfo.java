package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class Excleinfo implements Serializable {
    private Integer exid;//临时表ID
    private Integer uid;//用户名称
    private String odate;//时间
    private Double osale;//金额
    private String oremark;//备注
    private Integer pnnumber;//手机壳数量
    private Integer pid;//手机型号id
    private String pmodel;//手机型号名称
    private String connumber;//手机号码
    private String linephone;//固定电话
    private String lame;//收件人姓名
    private String ladress;//收件人地址
    private String lorder;//快递单号
    private String lcompany;//快递公司
    private String tbid;//淘宝单号
    private String photosrc;//图片路径
    private Double slingnumber;//挂绳数量
    private Double holdernumber;//支架数量
    private String province;//省
    private String city;//市
    private String county;//县
    private String file;
    private Integer extype;//插入类型
    private String Osendinfo;//发货信息

    public Excleinfo() {

    }
    @Override
    public String toString() {
        return "Excleinfo [exid=" + exid + ", uid=" + uid + ", odate=" + odate
                + ", osale=" + osale + ", oremark=" + oremark + ", pnnumber="
                + pnnumber + ", pid=" + pid + ", pmodel=" + pmodel
                + ", connumber=" + connumber + ", linephone=" + linephone
                + ", lame=" + lame + ", ladress=" + ladress + ", lorder="
                + lorder + ", lcompany=" + lcompany + ", tbid=" + tbid
                + ", photosrc=" + photosrc + ", slingnumber=" + slingnumber
                + ", holdernumber=" + holdernumber + ", province=" + province
                + ", city=" + city + ", county=" + county + ", file=" + file
                + ", extype=" + extype + ", Osendinfo=" + Osendinfo
                + ", getOsendinfo()=" + getOsendinfo() + ", getLinephone()="
                + getLinephone() + ", getPmodel()=" + getPmodel()
                + ", getExtype()=" + getExtype() + ", getFile()=" + getFile()
                + ", getExid()=" + getExid() + ", getUid()=" + getUid()
                + ", getOdate()=" + getOdate() + ", getOsale()=" + getOsale()
                + ", getOremark()=" + getOremark() + ", getConnumber()="
                + getConnumber() + ", getLame()=" + getLame()
                + ", getLadress()=" + getLadress() + ", getLorder()="
                + getLorder() + ", getLcompany()=" + getLcompany()
                + ", getTbid()=" + getTbid() + ", getPhotosrc()="
                + getPhotosrc() + ", getProvince()=" + getProvince()
                + ", getCity()=" + getCity() + ", getCounty()=" + getCounty()
                + ", getPnnumber()=" + getPnnumber() + ", getPid()=" + getPid()
                + ", getSlingnumber()=" + getSlingnumber()
                + ", getHoldernumber()=" + getHoldernumber() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
    public String getOsendinfo() {
        return Osendinfo;
    }
    public void setOsendinfo(String osendinfo) {
        Osendinfo = osendinfo;
    }
    public String getLinephone() {
        return linephone;
    }
    public void setLinephone(String linephone) {
        this.linephone = linephone;
    }
    public String getPmodel() {
        return pmodel;
    }
    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }
    public Integer getExtype() {
        return extype;
    }
    public void setExtype(Integer extype) {
        this.extype = extype;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public Integer getExid() {
        return exid;
    }
    public void setExid(Integer exid) {
        this.exid = exid;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getOdate() {
        return odate;
    }
    public void setOdate(String odate) {
        this.odate = odate;
    }
    public Double getOsale() {
        return osale;
    }
    public void setOsale(Double osale) {
        this.osale = osale;
    }
    public String getOremark() {
        return oremark;
    }
    public void setOremark(String oremark) {
        this.oremark = oremark;
    }
    public String getConnumber() {
        return connumber;
    }
    public void setConnumber(String connumber) {
        this.connumber = connumber;
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
    public String getTbid() {
        return tbid;
    }
    public void setTbid(String tbid) {
        this.tbid = tbid;
    }
    public String getPhotosrc() {
        return photosrc;
    }
    public void setPhotosrc(String photosrc) {
        this.photosrc = photosrc;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public Integer getPnnumber() {
        return pnnumber;
    }
    public void setPnnumber(Integer pnnumber) {
        this.pnnumber = pnnumber;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Double getSlingnumber() {
        return slingnumber;
    }
    public void setSlingnumber(Double slingnumber) {
        this.slingnumber = slingnumber;
    }
    public Double getHoldernumber() {
        return holdernumber;
    }
    public void setHoldernumber(Double holdernumber) {
        this.holdernumber = holdernumber;
    }
}
