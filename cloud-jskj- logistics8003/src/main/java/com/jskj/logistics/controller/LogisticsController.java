package com.jskj.logistics.controller;

import com.jskj.entities.LogisticsAndContactAndOrderinfoAndOrderdetails;
import com.jskj.entities.LogisticsAndOrderdetailsAndContact;
import com.jskj.entities.Userinfo;
import com.jskj.logistics.service.LogisticsServiceInf;
import com.jskj.logistics.util.ExcelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lintao
 */
@Controller
public class LogisticsController {
    @Autowired
    private LogisticsServiceInf logisticsSerImpl;

    /**
     * 物流信息的查询
     * @param page
     * @param limit
     * @param time
     * @param content
     * @param session
     * @return
     */
    @RequestMapping("/logistics/logistics")
    @CrossOrigin
    @ResponseBody
    public HashMap<String,Object> findlogistics(Integer page, Integer limit, String time, String content, HttpSession session){
        Userinfo u = (Userinfo) session.getAttribute("use");
        List<LogisticsAndContactAndOrderinfoAndOrderdetails> list = logisticsSerImpl.findlogistics(page, limit,time,content,u.getUid());
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", logisticsSerImpl.countUser());
        map.put("data", list);
        return map;
    }

    /**
     * 物流信息的查询的总语句
     * @return
     */
    @RequestMapping("/logistics/countShowUser")
    @CrossOrigin
    public @ResponseBody Long countShowUser(){
        return logisticsSerImpl.countUser();
    }

    /**
     * 单条页面假删
     * @param oid
     */
    @RequestMapping("/logistics/updateLogistics")
    @CrossOrigin
    @ResponseBody
    public void updateLogistics(String oid){
        int num = logisticsSerImpl.updateLogistics(oid);
    }

    /**
     * 批量页面假删
     * @param oids
     * @return
     */
    @RequestMapping("/logistics/deleteLogisticsByOid")
    @CrossOrigin
    public @ResponseBody int deleteLogisticsByOid(String[] oids) {
        for(String id: oids) {
        }
        int num = logisticsSerImpl.deleteLogisticsByOid(oids);
        return num;
    }
    //后台管理


    @RequestMapping("/logistics/findAllLogistic")
    @CrossOrigin
    public @ResponseBody HashMap<String, Object> findAllLogistics(Integer isyes,Integer isno,Integer page,Integer limit) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Long count=0l;
        List<LogisticsAndOrderdetailsAndContact> list = null;
        if(isno==0 && isyes==0) {
            list = logisticsSerImpl.findAllLogistics(page,limit);
            count=logisticsSerImpl.countlogistics();
        }else if (isno==1 && isyes==0) {
            list = logisticsSerImpl.findNo(page,limit);
            count=logisticsSerImpl.countByNo();
        }else {
            list = logisticsSerImpl.findYes(page,limit);
            count=logisticsSerImpl.countByYes();
        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/logistics/deleteLogisticsByLid")
    @CrossOrigin
    public @ResponseBody int deleteLogisticsByLid(Integer[] lids) {
        for(Integer id: lids) {
            System.out.println(id);
        }
        int num = logisticsSerImpl.deleteLogisticsByLid(lids);
        return num;
    }
    @RequestMapping("/logistics/deleteLogistics")
    @CrossOrigin
    public @ResponseBody int deleteLogistics(Integer lids) {
        int num = logisticsSerImpl.deleteLogistics(lids);
        return num;
    }
    @RequestMapping("/logistics/form")
    @CrossOrigin
    public void form(MultipartHttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
        List<LogisticsAndOrderdetailsAndContact> loclist = new ArrayList<LogisticsAndOrderdetailsAndContact>();
        List<String[]> list = ExcelData.getExcelData(request.getFile("forms"));
        for(int i = 0;i<list.size();i++) {
                LogisticsAndOrderdetailsAndContact loc = new LogisticsAndOrderdetailsAndContact();
                loc.setTbid((String)list.get(i)[0]);
                loc.setLcompany((String)list.get(i)[2]);
                loc.setLorder((String)list.get(i)[1]);
                loclist.add(loc);
        }
        logisticsSerImpl.insertDatas(loclist);
        response.sendRedirect("http://localhost:9527/jiemian/logistics");
    }
}
