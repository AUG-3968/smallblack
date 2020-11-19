package com.jskj.user.controller;

import com.jskj.entities.UserAndOrder;
import com.jskj.entities.Userinfo;
import com.jskj.user.service.UserServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author lintao
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceInf userSerImpl;



    /**
     * 修改头像
     * @param file
     * @param request
     * @param session
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/user/changdePhoto")
    public @ResponseBody
    HashMap<String, Object> changePhoto(MultipartFile file, HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
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

        //创建用来存储这个文件的文件夹  e:/test/2019/06/12
        File photo = new File("f:/upload/"+today);

        //判断这个文件夹是否存在如果不存在就多级创建
        if(!photo.exists()){
            photo.mkdirs();
        }
        //将文件输出到指定目录
        String newPath = "f:/upload/"+today + "/" + newFileName;
        File newFile = new File(newPath);
        file.transferTo(newFile);
        newPath = "/upload/"+today + "/" + newFileName;
        System.out.println(newPath);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        HashMap<String,String> data = new HashMap<String,String>();
        data.put("src", newPath);
        map.put("data", data);

        Userinfo u = (Userinfo) session.getAttribute("use");
        int num = userSerImpl.UpdatePhoto(newPath,u.getUid());
        Userinfo use = userSerImpl.FindUid(u.getUid());
        session.setAttribute("use", use);
        return map;
    }
    /**
     * 修改个人信息
     * @param userinfo
     * @param session
     * @return
     */
    @RequestMapping("/user/update")
    public String UpdateInfomation(Userinfo userinfo,HttpSession session){
        Userinfo u = (Userinfo) session.getAttribute("use");
        int num = userSerImpl.UpdateInformation(userinfo);
        if(num != 1) {
            return "/findMyinformation.action";
        }
        Userinfo use = userSerImpl.FindUid(u.getUid());
        session.setAttribute("use", use);
        return "/findMyinformation.action";

    }

    /**
     * 查询密码是否和原来的一样
     * 新密码不能和原密码一致
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/user/judgepwd")
    public @ResponseBody String judgePwd(String pwd,HttpSession session){
        Userinfo u = (Userinfo) session.getAttribute("use");
        String oldpwd = u.getUpwd();
        if(oldpwd.equals(pwd)){
            return "same";
        }else {
            return "bu";
        }
    }
    /**
     * 修改密码
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/user/updatepwd")
    public int UpdatePwd(String pwd, HttpSession session) {
        Userinfo u = (Userinfo) session.getAttribute("use");
        int num = userSerImpl.UpdatePwd(pwd,u.getUid());
        Userinfo use = userSerImpl.FindUid(u.getUid());
        session.setAttribute("use", use);
        return num;
    }
    @RequestMapping("/user/findUserAndMoney")
    public @ResponseBody HashMap<String,Object> findUserAndMoney(Integer page,Integer limit){
        List<UserAndOrder> list = userSerImpl.findAllUser(page,limit);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", userSerImpl.countUser());
        map.put("data", list);
        return map;
    }
    //修改用户的状态（禁用/启用）
    @RequestMapping("/user/lockUser")
    public void lockUser(Integer uid,Integer ustate) {
        int num = userSerImpl.lockUser(uid,ustate);
    }
    //删除用户
    @RequestMapping("/deleteUser.action")
    public void deleteUser(Integer uid) {
        int num = userSerImpl.deleteUser(uid);
    }
    //查询所有的管理员信息
    @RequestMapping("/user/findAdminAndMoney")
    public @ResponseBody HashMap<String,Object> findAdminAndMoney(Integer page,Integer limit){
        List<Userinfo> list = userSerImpl.findAllAdmin(page,limit);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", userSerImpl.countAdmin());
        map.put("data", list);
        return map;
    }
    //新增用户
    @RequestMapping("/user/addAdmin")
    public @ResponseBody int addAdmin(Userinfo userinfo) {
        Userinfo user = userSerImpl.findAdmin(userinfo.getUno());
        if(user==null) {
            int num = userSerImpl.addAdmin(userinfo);
            return num;
        }else {
            return 0;
        }
    }
}
