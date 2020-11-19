package com.jskj.model.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.entities.Brand;
import com.jskj.entities.Kind;
import com.jskj.entities.ModelViewbean;
import com.jskj.entities.Phoneinfo;
import com.jskj.model.dao.ModelMapper;
import com.jskj.model.service.ModelServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
@Service
public class ModelSerImpl implements ModelServiceInf {
    @Autowired
    private ModelMapper modelmapper;
    //邱思琪部分
    public List<Kind> showOneSelect() {
        return modelmapper.showOneSelect();
    }

    public List<Brand> showLevelTwoSelects(Integer kid) {
        return modelmapper.showLevelTwoSelects(kid);
    }

    public List<Phoneinfo> showLevelThreeSelects(Integer bid) {
        return modelmapper.showLevelThreeSelects(bid);
    }

    public PageInfo<ModelViewbean> showModels(Integer page, Integer pageSize,
                                              String kind, String brand, String phone) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        String bname = "";
        String pmodel = "";
        if(brand !="" && brand!= null){
            String[] split = brand.split("phone=");
            bname = split[0].trim();
            pmodel = split[1].trim();
        }
        if(kind.equals("0")){
            System.out.println("111");
            kind ="";
        }
        if(bname.equals("0")){
            System.out.println("111");
            bname ="";
        }
        if(pmodel.equals("0")){
            System.out.println("333");
            pmodel ="";
        }
        List<ModelViewbean> list = modelmapper.findAllModel(kind,bname,pmodel);
        System.out.println(list);
        PageInfo<ModelViewbean> pagelist = new PageInfo<ModelViewbean>();
        pagelist.setList(list);
        System.out.println(pagelist);
        return pagelist;
    }

    public int deleteOrdersBypids(String[] pids) {
        System.out.println("lo");
        for(String i:pids){
            System.out.println(i);
        }
        System.out.println("pl");
        return modelmapper.deleteOrdersBypids(pids);
    }

    @Override
    public int deleteOrdersBypid(String pid) {
        return modelmapper.deleteOrdersBypid(pid);
    }
    //邱思琪部分

    @Override
    public int findModelByThree(String cz, String brand, String phone) {
        return modelmapper.findModelByThree(cz,brand,phone);
    }

    @Override
    public void addPmodel(String phone,String brand) {
        modelmapper.addPmodel(phone,brand);
    }

    @Override
    public int findBrandByBidAndKid(String cz, String brand) {
        return modelmapper.findBrandByBidAndKid(cz,brand);
    }

    @Override
    public void addPbrand(String cz, String brand) {
        modelmapper.addPbrand(cz,brand);
    }

    @Override
    public int findKindByName(String cz) {
        return modelmapper.findKindByName(cz);
    }

    @Override
    public void addkName(String cz) {
        modelmapper.addkName(cz);
    }
}
