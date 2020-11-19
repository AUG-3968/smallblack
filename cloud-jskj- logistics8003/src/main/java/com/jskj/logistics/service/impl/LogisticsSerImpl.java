package com.jskj.logistics.service.impl;

import com.jskj.entities.LogisticsAndContactAndOrderinfoAndOrderdetails;
import com.jskj.entities.LogisticsAndOrderdetailsAndContact;
import com.jskj.logistics.dao.LogisticsMapper;
import com.jskj.logistics.service.LogisticsServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lintao
 */
@Service
public class LogisticsSerImpl implements LogisticsServiceInf {
    @Autowired
    private LogisticsMapper logisticsMapper;

    /**
     * 物流信息的查询
     */
    public List<LogisticsAndContactAndOrderinfoAndOrderdetails> findlogistics(Integer page, Integer limit, String time, String content, Integer uid) {
        String etime = "";
        String stime = "";
        if(time != "" && time != null) {
            String[] split = time.split("到");
            stime = split[0].trim();
            etime = split[1].trim();
        }
        System.out.println(stime+";"+etime+"`````");
        if(content != null && content != ""){
            content = "%"+content+"%";
        }else {
            content = "";
        }
        return logisticsMapper.findlogistics((page-1)*limit,limit,time,stime,etime,content,uid);
    }

    /**
     * 物流信息查询语句的总数
     */
    public Long countUser() {
        return logisticsMapper.countLogistics();
    }

    /**
     * 单条数据的页面假删
     */
    public Integer updateLogistics(String oid) {
        return logisticsMapper.updateLogistics(oid);
    }

    /**
     * 批量删除的页面假删
     */
    public int deleteLogisticsByOid(String[] oids) {
        return logisticsMapper.deleteLogisticsByOid(oids);
    }

    //陈妮部分
    @Override
    public List<LogisticsAndOrderdetailsAndContact> findAllLogistics(Integer page, Integer limit) {
        System.out.println();
        return logisticsMapper.findAllLogistics((page-1)*limit,limit);
    }
    @Override
    public Long countlogistics() {
        return logisticsMapper.countlogistics();
    }
    @Override
    public int deleteLogisticsByLid(Integer[] lids) {
        return logisticsMapper.deleteLogisticsByLid(lids);
    }
    @Override
    public int deleteLogistics(Integer lid) {
        return logisticsMapper.deleteLogistics(lid);
    }
    @Override
    public int insertDatas(List<LogisticsAndOrderdetailsAndContact> loclist) {
        return logisticsMapper.insertDatas(loclist);
    }
    @Override
    public List<LogisticsAndOrderdetailsAndContact> findNo(Integer page,Integer limit) {
        return logisticsMapper.findNo((page-1)*limit, limit);
    }
    @Override
    public Long countByNo() {
        return logisticsMapper.countByNo();
    }
    @Override
    public List<LogisticsAndOrderdetailsAndContact> findYes(Integer page,
                                                            Integer limit) {
        return logisticsMapper.findYes((page-1)*limit, limit);
    }
    @Override
    public Long countByYes() {
        return logisticsMapper.countByYes();
    }
    //陈妮部分

}
