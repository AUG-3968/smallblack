package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lintao
 */
public class UserinfoValidation implements Serializable {
    private int    uid;			//用户id

    @NotEmpty(message="账号不能为空")
    private String uno;			//用户账号

    @NotEmpty(message="密码不能为空")
    @Pattern(regexp="^\\w{6,12}$",message="密码必须是6-12位")
    private String upwd;		//用户密码

    @Pattern(regexp="^[\u4e00-\u9fa5]+$",message="请填写正确的中文姓名")
    private String urealname;	//用户真实姓名

    @Pattern(regexp="^[1]+\\d{10}$",message="退款账号必须为手机号")
    private String    umoneryno;	//支付宝退款账号

    private String uphoto;		//用户照片
    private int    ustate;		//用户状态（1为禁用2正常）
    private int    ugrade;		//用户等级（1为普通用户2为管理员3为最高管理员

    private int    usex;        //性别（1为男2为女）

    public UserinfoValidation() {

    }
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
    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUrealname() {
        return urealname;
    }
    public void setUrealname(String urealname) {
        this.urealname = urealname;
    }
    public String getUphoto() {
        return uphoto;
    }
    public void setUphoto(String uphoto) {
        this.uphoto = uphoto;
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
    public void setUgrad(int ugrad) {
        this.ugrade = ugrad;
    }
    public String getUmoneryno() {
        return umoneryno;
    }
    public void setUmoneryno(String umoneryno) {
        this.umoneryno = umoneryno;
    }
    public int getUsex() {
        return usex;
    }
    public void setUsex(int usex) {
        this.usex = usex;
    }
    @Override
    public String toString() {
        return "Userinfo [uid=" + uid + ", uno=" + uno + ", upwd=" + upwd + ", urealname="
                + urealname + ", uphoto=" + uphoto + ", ustate=" + ustate + ", ugrade=" + ugrade + ", umoneryno="
                + umoneryno + ", usex=" + usex + "]";
    }

}
