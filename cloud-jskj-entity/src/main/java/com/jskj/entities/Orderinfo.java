package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class Orderinfo implements Serializable {
    private String 	oid;	//订单编号
    private int 	uid;	//用户id
    private String	odate;	//订单时间
    private double	osale;	//订单金额
    private int 	ostate;	//订单状态
    private int		odelete;//是否可见：1：可见 2：不可见
    private String  lame; //收件人姓名
    private String connumber; //联系号码

    private int		pid;	//手机型号id

    public Orderinfo() {

    }


    public int getPid() {
        return pid;
    }


    public void setPid(int pid) {
        this.pid = pid;
    }


    public String getConnumber() {
        return connumber;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }

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

    public String toString() {
        return "Orderinfo [oid=" + oid + ", uid=" + uid + ", odate=" + odate + ", osale=" + osale + ", ostate=" + ostate
                + ", odelete=" + odelete + "]";
    }
}
