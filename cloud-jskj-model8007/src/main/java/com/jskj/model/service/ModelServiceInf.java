package com.jskj.model.service;

import com.github.pagehelper.PageInfo;
import com.jskj.entities.Brand;
import com.jskj.entities.Kind;
import com.jskj.entities.ModelViewbean;
import com.jskj.entities.Phoneinfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
public interface ModelServiceInf {
    List<Kind> showOneSelect();

    List<Brand> showLevelTwoSelects(Integer kid);

    List<Phoneinfo> showLevelThreeSelects(Integer bid);

    PageInfo<ModelViewbean> showModels(Integer page, Integer pageSize,
                                       String kind, String brand, String phone);

    int deleteOrdersBypids(String[] pids);

    int deleteOrdersBypid(String pid);

    int findModelByThree(String cz, String brand, String phone);

    void addPmodel(String phone,String brand);

    int findBrandByBidAndKid(String cz, String brand);

    void addPbrand(String cz, String brand);

    int findKindByName(String cz);

    void addkName(String cz);


    //邱思琪部分
}
