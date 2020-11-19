package com.jskj.sigin.service;

import com.jskj.entities.UserAndOrder;
import com.jskj.entities.Userinfo;
import com.jskj.entities.UserinfoValidation;

import java.util.List;

/**
 * @author lintao
 */
public interface LoginServiceInf {
    Userinfo find(Userinfo userinfo);


    /**
     * 根据用户账号查找用户
     * @param userinfo
     * @return
     */
    Userinfo findByUno(Userinfo userinfo);

    /**
     * 注册用户
     * @param userinfo
     * @return
     */
    Integer addUse(UserinfoValidation userinfo);


    /**
     * 判断账号是否存在
     * @param userinfo
     * @return
     */
    Userinfo judgerefund(Userinfo userinfo);

    /**
     * 找回密码
     * @param userinfo
     * @return
     */
    Integer findUserpwd(Userinfo userinfo);
    //陈妮部分
//		Userinfo find(Userinfo userinfo);

    List<UserAndOrder> findAllUser(Integer page, Integer limit);

    Long countUser();

    int lockUser(Integer uid,Integer ustate);

    int deleteUser(Integer uid);

    List<Userinfo> findAllAdmin(Integer page, Integer limit);

    Long countAdmin();

    int addAdmin(Userinfo userinfo);

    Userinfo findAdmin(String uno);
    //陈妮部分
}
