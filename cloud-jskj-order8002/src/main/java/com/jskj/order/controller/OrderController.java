package com.jskj.order.controller;

import com.github.pagehelper.PageInfo;
import com.jskj.entities.*;
import com.jskj.order.service.MessServiceInf;
import com.jskj.order.service.OrderServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lintao
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceInf orderserimpl;
    @Autowired
    private MessServiceInf messServiceInf;
    //商品管理模块开始
    @RequestMapping("/order/orders")
    @CrossOrigin
    public HashMap<String, Object> page(Integer page, Integer pageSize, String time, String content, String uid, String uoid, HttpServletRequest request){
        PageInfo<OrmanaViewbean> info = orderserimpl.showOrders(page, pageSize,time,content,uid,uoid);
        System.out.println(info);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", info.getTotal());
        map.put("data", info.getList());
        return map;
    }

    @RequestMapping("/order/deleteOrdersByoids.action")
    @CrossOrigin
    public int deleteLogisticsByoids(String[] oids) {
        int num = orderserimpl.deleteOrdersByoids(oids);
        return num;
    }
    @RequestMapping("/order/deleteOrdersByoid.action")
    @CrossOrigin
    public int deleteLogisticsByoid(String oid){
        int num = orderserimpl.deleteOrdersByoid(oid);
        return num;
    }
    @RequestMapping("/order/agreeproduc.action")
    @CrossOrigin
    public  int agreeproduc(String[] oids){
        int num = orderserimpl.agreeproducByoids(oids);
        return num;
    }
    @RequestMapping("/order/agreerefund.action")
    @CrossOrigin
    public  int agreerefund(String[] oids){
        int num = orderserimpl.agreerefundByoids(oids);
        return num;
    }
    //商品管理模块结束
    @RequestMapping("/order/customer/searchPhone.action")
    @CrossOrigin
    public  List<Kind> searchPhoneModel() {
        List<Kind> list = orderserimpl.searchPhoneModel();
        return list;
    }


    @RequestMapping("/order/customer/uploadPhoto.action")
    @CrossOrigin
    public  HashMap<String, Object> uploadPhoto(MultipartFile file, Model model) throws IllegalStateException, IOException {
        //获取提交上来的原始文件名
        String originalName = file.getOriginalFilename();
        //对提交上来的文件名进行处理，去除前面的  文件路径  c:/photo/ssss.jpg  保留  ssss.jpg
        String fileName =
                originalName.substring(originalName.lastIndexOf(File.separator) + 1);
        //对文件名加入随机数进行去重处理
        String newFileName = System.currentTimeMillis() +
                (new Random().nextInt(8999999)+1000000)
                + fileName;
        //创建一个日期分割的文件夹用来放图片
        //获取当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String today = sdf.format(new Date());

        //创建用来存储这个文件的文件夹  d:/test/2019/06/12
        File uFile = new File("g:/upload/"+today);

        //判断这个文件夹是否存在如果不存在就多级创建
        if(!uFile.exists()){
            uFile.mkdirs();
        }


        //将文件输出到指定目录
        String newPath = "g:/upload/"+today + "/" + newFileName;
        File newFile = new File(newPath);
        file.transferTo(newFile);
        newPath = "/upload/"+today + "/" + newFileName;
        model.addAttribute("newPath",newPath);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("cod", 0);
        map.put("msg","");
        HashMap<String, Object> date = new HashMap<String, Object>();
        date.put("src", newPath);
        map.put("data", date);
        return map;
    }

    /**
     * 跳转到diy定制页面
     * @return
     */
    @RequestMapping("/order/getMessage")
    @CrossOrigin
    public String getMessage(Model model, HttpSession session){
        Userinfo userinfo = (Userinfo)session.getAttribute("use");
        List<Message> lisMessages = messServiceInf.findByUid(userinfo.getUid());
        model.addAttribute("message", lisMessages);
        return "/jsp/customer/diy.jsp";
    }



    @RequestMapping("/order/customer/addcart.action")
    @CrossOrigin
    public   HashMap<String, Object> addcart(Model model, @RequestBody Excleinfo info,HttpServletRequest request ){
        String adress = info.getProvince()+info.getCity()+info.getCounty()+info.getLadress();
        info.setLadress(adress);
        double slingnumber = info.getSlingnumber();
        double holdernumber= info.getHoldernumber();
        System.out.println(holdernumber);
        if (slingnumber !=0) {
            double Sling = slingnumber*5;
            info.setSlingnumber(Sling);
        }
        if (holdernumber != 0) {
            double holder = holdernumber*5;
            info.setHoldernumber(holder);
        }
        HttpSession session =request.getSession();
        Userinfo userinfo = (Userinfo) session.getAttribute("use");
        System.out.println(userinfo);
        info.setUid(userinfo.getUid());
        info.setExtype(1);
        int seccses = orderserimpl.addCrat(info);
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("code", seccses);
        return map;
    }

    @RequestMapping("/order/customer/searchCart.action")
    @CrossOrigin
    public  HashMap<String,Object> searchCart(Integer page,Integer limit,HttpSession session,String extype){
        Userinfo userinfo = (Userinfo) session.getAttribute("use");
        List<Excleinfo> list = orderserimpl.searchCart(page,limit,userinfo.getUid(), Integer.parseInt(extype));
        list.toString();
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg", "");
        map.put("count", orderserimpl.countCart(userinfo.getUid(), Integer.parseInt(extype)));
        map.put("data", list);
        return map;
    }

    @RequestMapping("/order/customer/deleteCart.action")
    @CrossOrigin
    public void deleteUser(Integer exid) {
        int num = orderserimpl.deleteUser(exid);
    }

    @RequestMapping("/order/customer/insertOrder.action")
    @CrossOrigin
    public  int insertOrder(Integer[] lids,HttpSession session) {
        List<Integer> a = new ArrayList<Integer>();
        for (Integer i : lids) {
            a.add(i);
        }
        Userinfo userinfo = (Userinfo) session.getAttribute("use");
        Integer tate = orderserimpl.addOrder(a,userinfo);
        if(tate > 0){
            return 1;
        }else {
            return 0;
        }
    }

