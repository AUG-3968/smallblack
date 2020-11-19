package com.jskj.user.service.impl;

import com.jskj.entities.UserAndOrder;
import com.jskj.entities.Userinfo;
import com.jskj.entities.UserinfoValidation;
import com.jskj.user.dao.UserMapper;
import com.jskj.user.service.UserServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
@Service
public class UserServiceImpl implements UserServiceInf {
    @Autowired
    private UserServiceInf userServiceInf;
    @Autowired
    private UserMapper userMapper;

    /**
     * 修改信息
     */
    public Integer UpdateInformation(Userinfo userinfo) {
        return userServiceInf.UpdateInformation(userinfo);
    }

    /**
     * 修改头像
     */
    public Integer UpdatePhoto(String newPath, Integer uid) {
        return userServiceInf.UpdatePhoto(newPath, uid);
    }

    /**
     * 修改密码
     */
    public Integer UpdatePwd(String upwd, Integer uid) {
        return userServiceInf.UpdatePwd(upwd, uid);
    }

    /**
     *通过id 查找个人信息
     */
    public Userinfo FindUid(Integer uid) {
        return userServiceInf.FindUid(uid);
    }


    public Userinfo find(Userinfo userinfo) {
        return userMapper.findOne(userinfo);
    }

    /**
     * 根据账号查找用户
     */
    public Userinfo findByUno(Userinfo userinfo) {
        return userMapper.findByUno(userinfo);
    }

    /**
     * 注册用户
     */
    public Integer addUse(UserinfoValidation userinfo) {
        return userMapper.addUse(userinfo);
    }

    /**
     * 根据账号判断收款账号是否正确
     */
    public Userinfo judgerefund(Userinfo userinfo) {
        return userMapper.judgerefund(userinfo);
    }

    /**
     * 找回密码
     */
    public Integer findUserpwd(Userinfo userinfo) {
        return userMapper.findUserpwd(userinfo);
    }

    //陈妮部分
//	public Userinfo find(Userinfo userinfo) {
//		return userMapper.findOne(userinfo);
//	}
    @Override
    public List<UserAndOrder> findAllUser(Integer page, Integer limit) {
        return userMapper.findAllUser((page-1)*limit,limit);
    }
    @Override
    public Long countUser() {
        return userMapper.countUser();
    }
    @Override
    public int lockUser(Integer uid,Integer ustate) {
        return userMapper.lockUser(uid,ustate);
    }
    @Override
    public int deleteUser(Integer uid) {
        return userMapper.deleteUser(uid);
    }
    @Override
    public List<Userinfo> findAllAdmin(Integer page, Integer limit) {
        return userMapper.findAllAdmin((page-1)*limit,limit);
    }
    @Override
    public Long countAdmin() {
        return userMapper.countAdmin();
    }
    @Override
    public int addAdmin(Userinfo userinfo) {
        return userMapper.addAdmin(userinfo);
    }
    @Override
    public Userinfo findAdmin(String uno) {
        return userMapper.findAdmin(uno);
    }
    //陈妮部分

}
