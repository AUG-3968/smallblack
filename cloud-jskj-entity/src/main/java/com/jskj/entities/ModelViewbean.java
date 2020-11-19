package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class ModelViewbean implements Serializable {
    private String kname;
    private String pbrand;
    private String pmodel;
    private Integer pid;

    public ModelViewbean() {
    }
    public String getKname() {
        return kname;
    }
    public void setKname(String kname) {
        this.kname = kname;
    }
    public String getPbrand() {
        return pbrand;
    }
    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }
    public String getPmodel() {
        return pmodel;
    }
    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String toString() {
        return "ModelViewbean [kname=" + kname + ", pbrand=" + pbrand
                + ", pmodel=" + pmodel + ", pid=" + pid + "]";
    }
}
