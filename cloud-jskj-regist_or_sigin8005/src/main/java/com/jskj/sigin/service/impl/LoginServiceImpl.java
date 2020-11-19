package com.jskj.sigin.service.impl;

import com.jskj.entities.UserAndOrder;
import com.jskj.entities.Userinfo;
import com.jskj.entities.UserinfoValidation;
import com.jskj.sigin.dao.LoginMapper;
import com.jskj.sigin.service.LoginServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
@Service
public class LoginServiceImpl implements LoginServiceInf {
        @Autowired
        private LoginMapper loginMapper;

        public Userinfo find(Userinfo userinfo) {
            return loginMapper.findOne(userinfo);
        }

        /**
         * 根据账号查找用户
         */
        public Userinfo findByUno(Userinfo userinfo) {
            return loginMapper.findByUno(userinfo);
        }

        /**
         * 注册用户
         */
        public Integer addUse(UserinfoValidation userinfo) {
            return loginMapper.addUse(userinfo);
        }

        /**
         * 根据账号判断收款账号是否正确
         */
        public Userinfo judgerefund(Userinfo userinfo) {
            return loginMapper.judgerefund(userinfo);
        }

        /**
         * 找回密码
         */
        public Integer findUserpwd(Userinfo userinfo) {
            return loginMapper.findUserpwd(userinfo);
        }

    @Override
    public List<UserAndOrder> findAllUser(Integer page, Integer limit) {
        return null;
    }

    @Override
    public Long countUser() {
        return null;
    }

    @Override
    public int lockUser(Integer uid, Integer ustate) {
        return 0;
    }

    @Override
    public int deleteUser(Integer uid) {
        return 0;
    }

    @Override
    public List<Userinfo> findAllAdmin(Integer page, Integer limit) {
        return null;
    }

    @Override
    public Long countAdmin() {
        return null;
    }

    @Override
    public int addAdmin(Userinfo userinfo) {
        return 0;
    }

    @Override
    public Userinfo findAdmin(String uno) {
        return null;
    }
}
