package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */
public class Complimentary implements Serializable {
    private Integer Comid;
    private Integer slingnumber;
    private Integer holdernumber;
    private Integer Odid;

    public Complimentary() {

    }
    public Integer getComid() {
        return Comid;
    }
    public void setComid(Integer comid) {
        Comid = comid;
    }
    public Integer getSlingnumber() {
        return slingnumber;
    }
    public void setSlingnumber(Integer slingnumber) {
        this.slingnumber = slingnumber;
    }
    public Integer getHoldernumber() {
        return holdernumber;
    }
    public void setHoldernumber(Integer holdernumber) {
        this.holdernumber = holdernumber;
    }
    public Integer getOdid() {
        return Odid;
    }
    public void setOdid(Integer odid) {
        Odid = odid;
    }
}
