package com.jskj.order.service;

import com.github.pagehelper.PageInfo;
import com.jskj.entities.*;

import java.util.List;

/**
 * @author lintao
 */
public interface OrderServiceInf {
    /**
     * 查出该用户所有订单
     * @param use
     * @return
     */
    List<OrderListSeach> orderlist(Userinfo use, Integer page, Integer pageSize);

    /**
     * 查询所有订单的总数
     * @return
     */
    Object count(Userinfo order);

    /**
     * 删除单个订单
     * @param orderinfo
     * @return
     */
    Integer deleteByOid(Orderinfo orderinfo);
    /**
     * 修改单个订单状态
     * @param orderinfo
     * @return
     */
    Integer deleteStateByOid(Orderinfo orderinfo);

    /**
     * 批量删除
     * @param
     * @return
     */
    Integer deleteAllByOid(List<String> a);

    /**
     * 批量退款
     * @param a
     * @return
     */
    Integer refundAll(List<String> a);

    /**
     * 按条件查询订单
     * @param use
     * @param page
     * @param limit
     * @param times
     * @param content
     * @return
     */
    List<Orderinfo> orderlistByCondition(Userinfo use, Integer page, Integer limit,
                                         String times, String content);
    /**
     * 按条件查询的总数
     * @param use
     * @param times
     * @param content
     * @return
     */
    Object countByCondition(Userinfo use, String times, String content);
//邱思琪部分

    /**
     * 分页查询显示所有订单数据
     * @param
     * @param
     * @return
     */


    PageInfo<OrmanaViewbean> showOrders(Integer page, Integer pageSize, String time, String content, String uid, String uoid);

    /**
     * 通过Oid数组删除订单详情表信息
     * @param oids
     * @return
     */
    int deleteOrdersByoids(String[] oids);
    /**
     * 单行删除订单管理信息
     * @param oid
     * @return
     */
    int deleteOrdersByoid(String oid);
    /**
     * 批量同意生产方法
     * @param oids
     * @return
     */
    int agreeproducByoids(String[] oids);
    /**
     * 批量同意退款
     * @param oids
     * @return
     */
    int agreerefundByoids(String[] oids);
    //邱思琪部分
    /**
     * 查询手机型号及模具图片
     * @return
     */
    List<Kind> searchPhoneModel();
    /**
     * 加入购物车
     * @param info
     * @return
     */
    int addCrat(Excleinfo info);
    /**
     * 查询购物车信息
     * @param uid 用户id
     * @param extype 插入类型
     * @return
     */
    List<Excleinfo> searchCart(Integer startRow,Integer limit,Integer uid,Integer extype);

    /**
     * 购物车总行数
     * @param uid
     * @param extype
     * @return
     */
    long countCart(Integer uid,Integer extype);

    /**
     * 删除选定行
     * @param
     */
    int deleteUser(Integer exid);

    /**
     * 生成订单
     * @param a
     * @param
     * @param
     * @return
     */
    int addOrder(List<Integer> a, Userinfo info);

    /**
     * 批量插入excel表
     * @param excleinfos
     * @return
     */
    int insertExcel(List<Excleinfo> excleinfos);
    Orderinfo selectceshi();
}
