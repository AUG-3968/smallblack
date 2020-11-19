package com.jskj.order.dao;

import com.jskj.entities.Message;
import com.jskj.entities.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lintao
 */
@Mapper
public interface MessageMapper {
    @Select("select * from message where uid = #{uid} and mstate = 1 ")
    List<Message> findByUid(int uid);

    @Update("update message set mstate=2 where mis=#{mis}")
    int uadateState(Message message);
    @Update("update message set mstate=2 where uid=#{uid}")
    int readall(Userinfo userinfo);

}
