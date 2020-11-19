package com.jskj.order.service;

import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;

import java.util.List;

/**
 * @author lintao
 */
public interface MessServiceInf {
    /**
     * 查看用户所有未读消息
     * @param uid
     * @return
     */
    List<Message> findByUid(int uid);

    /**
     * 修改消息为已读状态
     * @param message
     * @return
     */
    int uadateState(Message message);
    /**
     * 修改所有未读为已读
     * @param userinfo
     * @return
     */
    int readall(Userinfo userinfo);

}
