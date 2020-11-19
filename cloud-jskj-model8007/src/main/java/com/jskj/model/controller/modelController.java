package com.jskj.model.controller;

import com.github.pagehelper.PageInfo;
import com.jskj.entities.Brand;
import com.jskj.entities.Kind;
import com.jskj.entities.ModelViewbean;
import com.jskj.entities.Phoneinfo;
import com.jskj.model.service.ModelServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author lintao
 */
@Controller
public class modelController {
    @Autowired
    private ModelServiceInf modelservice;
    //型号管理开始
    @RequestMapping("/model/allmodel")
    @CrossOrigin
    public @ResponseBody

    HashMap<String, Object> page(Integer page, Integer pageSize,String kind, String brand, String phone, HttpServletRequest request){
        System.out.println(page);
        PageInfo<ModelViewbean> info = modelservice.showModels(page, pageSize,kind,brand,phone);
        System.out.println(info);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", info.getTotal());
        map.put("data", info.getList());
        return map;
    }
    @RequestMapping("/model/deleteModelsBypids")
    @CrossOrigin
    public @ResponseBody int deleteLogisticsBypids(String[] pids) {
        int num = modelservice.deleteOrdersBypids(pids);
        return num;
    }
    @RequestMapping("/model/deleteModelsBypid")
    @CrossOrigin
    public @ResponseBody int deleteLogisticsBypid(String pid){
        int num = modelservice.deleteOrdersBypid(pid);
        System.out.println(pid);
        return num;
    }

    @RequestMapping("/model/model")
    @CrossOrigin
    public @ResponseBody
    ModelAndView showSelect(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        List<Kind> goodsList1 = modelservice.showOneSelect();
        for(int i=0;i<goodsList1.size();i++){
            goodsList1.get(i).getKid();
            goodsList1.get(i).getKname();
        }
        mav.addObject("goodsList1", goodsList1);
        mav.setViewName("view/manerview/modelmanager.jsp");
        return mav;
    }


    @RequestMapping("/model/showLevelTwoSelects")
    @CrossOrigin
    public 	@ResponseBody
    List<Brand> showLevelTwoSelects(Integer gtid){
        List<Brand> list = modelservice.showLevelTwoSelects(gtid);
        return list;
    }

    @RequestMapping("/model/showLevelThreeSelects")
    @CrossOrigin
    public 	@ResponseBody List<Phoneinfo> showLevelThreeSelects(Integer gt2id){
        List<Phoneinfo> list = modelservice.showLevelThreeSelects(gt2id);
        return list;
    }
    //型号管理结束
    //模具上传开始
    @RequestMapping("/model/model2")
    @CrossOrigin
    public @ResponseBody ModelAndView showSelect2(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        List<Kind> goodsList1 = modelservice.showOneSelect();
        for(int i=0;i<goodsList1.size();i++){
            goodsList1.get(i).getKid();
            goodsList1.get(i).getKname();
        }
        mav.addObject("goodsList1", goodsList1);
        mav.setViewName("view/manerview/model.jsp");
        return mav;
    }
    @RequestMapping("/model/addmodelthree")
    @CrossOrigin
    public @ResponseBody int addmodelthree(String cz,String brand,String phone) {
        int num = modelservice.findModelByThree(cz,brand,phone);
        if(num==0) {
            modelservice.addPmodel(phone,brand);
            return 1;
        }else {
            return 0;
        }
    }@RequestMapping("/model/addmodeltwo")
    @CrossOrigin
    public @ResponseBody int addmodeltwo(String cz,String brand) {
        int num = modelservice.findBrandByBidAndKid(cz,brand);
        if(num==0) {
            modelservice.addPbrand(cz,brand);
            return 1;
        }else {
            return 0;
        }
    }
    @RequestMapping("/model/addmodelone")
    @CrossOrigin
    public @ResponseBody int addmodelone(String cz) {
        int num = modelservice.findKindByName(cz);
        if(num==0) {
            modelservice.addkName(cz);
            return 1;
        }else {
            return 0;
        }
    }
    //模具上传结束
}
