package com.jskj.entities;

import java.io.Serializable;

/**
 * @author lintao
 */
public class OrderListSeach implements Serializable {
    private String 	oid;	//订单编号
    private int 	uid;	//用户id
    private String	odate;	//订单时间
    private double	osale;	//订单金额
    private int 	ostate;	//订单状态
    private int		odelete;//是否可见：1：可见 2：不可见
    private String  lame; //收件人姓名
    private String connumber; //联系号码

    private int		pid;	//手机型号id

    private Integer contactid;   //联系Id
    private String conway;       //联系方式
    private Integer lid;			//物流id
    private String ladress;		//收件人地址
    private String lorder;		//快递单号
    private String lcompany;	//快递公司
    private Integer	ldelete;		//是否可见：1：可见 2:不可见

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public double getOsale() {
        return osale;
    }

    public void setOsale(double osale) {
        this.osale = osale;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    public int getOdelete() {
        return odelete;
    }

    public void setOdelete(int odelete) {
        this.odelete = odelete;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public String getConway() {
        return conway;
    }

    public void setConway(String conway) {
        this.conway = conway;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
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

    public Integer getLdelete() {
        return ldelete;
    }

    public void setLdelete(Integer ldelete) {
        this.ldelete = ldelete;
    }
}
