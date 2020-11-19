package com.jskj.order.controller;

import com.alibaba.fastjson.JSON;
import com.jskj.entities.OrderListSeach;
import com.jskj.entities.Orderinfo;
import com.jskj.entities.Userinfo;
import com.jskj.order.service.OrderServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lintao
 */
@RestController
@Slf4j
public class OrderlistCtroller {
    @Autowired
    private OrderServiceInf orderServiceInf;

    @RequestMapping("/orderlist/orderlist")
    @CrossOrigin
    public HashMap<String, Object> orderlist(Integer page, Integer limit, HttpSession session, String time, String content){
        if("" == time && "" == content ){
            HashMap<String, Object> map = new HashMap<String, Object>();
            Userinfo use = (Userinfo)session.getAttribute("use");
            List<OrderListSeach> list = orderServiceInf.orderlist(use,page, limit);
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", orderServiceInf.count(use));
            map.put("data", list);
            return map;
        } else{
            HashMap<String, Object> map = new HashMap<String, Object>();
            Userinfo use = (Userinfo)session.getAttribute("use");
            List<Orderinfo> lists = orderServiceInf.orderlistByCondition(use,page,limit,time,content);
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", orderServiceInf.countByCondition(use,time,content));
            map.put("data", lists);
            return map;
        }
    }
    /**
     * 删除单个订单
     * @param orderinfo
     * @return
     */
    @RequestMapping("/orderlist/deleteByOid")
    @CrossOrigin
    public @ResponseBody Integer deleteByOid(Orderinfo orderinfo){
        Integer tate = orderServiceInf.deleteByOid(orderinfo);
        return tate;
    }
    /**
     * 修改单个订单状态为退款
     * @param orderinfo
     * @return
     */
    @RequestMapping("/orderlist/deleteStateByOid")
    @CrossOrigin
    public String deleteStateByOid(Orderinfo orderinfo){
        orderServiceInf.deleteStateByOid(orderinfo);
        return "/view/userview/orderview/orderview.jsp";
    }
    /**
     * 批量删除
     * @return
     */
    @RequestMapping("/orderlist/deleteAllByOid")
    @CrossOrigin
    public  Integer deleteAllByOid(String[] lids){
        List<String> a = new ArrayList<String>();
        for (String i : lids) {
            a.add(i);
        }
        Integer tate = orderServiceInf.deleteAllByOid(a);
        if(tate > 0){
            return 1;
        }else {
            return 0;
        }
    }
    /**
     * 批量退款
     * @param lids
     * @return
     */
    @RequestMapping("/orderlist/refundAll")
    @CrossOrigin
    public Integer refundAll(String[] lids){
        List<String> a = new ArrayList<String>();
        for (String i : lids) {
            a.add(i);
        }
        Integer tate = orderServiceInf.refundAll(a);
        if(tate > 0){
            return 1;
        }else {
            return 0;
        }

    }
}
