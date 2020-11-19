package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */
public class OrmanaViewbean implements Serializable {
    private String oid;			//订单编号
    private String urealname;	//用户姓名
    private String umoneryno;	//支付宝账号
    private Double osale;		//订单金额
    private String odate;		//订单日期
    private	Integer	ostate;		//订单状态
    private	String lame;		//收件人姓名
    private	String connumber;	//收件人号码
    private	String ladress;		//收件人地址
    private Integer	pnnumber;	//宝贝数量(手机壳数量)
    private String osendinfo;	//发货信息

    public OrmanaViewbean() {
    }
    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public String getUrealname() {
        return urealname;
    }
    public void setUrealname(String urealname) {
        this.urealname = urealname;
    }
    public String getUmoneryno() {
        return umoneryno;
    }
    public void setUmoneryno(String umoneryno) {
        this.umoneryno = umoneryno;
    }
    public Double getOsale() {
        return osale;
    }
    public void setOsale(Double osale) {
        this.osale = osale;
    }
    public String getOdate() {
        return odate;
    }
    public void setOdate(String odate) {
        this.odate = odate;
    }
    public Integer getOstate() {
        return ostate;
    }
    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }
    public String getLame() {
        return lame;
    }
    public void setLame(String lame) {
        this.lame = lame;
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
    public Integer getPnnumber() {
        return pnnumber;
    }
    public void setPnnumber(Integer pnnumber) {
        this.pnnumber = pnnumber;
    }
    public String getOsendinfo() {
        return osendinfo;
    }
    public void setOsendinfo(String osendinfo) {
        this.osendinfo = osendinfo;
    }
    public String toString() {
        return "OrmanaViewbean [oid=" + oid + ", urealname=" + urealname
                + ", umoneryno=" + umoneryno + ", osale=" + osale + ", odate="
                + odate + ", ostate=" + ostate + ", lame=" + lame
                + ", connumber=" + connumber + ", ladress=" + ladress
                + ", pnnumber=" + pnnumber + ", osendinfo=" + osendinfo + "]";
    }
}