//    @RequestMapping("/order/customer/form.action")
//    @CrossOrigin
//    public String form(MultipartHttpServletRequest request, Model model, HttpSession session) throws IOException {
//        List<Excleinfo> loclist = new ArrayList<Excleinfo>();
//        List<List<Object>> list = ExcelRead.MyExcel(request);
//        int tbid = 0;
//        int lname = 0;
//        int linePhone = 0;
//        int phone = 0;
//        int ladress = 0;
//        int pModel = 0;
//        int pNumber = 0;
//        System.out.println(list.get(0).size());
//        for(int i = 0;i < list.get(0).size();i++){
//            System.out.println(list.get(0).get(i));
//        }
//        for (int i = 0;i<list.get(0).size();i++) {
//            if(((String)list.get(0).get(i)).contains("订单编号")) {
//                tbid = i;
//            }
//            if(((String)list.get(0).get(i)).contains("收件人")) {
//                lname = i;
//            }
//            if(((String)list.get(0).get(i)).contains("固话")) {
//                linePhone = i;
//            }
//            if(((String)list.get(0).get(i)).contains("手机")) {
//                phone = i;
//            }
//            if(((String)list.get(0).get(i)).contains("地址")) {
//                ladress = i;
//            }
//            if(((String)list.get(0).get(i)).contains("发货信息")) {
//                pModel = i;
//            }
//            if(((String)list.get(0).get(i)).contains("宝贝数量")) {
//                pNumber = i;
//            }
//        }
//        System.out.println(list.get(0).size());
//        System.out.println(list.size());
//        for(int i = 1;i<list.size();i++) {
//            Excleinfo loc = new Excleinfo();
//            if ((String)list.get(i).get(tbid) == null) {
//                loc.setTbid((String)list.get(i).get(tbid));
//                i--;
//            }else {
//                loc.setTbid((String)list.get(i).get(tbid));
//            }
//            if ((String)list.get(i).get(lname) == null) {
//                loc.setLame((String)list.get(i).get(lname));
//                i--;
//            }else {
//                loc.setLame((String)list.get(i).get(lname));
//            }
//            if (((String)list.get(i).get(linePhone)).equals("")) {
//                loc.setLame((String)list.get(i).get(linePhone));
//                i--;
//            }else {
//                loc.setLame((String)list.get(i).get(linePhone));
//            }
//            if ((String)list.get(i).get(phone) == null) {
//                loc.setConnumber((String)list.get(i).get(phone));
//                i--;
//            }else {
//                loc.setConnumber((String)list.get(i).get(phone));
//            }
//            if ((String)list.get(i).get(ladress) == null) {
//                loc.setConnumber((String)list.get(i).get(ladress));
//                i--;
//            }else {
//                loc.setConnumber((String)list.get(i).get(ladress));
//            }
//            if ((String)list.get(i).get(pModel) == null) {
//                loc.setConnumber((String)list.get(i).get(pModel));
//                i--;
//            }else {
//                loc.setConnumber((String)list.get(i).get(pModel));
//            }
//            if ((String)list.get(i).get(pNumber) == null) {
//                i--;
//            }else {
//                loc.setPnnumber((int)Double.parseDouble(((String) list.get(i).get(pNumber)).trim()));
//            }
//
//            System.out.println((int)Double.parseDouble(((String) list.get(i).get(pNumber)).trim()));
//            loclist.add(loc);
//        }
//        Userinfo userinfo = (Userinfo) session.getAttribute("use");
//        for(int i = 0;i<loclist.size();i++){
//            Excleinfo info=loclist.get(i);
//            info.setUid(userinfo.getUid());
//            info.setExtype(2);
//            if (info.getOsendinfo().split(" ").length > 1) {
//                int pnnumber = info.getPnnumber();
//                info.setPnnumber(pnnumber-1);
//                for(int j = 1;j <info.getOsendinfo().split(" ").length;j++){
//                    Excleinfo infos = new Excleinfo();
//                    infos.setTbid(info.getTbid());
//                    infos.setLame(info.getLame());
//                    infos.setLinephone(info.getLinephone());
//                    infos.setConnumber(info.getConnumber());
//                    infos.setLadress(info.getLadress());
//                    infos.setOsendinfo(info.getOsendinfo().split(" ")[j]);
//                    infos.setPnnumber(1);
//                    infos.setUid(info.getUid());
//                    infos.setExtype(2);
//                    loclist.add(infos);
//                }
//            };
//        }
//        for(int i = 0;i<loclist.size();i++){
//            System.out.println(loclist.get(i).toString());
//        }
//        orderserimpl.insertExcel(loclist);
//        return "/customer/batch.jsp";
//    }
}
