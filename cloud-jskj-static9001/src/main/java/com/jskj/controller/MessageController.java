package com.jskj.controller;

import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;
import com.jskj.service.MessServiceInf;
import com.jskj.service.impl.MessSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lintao
 */
@RestController
public class MessageController {
    @Autowired
    private MessSerImpl messServiceInfl;
    @Autowired
    private MessServiceInf messServiceInf;
    /**
     * 修改消息已读状态
     * @param message
     */
    @RequestMapping("/message/uadateState")
    public String uadateState(Message message, HttpSession session){
        int state = messServiceInfl.uadateState(message);
        System.out.println(state);
        Userinfo userinfo2 = (Userinfo)session.getAttribute("use");
        List<Message> lisMessages = messServiceInf.findByUid(userinfo2.getUid());
//跳物流管理界面
        return "";
    }
    /**
     * 一键已读
     * @param session
     */
    @RequestMapping("/message/readall")
    public @ResponseBody
    String readall(HttpSession session){
        Userinfo userinfo = (Userinfo)session.getAttribute("use");
        int state = messServiceInfl.readall(userinfo);
        return "成功";
    }
}
