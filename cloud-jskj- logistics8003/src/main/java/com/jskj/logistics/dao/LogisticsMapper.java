package com.jskj.logistics.dao;

import com.jskj.entities.LogisticsAndContactAndOrderinfoAndOrderdetails;
import com.jskj.entities.LogisticsAndOrderdetailsAndContact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lintao
 */
@Mapper
public interface LogisticsMapper {
    //物流信息查询模块开始
    //物流信息查询模块开始
    /**
     * 1.物流信息查询
     * @param
     * @return
     */
    List <LogisticsAndContactAndOrderinfoAndOrderdetails> findlogistics(Integer page, Integer limit, @Param(value="time") String time, @Param(value="stime") String stime, @Param(value="etime") String etime, @Param(value="content") String content, @Param(value="uid")Integer uid);
    //物流信息查询模块结束
    //查询上面这个查询语句的总行数
    @Select("SELECT COUNT(*) FROM logisticsinfo")
    Long countLogistics();

    /**
     * 物流信息页面假删模块开始
     * @param oid
     * @return
     */
    //物流信息页面假删模块开始
    @Update("UPDATE logisticsinfo SET Ldelete=2 WHERE oid=#{oid}")
    Integer updateLogistics(String oid);
    //物流信息页面假删模块结束

    /**
     * 批量删除物流信息
     * @param oids 物流id的数组
     * @return
     */
    @Update("<script><foreach collection='array' item='id'>"
            + "update logisticsinfo set ldelete=2 "
            + "where oid=#{id};</foreach></script>")
    int deleteLogisticsByOid(String[] oids);
//后台管理
    /**
     * 查询所有可见的物流详情
     */
    @Select("<script>SELECT DISTINCT l.*,tbid,conway,connumber FROM logisticsinfo l "
            + "LEFT JOIN orderdetails od ON l.lid = od.lid LEFT JOIN contact c "
            + "ON c.Contactid=l.Contactid WHERE Ldelete=1 LIMIT #{arg0},#{arg1}</script>")
    List<LogisticsAndOrderdetailsAndContact> findAllLogistics(Integer startRow,
                                                              Integer limit);
    /**
     * 查询上述查询出来的数据条数
     * @return
     */
    @Select("SELECT DISTINCT COUNT(lid) FROM logisticsinfo WHERE Ldelete=1")
    Long countlogistics();
    /**
     * 批量删除物流信息
     * @param lids 物流id的数组
     * @return
     */
    @Update("<script><foreach collection='array' item='id'>"
            + "update logisticsinfo set ldelete=2 "
            + "where lid=#{id};</foreach></script>")
    int deleteLogisticsByLid(Integer[] lids);
    /**
     * 删除物流信息
     * @param lid 物流id的数组
     * @return
     */
    @Update("update logisticsinfo set ldelete=2 where lid=#{arg0}")
    int deleteLogistics(Integer lid);
    /**
     * 根据淘宝订单号 批量插入物流数据（快递公司、快递单号）
     * @param loclist 要插入的数据的集合
     */
    @Update("<script><foreach collection='list' item='logistics'>"
            + "update logisticsinfo set lorder=#{logistics.lorder},lcompany=#{logistics.lcompany} "
            + "where oid=#{logistics.tbid};</foreach></script>")
    int insertDatas(List<LogisticsAndOrderdetailsAndContact> loclist);
    /**
     * 查询所有可见的并且没有物流信息的物流详情
     */
    @Select("SELECT DISTINCT l.*,tbid,conway,connumber FROM logisticsinfo l "
            + "LEFT JOIN orderdetails od ON l.lid = od.lid LEFT JOIN contact c "
            + "ON c.Contactid=l.Contactid WHERE Ldelete=1 and Lorder IS NULL OR Lorder ='' LIMIT #{arg0},#{arg1}")
    List<LogisticsAndOrderdetailsAndContact> findNo(int i, Integer limit);
    /**
     * 查询上述查询出来的数据条数
     * @return
     */
    @Select("SELECT DISTINCT COUNT(lid) FROM logisticsinfo where Ldelete=1 and Lorder IS NULL OR Lorder =''")
    Long countByNo();
    /**
     * 查询所有可见的并且有物流信息的物流详情
     */
    @Select("SELECT DISTINCT l.*,tbid,conway,connumber FROM logisticsinfo l "
            + "LEFT JOIN orderdetails od ON l.lid = od.lid LEFT JOIN contact c "
            + "ON c.Contactid=l.Contactid WHERE Ldelete=1 and Lorder IS NOT NULL AND Lorder <>'' LIMIT #{arg0},#{arg1}")
    List<LogisticsAndOrderdetailsAndContact> findYes(int i, Integer limit);
    @Select("SELECT DISTINCT COUNT(lid) FROM logisticsinfo where Ldelete=1 and Lorder IS NOT NULL AND Lorder <>''")
    Long countByYes();

}
