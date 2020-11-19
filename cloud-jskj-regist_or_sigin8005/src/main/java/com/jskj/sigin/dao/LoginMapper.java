package com.jskj.sigin.dao;

import com.jskj.entities.UserAndOrder;
import com.jskj.entities.Userinfo;
import com.jskj.entities.UserinfoValidation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lintao
 */
@Mapper
public interface LoginMapper {
    //登陆注册模块开始
    /**
     * 1.用户登陆校验
     * @param userinfo
     * @return
     */
    @Select("select * from userinfo where uno=#{uno} and upwd=#{upwd}")
    Userinfo findOne(Userinfo userinfo);
    /**
     * 注册判断用户账号是否存在
     * @param userinfo
     * @return
     */
    @Select("select * from userinfo where uno=#{uno}")
    Userinfo findByUno(Userinfo userinfo);
    /**
     * 注册用户
     * @param userinfo
     * @return
     */
    @Insert("insert into userinfo(uno,upwd,urealname,umoneryno,uphoto,ustate,ugrade,usex) values(#{uno},#{upwd},#{urealname},#{umoneryno},#{uphoto},#{ustate},#{ugrade},#{usex})")
    Integer addUse(UserinfoValidation userinfo);
    /**
     * 根据用户账号查找收款账号
     * @param userinfo
     * @return
     */
    @Select("select * from userinfo where uno=#{uno} and Umoneryno=#{umoneryno}")
    Userinfo judgerefund(Userinfo userinfo);
    /**
     * 找回密码
     * @param userinfo
     * @return
     */
    @Update("update userinfo set Upwd = #{upwd} where uno=#{uno} and Umoneryno=#{umoneryno}")
    Integer findUserpwd(Userinfo userinfo);
//后台管理
    /**
     * 查询所有普通用户信息和消费总金额
     * @return 普通用户信息的集合
     */
    @Select("SELECT userinfo.*,SUM(osale) osale FROM userinfo LEFT JOIN orderinfo "
            + "ON userinfo.Uid = orderinfo.uid WHERE Ugrade=1 "
            + "GROUP BY uid LIMIT #{arg0},#{arg1}")
    List<UserAndOrder> findAllUser(Integer startRow, Integer limit);
    //startRow 从第0行开始查到9，共十条
    /**
     * 查询用户总人数
     * @return
     */
    @Select("SELECT COUNT(*) FROM userinfo WHERE Ugrade=1")
    Long countUser();
    /**
     * 根据用户id和状态修改对应的用户状态
     * @param uid 用户id
     * @param ustate 要修改的用户的状态
     * @return 修改条数
     */
    @Update("UPDATE userinfo SET Ustate = #{arg1} WHERE uid=#{arg0}")
    int lockUser(Integer uid,Integer ustate);
    /**
     * 根据用户id 删除对应的用户
     * @param uid 用户id
     * @param ustate
     * @return 删除的条数
     */
    @Update("DELETE FROM userinfo WHERE uid=#{arg0}")
    int deleteUser(Integer uid);
    //用户管理结束
    //管理员管理开始
    /**
     * 查询所有管理员信息 超级管理员除外
     * @return 管理员信息的集合
     */
    @Select("SELECT * FROM userinfo WHERE Ugrade IN (2,3)")
    List<Userinfo> findAllAdmin(Integer startRow, Integer limit);
    /**
     * 查询用户总人数
     * @return
     */
    @Select("SELECT COUNT(*) FROM userinfo WHERE Ugrade IN (2,3)")
    Long countAdmin();
    /**
     * 新增管理员
     * @param userinfo 要新增的管理员信息
     * @return
     */
    @Insert("insert into userinfo(uno,upwd,urealname,ugrade) "
            + "values(#{uno},#{upwd},#{urealname},#{ugrade})")
    int addAdmin(Userinfo userinfo);
    /**
     * 根据账号查询管理员是否已存在
     * @param
     * @return
     */
    @Select("select * from userinfo where uno=#{arg0}")
    Userinfo findAdmin(String uno);
}
