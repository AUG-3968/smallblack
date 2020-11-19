package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author lintao
 */

public class Message implements Serializable {
    private Integer mis;
    private Integer uid;
    private String mcontent;
    private Integer mstate;
    private Date mtime;

    public Message() {
    }
    public Integer getMis() {
        return mis;
    }
    public void setMis(Integer mis) {
        this.mis = mis;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getMcontent() {
        return mcontent;
    }
    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }
    public Integer getMstate() {
        return mstate;
    }
    public void setMstate(Integer mstate) {
        this.mstate = mstate;
    }
    public Date getMtime() {
        return mtime;
    }
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
}
