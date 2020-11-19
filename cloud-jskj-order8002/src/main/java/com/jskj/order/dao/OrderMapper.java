package com.jskj.order.dao;

import com.jskj.entities.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

/**
 * @author lintao
 */
@Mapper
public interface OrderMapper {
    //QSQ部分开始
    /**
     * 通过时间或者发件人查询订单管理的所有状态为可见的订单
     *
     */
    List<OrmanaViewbean> findAllOrder(@Param(value="time") String time, @Param(value="stime") String stime, @Param(value="etime")String etime, @Param(value="content")String content, @Param(value="uid")String uid, @Param(value="uoid")String uoid);



    /**
     * 批量删除订单管理信息
     * @param oids 订单编号oid的数组
     * @return
     */
    @Update("<script>update orderinfo set odelete=2 where oid in <foreach collection='array' item='id' open='(' separator=',' close=')'> #{id}</foreach></script>")
    int deleteOrdersByoids(String[] oids);

    /**
     * 单行删除订单管理信息
     * @param oid
     * @return
     */
    @Update("update orderinfo set odelete=2 where oid=#{id};")
    int deleteOrdersByoid(String oid);
    /**
     * 批量同意生产方法
     * @param oids
     * @return
     */
    @Update("<script><foreach collection='array' item='id'>"
            + "update orderinfo set ostate=1 "
            + "where oid=#{id};</foreach></script>")
    int agreeproducByoids(String[] oids);
    /**
     * 批量同意退款
     * @param oids
     * @return
     */
    @Update("<script><foreach collection='array' item='id'>"
            + "update orderinfo set ostate=3 "
            + "where oid=#{id};</foreach></script>")
    int agreerefundByoids(String[] oids);
//QSQ部分结束

//CN部分开始

//CN部分结束

//LT部分开始
    /**
     * 查询手机型号及模具图片
     * @return
     */
    @Select("SELECT * FROM kind")
    @Results({
            @Result(id=true,column="kid",property="kid"),
            @Result(column="kname",property="kname"),
            @Result(column="kid",property="kid"),
            @Result(column="kid",property="brands",many=@Many(select="com.jskj.order.dao.OrderMapper.selectBrandsAndPhoneinfosbyKid"))
    })
    List<Kind> selectKindAndBrands();
    @Select("select * from brand where kid = #{value}")
    @Results({
            @Result(id=true,column="bid",property="bid"),
            @Result(column="pbrand",property="pbrand"),
            @Result(column="kid",property="kid"),
            @Result(column="bid",property="phoneInfos",many=@Many(select="com.jskj.order.dao.OrderMapper.selectPhoneinfosbyBid"))
    })
    List<Brand> selectBrandsAndPhoneinfosbyKid(Integer kid);
    @Select("select * from phoneinfo where Bid = #{value}")
    List<Phoneinfo> selectPhoneinfosbyBid(Integer bid);

    /**
     * 加入购物车
     */
    @Insert("insert into excleinfo (Uid,Osale,Oremark,Pnnumber,Pid,Connumber,Lame,Ladress,Photosrc,slingnumber,holdernumber,Extype) values(#{uid},#{osale},#{oremark},#{pnnumber},#{pid},#{connumber},#{lame},#{ladress},#{photosrc},#{slingnumber},#{holdernumber},#{extype})")
    int insertCart(Excleinfo info);

    /**
     * 查看购物车信息(分页)
     *
     */
    @Select("select excleinfo.*,phoneinfo.Pmodel from excleinfo left join phoneinfo on excleinfo.pid = phoneinfo.pid  where uid=#{arg2} and extype=#{arg3} limit #{arg0},#{arg1}")
    List<Excleinfo> selectCart(Integer startRow,Integer limit,Integer uid, Integer extype);

    /**
     * 查看购物车信息
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @Select("<script>select * from excleinfo where exid in"
            + "<if test='orderStatus != null'>"
            + "<foreach item='status' index='index' collection='orderStatus' open='(' separator=',' close=')'>"
            + "#{status} "
            + "</foreach>"
            + "</if>"
            + "</script>")
    List<Excleinfo> selectCarts(@Param(value="orderStatus")List<Integer> lids);
    /**
     * 查询行数
     */
    @Select("select count(*) from excleinfo where uid=#{arg0} and extype=#{arg1}")
    long countCart(Integer uid,Integer extype);

    /*
     * 删除购物车选定行
     */
    @Delete("DELETE FROM excleinfo WHERE Exid = #{arg0}")
    int deleteUser(Integer exid);

    /**
     * 查询用户是否存在
     * @param uno
     * @param pwd
     * @return
     */
    @Select("select * from userinfo where Uno=#{arg0} and Upwd = #{arg1}")
    Userinfo selectUser(String uno, String pwd);

    @Insert("insert into orderinfo (Oid, Uid,Osale,Ostate,Odelete) values (#{oid},#{uid},#{osale},#{ostate},#{odelete})")
    int insertOrder(Orderinfo order);

    /**存储过程
     * 插入图片
     * @param photosrc
     * @param photoname
     * @return
     */
    @Select({"call selectphotoid(#{arg0},#{arg1})"})
    @Options(statementType= StatementType.CALLABLE)
    int insertPhoto(String photosrc,String photoname);

    /**
     * 插入电话号码
     * @param phone
     * @return
     */
    @Select({"call selectContactid(#{arg0})"})
    @Options(statementType=StatementType.CALLABLE)
    int insertContact(String phone);

    /**
     * 插入物流信息
     * @param
     * @return
     */
    @Select({"CALL selectlid(#{lame},#{ladress},#{oid},#{contactid},#{ldelete});"})
    @Options(statementType=StatementType.CALLABLE)
    int insertLogisticsinfo(Logisticsinfo logisticsinfo);

