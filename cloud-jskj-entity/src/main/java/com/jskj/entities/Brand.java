package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lintao
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bid;
    private String pbrand;
    private Integer kid;
    private List<Phoneinfo> phoneInfos;

    public Brand() {
    }
    public Brand(Integer bid, String pbrand, Integer kid,
                 List<Phoneinfo> phoneInfos) {
        this.bid = bid;
        this.pbrand = pbrand;
        this.kid = kid;
        this.phoneInfos = phoneInfos;
    }

    public List<Phoneinfo> getPhoneInfos() {
        return phoneInfos;
    }

    public void setPhoneInfos(List<Phoneinfo> phoneInfos) {
        this.phoneInfos = phoneInfos;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String toString() {
        return "Brand [bid=" + bid + ", pbrand=" + pbrand + ", kid=" + kid
                + "]";
    }
}
