package com.jskj.sigin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;
import com.jskj.entities.UserinfoValidation;
import com.jskj.sigin.service.LoginServiceInf;
import com.jskj.sigin.service.MessServiceInf;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

/**
 * @author lintao
 */
@Controller
public class LoginController {
    @Autowired
    private LoginServiceInf loginServiceInf;
    @Autowired private MessServiceInf messServiceInf;

    /**
     * 登录请求
     * @param userinfo
     * @param model
     * @return
     */
    @RequestMapping(value="/ls/login" ,method= RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public JSONObject longin(Userinfo userinfo, HttpServletRequest request, Model model){
        System.out.println(userinfo);
        Userinfo userinfo2 = loginServiceInf.find(userinfo);
        //登录成功
        HttpSession session = request.getSession();
        System.out.println(userinfo2);
        JSONObject json = new JSONObject();
        if(userinfo2 != null){
            session.setAttribute("use", userinfo2);
            if(userinfo2.getUstate() == 1){
                session.setAttribute("mes", "该用户已被锁定，请联系管理员");
                json.put("code",0);
                return json;
            }else {
                if(userinfo2.getUgrade() == 1){
                    //前台首页界面
                    List<Message> lisMessages = messServiceInf.findByUid(userinfo2.getUid());
                    session.setAttribute("message", lisMessages);
                    json.put("code",1);
                    System.out.println(session.getAttribute("use"));
                    return json;
                }else {
                    //后台管理界面
                    json.put("code",2);
                    return json;
                }
            }
        }else {
            //登录失败
            model.addAttribute("mes", "账号或密码错误");
            System.out.println(session.getAttribute("use"));
            json.put("code",0);
            return json;
        }
    }
    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/ls/quit")
    @CrossOrigin
    public String quit(HttpSession session){
        session.invalidate();
        return "/view/public/login.jsp";
    }
    /**
     * 根据用户账号查找账号是否已存在
     * @param userinfo
     * @return
     */
    @RequestMapping("/ls/judgeuno")
    @CrossOrigin
    @ResponseBody
    public String findByUno(Userinfo userinfo){
        Userinfo use = loginServiceInf.findByUno(userinfo);
        if(use != null){
            return "cun";
        }else {
            return "bu";
        }
    }
    /**
     * 判断收款账号是否存在
     * @param userinfo
     * @return
     */
    @RequestMapping("/ls/judgerefund")
    @CrossOrigin
    @ResponseBody
    public String judgerefund(Userinfo userinfo){
        Userinfo use = loginServiceInf.judgerefund(userinfo);
        if(use != null){
            return "cun";
        }else {
            return "bu";
        }
    }

    /**
     * 注册用户
     * @param userinfo
     * @return
     */
    @RequestMapping("/ls/addUse")
    @CrossOrigin
    public void addUse(UserinfoValidation userinfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
        userinfo.setUstate(2);
        userinfo.setUsex(2);
        userinfo.setUgrad(1);
        userinfo.setUphoto("/img/ss.jpg");
        Integer i = loginServiceInf.addUse(userinfo);
        System.out.println(userinfo);
        if (i != 1) {
            response.sendRedirect("http://localhost:9527/jiemian/register");
        }
        response.sendRedirect("http://localhost:9527/jiemian/login");
    }

//    /**
//     * 找回密码，重新设置密码
//     * @return
//     */
//    @RequestMapping("/ls/findUserpwd")
//    @CrossOrigin
//    public String findUserpwd(Userinfo userinfo){
//        Integer s = loginServiceInf.findUserpwd(userinfo);
//        if(s > 0){
//            return "/view/public/login.jsp";
//        }else {
//            return "/view/public/findpwd.jsp";
//        }
//    }
    /**
     *	获取图形验证码
     * @param request
     * @param response
     */
    @RequestMapping("/ls/getcode")
    @CrossOrigin
    public void getcode(HttpServletRequest request, HttpServletResponse response){
        System.out.println("");
        //设置响应编码
        String code = "";
        response.setContentType("image/jpeg");

        //获得从内存中画图的对象
        BufferedImage im = new BufferedImage(88, 47, BufferedImage.TYPE_INT_BGR);
        //画笔
        Graphics g = im.getGraphics();
        //画笔颜色
        g.setColor(new Color(239, 239, 239));
        //画实心矩形
        g.fillRect(0, 0, 88, 47);

        // ? 样式  大小
        g.setFont(new Font("", 15, 40));
        // 画的String 从x开始画   要画的高度Y
        String s = new Random().nextInt(9)+"";
        code = code+s;
        g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        g.drawString(s+"", 5, 40);
        s = new Random().nextInt(9)+"";
        code = code+s;
        g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        g.drawString(s, 25, 40);
        s = new Random().nextInt(9)+"";
        code = code+s;
        g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        g.drawString(s, 45, 40);
        s = new Random().nextInt(9)+"";
        code = code+s;
        g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        g.drawString(s, 65, 40);

        HttpSession se = request.getSession();
        se.setAttribute("code", code);
        //输出给浏览器
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //压缩
        JPEGImageEncoder encoder =  JPEGCodec.createJPEGEncoder(out);
        //开始压缩
        try {
            encoder.encode(im);
        } catch (ImageFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
