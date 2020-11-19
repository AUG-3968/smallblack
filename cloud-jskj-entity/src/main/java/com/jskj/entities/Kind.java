package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lintao
 */
public class Kind implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer kid;
    private String kname;
    private List<Brand> brands;

    public Kind() {
    }
    public Kind(Integer kid, String kname, List<Brand> brands) {

        this.kid = kid;
        this.kname = kname;
        this.brands = brands;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }
    public String toString() {
        return "Kind [kid=" + kid + ", kname=" + kname + "]";
    }
}
