package com.jskj.order.service.impl;

import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;
import com.jskj.order.dao.MessageMapper;
import com.jskj.order.service.MessServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
@Service
public class MessSerImpl implements MessServiceInf {
    @Autowired
    private MessageMapper messageMapper;
    /**
     * 查看用户所有未读消息
     */
    public List<Message> findByUid(int uid) {
        return messageMapper.findByUid(uid);
    }
    /**
     * 修改消息状态为已读
     */
    public int uadateState(Message message) {
        return messageMapper.uadateState(message);
    }
    /**
     * 修改所有的未读为已读
     */
    public int readall(Userinfo userinfo) {
        return messageMapper.readall(userinfo);
    }
}