    /**
     * 插入订单详情
     * @param orderdetails
     * @return
     */
    @Select("CALL selectOrderdetailsid(#{pid},#{oid},#{lid},#{pnnumber},#{oremark},#{contactid},#{photoid},#{uid})")
    @Options(statementType=StatementType.CALLABLE)
    int insertOrderdetails(Orderdetails orderdetails);

    /**
     * 清空购物车
     * @param lids
     * @return
     */
    @Update("<script>DELETE from excleinfo where Exid in "
            +"<if test='orderStatus != null'>"
            + "<foreach item='status' index='index' collection='orderStatus' open='(' separator=',' close=')'>"
            + "#{status} "
            + "</foreach>"
            + "</if>"
            + "</script>")
    int delete(@Param(value="orderStatus")List<Integer> lids);

    /**
     * 插入赠品表
     * @return
     */
    @Insert("insert into complimentary (slingnumber,holdernumber,Odid) VALUES (#{slingnumber},#{holdernumber},#{Odid})")
    int insertComplimentary(Complimentary complimentary);

    /**
     * 批量插入excel表数据
     * @return
     */
    @Insert("<script>insert into excleinfo (uid,osale,Oremark,Pnnumber,linephone,Connumber,Lame,Ladress,Tbid,Extype) VALUES "
            +"<if test='orderStatus != null'>"
            + "<foreach item='status' index='index' collection='orderStatus' separator=','>"
            + "(#{status.uid},#{status.osale},#{status.oremark},#{status.pnnumber},#{status.linephone},#{status.connumber},#{status.lame},#{status.ladress},#{status.tbid},2)"
            + "</foreach>"
            + "</if>"
            + "</script>")
    int insertExcel(@Param(value = "orderStatus") List<Excleinfo> excleinfos);

    @Select("select * from orderinfo,logisticsinfo,contact where orderinfo.Oid = logisticsinfo.Oid and logisticsinfo.Contactid = contact.Contactid and\n" +
            "uid = #{arg0} AND odelete=1  LIMIT #{arg1},#{arg2}")
    List<OrderListSeach> orderlist(Integer uid,Integer startRow,Integer limit);

    @Select("select count(*) from orderinfo where uid = #{uid} AND odelete=1  ")
    Object count(Userinfo order);

    @Update("UPDATE  orderinfo set odelete=2 where oid=#{oid}")
    Integer deleteByOid(Orderinfo orderinfo);

    @Update("UPDATE  orderinfo set ostate=2 where oid=#{oid}")
    Integer deleteStateByOid(Orderinfo orderinfo);

    /**
     * 批量删除
     * @param
     * @return
     */
    @UpdateProvider(type = Provider.class, method = "updateAll")
    Integer deleteAllByOid(List<String> ids);
    /**
     * 批量退款
     * @param
     * @return
     */
    @UpdateProvider(type = Provider.class, method = "refundAll")
    Integer refundAll(List<String> a);
    /**
     * 按订单编号查找
     */
    @Select("select * from orderinfo where uid = #{arg0} AND oid=#{arg3} AND odelete=1 LIMIT #{arg1},#{arg2}")
    List<Orderinfo> orderByConditionidnotime(int uid, int i, Integer limit,String content);
    @Select("select count(*) from orderinfo where uid = #{arg0} AND oid=#{arg1} AND odelete=1")
    Object orderBycountidnotime(int uid, String content);
    /**
     * 按收件人姓名查找
     */
    @Select("select * from orderinfo where uid = #{arg0} AND lame like #{arg3} AND odelete=1  LIMIT #{arg1},#{arg2}")
    List<Orderinfo> orderByConditionnamenotime(int uid, int i, Integer limit,
                                               String content);
    @Select("select count(*) from orderinfo where uid = #{arg0} AND lame like #{arg1} AND odelete=1 ")
    Object orderBycounnamenotime(int uid, String content);
    /**
     * 按照编号和时间来查
     */
    @Select("select * from orderinfo where uid = #{arg0} AND oid=#{arg5} AND odelete=1"
            + " AND odate between #{arg3} and #{arg4} LIMIT #{arg1},#{arg2}")
    List<Orderinfo> orderlistByConditionid(int uid, int i, Integer limit,
                                           String string, String string2, String content);
    @Select("select count(*)  from orderinfo where uid = #{arg0} AND oid=#{arg3} AND odelete=1"
            + " AND odate between #{arg1} and #{arg2}")
    Object orderlistBycountid(int uid, String string, String string2,
                              String content);
    /**
     * 按照时间和收件人来查
     */
    @Select("select * from orderinfo where uid = #{arg0} AND lame like #{arg3} AND odelete=1"
            + " AND odate between #{arg4} and #{arg5} LIMIT #{arg1},#{arg2}")
    List<Orderinfo> orderlistByConditionname(int uid, int i, Integer limit,
                                             String content, String string, String string2);
    @Select("select count(*) from orderinfo where uid = #{arg0} AND lame like #{arg1} AND odelete=1"
            + " AND odate between #{arg2} and #{arg3} ")
    Object orderlistBycountname(int uid, String content, String string,
                                String string2);


    class Provider {
        /* 批量删除 */
        public String updateAll(Map map) {
            List<String> ids = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE  orderinfo set odelete=2 where oid in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }

        /* 批量退款 */
        public String refundAll(Map map) {
            List<String> ids = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE  orderinfo set ostate=2 where oid in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();

        }
    }
    @Select("select * from orderinfo where Oid = 20190705031957916")
    Orderinfo selectceshi();

}
