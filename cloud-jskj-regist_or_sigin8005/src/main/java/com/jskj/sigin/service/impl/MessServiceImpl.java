package com.jskj.sigin.service.impl;

import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;
import com.jskj.sigin.service.MessServiceInf;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
@Service
public class MessServiceImpl implements MessServiceInf {
    @Override
    public List<Message> findByUid(int uid) {
        return null;
    }

    @Override
    public int uadateState(Message message) {
        return 0;
    }

    @Override
    public int readall(Userinfo userinfo) {
        return 0;
    }
}
