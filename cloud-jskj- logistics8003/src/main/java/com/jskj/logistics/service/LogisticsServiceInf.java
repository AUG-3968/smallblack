package com.jskj.logistics.service;

import com.jskj.entities.LogisticsAndContactAndOrderinfoAndOrderdetails;
import com.jskj.entities.LogisticsAndOrderdetailsAndContact;

import java.util.List;

/**
 * @author lintao
 */
public interface LogisticsServiceInf {
    /**
     * 物流信息的查询
     * @param startRow
     * @param limit
     * @return
     */
    List<LogisticsAndContactAndOrderinfoAndOrderdetails> findlogistics(Integer startRow, Integer limit, String time, String content, Integer uid);

    /**
     * 上面的查询语句的count
     * @return
     */
    Long countUser();

    /**
     * 物流信息页面的假删
     * @param oid
     * @return
     */
    Integer updateLogistics(String oid);

    /**
     * 批量删除物流信息
     * @param oids 物流id的数组
     * @return
     */
    int deleteLogisticsByOid(String[] oids);

    //陈妮部分
    List<LogisticsAndOrderdetailsAndContact> findAllLogistics(Integer page, Integer limit);

    Long countlogistics();

    int deleteLogisticsByLid(Integer[] lids);

    int deleteLogistics(Integer lids);

    int insertDatas(List<LogisticsAndOrderdetailsAndContact> loclist);

    List<LogisticsAndOrderdetailsAndContact> findNo(Integer page,
                                                    Integer limit);

    Long countByNo();

    List<LogisticsAndOrderdetailsAndContact> findYes(Integer page, Integer limit);

    Long countByYes();
    //陈妮部分
}
