package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class Contact implements Serializable {
    private Integer contactid;   //联系Id
    private String conway;       //联系方式
    private String connumber;   //联系号码

    public Contact() {
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

    public String getConnumber() {
        return connumber;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }
}
