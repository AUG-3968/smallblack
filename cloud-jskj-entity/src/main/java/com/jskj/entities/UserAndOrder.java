package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class UserAndOrder implements Serializable {
    private int    uid;			//用户id
    private String uno;			//用户账号
    private String uname;		//用户名称
    private String urealname;	//用户真实姓名
    private int    ustate;		//用户状态（1为禁用2正常）
    private int    ugrade;		//用户等级（1为普通用户2为管理员3为最高管理员
    private String    umoneryno;	//支付宝退款账号
    private Double osale;     	//支付总金额

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUno() {
        return uno;
    }
    public void setUno(String uno) {
        this.uno = uno;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUrealname() {
        return urealname;
    }
    public void setUrealname(String urealname) {
        this.urealname = urealname;
    }
    public int getUstate() {
        return ustate;
    }
    public void setUstate(int ustate) {
        this.ustate = ustate;
    }
    public int getUgrade() {
        return ugrade;
    }
    public void setUgrade(int ugrade) {
        this.ugrade = ugrade;
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
    public String toString() {
        return "UserAndOrder [uid=" + uid + ", uno=" + uno + ", uname=" + uname
                + ", urealname=" + urealname + ", ustate=" + ustate
                + ", ugrade=" + ugrade + ", umoneryno=" + umoneryno
                + ", osale=" + osale + "]";
    }

}
