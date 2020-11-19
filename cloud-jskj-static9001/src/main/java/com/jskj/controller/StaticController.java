package com.jskj.controller;

import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;
import com.jskj.service.MessServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lintao
 */
@Controller
public class StaticController {
    @Autowired
    private MessServiceInf messServiceInf;
    @RequestMapping("jiemian/login")
    public String login(){
        return "public/login";
    }
    @RequestMapping("jiemian/diy")
    public String diy(){
        return "customer/diy";
    }
    @RequestMapping("jiemian/batch")
    @CrossOrigin
    public String batch(){
        return "batch";
    }
    @RequestMapping("jiemian/admin")
    @CrossOrigin
    public String admin(){
        return "manerview/admin";
    }
    @RequestMapping("jiemian/logistics")
    @CrossOrigin
    public String logistics(){
        return "manerview/logistics";
    }
    @RequestMapping("jiemian/model")
    @CrossOrigin
    public String model(){
        return "manerview/model";
    }
    @RequestMapping("jiemian/modelmanager")
    @CrossOrigin
    public String modelmanager(){
        return "manerview/modelmanager";
    }
    @RequestMapping("jiemian/ordermanager")
    @CrossOrigin
    public String ordermanager(){
        return "manerview/ordermanager";
    }
    @RequestMapping("jiemian/user")
    @CrossOrigin
    public String user(){
        return "manerview/user";
    }
    @RequestMapping("jiemian/findpwd")
    @CrossOrigin
    public String findpwd(){
        return "findpwd";
    }
    @RequestMapping("jiemian/register")
    @CrossOrigin
    public String register(){
        return "public/register";
    }
    @RequestMapping("jiemian/myinformation")
    @CrossOrigin
    public String myinformation(){
        return "myinformation";
    }

    /**
     * 跳转到订单管理页面
     * @return
     */
    @RequestMapping("/jiemian/getOrdermess")
    @CrossOrigin
    public String getOrdermess(Model model, HttpSession session){
        Userinfo userinfo = (Userinfo)session.getAttribute("use");
        System.out.println(userinfo);
        List<Message> lisMessages = messServiceInf.findByUid(userinfo.getUid());
        model.addAttribute("message", lisMessages);
        return "userview/orderview/orderview";
    }

    /**
     * 跳转到物流管理页面
     * @return
     */
    @RequestMapping("/jiemian/getWuliumess")
    @CrossOrigin
    public String getWuliumess(Model model,HttpSession session){
        Userinfo userinfo = (Userinfo)session.getAttribute("use");
        List<Message> lisMessages = messServiceInf.findByUid(userinfo.getUid());
        model.addAttribute("message", lisMessages);
        return "userview/information/logisticsinformation";
    }
    @RequestMapping("/jiemian/findMyinformation")
    @CrossOrigin
    public String findMyinformation(Model model, HttpSession session, HttpServletRequest request){
        //Userinfo userinfo = (Userinfo) session.getAttribute("use");
        Userinfo userinfo = (Userinfo)session.getAttribute("use");
        List<Message> lisMessages = messServiceInf.findByUid(userinfo.getUid());
        model.addAttribute("message", lisMessages);
        return "/userview/information/myinformation";
    }

}
