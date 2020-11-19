package com.jskj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lintao
 */

public class Photoinfo implements Serializable {
    private Integer Photoid;
    private String Photosrc;
    private String Photoname;
    public Photoinfo() {

    }
    public Integer getPhotoid() {
        return Photoid;
    }
    public void setPhotoid(Integer photoid) {
        Photoid = photoid;
    }
    public String getPhotosrc() {
        return Photosrc;
    }
    public void setPhotosrc(String photosrc) {
        Photosrc = photosrc;
    }
    public String getPhotoname() {
        return Photoname;
    }
    public void setPhotoname(String photoname) {
        Photoname = photoname;
    }
}
